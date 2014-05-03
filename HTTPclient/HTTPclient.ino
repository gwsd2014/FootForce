#include <Bridge.h>
#include <HttpClient.h>
#include <FileIO.h>


int val1;
int val2;
int val3;
int val4;
int val5;
int val6;
int val7;

String v1;
String v2;
String v3;
String v4;
String v5;
String v6;
String v7;
String reading;
int num;

unsigned long time;
int count;
String str;

HttpClient client2;
  
void setup() {
  Bridge.begin();
  Serial.begin(9600);
  FileSystem.begin();
}

void loop() {
  File dataFile = FileSystem.open("/mnt/sda1/datalog.txt", FILE_APPEND);
    
  val1 = analogRead(A0);
  val2 = analogRead(A1);
  val3 = analogRead(A2);
  val4 = analogRead(A3);
  val5 = analogRead(A4);
  val6 = analogRead(A5);
  
  v1 = String(val1);
  v2 = String(val2);
  v3 = String(val3);
  v4 = String(val4);
  v5 = String(val5);
  v6 = String(val6);
  v7 = String(val7);
  
  if(dataFile){
    dataFile.write(val1);
    dataFile.write(val2);
    dataFile.write(val3);
    dataFile.write(val4);
    dataFile.write(val5);
    dataFile.write(val6);
    dataFile.close();
  }
  
  else{
    Serial.println("error opening datalog.txt \n"); 
  }
  
  Serial.println(val1);
  Serial.println(val2);
  Serial.println(val3);
  Serial.println(val4);
  Serial.println(val5);
  Serial.println(val6);
  
  str = "http://192.168.0.100/sendFootData/?val1=";
  reading = v1+"&val2="+v2+"&val3="+v3+"&val4="+v4+"&val5="+v5+"&val6="+v6+"&val7="+v7;
  str = str + reading;
  //Serial.println(str);
  //delay(1000);
  Serial.println(str);
  client2.get(str);  
  

  
}
