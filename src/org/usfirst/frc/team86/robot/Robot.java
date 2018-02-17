package org.usfirst.frc.team86.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	NavX gyro = new NavX();
	TankGyro tankgyro;
	TurnTo gyroturn;
	DriveStraight drive;
	
	@Override
	public void robotInit() {
		
		IO.leftFront.setInverted(false);
		IO.leftBack.setInverted(false);
		IO.rightFront.setInverted(true);
		IO.rightBack.setInverted(true);
		
		IO.leftFront.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		IO.leftBack.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		IO.rightFront.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		IO.rightBack.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		
		IO.leftFront.setSensorPhase(false);
		IO.leftBack.setSensorPhase(false);
		IO.rightFront.setSensorPhase(false);
		IO.rightBack.setSensorPhase(false);
		
		IO.leftBack.set(ControlMode.Follower, IO.leftFront.getDeviceID());
		IO.rightBack.set(ControlMode.Follower, IO.rightFront.getDeviceID());
		
	}
	
	@Override
	public void autonomousInit() {
		gyro.reset();
		drive = new DriveStraight(IO.leftFront,IO.rightFront, 1);
		gyroturn = new TurnTo(IO.leftFront, IO.rightFront, IO.leftBack, IO.rightBack, 90);
//	    tankgyro = new TankGyro(IO.leftFront, IO.leftBack, IO.rightFront, IO.rightBack);
//	    tankgyro.turnToAngle(targetAngle);
		
		
//		String gameData = DriverStation.getInstance().getGameSpecificMessage();
//		double robotPosition = SmartDashboard.getNumber("RobotPosistion(0,1,2,3)", 0);
//		
//		int home  = gameData.charAt(0)=='L'?0:1; 
//		int scale = gameData.charAt(1)=='L'?0:1;
//		
//		SmartDashboard.putNumber("home", home);
//		SmartDashboard.putNumber("scale", scale);
	}

	@Override
	public void autonomousPeriodic() {
	//	while(drive.done() == false) {
	//		drive.execute();
	//	}
//		
		gyroturn.execute();
//	tankgyro.updateGyro();
//		if(IO.drive1.equals(true)){
//			drive.execute();
//		}
//		SmartDashboard.putNumber("angle",gyro.getNormalizedAngle());
//		tankgyro.updateGyro();
	}
	
	@Override
	public void teleopPeriodic() {
		
		
		IO.compressorRelay.set(IO.compressor.enabled() ? Relay.Value.kOn : Relay.Value.kOff);
		JoystickIO.update();
		Time.update();
		
		IO.leftFront.set(ControlMode.PercentOutput, -1 * JoystickIO.leftJoystick.getY());
		IO.rightFront.set(ControlMode.PercentOutput, -1 * JoystickIO.rightJoystick.getY());
		
		SmartDashboard.putNumber("Left Front Velocity", IO.leftFront.getSelectedSensorVelocity(0));
		SmartDashboard.putNumber("Left Back Velocity", IO.leftBack.getSelectedSensorVelocity(0));
		SmartDashboard.putNumber("Right Front Velocity", IO.rightFront.getSelectedSensorVelocity(0));
		SmartDashboard.putNumber("Right Back Velocity", IO.rightBack.getSelectedSensorVelocity(0));
		
		if (JoystickIO.testGearShiftUp.onButtonPressed()) {
			IO.gearShifter.set(true);
		} else if (JoystickIO.testGearShiftDown.onButtonPressed()) {
			IO.gearShifter.set(false);
		}
		
	}
}

