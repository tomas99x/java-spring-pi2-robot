//package com.code.pi2robot.servo;
//
//
//
//import org.springframework.stereotype.Component;
//
//import com.pi4j.io.gpio.GpioController;
//import com.pi4j.io.gpio.GpioFactory;
//import com.pi4j.io.gpio.GpioPinPwmOutput;
//import com.pi4j.io.gpio.Pin;
//import com.pi4j.io.gpio.RaspiPin;
//import com.pi4j.util.CommandArgumentParser;
//
//@Component
//public class ServoInit {
//
//	private GpioPinPwmOutput pwm;
//	private GpioPinPwmOutput pwm2;
//	
//	public ServoInit() {
//		System.out.println("start servoINit");
//
//		// create Pi4J console wrapper/helper
//		// (This is a utility class to abstract some of the boilerplate code)
//
//		// create GPIO controller instance
//		GpioController gpio = GpioFactory.getInstance();
//
//		// All Raspberry Pi models support a hardware PWM pin on GPIO_01.
//		// Raspberry Pi models A+, B+, 2B, 3B also support hardware PWM pins: GPIO_23,
//		// GPIO_24, GPIO_26
//		//
//		// by default we will use gpio pin #01; however, if an argument
//		// has been provided, then lookup the pin by address
//		Pin pin = CommandArgumentParser.getPin(RaspiPin.class, // pin provider class to obtain pin instance from
//				RaspiPin.GPIO_01 // default pin if no pin argument found
//		); // argument array to search in
//
//
//
//		com.pi4j.wiringpi.Gpio.pwmSetMode(com.pi4j.wiringpi.Gpio.PWM_MODE_MS);
//		com.pi4j.wiringpi.Gpio.pwmSetClock(1000);
//		com.pi4j.wiringpi.Gpio.pwmSetRange(384);
//
//		pwm = gpio.provisionPwmOutputPin(pin);
//	}
//
//	public GpioPinPwmOutput getPwm() {
//		return pwm;
//	}
//
//	public void setPwm(GpioPinPwmOutput pwm) {
//		this.pwm = pwm;
//	}
//
//	public GpioPinPwmOutput getPwm2() {
//		return pwm2;
//	}
//
//	public void setPwm2(GpioPinPwmOutput pwm2) {
//		this.pwm2 = pwm2;
//	}
//	
//	
//}
