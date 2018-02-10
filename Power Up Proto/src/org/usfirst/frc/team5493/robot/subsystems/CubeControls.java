package org.usfirst.frc.team5493.robot.subsystems;

import org.usfirst.frc.team5493.robot.Robot;
import org.usfirst.frc.team5493.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeControls extends Subsystem {

	private WPI_TalonSRX leftIntakeMotor;
	private WPI_TalonSRX rightIntakeMotor;
	private double intakeSpeed;
	// private RobotDrive intake;
	private double outtakeSpeed;

	public CubeControls() {
		super();

		leftIntakeMotor = new WPI_TalonSRX(RobotMap.INTAKE_LEFT);
		rightIntakeMotor = new WPI_TalonSRX(RobotMap.INTAKE_RIGHT);

		rightIntakeMotor.set(ControlMode.Follower, RobotMap.INTAKE_LEFT);

		double secondsFromNeutral = 0;
		int timeoutMs = 0;

		Preferences prefs = Preferences.getInstance();

		secondsFromNeutral = prefs.getDouble("RampRateCube", 0.25);
		timeoutMs = prefs.getInt("RampRateCubeTimeout", 1);
		intakeSpeed = prefs.getDouble("IntakeSpeed", 0.5);
		outtakeSpeed = prefs.getDouble("OuttakeSpeed", -0.5);

		leftIntakeMotor.configOpenloopRamp(secondsFromNeutral, timeoutMs);
		rightIntakeMotor.configOpenloopRamp(secondsFromNeutral, timeoutMs);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void intake() {
		Robot.cubeControls.leftIntakeMotor.set(-intakeSpeed);
		Robot.cubeControls.rightIntakeMotor.set(intakeSpeed);
	}

	public void outtake() {
		Robot.cubeControls.leftIntakeMotor.set(outtakeSpeed);
		Robot.cubeControls.rightIntakeMotor.set(-outtakeSpeed);
	}

	public void end() {
		Robot.cubeControls.leftIntakeMotor.set(0.0);
		Robot.cubeControls.rightIntakeMotor.set(0.0);
	}
}
