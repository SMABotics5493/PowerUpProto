package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CubeIntake extends Command {

    public CubeIntake() {
        requires(Robot.cubeControls);
    }
    
    //When Button is pressed, CubeIntake will turn on and take in cube until limit switch = 1
    //once limit switch = 1, CubeIntake will stop
    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.cubeControls.leftIntakeMotor.set(1.0);
    	Robot.cubeControls.rightIntakeMotor.set(1.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.cubeControls.leftIntakeMotor.set(0.0);
    	Robot.cubeControls.rightIntakeMotor.set(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
