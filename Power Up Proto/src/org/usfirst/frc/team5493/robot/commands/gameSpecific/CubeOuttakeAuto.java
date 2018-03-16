package org.usfirst.frc.team5493.robot.commands.gameSpecific;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class CubeOuttakeAuto extends TimedCommand {

	public CubeOuttakeAuto(double Outtake) {
		super(Outtake);
		
		requires(Robot.cubeControls);
		
		
	}

	protected void initialize() {
		
	}

	protected void execute() {
		 if (!isTimedOut()){
			Robot.cubeControls.outtake();
		}
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		Robot.cubeControls.end();
	}

	protected void interrupted() {
		end();
	}
}
