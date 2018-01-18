package org.usfirst.frc.team5493.robot.commands;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
/*public class DriveStraightwithGyro extends Command {

	private RobotDrive gyroDrive;
	private Gyro gyro;
	double Kp = 0.03;
    public DriveStraightwithGyro() {
        gyro = new AnalogGyro(1);
        gyroDrive = new RobotDrive(1,2);
        gyroDrive.setExpiration(0.1);
    }
    public void autonomous() {
        gyro.reset();
        while (Autonomous()) {
            double angle = gyro.getAngle(); // get current heading
            gyroDrive.drive(-1.0, -angle*Kp); // drive towards heading 0
            Timer.delay(0.004);
        }
        gyroDrive.drive(0.0, 0.0);
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
}*/
