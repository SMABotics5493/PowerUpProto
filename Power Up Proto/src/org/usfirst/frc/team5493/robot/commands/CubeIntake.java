package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CubeIntake extends Command {

	private boolean isFinished;
	
    public CubeIntake() {
        requires(Robot.cubeControls);
    }
    
    DigitalInput limitSwitch;
    //When Button is pressed, CubeIntake will turn on and take in cube until limit switch = 1
    //once limit switch = 1, CubeIntake will stop
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	//limitSwitch = new DigitalInput(1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	isFinished = true;
    	Robot.cubeControls.intake();
    	isFinished = false;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
