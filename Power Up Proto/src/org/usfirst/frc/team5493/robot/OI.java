package org.usfirst.frc.team5493.robot;

import org.usfirst.frc.team5493.robot.commands.CascadeBySpeed;
import org.usfirst.frc.team5493.robot.commands.CascadeDown;
import org.usfirst.frc.team5493.robot.commands.CascadeUp;
import org.usfirst.frc.team5493.robot.commands.ClimbDown;
import org.usfirst.frc.team5493.robot.commands.ClimbUp;
import org.usfirst.frc.team5493.robot.commands.CubeIntake;
import org.usfirst.frc.team5493.robot.commands.CubeOuttake;
import org.usfirst.frc.team5493.robot.commands.EndForward;
import org.usfirst.frc.team5493.robot.commands.EndReverse;
import org.usfirst.frc.team5493.robot.commands.EndgameRaise;
import org.usfirst.frc.team5493.robot.commands.TiltyBoiDown;
import org.usfirst.frc.team5493.robot.commands.TiltyBoiUp;
import org.usfirst.frc.team5493.robot.commands.TransmissionForward;
import org.usfirst.frc.team5493.robot.commands.TransmissionReverse;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * Test a build trigger.
 */
public class OI {

	private Joystick driveJoystick = new Joystick(RobotMap.JOYSTICK_DRIVE_PORT);
	private Joystick joystick = new Joystick(RobotMap.JOYSTICK_PORT);
	// DriverStation ds = DriverStation.getInstance();

	JoystickButton cubeIntake = new JoystickButton(joystick, RobotMap.JOYBTN_LB);
	JoystickButton cubeOuttake = new JoystickButton(joystick, RobotMap.JOYBTN_RB);
	//JoystickButton cascadeLock = new JoystickButton(joystick, RobotMap.CASCADE_LOCK);
	//JoystickButton cascadeSpeed = new JoystickButton(joystick, RobotMap.CASCADE_JOYSTICK);
	JoystickButton solenoidForward = new JoystickButton(driveJoystick, RobotMap.JOYBTN_Y);
	JoystickButton solenoidReverse = new JoystickButton(driveJoystick, RobotMap.JOYBTN_A);
	JoystickButton tiltyBoiUp = new JoystickButton(driveJoystick, RobotMap.JOYBTN_LB);
	JoystickButton tiltyBoiDown = new JoystickButton(driveJoystick, RobotMap.JOYBTN_RB);
	JoystickButton pullUp = new JoystickButton(joystick, RobotMap.JOYBTN_X);
	JoystickButton pullDown = new JoystickButton(joystick, RobotMap.JOYBTN_B);
	JoystickButton solenoidEndForward = new JoystickButton(driveJoystick, RobotMap.JOYBTN_X);
	JoystickButton solenoidEndReverse = new JoystickButton(driveJoystick, RobotMap.JOYBTN_B);
	JoystickButton endgameRelease = new JoystickButton(joystick, RobotMap.JOYBTN_START);
	JoystickButton cascadeUp = new JoystickButton(joystick, RobotMap.JOYBTN_Y);
	JoystickButton cascadeDown = new JoystickButton(joystick, RobotMap.JOYBTN_A);

	public Joystick getDriveJoystick() {
		return driveJoystick;
	}

	public Joystick getJoystick() {
		return joystick;
	}

	public OI() {

		//cascadeSpeed.whileActive(new CascadeBySpeed(cascadeLock));
		//cascadeLock.whileActive(new CascadeBySpeed(cascadeLock));
		cubeIntake.whileHeld(new CubeIntake(cubeIntake));
		cubeOuttake.whileHeld(new CubeOuttake(cubeOuttake));
		solenoidForward.whenPressed(new TransmissionForward());
		solenoidReverse.whenPressed(new TransmissionReverse());
		pullUp.whileHeld(new ClimbUp(pullUp));
		pullDown.whileHeld(new ClimbDown(pullDown));
		tiltyBoiUp.whileHeld(new TiltyBoiUp());
		tiltyBoiDown.whileHeld(new TiltyBoiDown());
		solenoidEndForward.whenPressed(new EndForward());
		solenoidEndReverse.whenPressed(new EndReverse());
		endgameRelease.whileHeld(new EndgameRaise());
		cascadeUp.whileHeld(new CascadeUp(cascadeUp));
		cascadeDown.whileHeld(new CascadeDown(cascadeDown));

	}

}
