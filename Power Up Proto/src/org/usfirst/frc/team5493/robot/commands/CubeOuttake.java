package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CubeOuttake extends Command {

	private boolean isFinished;

	public CubeOuttake() {
		requires(Robot.cubeControls);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}
	// When button is pressed CubOuttake will run until until limit switch = 0
	// When limit switch = 0, CubeOuttake will continue run for 2 sec

	// Called just before this Command runs the first time
	protected void initialize() {
		isFinished = false;
		setTimeout(.25);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.cubeControls.outtake();
	}
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		// TODO - Meng... I think this needs to gets something back from cubeControls to
		// know it's done - i.e. a time expiration or something like that.
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.cubeControls.end();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
