package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

	 public WPI_TalonSRX climbMotor;
	
	public void climber() {
		
		
	climbMotor = new WPI_TalonSRX(RobotMap.climber);
	
	double secondsFromNeutral = 0;
	int timeoutMs = 0;
	
	Preferences prefs = Preferences.getInstance();
	
	secondsFromNeutral = prefs.getDouble("RampRateClimber", 0.25);
	timeoutMs = prefs.getInt("RampRateClimberTimeout", 1);
	
	climbMotor.configOpenloopRamp(secondsFromNeutral, timeoutMs);
	
	 }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

