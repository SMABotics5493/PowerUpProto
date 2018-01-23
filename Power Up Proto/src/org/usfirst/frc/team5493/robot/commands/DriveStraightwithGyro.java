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
public class DriveStraightwithGyro extends TimedCommand {

//	private RobotDrive gyroDrive;
	private ADXRS450_Gyro gyro;
	double Kp = 0.03;
    public DriveStraightwithGyro() {
    	super(10);
        gyro = new ADXRS450_Gyro();
        gyro.reset();
        //gyro = new RobotDrive(1,2);
        //Robot.driveBase.setExpiration(0.1);
    }
    public void autonomous() {
    	
       // while (Autonomous()) {
            double angle = gyro.getAngle();
            //Robot.driveBase.driveHeading(0.1, -angle*Kp);
            // get current heading
            //gyroDrive.drive(-1.0, -angle*Kp); // drive towards heading 0
            Timer.delay(0.004);
        //}
        //gyroDrive.drive(0.0, 0.0);
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
