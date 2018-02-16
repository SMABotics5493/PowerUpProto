package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.RobotMap;
import org.usfirst.frc.team5493.robot.commands.JoystickDrive;

import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveBase extends Subsystem {
	double wheelDiameter = 6.0;

	double pulsesPerRevolution = 1440.0;
	double averageDistance;
	// WPI_TalonSRX leftBackMotor;
	// WPI_TalonSRX rightBackMotor;;
	WPI_TalonSRX rightFrontMotor;
	WPI_TalonSRX leftFrontMotor;
	private RobotDrive drive;
	private Encoder leftEncoder, rightEncoder;
	private final String DRIVE_SYSTEM = "Tank Drive System";
	private final String LEFT_FRONT = "Left Front Motor";

	public DriveBase() {
		super();

		// leftFrontMotor = new WPI_TalonSRX(RobotMap.LEFT_FRONT);
		// leftBackMotor = new WPI_TalonSRX(RobotMap.LEFT_BACK);
		// rightFrontMotor = new WPI_TalonSRX(RobotMap.RIGHT_FRONT);
		// rightBackMotor = new WPI_TalonSRX(RobotMap.RIGHT_BACK);

		leftFrontMotor = new WPI_TalonSRX(0);
		rightFrontMotor = new WPI_TalonSRX(1);

		// leftBackMotor.set(ControlMode.Follower, RobotMap.LEFT_FRONT);
		// rightBackMotor.set(ControlMode.Follower, RobotMap.RIGHT_FRONT);

		ErrorCode lcode = ((TalonSRX) leftFrontMotor).configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 1);
		
		if (lcode == ErrorCode.OK) {
			DriverStation.reportWarning("Left Encoder Quad Sensor Okay", false);
		}
		
		ErrorCode rcode = ((TalonSRX) rightFrontMotor).configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 1);

		if (rcode == ErrorCode.OK) {
			DriverStation.reportWarning("Right Encoder Quad Sensor Okay", false);
		}

		// drive = new RobotDrive(leftFrontMotor, leftBackMotor, rightFrontMotor,
		// rightBackMotor);
		drive = new RobotDrive(leftFrontMotor, rightFrontMotor);
		drive.setExpiration(0.1);

		double secondsFromNeutral = 0;
		int timeoutMs = 0;

		Preferences prefs = Preferences.getInstance();

		secondsFromNeutral = prefs.getDouble("RampRateDriveBase", 0.25);
		timeoutMs = prefs.getInt("RampRateDriveBaseTimeout", 1);

		leftFrontMotor.configOpenloopRamp(secondsFromNeutral, timeoutMs);
		rightFrontMotor.configOpenloopRamp(secondsFromNeutral, timeoutMs);
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

	public void log() {
		// SmartDashboard.putNumber("Left Distance", this.leftEncoder.get());
		// SmartDashboard.putNumber("Right Distance", this.rightEncoder.get());
	}

	public void reset() {
		drive(0.0, 0.0);
	}
}
