//package org.usfirst.frc.team5493.robot.subsystems;
//
//import org.usfirst.frc.team5493.robot.Robot;
//import org.usfirst.frc.team5493.robot.RobotMap;
//
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//
//import edu.wpi.first.wpilibj.CounterBase.EncodingType;
//import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.command.Subsystem;
//
///**
// *
// */
//public class OldOneClimbyBoi extends Subsystem {
//
//	public WPI_TalonSRX climbMotor;
//	public Object climbDown;
//	
//	
//	//Encoder numbers to be added
//	//Encoder A Channel -> DIO 1, Module 1;
//	
//	//private Encoder encoder = new Encoder(1, 2, false, EncodingType.k2X);
//	
//	
//	public void robotInit() {
//		//encoder.setDistancePerPulse(kDistancePerPulse);
//		
//		//encoder.start();
//		
//		resetEncoders();
//	}
//	
//	public OldOneClimbyBoi() {
//	super();
//	
//	climbMotor = new WPI_TalonSRX(RobotMap.CASCADE);
//    
//	 }
//    public void initDefaultCommand() {
//        
//    }
//    public void climbUp() {
//    	Robot.climber.climbMotor.set(0.8);
//    }
//    public void climbDown(){
//    	Robot.climber.climbMotor.set(-0.4);
//    }
//    public void climbHold(){
//    	Robot.climber.climbMotor.set(0.1);
//    }
//    public void end(){
//    	Robot.climber.climbMotor.set(0.1);
//    }
//    
//    //private double getAverageEncoderPosition() {
//    	//return (encoder.getDistance()) / 2;
//
//    //}
//    
//    private void resetEncoders() {
//    	//encoder.reset();
//    }
//    
//}
//
