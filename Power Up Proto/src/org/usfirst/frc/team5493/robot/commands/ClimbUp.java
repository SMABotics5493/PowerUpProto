package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimbUp extends Command {

	boolean isFinished;

	public ClimbUp() {
		requires(Robot.climber);
		//super(0.25);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		isFinished = false;
		setTimeout(.25);
//		Robot.climber.initializeCounterUp();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.climber.climbUp();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		//DriverStation.reportError("up  timeout is = "+ isTimedOut(), false);
		//return isTimedOut();
		return true; 
//		return Robot.climber.hasClimbedDown();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.climber.end();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
