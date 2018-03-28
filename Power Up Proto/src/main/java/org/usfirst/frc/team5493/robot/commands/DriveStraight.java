package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends Command {

	private double speed;
	private double time;
	
    public DriveStraight(double s, double t) {
    	requires(Robot.driveBase);
    	speed = s;
    	time = t;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveBase.drive(speed*1.08, speed*.995);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return(this.timeSinceInitialized() >= time);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveBase.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
