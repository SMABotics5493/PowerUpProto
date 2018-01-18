package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
/*public class DriveStraightTimed extends TimedCommand {

	private double driveValueRamping = 0.2;
	private double maxDriveValue = 0.6;
	private double rampBy = 0.012;
	private double timeout;
	
	private double lastReadAt = 0;

	private double readEverySeconds = 0;
	
	private double driveEncoderInitial = .5;
	
	private double driveEncoderLeft = driveEncoderInitial;
	private double driveEncoderRight = driveEncoderInitial;

	public DriveStraightTimed(double timeout) {
		super(timeout);
		this.timeout = timeout;
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis)
		requires(Robot.driveBase);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		//Robot.driveBase.resetEncoders();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (!isTimedOut()) {
			driveUsingEncoderTargetedSpeed();
		}
	}

	private void driveUsingEncoderTargetedSpeed() {
		
		/*EncoderAdjustment adjustBy = driveBase.determineAdjusments();
		
		if (readEverySeconds == 0 ) {
			readEverySeconds = timeout * .05;
		}
		
		double timeSince = timeSinceInitialized();
		
		if ( timeSince - lastReadAt >= readEverySeconds) {
			if (adjustBy.sideToAdjust==EncoderAdjustment.SIDE_LEFT) {
				driveEncoderLeft += adjustBy.adjustment;
			}
			else if (adjustBy.sideToAdjust==EncoderAdjustment.SIDE_RIGHT){
				driveEncoderRight += adjustBy.adjustment;
			}
			
			lastReadAt = timeSince;
		}
		
		DriverStation.getInstance().reportError("Left: " + driveEncoderLeft + " Right: " + driveEncoderRight, false);
		
		driveBase.tankDrive(driveEncoderLeft, driveEncoderRight);*/
	//}

	/*private void driveUsingRampingSpeed() {
		if (timeSinceInitialized() <= timeout * .5) {
			driveValueRamping += rampBy;
		}
		if (timeSinceInitialized() > timeout * .5) {
			driveValueRamping -= rampBy;
		}

		driveValueRamping = driveValueRamping > maxDriveValue ? maxDriveValue : driveValueRamping;
		driveValueRamping = driveValueRamping < 0 ? 0 : driveValueRamping;

		driveBase.tankDrive(driveValueRamping, driveValueRamping);
	}*/

	/*protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after timeout
	protected void end() {
		Robot.driveBase.drive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}*/
