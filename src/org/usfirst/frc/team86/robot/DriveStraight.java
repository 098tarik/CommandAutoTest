package org.usfirst.frc.team86.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveStraight implements ICommand {
	
	private final double rpm = 7.1;
	private final double circumference = 4 * Math.PI;
	
	TalonSRX leftMotor, rightMotor;
	boolean finished = true;
	double distance = 0;
	
	
	public DriveStraight(TalonSRX leftMotor, TalonSRX rightMotor, TalonSRX leftBack, TalonSRX rightBack, double distance){
		this.leftMotor = leftMotor;
		this.rightMotor = rightMotor;
		this.distance = distance;
		
		leftBack.set(ControlMode.Follower, leftMotor.getDeviceID());
        rightBack.set(ControlMode.Follower, rightMotor.getDeviceID());
    
		leftMotor.set(ControlMode.PercentOutput,0);
	    rightMotor.set(ControlMode.PercentOutput, 0);
	}
	
	@Override
	public void execute() {
		
		SmartDashboard.getBoolean("is finished?", finished);
		finished = false;
		
		double feetPerSecond = rpm * circumference / 60;
		double duration = Math.pow(feetPerSecond, -1) * distance;
		
		double time = System.currentTimeMillis();
		if(System.currentTimeMillis() - time <= duration) {
			leftMotor.set(ControlMode.PercentOutput, .2);
			rightMotor.set(ControlMode.PercentOutput, -.2);
		} else { 
			leftMotor.set(ControlMode.PercentOutput, 0);
			rightMotor.set(ControlMode.PercentOutput, 0);
			finished= true;
		}
	}

	@Override
	public boolean done() {
		return finished;
	}

}
