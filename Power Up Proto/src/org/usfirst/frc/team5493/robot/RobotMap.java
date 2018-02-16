package org.usfirst.frc.team5493.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static final int JOYSTICK_DRIVE_PORT = 0;
	public static final int JOYSTICK_PORT = 1;
	
	public static final int JOYBTN_A = 1;
	public static final int JOYBTN_B = 2;
	public static final int JOYBTN_X = 3;
	public static final int JOYBTN_Y = 4; 
	public static final int JOYBTN_LB = 5;
	public static final int JOYBTN_RB = 6;
	public static final int JOYBTN_RT = 6;
	public static final int JOYBTN_LT = 5;
	
	public static final int RIGHTYAXIS = 5;
	public static final int LEFTYAXIS = 1;
	
	public static final int LEFT_FRONT = 7;
	public static final int LEFT_BACK = 6;
	public static final int RIGHT_FRONT = 2;
	public static final int RIGHT_BACK = 5;

	public static final int INTAKE_LEFT = 3;
	public static final int INTAKE_RIGHT = 1;
	
	public static final int CLIMBER = 4; 
	
	public static final int LEFT_ENCODER_A = 1;
	public static final int LEFT_ENCODER_B = 2;  //THESE ARE NOT THE CORRECT PORTS
	public static final int RIGHT_ENCODER_A = 3;
	public static final int RIGHT_ENCODER_B = 4;
	
	public static final int SOLENOID_FORWARD = 0;
	public static final int SOLENOID_REVERSE = 7;
	
	public static final int LIMIT_SWITCH_CUBE_CONTROLS = 1; //port on DIO
	public static final int LIMIT_SWITH_UP_CLIMBER = 2; 
	public static final int LIMIT_SWITH_DOWN_CLIMBER = 3; 
	
	//public static int gyro;
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
