package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightWithGyro extends Command {

	private static final double UNITS = 3;
	double Kp = 0.03;
	private int _encoderPulses = 1440;
	private boolean isFinished = false;

	private double startingPosition;

	private boolean isStarted = false;
	private double _direction;
	private double _distance;
	private double _speed;
	private double targetHeading;

	public DriveStraightWithGyro(double speed, double distance, double direction) {
		super(5);

		requires(Robot.driveBase);
		requires(Robot.throwDaggersInBensEyes);
		_distance = distance;
		_direction = direction;
		_speed = speed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.gyro.reset();
		isStarted = false;
		startingPosition = 0;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		distance();
		// 35 to turn 90 degrees

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		DriverStation.reportWarning("finished? " + isFinished, false);
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		DriverStation.reportWarning("end", false);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		DriverStation.reportWarning("interrupt", false);
	}

	protected void distance() {

		double currentHeading = Robot.gyro.getAngle();
		if (!isStarted) {
			// initialize();
			Robot.driveBase.resetEncoder();
			startingPosition = Robot.driveBase.getEncoderPosition();
			
//			Robot.throwDaggersInBensEyes.reverse(null);

			isStarted = true;
			targetHeading = currentHeading + _direction;

		} else {

			double current = Robot.driveBase.getEncoderPosition();
			DriverStation.reportWarning("waiting start " + startingPosition, false);
			DriverStation.reportWarning("waiting curre " + current, false);

			isFinished = Math.abs(current) - Math.abs(startingPosition) > _distance;// UNITS;
			DriverStation.reportWarning("waiting finished? " + isFinished, false);
		}

		double setHeading = -currentHeading * UNITS;
		if (_direction != 0) {
			setHeading = targetHeading;
		}

		Robot.driveBase.driveHeading(_speed, setHeading);

	}
}
