package org.usfirst.frc.team5493.robot.commands.gameSpecific;

import org.usfirst.frc.team5493.robot.RobotMap;
import org.usfirst.frc.team5493.robot.commands.DriveStraightWithGyro;
import org.usfirst.frc.team5493.robot.commands.TiltyBoiDown;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftRightLeft extends CommandGroup {

    public LeftRightLeft(int startingPosition) {
    	switch (startingPosition) {
		case 1:
			//TODO: Position 1 logic
			addSequential(new DriveStraightWithGyro(-.6,20,0));
			addSequential(new CascadeUpByTime(RobotMap.SwitchHeight));
			addSequential(new TiltyBoiDown());
			addSequential(new DriveStraightWithGyro(-.3,20,-90));
			addSequential(new CubeOuttakeAuto(.5));
			//addSequential(new CascadeDownByTime)
			//addSequential(new DriveStraightWithGyro(.3, 20,0));
			break;
		case 2:
			//TODO: Position 1 logic
			break;
		case 3:
			//TODO: Position 1 logic
			break;
		}
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
