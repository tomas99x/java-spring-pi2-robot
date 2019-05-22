package com.code.pi2robot.service;

public interface ServoService {

	public void walk(String steps);
	
	public void moveServo1();
	
	public void moveServo2();
	
	public void moveServo3();
	
	public void moveServo4();
	
	public void moveServoTo(int intPosition);

	public void movementBySequence(String sequence);
}
