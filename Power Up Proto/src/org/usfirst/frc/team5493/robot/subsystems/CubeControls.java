package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeControls extends Subsystem {
		
	 public WPI_TalonSRX leftIntakeMotor;
	 public WPI_TalonSRX rightIntakeMotor;
	//private RobotDrive intake;
	
	public CubeControls() {
	super();
	
	leftIntakeMotor = new WPI_TalonSRX(RobotMap.intakeLeft);
	rightIntakeMotor = new WPI_TalonSRX(RobotMap.intakeRight);
	
    //intake = new RobotDrive(leftIntakeMotor,rightIntakeMotor);
	
	// Put methods for controlling this subsystem
	
	double secondsFromNeutral = 0;
	int timeoutMs = 0;
	
	Preferences prefs = Preferences.getInstance();
	
	secondsFromNeutral = prefs.getDouble("RampRateCube", 0.25);
	timeoutMs = prefs.getInt("RampRateCubeTimeout", 1);
	
	leftIntakeMotor.configOpenloopRamp(secondsFromNeutral, timeoutMs);
	rightIntakeMotor.configOpenloopRamp(secondsFromNeutral, timeoutMs);
	
	
	}
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

