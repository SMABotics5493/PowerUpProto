package org.usfirst.frc.team5493.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public final static int Joystick_Drive_Port = 0;
	public final static int Joystick_Port = 1;
	
	public final static int JOYBTN_A = 1;
	public final static int JOYBTN_B = 2;
	public final static int JOYBTN_X = 3;
	public final static int JOYBTN_Y = 4; 
	public final static int JOYBTN_LB = 5;
	public final static int JOYBTN_RB = 6;
	public final static int JOYBTN_LT = 1;
	public final static int JOYBTN_RT = 5;
	
	public static int leftFront;
	public static int leftBack;
	public static int rightFront;
	public static int rightBack;

	public static int intakeLeft;
	public static int intakeRight;
	
	public static int climber; 
	
	public static int leftEncoderA;
	public static int leftEncoderB;
	public static int rightEncoderA;
	public static int rightEncoderB;
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
