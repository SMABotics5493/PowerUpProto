package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;
import org.usfirst.frc.team5493.robot.utils.ButtonMonitor;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CascadeDown extends Command {

	private ButtonMonitor buttonMonitor;

	public CascadeDown(Button cmdButton) {
		requires(Robot.cascade);
		buttonMonitor = new ButtonMonitor(cmdButton);
		//super(0.25);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		//	Robot.cascade.initializeCounterUp();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (buttonMonitor.checkButtonState() == ButtonMonitor.ButtonState.Active) {
			Robot.cascade.climbDown();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return buttonMonitor.checkButtonState() == ButtonMonitor.ButtonState.Inactive;
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

