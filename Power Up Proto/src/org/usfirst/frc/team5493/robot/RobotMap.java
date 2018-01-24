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
	
	public final static int RIGHTYAXIS = 5;
	public final static int LEFTYAXIS = 1;
	
	public static int leftFront = 7;
	public static int leftBack = 6;
	public static int rightFront = 2;
	public static int rightBack = 5;

	public static int intakeLeft = 3;
	public static int intakeRight = 1;
	
	public static int climber = 4; 
	
	public static int leftEncoderA;
	public static int leftEncoderB;
	public static int rightEncoderA;
	public static int rightEncoderB;
	
	public static int solenoidForward = 1;
	public static int solenoidReverse = 9;
	
	//public static int gyro;
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
