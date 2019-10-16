#include <LWiFi.h>
#include <MQTT.h>
#include "DHT.h"
#define DHTPIN A0     // what pin we're connected to
#define DHTTYPE DHT11   // DHT 11 

char ssid[] = "MCS";
char password[] = "ilovemcs";
char mqtt_server[] = "140.116.72.90";
char pub_topic[] = "0708";
char client_Id[] = "";

DHT dht(DHTPIN, DHTTYPE);
String msgStr = "";
String tmp = "";
char json[79];

WiFiClient mtclient;
MQTTClient client;

void messageReceived(String &topic, String &payload) {
  Serial.println("incoming: " + topic + " - " + payload);
}

void setup()
{
  Serial.begin(9600);
  Serial.println("DHTxx test!");
  WiFi.begin(ssid, password);
  client.begin("140.116.72.90", mtclient);
  client.onMessage(messageReceived);
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
    Serial.print("Humidity: ");
    Serial.print(h);
    Serial.print(" %\t");
    Serial.print("Temperature: ");
    Serial.print(t);
    Serial.println(" *C");
/*
  String inbyte;
    if (Serial.available() > 0) {
                // 受信したデータの1バイトを読み取る
                 inbyte = Serial.read();
                 if(inbyte == "ON"){
                  msgStr += "ON";
                 } else {
                  msgStr += "Off";
                 }
     }
*/
    
    if (t >= 20) {
      msgStr += "ON";
      //      Serial.print("mqtt msg ON");
    } else {
      msgStr += "OFF";
      //      Serial.print("mqtt msg OFF");
    }
    msgStr.toCharArray(json, 90);
    Serial.print("Publish message: ");
    Serial.println(json);
    if (msgStr != tmp) {
      tmp = msgStr;
      client.publish(pub_topic, json);
    }
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
  Serial.print("\nconnecting...");
  while (!client.connect(clientId.c_str(), "try", "try")) {
    Serial.print(".");
    delay(1000);
  }

  Serial.println("\nconnected!");

  client.subscribe(pub_topic);
  // client.unsubscribe("/hello");
}
