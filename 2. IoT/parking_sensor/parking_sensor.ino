// Ultrasonic - Library for HR-SC04 Ultrasonic Ranging Module.
// Rev.4 (06/2012)
// J.Rodrigo ( www.jrodrigo.net )
// more info at www.ardublog.com

#include <Ultrasonic.h>

int distance = 0;
int interval = 20;
int beep = 0;

Ultrasonic ultrasonic(12,13); // (Trig PIN,Echo PIN)

void setup() {
  Serial.begin(9600); 
}

void loop()
{
  distance = ultrasonic.Ranging(CM);
  Serial.print(distance); // CM or INC
  Serial.println(" cm" );
  beep = distance*interval;
  Serial.println(beep);
  analogWrite(3, 125);
  delay(beep);
  analogWrite(3, 255);
  delay(beep);
}
