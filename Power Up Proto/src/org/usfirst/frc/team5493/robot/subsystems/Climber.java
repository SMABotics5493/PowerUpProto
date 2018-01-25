package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

	 public WPI_TalonSRX climbMotor;
	
	public Climber() {
	super();
	
	climbMotor = new WPI_TalonSRX(RobotMap.climber);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	 }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

