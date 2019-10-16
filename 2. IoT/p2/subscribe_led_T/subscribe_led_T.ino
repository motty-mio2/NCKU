
#include <LWiFi.h>
#include <MQTT.h>

char ssid[] = "MCS";
char password[] = "ilovemcs";
char mqtt_server[] = "140.116.72.90";
char pub_topic[] = "leds";
char client_Id[] = "";
WiFiClient mtclient;
MQTTClient client;

// JSON
String msgStr = "";
char json[79];


void setup() {
  Serial.begin(9600);

  WiFi.begin(ssid, password);
  client.begin("140.116.72.90", mtclient);
  client.onMessage(messageReceived);

  connect();
  pinMode(1, OUTPUT);
  pinMode(2, OUTPUT);
  pinMode(3, OUTPUT);
  pinMode(4, OUTPUT);
  pinMode(5, OUTPUT);
  pinMode(6, OUTPUT);
  pinMode(7, OUTPUT);
  pinMode(8, OUTPUT);
  pinMode(9, OUTPUT);
  pinMode(10, OUTPUT);
}

void loop() {
  client.loop();

  if (!client.connected()) {
    connect();
  }

  delay(1000);
}
void connect() {
  Serial.print("checking wifi...");
  while (WiFi.status() != WL_CONNECTED) {
    Serial.print(".");
    delay(1000);
  }
  String clientId = client_Id;
  clientId += String(random(0xffff), HEX);  
  Serial.print("\nconnecting...");
  while (!client.connect(clientId.c_str(), "try", "try")) {
    Serial.print(".");
    delay(1000);
  }
  Serial.println("\nconnected!");

  client.subscribe("leds");

}

void messageReceived(String &topic, String &payload) {
  Serial.println("incoming: " + topic + " - " + payload);

  //convert topic to string to make it easier to work with
  String topicStr = topic;

  msgStr = "";
  msgStr = payload;
  Serial.print(msgStr);
  if (msgStr == "T1_ON") {
    digitalWrite(1, HIGH);
  }
  else if (msgStr == "T1_OFF") {
    digitalWrite(1, LOW);
  }
  else if (msgStr == "T2_ON") {
    digitalWrite(2, HIGH);
  }
  else if (msgStr == "T2_OFF") {
    digitalWrite(2, LOW);
  }
  else if (msgStr == "T3_ON") {
    digitalWrite(3, HIGH);
  }
  else if (msgStr == "T3_OFF") {
    digitalWrite(3, LOW);
  }
  else if (msgStr == "T4_ON") {
    digitalWrite(4, HIGH);
  }
  else if (msgStr == "T4_OFF") {
    digitalWrite(4, LOW);
  }
  else if (msgStr == "T5_ON") {
    digitalWrite(5, HIGH);
  }
  else if (msgStr == "T5_OFF") {
    digitalWrite(5, LOW);
  }
  else if (msgStr == "T6_ON") {
    digitalWrite(6, HIGH);
  }
  else if (msgStr == "T6_OFF") {
    digitalWrite(6, LOW);
  }
  else if (msgStr == "T7_ON") {
    digitalWrite(7, HIGH);
  }
  else if (msgStr == "T7_OFF") {
    digitalWrite(7, LOW);
  }
  else if (msgStr == "T8_ON") {
    digitalWrite(8, HIGH);
  }
  else if (msgStr == "T8_OFF") {
    digitalWrite(8, LOW);
  }
  else if (msgStr == "T9_ON") {
    digitalWrite(9, HIGH);
  }
  else if (msgStr == "T9_OFF") {
    digitalWrite(9, LOW);
  }
  else if (msgStr == "T10_ON") {
    digitalWrite(10, HIGH);
  }
  else if (msgStr == "T10_OFF") {
    digitalWrite(10, LOW);
  }
}
