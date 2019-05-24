package com.code.pi2robot.servo;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.SoftPwm;

//@Primary
@Component
@Scope("prototype")
public class ServoImpl implements Servo {

	private int PIN_NUMBER;
	private final static int minPosition = 4;
	private final static int maxPosition = 24;
	private final static int midPositon = 14;
	private int currPosition = 10;

	@Override
	public void servoInit(int pinIn) {
		System.out.println("start servoINit: " + pinIn);
		Gpio.wiringPiSetup();
		PIN_NUMBER = pinIn;
		SoftPwm.softPwmCreate(PIN_NUMBER, 4, 100);
		SoftPwm.softPwmWrite(PIN_NUMBER, midPositon);

	}

	private void currentPosition(int nextPosition) {
		currPosition = nextPosition;
		SoftPwm.softPwmWrite(PIN_NUMBER, currPosition);
	}

	@Override
	public void changeServoPosition(int nextPosition) {
		if (nextPosition != currPosition && nextPosition >= minPosition && nextPosition <= maxPosition) {
			currentPosition(nextPosition);
		}

	}

	@Override
	public void moveServoTest() {
		for (int x = 0; x < 1; x++) {
			for (int i = minPosition; i <= maxPosition; i++) {
				System.out.println("p1");
				currentPosition(i);

				System.out.println("PWM rate is: " + i);

				try {
					Thread.sleep(1120);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		currentPosition(midPositon);
		System.out.println("PWM: " + PIN_NUMBER);
	}

}
