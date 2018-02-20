package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TiltyBoiDown extends Command {
	
	private boolean isFinished;

    public TiltyBoiDown() { 	
    	requires(Robot.cubeControls);       
    }  
    protected void initialize() {
    	isFinished = false;
    	setTimeout(.25);
    }   
    protected void execute() {
    	Robot.cubeControls.raiseDown();    	
    }   
    protected boolean isFinished() {
        return isTimedOut();
    }   
    protected void end() {
    	Robot.cubeControls.end2();
    } 
    protected void interrupted() {
    	end();
    }
}
