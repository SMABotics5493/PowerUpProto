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

public class DriveBase extends Subsystem {
	double wheelDiameter = 6.0;

	double pulsesPerRevolution = 1440.0;
	double averageDistance;
	WPI_TalonSRX leftBackMotor;
	WPI_TalonSRX rightBackMotor;;
	WPI_TalonSRX rightFrontMotor;
	WPI_TalonSRX leftFrontMotor;
	private RobotDrive drive;
	private Encoder leftEncoder, rightEncoder;
	private final String DRIVE_SYSTEM = "Tank Drive System";
	private final String LEFT_FRONT = "Left Front Motor";

	public DriveBase() {
		super();

		// TODO: This should be set back... the other code (lines 42 and 43 was test
		// code)
		// TODO: make sure to look at the ReferenceDocuments/Talon SRX Victor SPX -
		// Software Reference Manual.pdf
		// Section 7.6. Multiple Talon SRXs and single sensor
		// FAILURE TO DO SO MAY BURN OUT THE MOTORS!!!!!

		leftFrontMotor = new WPI_TalonSRX(RobotMap.LEFT_FRONT);
		leftBackMotor = new WPI_TalonSRX(RobotMap.LEFT_BACK);
		rightFrontMotor = new WPI_TalonSRX(RobotMap.RIGHT_FRONT);
		rightBackMotor = new WPI_TalonSRX(RobotMap.RIGHT_BACK);

		// leftFrontMotor = new WPI_TalonSRX(0);
		// rightFrontMotor = new WPI_TalonSRX(1);

		leftBackMotor.set(ControlMode.Follower, RobotMap.LEFT_FRONT);
		rightBackMotor.set(ControlMode.Follower, RobotMap.RIGHT_FRONT);

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

		// TODO: Look at the manual for "Follower" to see if we need to set the open
		// loop ramp on the followers.
		leftBackMotor.configOpenloopRamp(secondsFromNeutral, timeoutMs);
		rightBackMotor.configOpenloopRamp(secondsFromNeutral, timeoutMs);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive());
	}

	public void drive(Joystick j) {

		drive(j.getRawAxis(RobotMap.LEFTYAXIS), j.getRawAxis(RobotMap.RIGHTYAXIS));

	}

	public void drive(double left, double right) {
		drive.tankDrive(left, right);
	}

	public void drive(double left, double right, double arc, double distance) {
		// TODO: make call with drive based on left, right speeds, arc (heading on
		// gyro), and distance (using encoders)
		// TODO: Probably better/best to have the encoder as a field on DriveBase and
		// expose a method on drive base that returns the distance travelled to the
		// caller and let the caller (aka drive distance command) determine if it has
		// driven to expectations or not. In that case, this drive method probably
		// becomes obsolete.

		// TODO: if other TODO is done this code becomes not needed (just use drive
		// (with speeds)).
		// TODO: see above, but then if it is needed would need to determine logic to
		// use the arc and distance to know when it has travelled far enough and on the
		// heading/arc desired. Would have to add the calls to set the arc and figure
		// out dicstance here.

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

	public double[] distanceTraveled() {
		// TODO: This would be where the encoder logic would go to determine how far it
		// has traveled.
		// Things to consider 1. How will we reset distances between calls?
		// 2. How will we ensure distances aren't reset until the previous command is
		// done?
		// 3. Will distance traveled only be allowed in autonomous?
		// 4. How will we track distances between calls? I.e. pass it in as a parameter?
		// Field on driveBase that gets reset?
		
		// TODO: See ReferenceDocuments/Talon SRX Victor SPX - Software Reference Manual.pdf
		// Section 7 (See all subsections and pay attention to the quadrature instructions.

		double[] distances = new double[2];

		//TODO: replace the 0.0 with the actual calculated values!
		distances[RobotMap.EncoderDistances.DRIVE_BASE_LEFT] = 0.0; // Left distance traveled
		distances[RobotMap.EncoderDistances.DRIVE_BASE_RIGHT] = 0.0; // Right distance traveled

		return distances;
	}

	public void reset() {
		drive(0.0, 0.0);
	}
}
