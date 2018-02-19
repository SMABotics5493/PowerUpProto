package org.usfirst.frc.team5493.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeftLeft extends CommandGroup {

    public AutoLeftLeft() {
    	//addSequential(new IntakeRelease());
    	//addSequential(new CubeIntake());
    	//addSequential(new DriveStraightWithGyro(-0.5, 40, 0));
    	//addSequential(new TurnWithGyro());
    	addSequential(new DriveStraightWithGyro(-0.5, 20, 90));
    	//addSequential(new CascadeUp());
    	//addSequential(new DriveStraightWithGyro(-0.5, 35, 0));
    	//addSequential(new CubeOuttake());
    	//addSequential(new DriveStraightBack());
    	//addSequential(new CascadeDown());
       
    }
}
