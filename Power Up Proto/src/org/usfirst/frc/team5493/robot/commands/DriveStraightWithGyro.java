package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightWithGyro extends Command {

	double Kp = 0.03;
	private int _encoderPulses = 1440;
	private boolean isFinished = false;

	private double startingPosition;
	
	private boolean isStarted = false;

	public DriveStraightWithGyro() {
		// super(10);

		requires(Robot.driveBase);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.gyro.reset();
		isStarted = false;
		startingPosition = 0;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		distance(10);

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		DriverStation.reportWarning("finished? " + isFinished, false);
		return isFinished;
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

	protected void distance(double targetPositionRotations) {
		if (!isStarted) {
			startingPosition = Robot.driveBase.getEncoderPosition();


			double angle = Robot.gyro.getAngle();
			Robot.driveBase.driveHeading(0.23, -angle*Kp);

			isStarted = true;
			DriverStation.reportWarning("distance", false);
			// _talon.set(ControlMode.Position, targetPositionRotations);
		} else {
			DriverStation.reportWarning("waiting", false);
			double current = Robot.driveBase.getEncoderPosition();
			DriverStation.reportWarning("waiting start " + startingPosition, false);
			DriverStation.reportWarning("waiting curre " + current, false);
			
			isFinished = current - startingPosition > targetPositionRotations * _encoderPulses;
			DriverStation.reportWarning("waiting finished? " + isFinished, false);
			double angle = Robot.gyro.getAngle();
			Robot.driveBase.driveHeading(0.23, -angle*Kp);
		}
	}
}
