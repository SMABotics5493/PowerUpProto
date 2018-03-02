package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;
import org.usfirst.frc.team5493.robot.utils.ButtonMonitor;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimbDown extends Command {

	private boolean isFinished;
	private ButtonMonitor buttonMonitor;

	public ClimbDown(Button cmdButton) {
		requires(Robot.climber);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		buttonMonitor = new ButtonMonitor(cmdButton);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		// setTimeout(.25);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (buttonMonitor.checkButtonState() == ButtonMonitor.ButtonState.Active) {
			Robot.climber.pullDown();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return buttonMonitor.checkButtonState() == ButtonMonitor.ButtonState.Inactive;
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
