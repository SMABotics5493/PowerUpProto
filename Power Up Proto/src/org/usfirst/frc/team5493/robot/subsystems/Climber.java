package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.Robot;
import org.usfirst.frc.team5493.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

	private WPI_TalonSRX climbMotor;
	public Object climbDown;
	
	public Climber() {
	super();
	
	climbMotor = new WPI_TalonSRX(RobotMap.CLIMBER);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	 }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void climbUp() {
    	Robot.climber.climbMotor.set(0.5);
    }
    public void climbDown(){
    	Robot.climber.climbMotor.set(-0.5);
    }
    public void end(){
    	Robot.climber.climbMotor.set(0.0);
    }
}

