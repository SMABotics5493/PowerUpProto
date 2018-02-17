package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CascadeUp extends Command {

	boolean isFinished;

	public CascadeUp() {
		requires(Robot.cascade);
		//super(0.25);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		isFinished = false;
		setTimeout(.25);
//		Robot.cascade.initializeCounterUp();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.cascade.climbUp();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		//DriverStation.reportError("up  timeout is = "+ isTimedOut(), false);
		//return isTimedOut();
		return true; 
//		return Robot.cascade.hasClimbedDown();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.cascade.end();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
