package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.RobotMap;
import org.usfirst.frc.team5493.robot.commands.JoystickDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class driveBase extends Subsystem {
	double wheelDiameter = 4.0;
	
	double pulsesPerRevolution = 1440.0;
	double averageDistance;
	WPI_TalonSRX leftBackMotor;
    WPI_TalonSRX rightBackMotor;
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
		leftEncoder = new Encoder(RobotMap.leftEncoderA, RobotMap.leftEncoderB);
		rightEncoder = new Encoder(RobotMap.rightEncoderA,RobotMap.rightEncoderB);
		//leftBackMotor = (assigning a port on the joystick for controlling the left back motor)
		drive = new RobotDrive(leftFrontMotor, rightFrontMotor, leftBackMotor, rightBackMotor);
		drive.setExpiration(0.1); 
		
		double secondsFromNeutral = 0;
		int timeoutMs = 0;
		
		Preferences prefs = Preferences.getInstance();
		
		secondsFromNeutral = prefs.getDouble("RampRateDriveBase", 0.25);
		timeoutMs = prefs.getInt("RampRateDriveBaseTimeout", 1);
		
		leftFrontMotor.configOpenloopRamp(secondsFromNeutral, timeoutMs);
		rightFrontMotor.configOpenloopRamp(secondsFromNeutral, timeoutMs);
		leftBackMotor.configOpenloopRamp(secondsFromNeutral, timeoutMs);
		rightBackMotor.configOpenloopRamp(secondsFromNeutral, timeoutMs);
		
		
		
		
		leftEncoder.setDistancePerPulse((wheelDiameter*Math.PI)/pulsesPerRevolution);
		rightEncoder.setDistancePerPulse((wheelDiameter*Math.PI)/pulsesPerRevolution);
		LiveWindow.addActuator(DRIVE_SYSTEM, LEFT_FRONT, (LiveWindowSendable) leftFrontMotor);
		
		LiveWindow.addActuator("Drive Base", "Left Encoder", leftEncoder);
		LiveWindow.addActuator("Drive Base", "Right Encoder", rightEncoder);
	}
	public void resetEncoder(){
		leftEncoder.reset();
		rightEncoder.reset();
	}
	public double averageDistance(){
		return Math.abs((leftEncoder.getDistance() + rightEncoder.getDistance())/2.0);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new JoystickDrive());
    }
    
    public void drive(Joystick j){
    	drive(j.getX(), j.getY());
    }
    
    public void drive(double left, double right){
    	drive.tankDrive(left, right);
    }
    
    public void log(){
    	SmartDashboard.putNumber("Left Distance", this.leftEncoder.get());
    	SmartDashboard.putNumber("Right Distance", this.rightEncoder.get());
    }
    
    public void reset(){
    	drive(0.0, 0.0);
    }
}

//LETS WRITE SOME CODE!!!!


