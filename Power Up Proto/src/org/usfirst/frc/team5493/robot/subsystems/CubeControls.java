package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.Robot;
import org.usfirst.frc.team5493.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeControls extends Subsystem {
		
	 private WPI_TalonSRX leftIntakeMotor;
	 private WPI_TalonSRX rightIntakeMotor;
	//private RobotDrive intake;
	
	public CubeControls() {
	super();
	
	leftIntakeMotor = new WPI_TalonSRX(RobotMap.INTAKE_LEFT);
	rightIntakeMotor = new WPI_TalonSRX(RobotMap.INTAKE_RIGHT);
	
	rightIntakeMotor.set(ControlMode.Follower,RobotMap.INTAKE_LEFT);
	
	leftIntakeMotor.configOpenloopRamp(.2, 1);
	rightIntakeMotor.configOpenloopRamp(.2, 1);
    //intake = new RobotDrive(leftIntakeMotor,rightIntakeMotor);
	
	// Put methods for controlling this subsystem
	}
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void intake(){
    	Robot.cubeControls.leftIntakeMotor.set(-0.5);
    	Robot.cubeControls.rightIntakeMotor.set(0.5);
    }
    public void outtake() {
    	Robot.cubeControls.leftIntakeMotor.set(0.5);
    	Robot.cubeControls.rightIntakeMotor.set(-0.5);
    }
    public void end() {
    	Robot.cubeControls.leftIntakeMotor.set(0.0);
    	Robot.cubeControls.rightIntakeMotor.set(0.0);
    }
   
}

