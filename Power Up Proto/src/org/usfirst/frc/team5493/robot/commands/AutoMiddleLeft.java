package org.usfirst.frc.team5493.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMiddleLeft extends CommandGroup {

    public AutoMiddleLeft() {
    	//addSequential(new IntakeRelease());
    	addSequential(new CubeIntake());
    	addSequential(new DriveStraightWithGyro());
    	//addSequential(new TurnLeftWithGyro());
    	addSequential(new DriveStraightWithGyro());
    	//addSequential(new TurnWithGyro());
    	addSequential(new DriveStraightWithGyro());
    	addSequential(new CascadeUp());
    	addSequential(new CascadeHold());
    	addSequential(new DriveStraightWithGyro());
    	addSequential(new CubeOuttake());
    	//addSequential(new DriveStraightBack());
    	addSequential(new CascadeDown());
    }
}
