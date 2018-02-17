package org.usfirst.frc.team86.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Auto {
	AutoMode _autoMode;
	TalonSRX leftMotor, rightMotor;

	// 0- far left, 1- off left, 2- off right, 3- far right
	
//	String gameData = DriverStation.getInstance().getGameSpecificMessage();
//	double robotPosition = SmartDashboard.getNumber("RobotPosistion(0,1,2,3)", 0);
//	
//	char switchPosition = gameData.charAt(0);
//	char scalePosition  = gameData.charAt(1);
	
	public Auto(double robotPosition, char switchPosition, char scalePosition) {
		String mode = String.valueOf(robotPosition) + switchPosition + scalePosition;
		
		SmartDashboard.putNumber("switch", switchPosition);
		SmartDashboard.putNumber("scale", scalePosition);
	
		switch(mode){
			case "0ll":
			//	_autoMode = new AutoMode(new DriveStraight(leftMotor,rightMotor, 18), new TurnTo(leftMotor, leftMotor, 90));
				break;
			case "0lr":
				_autoMode = new AutoMode();
				break;
			case "0rl":
				_autoMode = new AutoMode();
				break;
			case "0rr":
				_autoMode = new AutoMode();
				break;
			case "1ll":
				_autoMode = new AutoMode();
				break;
			case "1lr":
				_autoMode = new AutoMode();
				break;
			case "1rl":
				_autoMode = new AutoMode();
				break;
			case "1rr":
				_autoMode = new AutoMode();
				break;
			case "2ll":
				_autoMode = new AutoMode();
				break;
			case "2lr":
				_autoMode = new AutoMode();
				break;
			case "2rl":
				_autoMode = new AutoMode();
				break;
			case "2rr":
				_autoMode = new AutoMode();
				break;
			case "3ll":
				_autoMode = new AutoMode();
				break;
			case "3lr":
				_autoMode = new AutoMode();
				break;
			case "3rl":
				_autoMode = new AutoMode();
				break;
			case "3rr":
				_autoMode = new AutoMode();
				break;
		}
	}
	
	public void update() {
		_autoMode.execute();
	}
	
}
