package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.Robot;
import org.usfirst.frc.team5493.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Candycane extends Subsystem {

	private WPI_TalonSRX candycane;
	
	public Candycane() {
		candycane = new WPI_TalonSRX(RobotMap.CANDYCANE);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    }

    	public void pullUp() {
    		Robot.candycane.candycane.set(1);
       	}
    	public void pullDown() {
    		Robot.candycane.candycane.set(-0.4);
    	}
    	public void end() {
    		Robot.candycane.candycane.set(0.0);
    		
    	}
}

