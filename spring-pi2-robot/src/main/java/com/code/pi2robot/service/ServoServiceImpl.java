package com.code.pi2robot.service;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.code.pi2robot.servo.Servo;


@Service
public class ServoServiceImpl implements ServoService {

	@Autowired
	Servo servo1;
	@Autowired
	Servo servo2;
	@Autowired
	Servo servo3;
	@Autowired
	Servo servo4;

	@PostConstruct
	public void loadData() {

		System.out.println("postConstructor");
		servo1.servoInit(0);
		servo2.servoInit(1);
		servo3.servoInit(2);
		servo4.servoInit(3);

	}

	@Override
	public void moveServo1() {
		servo1.moveServoTest();
		System.out.println("serwo1");
	}

	@Override
	public void moveServo2() {
		servo2.moveServoTest();
		System.out.println("serwo2");
	}

	@Override
	public void moveServo3() {
		servo3.moveServoTest();
		System.out.println("serwo3");
	}

	@Override
	public void moveServo4() {
		servo4.moveServoTest();
		System.out.println("serwo4");
	}

	@Override
	public void moveServoTo(int intPosition) {

		switch (intPosition / 100) {
		case 1:
			servo1.changeServoPosition(intPosition % 100);
			System.out.println("move to pos: " + intPosition);
			break;
		case 2:
			servo2.changeServoPosition(intPosition % 100);
			System.out.println("move to pos: " + intPosition);
			break;
		case 3:
			servo3.changeServoPosition(intPosition % 100);
			System.out.println("move to pos: " + intPosition);
			break;
		case 4:
			servo4.changeServoPosition(intPosition % 100);
			System.out.println("move to pos: " + intPosition);
			break;

		default:
			break;
		}

	}

	@Override
	public void walk(String steps) {

		int[] stepsToWalk = { 316, 20, 416, 200, 116, 20, 216, 200, 114, 20, 214, 20, 314, 20, 414, 20, 112, 20, 212,
				200, 312, 20, 412, 200, 114, 20, 214, 20, 314, 20, 414, 200 };

		int stepsInt = stringToInt(steps);

		if (stepsInt == 0)
			stepsInt = 1;

		for (int x = 0; x < stepsInt; x++) {

			for (int i = 0; i < stepsToWalk.length; i += 2) {
				moveServoTo(stepsToWalk[i]);
				System.out.print("walk step : " + stepsToWalk[i] + "  ");
				try {
					Thread.sleep(stepsToWalk[i + 1]);
					System.out.println("walk time : " + stepsToWalk[i + 1]);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void movementBySequence(String sequence) {

		String[] sequenceTab = sequence.split("!");

		for (String i : sequenceTab) {
			System.out.println(i);
		}

		for (int i = 0; i < sequenceTab.length; i += 2) {

			moveServoTo(stringToInt(sequenceTab[i]));

			System.out.println("iiii: " + i);

			try {

				Thread.sleep(stringToInt(sequenceTab[i + 1]));
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("outside the array");
			}
		}

	};

	private int stringToInt(String stingToChange) {

		int returnInt;
		try {
			returnInt = Integer.parseInt(stingToChange);
		} catch (NumberFormatException e) {
			returnInt = 0;
		}

		return returnInt;

	}
}
