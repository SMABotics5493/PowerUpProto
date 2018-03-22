package org.usfirst.frc.team5493.robot.commands.gameSpecific;

import org.usfirst.frc.team5493.robot.Robot;
import org.usfirst.frc.team5493.robot.utils.ButtonMonitor;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class CascadeDownByTime extends TimedCommand {

	

	public CascadeDownByTime(double Time) {
		
		super(Time);
		
		requires(Robot.cascade);
		
		
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		//	Robot.cascade.initializeCounterUp();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (!isTimedOut()) {
			Robot.cascade.climbDown();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
		// true; 
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

