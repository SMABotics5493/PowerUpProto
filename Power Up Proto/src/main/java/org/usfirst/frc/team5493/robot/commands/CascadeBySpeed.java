package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;
import org.usfirst.frc.team5493.robot.RobotMap;
import org.usfirst.frc.team5493.robot.utils.ButtonMonitor;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CascadeBySpeed extends Command {

	// private ButtonMonitor buttonMonitor;
	private ButtonMonitor lockMonitor;

	public CascadeBySpeed(Button cascadeLock) {
		requires(Robot.cascade);
		// buttonMonitor = new ButtonMonitor(cmdButton);
		// lockMonitor = new ButtonMonitor(cascadeLock);

		// super(0.25);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		// Robot.cascade.initializeCounterUp();
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// if (lockMonitor.checkButtonState() ==
		// ButtonMonitor.ButtonState.Active) {
//		if (Robot.oi.getJoystick().getRawAxis(RobotMap.CASCADE_LOCK) == 1
//				|| Robot.oi.getJoystick().getRawAxis(RobotMap.CASCADE_LOCK) == -1) {
		
		DriverStation.getInstance().reportWarning("Execute!!!",false);
		Robot.cascade.climbBySpeed(1);
//		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false; //Robot.oi.getJoystick().getRawAxis(RobotMap.CASCADE_LOCK) == 0;
		// true;
		// return Robot.cascade.hasClimbedDown();
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
