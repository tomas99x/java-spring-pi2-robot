<h1>Raspberry Pi 2 mini robot w Java Spring</h1>

Koncepcją było napisanie prostego robota opartego na minikomputerze Raspberry Pi wykonującego kilka podstawowych czynności, składającego się  z 4 serwomechanizmów imitujących nogi .

<h3>Użyte technologie:</h3>
<ul>
  <li>Java Spring MVC, Boot, Rest</li>
  <li>Maven</li>
  <li>pi4j</li>
</ul>


<h3>Pakiety i klasy</h3>
+ <b>com.code.pi2robot</b>
<br />
++ <b>AppConfig.java</b> – klasa konfiguracyjna Spring Boot
<br /><br />
+ <b>com.code.pi2robot.controller</b>
<br />
++ <b>RestServoController.java</b> – kontroler obsługujący zapytania rest
<br /><br />
+ <b>com.code.pi2robot.service</b> – pakiet przechowujący logikę działania serwomechanizmów
<br />
++ <b>ServoService.java</b> – serwis interfejs
<br />
++ <b>ServoServiceImpl.java</b> – implementacja serwisu
<br /><br />
+ <b>com.code.pi2robot.servo</b>
<br />
++ <b>Servo.java</b> – interfejs serwomechanizmu
<br />
++ <b>ServoImpl.java</b> – implementacja serwomechanizmu
<br />
++ <b>TestServoImpl.java </b> – implementacja testowego serwomechanizmu, wykorzystywana do testów na komputerze PC, nie wtedy potrzeby wgrywania projektu na Raspberry Pi, co oszczędza czas
