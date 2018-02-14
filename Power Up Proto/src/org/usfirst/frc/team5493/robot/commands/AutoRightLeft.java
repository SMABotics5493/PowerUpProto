package org.usfirst.frc.team5493.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRightLeft extends CommandGroup {

    public AutoRightLeft() {
    	 //addSequential(new IntakeRelease());
    	addSequential(new DriveStraightWithGyro());
    	//addSequential(new TurnWithGyro());
    	addSequential(new DriveStraightWithGyro());
    	//addSequential(new TurnWithGyro());
    	addSequential(new DriveStraightWithGyro());
    	addSequential(new ClimbUp());
    	addSequential(new ClimbHold());
    	addSequential(new DriveStraightWithGyro());
    	addSequential(new CubeOuttake());
    	//addSequential(new DriveStraightBack());
    	addSequential(new ClimbDown());    
    }
}
