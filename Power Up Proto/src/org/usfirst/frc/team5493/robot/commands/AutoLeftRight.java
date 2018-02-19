package org.usfirst.frc.team5493.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeftRight extends CommandGroup {

    public AutoLeftRight() {
       //addSequential(new IntakeRelease());
    	addSequential(new DriveStraightWithGyro(0, 0, 0));
    	//addSequential(new TurnWithGyro());
    	addSequential(new DriveStraightWithGyro(0, 0, 0));
    	//addSequential(new TurnWithGyro());
    	addSequential(new DriveStraightWithGyro(0, 0, 0));
    	addSequential(new CascadeUp());
    	addSequential(new DriveStraightWithGyro(0, 0, 0));
    	addSequential(new CubeOuttake());
    	//addSequential(new DriveStraightBack());
    	addSequential(new CascadeDown());
    }
}
