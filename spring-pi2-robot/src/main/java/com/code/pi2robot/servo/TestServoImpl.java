package com.code.pi2robot.servo;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Primary
@Component
@Scope("prototype")
public class TestServoImpl implements Servo {

	// private int PIN_NUMBER;
	private final static int minPosition = 4;
	private final static int maxPosition = 24;
	private final static int midPositon = 14;
	private int currPosition = 10;
	private String servoName;

	@Override
	public void servoInit(int pinIn) {

		System.out.println("start servoINit: " + pinIn);

		currPosition = midPositon;

		switch (pinIn) {
		case 0:
			servoName = "servo1";
			break;
		case 1:
			servoName = "servo2";
			break;
		case 2:
			servoName = "servo3";
			break;
		case 3:
			servoName = "servo4";
			break;

		default:
			break;
		}

		System.out.println("Pin and positon: " + servoName + " , " + currPosition);

	}

	@Override
	public void changeServoPosition(int nextPosition) {

		currPosition = nextPosition;

		System.out.println("Pin and positon from changeServoPosition: " + servoName + " , " + currPosition);

	}

	@Override
	public void moveServoTest() {

		for (int x = 0; x < 1; x++) {
			for (int i = minPosition; i <= maxPosition; i++) {

				currPosition = i;
				System.out.println("Pin and positon from moveServoTest in loop: " + servoName + " , " + currPosition);

				try {
					Thread.sleep(1120);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		currPosition = midPositon;
		System.out.println("Pin and positon from moveServoTest: " + servoName + " , " + currPosition);

	}

}
