package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class EncoderForDistance extends Command {
	
	private double target;
	private double speed;
	private boolean goForward;
	
	//TODO: What the _encoderPulses are for the encoders we're using.
	private int _encoderPulses = 1440;
	private double _diameter = 6;

    public EncoderForDistance(double distance, boolean forward) {
          requires(Robot.driveBase);
          if(forward)
        	  target = distance;
          else
        	  target = -distance;
          goForward = forward;
          
        
    }

    // Called just before this Command runs the first time
    protected void initialize() { 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveBase.drive(speed, speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    
    protected void distance(double targetPositionRotations) {
		/* 10 Rotations * 4096 u/rev in either direction */
		targetPositionRotations = targetPositionRotations * _encoderPulses;
		
		Robot.driveBase.drivePosition(targetPositionRotations);
//		_talon.set(ControlMode.Position, targetPositionRotations);
    }
}
