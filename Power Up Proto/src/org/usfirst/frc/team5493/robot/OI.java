package org.usfirst.frc.team5493.robot;
import org.usfirst.frc.team5493.robot.commands.ClimbDown;
//import org.usfirst.frc.team5493.robot.commands.ClimbHold;
import org.usfirst.frc.team5493.robot.commands.ClimbUp;
import org.usfirst.frc.team5493.robot.commands.CubeIntake;
import org.usfirst.frc.team5493.robot.commands.CubeOuttake;
import org.usfirst.frc.team5493.robot.commands.TransmissionForward;
import org.usfirst.frc.team5493.robot.commands.TransmissionReverse;
import org.usfirst.frc.team5493.robot.subsystems.OneClimbyBoi;
//import org.usfirst.frc.team5493.robot.subsystems.ThrowDaggersInBensEyes;

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
	JoystickButton CubeThingGoUp = new JoystickButton(joystick, RobotMap.JOYBTN_LB);
	JoystickButton CubeThingGoDown = new JoystickButton(joystick, RobotMap.JOYBTN_RB);
	
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
//    	solenoidForward.whenPressed(new TransmissionForward());
//    	solenoidReverse.whenPressed(new TransmissionReverse());
    	
    	//JoystickButton triggerButton = new JoystickButton(joy, RobotMap.JOYBTN_TRIGGER);
    	
    	//SmartDashboard.putData(null);
       
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    	
    }
    
}

