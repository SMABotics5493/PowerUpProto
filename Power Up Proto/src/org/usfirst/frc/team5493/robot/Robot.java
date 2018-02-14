package org.usfirst.frc.team5493.robot;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team5493.robot.commands.DriveStraightWithGyro;
import org.usfirst.frc.team5493.robot.commands.JoystickDrive;
import org.usfirst.frc.team5493.robot.subsystems.CubeControls;
import org.usfirst.frc.team5493.robot.subsystems.DriveBase;
import org.usfirst.frc.team5493.robot.subsystems.OneClimbyBoi;
//import org.usfirst.frc.team5493.robot.subsystems.ThrowDaggersInBensEyes;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import com.ctre.CANTalon.TalonControlMode;

public class Robot extends IterativeRobot {

	public static final DriveBase driveBase = new DriveBase();
	public static OneClimbyBoi climber;
	public static OI oi;
//	public static ThrowDaggersInBensEyes throwDaggersInBensEyes;
	public static CubeControls cubeControls;
 
	//Encoder encoder = new Encoder(4, 5, true, EncodingType.k2X);
	static double distancePerRevolution = 480.66;
	static double pulsesPerRevolution = 1440;
	static double countsPerRevolution = 360;
	static double distancePerPulse = distancePerRevolution / pulsesPerRevolution;
	static double distancePerCount = distancePerRevolution / countsPerRevolution;
	
 Command autonomousCommand;
    SendableChooser chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    
    public void robotInit() {
    	
    	climber = new OneClimbyBoi();
    	cubeControls = new CubeControls();
//    	throwDaggersInBensEyes = new ThrowDaggersInBensEyes();
		oi = new OI();
//		throwDaggersInBensEyes = new ThrowDaggersInBensEyes();
		
        chooser = new SendableChooser();
        chooser.addDefault("Tank Drive", new JoystickDrive());
        SmartDashboard.putData("Auto mode", chooser);
        SmartDashboard.putData("Drive Base", driveBase);

    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
    	//encoder.reset();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        autonomousCommand = new DriveStraightWithGyro();
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) 
        	autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null)
        	autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
       // drive.arcadeDrive(speed, rotation);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
