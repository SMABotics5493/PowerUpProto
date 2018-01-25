package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Solenoid extends Subsystem {
	
	DoubleSolenoid solenoid = new DoubleSolenoid(RobotMap.solenoidForward, RobotMap.solenoidReverse);
	
	public void forward() {
		solenoid.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void reverse(){
		solenoid.set(DoubleSolenoid.Value.kForward);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	solenoid.set(DoubleSolenoid.Value.kOff);
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

