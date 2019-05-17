package com.code.pi2robot.servo;


public interface Servo {
	
	public void servoInit(int pinIn);
	
	public void changeServoPosition(int nextPosition) ;
	
	public void moveServoTest() ;

}
