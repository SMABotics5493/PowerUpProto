package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.Robot;
import org.usfirst.frc.team5493.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

	private WPI_TalonSRX candycane;
	private WPI_TalonSRX climbMotor;
	
	public Climber() {
		candycane = new WPI_TalonSRX(RobotMap.CLIMBER);
		climbMotor = new WPI_TalonSRX(RobotMap.CASCADE);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    }

    	public void pullUp() {
    		Robot.climber.candycane.set(0.8);
       	}
    	public void pullDown() {
    		Robot.climber.candycane.set(-0.4);
    	}
    	public void endgameRaise() {
    		Robot.climber.candycane.set(-0.25);
    		Robot.climber.climbMotor.set(1);
    	}
    	public void end() {
    		Robot.climber.candycane.set(0.0);
    		
    	}
    	public void end3(){
    		Robot.climber.candycane.set(0.0);
    		Robot.climber.climbMotor.set(0.0);
    	}
}

