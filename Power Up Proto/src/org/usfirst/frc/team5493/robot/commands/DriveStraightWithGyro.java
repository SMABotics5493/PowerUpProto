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

	double Kp = 0.03;
	private boolean isFinished = false;

	private double startingPosition;

	private boolean isStarted = false;
	private boolean _quickTurn = false;
	private double _heading;
	private double _distance;
	private double _directionalSpeed;
	private double targetHeading;
	private double maxAngle = 0;
	private double minAngle = 0;
	private double startingAngle = 0;

	public DriveStraightWithGyro(double directionalSpeed, double distance, double heading) {
		requires(Robot.driveBase);
		requires(Robot.throwDaggersInBensEyes);
		_distance = DriveBase.inchesToRotations(distance);
		_heading = heading;
		_directionalSpeed = directionalSpeed;
	}

	public DriveStraightWithGyro(double directionalSpeed, double distance, double heading, boolean quickTurn) {
		this(directionalSpeed, distance, heading);
		_quickTurn = quickTurn;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.gyro.reset();
		Robot.driveBase.resetEncoder();
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
		// DriverStation.reportWarning("finished? " + isFinished, false);
		return isFinished;
	}

	// Called once after isFinished returns true
	protected void end() {
<<<<<<< HEAD
		// DriverStation.reportWarning("end", false);
		Robot.driveBase.reset();
		isStarted = false;
		isFinished = true;
=======
		DriverStation.reportWarning("end", false);
>>>>>>> NewAbby
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
<<<<<<< HEAD
		// DriverStation.reportWarning("interrupt", false);
=======
		DriverStation.reportWarning("interrupt", false);
		end();
>>>>>>> NewAbby
	}

	protected void distance() {

		StringBuffer sb = new StringBuffer();
		double traveled = 0;
		double currentHeading = Robot.gyro.getAngle();
		if (!isStarted) {
			// DriverStation.reportWarning(" distance starting ", false);
			// initialize();
			startingPosition = 0;
			isFinished = false;
			startingPosition = Robot.driveBase.getEncoderAverage();
			startingAngle = currentHeading;
			// Robot.throwDaggersInBensEyes.reverse(null);

			isStarted = true;
			targetHeading = currentHeading + _heading;

		} else {

			// DriverStation.reportWarning("waiting start " + startingPosition, false);
			// DriverStation.reportWarning("waiting curre " + current, false);
			// DriverStation.reportWarning("traveled " + traveled, false);
			// DriverStation.reportWarning("distance " + _distance, false);
			if (_distance == 0) {

				maxAngle = Math.max(currentHeading, maxAngle);
				minAngle = Math.min(currentHeading, minAngle);

				boolean isAngled = startingAngle > targetHeading ? Math.min(minAngle, currentHeading) <= targetHeading
						: Math.max(maxAngle, currentHeading) >= targetHeading;
				isFinished = isAngled;// UNITS;

				sb.append("\r\n target      " + targetHeading);
				sb.append("     headed      " + currentHeading);
				sb.append("     minAngle    " + minAngle);
				sb.append("     maxAngle    " + maxAngle);
				sb.append("     isFinished  " + isFinished);
				sb.append("     isAngled    " + isAngled);
				sb.append("\r\n   ");
				sb.append("\r\n   ");
				sb.append("\r\n   ");

				DriverStation.reportWarning(sb.toString(), false);
			} else {
				double current = Robot.driveBase.getEncoderAverage();
				traveled = Robot.driveBase.difference(startingPosition, current);

				isFinished = traveled > Math.abs(_distance);// UNITS;

			}

			// DriverStation.reportWarning("waiting finished? " + isFinished, false);
		}

		if (isFinished) {
			return;
		}

		double setHeading = -currentHeading * Kp;
		if (_heading != 0) {
			setHeading = targetHeading;
		}

<<<<<<< HEAD
		// Robot.driveBase.driveHeading(_speed, setHeading);
		Robot.driveBase.driveHeading(_directionalSpeed, setHeading, _quickTurn);
		// Robot.driveBase.drive(_speed, _speed);

		log(traveled);
=======
		Robot.driveBase.driveHeading(_speed, setHeading);
		//Robot.driveBase.driveHeading(_speed, 0);
		//Robot.driveBase.drive(_speed, _speed);
>>>>>>> NewAbby

	}

	public void log(double traveled) {
		double leftTravel = Robot.driveBase.getLeftDistanceUnits(startingPosition);
		double rightTravel = Robot.driveBase.getRightDistanceUnits(startingPosition);
		SmartDashboard.putNumber("DSG: Started Units", startingPosition);

		SmartDashboard.putNumber("DSG: Left Distance - Sensor Units", leftTravel);
		SmartDashboard.putNumber("DSG: Right Distance - Sensor Units", rightTravel);
		SmartDashboard.putNumber("DSG: Left Distance - Inches", DriveBase.unitsToInches(leftTravel));
		SmartDashboard.putNumber("DSG: Right Distance - Inches", DriveBase.unitsToInches(traveled));
		// SmartDashboard.putNumber("DSG: Left - Inches per second",
		// Robot.driveBase.getLeftVelocityInchesPerSec());
		// SmartDashboard.putNumber("DSG: Right - Inches per second",
		// Robot.driveBase.getRightVelocityInchesPerSec());

	}

}
