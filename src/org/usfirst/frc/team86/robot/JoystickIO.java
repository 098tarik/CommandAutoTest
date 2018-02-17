package org.usfirst.frc.team86.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;

import java.util.ArrayList;

public class JoystickIO {
	// Joysticks
	public static Joystick leftJoystick = new Joystick(0);
	public static Joystick rightJoystick = new Joystick(1);
	public static Joystick coJoystick = new Joystick(2);

	// Buttons
	private static ArrayList<Button> buttons = new ArrayList<>();
	
	public static Button getCube = createButton(coJoystick,1);
	public static Button releaseCube = createButton(coJoystick,6);
	
//	public static Button exchange = createButton(coJoystick, 2);
	public static Button switchHeight = createButton(coJoystick, 3);
	public static Button scaleLow = createButton(coJoystick, 4);
	public static Button scaleHigh = createButton(coJoystick, 5);
	
	public static Button jogArmUp = createButton(coJoystick, 6);
	public static Button jogArmDown = createButton(coJoystick, 7);
	
	public static Button shiftGearDown = createButton(coJoystick, 8);
	public static Button shiftGearUp = createButton(coJoystick, 9);
	
	// test buttons
	public static Button testFlippers = createButton(rightJoystick, 2);
	public static Button testClaw = createButton(rightJoystick, 3);
	public static Button testGearShiftUp = createButton(rightJoystick, 4);
	public static Button testGearShiftDown = createButton(rightJoystick, 5);
	
	public static Button testRollers = createButton(leftJoystick, 3);
	
	
	public static void update() {
		for (Button b : buttons) {
			b.update();
		}
	}

	private static Button createButton(GenericHID stick, int button) {
		Button newButton = new Button(stick, button);
		buttons.add(newButton);
		return newButton;
	}
}
