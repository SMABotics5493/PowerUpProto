package org.usfirst.frc.team5493.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMiddleLeft extends CommandGroup {

    public AutoMiddleLeft() {
    	//addSequential(new IntakeRelease());
    	addSequential(new CubeIntake(null));
    	addSequential(new DriveStraightWithGyro(0, 0, 0));
    	//addSequential(new TurnLeftWithGyro());
    	addSequential(new DriveStraightWithGyro(0, 0, 0));
    	//addSequential(new TurnWithGyro());
    	addSequential(new DriveStraightWithGyro(0, 0, 0));
    	addSequential(new CascadeUp());
    	addSequential(new DriveStraightWithGyro(0, 0, 0));
    	addSequential(new CubeOuttake(null));
    	//addSequential(new DriveStraightBack());
    	addSequential(new CascadeDown());
    }
}
