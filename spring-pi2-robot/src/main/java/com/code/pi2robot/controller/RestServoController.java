package com.code.pi2robot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.code.pi2robot.entity.StepsNumber;
import com.code.pi2robot.service.ServoService;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

@RestController
public class RestServoController {

	@Autowired
	ServoService servoService;

	public static GpioPinDigitalOutput pin;

	/*
	 * ModelAndView mavIndex = new ModelAndView("index"); // Goruntulenecek sayfanin
	 * adi (view page name)
	 * 
	 * 
	 * 
	 * @RequestMapping(value = "/") public ModelAndView index(Principal principal) {
	 * String user = principal.getName(); // Login olan kullanicinin username'i |
	 * Username of the login user mavIndex.addObject("principal", user); return
	 * mavIndex; }
	 */

	@GetMapping("/light")
	public String light() {

		if (pin == null) {
			GpioController gpio = GpioFactory.getInstance();
			pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "My LED", PinState.LOW);
		}
		pin.toggle();
		System.out.println("światło");
		return "Response from light!!";
	}

	@GetMapping("/servo1")
	public String TestServo1() {

		servoService.moveServo1();
		return "servo on!!";

	}

	@GetMapping("/servo2")
	public String TestServo2() {

		servoService.moveServo2();
		return "servo2 on!!";

	}

	@GetMapping("/servo3")
	public String TestServo3() {

		servoService.moveServo3();
		return "servo3 on!!";

	}

	@GetMapping("/servo4")
	public String TestServo4() {

		servoService.moveServo4();
		return "servo4 on!!";

	}

	@GetMapping("/test/{intPosition}")
	public String getStudents(@PathVariable int intPosition) {

		servoService.moveServoTo(intPosition);
		return "move to position" + intPosition;

	}

	@PostMapping({ "/walk" })
	public String walk(@RequestBody StepsNumber theStepsNumber) {

		servoService.walk(theStepsNumber.getStepsNumber());

		System.out.println("Steps from walk:" + theStepsNumber.getStepsNumber());

		return "I am walking!!";

	}

	@GetMapping("/sequent/{sequence}")
	public String sequentToMove(@PathVariable String sequence) {

		System.out.println("sequence is: " + sequence);
		servoService.movementBySequence(sequence);
		return "sequent ready";

	}

}