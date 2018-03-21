package org.usfirst.frc.team5493.robot;

import org.usfirst.frc.team5493.robot.commands.AutoDoNothing;
import org.usfirst.frc.team5493.robot.commands.AutoLeftLeft;
import org.usfirst.frc.team5493.robot.commands.DriveStraightWithGyro;
import org.usfirst.frc.team5493.robot.commands.OldDriveStraight;
import org.usfirst.frc.team5493.robot.commands.gameSpecific.LeftRightLeft;
import org.usfirst.frc.team5493.robot.subsystems.Cascade;
import org.usfirst.frc.team5493.robot.subsystems.Climber;
import org.usfirst.frc.team5493.robot.subsystems.CubeControls;
import org.usfirst.frc.team5493.robot.subsystems.DriveBase;
import org.usfirst.frc.team5493.robot.subsystems.Endgame;
import org.usfirst.frc.team5493.robot.subsystems.ThrowDaggersInBensEyes;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import com.ctre.CANTalon.TalonControlMode;

public class Robot extends IterativeRobot {

	public static boolean isShifted = false;
	public static final DriveBase driveBase = new DriveBase();
	public static Cascade cascade;
	public static OI oi;
	public static ThrowDaggersInBensEyes throwDaggersInBensEyes;
	public static Endgame endgame;
	public static CubeControls cubeControls;
	public static Climber climber;

	public static ADXRS450_Gyro gyro;
	// Encoder encoder = new Encoder(4, 5, true, EncodingType.k2X);
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
		gyro = new ADXRS450_Gyro();
		cascade = new Cascade();
		cubeControls = new CubeControls();
		throwDaggersInBensEyes = new ThrowDaggersInBensEyes();
		endgame = new Endgame();
		climber = new Climber();
		oi = new OI();

		chooser = new SendableChooser();
		chooser.addObject("AutoDoNothing", new AutoDoNothing());
		chooser.addObject("AutoLeftLeft", new AutoLeftLeft());
//		chooser.addDefault("AutoStraightOverLine", new DriveStraightWithGyro(-.3, 40, 20));
		chooser.addObject("OldAutoStraight", new OldDriveStraight());

		SmartDashboard.putData("Auto mode", chooser);
		SmartDashboard.putData("Drive Base", driveBase);

	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit() {
		// encoder.reset();
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	public void autonomousInit() {
		autonomousCommand = (Command) chooser.getSelected();

		int startingPosition = 1;
	String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if (gameData.length() > 0) {
			if (gameData.equals("LRL")) {
				autonomousCommand = new LeftRightLeft(startingPosition);
			}
//			if (gameData.charAt(0) == 'L') {
//			}
//				// Put left auto code here
//				autonomousCommand = new DriveStraightWithGyro(0.5, 40, 0);
//			} else {
//				// Put right auto code here
//				autonomousCommand = null;
//			}
		}

	autonomousCommand=new DriveStraightWithGyro(-.4, 120, 0);
	// schedule the autonomous command (example)
	if(autonomousCommand!=null)autonomousCommand.start();

	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
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
