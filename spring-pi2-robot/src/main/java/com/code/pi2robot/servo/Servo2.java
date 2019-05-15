package com.code.pi2robot.servo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.util.CommandArgumentParser;

@Component

public class Servo2 {

	private GpioPinPwmOutput pwm;

	public Servo2() {
		System.out.println("start servo constructor");
	}

	public void servoInit(Pin pinIn) {
		System.out.println("start servoINit");

		// create Pi4J console wrapper/helper
		// (This is a utility class to abstract some of the boilerplate code)

		// create GPIO controller instance
		GpioController gpio = GpioFactory.getInstance();

		// All Raspberry Pi models support a hardware PWM pin on GPIO_01.
		// Raspberry Pi models A+, B+, 2B, 3B also support hardware PWM pins: GPIO_23,
		// GPIO_24, GPIO_26
		//
		// by default we will use gpio pin #01; however, if an argument
		// has been provided, then lookup the pin by address
		Pin pin = CommandArgumentParser.getPin(RaspiPin.class, // pin provider class to obtain pin instance from
				pinIn // default pin if no pin argument found
		); // argument array to search in

		pwm = gpio.provisionPwmOutputPin(pin);

		com.pi4j.wiringpi.Gpio.pwmSetMode(com.pi4j.wiringpi.Gpio.PWM_MODE_MS);
		com.pi4j.wiringpi.Gpio.pwmSetClock(1000);
		com.pi4j.wiringpi.Gpio.pwmSetRange(384);

	}

	public void moveServo() {
		for (int x = 0; x < 1; x++) {
			for (int i = 14; i < 44; i++) {
				System.out.println("p1");
				pwm.setPwm(i);
				System.out.println("PWM rate is: " + pwm.getPwm());

				try {
					Thread.sleep(120);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void moveToPos(int pos, int time) {
		time = 100;
		int currentPos = pwm.getPwm();
	}
}
