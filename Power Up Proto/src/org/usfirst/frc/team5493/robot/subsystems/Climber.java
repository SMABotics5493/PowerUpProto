package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.Robot;
import org.usfirst.frc.team5493.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

	private WPI_TalonSRX climbMotor;
	public Object climbDown;
	private double downSpeed;
	private double upSpeed;

	public Climber() {
		super();

		climbMotor = new WPI_TalonSRX(RobotMap.CLIMBER);
		// Put methods for controlling this subsystem
		// here. Call these from Commands.
		double secondsFromNeutral = 0;
		int timeoutMs = 0;

		Preferences prefs = Preferences.getInstance();

		secondsFromNeutral = prefs.getDouble("RampRateClimber", 0.25);
		upSpeed = prefs.getDouble("ClimberUpSpeed", 0.5);
		downSpeed = prefs.getDouble("ClimberDownSpeed", -0.5);
		timeoutMs = prefs.getInt("RampRateClimberTimeout", 1);

		climbMotor.configOpenloopRamp(secondsFromNeutral, timeoutMs);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void climbUp() {
		Robot.climber.climbMotor.set(upSpeed);
	}

	public void climbDown() {
		Robot.climber.climbMotor.set(downSpeed);
	}

	public void end() {
		Robot.climber.climbMotor.set(0.0);
	}
}
