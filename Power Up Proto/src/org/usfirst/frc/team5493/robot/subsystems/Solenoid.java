package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Solenoid extends Subsystem {
	
	DoubleSolenoid solenoid = new DoubleSolenoid(RobotMap.SOLENOID_FORWARD, RobotMap.SOLENOID_REVERSE);
	
	public void forward() {
		if (solenoid.get() == DoubleSolenoid.Value.kForward) {
			DriverStation.reportError("Pnuematics Releases: Forward", false);
		} else if (solenoid.get() == DoubleSolenoid.Value.kReverse) {
			DriverStation.reportError("Pnuematics Release: Reverse", false);
		} else if (solenoid.get() == DoubleSolenoid.Value.kOff) {
			DriverStation.reportError("Pnuematics Release: Off", false);
		}
		solenoid.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void reverse(){
		if (solenoid.get() == DoubleSolenoid.Value.kReverse) {
			DriverStation.reportError("Pnuematics Releases: Reverse", false);
		} else if (solenoid.get() == DoubleSolenoid.Value.kForward) {
			DriverStation.reportError("Pnuematics Release: Forward", false);
		} else if (solenoid.get() == DoubleSolenoid.Value.kOff) {
			DriverStation.reportError("Pnuematics Release: Off", false);
		}
		solenoid.set(DoubleSolenoid.Value.kForward);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	solenoid.set(DoubleSolenoid.Value.kOff);
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	public void reverse(Object object) {
		// TODO Auto-generated method stub
		
	}

	public void forward(Object object) {
		// TODO Auto-generated method stub
		
	}
}

