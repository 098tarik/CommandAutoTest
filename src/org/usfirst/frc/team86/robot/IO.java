package org.usfirst.frc.team86.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class IO {
	public static Solenoid flippers = new Solenoid(1, 1);
	public static Solenoid claw = new Solenoid(1,0);
	public static Solenoid gearShifter = new Solenoid(1,2);
	
	public static VictorSP rightIntake = new VictorSP(0);
	public static VictorSP leftIntake = new VictorSP(1);
	
	public static InvertibleDigitalInput rollersFullyIn = new InvertibleDigitalInput(2, true);
	public static InvertibleDigitalInput cubeFullyIn = new InvertibleDigitalInput(1, true);
	public static InvertibleDigitalInput armBottomSwitch = new InvertibleDigitalInput(0, false);
	
	public static Joystick coJoystick = new Joystick(0);
	public static Button rotateButton = new JoystickButton(coJoystick, 1);
	public static Button resetButton = new JoystickButton(coJoystick, 2);
	public static Button drive1 = new JoystickButton(coJoystick,3);

	
	
	public static TalonSRX armMotor = new TalonSRX(58);
	
	public static TalonSRX leftFront = new TalonSRX(57);
	public static TalonSRX leftBack = new TalonSRX(55);
	public static TalonSRX rightFront = new TalonSRX(56);
	public static TalonSRX rightBack = new TalonSRX(59);
	
	public static Compressor compressor = new Compressor(1);
	public static Relay compressorRelay = new Relay(0);
	public static PowerDistributionPanel pdp = new PowerDistributionPanel(0);
	
}
