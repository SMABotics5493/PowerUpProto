package org.usfirst.frc.team5493.robot.commands;

import org.usfirst.frc.team5493.robot.commands.gameSpecific.CascadeUpByTime;
import org.usfirst.frc.team5493.robot.commands.gameSpecific.CubeOuttakeAuto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRightRight extends CommandGroup {

    public AutoRightRight() {
    	addSequential(new DriveStraightWithGyro(-0.5,8300 ,0));
    	addSequential(new DriveStraightWithGyro(-0.5, 8000, 90));
    	addSequential(new CascadeUpByTime(5));
    	addSequential(new CubeOuttakeAuto(3));
    	//addSequential(new DriveStraightWithGyro(-0.5, -4000, 0))   
    	}
}
