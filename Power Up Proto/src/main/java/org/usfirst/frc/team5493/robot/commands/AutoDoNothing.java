package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDoNothing extends Command {

    public AutoDoNothing() {
    	requires(Robot.driveBase);
        
    }

   
    protected void initialize() {
    }

    
    protected void execute() {
    }

   
    protected boolean isFinished() {
        return true;
    }

    
    protected void end() {
    }

    
    protected void interrupted() {
    }
}
