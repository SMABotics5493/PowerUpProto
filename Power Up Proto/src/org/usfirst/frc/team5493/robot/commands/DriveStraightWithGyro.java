package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;
import org.usfirst.frc.team5493.robot.subsystems.DriveBase;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveStraightWithGyro extends Command {

	private static final double UNITS = 3;
	double Kp = 0.03;
	private boolean isFinished = false;

	private double startingPosition;

	private boolean isStarted = false;
	private double _direction;
	private double _distance;
	private double _speed;
	private double targetHeading;

	public DriveStraightWithGyro(double speed, double distance, double direction) {
		requires(Robot.driveBase);
		requires(Robot.throwDaggersInBensEyes);
		_distance = DriveBase.inchesToRotations(distance);
		_direction = direction;
		_speed = speed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.gyro.reset();
		isStarted = false;
		startingPosition = 0;
		isFinished = false;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		distance();
		// 35 to turn 90 degrees

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		DriverStation.reportWarning("finished? " + isFinished, false);
		return isFinished;
	}

	// Called once after isFinished returns true
	protected void end() {
		DriverStation.reportWarning("end", false);
		Robot.driveBase.reset();
		isStarted = false;
		isFinished = true;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		DriverStation.reportWarning("interrupt", false);
	}

	protected void distance() {

		double traveled = 0;
		double currentHeading = Robot.gyro.getAngle();
		if (!isStarted) {
			DriverStation.reportWarning(" distance starting ", false);
			// initialize();
			startingPosition = 0;
			isFinished = false;
			startingPosition = Robot.driveBase.getEncoderAverage();

			// Robot.throwDaggersInBensEyes.reverse(null);

			isStarted = true;
			targetHeading = currentHeading + _direction;

		} else {

			double current = Robot.driveBase.getEncoderAverage();
			traveled = Robot.driveBase.difference(startingPosition, current);
			DriverStation.reportWarning("waiting start " + startingPosition, false);
			DriverStation.reportWarning("waiting curre " + current, false);
			DriverStation.reportWarning("traveled      " + traveled, false);
			DriverStation.reportWarning("distance      " + _distance, false);

			isFinished = traveled > Math.abs(_distance);// UNITS;
			DriverStation.reportWarning("waiting finished? " + isFinished, false);
		}

		double setHeading = -currentHeading * UNITS;
		if (_direction != 0) {
			setHeading = targetHeading;
		}

		// Robot.driveBase.driveHeading(_speed, setHeading);
		Robot.driveBase.driveHeading(_speed, 0);
		// Robot.driveBase.drive(_speed, _speed);

		log(traveled);

	}

	public void log(double traveled) {
		double leftTravel = Robot.driveBase.getLeftDistanceUnits(startingPosition);
		double rightTravel = Robot.driveBase.getRightDistanceUnits(startingPosition);
		SmartDashboard.putNumber("DSG: Started Units", startingPosition);

		SmartDashboard.putNumber("DSG: Left Distance - Sensor Units", leftTravel);
		SmartDashboard.putNumber("DSG: Right Distance - Sensor Units", rightTravel);
		SmartDashboard.putNumber("DSG: Left Distance - Inches", Robot.driveBase.unitsToInches(leftTravel));
		SmartDashboard.putNumber("DSG: Right Distance - Inches", Robot.driveBase.unitsToInches(traveled));
		SmartDashboard.putNumber("DSG: Left - Inches per second", Robot.driveBase.getLeftVelocityInchesPerSec());
		SmartDashboard.putNumber("DSG: Right - Inches per second", Robot.driveBase.getRightVelocityInchesPerSec());

	}

}
