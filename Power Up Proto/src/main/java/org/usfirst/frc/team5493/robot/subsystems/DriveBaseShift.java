package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.Robot;
import org.usfirst.frc.team5493.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveBaseShift extends Subsystem {
	
	DoubleSolenoid solenoid = new DoubleSolenoid(RobotMap.DRIVEBASE_HIGH, RobotMap.DRIVEBASE_LOW);
	
	public DriveBaseShift() {
		solenoid.set(DoubleSolenoid.Value.kForward);
		Robot.isShifted = false;
	}
	
	public void forward(String commandname) {
		/*if (solenoid.get() == DoubleSolenoid.Value.kForward) {
			DriverStation.reportError("Pnuematics Releases: Forward", false);
		} else if (solenoid.get() == DoubleSolenoid.Value.kReverse) {
			DriverStation.reportError("Pnuematics Release: Reverse", false);
		} else if (solenoid.get() == DoubleSolenoid.Value.kOff) {
			DriverStation.reportError("Pnuematics Release: Off", false);
		}*/
		DriverStation.reportError("Forward was called",false);
		solenoid.set(DoubleSolenoid.Value.kReverse);
		Robot.isShifted = true;
	}
	
	public void reverse(String commandname){
		/*if (solenoid.get() == DoubleSolenoid.Value.kReverse) {
			DriverStation.reportError("Pnuematics Releases: Reverse", false);
		} else if (solenoid.get() == DoubleSolenoid.Value.kForward) {
			DriverStation.reportError("Pnuematics Release: Forward", false);
		} else if (solenoid.get() == DoubleSolenoid.Value.kOff) {
			DriverStation.reportError("Pnuematics Release: Off", false);
		}*/
		DriverStation.reportError("Reverse was called",false);
		solenoid.set(DoubleSolenoid.Value.kForward);
		Robot.isShifted = false;
	}
	public void off(String commandname){
		DriverStation.reportError("Transmission Off",false);
		solenoid.set(DoubleSolenoid.Value.kOff);
		Robot.isShifted = false;
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	//solenoid.set(DoubleSolenoid.Value.kOff);
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	//public void reverse(Object object) {
		// TODO Auto-generated method stub
		
	//}

	//public void forward(Object object) {
		// TODO Auto-generated method stub
		
	//}
}

