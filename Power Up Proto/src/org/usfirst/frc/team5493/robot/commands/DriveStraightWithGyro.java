package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.Robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.TimedCommand;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
public class DriveStraightWithGyro extends TimedCommand {

	private ADXRS450_Gyro gyro;
	double Kp = 0.03;
    public DriveStraightWithGyro() {
    	super(10);
        gyro = new ADXRS450_Gyro();
        gyro.reset();
       
    }
    public void autonomous() {
    	
            double angle = gyro.getAngle();
            Timer.delay(0.004);
    }
    private boolean Autonomous() {
		// TODO Auto-generated method stub
		return false;
	}
	// Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	 double angle = gyro.getAngle();
         Robot.driveBase.driveHeading(-0.5, -angle*Kp);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
