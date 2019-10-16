// Example testing sketch for various DHT humidity/temperature sensors
// Written by ladyada, public domain
#include <LWiFi.h>
#include <MQTT.h>
#include "DHT.h"
#define DHTPIN A0     // what pin we're connected to
#define DHTTYPE DHT11   // DHT 11 

char ssid[] = "MCS";
char password[] = "ilovemcs";
char mqtt_server[] = "140.116.72.90";
char pub_topic[] = "postHT/Team5";
char client_Id[] = "";

DHT dht(DHTPIN, DHTTYPE);
String msgStr = "";
char json[79];

WiFiClient mtclient;
MQTTClient client;

void setup()
{
  Serial.begin(9600);
  WiFi.begin(ssid, password);
  client.begin(mqtt_server, mtclient);
  connect();
  dht.begin();
}

void loop()
{
  client.loop();
  delay(10);  // <- fixes some issues with WiFi stability
  if (!client.connected()) {
    connect();
  }

  float h = dht.readHumidity();
  float t = dht.readTemperature();


  if (isnan(t) || isnan(h))
  {
    Serial.println("Failed to read from DHT");
  }
  else
  {
    msgStr = "";
    msgStr = msgStr + "{\"DeviceID\":\"Team5\",\"Humidity\" :" + h + ",\"Temperature\" :" + t + "}";
    msgStr.toCharArray(json, 90);
    Serial.print("Publish message: ");
    Serial.println(json);
    client.publish(pub_topic, json);
    delay(1000);
  }
}


void connect() {
  Serial.print("checking wifi...");
  while (WiFi.status() != WL_CONNECTED) {
    Serial.print(".");
    delay(1000);
  }

  Serial.print("\nconnecting...");
  String clientId = client_Id;
  clientId += String(random(0xffff), HEX);  
  while (!client.connect(clientId.c_str(), "try", "try")) {
    Serial.print(".");
    delay(1000);
  }

  Serial.println("\nconnected!");

}
