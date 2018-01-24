package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.Robot;
import org.usfirst.frc.team5493.robot.RobotMap;
import org.usfirst.frc.team5493.robot.commands.JoystickDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class driveBase extends Subsystem {
	double wheelDiameter = 6.0;
	
	double pulsesPerRevolution = 1440.0;
	double averageDistance;
	WPI_TalonSRX leftBackMotor;
    WPI_TalonSRX rightBackMotor; ; 
	WPI_TalonSRX rightFrontMotor;
	WPI_TalonSRX leftFrontMotor;
	private RobotDrive drive;
	private Encoder leftEncoder, rightEncoder;
	private final String DRIVE_SYSTEM = "Tank Drive System";
	private final String LEFT_FRONT = "Left Front Motor";
	
	public driveBase(){
		super();

		leftFrontMotor = new WPI_TalonSRX(RobotMap.leftFront);
		leftBackMotor = new WPI_TalonSRX(RobotMap.leftBack);
		rightFrontMotor = new WPI_TalonSRX(RobotMap.rightFront);
		rightBackMotor = new WPI_TalonSRX(RobotMap.rightBack);
		
		leftBackMotor.set(ControlMode.Follower,RobotMap.leftFront);
		rightBackMotor.set(ControlMode.Follower, RobotMap.rightFront);
		
		leftFrontMotor.configOpenloopRamp(.5,1);
		leftBackMotor.configOpenloopRamp(.5,1);
		rightFrontMotor.configOpenloopRamp(.5,1);
		rightBackMotor.configOpenloopRamp(.5,1);
		//leftEncoder = new Encoder(RobotMap.leftEncoderA, RobotMap.leftEncoderB);
		//rightEncoder = new Encoder(RobotMap.rightEncoderA,RobotMap.rightEncoderB);
		//leftBackMotor = (assigning a port on the joystick for controlling the left back motor)
		drive = new RobotDrive(leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor);
		drive.setExpiration(0.1); 
		
		//leftEncoder.setDistancePerPulse((wheelDiameter*Math.PI)/pulsesPerRevolution);
		//rightEncoder.setDistancePerPulse((wheelDiameter*Math.PI)/pulsesPerRevolution);
		
		//LiveWindow.addActuator(DRIVE_SYSTEM, LEFT_FRONT, (LiveWindowSendable) leftFrontMotor);
		//LiveWindow.addActuator("Drive Base", "Left Encoder", leftEncoder);
		//LiveWindow.addActuator("Drive Base", "Right Encoder", rightEncoder);
	}
	//public void resetEncoder(){
		//leftEncoder.reset();
		//rightEncoder.reset();
	//}
	//public double averageDistance(){
		//return Math.abs((leftEncoder.getDistance() + rightEncoder.getDistance())/2.0);
	//}

    public void initDefaultCommand() {
        setDefaultCommand(new JoystickDrive());
    }
    
    public void drive(Joystick j){
    	drive(j.getRawAxis(RobotMap.LEFTYAXIS), j.getRawAxis(RobotMap.RIGHTYAXIS));
    }
    
    public void drive(double left, double right){
    	drive.tankDrive(left, right);
    }
    
    public void driveHeading(double direction, double arc) {
    	drive.setSafetyEnabled(false);
    	//drive.tankDrive(-.6, -.6);
    	drive.drive(direction, arc);
    	drive.setSafetyEnabled(true);
    	DriverStation.getInstance().reportWarning("Drive Heading", true);
    }
    public void log(){
    	//SmartDashboard.putNumber("Left Distance", this.leftEncoder.get());
    	//SmartDashboard.putNumber("Right Distance", this.rightEncoder.get());
    }
    
    public void reset(){
    	drive(0.0, 0.0);
    }
}

//LETS WRITE SOME CODE!!!!


