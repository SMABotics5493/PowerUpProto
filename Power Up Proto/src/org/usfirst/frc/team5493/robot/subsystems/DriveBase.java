package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.RobotMap;
import org.usfirst.frc.team5493.robot.commands.JoystickDrive;

import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveBase extends Subsystem {
	double wheelDiameter = 6.0;

	double pulsesPerRevolution = 1440.0;
	double averageDistance;
	WPI_TalonSRX leftBackMotor;
	WPI_TalonSRX rightBackMotor;;
	WPI_TalonSRX rightFrontMotor;
	WPI_TalonSRX leftFrontMotor;

	WPI_TalonSRX[] encoderTalons;
	WPI_TalonSRX[] allTalons;

	private RobotDrive drive;
	private Encoder leftEncoder, rightEncoder;
	private final String DRIVE_SYSTEM = "Tank Drive System";
	private final String LEFT_FRONT = "Left Front Motor";

	private final int kPIDLoopIdx = 0;
	private final int kTimeoutMs = 0;

	public DriveBase() {
		super();

		leftFrontMotor = new WPI_TalonSRX(RobotMap.LEFT_FRONT);
		leftBackMotor = new WPI_TalonSRX(RobotMap.LEFT_BACK);
		rightFrontMotor = new WPI_TalonSRX(RobotMap.RIGHT_FRONT);
		rightBackMotor = new WPI_TalonSRX(RobotMap.RIGHT_BACK);

		// leftFrontMotor = new WPI_TalonSRX(0);
		// rightFrontMotor = new WPI_TalonSRX(1);

		leftFrontMotor.set(ControlMode.Follower, RobotMap.LEFT_BACK);
		rightFrontMotor.set(ControlMode.Follower, RobotMap.RIGHT_BACK);

		encoderTalons = new WPI_TalonSRX[2];
		encoderTalons[0] = leftBackMotor;
		// encoderTalons[RobotMap.LEFT_BACK] = leftBackMotor;
		encoderTalons[1] = rightBackMotor;
		// encoderTalons[RobotMap.RIGHT_BACK] = rightBackMotor;

		this.initializeTalonsForEncoder();

		allTalons = new WPI_TalonSRX[4];
		allTalons[0] = leftBackMotor;
		allTalons[1] = leftFrontMotor;
		allTalons[2] = rightBackMotor;
		allTalons[3] = rightFrontMotor;

		drive = new RobotDrive(leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor);
		// drive = new RobotDrive(leftFrontMotor, rightFrontMotor);
		drive.setExpiration(0.1);

		double secondsFromNeutral = 0;
		int timeoutMs = 0;

		Preferences prefs = Preferences.getInstance();

		secondsFromNeutral = prefs.getDouble("RampRateDriveBase", 0.25);
		timeoutMs = prefs.getInt("RampRateDriveBaseTimeout", 1);

		// leftFrontMotor.configOpenloopRamp(secondsFromNeutral, timeoutMs);
		// rightFrontMotor.configOpenloopRamp(secondsFromNeutral, timeoutMs);
		// leftBackMotor.configOpenloopRamp(secondsFromNeutral, timeoutMs);
		// rightBackMotor.configOpenloopRamp(secondsFromNeutral, timeoutMs);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive());
	}

	public void drive(Joystick j) {

		drive(j.getRawAxis(RobotMap.LEFTYAXIS), j.getRawAxis(RobotMap.RIGHTYAXIS));

		// leftStatus = ((TalonSRX)
		// leftBackMotor).getSensorCollection().getPulseWidthRiseToRiseUs();
		// rightStatus = ((TalonSRX)
		// rightBackMotor).getSensorCollection().getPulseWidthRiseToRiseUs();
		//
		// if (leftStatus == 0 && rightStatus == 0) {
		// DriverStation.reportWarning("lb aft Sensor Not Present", false);
		// } else {
		// DriverStation.reportWarning("lb aft Sensor Present", false);
		//
		// }
	}

	public void drive(double left, double right) {
		drive.tankDrive(left, right);
	}

	public void driveHeading(double direction, double arc) {
		drive.setSafetyEnabled(false);
		// drive.tankDrive(-.6, -.6);
		drive.drive(direction, arc);
		drive.setSafetyEnabled(true);
		DriverStation.getInstance().reportWarning("Drive Heading", true);
	}

	private void initializeTalonsForEncoder() {
		for (int talIdx = 0; talIdx < encoderTalons.length; talIdx++) {

			TalonSRX talon = (TalonSRX) encoderTalons[talIdx];

			ErrorCode lcode = (talon).configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, kPIDLoopIdx, kTimeoutMs);

			if (lcode == ErrorCode.OK) {
				DriverStation.reportWarning(talon.getDeviceID() + " Encoder Quad Sensor Okay", false);
			}

			// /* choose to ensure sensor is positive when output is positive */
			// talon.setSensorPhase(Constants.kSensorPhase);
			//
			// /* choose based on what direction you want forward/positive to
			// be.
			// * This does not affect sensor phase. */
			// talon.setInverted(Constants.kMotorInvert);

			/* set the peak and nominal outputs, 12V means full */
			talon.configNominalOutputForward(0, kTimeoutMs);
			talon.configNominalOutputReverse(0, kTimeoutMs);
			talon.configPeakOutputForward(.1, kTimeoutMs);
			talon.configPeakOutputReverse(-.1, kTimeoutMs);
			/*
			 * set the allowable closed-loop error, Closed-Loop output will be
			 * neutral within this range. See Table in Section 17.2.1 for native
			 * units per rotation.
			 */
			talon.configAllowableClosedloopError(0, kPIDLoopIdx, kTimeoutMs);

			/* set closed loop gains in slot0, typically kF stays zero. */
			talon.config_kF(kPIDLoopIdx, 0.0, kTimeoutMs);
			talon.config_kP(kPIDLoopIdx, 0.1, kTimeoutMs);
			talon.config_kI(kPIDLoopIdx, 0.0, kTimeoutMs);
			talon.config_kD(kPIDLoopIdx, 0.0, kTimeoutMs);

		}
		resetEncoder();
	}

	public void resetEncoder() {
		for (int talIdx = 0; talIdx < encoderTalons.length; talIdx++) {

			TalonSRX talon = (TalonSRX) encoderTalons[talIdx];
			/*
			 * lets grab the 360 degree position of the MagEncoder's absolute
			 * position, and intitally set the relative sensor to match.
			 */
			int absolutePosition = talon.getSensorCollection().getPulseWidthPosition();
			/* mask out overflows, keep bottom 12 bits */
			absolutePosition &= 0xFFF;
			// if (Constants.kSensorPhase)
			// absolutePosition *= -1;
			// if (Constants.kMotorInvert)
			// absolutePosition *= -1;
			/* set the quadrature (relative) sensor to match absolute */
			talon.setSelectedSensorPosition(absolutePosition, kPIDLoopIdx, kTimeoutMs);
		}
	}

	public void log() {
		//SmartDashboard.putNumber("Left Distance", this.leftEncoder.get());
		//SmartDashboard.putNumber("Right Distance", this.rightEncoder.get());
	}

	public void reset() {
		drive(0.0, 0.0);
	}

	public void drivePosition(double targetPositionRotations) {

		for (int talIdx = 0; talIdx < allTalons.length; talIdx++) {

			TalonSRX talon = (TalonSRX) allTalons[talIdx];
			talon.set(ControlMode.Position, targetPositionRotations);

			DriverStation.reportWarning("Set talon " + talIdx, false);
		}

	}

	public double getEncoderPosition() {
		double total = 0;
		for (int talIdx = 0; talIdx < encoderTalons.length; talIdx++) {

			TalonSRX talon = (TalonSRX) encoderTalons[talIdx];
			total += talon.getSelectedSensorPosition(kPIDLoopIdx);
		}

		return total / encoderTalons.length;
	}

}
