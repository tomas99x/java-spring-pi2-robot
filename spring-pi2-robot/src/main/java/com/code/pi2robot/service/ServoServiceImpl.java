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
			break;
		case 2:
			servo2.changeServoPosition(intPosition % 100);
			break;
		case 3:
			servo3.changeServoPosition(intPosition % 100);
			break;
		case 4:
			servo4.changeServoPosition(intPosition % 100);
			break;

		default:
			break;
		}

		// servo4.changeServoPosition(testInt%100);
		System.out.println("testowy int: " + intPosition % 100);
		
	}
	
	@Override
	public void walking() {

		servo1.changeServoPosition(10);
		
		servo2.changeServoPosition(10);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		servo3.changeServoPosition(10);

		servo4.changeServoPosition(10);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		servo4.changeServoPosition(14);
		
		servo3.changeServoPosition(14);
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		servo1.changeServoPosition(14);

		servo2.changeServoPosition(14);
		
	}

}
