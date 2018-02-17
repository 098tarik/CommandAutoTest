package org.usfirst.frc.team86.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurnTo implements ICommand {
	
	private boolean _finished = true;
	
	private NavX talonGyro = new NavX();
	private double targetAngle;
	
	private TalonSRX leftMotor, rightMotor;
	
	// PID constants
	private double kP = 1/360; // Proportional constant
	private double kI = 0.0; // Integral constant
	private double kD = 0.0; // Derivative constant
	private double kF = 0.0; // Feed Forward constant
	private double tolerance  = 1; // Tolerance for the gyro angle
	private double maxOutput = 1; // Maximum power output for drive motors
	
	// PID variables
	private double error = 0.0; // The current error
	private double prevError = 0.0; // The error from the previous loop
	private double integral = 0.0; // Error integrated over time
	
	public TurnTo(TalonSRX leftMotor, TalonSRX rightMotor, TalonSRX rightBack, TalonSRX leftBack, double targetAngle) {
		this.leftMotor = leftMotor;
		this.rightMotor = rightMotor;
		this.targetAngle = targetAngle;
		
		leftBack.set(ControlMode.Follower, leftMotor.getDeviceID());
        rightBack.set(ControlMode.Follower, rightMotor.getDeviceID());
    
		leftMotor.set(ControlMode.PercentOutput,0);
	    rightMotor.set(ControlMode.PercentOutput, 0);
	}
	
	@Override
	public void execute() {
		SmartDashboard.putNumber("gyro", talonGyro.getNormalizedAngle());
		SmartDashboard.putNumber("target angle", targetAngle);
		SmartDashboard.getBoolean("is finished", _finished);
		
	
		
		error = (targetAngle - talonGyro.getNormalizedAngle())*1.0/360.0;
		
		SmartDashboard.putNumber("error", error);
//		if (Math.abs(error) > 180) { 
//			if (error > 0) // if target angle is larger than current angle, subtract 360
//				error = error - 360;
//			else // if target angle is smaller than current angle, add 360
//			    error = error + 360;
//		}
//		
//		//PID
//		double result = (kP * error) + (kI * integral) + (kD * (error - prevError));
//        if (result > 0) {
//        	result += kF;
//        } else {
//        	result -= kF;
//        }
//       	prevError = error;
//       	
//        if (result > maxOutput) {
//          result = 1;
//        } else if (result < -maxOutput) {
//          result = -1;
//        }
   
        // result is the power for the turning
        leftMotor.set(ControlMode.PercentOutput, error);
        rightMotor.set(ControlMode.PercentOutput, -error);
        
       // if(Math.abs(talonGyro.getNormalizedAngle() - targetAngle) < 1) _finished = true;
		
	}

	@Override
	public boolean done() {
		return _finished;
	}
}
