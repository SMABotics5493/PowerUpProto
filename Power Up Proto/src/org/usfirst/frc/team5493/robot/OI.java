package org.usfirst.frc.team5493.robot;

import org.usfirst.frc.team5493.robot.commands.ClimbDown;
//import org.usfirst.frc.team5493.robot.commands.ClimbHold;
import org.usfirst.frc.team5493.robot.commands.ClimbUp;
import org.usfirst.frc.team5493.robot.commands.CubeIntake;
import org.usfirst.frc.team5493.robot.commands.CubeOuttake;
import org.usfirst.frc.team5493.robot.commands.Endgame;
import org.usfirst.frc.team5493.robot.commands.PullDown;
import org.usfirst.frc.team5493.robot.commands.PullUp;
import org.usfirst.frc.team5493.robot.commands.TiltyBoiDown;
import org.usfirst.frc.team5493.robot.commands.TiltyBoiUp;
import org.usfirst.frc.team5493.robot.commands.TransmissionForward;
import org.usfirst.frc.team5493.robot.commands.TransmissionReverse;
import org.usfirst.frc.team5493.robot.subsystems.Candycane;
import org.usfirst.frc.team5493.robot.subsystems.OneClimbyBoi;
import org.usfirst.frc.team5493.robot.subsystems.ThrowDaggersInBensEyes;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * Test a build trigger.
 */
public class OI {
    
    private Joystick driveJoystick = new Joystick(RobotMap.JOYSTICK_DRIVE_PORT);
    private Joystick joystick = new Joystick(RobotMap.JOYSTICK_PORT);
   // DriverStation ds = DriverStation.getInstance();
 
    JoystickButton cubeIntake = new JoystickButton(joystick, RobotMap.JOYBTN_LT);
	JoystickButton cubeOuttake = new JoystickButton(joystick, RobotMap.JOYBTN_RT);
	JoystickButton climbUp = new JoystickButton(joystick, RobotMap.JOYBTN_Y);
	JoystickButton climbDown = new JoystickButton(joystick, RobotMap.JOYBTN_A);
	JoystickButton solenoidForward = new JoystickButton(driveJoystick, RobotMap.JOYBTN_X);
	JoystickButton solenoidReverse = new JoystickButton(driveJoystick, RobotMap.JOYBTN_B);
	JoystickButton climbHold = new JoystickButton(joystick, RobotMap.JOYBTN_X);
	JoystickButton tiltyBoiUp = new JoystickButton(joystick, RobotMap.JOYBTN_LB);
	JoystickButton tiltyBoiDown = new JoystickButton(joystick, RobotMap.JOYBTN_RB);
	JoystickButton pullUp = new JoystickButton(driveJoystick, RobotMap.JOYBTN_Y);
	JoystickButton pullDown = new JoystickButton(driveJoystick, RobotMap.JOYBTN_A);
	JoystickButton solenoidEndgame = new JoystickButton(driveJoystick, RobotMap.JOYBTN_B);
	
    public Joystick getDriveJoystick(){
    	return driveJoystick;
    }
    
    public Joystick getJoystick(){
    	return joystick;
    }
    
    
    
    public OI(){
    	
    	cubeIntake.whileHeld(new CubeIntake());
    	cubeOuttake.whileHeld(new CubeOuttake());
    	climbUp.whileHeld(new ClimbUp());
    	climbDown.whileHeld(new ClimbDown());
    	solenoidForward.whenPressed(new TransmissionForward());
    	solenoidReverse.whenPressed(new TransmissionReverse());
    	pullUp.whileHeld(new PullUp());
    	pullDown.whileHeld(new PullDown());
    	tiltyBoiUp.whileHeld(new TiltyBoiUp());
    	tiltyBoiDown.whileHeld(new TiltyBoiDown());    	
    	solenoidEndgame.whenPressed(new Endgame());
    	
    	
    }
    
}

