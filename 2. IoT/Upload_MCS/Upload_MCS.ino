// DHT
#include "dht.h"
#define dht_dpin 2      
  
dht DHT;

// WIFI
#include <LWiFi.h>
#include "MCS.h"

char _lwifi_ssid[] = "";
char _lwifi_pass[] = "";
MCSDevice mcs("DeviceId", "DeviceKey");

MCSDisplayFloat Temp("Temperature");
MCSDisplayFloat Humi("Humidity");
void setup()
{
  Serial.begin(9600);

  mcs.addChannel(Temp);
  mcs.addChannel(Humi);
  Serial.println("WIFI start to connect");
  while (WiFi.begin(_lwifi_ssid, _lwifi_pass) != WL_CONNECTED) { delay(1000); }
  Serial.println("WIFI successfully connected");
  Serial.println("MCS start to connect");
  Serial.println("MCS successfully connected");while(!mcs.connected()) { mcs.connect(); }
  Serial.begin(9600);
}

void loop()
{
  
  while (!mcs.connected()) {
  mcs.connect();
  if (mcs.connected()) { Serial.println("MCS has reconnected"); }
  }
  mcs.process(100);
  DHT.read11(dht_dpin);
  float temperature = DHT.temperature;
  float humidity = DHT.humidity;
  Serial.println(temperature);    
  Serial.println(humidity); 
  Temp.set(temperature);
  Humi.set(humidity);
  delay(5000);
}
