package org.usfirst.frc.team86.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoMode implements ICommand {
	
	ICommand[] _commands; // stores all of the commands passed into the constructor
	
	int _state = 0; // stores the state of the state machine
	boolean _done = false; // stores whether the whole autonomous routine is done
	
	int index = 0;
	
	public AutoMode(ICommand...commands) {
		_commands = commands;
	}

	@Override
	public void execute() {
		
		SmartDashboard.putNumber("index", index);
		SmartDashboard.getBoolean("is autonomous done?", _done);
		_done = false;
		
		while (index < _commands.length){
			if (!_commands[index].done())
				_commands[index].execute();
			else
				index++;
		}
		
		if (index == _commands.length - 1){ _done = true; }
	}

	@Override
	public boolean done() {
		return _done;
	}

}
