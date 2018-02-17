package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CascadeDown extends Command {

	private boolean isFinished;
	
	public CascadeDown() {
		super(0.25);
		requires(Robot.cascade);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		isFinished = false;
		
		setTimeout(.25);
		
//		Robot.cascade.initializeCounterDown();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.cascade.climbDown();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		DriverStation.reportError("down timeout is = "+ isTimedOut(), false);
		return isTimedOut();
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
