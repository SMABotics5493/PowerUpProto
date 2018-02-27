package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.Robot;
import org.usfirst.frc.team5493.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Cascade extends Subsystem {

	//TODO: Hold can be removed when PID is integrated.
	
	//Encoder numbers to be added
	//Encoder A Channel -> DIO 1, Module 1;
	
	//private Encoder encoder = new Encoder(1, 2, false, EncodingType.k2X);
	
	
	private WPI_TalonSRX climbMotor;

	private double downSpeed;
	private double upSpeed;
//	private DigitalInput climbuplimitSwitch = new DigitalInput(RobotMap.LIMIT_SWITH_UP_CLIMBER);
//	private Counter climbupCounter = new Counter(climbuplimitSwitch);
//	private DigitalInput climbdownlimitSwitch = new DigitalInput(RobotMap.LIMIT_SWITH_DOWN_CLIMBER);
//	private Counter climbdownCounter = new Counter(climbdownlimitSwitch);
	
	public static final double kDistancePerRevolution = 18.84;
	public static final double kPulsesPerRevolution = 1024;
	public static final double kDistancePerPulse = kDistancePerRevolution / kPulsesPerRevolution;


	public Cascade() {
		super();

		climbMotor = new WPI_TalonSRX(RobotMap.CASCADE);
		// Put methods for controlling this subsystem
		// here. Call these from Commands.
		double secondsFromNeutral = 0;
		int timeoutMs = 0;

		Preferences prefs = Preferences.getInstance();

		secondsFromNeutral = prefs.getDouble("RampRateClimber", 0.25);
		upSpeed = prefs.getDouble("ClimberUpSpeed", 1);
		downSpeed = prefs.getDouble("ClimberDownSpeed", -0.4);
		timeoutMs = prefs.getInt("RampRateClimberTimeout", 1);

		climbMotor.configOpenloopRamp(secondsFromNeutral, timeoutMs);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void robotInit() {
		//encoder.setDistancePerPulse(kDistancePerPulse);
		
		//encoder.start();
		
		resetEncoders();
	}

	public void climbUp() {
		Robot.cascade.climbMotor.set(upSpeed);
	}

	public void climbDown() {
		Robot.cascade.climbMotor.set(downSpeed);
	}

	public void end() {
		Robot.cascade.climbMotor.set(0.0);
	}

//	public void initializeCounterUp() {
//		climbupCounter.reset();
//	}
//
//	public void initializeCounterDown() {
//		climbdownCounter.reset();
//	}
//
//	public boolean hasClimbedUp() {
//		return climbupCounter.get() > 0;
//	}
//
//	public boolean hasClimbedDown() {
//		return climbdownCounter.get() > 0;
//	}
    private void resetEncoders() {
    	//encoder.reset();
    }
}
