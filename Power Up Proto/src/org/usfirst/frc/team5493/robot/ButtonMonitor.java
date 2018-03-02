package org.usfirst.frc.team5493.robot;

import edu.wpi.first.wpilibj.buttons.Button;

public class ButtonMonitor {
	
	public enum ButtonState {
		Active,
		Inactive,

		NeverActive,
	}

	private Button _button;
	private ButtonState _state;

	public ButtonMonitor(Button buttonToMonitor) {
		_button = buttonToMonitor;
		_state = ButtonState.NeverActive;
	}
	
	public ButtonState checkButtonState(){
		
		
		if(_button.get()) {
			_state = ButtonState.Active;
		}
		else if (!_button.get() && _state == ButtonState.Active) {
			_state = ButtonState.Inactive;
		}
		return _state;
		
	}
}
