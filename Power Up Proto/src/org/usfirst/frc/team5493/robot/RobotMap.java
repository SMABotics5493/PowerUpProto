package org.usfirst.frc.team5493.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public final static int JOYSTICK_DRIVE_PORT = 5;
	public final static int JOYSTICK_PORT = 1;
	
	public final static int JOYBTN_A = 1;
	public final static int JOYBTN_B = 2;
	public final static int JOYBTN_X = 3;
	public final static int JOYBTN_Y = 4; 
	public final static int JOYBTN_LB = 5;
	public final static int JOYBTN_RB = 6;
	public final static int JOYBTN_RT = 6;
	public final static int JOYBTN_LT = 5;
	
	public final static int RIGHTYAXIS = 5;
	public final static int LEFTYAXIS = 1;
	
	public final static int LEFT_FRONT = 7;
	public final static int LEFT_BACK = 6;
	public final static int RIGHT_FRONT = 2;
	public final static int RIGHT_BACK = 5;

	public final static int INTAKE_LEFT = 5;
	public final static int INTAKE_RIGHT = 4;
	
	public final static int INTAKE_LIFT = 3;
	
	public final static int ENDGAME = 0;
	
	public final static int CLIMBER = 2; 
	
	public final static int LEFT_ENCODER_A = 1;
	public final static int LEFT_ENCODER_B = 2;  //THESE ARE NOT THE CORRECT PORTS
	public final static int RIGHT_ENCODER_A = 3;
	public final static int RIGHT_ENCODER_B = 4;
	
	public final static int SOLENOID_FORWARD = 0;
	public final static int SOLENOID_REVERSE = 7;
	
	//public static int gyro;
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
