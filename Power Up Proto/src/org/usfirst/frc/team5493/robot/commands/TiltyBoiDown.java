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
    }

    
    protected void execute() {
    	
    	isFinished = true; 
    	Robot.cubeControls.outtake();
    	isFinished = false;
    	
    }

    
    protected boolean isFinished() {
        return false;
    }

    
    protected void end() {
    }

    
    protected void interrupted() {
    }
}
