import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.pdf.*; 
import de.bezier.data.sql.*; 
import java.awt.Desktop; 
import java.net.URI; 
import java.io.IOException; 
import java.net.URISyntaxException; 

import com.mysql.cj.*; 
import com.mysql.cj.admin.*; 
import com.mysql.cj.callback.*; 
import com.mysql.cj.conf.*; 
import com.mysql.cj.conf.url.*; 
import com.mysql.cj.exceptions.*; 
import com.mysql.cj.interceptors.*; 
import com.mysql.cj.jdbc.*; 
import com.mysql.cj.jdbc.admin.*; 
import com.mysql.cj.jdbc.exceptions.*; 
import com.mysql.cj.jdbc.ha.*; 
import com.mysql.cj.jdbc.integration.c3p0.*; 
import com.mysql.cj.jdbc.interceptors.*; 
import com.mysql.cj.jdbc.jmx.*; 
import com.mysql.cj.jdbc.result.*; 
import com.mysql.cj.jdbc.util.*; 
import com.mysql.cj.log.*; 
import com.mysql.cj.protocol.*; 
import com.mysql.cj.protocol.a.*; 
import com.mysql.cj.protocol.a.authentication.*; 
import com.mysql.cj.protocol.a.result.*; 
import com.mysql.cj.protocol.result.*; 
import com.mysql.cj.protocol.x.*; 
import com.mysql.cj.result.*; 
import com.mysql.cj.sasl.*; 
import com.mysql.cj.util.*; 
import com.mysql.cj.x.protobuf.*; 
import com.mysql.cj.xdevapi.*; 
import com.mysql.jdbc.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Soluci__inform_tica extends PApplet {

//Librarias




public void setup() {
  
  textAlign(CENTER);
  setGUI();
}
int shading = 0;
public void draw() {
  if (frameCount < 75) {
    
    background.resize(width, height);
    image(background, 0, 0);
    textAlign(CENTER, CENTER); 
    textFont(fonts[0]); 
    textSize(120); 
    fill(shading);
    text("FísicAprobada", width/2, height/2);
    shading+=1.2f;
  } else {
    noTint();
    //Background
    background.resize(width, height);
    image(background, 0, 0);
    seleccionaPantalla(Pantalla);
  }

  
}

//Crear los móbiles de el ejercicio de cinemática
public void createMobilsC1() {
  if (objetos == 0) {
    m0.setValues1(tfCaddName.text, Float.parseFloat(tfCaddPos1.text), Float.parseFloat(tfCaddPos2.text), Float.parseFloat(tfCaddVel.text), paleta[0]);
  } else if (objetos == 1) {
    m1.setValues1(tfCaddName.text, Float.parseFloat(tfCaddPos1.text), Float.parseFloat(tfCaddPos2.text), Float.parseFloat(tfCaddVel.text), paleta[1]);
    C1vectors = new Vector(m0, m1);
  }
  tfCaddName.resetText();
  tfCaddPos1.resetText();
  tfCaddPos2.resetText();
  tfCaddVel.resetText();
}

public void createRanMobilsC1(){
  print("eva maria se fue, buscando el sol en la playa");
  if(objetos == 0){
     m0.setValues1("A",(int)random(-20, 20),(int)random(-20, 20),(int)random(0, 25),paleta[(int)random(0, 1)]);
  }else if(objetos == 1){
     m1.setValues1("B",(int)random(-20, 20),(int)random(-20, 20),(int)random(0, 25),paleta[(int)random(0, 1)]);
     C1vectors = new Vector(m0, m1);
  }
  tfCaddName.resetText();
  tfCaddPos1.resetText();
  tfCaddPos2.resetText();
  tfCaddVel.resetText();
}

public void createMobilC2() {
  if (objetos == 0) {
    m0.setValues2(tfCaddName.text, Float.parseFloat(tfCaddVel.text), Float.parseFloat(tfCaddHigh.text), Float.parseFloat(tfCaddAngle.text), paleta[1]);
  }
  tfCaddName.resetText();
  tfCaddHigh.resetText();
  tfCaddAngle.resetText();
  tfCaddVel.resetText();
}

public void createRanMobilC2(){
  if (objetos == 0) {
    m0.setValues2("Mobil", random(50, 250), (int)random(5, 30), (int)random(20, 70), paleta[1]);
  }
  tfCaddName.resetText();
  tfCaddHigh.resetText();
  tfCaddAngle.resetText();
  tfCaddVel.resetText();
}

public void createCajasD1() {
  if (objetos == 0) {
    c0.setValues1(Float.parseFloat(tfDaddMasa.text), Float.parseFloat(tfCaddAngle.text));
  }
  tfDaddMasa.resetText();
  tfCaddAngle.resetText();
}

public void createRanCajasD1(){
  if (objetos == 0) {
    c0.setValues1(random(3, 10), (int)random(20, 70));
  }
  tfDaddMasa.resetText();
  tfCaddAngle.resetText();
}

public void createCajaD2() {
  if (objetos == 0) {
    c0.setValues2(Float.parseFloat(tfDaddMasa.text), Float.parseFloat(tfDaddF.text), Float.parseFloat(tfDaddNu.text));
  }
  tfDaddMasa.resetText();
  tfDaddF.resetText();
  tfDaddNu.resetText();
}

public void createRanCajaD2(){
  if (objetos == 0) {
    c0.setValues2((int)random(3, 10), random(10, 100),random(0, 1));
  }
  tfDaddMasa.resetText();
  tfDaddF.resetText();
  tfDaddNu.resetText();
}

public void createLuzO1() {
  if (objetos == 0) {
    l.setValues1(Float.parseFloat(tfOXobs.text), Float.parseFloat(tfOXabeja.text), Float.parseFloat(tfOYabeja.text));
  }
  tfOXobs.resetText();
  tfOXabeja.resetText();
  tfOYabeja.resetText();
}

public void createRanLuzO1(){
  if (objetos == 0) {
    int x =(int)random(4, 6);
    l.setValues1(x, (int)random(1, 3), random(2, 6));
  }
  tfOXobs.resetText();
  tfOXabeja.resetText();
  tfOYabeja.resetText();
}

public void createLuzO2() {
  if (objetos == 0) {
    l.setValues2(Float.parseFloat(tfOAngulo.text), Float.parseFloat(tfOn1.text), Float.parseFloat(tfOn2.text));
  }
  tfOAngulo.resetText();
  tfOn1.resetText();
  tfOn2.resetText();
}

public void createRanLuzO2(){
  if (objetos == 0) {
    l.setValues2(random(20, 70), random(0, 1), random(0, 1));
  }
  tfOAngulo.resetText();
  tfOn1.resetText();
  tfOn2.resetText();
}

public void createCampoGravitatorioG1() {
  if (objetos == 0) {
    CG.setValues1(Float.parseFloat(tfGm1.text), Float.parseFloat(tfGm1.text), Float.parseFloat(tfGDistancias.text));
  }
  tfGm1.resetText();
  tfGm2.resetText();
  tfGDistancias.resetText();
}

public void createRanCampoGravitatorioG1(){
  if (objetos == 0) {
    CG.setValues1((int)random(24, 243)*1000000000, (int)random(12, 243)*1000000000, (int)random(20, 63)*10);
  }
  tfGm1.resetText();
  tfGm2.resetText();
  tfGDistancias.resetText();
}

public void createCampoGravitatorioG2() {
  if (objetos == 0) {
    CG.setValues2(Float.parseFloat(tfGr1.text), Float.parseFloat(tfGr2.text), Float.parseFloat(tfGv1.text));
  }
  tfGr1.resetText();
  tfGv1.resetText();
  tfGr2.resetText();
}

public void createRanCampoGravitatorioG2(){
  if (objetos == 0) {
    CG.setValues2((int)random(1, 243)*1000, (int)random(1, 243)*1000, (int)random(1, 20)*10);
  }
  tfGr1.resetText();
  tfGv1.resetText();
  tfGr2.resetText();
}

public void createCampoElectrico1(){
  if(objetos == 0){
    P.setValores1(Float.parseFloat(tfEc1.text), Float.parseFloat(tfEc2.text), Float.parseFloat(tfGDistancias.text));
  }
  tfEc1.resetText();
  tfEc2.resetText();
  tfGDistancias.resetText();
}

public void createRanCampoElectrico1(){
  if(objetos == 0){
    P.setValores1((int)random(-10, 10), (int)random(-10, 10), (int)random(5, 20));
  }
  tfEc1.resetText();
  tfEc2.resetText();
  tfGDistancias.resetText();
}

public void createCampoElectrico2(){
  if(objetos == 0){
    P.setValores2(Float.parseFloat(tfEV.text));
    tfEV.resetText();
  }
}

public void createRanCampoElectrico2(){
  if(objetos == 0){
    P.setValores2((int)random(5, 12));
    tfEV.resetText();
  }
}

public void createCampoMagnetico1(){
  if(objetos == 0){
    CM.setValues1(Float.parseFloat(tfMI1.text), Float.parseFloat(tfMI2.text), Float.parseFloat(tfGDistancias.text));
  }
  tfMI1.resetText();
  tfGDistancias.resetText();
  tfMI2.resetText();
}

public void createRanCampoMagnetico1(){
  if(objetos == 0){
    CM.setValues1((int)random(-12, 12), (int)random(-12, 12), (int)random(1, 20));
  }
  tfMI1.resetText();
  tfGDistancias.resetText();
  tfMI2.resetText();
}

public void createCampoMagnetico2(){
  if(objetos == 0){
    CM.setValues2(Float.parseFloat(ftMIntensidad.text), Float.parseFloat(tfMRadio.text));
  }
  ftMIntensidad.resetText();
  tfMRadio.resetText();
}

public void createRanCampoMagnetico2(){
  if(objetos == 0){
      CM.setValues2((int)random(-12, 12),(int)random(1, 20));
  }
  ftMIntensidad.resetText();
  tfMRadio.resetText();
}
// Objeto de connexión a la BBDD
MySQL msql;

public void setBBDD(){
    String user     = "admin";
    String pass     = "12345";   
    String database = "fisica";
    
    //Conexión
    msql = new MySQL( this, "localhost", database, user, pass );
    
    // Si la connexió s'ha establert
    if (msql.connect()){
      println("Connected to DDBB");
    }
    else {
      // La connexió ha fallat!!!
      println("Connection failed !");
    }
}

public void setFormulario(){
  
}

public void setFormulas(){
  
}


public String[] getInfoFormulario(int idFormulario){
  String q = "SELECT `variable`, `definicion`, `unidadSI` FROM `formulario` WHERE `idformulario`='"+idFormulario+"'";
  msql.query(q);
  msql.next();
  
  String[] data = new String[3];
      data[0]= msql.getString("variable");
      data[1]= msql.getString("definicion");
      data[2]= msql.getString("unidadSI");
  return data;
}

public String getInfoFormula(int idFormula){
  String q = "SELECT `formula` FROM `formula` WHERE `idformula` ='"+idFormula+"'";
  msql.query(q);
  msql.next();
  
  String data;
      data = msql.getString("formula");
  return data;
}
// Classe Botó

class Button {
  
 // Propietats d'un botó:
 float x, y, w, h;  // Posició i dimensions 
 String textBoto;  // Text
 boolean enabled;  // Abilitat / desabilitat
 boolean text = true;
 boolean isSelected = false;
 float redondetjat = 10;
 
 
 // Mètode Constructor
 Button(String text){
   this.textBoto = text;
   this.enabled = false;
 }
 
 // Setters
 
 public void setMides(float x, float y, float w, float h){
   this.x = x;
   this.y = y;
   this.w = w;
   this.h = h;
 }
 //Se utiliza para el seleccionador
 public void selecUse(){
   redondetjat = 35;
 }
 
 // Dibuixa el botó
 public void display(){
   pushStyle();
     if(mouseOverButton()&&!isSelected){
       fill(getColor("BotonPulsado"));      // Color quan ratolí a sobre
     }
     else if(isSelected){
       fill(getColor("Seleccionado"));          // Color actiu però ratolí fora
     }else{
       fill(getColor("BotonSinPulsar"));
     }
     stroke(0); strokeWeight(2);        //Color i gruixa del contorn
     rect(this.x, this.y, this.w, this.h, redondetjat);   // Rectangle del botó
     
     // Text (color, alineació i mida)
     if(text){
       fill(0); textAlign(CENTER); textFont(fonts[1]);
       if(textBoto == "Valores Aleatorios"){
         textSize(20);
       }
       
       text(textBoto, this.x + this.w/2, this.y + this.h/2 + (20/2));
     }
   popStyle();
 }
 
 public void DisplayWithImage(PImage icona, int c){
   pushStyle();
     imageMode(CORNER);
     if(mouseOverButton()&&!isSelected){
       tint(200); fill(200);
     }else{
       fill(c);
     }
     
     rect(this.x, this.y, this.w, this.h, redondetjat);   // Rectangle del botó
     stroke(0); strokeWeight(2);        //Color i gruixa del contorn
     image(icona, this.x+3, this.y+3, this.w-6, this.h-6);
     
   popStyle();
 }
 
 public void displayTransparencia(float t){
   pushStyle();
     if(mouseOverButton()&&!isSelected){
       fill(getColor("BotonPulsado"), t);  // Color quan ratolí a sobre
     }
     else if(isSelected){
       fill(getColor("Seleccionado"), t);          // Color actiu però ratolí fora
     }else{
       fill(getColor("BotonSinPulsar"), t);
     }
     stroke(0); strokeWeight(2);        //Color i gruixa del contorn
     rect(this.x, this.y, this.w, this.h, redondetjat);   // Rectangle del botó
     
     // Text (color, alineació i mida)
     if(text){
       fill(0); textAlign(CENTER); textSize(20);
       text(textBoto, this.x + this.w/2, this.y + this.h/2 + (20/2));
     }
   popStyle();
 }
 
 // Indica si el cursor està sobre el botó
 public boolean mouseOverButton(){
   return (mouseX >= this.x) && 
          (mouseX<=this.x + this.w) && 
          (mouseY>= this.y) && 
          (mouseY<= this.y + this.h); 
 }
  
}
class Caja extends Objeto{
  //Atributos
  float masa;
  float Fuerza;
  float Nu;
  float angulo;
  
  Caja(){
    super("", 0, 0);
  }
  
  public void setValues2(float m, float F, float n){
    this.masa = m;
    this.Fuerza = F;
    this.Nu = n;
  }
  public void setValues1(float m, float a){
    this.masa = m;
    this.angulo = a;
  }
  
  public void display(){
    if(exercici == 1){
      pushMatrix();
        rotate(PI/4+0.05f); fill(paleta[1]);
        rect(-80, 0, 115, 115);   
        rotate(-PI/2);
        textAlign(CENTER); textSize(17); fill(0);
        text(c0.masa+"kg",-60, 0);
      popMatrix();
      noFill();
      arc(xEmpiezaTriangulo, floorD1, 200, 200, 3*PI/2+ (PI/2-PI/4+0.08f), 2*PI);
      text(c0.angulo+"º", xEmpiezaTriangulo+140, floorD1-20);
      line(8, 8, 181, -147);
      line(225, -130, 225, 0);
      rectMode(CENTER); fill(paleta[1]);
      rect(225, 40, 80, 80);
      
    }else if(exercici == 2){
      monigote.resize(130, 200);
      imageMode(CENTER);
      image(monigote, -67, 98); 
      fill(0);textSize(20);
      text("F", 20, 60);
      f.changePoints(0, 90,40,90); f.display(0);
      
      text("Ff", -30, 160);
      f.changePoints(0, 190,-40,190); f.display(0);
    }

  }
  
  public void reset(){
    this.masa = 0;
    this.Fuerza = 0;
    this.Nu = 0;
  }
}
public float calcularEjercicioC1(){
  float t;
  float distX = m0.p.x -m1.p.x;
  float distY = m0.p.y -m1.p.y;
  if(distX<0){
    distX = -distX;
  }
  if(distY<0){
    distY = -distY;
  }
  float dist = sqrt((float)(Math.pow(distX, 2) + Math.pow(distY, 2)));
  //Se calcula el momento donde se xocarán
  t =(dist/(m0.vel+m1.vel));
  return t;
}

public float calcularEjercicioC2(){
  float x;
  float an = radians(m0.angulo);
  println("a: "+an);
  double a = (-9.81f)/2;  double b = (m0.vel*sin(an));  double c = 26;
  double Arriba = -b -Math.sqrt(Math.pow(b, 2) -4*a*c);
  double Abajo = 2*a;
  float t = (float)(Arriba/Abajo);
  println("t:"+Arriba/Abajo);
  x = (m0.vel*cos(an))*t;
  return x;
}
public float calcularEjercicioD1(){
  float m2;
  float a = radians(c0.angulo);
  m2 = c0.masa * sin(a);
  return m2;
}

public float calcularEjercicioD2(){
  float nu;
  nu = (c0.Fuerza-(c0.masa*9.81f*c0.Nu))/(c0.masa);
  return nu;
}

public float calcularEjercicioO1(){
  float distX = 2*l.XObsVi -l.xAbeja;
  float distY = l.yAbeja;
  return sqrt((distX)*(distX) + (distY)*(distY));
}

public float calcularEjercicioO2(){
  float A1, A2, res;
  float a = radians(l.angulo);
  A1 = (float)Math.toDegrees(Math.asin((1/l.n1)*sin(a)));
  println("Angulo: " + Math.toDegrees(Math.asin(0.5f)));
  println(A1);
  A2 = (float)Math.toDegrees(Math.asin((1/l.n2)*sin(a)));
  res = abs(A1-A2);
  return res;
}

public float calcularEjercicioG1(){
  float a = (float)(6.67f*Math.pow(10, -11))*CG.m1 * CG.m2;
  float b = (float)(Math.pow(CG.distancia * 1000, 2));
  return a/b;
}

public float calcularEjercicioG2(){
  float v = (CG.rp*(float)Math.pow(10,3) * CG.vp)/(CG.ra*(float)Math.pow(10,3));
  return v;
}

public float calcularEjercicioE1(){
  float F;
  float a = (float)(9*Math.pow(10, 9) * P.c1/1000000000 * P.c2/1000000000);
  float b = (float) (Math.pow(P.distancia/1000, 2));
  F = a/b;
  return F;
}

public float calcularEjercicioE2(){
  float a = 1.6f* (float)Math.pow(10,-19) * P.V;
  float b = 9.81f* 9.31f * (float)Math.pow(10, -31);
  return a/b;
}

public float calcularEjercicioM1(){
  float a =  4*PI*(float)Math.pow(10,-7) * CM.I1 * CM.I2;
  float b = 2*PI*CM.distancia*(float)Math.pow(10,-4);
  return a/b;
}

public float calcularEjercicioM2(){
  float a =  4*PI* (float)Math.pow(10,-7) * CM.I1;
  float b = 2*CM.distancia*(float)Math.pow(10,-3);
  return a/b;
}
class CampoGravitatorio{
  //Atributos
  float m1, m2;
  float distancia;
  
  float rp, ra;
  float vp;
  
  CampoGravitatorio(){}
  
  public void setValues1(float m1, float m2, float d){
    this.m1 = m1;
    this.m2 = m2;
    this.distancia = d;
  }
  
  public void setValues2(float r1, float r2, float v){
     this.rp = r1;
     this.ra = r2;
     this.vp = v;
  }
  
  public void display(){
    if(exercici == 1){
      //Planeta
      fill(paleta[0]);
      circle(0, -hVisualitzacio/2+100, 125);
      f.changePoints(0, -hVisualitzacio/2+100, 0, -hVisualitzacio/2+ 200); f.display(0);
      f.changePoints(0, hVisualitzacio/2, 0, hVisualitzacio/2- 200); f.display(0);
      fill(0);
      textSize(25);
      text("F", 20, -hVisualitzacio/2 + 150);
      text("F", 20, hVisualitzacio/2 - 150);
      
      f.changePoints(-100, -hVisualitzacio/2+100, -100, hVisualitzacio/2-20); f.display(0);
      f.changePoints(-100, hVisualitzacio/2-20, -100, -hVisualitzacio/2+100); f.display(0);
      
      text(distancia, -200, 0);
      
    }else if(exercici == 2){
      noFill();stroke(1);strokeWeight(2);
      ellipse(0, 0, 750, 450);
      //Planeta
      fill(paleta[0]); noStroke();
      circle(375, 0, 75);
      circle(-375, 0, 75);
      textSize(20);
      fill(0);
      text("V", 320, 60);
      f.changePoints(375, 0,375, 60); f.display(0);
      text("V", -320, -60);
      
      f.changePoints(-375, 0,-375, -60); f.display(0);
    }
  }
  
  public void reset(){
    m1 = 0;
    m2 = 0;
    distancia = 0;
  }
}
class CampoMagnetico{
  //Atributos
  float I1, I2;
  float distancia;
  
  CampoMagnetico(){}
  
  public void setValues1(float I1, float I2, float dist){
    this.I1 = I1;
    this.I2 = I2;
    this.distancia = dist;
  }
  
  public void setValues2(float I, float dist){
    this.I1 = I;
    this.distancia = dist;
  }
  
  public void display(){
    if(exercici == 1){
      //Fletxas orientadas según la corriente
      if(I1 < 0){
        f.changePoints(-wVisualitzacio/5, -100, -wVisualitzacio/5, 100);
      }else{
        f.changePoints(-wVisualitzacio/5, 100, -wVisualitzacio/5, -100);
      }
      f.display(paleta[4]);
      
      if(I2 < 0){
        f.changePoints(wVisualitzacio/5, -100, wVisualitzacio/5, 100);
      }else{
        f.changePoints(wVisualitzacio/5, 100, wVisualitzacio/5, -100);
      }
      f.display(paleta[4]);
      textSize(20);
      if(CM.I1< 0 && CM.I2< 0 || CM.I1> 0 && CM.I2> 0){
        
        text("F1", wVisualitzacio/5-40, 20);
        f.changePoints(wVisualitzacio/5, 0, wVisualitzacio/5-60, 0);f.display(0);
        text("F1",-wVisualitzacio/5+40, 20);
        f.changePoints(-wVisualitzacio/5, 0, -wVisualitzacio/5+60,0);f.display(0);
      }else{
        text("F1", wVisualitzacio/5+40, 20);
        f.changePoints(wVisualitzacio/5, 0, wVisualitzacio/5+60, 0);f.display(0);
        text("F1",-wVisualitzacio/5-40, 20);
        f.changePoints(-wVisualitzacio/5, 0, -wVisualitzacio/5-60,0);f.display(0);
      }
    }else if(exercici == 2){
      textSize(20);
      if(CM.I1 < 0){
        text(CM.I1, -wVisualitzacio/2+150, 200*sin(-6*PI/7)-80);
        f.changePoints(-wVisualitzacio/2+260, 200*sin(-6*PI/7),-wVisualitzacio/2+110, 200*sin(-6*PI/7));
        f.display(paleta[4]);
        f.changePoints(-wVisualitzacio/2+110, -200*sin(-6*PI/7), -wVisualitzacio/2+260, -200*sin(-6*PI/7));
        f.display(paleta[4]);
      }else{
        text(CM.I1, -wVisualitzacio/2+150, 200*sin(-6*PI/7));
        f.changePoints(-wVisualitzacio/2+110, 200*sin(-6*PI/7),-wVisualitzacio/2+260, 200*sin(-6*PI/7));
        f.display(paleta[4]);
        f.changePoints(-wVisualitzacio/2+260, -200*sin(-6*PI/7), -wVisualitzacio/2+110, -200*sin(-6*PI/7));
        f.display(paleta[4]);
      }
      text(distancia, 40, -20);
      f.changePoints(0, 0, 200*sin(PI/4)-4, -200*sin(PI/4)-4);f.display(0);
    }
  }
  
  public void reset(){
    this.I1 = 0;
    this.I2 = 0;
    this.distancia = 0;
  }
}
class Card{
  
  String nom;
  int estrelles;
  Button boto;
  TEMA tema;
  PImage image;
  
  Card(TEMA tema, int e, Button b){
    this.tema = tema;
    this.nom = this.tema.toString();
    this.estrelles = e;
    this.boto = b;
    
  }
  public void display(float x, float y){
    pushStyle();
      selectImage();
      textSize(midaSubtitol); textFont(fonts[0]); fill(0);
      text(this.nom, x+wCard/2, y- 30);
      //Se muestran las estrellas
      displayStars(estrelles, x, y-20);
      this.boto.setMides(x, y+100, wCard, 250); this.boto.DisplayWithImage(this.image, 255);
    popStyle();
  }
  public void displayStars(int e, float x, float y){
    //Se redimensionan al tamaño deseado
    stars[e-1].resize((int)wCard, 95);
    image(stars[e-1], x, y+30);
  }
  public void selectImage(){
    if(this.tema == TEMA.CINEMATICA){
      this.nom = "Cinemática";
      this.image = portadas[0];
    }else if(this.tema == TEMA.DINAMICA){
      this.nom = "Dinámica";
      this.image = portadas[1];
    }else if(this.tema == TEMA.OPTICA){
      this.nom = "Óptica";
      this.image = portadas[2];
    }else if(this.tema == TEMA.GRAVITATORI){
      this.nom = "Gravitatorio";
      this.image = portadas[3];
    }else if(this.tema == TEMA.ELECTRIC){
      this.nom = "Electrico";
      this.image = portadas[4];
    }else if(this.tema == TEMA.MEGNETIC){
      this.nom = "Magnético";
      this.image = portadas[5];
    }
  }
}
// Fitxer amb la informació dels Colors de l'App
  
// Array de colors
int[] colors;

//Array de paleta
int[] paleta;
  
// Estableix colors de l'App
public void setColors(){
    this.colors = new int[7];
    this.colors[0] = color(0xffFFFFFF);//Blanco
    this.colors[1] = color(0xff000000);//Negro
    this.colors[2] = color(0xffE0E0E0);//Fondo
    this.colors[3] = color(0xff434343);//Contorno
    this.colors[4] = color(0xffADADAD);//Botón sin pulsar
    this.colors[5] = color(0xff959595);//Botón pulsado
    this.colors[6] = color(0xff7a7979);//Botón seleccionado
    
    this.paleta = new int[6];
    this.paleta[0] = color(0xff8D86C9);
    this.paleta[1] = color(0xffE6AE60);
    this.paleta[2] = color(0xffFF5D73);
    this.paleta[3] = color(0xff5FA8D3);
    this.paleta[4] = color(0xff30343F);
    this.paleta[5] = color(0xffAE4A84);
}
  
  
  public int getColor(String s){
    if(s.equals("Blanco")){
      return this.colors[0];
    }else if(s.equals("Negro")){
      return this.colors[1];
    }else if(s.equals("Fondo")){
      return this.colors[2];
    }else if(s.equals("Contorno")){
      return this.colors[3];
    }else if(s.equals("BotonSinPulsar")){
      return this.colors[4];
    }else if(s.equals("BotonPulsado")){
      return this.colors[5];
    }else if(s.equals("Seleccionado")){
      return this.colors[6];
    }
    return color(255, 0, 0);
  }
//CINEMATICA
public void exportarRC1() {
  pdfRC1.beginDraw();
  pushStyle();
  pdfRC1.fill(255); 
  pdfRC1.noStroke();
  float x = width/6; 
  float y = 0;
  float w = 2*width/3; 
  float h = height;
  pdfRC1.rect(width/6, 0, 2*width/3, height);
  pdfRC1.fill(0);
  pdfRC1.textSize(midaTitol-5); 
  pdfRC1.fill(0); 
  pdfRC1.textAlign(CENTER);
  pdfRC1.text("Explicación choque entre cuerpos", width/2, marginV+25);//titol
  pdfRC1.fill(200); 
  pdfRC1.noStroke();
  pdfRC1.rect(x+ 30 -10, y+marginV+55-10, w-50, 190, 10);
  pdfRC1.textSize(midaSubtitol-2); 
  pdfRC1.textAlign(TOP, LEFT); 
  pdfRC1.fill(0);
  if (objetos>1) {
    pdfRC1.text("Enunciado: Dos mobiles, uno situado en la coordenada ("+m0.p.x+", "+m0.p.y+") de un eje de cordenadas cartegianas y otro situado en ("+m1.p.x+", "+m1.p.y+") se mueven en un MRU (que empieza en t=0s) en dirección de chocar. Si la velocidad del primero es "+m0.vel+"m/s y la del segundo es "+m1.vel+",m/s ¿cuándo chocarán?", x+ 30, y+marginV+55, w-60, h-10);
  } else {
    pdfRC1.text("Enunciado: Dos mobiles, uno situado en la coordenada (X1, Y1) de un eje de cordenadas cartegianas y otro situado en (X2, Y2) se mueven en un MRU (que empieza en t=0s) en dirección de chocar. Si la velocidad del primero es V1m/s y la del segundo es V2m/2, ¿cuándo chocarán?", x+ 30, y+marginV+55, w-60, h-10);
  }
  //Escrito de resolución
  pdfRC1.textSize(midaSubtitol-8);
  pdfRC1.text("En primer lugar, se halla la distancia entre los dos móbiles usando el teorema de pitágoras:", x+ 30, y+marginV+55+200, w-50, h-10);
  //Pitagoras:
  pit1.resize(240, 240); 
  pit2.resize(500, 150);
  float xBorde = x+30;
  float yImg1 = y+marginV+55+200 + 100;
  pdfRC1.image(pit1, xBorde, yImg1); 
  float x1F1 = xBorde + 240; 
  float x2F1 =x1F1 + 60;
  float yF = yImg1 + 240/2;
  f.changePoints(x1F1, yF, x2F1, yF); 
  f.display(0);
  float xDist = x2F1 + 10;
  pdfRC1.textAlign(LEFT, CENTER); 
  pdfRC1.textSize(midaParagraf);
  pdfRC1.text("Dist = sqrt((Dx)^2 + (Dy)^2   \nDist = sqrt((X2-X1)^2 + (Y2-Y1)^2)", xDist, yF);
  float xImg2 = xDist+ 400;
  pdfRC1.image(pit2, xImg2, y+marginV+55+200 + 100 + 45);

  pdfRC1.textAlign(LEFT, TOP); 
  pdfRC1.textSize(midaSubtitol-8); 
  float yText = yF + 240/2; 
  pdfRC1.fill(0);
  pdfRC1.text("Que los coches choquen significa que su posición es la misma; por lo tanto, igualamos sus ecuaciones de movimiento:", x+ 30, yText, w-50, h-10);
  //Igualación de Ecuaciones:
  pdfRC1.textAlign(CENTER, TOP); 
  pdfRC1.textSize(midaParagraf+4);
  float xExpr = x+w/2-400; 
  float yExpr = yText + 60;
  pdfRC1.text("p1 =p2   \np01+v1*t = p02+v2*t   \n0+v1*t = dist+v2*t \nen modulo: v1*t = dist -v2*t \nt = (dist)/(v1+v2)    \nt = (sqrt((X2-X1)^2 + (Y2-Y1)^2))/(v1+v2)", xExpr, yExpr, 800, 600);

  //Substitución:
  if (objetos>1) {
    pdfRC1.textAlign(LEFT, TOP); 
    pdfRC1.textSize(midaSubtitol-8);
    float ySub = yExpr + 180;
    pdfRC1.text("Entonces, substituimos en la ecuación:", xBorde, ySub);
    float yRes = ySub+40;
    float Resp = calcularEjercicioC1();
    pdfRC1.text("t = (sqrt(("+m1.p.x+"-"+m0.p.x+")^2 + ("+m1.p.y+"-"+m0.p.y+"^2))/("+m0.vel+"+"+m1.vel+") = "+Resp, xExpr, yRes, w, 600);
    pdfRC1.text("SOLUCIÓN: Se chocarán cuando hayan passado "+Resp+"s", xBorde, ySub+100);
  }
  pdfRC1.dispose();
  pdfRC1.endDraw();
}
public void exportarEC1() {
  pdfEC1.beginDraw();
    pushStyle();
    pdfEC1.fill(255); 
    pdfRC1.noStroke();
    float x = width/6; 
    float y = 0;
    float w = 2*width/3; 
    float h = height;
    pdfEC1.rect(width/6, 0, 2*width/3, height);
    pdfEC1.fill(0);
    pdfEC1.textSize(midaTitol-5); 
    pdfEC1.fill(0); 
    pdfEC1.textAlign(CENTER);
    pdfEC1.text("Explicación choque entre cuerpos", width/2, marginV+25);//titol
    pdfEC1.fill(200); 
    pdfRC1.noStroke();
    pdfEC1.rect(x+ 30 -10, y+marginV+55-10, w-50, 190, 10);
    pdfEC1.textSize(midaSubtitol-2); 
    pdfEC1.textAlign(TOP, LEFT); 
    pdfEC1.fill(0);
    if (objetos>1) {
      pdfEC1.text("Enunciado: Dos mobiles, uno situado en la coordenada ("+m0.p.x+", "+m0.p.y+") de un eje de cordenadas cartegianas y otro situado en ("+m1.p.x+", "+m1.p.y+") se mueven en un MRU (que empieza en t=0s) en dirección de chocar. Si la velocidad del primero es "+m0.vel+"m/s y la del segundo es "+m1.vel+",m/s ¿cuándo chocarán?", x+ 30, y+marginV+55, w-60, h-10);
    } else {
      pdfEC1.text("Enunciado: Dos mobiles, uno situado en la coordenada (X1, Y1) de un eje de cordenadas cartegianas y otro situado en (X2, Y2) se mueven en un MRU (que empieza en t=0s) en dirección de chocar. Si la velocidad del primero es V1m/s y la del segundo es V2m/2, ¿cuándo chocarán?", x+ 30, y+marginV+55, w-60, h-10);
    }
  pdfEC1.dispose();
  pdfEC1.endDraw();
}

public void exportarRC2(){
  pdfRC2.beginDraw();
    float x = width/6; 
    float y = 0;
    float w = 2*width/3; 
    float h = height;
    pdfRC2.rect(width/6, 0, 2*width/3, height);
    pdfRC2.textSize(midaTitol-5); pdfRC2.fill(0); pdfRC2.textAlign(CENTER);
    pdfRC2.text("Explicación tiro parabólico", width/2, marginV+25);//titol
    pdfRC2.fill(200); pdfRC2.noStroke();
    pdfRC2.rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
    pdfRC2.textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
    //Pregunta
    if(objetos == 0){
      pdfRC2.text("Si un mobil se situa en un precipicio cuya altura es H y se lanza a una velocidad V en un ángulo A respeto a la horizontal; ¿a cuantos metros del precicpicio xocará contra el suelo?", x+ 30, y+marginV+55, w-60, h-10);
    }else if(objetos >0){
      pdfRC2.text("Si un mobil se situa en un precipicio cuya altura es "+m0.altura+" y se lanza a una velocidad "+m0.vel+" en un ángulo "+m0.angulo+" respeto a la horizontal; ¿a cuantos metros del precicpicio xocará contra el suelo?", x+ 30, y+marginV+55, w-60, h-10);
    }
    //Explicación:
    pdfRC2.textSize(midaSubtitol-8);
    float Y1 = y+marginV+55+200;
    pdfRC2.text("En primer lugar, se halla el tiempo en que el objeto tocará el suelo. Para esto, se utiliza la fórmula de MRUA:", x+ 30,Y1, w-50, h-10);
    float Y2 = Y1 + 100;
    pdfRC2.textSize(midaParagraf);
    pdfRC2.text("0 = h + Vy*t +(g*t^2)/2", w/2 + 125, Y2, w-50, h-10);
    pdfRC2.textSize(midaSubtitol-8);
    float Y3 = Y2 + 50;
    pdfRC2.text("Entonces, según la ecuación de segundo grado, se calcula el tiempo:", x+ 30, Y3, w-50, h-10);
    float Y4 = Y3 + 50;
    pdfRC2.textSize(midaParagraf);
    pdfRC2.text("t = [ -(Vy) +sqrt[(Vy)^2 +4*h*4.9] ]/(-9.81)", w/2, Y4, w-50, h-10);
    pdfRC2.textSize(midaSubtitol-8);
    float Y5 = Y4 + 50;
    pdfRC2.text("Este es el tiempo que se debe introducir en la ecuación del MRU horizonal del móbil para calcular a qué distancia xocará con el suelo. La ecuación resultante es la siguiente: ", x+ 30, Y5, w-50, h-10);
    pdfRC2.textSize(midaParagraf);
    float Y6 = Y5 + 100;
    pdfRC2.text("X = Vx * t", w/2 + 200, Y6, w-50, h-10);
    float Y7 = Y6 + 50;
    pdfRC2.text("X = Vx * [ -(Vy) +sqrt[(Vy)^2 +4*h*4.9] ]/(-9.81)", w/2, Y7, w-50, h-10);
    pdfRC2.textSize(midaSubtitol-8);
    float Y8 = Y7 + 50;
    pdfRC2.text("Las componentes Y y X de la velocidad se conseguirán multiplicando la velocidad por el sinus y el cosinus respectivamente.", x+ 30, Y8, w-50, h-10);
    pdfRC2.textSize(midaParagraf);float Y9 = Y8 + 100;
    pdfRC2.text("Vx = V*cos(A)     Vy = v*sin(A)", w/2, Y9, w-50, h-10);
    float Y10 = Y9 + 50;
    pdfRC2.textSize(midaSubtitol-8);
    pdfRC2.text("Entonces:", x+ 30, Y10, w-50, h-10);
    pdfRC2.textSize(midaParagraf);
    pdfRC2.text("X = V*cos(A) * [ -(V*sin(A)) +sqrt[(V*sin(A))^2 +4*h*4.9] ]/(-9.81)", w/2, Y10+2, w-50, h-10);
    float Y11 = Y10 + 50;
    pdfRC2.textSize(midaSubtitol-8);
    pdfRC2.text("Substituimos:", x+ 30, Y11, w-50, h-10);
    if(objetos > 0){
      pdfRC2.textSize(midaParagraf);
      float Resp = calcularEjercicioC2();
      pdfRC2.text("X = "+m0.vel+"*cos("+m0.angulo+") * [ -("+m0.vel+"*sin("+m0.angulo+")) +sqrt[("+m0.vel+"*sin("+m0.angulo+"))^2 +4*"+m0.altura+"*4.9] ]/(-9.81) = "+Resp, w/2, Y11+2, w/2+ 350, h-10);
      float Y12 = Y11 + 50;
      pdfRC2.textSize(midaSubtitol-8);
      pdfRC2.text("Solición: Chocará con el suelo a "+Resp+" m del precipicio", x+ 30, Y12, w-50, h-10);
    }
  pdfRC2.dispose();
  pdfRC2.endDraw();
}

public void exportarEC2(){
  pdfEC2.beginDraw();
    float x = width/6; 
    float y = 0;
    float w = 2*width/3; 
    float h = height;
    pdfEC2.rect(width/6, 0, 2*width/3, height);
    pdfEC2.textSize(midaTitol-5); pdfEC2.fill(0); pdfEC2.textAlign(CENTER);
    pdfEC2.text("Explicación tiro parabólico", width/2, marginV+25);//titol
    pdfEC2.fill(200); pdfEC2.noStroke();
    pdfEC2.rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
    pdfEC2.textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
    //Pregunta
    if(objetos == 0){
      pdfEC2.text("Si un mobil se situa en un precipicio cuya altura es H y se lanza a una velocidad V en un ángulo A respeto a la horizontal; ¿a cuantos metros del precicpicio xocará contra el suelo?", x+ 30, y+marginV+55, w-60, h-10);
    }else if(objetos >0){
      pdfEC2.text("Si un mobil se situa en un precipicio cuya altura es "+m0.altura+" y se lanza a una velocidad "+m0.vel+" en un ángulo "+m0.angulo+" respeto a la horizontal; ¿a cuantos metros del precicpicio xocará contra el suelo?", x+ 30, y+marginV+55, w-60, h-10);
    }
  
  pdfEC2.dispose();
  pdfEC2.endDraw();
}
//DINAMICA
public void exportarRD1(){
  pdfRD1.beginDraw();
    float x = width/6; 
    float y = 0;
    float w = 2*width/3; 
    float h = height;
    textSize(midaTitol-12); fill(0); textAlign(CENTER);
    text("Explicación Polea en plano inclinado", width/2, marginV+25);//titol
    fill(200); noStroke();
    rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
    textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
    //Pregunta
    if(objetos == 0){
      text("Si se considera una polea en un plano inclinado de ángulo Alpha que sujeta dos objetos, y el que está en el plano inclinado tiene una masa de M1 kg, ¿qué masa tiene que tener el segundo objeto para que el sistema esté en equilibrio?", x+ 30, y+marginV+55, w-60, h-10);
    }else if(objetos == 1){
      text("Si se considera una polea en un plano inclinado de ángulo "+c0.angulo+" que sujeta dos objetos, y el que está en el plano inclinado tiene una masa de "+c0.masa+" kg, ¿qué masa tiene que tener el segundo objeto para que el sistema esté en equilibrio?", x+ 30, y+marginV+55, w-60, h-10);
    }
    
    //Explicación:
    textSize(midaSubtitol-8);
    float Y1 = y+marginV+55+200;
    text("La tensión de la cuerda es la misma en toda ella, lo que significa que la fuerza que hacen las cajas sobre ella es igual. La primera caja está apoyada sobre un plano inclinado; por este motivo, la fuerza que ejerce este es la componente x del peso sobre el plano. Por este motivo, se puede afirmar que:", x+ 30,Y1, w-50, h-10);
    float Y2 = Y1 + 150;
    textSize(midaParagraf);
    text(" P1x = P1*sin(A)", w/2 + 150,Y2, w-50, h-10);
    textSize(midaSubtitol-8);
    float Y3 = Y2 + 50;
    text("En relación a la fuerza de la seguna caja, debido a que no está apoyada, es su masa multiplicado por el peso", x+ 30,Y3, w-50, h-10);
    float Y4 = Y3 + 50;
    textSize(midaParagraf);
    text(" P2 = m2* g", w/2 + 150,Y4, w-50, h-10);
    float Y5 = Y4+50;
    textSize(midaSubtitol-8);
    text("Entonces, igualamos las ecuaciones", x+ 30,Y5, w-50, h-10); 
    float Y6 = Y5 + 50;
    textSize(midaParagraf);
    text("P1 * sin(A) = m2* g", w/2 + 150,Y6, w-50, h-10);
    float Y7 = Y6 + 50;
    text("m1* g * sin(A) = m2* g", w/2 + 150,Y7, w-50, h-10);
    float Y8 = Y7 + 50;
    text("m2 = m1 * sin(A)", w/2 + 150,Y8, w-50, h-10);
    float Y9 = Y8+50;
    textSize(midaSubtitol-8);
    text("Finalmente, se substituye:", x+ 30,Y9, w-50, h-10); 
    if(objetos > 0){
      float Resp = calcularEjercicioD1();
      textSize(midaParagraf);
      text("m2 = "+c0.masa+" * sin("+c0.angulo+") = "+ Resp, w/2 + 150,Y9, w-50, h-10);
      float Y10 = Y9 + 50;
      text("Solución: Para que el sistema esté en equilibrio la segunda caja debe tener una masa de "+Resp+"kg", x + 30, Y10, w-30, h);
    }
  pdfRD1.dispose();
  pdfRD1.endDraw();
}

public void exportarED1(){
  pdfED1.beginDraw();
    float x = width/6; 
    float y = 0;
    float w = 2*width/3; 
    float h = height;
    pdfED1.textSize(midaTitol-12); pdfED1.fill(0); pdfED1.textAlign(CENTER);
    pdfED1.text("Explicación Polea en plano inclinado", width/2, marginV+25);//titol
    pdfED1.fill(200); pdfED1.noStroke();
    pdfED1.rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
    pdfED1.textSize(midaSubtitol-2);pdfED1.textAlign(TOP, LEFT); fill(0);
    //Pregunta
    if(objetos == 0){
      pdfED1.text("Si se considera una polea en un plano inclinado de ángulo Alpha que sujeta dos objetos, y el que está en el plano inclinado tiene una masa de M1 kg, ¿qué masa tiene que tener el segundo objeto para que el sistema esté en equilibrio?", x+ 30, y+marginV+55, w-60, h-10);
    }else if(objetos == 1){
      pdfED1.text("Si se considera una polea en un plano inclinado de ángulo "+c0.angulo+" que sujeta dos objetos, y el que está en el plano inclinado tiene una masa de "+c0.masa+" kg, ¿qué masa tiene que tener el segundo objeto para que el sistema esté en equilibrio?", x+ 30, y+marginV+55, w-60, h-10);
    }
  pdfED1.dispose();
  pdfED1.endDraw();
}

public void exportarRD2(){
  pdfRD2.beginDraw();
    float x = width/6; 
    float y = 0;
    float w = 2*width/3; 
    float h = height;
    pdfRD2.textSize(midaTitol-5); 
    pdfRD2.fill(0); 
    pdfRD2.textAlign(CENTER);
    pdfRD2.text("Explicación Cajas Rozantes", width/2, marginV+25);//titol
    pdfRD2.fill(200); 
    pdfRD2.noStroke();
    pdfRD2.rect(x+ 30 -10, y+marginV+55-10, w-50, 190, 10);
    pdfRD2.textSize(midaSubtitol-2);
    pdfRD2.textAlign(TOP, LEFT); 
    pdfRD2.fill(0);
    //Prgunta
    if (objetos == 0) {
      pdfRD2.text("Si a un cuerpo de massa M kg se le aplica una fuerza F N, teniendo en cuenta que entre el cuerpo y el suelo hay un coeficiente de fricción Nu, ¿Se moverá? En caso afirmativo ¿Cual será su acceleración?", x+ 30, y+marginV+55, w-60, h-10);
    } else {
      pdfRD2.text("Si a un cuerpo de massa "+c0.masa+" kg se le aplica una fuerza "+c0.Fuerza+" N, teniendo en cuenta que entre el cuerpo y el suelo hay un coeficiente de fricción "+c0.Nu+", ¿Se moverá? En caso afirmativo ¿Cual será su acceleración?", x+ 30, y+marginV+55, w-60, h-10);
    }
    //Explicación:
    pdfRD2.textSize(midaSubtitol-8);
    float Y1 = y+marginV+55+200;
    pdfRD2.text("Para que el cuerpo se mueva, la fuerza aplicada debe ser superior a la fuerza de resistencia; es decir, la fuerza de fricción. Es por esto que se tiene que aplicar la segunda ley Newton.\nEsta dice que el sumatorio de las ferzas da como resultado la masa del cuerpo multiplicado por su acceleración. En este caso, la ecuación sería así:", x+ 30, Y1, w-50, h-10);
    pdfRD2.textSize(midaParagraf);
    float Y2 = Y1+150;
    pdfRD2.text(" F - Ff = m * a", w/2 + 150, Y2, w-50, h-10);
    float Y3 = Y2 + 50;
    pdfRD2.textSize(midaSubtitol-8);
    pdfRD2.text("En este problema, ya que se consideran los módulos, la acceleración puede ser negativa. Que sea negativa significa que el objeto no se moverá, en cambio, si la acceleración es positiva, se moverá.", x+ 30, Y3, w-50, h-10);
    float Y4 = Y3 + 100;
    pdfRD2.text("La fuerza de fricción se calcula multiplicando la normal, que es el peso de la caja con el coeficiente de fricción. Es decir:", x+ 30, Y4, w-50, h-10); 
    pdfRD2.textSize(midaParagraf);
    float Y5 = Y4+70;
    pdfRD2.text("Ff = m*g * nu", w/2 + 150, Y5, w-50, h-10);
    pdfRD2.textSize(midaSubtitol-8);
    float Y6 = Y5 + 50;
    pdfRD2.text("Entonces, la acceleración se puede calcular a partir de la siguiente ecuación:", x+ 30, Y6, w-50, h-10); 
    pdfRD2.textSize(midaParagraf);
    float Y7 = Y6+50;
    pdfRD2.text("a = (F-m*g*nu)/m", w/2 + 150, Y7, w-50, h-10);
    pdfRD2.textSize(midaSubtitol-8);
    float Y8 = Y7 + 50;
    pdfRD2.text("A continación, se substituyen los valores:", x+ 30, Y8, w-50, h-10); 
  
    float Y9 = Y8+50;
    if (objetos > 0) {
      pdfRD2.textSize(midaParagraf);
      float Resp = calcularEjercicioD2();
      pdfRD2.text("a = ("+c0.Fuerza+"-"+c0.masa+"*9.81*"+c0.Nu+")/"+c0.masa+" = "+ Resp, w/2 + 150, Y9, w-50, h-10);
      float Y10 = Y9 + 50;
      pdfRD2.textSize(midaSubtitol-8);
      if (Resp > 0) {
        pdfRD2.text("Solución: Se moverá; concretamente a "+Resp+"m/(s^2)", x+30, Y10, w-30, h);
      } else {
        pdfRD2.text("Solución: No se moverá", x+30, Y10, w-30, h);
      }
    }
  pdfRD2.dispose();
  pdfRD2.endDraw();
}

public void exportarED2(){
  pdfED2.beginDraw();
    float x = width/6; 
    float y = 0;
    float w = 2*width/3; 
    float h = height;
    pdfED2.textSize(midaTitol-5); 
    pdfED2.fill(0); 
    pdfED2.textAlign(CENTER);
    pdfED2.text("Explicación Cajas Rozantes", width/2, marginV+25);//titol
    pdfED2.fill(200); 
    pdfED2.noStroke();
    pdfED2.rect(x+ 30 -10, y+marginV+55-10, w-50, 190, 10);
    pdfED2.textSize(midaSubtitol-2);
    pdfED2.textAlign(TOP, LEFT); 
    pdfED2.fill(0);
    //Pregunta
    if (objetos == 0) {
      pdfED2.text("Si a un cuerpo de massa M kg se le aplica una fuerza F N, teniendo en cuenta que entre el cuerpo y el suelo hay un coeficiente de fricción Nu, ¿Se moverá? En caso afirmativo ¿Cual será su acceleración?", x+ 30, y+marginV+55, w-60, h-10);
    } else{
      pdfED2.text("Si a un cuerpo de massa "+c0.masa+" kg se le aplica una fuerza "+c0.Fuerza+" N, teniendo en cuenta que entre el cuerpo y el suelo hay un coeficiente de fricción "+c0.Nu+", ¿Se moverá? En caso afirmativo ¿Cual será su acceleración?", x+ 30, y+marginV+55, w-60, h-10);
    }
  pdfED2.dispose();
  pdfED2.endDraw();
}



//Óptica:
public void exportarRO1(){
  pdfRO1.beginDraw();
     float x = width/6; 
     float y = 0;
     float w = 2*width/3; 
     float h = height;
     pdfRO1.textSize(midaTitol-16); pdfRO1.fill(0); pdfRO1.textAlign(CENTER);
     pdfRO1.text("Explicación Espejo", width/2, marginV+25);//titol
     pdfRO1.fill(200); pdfRO1.noStroke();
     pdfRO1.rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
     pdfRO1.textSize(midaSubtitol-2);pdfRO1.textAlign(TOP, LEFT); pdfRO1.fill(0);
     //Pregunta
     if(objetos == 0){
       pdfRO1.text("Se toma como punto de referencia el ojo de un observador. También se sabe que hay un vidrio a X1 m del ojo y una abeja stiuada a X2 y Y2 m de distáncia,¿en que posición se produce la imagen de la abeja?", x+ 30, y+marginV+55, w-60, h-10);
     }else if(objetos == 1){
       pdfRO1.text("Se toma como punto de referencia el ojo de un observador. También se sabe que hay un vidrio a "+l.XObsVi+" m del ojo y una abeja stiuada a "+l.xAbeja+" y "+l.yAbeja+" m de distáncia,¿en que posición se produce la imagen de la abeja?", x+ 30, y+marginV+55, w-60, h-10);
     }
     //Explicación
     pdfRO1.textSize(midaSubtitol-8);
     float Y1 = y+marginV+55+200;
     pdfRO1.text("Cuando se ve un objeto reflejado en un espejo, se ve como una imagen virtual. Además, se puede afirmar que la distancia entre el objto y el vidrio será la mismo que entre la imagen y el vídrio. Además, su posición Y será también identica. Entonces, se puede afirmar lo siguiente:", x+ 30,Y1, w-50, h-10);
     float Y2 = Y1+125;
     pdfRO1.textSize(midaParagraf);
     pdfRO1.text("Ax = DXvo + DXva     ;     Ay = DYao", w/2 + 150,Y2, w-50, h-10);
     float Y3 = Y2 + 50;
     pdfRO1.textSize(midaSubtitol-8);
     pdfRO1.text("Donde DXvo se refiere a la distancia horizontal entre el vidrio y el ojo; DXva, a la distancia horizontal entre el vidrio y la abeja y finalmente, DYao, a la vertical entre la abeja y el ojo. \nEntonces, la posición de la abeja se escribe como A(Ax, Ay). Seguidamente, se debe hacer el módulo de este vector.", x+ 30,Y3, w-50, h-10);
     if(objetos > 0){
       float Y4 = Y3 + 150;
       pdfRO1.text("Primero, se substituye:", x+ 30,Y4, w-50, h-10);
       pdfRO1.textSize(midaParagraf);
       pdfRO1.text("Ax = "+l.XObsVi+" + "+l.xAbeja+"     ;     Ay = "+l.yAbeja+"", w/2+150,Y4, w-50, h-10);
       float Y5 = Y4 + 50;
       pdfRO1.textSize(midaSubtitol-8);
       pdfRO1.text("Y luego, se calcula el módulo:", x+ 30,Y5, w-50, h-10);
       pdfRO1.textSize(midaParagraf);
       float Resp = calcularEjercicioO1();
       pdfRO1.text("|A| = sqrt[("+l.XObsVi+" + "+l.xAbeja+")^2 + ("+l.yAbeja+")^2] = "+Resp, w/2+ 150,Y5, w-50, h-10);
       float Y6 = Y5+50;
       pdfRO1.textSize(midaSubtitol-8);
       pdfRO1.text("Solución: La imagen se formará a "+Resp+"m del observador", x+30, Y6, w-30, h);
    }
  pdfRO1.dispose();
  pdfRO1.endDraw();
}

public void exportarEO1(){
   pdfEO1.beginDraw();
     float x = width/6; 
     float y = 0;
     float w = 2*width/3; 
     float h = height;
     pdfEO1.textSize(midaTitol-16); pdfEO1.fill(0); pdfEO1.textAlign(CENTER);
     pdfEO1.text("Explicación Espejo", width/2, marginV+25);//titol
     pdfEO1.fill(200); pdfEO1.noStroke();
     pdfEO1.rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
     pdfEO1.textSize(midaSubtitol-2);pdfEO1.textAlign(TOP, LEFT); pdfEO1.fill(0);
     //Pregunta
     if(objetos == 0){
       pdfEO1.text("Se toma como punto de referencia el ojo de un observador. También se sabe que hay un vidrio a X1 m del ojo y una abeja stiuada a X2 y Y2 m de distáncia,¿en que posición se produce la imagen de la abeja?", x+ 30, y+marginV+55, w-60, h-10);
     }else if(objetos == 1){
       pdfEO1.text("Se toma como punto de referencia el ojo de un observador. También se sabe que hay un vidrio a "+l.XObsVi+" m del ojo y una abeja stiuada a "+l.xAbeja+" y "+l.yAbeja+" m de distáncia,¿en que posición se produce la imagen de la abeja?", x+ 30, y+marginV+55, w-60, h-10);
     }
  pdfEO1.dispose();
  pdfEO1.endDraw();
}


public void exportarRO2(){
  pdfRO2.beginDraw();
    float x = width/6; 
    float y = 0;
    float w = 2*width/3; 
    float h = height;
    pdfRO2.textSize(midaTitol-16); pdfRO2.fill(0); pdfRO2.textAlign(CENTER);
    pdfRO2.text("Explicación Separación de rayos", width/2, marginV+25);//titol
    pdfRO2.fill(200); pdfRO2.noStroke();
    pdfRO2.rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
    pdfRO2.textSize(midaSubtitol-2);pdfRO2.textAlign(TOP, LEFT); pdfRO2.fill(0);
    //Pregunta
    if(objetos == 0){
      pdfRO2.text("Si un rayo de luz que se translada por el aire incide en un vidrio formando un ángulo de Aº con la normal y se separa en dos rayos de coeficientes de refracción n1 y n2, ¿cual será la separación angular de los rayos?", x+ 30, y+marginV+55, w-60, h-10);
    }else if(objetos == 1){
      pdfRO2.text("Si un rayo de luz que se translada por el aire incide en un vidrio formando un ángulo de "+l.angulo+"º con la normal y se separa en dos rayos de coeficientes de refracción "+l.n1+" y "+l.n2+", ¿cual será la separación angular de los rayos?", x+ 30, y+marginV+55, w-60, h-10);
    }
    pdfRO2.textSize(midaSubtitol-8);
    float Y1 = y+marginV+55+200;
    pdfRO2.text("Para calcular la separación, se tienen que calcular cada uno de los ángulos y encontrar la diferencia. \nPara esto, se tiene que aplicar la ley de Snell, que dice:", x+ 30,Y1, w-50, h-10);
    float Y2 = Y1 + 100;
    pdfRO2.textSize(midaParagraf);
    pdfRO2.text("n sin(a) = n' sin(a')", w/2 + 100,Y2, w-50, h-10);
    float Y3 = Y2 + 50;
    pdfRO2.textSize(midaSubtitol-8);
    pdfRO2.text("Entonces, se tienen que calcular esto para los dos casos.", x+ 30,Y3, w-50, h-10);
    float Y4 = Y3 + 50;
    pdfRO2.textSize(midaParagraf);
    pdfRO2.text("1* sin(A) = n1' sin(a1)", w/2 + 100,Y4, w-50, h-10);
    float Y5 = Y4 + 50;
    pdfRO2.text("a1 = arcsin[(sin(A))/n1]", w/2 + 100,Y5, w-50, h-10);
    float Y6 = Y5 + 50;
    pdfRO2.text("1* sin(A) = n2' sin(a2)", w/2 + 100,Y6, w-50, h-10);
    float Y7 = Y6 + 50;
    pdfRO2.text("a2 = arcsin[(sin(A))/n2]", w/2 + 100,Y7, w-50, h-10);
    pdfRO2.textSize(midaSubtitol-8);
    float Y8 = Y7 + 50;
    pdfRO2.text("La sparación, será la resta entre los dos ángulos", x+ 30,Y8, w-50, h-10);
    float Y9 = Y8 +50;
    pdfRO2.textSize(midaParagraf);
    pdfRO2.text("S = arcsin[(sin(A))/n1]-arcsin[(sin(A))/n2]", w/2 + 100,Y9, w-50, h-10);
    if(objetos > 0){
      pdfRO2.textSize(midaSubtitol-8);
      float Y10 = Y9 + 50;
      pdfRO2.text("Finalmente, substituimos:", x+ 30,Y10, w-50, h-10);
      pdfRO2.textSize(midaParagraf);
      float Resp = calcularEjercicioO2();
      pdfRO2.text("S = arcsin[(sin("+l.angulo+"))/"+l.n1+"]-arcsin[(sin("+l.angulo+"))/"+l.n2+"] = "+Resp, w/2 + 100,Y10, w-250, h-10);
      float Y11 = Y10 + 50;
      pdfRO2.textSize(midaSubtitol-8);
      pdfRO2.text("La separación de los rayos será por "+Resp+"º", x+30, Y11, w-30, h);
   }
   pdfRO2.dispose();
   pdfRO2.endDraw();
}

public void exportarEO2(){
  pdfEO2.beginDraw();
    float x = width/6; 
    float y = 0;
    float w = 2*width/3; 
    float h = height;
    pdfEO2.textSize(midaTitol-16); pdfEO2.fill(0); pdfEO2.textAlign(CENTER);
    pdfEO2.text("Explicación Separación de rayos", width/2, marginV+25);//titol
    pdfEO2.fill(200); pdfEO2.noStroke();
    pdfEO2.rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
    pdfEO2.textSize(midaSubtitol-2);pdfEO2.textAlign(TOP, LEFT); pdfEO2.fill(0);
    //Pregunta
    if(objetos == 0){
      pdfEO2.text("Si un rayo de luz que se translada por el aire incide en un vidrio formando un ángulo de Aº con la normal y se separa en dos rayos de coeficientes de refracción n1 y n2, ¿cual será la separación angular de los rayos?", x+ 30, y+marginV+55, w-60, h-10);
    }else if(objetos == 1){
      pdfEO2.text("Si un rayo de luz que se translada por el aire incide en un vidrio formando un ángulo de "+l.angulo+"º con la normal y se separa en dos rayos de coeficientes de refracción "+l.n1+" y "+l.n2+", ¿cual será la separación angular de los rayos?", x+ 30, y+marginV+55, w-60, h-10);
    }
  pdfEO2.dispose();
  pdfEO2.endDraw();
}



//Gravitatorio:

public void exportarRG1(){
  pdfRG1.beginDraw();
    float x = width/6; 
    float y = 0;
    float w = 2*width/3; 
    float h = height;
    pdfRG1.textSize(midaTitol-16); pdfRG1.fill(0); pdfRG1.textAlign(CENTER);
    pdfRG1.text("Explicación Atreacción Estrella-Planeta", width/2, marginV+25);//titol
    pdfRG1.fill(200); pdfRG1.noStroke();
    pdfRG1.rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
    pdfRG1.textSize(midaSubtitol-2);pdfRG1.textAlign(TOP, LEFT); pdfRG1.fill(0);
    //Pregunta
    if(objetos == 0){
      pdfRG1.text("Si un planeta de massa M1 Kg se encuentra a Dist Km de una estrella de massa M2 Kg, ¿cual será la fuerza de atracción entre los dos cuerpos?", x+ 30, y+marginV+55, w-60, h-10);
    }else{
      pdfRG1.text("Si un planeta de massa "+CG.m1+"Kg se encuentra a "+CG.distancia+"Km de una estrella de massa "+CG.m2+"Kg, ¿cual será la fuerza de atracción entre los dos cuerpos?", x+ 30, y+marginV+55, w-60, h-10);
    }
    //Explicación:
    pdfRG1.textSize(midaSubtitol-8);
    float Y1 = y+marginV+55+200;
    pdfRG1.text("La fuerza de atracción entre cuerpoes es debido al campo gravitatorio. De hecho, exsite una fórmula para calcular la fuerza de atracción entre dos cuerpos. Esta es la siguiente:", x+ 30,Y1, w-50, h-10);
    float Y2 = Y1 + 100;
    pdfRG1.textSize(midaParagraf);
    pdfRG1.text("F = G*(M1*M2)/(r^2)", w/2 + 150,Y2, w-50, h-10);
    pdfRG1.textSize(midaSubtitol-8);
    float Y3 = Y2 + 50;
    pdfRG1.text("En esta ecuación, G es la constante de gravitación que equivale a 6.67*(10^-11)\nEntonces, lo único que hace falta es substituir.", x+ 30,Y3, w-50, h-10);
    
    if(objetos > 0){
      float Y4 = Y3 + 75;
      float Resp = calcularEjercicioG1();
      pdfRG1.textSize(midaParagraf);
      pdfRG1.text("F = (6.67*(10^-11))*("+CG.m1+"*"+CG.m2+")/("+CG.distancia+"^2) = "+Resp, w/2-150,Y4, w-50, h-10);
      
      pdfRG1.textSize(midaSubtitol-8);
      float Y5 = Y4 + 50;
      pdfRG1.text("Solución: La fuerza de atracción entre los cuerpos astonómicos es "+Resp+"N", x+ 30,Y5, w-50, h-10);          
    }
  pdfRG1.dispose();
  pdfRG1.endDraw();
}

public void exportarEG1(){
  pdfEG1.beginDraw();
    float x = width/6; 
    float y = 0;
    float w = 2*width/3; 
    float h = height;
    pdfEG1.textSize(midaTitol-16); pdfEG1.fill(0); pdfEG1.textAlign(CENTER);
    pdfEG1.text("Explicación Atreacción Estrella-Planeta", width/2, marginV+25);//titol
    pdfEG1.fill(200); pdfRG1.noStroke();
    pdfEG1.rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
    pdfEG1.textSize(midaSubtitol-2);pdfEG1.textAlign(TOP, LEFT); pdfEG1.fill(0);
    //Pregunta
    if(objetos == 0){
      pdfEG1.text("Si un planeta de massa M1 Kg se encuentra a Dist Km de una estrella de massa M2 Kg, ¿cual será la fuerza de atracción entre los dos cuerpos?", x+ 30, y+marginV+55, w-60, h-10);
    }else{
      pdfEG1.text("Si un planeta de massa "+CG.m1+"Kg se encuentra a "+CG.distancia+"Km de una estrella de massa "+CG.m2+"Kg, ¿cual será la fuerza de atracción entre los dos cuerpos?", x+ 30, y+marginV+55, w-60, h-10);
    }
  pdfEG1.dispose();
  pdfEG1.endDraw();
}

public void exportarRG2(){
  pdfRG2.beginDraw();
    float x = width/6; 
    float y = 0;
    float w = 2*width/3; 
    float h = height;
    pdfRG2.textSize(midaTitol-16); pdfRG2.fill(0); pdfRG2.textAlign(CENTER);
    pdfRG2.text("Explicación Velocidad planeta orbital", width/2, marginV+25);//titol
    pdfRG2.fill(200); pdfRG2.noStroke();
    pdfRG2.rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
    pdfRG2.textSize(midaSubtitol-2);pdfRG2.textAlign(TOP, LEFT); pdfRG2.fill(0);
    //Pregunta
    if(objetos == 0){
      pdfRG2.text("Si un cuerpo orbita al rededor de otro y su velocidad en el perihélio (Dist km) es V1 m/s, ¿cual será su velocidad en el afelio (Dist km)?", x+ 30, y+marginV+55, w-60, h-10);
    }else{
      pdfRG2.text("Si un cuerpo orbita al rededor de otro y su velocidad en el perihélio ("+CG.rp+"km) es "+CG.vp+" m/s, ¿cual será su velocidad en el afelio ("+CG.ra+" km)?", x+ 30, y+marginV+55, w-60, h-10);
    }
    //Explicación:
    pdfRG2.textSize(midaSubtitol-8);
    float Y1 = y+marginV+55+200;
    pdfRG2.text("El campo gravitatorio se caracteriza por ser conservativo, lo que significa que la energía mecánica se conserva. Además, según las leyes de Keppler, en una orbita cerrada elíptica, se conserva el movimiento angular. Para simplificar el caso estudiado, se van a considerar los puntos correspondientes al afelio y el perifelio ya que se conoce su distancia y velocidad.", x+ 30,Y1, w-50, h-10);
    pdfRG2.textSize(midaParagraf);
    float Y2 = Y1 + 125;
    pdfRG2.text("Lp = La", w/2 + 150,Y2, w-50, h-10);
    float Y3 = Y2 + 50;
    pdfRG2.text("Rp*Pp = Ra*Pa", w/2 + 150,Y3, w-50, h-10);
    pdfRG2.textSize(midaSubtitol-8);
    float Y4 = Y3 + 50;
    pdfRG2.text("Donde p es la cantidad de movimiento. Entonces, esta se puede escribir como masa por velocidad donde la masa es igual ya que se trata del mismo cuerpo.", x+ 30,Y4, w-50, h-10);
    pdfRG2.textSize(midaParagraf);
    float Y5 = Y4 + 75;
    pdfRG2.text("Rp*m*Vp = Ra*m*Va", w/2 + 150,Y5, w-50, h-10);
    float Y6 = Y5 + 50;
    pdfRG2.text("Rp*Vp = Ra*Va", w/2 + 150,Y6, w-50, h-10);
    pdfRG2.textSize(midaSubtitol-8);
    float Y7 = Y6 + 50;
    pdfRG2.text("Entonces, aislamos:", x+ 30,Y7, w-50, h-10);
    pdfRG2.textSize(midaParagraf);
    pdfRG2.text("Va = (Rp*Vp)/Ra", w/2 + 150,Y7, w-50, h-10);
    
    if(objetos > 0){
      pdfRG2.textSize(midaSubtitol-8);
      float Y8 = Y7 + 50;
      pdfRG2.text("I finalmente, substituimos:", x+ 30,Y8, w-50, h-10);
      float Resp = calcularEjercicioG2();
      pdfRG2.textSize(midaParagraf);
      pdfRG2.text("Va = ("+CG.rp+"*"+CG.vp+")/"+CG.ra+" = "+Resp, w/2 + 150,Y8, w-50, h-10);
      pdfRG2.textSize(midaSubtitol-8);
      float Y9 = Y8 + 50;
      pdfRG2.text("Solución: En el afelio tiene una velocidad de "+Resp+"km/s", x+ 30,Y9, w-50, h-10);
    } 
  pdfRG2.dispose();
  pdfRG2.endDraw();
}

public void exportarEG2(){
  pdfEG2.beginDraw();
    float x = width/6; 
    float y = 0;
    float w = 2*width/3; 
    float h = height;
    pdfEG2.textSize(midaTitol-16); pdfEG2.fill(0); pdfEG2.textAlign(CENTER);
    pdfEG2.text("Explicación Velocidad planeta orbital", width/2, marginV+25);//titol
    pdfEG2.fill(200); pdfEG2.noStroke();
    pdfEG2.rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
    pdfEG2.textSize(midaSubtitol-2);pdfEG2.textAlign(TOP, LEFT); pdfEG2.fill(0);
    //Pregunta
    if(objetos == 0){
      pdfEG2.text("Si un cuerpo orbita al rededor de otro y su velocidad en el perihélio (Dist km) es V1 m/s, ¿cual será su velocidad en el afelio (Dist km)?", x+ 30, y+marginV+55, w-60, h-10);
    }else{
      pdfEG2.text("Si un cuerpo orbita al rededor de otro y su velocidad en el perihélio ("+CG.rp+"km) es "+CG.vp+" m/s, ¿cual será su velocidad en el afelio ("+CG.ra+" km)?", x+ 30, y+marginV+55, w-60, h-10);
    }
  pdfEG2.dispose();
  pdfEG2.endDraw();
}



//ELECTRICO:

public void exportarRE1(){
  pdfRE1.beginDraw();
    float x = width/6; 
    float y = 0;
    float w = 2*width/3; 
    float h = height;
    pdfRE1.textSize(midaTitol-16); pdfRE1.fill(0); pdfRE1.textAlign(CENTER);
    pdfRE1.text("Explicación Partículas cargadas", width/2, marginV+25);//titol
    pdfRE1.fill(200); pdfRE1.noStroke();
    pdfRE1.rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
    pdfRE1.textSize(midaSubtitol-2);pdfRE1.textAlign(TOP, LEFT); pdfRE1.fill(0);
    //Pregunta
    if(objetos == 0){
      pdfRE1.text("¿Cual és la fuerza entre dos particulas cargadas (C1 nC y C2 nC) que se encuentran a D mm de distancia?",x+ 30, y+marginV+55, w-60, h-10);
    }else{
      pdfRE1.text("¿Cual és la fuerza entre dos particulas cargadas ("+P.c1+"nC y "+P.c2+"nC) que se encuentran a "+P.distancia+"mm de distancia?", x+ 30, y+marginV+55, w-60, h-10);
    }
    //Explicación:
    pdfRE1.textSize(midaSubtitol-8);
    float Y1 = y+marginV+55+200;
    pdfRE1.text("La fuerza de atracción entre cuerpoes es debido al campo electrico. De hecho, exsite una fórmula para calcular la fuerza de atracción entre dos partículas cargadas. Esta es la siguiente:", x+ 30,Y1, w-50, h-10);
    float Y2 = Y1 + 100;
    pdfRE1.textSize(midaParagraf);
    pdfRE1.text("F = K*(C1*C2)/(r^2)", w/2 + 150,Y2, w-50, h-10);
    pdfRE1.textSize(midaSubtitol-8);
    float Y3 = Y2 + 50;
    pdfRE1.text("En esta ecuación, K es la constante del campo eléctrico que se aproxima que equivale a 9*(10^9)\nEntonces, lo único que hace falta es substituir.", x+ 30,Y3, w-50, h-10);
    if(objetos > 0){
      float Y4 = Y3 + 100;
      float Resp = calcularEjercicioE1();
      pdfRE1.textSize(midaParagraf);
      pdfRE1.text("F = (9*(10^9))*("+P.c1+"*"+P.c2+")/("+P.distancia+"^2) = "+Resp, w/2,Y4, w-50, h-10);
      
      pdfRE1.textSize(midaSubtitol-8);
      float Y5 = Y4 + 50;
      if(P.c1 > 0 && P.c2 > 0 || P.c1 < 0 && P.c2 < 0){
        pdfRE1.text("La fuerza entre las partículas es de "+Resp+"F repulsiva", x+30, Y5, w-30, h);
      }else{
        pdfRE1.text("La fuerza entre las partículas es de "+Resp+"F atractiva", x+30, Y5, w-30, h);
      }        
    }
  pdfRE1.dispose();
  pdfRE1.endDraw();
}

public void exportarEE1(){
  pdfEE1.beginDraw();
    float x = width/6; 
    float y = 0;
    float w = 2*width/3; 
    float h = height;
    pdfEE1.textSize(midaTitol-16); pdfEE1.fill(0); pdfEE1.textAlign(CENTER);
    pdfEE1.text("Explicación Partículas cargadas", width/2, marginV+25);//titol
    pdfEE1.fill(200); pdfEE1.noStroke();
    pdfEE1.rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
    pdfEE1.textSize(midaSubtitol-2);pdfEE1.textAlign(TOP, LEFT); pdfEE1.fill(0);
    //Pregunta
    if(objetos == 0){
      pdfEE1.text("¿Cual és la fuerza entre dos particulas cargadas (C1 nC y C2 nC) que se encuentran a D mm de distancia?",x+ 30, y+marginV+55, w-60, h-10);
    }else{
      pdfEE1.text("¿Cual és la fuerza entre dos particulas cargadas ("+P.c1+"nC y "+P.c2+"nC) que se encuentran a "+P.distancia+"mm de distancia?", x+ 30, y+marginV+55, w-60, h-10);
    }
  pdfEE1.dispose();
  pdfEE1.endDraw();
}

public void exportarRE2(){
  pdfRE2.beginDraw();
    float x = width/6; 
    float y = 0;
    float w = 2*width/3; 
    float h = height;
    pdfRE2.textSize(midaTitol-16); pdfRE2.fill(0); pdfRE2.textAlign(CENTER);
    pdfRE2.text("Explicación Equilibrio eléctrico", width/2, marginV+25);//titol
    pdfRE2.fill(200); pdfRE2.noStroke();
    pdfRE2.rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
    pdfRE2.textSize(midaSubtitol-2);pdfRE2.textAlign(TOP, LEFT); pdfRE2.fill(0);
    //Pregunta
    if(objetos == 0){
      pdfRE2.text("¿Cuál debe ser la separación entre dos placas infinits con diferencia de potencial v V para mantener unelectrón en equilibrio?", x+ 30, y+marginV+55, w-60, h-10);
    }else{
      pdfRE2.text("¿Cuál debe ser la separación entre dos placas infinitas con diferencia de potencial "+P.V+" V para mantener unelectrón en equilibrio?", x+ 30, y+marginV+55, w-60, h-10);
    }
    float Y1 = y+marginV+55+200;
    pdfRE2.textSize(midaSubtitol-8);
    pdfRE2.text("Cuando dos planos cargados eléctricamente se encuentran cerca, se establece una diferencia de potenciasl. Al acercarse más y ser paralelos e infinitos, esta diferencia de potencial crea un campo eléctrico constante que se define de la siguiente manera:", x+30, Y1, w-30, h);
    pdfRE2.textSize(midaParagraf);
    float Y2 = Y1+ 150;
    pdfRE2.text("E = DV/d", w/2+ 250,Y2, w-50, h-10);
    float Y3 = Y2 +50;
    pdfRE2.textSize(midaSubtitol-8);
    pdfRE2.text("Que estén en equilibrio significa que la fuerza eléctrica se iguala con el peso. por lo tanto, se pueden igualar los módulos", x+30, Y3, w-30, h);
    pdfRE2.textSize(midaParagraf);
    float Y4 = Y3+ 50;
    pdfRE2.text("F = P", w/2 + 250,Y4, w-50, h-10);
    float Y5 = Y4+ 50;
    pdfRE2.text("q*E = m*g", w/2+ 250,Y5, w-50, h-10);
    float Y6 = Y5+ 50;
    pdfRE2.text("q*V/d = m*g", w/2+ 250,Y6, w-50, h-10);
    float Y7 = Y6 +50;
    pdfRE2.textSize(midaSubtitol-8);
    pdfRE2.text("Seguidamente, de aisla la distancia:", x+30, Y7, w-30, h);
    pdfRE2.textSize(midaParagraf);
    pdfRE2.text("d = (q*V)/(m*g)", w/2+ 250,Y7, w-50, h-10);
    if(objetos > 0){
     float Y8 = Y7 +50;
     pdfRE2.textSize(midaSubtitol-8);
     pdfRE2.text("Finalmente, se substituye:", x+30, Y8, w-30, h);
     pdfRE2.textSize(midaParagraf);
     float Resp = calcularEjercicioE2();
     pdfRE2.text("d = (1.6*(10^-19)*"+P.V+")/(9.1*(10^-31)*9.81) = "+Resp, w/2+ 250,Y8, w-50, h-10);
     float Y9 = Y8+50;
     pdfRE2.textSize(midaSubtitol-8);
     if(P.V > 0){
       pdfRE2.text("Solución: Tendrá que tener una carga de "+Resp+"C para mantenerse en equilibrio", x+30, Y9, w-30, h);
     }else{
       pdfRE2.text("Solución: No se podrá aguantar", x+30, Y9, w-30, h);
     }
    }
  pdfRE2.dispose();
  pdfRE2.endDraw();
}

public void exportarEE2(){
  pdfEE2.beginDraw();
    float x = width/6; 
    float y = 0;
    float w = 2*width/3; 
    float h = height;
    pdfEE2.textSize(midaTitol-16); pdfEE2.fill(0); pdfEE2.textAlign(CENTER);
    pdfEE2.text("Explicación Equilibrio eléctrico", width/2, marginV+25);//titol
    pdfEE2.fill(200); pdfEE2.noStroke();
    pdfEE2.rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
    pdfEE2.textSize(midaSubtitol-2);pdfEE2.textAlign(TOP, LEFT); pdfEE2.fill(0);
    //Pregunta
    if(objetos == 0){
      pdfEE2.text("¿Cuál debe ser la separación entre dos placas infinits con diferencia de potencial v V para mantener unelectrón en equilibrio?", x+ 30, y+marginV+55, w-60, h-10);
    }else{
      pdfEE2.text("¿Cuál debe ser la separación entre dos placas infinitas con diferencia de potencial "+P.V+" V para mantener unelectrón en equilibrio?", x+ 30, y+marginV+55, w-60, h-10);
    }
  pdfEE2.dispose();
  pdfEE2.endDraw();
}



//Magnético

public void exportarRM1(){
  pdfRM1.beginDraw();
    float x = width/6; 
    float y = 0;
    float w = 2*width/3; 
    float h = height;
    pdfRM1.textSize(midaTitol-16); pdfRM1.fill(0); pdfRM1.textAlign(CENTER);
    pdfRM1.text("Explicación Fuerza entre hilos", width/2, marginV+25);//titol
    pdfRM1.fill(200); pdfRM1.noStroke();
    pdfRM1.rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
    pdfRM1.textSize(midaSubtitol-2); pdfRM1.textAlign(TOP, LEFT); pdfRM1.fill(0);
    //Pregunta
    if(objetos == 0){
      pdfRM1.text("Si se consideran dos hilos conductores con intensidades I1 A y I2 A que distan de Dist m ¿Qué valdrá la fuerza producida entre ellos?", x+ 30, y+marginV+55, w-60, h-10);
    }else{
      pdfRM1.text("Si se consideran dos hilos conductores con intensidades "+CM.I1+"A y "+CM.I2+"A que distan de "+CM.distancia+"mm  ¿Qué valdrá la fuerza producida entre ellos?", x+ 30, y+marginV+55, w-60, h-10);
    }
    //Explicación:
    float Y1 = y+marginV+55+200;
    pdfRM1.textSize(midaSubtitol-8);
    pdfRM1.text("En esto problema, existen dos casos. Por un lado, si los verctores de la intensidad de los hilos van en el mismo sentido, la fuerza será actractiva, en cambio, si van en sentido contrario, será repulsiva. De igual manera, su valor se puede calcular con el módulo siguiendo la siguiente expresión:", x+30, Y1, w-30, h);
    float Y2 = Y1 + 125;
    pdfRM1.textSize(midaParagraf);
    pdfRM1.text("F = NUo*(I1*I2)/(2*PI*r)", w/2 + 150,Y2, w-50, h-10);
    pdfRM1.textSize(midaSubtitol-8);
    float Y3 = Y2 + 50;
    pdfRM1.text("En esta ecuación, NUo es la resistivitat magnética del medio que equivale a 4*PI*(10^-7)\nEntonces, lo único que hace falta es substituir.", x+ 30,Y3, w-50, h-10);
    
    if(objetos > 0){
      float Y4 = Y3 + 75;
      float Resp = calcularEjercicioM1();
      pdfRM1.textSize(midaParagraf);
      pdfRM1.text("F = (4*PI*(10^-7))*("+CM.I1+"*"+CM.I2+")/(2*PI*"+CM.distancia+") = "+Resp, w/2-150,Y4, w-50, h-10);
      
      pdfRM1.textSize(midaSubtitol-8);
      float Y5 = Y4 + 50;
      if(CM.I1< 0 && CM.I2< 0 || CM.I1> 0 && CM.I2> 0){
        pdfRM1.text("Solución: La fuerza entre los hilos es de "+Resp+"F atractiva", x+30, Y5, w-30, h);
      }else{
        pdfRM1.text("Solución: La fuerza entre los hilos es de "+Resp+"F repulsiva", x+30, Y5, w-30, h);
      }        
    }
  pdfRM1.dispose();
  pdfRM1.endDraw();
}

public void exportarEM1(){
  pdfEM1.beginDraw();
    float x = width/6; 
    float y = 0;
    float w = 2*width/3; 
    float h = height;
    pdfEM1.textSize(midaTitol-16); pdfEM1.fill(0); pdfEM1.textAlign(CENTER);
    pdfEM1.text("Explicación Fuerza entre hilos", width/2, marginV+25);//titol
    pdfEM1.fill(200); pdfEM1.noStroke();
    pdfEM1.rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
    pdfEM1.textSize(midaSubtitol-2); pdfEM1.textAlign(TOP, LEFT); pdfEM1.fill(0);
    //Pregunta
    if(objetos == 0){
      pdfEM1.text("Si se consideran dos hilos conductores con intensidades I1 A y I2 A que distan de Dist m ¿Qué valdrá la fuerza producida entre ellos?", x+ 30, y+marginV+55, w-60, h-10);
    }else{
      pdfEM1.text("Si se consideran dos hilos conductores con intensidades "+CM.I1+"A y "+CM.I2+"A que distan de "+CM.distancia+"mm  ¿Qué valdrá la fuerza producida entre ellos?", x+ 30, y+marginV+55, w-60, h-10);
    }
  pdfEM1.dispose();
  pdfEM1.endDraw();
}

public void exportarRM2(){
  pdfRM2.beginDraw();
    float x = width/6; 
    float y = 0;
    float w = 2*width/3; 
    float h = height;
    pdfRM2.textSize(midaTitol-16); pdfRM2.fill(0); pdfRM2.textAlign(CENTER);
    pdfRM2.text("Explicació Espira conductora", width/2, marginV+25);//titol
    pdfRM2.fill(200); pdfRM2.noStroke();
    pdfRM2.rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
    pdfRM2.textSize(midaSubtitol-2); pdfRM2.textAlign(TOP, LEFT); pdfRM2.fill(0);
    //Pregunta
    if(objetos == 0){
      pdfRM2.text("¿Cual es el valor del campo magnético en una espira de radio R mm que conduce una intensidad de I A?", x+ 30, y+marginV+55, w-60, h-10);
    }else{
      pdfRM2.text("¿Cual es el valor del campo magnético en una espira de radio "+CM.distancia+" mm que conduce una intensidad de "+CM.I1+" A?", x+ 30, y+marginV+55, w-60, h-10);
    }
    //Explicación:
    float Y1 = y+marginV+55+200;
    pdfRM2.textSize(midaSubtitol-8);
    pdfRM2.text("En esto problema, existen dos casos. Por un lado, si la intensidad es positiva(es decir, circula en sentido horario) el vecor del campo magnético irá hacia dentro del plano del papel. En cambio, si es negativa, irá hacia fuera. De igual manera, su valor se puede calcular con el módulo siguiendo la siguiente expresión:", x+30, Y1, w-30, h);
    float Y2 = Y1 + 125;
    pdfRM2.textSize(midaParagraf);
    pdfRM2.text("B = NUo*(I)/(2*r)", w/2 + 150,Y2, w-50, h-10);
    pdfRM2.textSize(midaSubtitol-8);
    float Y3 = Y2 + 50;
    pdfRM2.text("En esta ecuación, NUo es la resistivitat magnética del medio que equivale a 4*PI*(10^-7)\nEntonces, lo único que hace falta es substituir.", x+ 30,Y3, w-50, h-10);
    if(objetos > 0){
      float Y4 = Y3 + 75;
      float Resp = calcularEjercicioM2();
      pdfRM2.textSize(midaParagraf);
      pdfRM2.text("F = (4*PI*(10^-7))*("+CM.I1+")/(2*"+CM.distancia+") = "+Resp, w/2,Y4, w-50, h-10);
      
      pdfRM2.textSize(midaSubtitol-8);
      float Y5 = Y4 + 50;
      if(CM.I1>0){
        pdfRM2.text("El campo magnetico generado es de "+Resp+"T hacia dentro de la pantalla", x+30, Y5, w-30, h);
      }else{
        pdfRM2.text("El campo magnetico generado es de "+Resp+"T hacia fuera de la pantalla", x+30, Y5, w-30, h);
      } 
    }
  pdfRM2.dispose();
  pdfRM2.endDraw();
}

public void exportarEM2(){
  pdfEM2.beginDraw();
    float x = width/6; 
    float y = 0;
    float w = 2*width/3; 
    float h = height;
    pdfEM2.textSize(midaTitol-16); pdfEM2.fill(0); pdfEM2.textAlign(CENTER);
    pdfEM2.text("Explicación Espira conductora", width/2, marginV+25);//titol
    pdfEM2.fill(200); pdfEM2.noStroke();
    pdfEM2.rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
    pdfEM2.textSize(midaSubtitol-2); pdfEM2.textAlign(TOP, LEFT); pdfEM2.fill(0);
    //Pregunta
    if(objetos == 0){
      pdfEM2.text("¿Cual es el valor del campo magnético en una espira de radio R mm que conduce una intensidad de I A?", x+ 30, y+marginV+55, w-60, h-10);
    }else{
      pdfEM2.text("¿Cual es el valor del campo magnético en una espira de radio "+CM.distancia+" mm que conduce una intensidad de "+CM.I1+" A?", x+ 30, y+marginV+55, w-60, h-10);
    }
  pdfEM2.dispose();
  pdfEM2.endDraw();
}
class Fletxa {
  
  PVector p, q;
  float cx, cy;

  Fletxa(float x1, float y1, float x2, float y2){
    p = new PVector(x1, y1);
    q = new PVector(x2, y2);
    cx = x2-x1;
    cy = y2-y1;
  }
  
  Fletxa(){}
  
  public float distance(){
    return p.dist(q);
  }
  
  public void changePoints(float x1, float y1, float x2, float y2){
    p = new PVector(x1, y1);
    q = new PVector(x2, y2);
    cx = x2-x1;
    cy = y2-y1;
  }
  
  public float angle() {
        PVector a2 = p.copy().add(1, 0);
        float angle1 = atan2(a2.y - p.y, p.x - a2.x);
        float angle2 = atan2(q.y - p.y, p.x - q.x);
        float angle = (float) degrees(angle1 - angle2);
        if (angle < 0) angle += 360;
        if(angle>=360) angle-=360;
        return angle;
    }
  
  public void display(int c){
    pushStyle();
    stroke(c); strokeWeight(3);
    line(this.p.x, this.p.y, this.q.x, this.q.y);
    
    float a = angle();
    float d = distance()/6;
    
    float a1 = radians(a-10);
    float fx1 = this.q.x - d*cos(a1);
    float fy1 = this.q.y - d*sin(a1);
    
    
    float a2 = radians(a+10);
    float fx2 = this.q.x - d*cos(a2);
    float fy2 = this.q.y - d*sin(a2);
    
    fill(c);
    line(this.q.x, this.q.y, fx1, fy1);
    triangle(this.q.x, this.q.y, fx1, fy1, fx2, fy2);
    popStyle();
  }
}
// Fitxer amb la informació dels Fonts de l'App
  
// Array de tipografies
PFont[] fonts;
  
// Estableix les fonts de l'App
public void setFonts(){
    this.fonts = new PFont[3];
    this.fonts[0] = createFont("fonts/jackinput.TTF", midaTitol); //Título
    this.fonts[1] = createFont("fonts/monofonto.otf", 23); //Subtítulo
    this.fonts[2] = createFont("fonts/Sono-medium.ttf", midaParagraf); //texto
}
  
  public PFont getFont(String s){
    if(s.equals("Titulo")){
      return this.fonts[0];
    }else if(s.equals("Subtítulo")){
      return this.fonts[1];
    }else{
      return this.fonts[2];
    }
  }
// Fitxer amb la informació dels Medias de l'App

// URL de la carpeta on hi ha les imatges
String URL_IMGS = "imgs/";
String URL_RATING = "Rating/";
String URL_PORTADAS = "Portadas/";
String URL_EJERCICIOS = "Ejercicios/";
String URL_RESOLUCIONES = "Resoluciones/";


//IMAGES
PImage background;
// Array d'imatges (JPG, PNG, GIF)
PImage[] imgs;

PImage[] stars;

PImage[] portadas;

PImage[] ejercicios;
  
//IMATGES EXERCICIS
PImage monigote, vidrio, ojo, abeja;

//IMAGENES RESOLUCIONES
PImage pit1, pit2;

// Estableix les imatges de l'App
public void setMedias(){
  background = loadImage(URL_IMGS+"Background.png");
  
    this.imgs = new PImage[3];
    this.imgs[0] = loadImage(URL_IMGS+"Electron.png"); //Electron
    this.imgs[1] = loadImage(URL_IMGS+"Proton.png"); //Proton
    
    //Iniciar imagen de estrellas
    this.stars = new PImage[5];
    for(int i = 0; i<stars.length; i++){
      int n = i+1;
      this.stars[i] = loadImage(URL_IMGS+URL_RATING+n+".png"); 
    }
    
    this.portadas = new PImage[6];//C:\IB\AI_Informatica\Soluci__inform_tica\data\imgs\Portadas\Ejercicios
    portadas[0] = loadImage(URL_IMGS+URL_PORTADAS+"Cinematica.png");
    portadas[1] = loadImage(URL_IMGS+URL_PORTADAS+"Dinamica.png");
    portadas[2] = loadImage(URL_IMGS+URL_PORTADAS+"Optica.png");
    portadas[3] = loadImage(URL_IMGS+URL_PORTADAS+"Gravitatori.png");
    portadas[4] = loadImage(URL_IMGS+URL_PORTADAS+"Electric.png");
    portadas[5] = loadImage(URL_IMGS+URL_PORTADAS+"Magnetic.png");
    
    ejercicios = new PImage[12];
    ejercicios[0] = loadImage(URL_IMGS+URL_PORTADAS+URL_EJERCICIOS+"C1.png");
    ejercicios[1] = loadImage(URL_IMGS+URL_PORTADAS+URL_EJERCICIOS+"C2.png");
    ejercicios[2] = loadImage(URL_IMGS+URL_PORTADAS+URL_EJERCICIOS+"D1.png");
    ejercicios[3] = loadImage(URL_IMGS+URL_PORTADAS+URL_EJERCICIOS+"D2.png");
    ejercicios[4] = loadImage(URL_IMGS+URL_PORTADAS+URL_EJERCICIOS+"O1.png");
    ejercicios[5] = loadImage(URL_IMGS+URL_PORTADAS+URL_EJERCICIOS+"O2.png");
    ejercicios[6] = loadImage(URL_IMGS+URL_PORTADAS+URL_EJERCICIOS+"G1.png");
    ejercicios[7] = loadImage(URL_IMGS+URL_PORTADAS+URL_EJERCICIOS+"G2.png");
    ejercicios[8] = loadImage(URL_IMGS+URL_PORTADAS+URL_EJERCICIOS+"E1.png");
    ejercicios[9] = loadImage(URL_IMGS+URL_PORTADAS+URL_EJERCICIOS+"E2.png");
    ejercicios[10] = loadImage(URL_IMGS+URL_PORTADAS+URL_EJERCICIOS+"M1.png");
    ejercicios[11] = loadImage(URL_IMGS+URL_PORTADAS+URL_EJERCICIOS+"M2.png");
    
    monigote = loadImage(URL_IMGS+URL_EJERCICIOS+"Monigote.png");
    vidrio = loadImage(URL_IMGS+URL_EJERCICIOS+"Vidrio.png");
    ojo = loadImage(URL_IMGS+URL_EJERCICIOS+"Ojo.png");
    abeja = loadImage(URL_IMGS+URL_EJERCICIOS+"Abeja.png");
    
    pit1 = loadImage(URL_IMGS+URL_RESOLUCIONES+"Pit1.png");
    pit2 = loadImage(URL_IMGS+URL_RESOLUCIONES+"Pit2.png");
}
  
  public PImage getImage(String s){
    if(s.equals("Proton")){
      return this.imgs[0];
    }else if(s.equals("Electron")){
      return this.imgs[1];
    }else if(s.equals("Estrella")){
    }
    return loadImage(URL_IMGS+"/red.png");
  }
public void setGUI(){
  setColors(); 
  setFonts();
  setBBDD();
  setCards(); 
  setButtons();
  setSeleccionador();
  setFormulasTable();
  setFormularis();
  setTaules(); 
  setDesktop(); 
  setTFnumbers();
  setMedias(); 
  createGraphicsPDF();
}


public void setDesktop(){
  //Desktop
  desktop = Desktop.getDesktop();
}
//BUTTONS
  //Atrás
    Button bAtras = new Button("Atras");
  //Inici
    //Exercicis
    Button bCinematica = new Button("CINEMÀTICA");
    Button bDinamica = new Button("DINÀMICA");
    Button bOptica = new Button("ÒPTICA");
    Button bGravitatori = new Button("CAMP GRAVITATÒRI");
    Button bElectric = new Button("CAMP ELÈCTRIC");
    Button bMagnetic = new Button("CAMP MAGNÈTIC");
    //Otros
    Button bApp = new Button("Pagina Web Oficial");
    Button bFAQs = new Button("FAQs");
    Button bProponer = new Button("Proponer Ejercicio");
  //Selecció d'exercicis
    Button[] buttonsExercicis = new Button[12];
    //Cienamàtica
      Button bC1 = new Button("CINEMÀTICA 1");
      Button bC2 = new Button("CINEMÀTICA 2");
    //Dinamica
      Button bD1 = new Button("DINÀMICA 1");
      Button bD2 = new Button("DINÀMICA 2");
    //Optica
      Button bO1 = new Button("ÒPTICA 1");
      Button bO2 = new Button("ÒPTICA 2");
    //CAMP GRAVITATORI
      Button bG1 = new Button("CAMP GRAVITATÒRI 1");
      Button bG2 = new Button("CAMP GRAVITATÒRI 2");
    //CAMP ELECTRIC
      Button bE1 = new Button("CAMP ELÈCTRIC 1");
      Button bE2 = new Button("CAMP ELÈCTRIC 2");
    //CAMP MAGNETIC
      Button bM1 = new Button("CAMP MAGNÈTIC 1");
      Button bM2 = new Button("CAMP MAGNÈTIC 2");
    
  
  //Interacció d'exercicis
  
    //Visualització
      //Zoom
        Button bzoomMas = new Button("+");
        Button bzoomMenos = new Button("-");
        
      //Dreta/esquerra
        Button bDerecha = new Button("->");
        Button bIzquierda = new Button ("<-");
    //Añadir
      //Enter
        Button bADD = new Button("Dar Valores");
        
      //Leave
        Button bADDLeave = new Button("Dar Valores");
      //Random Values
        Button bADDRanValues = new Button("Valores Aleatorios");
      
    //Formulari
      Button bFORMULARIO = new Button("Formulari");

    //Explicació
      Button bEXPLICACION = new Button("Explicar");
      
    //Reset
      Button bRESET = new Button("Nuevos valores");

    
    //Exportar
      //Enter
        Button bEXPORT = new Button("Exportar");

      //Enunciat  
        Button bEXPORTEnu = new Button("Enunciado");

      //Resposta
        Button bEXPORTRes = new Button("Respuesta");
      
      
  //Seleccionadors
    //Enunciado i respuestas
       Button Enunciado = new Button("Enunciado");
       Button Respuestas = new Button("Respuestas");
       
       
     Button[] Buttons = new Button[52];
    public void setButtons(){
      //Exercicis
        buttonsExercicis[0] = bC1;
        buttonsExercicis[1] = bC2;
        buttonsExercicis[2] = bD1;
        buttonsExercicis[3] = bD2;
        buttonsExercicis[4] = bO1;
        buttonsExercicis[5] = bO2;
        buttonsExercicis[6] = bG1;
        buttonsExercicis[7] = bG2;
        buttonsExercicis[8] = bE1;
        buttonsExercicis[9] = bE2;
        buttonsExercicis[10] = bM1;
        buttonsExercicis[11] = bM2;
    }
    
    
//CARDS
  Card[] cards;
  
  public void setCards(){
    cards = new Card[6];
    
    cards[0] = new Card(TEMA.CINEMATICA, 1, bCinematica);
    cards[1] = new Card(TEMA.DINAMICA, 2, bDinamica);
    cards[2] = new Card(TEMA.OPTICA, 3, bOptica);
    cards[3] = new Card(TEMA.GRAVITATORI, 4, bGravitatori);
    cards[4] = new Card(TEMA.ELECTRIC, 4, bElectric);
    cards[5] = new Card(TEMA.MEGNETIC, 5, bMagnetic);
  }
  
//Selecionadors
  Seleccionador s1 = new Seleccionador(); 
  
  public void setSeleccionador(){
    s1.setBotons(2, Enunciado, Respuestas);
  }
  
//TABLES
  //FORMULARIS:
    //Informació:
      //Nombre de files:
        int nCr = 8;
        int nDr = 8;
        int nOr = 8;
        int nGr = 8;
        int nEr = 8;
        int nMr = 8;
      //Nombre columnes:
        int nc = 3;
      //Proportions
        float[] porportions = {20, 50, 30};
        
      //informació Taules:
        String[] header = {"Variable", "Definición", "Unidad en SI"};
        
String[] F1 = new String[3];
String[] F2 = new String[3];
String[] F3 = new String[3];
String[] F4 = new String[3];
String[] F5 = new String[3];
String[] F6 = new String[3];
String[] F7 = new String[3];
String[] F8 = new String[3];
String[] F9 = new String[3];
String[] F10 = new String[3];
String[] F11 = new String[3];
String[] F12 = new String[3];
String[] F13 = new String[3];
String[] F14 = new String[3];
String[] F15 = new String[3];
String[] F16 = new String[3];
String[] F17 = new String[3];
String[] F18 = new String[3];
String[] F19 = new String[3];
String[] F20 = new String[3];
String[] F21 = new String[3];


String[][] infoCt;
String[][] infoDt;
String[][] infoOt;
String[][] infoEt;
String[][] infoGt;
String[][] infoMt;


public void setFormularis(){
  F1 = getInfoFormulario(1);
  F2 = getInfoFormulario(2);
  F3 = getInfoFormulario(3);
  F4 = getInfoFormulario(4);
  F5 = getInfoFormulario(5);
  F6 = getInfoFormulario(6);
  F7 = getInfoFormulario(7);
  F8 = getInfoFormulario(8);
  F9 = getInfoFormulario(9);
  F10 = getInfoFormulario(10);
  F11 = getInfoFormulario(11);
  F12 = getInfoFormulario(12);
  F13 = getInfoFormulario(13);
  F14 = getInfoFormulario(14);
  F15 = getInfoFormulario(15);
  F16 = getInfoFormulario(16);
  F17 = getInfoFormulario(17);
  F18 = getInfoFormulario(18);
  F19 = getInfoFormulario(19);
  F20 = getInfoFormulario(20);
  F21 = getInfoFormulario(21);
  String[][] C = {F1,F2,F3,F4,F5,F6,
                 {"", "", ""},
                 {"", "", ""}}; 
  infoCt = C;   
  String[][] D = {F7,F8,F9,
                 {"", "", ""},
                 {"", "", ""},
                 {"", "", ""},
                 {"", "", ""},
                 {"", "", ""}};
  infoDt = D;
  String[][] O = {F10,F11,F12,F13,
                      {"", "", ""},
                      {"", "", ""},
                      {"", "", ""},
                      {"", "", ""}};
  infoOt = O;
  String[][] G = {F14,F15,F16,
                      {"", "", ""},
                      {"", "", ""},
                      {"", "", ""},
                      {"", "", ""},
                      {"", "", ""}};
  infoGt = G;
  String[][] E = {F17,F18,F19,
                      {"", "", ""},
                      {"", "", ""},
                      {"", "", ""},
                      {"", "", ""},
                      {"", "", ""}};
  infoEt = E;
  String[][] M = {F20,F21,
                 {"", "", ""},
                 {"", "", ""},
                 {"", "", ""},
                 {"", "", ""},
                 {"", "", ""},
                 {"", "", ""}};
  infoMt = M;
}
        
    //Talbes
    Table tCfor = new Table(nCr, nc); 
    Table tDfor = new Table(nGr, nc); 
    Table tOfor = new Table(nOr, nc); 
    Table tGfor = new Table(nGr, nc); 
    Table tEfor = new Table(nEr, nc); 
    Table tMfor = new Table(nMr, nc); 
    
    String[] formules = {"Formules"};
    float[] proportionsF = {100};
    
    String[][] infoCf;
    String[][] infoDf;
    String[][] infoOf;
    String[][] infoGf;
    String[][] infoEf;
    String[][] infoMf;
    
    String For1;
    String For2;
    String For3;
    String For4;
    String For5;
    String For6;
    String For7;
    String For8;
    String For9;
    String For10;
    String For11;
    String For12;
    String For13;
    String For14;
    String For15;
    
    public void setFormulasTable(){
      For1 = getInfoFormula(1);
      For2 = getInfoFormula(2);
      For3 = getInfoFormula(3);
      For4 = getInfoFormula(4);
      For5 = getInfoFormula(5);
      For6 = getInfoFormula(6);
      For7 = getInfoFormula(7);
      For8 = getInfoFormula(8);
      For9 = getInfoFormula(9);
      For10 = getInfoFormula(10);
      For11 = getInfoFormula(11);
      For12 = getInfoFormula(12);
      For13 = getInfoFormula(13);
      For14 = getInfoFormula(14);
      For15 = getInfoFormula(15);
      
      
        String[][] C = {{For1},
                        {For2},
                        {For3},
                        {""},
                        {""},
                        {""},
                        {""},
                        {""}};
        infoCf = C;
        String[][] D = {{For4},
                       {For5},
                       {For6},
                       {""},
                       {""},
                       {""},
                       {""},
                       {""}};
        infoDf = D;
        String[][] O = {{For7},
                       {For8},
                       {""},
                       {""},
                       {""},
                       {""},
                       {""},
                       {""}};
        infoOf = O;
        String[][] G = {{For9},
                       {For10},
                       {For11},
                       {""},
                       {""},
                       {""},
                       {""},
                       {""}};
         infoGf = G;
        String[][] E = {{For12},
                       {For13},
                       {""},
                       {""},
                       {""},
                       {""},
                       {""},
                       {""}};
        infoEf = E;
        String[][] M = {{For14},
                       {For15},
                       {""},
                       {""},
                       {""},
                       {""},
                       {""},
                       {""}};
        infoMf = M; 
    }
            
                             
     Table fC = new Table(nCr, 1);
     Table fD = new Table(nDr, 1);
     Table fO = new Table(nOr, 1);
     Table fG = new Table(nGr, 1);
     Table fE = new Table(nEr, 1);
     Table fM = new Table(nMr, 1);
    
  public void setTaules(){
    //Proportions
      tCfor.setColumnWidths(porportions);
      tDfor.setColumnWidths(porportions);
      tOfor.setColumnWidths(porportions);
      tGfor.setColumnWidths(porportions);
      tEfor.setColumnWidths(porportions);
      tMfor.setColumnWidths(porportions);
    //Headers
      tCfor.setHeaders(header);
      tDfor.setHeaders(header);
      tOfor.setHeaders(header);
      tGfor.setHeaders(header);
      tEfor.setHeaders(header);
      tMfor.setHeaders(header);
    //Information 
      tCfor.setData(infoCt);
      tDfor.setData(infoDt);
      tOfor.setData(infoOt);
      tGfor.setData(infoGt);
      tEfor.setData(infoEt);
      tMfor.setData(infoMt);
      
    //Proportions
      fC.setColumnWidths(proportionsF);
      fD.setColumnWidths(proportionsF);
      fO.setColumnWidths(proportionsF);
      fG.setColumnWidths(proportionsF);
      fE.setColumnWidths(proportionsF);
      fM.setColumnWidths(proportionsF);

    //Headers
      fC.setHeaders(formules);
      fD.setHeaders(formules);
      fO.setHeaders(formules);
      fG.setHeaders(formules);
      fE.setHeaders(formules);
      fM.setHeaders(formules);
    
    //Information
      fC.setData(infoCf);
      fD.setData(infoDf);
      fO.setData(infoOf);
      fG.setData(infoGf);
      fE.setData(infoEf);
      fM.setData(infoMf);
      
  }
  
//TextFields
  //ADD:
    //Cinemática:
      //Nombre
      TextField tfCaddName = new TextField("Nombre");
      //Posición
      TextField tfCaddPos1 = new TextField("Posición");
      TextField tfCaddPos2 = new TextField("Posición");
      //Velocidad
      TextField tfCaddVel = new TextField("Velocitat");
      
      //
      TextField tfCaddAngle = new TextField("Ángulo");
      TextField tfCaddHigh = new TextField ("Altura");
      
      TextField tfDaddF = new TextField("Fuerza");
      TextField tfDaddMasa = new TextField("Masa");
      TextField tfDaddNu = new TextField("Nu");
      
      TextField tfOXobs = new TextField("Distancia Obs-V");
      TextField tfOXabeja = new TextField("Distancia 'x' Abeja-Obs");
      TextField tfOYabeja = new TextField("Distancia 'y' Abeja-Obs");
      
      TextField tfOAngulo = new TextField("Ángulo");
      TextField tfOn1 = new TextField("n 1");
      TextField tfOn2 = new TextField("n 2");
      
      TextField tfGm1 = new TextField("Masa Planeta");
      TextField tfGm2 = new TextField("Masa Estrella");
      TextField tfGDistancias = new TextField("Distancia");
      
      TextField tfGr1 = new TextField("Radio Perihelio");
      TextField tfGr2 = new TextField("Radio Afelio");
      TextField tfGv1 = new TextField("Vel. Perihelio");
      
      
      TextField tfEc1 = new TextField("Carga 1");
      TextField tfEc2 = new TextField("Carga 2");
      
      TextField tfEV = new TextField("Diferencia de potencial");
      
      TextField tfMI1 = new TextField("Intensidad 1");
      TextField tfMI2 = new TextField("Intensidad 2");
      
      TextField ftMIntensidad = new TextField("Intensidad");
      TextField tfMRadio = new TextField ("Radio");
      
      
      //Set numerics
      public void setTFnumbers(){
        tfCaddPos1.numerical = true;
        tfCaddPos2.numerical = true;
        
        tfCaddVel.numerical = true;
              
        tfCaddAngle.numerical = true;
        tfCaddHigh.numerical = true;
              
        tfDaddF.numerical = true;
        tfDaddMasa.numerical = true;
        tfDaddNu.numerical = true;
              
        tfOXobs.numerical = true;
        tfOXabeja.numerical = true;
        tfOYabeja.numerical = true;
              
        tfOAngulo.numerical = true;
        tfOn1.numerical = true;
        tfOn2.numerical = true;
              
        tfGm1.numerical = true;
        tfGm2.numerical = true;
        tfGDistancias.numerical = true;
              
        tfGr1.numerical = true;
        tfGr2.numerical = true;
        tfGv1.numerical = true;
              
              
        tfEc1.numerical = true;
        tfEc2.numerical = true;
              
        tfEV.numerical = true;
              
        tfMI1.numerical = true;
        tfMI2.numerical = true;
              
        ftMIntensidad.numerical = true;
        tfMRadio.numerical = true;
      }
//Objetos
  //Mobiles
    Mobil m0 = new Mobil();
    Mobil m1 = new Mobil();
  //Cajas
    Caja c0 = new Caja();
    
  //Luz
  Luz l = new Luz();
  
  //Campo Gravitatorio
  CampoGravitatorio CG = new CampoGravitatorio();
  
  //Campo Electrico
  Particula P = new Particula();
  
  //Campo Magnetico
  CampoMagnetico CM = new CampoMagnetico();
  
  //Vectores
    Vector C1vectors;
    
    
//PDFs
PGraphics pdfRC1;
PGraphics pdfEC1;
PGraphics pdfRC2;
PGraphics pdfEC2;
PGraphics pdfRD1;
PGraphics pdfED1;
PGraphics pdfRD2;
PGraphics pdfED2;
PGraphics pdfRO1;
PGraphics pdfEO1;
PGraphics pdfRO2;
PGraphics pdfEO2;
PGraphics pdfRG1;
PGraphics pdfEG1;
PGraphics pdfRG2;
PGraphics pdfEG2;
PGraphics pdfRE1;
PGraphics pdfEE1;
PGraphics pdfRE2;
PGraphics pdfEE2;
PGraphics pdfRM1;
PGraphics pdfEM1;
PGraphics pdfRM2;
PGraphics pdfEM2;

public void createGraphicsPDF(){
  pushMatrix();
    translate(width/6, 0);
    pdfRC1 = createGraphics(width, height, PDF, "Respuestas_Ejercicio_Cinematica1.pdf");
    pdfEC1 = createGraphics(width, height, PDF, "Enunciado_Ejercicio_Cinematica1.pdf");
    pdfRC2 = createGraphics(width, height, PDF, "Respuestas_Ejercicio_Cinematica2.pdf");
    pdfEC2 = createGraphics(width, height, PDF, "Enunciado_Ejercicio_Cinematica2.pdf");
    pdfRD1 = createGraphics(width, height, PDF, "Respuestas_Ejercicio_Dinamica1.pdf");
    pdfED1 = createGraphics(width, height, PDF, "Enunciado_Ejercicio_Dinamica1.pdf");
    pdfRD2 = createGraphics(width, height, PDF, "Respuestas_Ejercicio_Dinamica2.pdf");
    pdfED2 = createGraphics(width, height, PDF, "Enunciado_Ejercicio_Dinamica2.pdf");
    pdfRO1 = createGraphics(width, height, PDF, "Respuestas_Ejercicio_Optica1.pdf");
    pdfEO1 = createGraphics(width, height, PDF, "Enunciado_Ejercicio_Optica1.pdf");
    pdfRO2 = createGraphics(width, height, PDF, "Respuestas_Ejercicio_Optica2.pdf");
    pdfEO2 = createGraphics(width, height, PDF, "Enunciado_Ejercicio_Optica2.pdf");
    pdfRG1 = createGraphics(width, height, PDF, "Respuestas_Ejercicio_Campo_Gravitatorio1.pdf");
    pdfEG1 = createGraphics(width, height, PDF, "Enunciado_Ejercicio_Campo_Gravitatorio1.pdf");
    pdfRG2 = createGraphics(width, height, PDF, "Respuestas_Ejercicio_Campo_Gravitatorio2.pdf");
    pdfEG2 = createGraphics(width, height, PDF, "Enunciado_Ejercicio_Campo_Gravitatorio2.pdf");
    pdfRE1 = createGraphics(width, height, PDF, "Respuestas_Ejercicio_Campo_Electrico1.pdf");
    pdfEE1 = createGraphics(width, height, PDF, "Enunciado_Ejercicio_Campo_Electrico1.pdf");
    pdfRE2 = createGraphics(width, height, PDF, "Respuestas_Ejercicio_Campo_Electrico2.pdf");
    pdfEE2 = createGraphics(width, height, PDF, "Enunciado_Ejercicio_Campo_Electrico2.pdf");
    pdfRM1 = createGraphics(width, height, PDF, "Respuestas_Ejercicio_Campo_Magnetico1.pdf");
    pdfEM1 = createGraphics(width, height, PDF, "Enunciado_Ejercicio_Campo_Magnetico1.pdf");
    pdfRM2 = createGraphics(width, height, PDF, "Respuestas_Ejercicio_Campo_Magnetico2.pdf");
    pdfEM2 = createGraphics(width, height, PDF, "Enunciado_Ejercicio_Campo_Magnetico2.pdf");
  popMatrix();
  
}
// Marges Horitzontal i Vertical
float marginH = 100,
      marginV = 75;

// Dimensions Zona Lateral
float sidebarWidth  = 300, 
      sidebarHeight = 720;

// Dimensions Logo
float logoWidth  = 300, 
      logoHeight = 300;
      
// Dimensions Banner
float bannerWidth  = 1560, 
      bannerHeight = 300;
      
// Dimensions Columnes
float columnWidth  = 505,
      columnHeight = 720;
      
//Visualització:
float wVisualitzacio = 900,
      hVisualitzacio = 600;

float xVisualitzacio = marginH+100 + wVisualitzacio/2,
      yVisualitzacio = 1080/3-70+hVisualitzacio/2;
class Luz{
  //Atributos
  //Ejercicio 1
  float XObsVi;
  float xAbeja, yAbeja;
  
  //Ejercicio 2
  float angulo;
  float n1;
  float n2;
  
  Luz(){}
  
  public void setValues1(float Xo, float Xa, float Ya){
    this.XObsVi = Xo;
    this.xAbeja = Xa;
    this.yAbeja = Ya;
  }
  public void setValues2(float a, float n1, float n2){
    this.angulo = a;
    this.n1 = n1;
    this.n2 = n2;
  }
  
  public void display(){
    if(exercici == 1){
      //Abeja
      abeja.resize(200, 200);
      image(abeja, -wVisualitzacio/3+ 140, -hVisualitzacio/3+10);
      //Rayo de luz
      line(-wVisualitzacio/3+50, hVisualitzacio/3-2, wVisualitzacio/3 - 100, 0);
      line(wVisualitzacio/3 - 100, 0, -wVisualitzacio/3+ 210, -hVisualitzacio/3+40);
      //Acotación
      fill(0);textSize(20);
      text(l.XObsVi, -40, hVisualitzacio/3-40);
      f.changePoints(-wVisualitzacio/3+50, hVisualitzacio/3-2,wVisualitzacio/3 - 100, hVisualitzacio/3-2); f.display(0);
      f.changePoints(wVisualitzacio/3 - 100, hVisualitzacio/3-2, -wVisualitzacio/3+50, hVisualitzacio/3-2); f.display(0);
      
      text(l.yAbeja, -wVisualitzacio/3-40, 0);
      f.changePoints(-wVisualitzacio/3+50, hVisualitzacio/3-2, -wVisualitzacio/3+50, -hVisualitzacio/3+40); f.display(0);
      
      text(l.xAbeja, -wVisualitzacio/3+80, -hVisualitzacio/3+80);
      f.changePoints(-wVisualitzacio/3+50, -hVisualitzacio/3+40, -wVisualitzacio/3+ 210, -hVisualitzacio/3+40); f.display(0);
      f.changePoints(-wVisualitzacio/3+ 210, -hVisualitzacio/3+40, -wVisualitzacio/3+50, -hVisualitzacio/3+40); f.display(0);
      
      //Discontínuas
      line(wVisualitzacio/3 - 100, 0, wVisualitzacio/3-50, -20);
      line( wVisualitzacio/3 , -40, wVisualitzacio/3 +50, -60);
      line( wVisualitzacio/3 +100, -80, wVisualitzacio/3 +150, -100);
      
    }else if(exercici == 2){
      fill(0);
      line(-100, 0, -200, 0);
      textSize(20);
      text(l.angulo, -250, 20);
      noFill();
      arc(-100, 0, 60, 60, 2.8f*PI/4, PI);
      
      stroke(paleta[1]);
      line(-100, 0, -wVisualitzacio/3, hVisualitzacio/2-20);
      stroke(paleta[2]);
      line(-100, 0, 100, -100);
      line(100, -100, +wVisualitzacio/3 -60, -hVisualitzacio/2+40);
      stroke(paleta[5]);
      line(-100, 0, 100, -40);
      line(100, -40, +wVisualitzacio/3 -10, -hVisualitzacio/2+40);
      
    }
  }
  
  public void reset(){
    XObsVi = 0;
    xAbeja = 0; 
    yAbeja = 0;
    angulo = 0;
    n1 = 0;
    n2 = 0;
  }
}
// Fitxer amb informació de Mides d'objectes de la GUI
float midaMegaTitol = 90;
float midaTitol = 75;
float midaMegaSubtitol = 60;
float midaSubtitol = 32;
float midaParagraf = 18;

//Mides Card
  float wCard = 400;
  float hCard = 600;
  
//Mides botó zoom
  float wZoom = 80;
  float hZoom = 80;
class Mobil extends Objeto{
  //Atributos
  float vel;
  int c;
  float angulo;
  float altura;
  
  Mobil(){
    super("");
  }
  public void setValues1(String n, float x, float y, float Vel, int c){
    //Atributos genéricos
    super.nombre = n;
    super.p = new PVector(x, y);
    //Atributos específicos
    this.vel = Vel;
    this.c = c;
  }
  
  public void setValues2(String n, float v, float h, float a, int c){
    //Atributos genéricos
    super.nombre = n;
    super.p = new PVector(precipicioXSacled-30, -30);
    print(precipicioXSacled-10); print(floor-10);
    this.altura = h;
    this.angulo = a;
    this.vel = v;
    this.c = c;
  }
  
  public void reset(){
    super.nombre = "";
    super.p = null;
    this.vel = 0;
    this.altura = 0;
    this.angulo = 0;
  }
  
  public void display(float sX, float sY){
    if(exercici == 1){
      calculateDisplay(sX, sY);
      fill(this.c); noStroke();
      circle(displayX, displayY, 10);
      textAlign(CENTER);textSize(20);fill(0);
      text(super.nombre, super.displayX, super.displayY-15);
    }else if (exercici == 2){
      pushMatrix();
        translate(xVisualitzacio, yVisualitzacio);
        float DisX = sX*(1+ scaleEjercicio);
        if(DisX>-wVisualitzacio/2){
          fill(this.c); noStroke();
          circle(DisX, sY, 60);
          textAlign(CENTER);textSize(20);fill(0);
          text(super.nombre, DisX, sY-40);
          text(String.valueOf(this.altura), DisX-35, floor-80); 
        }
      popMatrix();
    }
    
    
  }
}
public void mousePressed(){
  //Escuchar botones de las pantallas
  if(Pantalla == PANTALLA.INICI){
    checkBotonsInici();
  }else if(Pantalla == PANTALLA.SELECCIO){
    checkBotonsSeleccio();
  }else if(Pantalla == PANTALLA.EXERCICI){
    checkBotonsExercici();
  }else if(Pantalla == PANTALLA.FORMULARI || Pantalla == PANTALLA.EXPLICACION){
    checkBotonsFormulariOExplicacion();
  }
  //Escuchar botón atrás
  if(Pantalla != PANTALLA.INICI){
    checkAtras();
  }
}

public void checkAtras(){
   if(bAtras.mouseOverButton()){
     //Se cuelve al ejercicio
     if(currentState==ESTADO.ANADIR || currentState==ESTADO.EXPORTAR){
       currentState=ESTADO.EJERCICIO;
     }
     //Se vuelve a la pantalla anterior
     else{
       if(Pantalla == PANTALLA.EXERCICI){
         if(tema == TEMA.CINEMATICA){
           resetCinematica();
         }else if(tema == TEMA.DINAMICA){
           resetDinamica();
         }else if(tema == TEMA.OPTICA){
           resetOptica();
         }else if(tema == TEMA.GRAVITATORI){
           resetCampoGravitatorio();
         }else if(tema == TEMA.ELECTRIC){
           resetCampoElectrico();
         }else if(tema == TEMA.MEGNETIC){
           resetCampoMagnetico();
         }
       }
       Pantalla = PantallaPrevia;
     }
   }
}

public void checkBotonsInici(){
  for(int i = 0; i<cards.length; i++){
    if(cards[i].boto.mouseOverButton()){
    tema = cards[i].tema;
    Pantalla= PANTALLA.SELECCIO;
    
    } 
  }
  
  if(bProponer.mouseOverButton()){
    openWebPage("https://forms.gle/ff2SHGXzBjkzugaU6");
  }else if(bApp.mouseOverButton()){
    openWebPage("https://sites.google.com/view/fisicaprobada/inicio");
  }else if(bFAQs.mouseOverButton()){
    openWebPage("https://drive.google.com/file/d/1CIzs9U0DCSMxKgjvPyjr9B-FPLUwZe7T/view?usp=share_link");
  }

  
}

public void checkBotonsSeleccio(){
  PantallaPrevia = PANTALLA.INICI;
  for(int i = 0; i<buttonsExercicis.length ; i++){
    if(buttonsExercicis[i].mouseOverButton()){
      exercici = i%2 == 0 ? 1: 2;
      Pantalla = PANTALLA.EXERCICI;
      PantallaPrevia = PANTALLA.SELECCIO;
    }
  }
}

public void checkBotonsExercici(){
  PantallaPrevia = PANTALLA.SELECCIO;
  //Selecció Enunciado/respuestas
    for(int i=0; i<s1.opcions.length; i++){
      if(s1.opcions[i].mouseOverButton()){
        s1.opcions[i].isSelected = true;
        s1.setSelec(i);
      }
    }
  //Botons:    
    //Añadir
      if(bADD.mouseOverButton()){
        currentState = ESTADO.ANADIR;
        bADDLeave.enabled = true;
        bADDRanValues.enabled = true;
      }else if(bADDLeave.mouseOverButton() && bADDLeave.enabled == true && canAdd){
        currentState = ESTADO.EJERCICIO;
        bADDLeave.enabled = false;
        if(tema == TEMA.CINEMATICA){
          if(exercici == 1){
            createMobilsC1();
            objetos++;
          }else if(exercici == 2){
            createMobilC2();
            objetos++;
          }
        }else if(tema == TEMA.DINAMICA){
          if(exercici == 1){
            createCajasD1();
            objetos ++;
          }else if(exercici == 2){
            createCajaD2();
            objetos ++;
          }
        }else if(tema == TEMA.OPTICA){
          if(exercici == 1){
            createLuzO1();
            objetos ++;
          }else if(exercici == 2){
            createLuzO2();
            objetos ++;
          }
        }else if(tema == TEMA.GRAVITATORI){
          if(exercici == 1){
            createCampoGravitatorioG1();
            objetos++;
          }else if(exercici == 2){
            createCampoGravitatorioG2();
            objetos++;
          }
        }else if(tema == TEMA.ELECTRIC){
          if(exercici == 1){
            createCampoElectrico1();
            objetos++;
          }else if(exercici == 2){
            createCampoElectrico2();
            objetos++;
          }
        }else if(tema == TEMA.MEGNETIC){
          if(exercici == 1){
            createCampoMagnetico1();
            objetos++;
          }else if(exercici == 2){
            createCampoMagnetico2();
            objetos++;
          }
        }
      }else if(bADDRanValues.mouseOverButton() && bADDRanValues.enabled == true && canAdd){
        currentState = ESTADO.EJERCICIO;
        bADDRanValues.enabled = false;
        if(tema == TEMA.CINEMATICA){
          if(exercici == 1){
            createRanMobilsC1();
            objetos++;
          }else if(exercici == 2){
            createRanMobilC2();
            objetos++;
          }
        }else if(tema == TEMA.DINAMICA){
          if(exercici == 1){
            createRanCajasD1();
            objetos ++;
          }else if(exercici == 2){
            createRanCajaD2();
            objetos ++;
          }
        }else if(tema == TEMA.OPTICA){
          if(exercici == 1){
            createRanLuzO1();
            objetos ++;
          }else if(exercici == 2){
            createRanLuzO2();
            objetos ++;
          }
        }else if(tema == TEMA.GRAVITATORI){
          if(exercici == 1){
            createRanCampoGravitatorioG1();
            objetos++;
          }else if(exercici == 2){
            createRanCampoGravitatorioG2();
            objetos++;
          }
        }else if(tema == TEMA.ELECTRIC){
          if(exercici == 1){
            createRanCampoElectrico1();
            print("holis");
            objetos++;
          }else if(exercici == 2){
            createRanCampoElectrico2();
            objetos++;
          }
        }else if(tema == TEMA.MEGNETIC){
          if(exercici == 1){
            createRanCampoMagnetico1();
            objetos++;
          }else if(exercici == 2){
            createRanCampoMagnetico2();
            objetos++;
          }
        }
      }
    //Exportar
      //Enunciado
      else if(bEXPORT.mouseOverButton()){
        currentState = ESTADO.EXPORTAR;
      }else if(bEXPORTEnu.mouseOverButton()){
        //Iniciar exportacion
        currentState = ESTADO.EJERCICIO;
        if(tema == TEMA.CINEMATICA){
          if(exercici == 1){
            exportarEC1();
          }else if(exercici == 2){
            exportarEC2();
          }
        }if(tema == TEMA.DINAMICA){
          if(exercici == 1){
            exportarED1();
          }else if(exercici == 2){
            exportarED2();
          }
        }if(tema == TEMA.OPTICA){
          if(exercici == 1){
            exportarEO1();
          }else if(exercici == 2){
            exportarEO2();
          }
        }if(tema == TEMA.GRAVITATORI){
          if(exercici == 1){
            exportarEG1();
          }else if(exercici == 2){
            exportarEG2();
          }
        }if(tema == TEMA.ELECTRIC){
          if(exercici == 1){
            exportarEE1();
          }else if(exercici == 2){
            exportarEE2();
          }
        }if(tema == TEMA.MEGNETIC){
          if(exercici == 1){
            exportarEM1();
          }else if(exercici == 2){
            exportarEM2();
          }
        }
        
      }
      //Respuestas
      else if(bEXPORTRes.mouseOverButton()){
        //Iniciar exportacion Respuesas();
       currentState = ESTADO.EJERCICIO;
        if(tema == TEMA.CINEMATICA){
          if(exercici == 1){
            exportarRC1();
          }else if(exercici == 2){
            exportarRC2();
          }
        }if(tema == TEMA.DINAMICA){
          if(exercici == 1){
            exportarRD1();
          }else if(exercici == 2){
            exportarRD2();
          }
        }if(tema == TEMA.OPTICA){
          if(exercici == 1){
            exportarRO1();
          }else if(exercici == 2){
            exportarRO2();
          }
        }if(tema == TEMA.GRAVITATORI){
          if(exercici == 1){
            exportarRG1();
          }else if(exercici == 2){
            exportarRG2();
          }
        }if(tema == TEMA.ELECTRIC){
          if(exercici == 1){
            exportarRE1();
          }else if(exercici == 2){
            exportarRE2();
          }
        }if(tema == TEMA.MEGNETIC){
          if(exercici == 1){
            exportarRM1();
          }else if(exercici == 2){
            exportarRM2();
          }
        }
        
      }
    //Explicación
      else if(bEXPLICACION.mouseOverButton()&& s1.getSelected().equals("Respuestas")){
        Pantalla = PANTALLA.EXPLICACION;
      }else if(bRESET.mouseOverButton()&& s1.getSelected().equals("Enunciado")){
        if(tema == TEMA.CINEMATICA){
          resetCinematica();
        }else if(tema == TEMA.DINAMICA){
          resetDinamica();
        }else if(tema == TEMA.OPTICA){
          resetOptica();
        }else if(tema == TEMA.GRAVITATORI){
          resetCampoGravitatorio();
        }else if(tema == TEMA.ELECTRIC){
          resetCampoElectrico();
        }else if(tema == TEMA.MEGNETIC){
          resetCampoMagnetico();
        }
      }
    //Formulari
      else if(bFORMULARIO.mouseOverButton()){
        Pantalla = PANTALLA.FORMULARI;
      }
    //INTERACIÓN CON EL EJERCICIO:
      InteraccionEjercicio(tema, exercici);
      
    
  
}
public void InteraccionEjercicio(TEMA tema, int ejercicio){
  pushStyle();
  if(tema == TEMA.CINEMATICA){
      if(ejercicio==1){
        if(bzoomMas.mouseOverButton()){
          scaleEjercicio-=1;
        }else if(bzoomMenos.mouseOverButton()){
          scaleEjercicio+=1;
        }
        
        //TextFields:
           tfCaddName.isPressed();
           tfCaddPos1.isPressed(); tfCaddPos2.isPressed();
           tfCaddVel.isPressed();
        
      }else if(ejercicio==2){
        if(bDerecha.mouseOverButton()){
          scaleEjercicio+=1;
        }else if(bIzquierda.mouseOverButton()&&scaleEjercicio>0){
          scaleEjercicio-=1;
        }
        //TextFields:
           tfCaddName.isPressed();
           tfCaddHigh.isPressed();
           tfCaddAngle.isPressed();
           tfCaddVel.isPressed();
      }  
    }else if(tema == TEMA.DINAMICA){
      if(ejercicio==1){
        tfDaddMasa.isPressed();
        tfCaddAngle.isPressed();
      }else if(ejercicio==2){
        tfDaddMasa.isPressed();
        tfDaddF.isPressed();
        tfDaddNu.isPressed();
      }
    }else if(tema == TEMA.OPTICA){
      if(ejercicio==1){
        tfOXobs.isPressed();
        tfOXabeja.isPressed();
        tfOYabeja.isPressed();
      }else if(ejercicio==2){
        tfOAngulo.isPressed();
        tfOn1.isPressed();
        tfOn2.isPressed();
      }
    }else if(tema == TEMA.GRAVITATORI){
      if(ejercicio==1){
        tfGm1.isPressed();
        tfGm2.isPressed();
        tfGDistancias.isPressed();
      }else if(ejercicio==2){
        tfGr1.isPressed();
        tfGr2.isPressed();
        tfGv1.isPressed();
      }
    }else if(tema == TEMA.ELECTRIC){
      if(ejercicio==1){
        tfEc1.isPressed();
        tfEc2.isPressed();
        tfGDistancias.isPressed();
      }else if(ejercicio==2){
        tfEV.isPressed();
      }
    }else if(tema == TEMA.MEGNETIC){
      if(ejercicio==1){
        tfMI1.isPressed();
        tfGDistancias.isPressed();
        tfMI2.isPressed();
      }else if(ejercicio==2){
        ftMIntensidad.isPressed();
        tfMRadio.isPressed();
      }
    }
  popStyle();
  
}

public void checkBotonsFormulariOExplicacion(){
  PantallaPrevia = PANTALLA.EXERCICI;
}

public void keyPressed() {
  if(tema == TEMA.CINEMATICA){
    tfCaddName.keyPressed(key, (int)keyCode);
    tfCaddVel.keyPressed(key, (int)keyCode);
    if(exercici == 1){
      tfCaddPos1.keyPressed(key, (int)keyCode); tfCaddPos2.keyPressed(key, (int)keyCode);
    }else if(exercici == 2){
      tfCaddHigh.keyPressed(key, (int)keyCode);
      tfCaddAngle.keyPressed(key, (int)keyCode);
    }
  }else if(tema == TEMA.DINAMICA){
    if(exercici == 1){
      tfDaddMasa.keyPressed(key, (int)keyCode);
      tfCaddAngle.keyPressed(key, (int)keyCode);
    }else if(exercici == 2){
      tfDaddMasa.keyPressed(key, (int)keyCode);
      tfDaddF.keyPressed(key, (int)keyCode);
      tfDaddNu.keyPressed(key, (int)keyCode);
    }
  }else if(tema == TEMA.OPTICA){
    if(exercici == 1){
      tfOXobs.keyPressed(key, (int)keyCode);
      tfOXabeja.keyPressed(key, (int)keyCode);
      tfOYabeja.keyPressed(key, (int)keyCode);
    }else if(exercici == 2){
      tfOAngulo.keyPressed(key, (int)keyCode);
      tfOn1.keyPressed(key, (int)keyCode);
      tfOn2.keyPressed(key, (int)keyCode);
    }
  }else if(tema == TEMA.GRAVITATORI){
    if(exercici == 1){
      tfGm1.keyPressed(key, (int)keyCode);
      tfGm2.keyPressed(key, (int)keyCode);
      tfGDistancias.keyPressed(key, (int)keyCode);
    }else if(exercici == 2){
      tfGr1.keyPressed(key, (int)keyCode);
      tfGr2.keyPressed(key, (int)keyCode);
      tfGv1.keyPressed(key, (int)keyCode);
    }
  }else if(tema == TEMA.ELECTRIC){
    if(exercici == 1){
      tfEc1.keyPressed(key, (int)keyCode);
      tfEc2.keyPressed(key, (int)keyCode);
      tfGDistancias.keyPressed(key, (int)keyCode);
    }else if(exercici == 2){
      tfEV.keyPressed(key, (int)keyCode);
    }
  }else if(tema == TEMA.MEGNETIC){
    if(exercici == 1){
      tfMI1.keyPressed(key, (int)keyCode);
      tfGDistancias.keyPressed(key, (int)keyCode);
      tfMI2.keyPressed(key, (int)keyCode);
    }else if(exercici == 2){
      ftMIntensidad.keyPressed(key, (int)keyCode);
      tfMRadio.keyPressed(key, (int)keyCode);
    }
      
  }
   
}
class Objeto{
  //Atributos
  String nombre;//Nombre
  PVector p;//Posición
  float displayX, displayY;
  
  Objeto(String n, float x, float y){
    this.nombre = n;
    this.p = new PVector(x, y);
  }
  Objeto(String n){
    this.nombre = n;
  }
  
  public void calculateDisplay(float sX, float sY){
    displayX = this.p.x*sX;
    displayY = -this.p.y*sY;
  }
}
enum PANTALLA {INICI, SELECCIO, EXERCICI, FORMULARI, EXPLICACION};
PANTALLA Pantalla = PANTALLA.INICI;
PANTALLA PantallaPrevia = PANTALLA.INICI;
enum TEMA {CINEMATICA, DINAMICA, OPTICA, GRAVITATORI, MEGNETIC, ELECTRIC};
TEMA tema; int exercici; 
enum ESTADO {EJERCICIO, ANADIR, EXPORTAR};
ESTADO currentState = ESTADO.EJERCICIO;
int objetos = 0; int objetoLimite; boolean canAdd= true;

public void seleccionaPantalla(PANTALLA p){
  if(p==PANTALLA.INICI){
    pantallaInicial();
  }else if(p==PANTALLA.SELECCIO){
    pantallaSeleccio(tema);
  }else if(p==PANTALLA.EXERCICI){
    pantallaExercicis(tema, exercici);
  }else if(p==PANTALLA.FORMULARI){
    pantallaFormulari(tema);
  }else if(p==PANTALLA.EXPLICACION){
    pantallaExplicacion(tema, exercici);
  }
  if(p!=PANTALLA.INICI){
    bAtras.setMides(marginV, marginH-40, 150, 75);
    bAtras.display();
  }
}


public void pantallaInicial(){
  //Dibujar Cards
  for(int i = 0; i<cards.length+0; i++){
    if(i<cards.length/2){
       cards[i].display((1+2*i)*(width)/6-200, marginV+35);
    }else{
       cards[i].display((-5+2*i)*(width)/6-200, (height/2)+10);
    }
  }
   bApp.setMides((1)*(width)/6-200, height -125, wCard, 80);
   bApp.display();
   bFAQs.setMides((3)*(width)/6-200, height -125, wCard, 80);
   bFAQs.display();
   bProponer.setMides((5)*(width)/6-200, height -125, wCard, 80);
   bProponer.display();
}

public void pantallaSeleccio(TEMA tema){
  pushStyle();
    if(tema == TEMA.CINEMATICA){
      textSize(midaTitol); fill(0);
    text("Cinemática", width/2, marginV+100);//titol
      //Exercicis
        bC1.setMides((width/2)-650, 250, 500, 750); bC1.DisplayWithImage(ejercicios[0], 255);
        bC2.setMides(width/2+150, 250, 500, 750); bC2.DisplayWithImage(ejercicios[1], 255);
    }else if(tema == TEMA.DINAMICA){
      //Exercicis
        bD1.setMides((width/2)-650, 250, 500, 750); bD1.DisplayWithImage(ejercicios[2], 255);
        bD2.setMides(width/2+150, 250, 500, 750); bD2.DisplayWithImage(ejercicios[3], 255);
        textSize(midaTitol); fill(0);
    text("Dinámica", width/2, marginV+100);//titol
    }else if(tema == TEMA.OPTICA){
      //Exercicis
        bO1.setMides((width/2)-650, 250, 500, 750); bO1.DisplayWithImage(ejercicios[4], 255);
        bO2.setMides(width/2+150, 250, 500, 750); bO2.DisplayWithImage(ejercicios[5], 255);
        textSize(midaTitol); fill(0);
    text("Óptica", width/2, marginV+100);//titol
    }else if(tema == TEMA.GRAVITATORI){
      //Exercicis
        bG1.setMides((width/2)-650, 250, 500, 750); bG1.DisplayWithImage(ejercicios[6], 255);
        bG2.setMides(width/2+150, 250, 500, 750); bG2.DisplayWithImage(ejercicios[7], 255);
        textSize(midaTitol); fill(0);
    text("Gravitatorio", width/2, marginV+100);//titol
    }else if(tema == TEMA.ELECTRIC){
      //Exercicis
        bE1.setMides((width/2)-650, 250, 500, 750); bE1.DisplayWithImage(ejercicios[8], 255);
        bE2.setMides(width/2+150, 250, 500, 750); bE2.DisplayWithImage(ejercicios[9], 255);
        textSize(midaTitol); fill(0);
    text("Eléctrico", width/2, marginV+100);//titol
    }else if(tema == TEMA.MEGNETIC){
      //Exercicis
        bM1.setMides((width/2)-650, 250, 500, 750); bM1.DisplayWithImage(ejercicios[10], 255);
        bM2.setMides(width/2+150, 250, 500, 750); bM2.DisplayWithImage(ejercicios[11], 255);
        textSize(midaTitol); fill(0);
    text("Magnético", width/2, marginV+100);//titol
    }
  popStyle();
}

public void pantallaFormulari(TEMA tema){
  pushStyle();fill(0);
  float x1 = width/6;
  float w1 = width/2;
    textSize(midaTitol);
    if(tema == TEMA.CINEMATICA){
      float y = height/6+85;
      float h = 4*height/6;
      text("Formulario Cinemática", width/2, 175);
      tCfor.display(x1, y, w1, h);
      fC.display(x1 + w1 + 100, y, 350, h);
    }else if(tema == TEMA.DINAMICA){
      float y = height/6+85;
      float h = 4*height/6;
      text("Formulario Dinámica", width/2, 175);
      tDfor.display(x1, y, w1, h);
      fD.display(x1 + w1 + 100, y, 350, h);
    }else if(tema == TEMA.OPTICA){
      float y = height/6+85;
      float h = 4*height/6;
      text("Formulario Óptica", width/2, 175);
      tOfor.display(x1, y, w1, h);
      fO.display(x1 + w1 + 100, y, 350, h);
    }else if(tema == TEMA.GRAVITATORI){
      float y = height/6+85;
      float h = 4*height/6;
      text("Formulario Gravitatorio", width/2, 175);
      tGfor.display(x1, y, w1, h);
      fG.display(x1 + w1 + 100, y, 350, h);
    }else if(tema == TEMA.ELECTRIC){
      float y = height/6+85;
      float h = 4*height/6;
      text("Formulario Eléctrico", width/2, 175);
      tEfor.display(x1, y, w1, h);
      fE.display(x1 + w1 + 100, y, 350, h);
    }else if(tema == TEMA.MEGNETIC){
      float y = height/6+85;
      float h = 4*height/6;
      text("Formulario Magnético", width/2, 175);
      tMfor.display(x1, y, w1, h);
      fM.display(x1 + w1 + 100, y, 350, h);
    }
  popStyle();  
}

Fletxa f = new Fletxa();
public void pantallaExplicacion(TEMA tema, int ejercicio){
  pushStyle();
    fill(255); noStroke();
    float x = width/6; float y = 0;
    float w = 2*width/3; float h = height;
    rect(width/6, 0, 2*width/3, height);
    fill(0);
      if(tema == TEMA.CINEMATICA){
        if(ejercicio==1){
          textSize(midaTitol-5); fill(0); textAlign(CENTER);
          text("Explicación choque entre cuerpos", width/2, marginV+25);//titol
          fill(200); noStroke();
          rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
          textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
          if(objetos>1){
            text("Enunciado: Dos mobiles, uno situado en la coordenada ("+m0.p.x+", "+m0.p.y+") de un eje de cordenadas cartegianas y otro situado en ("+m1.p.x+", "+m1.p.y+") se mueven en un MRU (que empieza en t=0s) en dirección de chocar. Si la velocidad del primero es "+m0.vel+"m/s y la del segundo es "+m1.vel+",m/s ¿cuándo chocarán?", x+ 30, y+marginV+55, w-60, h-10);
          }else{
            text("Enunciado: Dos mobiles, uno situado en la coordenada (X1, Y1) de un eje de cordenadas cartegianas y otro situado en (X2, Y2) se mueven en un MRU (que empieza en t=0s) en dirección de chocar. Si la velocidad del primero es V1m/s y la del segundo es V2m/2, ¿cuándo chocarán?", x+ 30, y+marginV+55, w-60, h-10);
          }
          //Escrito de resolución
          textSize(midaSubtitol-8);
          text("En primer lugar, se halla la distancia entre los dos móbiles usando el teorema de pitágoras:", x+ 30, y+marginV+55+200, w-50, h-10);
          //Pitagoras:
            pit1.resize(240, 240); pit2.resize(500, 150);
            float xBorde = x+30;
            float yImg1 = y+marginV+55+200 + 100;
            image(pit1, xBorde, yImg1); 
            float x1F1 = xBorde + 240; float x2F1 =x1F1 + 60;
            float yF = yImg1 + 240/2;
            f.changePoints(x1F1, yF, x2F1, yF);f.display(0);
            float xDist = x2F1 + 10;
            textAlign(LEFT, CENTER); textSize(midaParagraf);
            text("Dist = sqrt((Dx)^2 + (Dy)^2   \nDist = sqrt((X2-X1)^2 + (Y2-Y1)^2)",xDist, yF);
            float xImg2 = xDist+ 400;
            image(pit2, xImg2, y+marginV+55+200 + 100 + 45);
          
          textAlign(LEFT, TOP); textSize(midaSubtitol-8); float yText = yF + 240/2; fill(0);
          text("Que los coches choquen significa que su posición es la misma; por lo tanto, igualamos sus ecuaciones de movimiento:", x+ 30, yText, w-50, h-10);
          //Igualación de Ecuaciones:
          textAlign(CENTER, TOP); textMode(CENTER);textSize(midaParagraf+4);
          float xExpr = x+w/2-400; float yExpr = yText + 60;
          text("p1 =p2   \np01+v1*t = p02+v2*t   \n0+v1*t = dist+v2*t \nen modulo: v1*t = dist -v2*t \nt = (dist)/(v1+v2)    \nt = (sqrt((X2-X1)^2 + (Y2-Y1)^2))/(v1+v2)", xExpr, yExpr, 800, 600);
          textAlign(LEFT, TOP); textSize(midaSubtitol-8);
          float ySub = yExpr + 180;
          text("Entonces, substituimos en la ecuación:", xBorde, ySub);
          //Substitución:
          if(objetos>1){
            
            float yRes = ySub+40;
            float Resp = calcularEjercicioC1();
            text("t = (sqrt(("+m1.p.x+"-"+m0.p.x+")^2 + ("+m1.p.y+"-"+m0.p.y+"^2))/("+m0.vel+"+"+m1.vel+") = "+Resp, xExpr, yRes, w, 600);
            text("SOLUCIÓN: Se chocarán cuando hayan passado "+Resp+"s", xBorde, ySub+100);
          }
          
          
        }else if(ejercicio==2){
          textSize(midaTitol-5); fill(0); textAlign(CENTER);
          text("Explicación tiro parabólico", width/2, marginV+25);//titol
          fill(200); noStroke();
          rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
          textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
          //Pregunta
          if(objetos == 0){
            text("Si un mobil se situa en un precipicio cuya altura es H y se lanza a una velocidad V en un ángulo A respeto a la horizontal; ¿a cuantos metros del precicpicio xocará contra el suelo?", x+ 30, y+marginV+55, w-60, h-10);
          }else if(objetos >0){
            text("Si un mobil se situa en un precipicio cuya altura es "+m0.altura+" y se lanza a una velocidad "+m0.vel+" en un ángulo "+m0.angulo+" respeto a la horizontal; ¿a cuantos metros del precicpicio xocará contra el suelo?", x+ 30, y+marginV+55, w-60, h-10);
          }
          //Explicación:
          textSize(midaSubtitol-8);
          float Y1 = y+marginV+55+200;
          text("En primer lugar, se halla el tiempo en que el objeto tocará el suelo. Para esto, se utiliza la fórmula de MRUA:", x+ 30,Y1, w-50, h-10);
          float Y2 = Y1 + 100;
          textSize(midaParagraf);
          text("0 = h + Vy*t +(g*t^2)/2", w/2 + 125, Y2, w-50, h-10);
          textSize(midaSubtitol-8);
          float Y3 = Y2 + 50;
          text("Entonces, según la ecuación de segundo grado, se calcula el tiempo:", x+ 30, Y3, w-50, h-10);
          float Y4 = Y3 + 50;
          textSize(midaParagraf);
          text("t = [ -(Vy) +sqrt[(Vy)^2 +4*h*4.9] ]/(-9.81)", w/2, Y4, w-50, h-10);
          textSize(midaSubtitol-8);
          float Y5 = Y4 + 50;
          text("Este es el tiempo que se debe introducir en la ecuación del MRU horizonal del móbil para calcular a qué distancia xocará con el suelo. La ecuación resultante es la siguiente: ", x+ 30, Y5, w-50, h-10);
          textSize(midaParagraf);
          float Y6 = Y5 + 100;
          text("X = Vx * t", w/2 + 200, Y6, w-50, h-10);
          float Y7 = Y6 + 50;
          text("X = Vx * [ -(Vy) +sqrt[(Vy)^2 +4*h*4.9] ]/(-9.81)", w/2, Y7, w-50, h-10);
          textSize(midaSubtitol-8);
          float Y8 = Y7 + 50;
          text("Las componentes Y y X de la velocidad se conseguirán multiplicando la velocidad por el sinus y el cosinus respectivamente.", x+ 30, Y8, w-50, h-10);
          textSize(midaParagraf);float Y9 = Y8 + 100;
          text("Vx = V*cos(A)     Vy = v*sin(A)", w/2, Y9, w-50, h-10);
          float Y10 = Y9 + 50;
          textSize(midaSubtitol-8);
          text("Entonces:", x+ 30, Y10, w-50, h-10);
          textSize(midaParagraf);
          text("X = V*cos(A) * [ -(V*sin(A)) +sqrt[(V*sin(A))^2 +4*h*4.9] ]/(-9.81)", w/2, Y10+2, w-50, h-10);
          float Y11 = Y10 + 50;
          textSize(midaSubtitol-8);
          text("Substituimos:", x+ 30, Y11, w-50, h-10);
          if(objetos > 0){
            textSize(midaParagraf);
            float Resp = calcularEjercicioC2();
            text("X = "+m0.vel+"*cos("+m0.angulo+") * [ -("+m0.vel+"*sin("+m0.angulo+")) +sqrt[("+m0.vel+"*sin("+m0.angulo+"))^2 +4*"+m0.altura+"*4.9] ]/(-9.81) = "+Resp, w/2, Y11+2, w/2+ 350, h-10);
            float Y12 = Y11 + 50;
            textSize(midaSubtitol-8);
            text("Solición: Chocará con el suelo a "+Resp+" m del precipicio", x+ 30, Y12, w-50, h-10);
          }
        }
      }else if(tema == TEMA.DINAMICA){
        if(ejercicio==1){
          textSize(midaTitol-12); fill(0); textAlign(CENTER);
          text("Explicación Polea en plano inclinado", width/2, marginV+25);//titol
          fill(200); noStroke();
          rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
          textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
          //Pregunta
          if(objetos == 0){
            text("Si se considera una polea en un plano inclinado de ángulo Alpha que sujeta dos objetos, y el que está en el plano inclinado tiene una masa de M1 kg, ¿qué masa tiene que tener el segundo objeto para que el sistema esté en equilibrio?", x+ 30, y+marginV+55, w-60, h-10);
          }else if(objetos == 1){
            text("Si se considera una polea en un plano inclinado de ángulo "+c0.angulo+" que sujeta dos objetos, y el que está en el plano inclinado tiene una masa de "+c0.masa+" kg, ¿qué masa tiene que tener el segundo objeto para que el sistema esté en equilibrio?", x+ 30, y+marginV+55, w-60, h-10);
          }
          
          //Explicación:
          textSize(midaSubtitol-8);
          float Y1 = y+marginV+55+200;
          text("La tensión de la cuerda es la misma en toda ella, lo que significa que la fuerza que hacen las cajas sobre ella es igual. La primera caja está apoyada sobre un plano inclinado; por este motivo, la fuerza que ejerce este es la componente x del peso sobre el plano. Por este motivo, se puede afirmar que:", x+ 30,Y1, w-50, h-10);
          float Y2 = Y1 + 150;
          textSize(midaParagraf);
          text(" P1x = P1*sin(A)", w/2 + 150,Y2, w-50, h-10);
          textSize(midaSubtitol-8);
          float Y3 = Y2 + 50;
          text("En relación a la fuerza de la seguna caja, debido a que no está apoyada, es su masa multiplicado por el peso", x+ 30,Y3, w-50, h-10);
          float Y4 = Y3 + 50;
          textSize(midaParagraf);
          text(" P2 = m2* g", w/2 + 150,Y4, w-50, h-10);
          float Y5 = Y4+50;
          textSize(midaSubtitol-8);
          text("Entonces, igualamos las ecuaciones", x+ 30,Y5, w-50, h-10); 
          float Y6 = Y5 + 50;
          textSize(midaParagraf);
          text("P1 * sin(A) = m2* g", w/2 + 150,Y6, w-50, h-10);
          float Y7 = Y6 + 50;
          text("m1* g * sin(A) = m2* g", w/2 + 150,Y7, w-50, h-10);
          float Y8 = Y7 + 50;
          text("m2 = m1 * sin(A)", w/2 + 150,Y8, w-50, h-10);
          float Y9 = Y8+50;
          textSize(midaSubtitol-8);
          text("Finalmente, se substituye:", x+ 30,Y9, w-50, h-10); 
          if(objetos > 0){
            float Resp = calcularEjercicioD1();
            textSize(midaParagraf);
            text("m2 = "+c0.masa+" * sin("+c0.angulo+") = "+ Resp, w/2 + 150,Y9, w-50, h-10);
            float Y10 = Y9 + 50;
            text("Solución: Para que el sistema esté en equilibrio la segunda caja debe tener una masa de "+Resp+"kg", x + 30, Y10, w-30, h);
            
          }
        }else if(ejercicio==2){
          textSize(midaTitol-5); fill(0); textAlign(CENTER);
          text("Explicación Cajas Rozantes", width/2, marginV+25);//titol
          fill(200); noStroke();
          rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
          textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
          //Pregunta
          if(objetos == 0){
            text("Si a un cuerpo de massa M kg se le aplica una fuerza F N, teniendo en cuenta que entre el cuerpo y el suelo hay un coeficiente de fricción Nu, ¿Se moverá? En caso afirmativo ¿Cual será su acceleración?",x+ 30, y+marginV+55, w-60, h-10);      
          }else{
            text("Si a un cuerpo de massa "+c0.masa+" kg se le aplica una fuerza "+c0.Fuerza+" N, teniendo en cuenta que entre el cuerpo y el suelo hay un coeficiente de fricción "+c0.Nu+", ¿Se moverá? En caso afirmativo ¿Cual será su acceleración?", x+ 30, y+marginV+55, w-60, h-10);
          }
          //Explicación:
          textSize(midaSubtitol-8);
          float Y1 = y+marginV+55+200;
          text("Para que el cuerpo se mueva, la fuerza aplicada debe ser superior a la fuerza de resistencia; es decir, la fuerza de fricción. Es por esto que se tiene que aplicar la segunda ley Newton.\nEsta dice que el sumatorio de las ferzas da como resultado la masa del cuerpo multiplicado por su acceleración. En este caso, la ecuación sería así:", x+ 30,Y1, w-50, h-10);
          textSize(midaParagraf);
          float Y2 = Y1+150;
          text(" F - Ff = m * a", w/2 + 150,Y2, w-50, h-10);
          float Y3 = Y2 + 50;
          textSize(midaSubtitol-8);
          text("En este problema, ya que se consideran los módulos, la acceleración puede ser negativa. Que sea negativa significa que el objeto no se moverá, en cambio, si la acceleración es positiva, se moverá.", x+ 30,Y3, w-50, h-10);
          float Y4 = Y3 + 100;
          text("La fuerza de fricción se calcula multiplicando la normal, que es el peso de la caja con el coeficiente de fricción. Es decir:", x+ 30,Y4, w-50, h-10); 
          textSize(midaParagraf);
          float Y5 = Y4+70;
          text("Ff = m*g * nu", w/2 + 150,Y5, w-50, h-10);
          textSize(midaSubtitol-8);
          float Y6 = Y5 + 50;
          text("Entonces, la acceleración se puede calcular a partir de la siguiente ecuación:", x+ 30, Y6, w-50, h-10); 
          textSize(midaParagraf);
          float Y7 = Y6+50;
          text("a = (F-m*g*nu)/m", w/2 + 150,Y7, w-50, h-10);
          textSize(midaSubtitol-8);
          float Y8 = Y7 + 50;
          text("A continación, se substituyen los valores:", x+ 30, Y8, w-50, h-10); 
          
          float Y9 = Y8+50;
          if(objetos > 0){
            textSize(midaParagraf);
            float Resp = calcularEjercicioD2();
            text("a = ("+c0.Fuerza+"-"+c0.masa+"*9.81*"+c0.Nu+")/"+c0.masa+" = "+ Resp, w/2 + 150,Y9, w-50, h-10);
            float Y10 = Y9 + 50;
            textSize(midaSubtitol-8);
            if(Resp > 0){
              text("Solución: Se moverá; concretamente a "+Resp+"m/(s^2)", x+30, Y10, w-30, h);
            }else{
              text("Solución: No se moverá", x+30, Y10, w-30, h);
            }
          }
          
        }
      }else if(tema == TEMA.OPTICA){
        if(ejercicio==1){
          textSize(midaTitol-16); fill(0); textAlign(CENTER);
          text("Explicación Espejo", width/2, marginV+25);//titol
          fill(200); noStroke();
          rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
          textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
          //Pregunta
          if(objetos == 0){
            text("Se toma como punto de referencia el ojo de un observador. También se sabe que hay un vidrio a X1 m del ojo y una abeja stiuada a X2 y Y2 m de distáncia,¿en que posición se produce la imagen de la abeja?", x+ 30, y+marginV+55, w-60, h-10);
          }else if(objetos == 1){
            text("Se toma como punto de referencia el ojo de un observador. También se sabe que hay un vidrio a "+l.XObsVi+" m del ojo y una abeja stiuada a "+l.xAbeja+" y "+l.yAbeja+" m de distáncia,¿en que posición se produce la imagen de la abeja?", x+ 30, y+marginV+55, w-60, h-10);
          }
          //Explicación
          textSize(midaSubtitol-8);
          float Y1 = y+marginV+55+200;
          text("Cuando se ve un objeto reflejado en un espejo, se ve como una imagen virtual. Además, se puede afirmar que la distancia entre el objto y el vidrio será la mismo que entre la imagen y el vídrio. Además, su posición Y será también identica. Entonces, se puede afirmar lo siguiente:", x+ 30,Y1, w-50, h-10);
          float Y2 = Y1+125;
          textSize(midaParagraf);
          text("Ax = DXvo + DXva     ;     Ay = DYao", w/2 + 150,Y2, w-50, h-10);
          float Y3 = Y2 + 50;
          textSize(midaSubtitol-8);
          text("Donde DXvo se refiere a la distancia horizontal entre el vidrio y el ojo; DXva, a la distancia horizontal entre el vidrio y la abeja y finalmente, DYao, a la vertical entre la abeja y el ojo. \nEntonces, la posición de la abeja se escribe como A(Ax, Ay). Seguidamente, se debe hacer el módulo de este vector.", x+ 30,Y3, w-50, h-10);
          if(objetos > 0){
            float Y4 = Y3 + 150;
            text("Primero, se substituye:", x+ 30,Y4, w-50, h-10);
            textSize(midaParagraf);
            text("Ax = "+l.XObsVi+" + "+l.xAbeja+"     ;     Ay = "+l.yAbeja+"", w/2+150,Y4, w-50, h-10);
            float Y5 = Y4 + 50;
            textSize(midaSubtitol-8);
            text("Y luego, se calcula el módulo:", x+ 30,Y5, w-50, h-10);
            textSize(midaParagraf);
            float Resp = calcularEjercicioO1();
            text("|A| = sqrt[("+l.XObsVi+" + "+l.xAbeja+")^2 + ("+l.yAbeja+")^2] = "+Resp, w/2+ 150,Y5, w-50, h-10);
            float Y6 = Y5+50;
            textSize(midaSubtitol-8);
            text("Solución: La imagen se formará a "+Resp+"m del observador", x+30, Y6, w-30, h);
          }
          
          
          textSize(midaSubtitol-8);
        }else if(ejercicio==2){
          textSize(midaTitol-16); fill(0); textAlign(CENTER);
          text("Explicación Separación de rayos", width/2, marginV+25);//titol
          fill(200); noStroke();
          rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
          textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
          //Pregunta
          if(objetos == 0){
            text("Si un rayo de luz que se translada por el aire incide en un vidrio formando un ángulo de Aº con la normal y se separa en dos rayos de coeficientes de refracción n1 y n2, ¿cual será la separación angular de los rayos?", x+ 30, y+marginV+55, w-60, h-10);
         }else if(objetos == 1){
            text("Si un rayo de luz que se translada por el aire incide en un vidrio formando un ángulo de "+l.angulo+"º con la normal y se separa en dos rayos de coeficientes de refracción "+l.n1+" y "+l.n2+", ¿cual será la separación angular de los rayos?", x+ 30, y+marginV+55, w-60, h-10);
         }
         textSize(midaSubtitol-8);
         float Y1 = y+marginV+55+200;
         text("Para calcular la separación, se tienen que calcular cada uno de los ángulos y encontrar la diferencia. \nPara esto, se tiene que aplicar la ley de Snell, que dice:", x+ 30,Y1, w-50, h-10);
         float Y2 = Y1 + 100;
         textSize(midaParagraf);
         text("n sin(a) = n' sin(a')", w/2 + 100,Y2, w-50, h-10);
         float Y3 = Y2 + 50;
         textSize(midaSubtitol-8);
         text("Entonces, se tienen que calcular esto para los dos casos.", x+ 30,Y3, w-50, h-10);
         float Y4 = Y3 + 50;
         textSize(midaParagraf);
         text("1* sin(A) = n1' sin(a1)", w/2 + 100,Y4, w-50, h-10);
         float Y5 = Y4 + 50;
         text("a1 = arcsin[(sin(A))/n1]", w/2 + 100,Y5, w-50, h-10);
         float Y6 = Y5 + 50;
         text("1* sin(A) = n2' sin(a2)", w/2 + 100,Y6, w-50, h-10);
         float Y7 = Y6 + 50;
         text("a2 = arcsin[(sin(A))/n2]", w/2 + 100,Y7, w-50, h-10);
         textSize(midaSubtitol-8);
         float Y8 = Y7 + 50;
         text("La sparación, será la resta entre los dos ángulos", x+ 30,Y8, w-50, h-10);
         float Y9 = Y8 +50;
         textSize(midaParagraf);
         text("S = arcsin[(sin(A))/n1]-arcsin[(sin(A))/n2]", w/2 + 100,Y9, w-50, h-10);
         if(objetos > 0){
           textSize(midaSubtitol-8);
           float Y10 = Y9 + 50;
           text("Finalmente, substituimos:", x+ 30,Y10, w-50, h-10);
           textSize(midaParagraf);
           float Resp = calcularEjercicioO2();
           text("S = arcsin[(sin("+l.angulo+"))/"+l.n1+"]-arcsin[(sin("+l.angulo+"))/"+l.n2+"] = "+Resp, w/2 + 100,Y10, w-250, h-10);
           float Y11 = Y10 + 50;
           textSize(midaSubtitol-8);
           text("La separación de los rayos será por "+Resp+"º", x+30, Y11, w-30, h);
         }
        }
      }else if(tema == TEMA.GRAVITATORI){
        if(ejercicio==1){
          textSize(midaTitol-16); fill(0); textAlign(CENTER);
          text("Explicación Atreacción Estrella-Planeta", width/2, marginV+25);//titol
          fill(200); noStroke();
          rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
          textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
          //Pregunta
          if(objetos == 0){
            text("Si un planeta de massa M1 Kg se encuentra a Dist Km de una estrella de massa M2 Kg, ¿cual será la fuerza de atracción entre los dos cuerpos?", x+ 30, y+marginV+55, w-60, h-10);
          }else{
            text("Si un planeta de massa "+CG.m1+"Kg se encuentra a "+CG.distancia+"Km de una estrella de massa "+CG.m2+"Kg, ¿cual será la fuerza de atracción entre los dos cuerpos?", x+ 30, y+marginV+55, w-60, h-10);
          }
          //Explicación:
          textSize(midaSubtitol-8);
          float Y1 = y+marginV+55+200;
          text("La fuerza de atracción entre cuerpoes es debido al campo gravitatorio. De hecho, exsite una fórmula para calcular la fuerza de atracción entre dos cuerpos. Esta es la siguiente:", x+ 30,Y1, w-50, h-10);
          float Y2 = Y1 + 100;
          textSize(midaParagraf);
          text("F = G*(M1*M2)/(r^2)", w/2 + 150,Y2, w-50, h-10);
          textSize(midaSubtitol-8);
          float Y3 = Y2 + 50;
          text("En esta ecuación, G es la constante de gravitación que equivale a 6.67*(10^-11)\nEntonces, lo único que hace falta es substituir.", x+ 30,Y3, w-50, h-10);
          
          if(objetos > 0){
            float Y4 = Y3 + 75;
            float Resp = calcularEjercicioG1();
            textSize(midaParagraf);
            text("F = (6.67*(10^-11))*("+CG.m1+"*"+CG.m2+")/("+CG.distancia+"^2) = "+Resp, w/2-150,Y4, w-50, h-10);
            
            textSize(midaSubtitol-8);
            float Y5 = Y4 + 50;
            text("Solución: La fuerza de atracción entre los cuerpos astonómicos es "+Resp+"N", x+ 30,Y5, w-50, h-10);          
          }
          
        }else if(ejercicio==2){
          textSize(midaTitol-16); fill(0); textAlign(CENTER);
          text("Explicación Velocidad planeta orbital", width/2, marginV+25);//titol
          fill(200); noStroke();
          rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
          textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
          //Pregunta
          if(objetos == 0){
            text("Si un cuerpo orbita al rededor de otro y su velocidad en el perihélio (Dist km) es V1 m/s, ¿cual será su velocidad en el afelio (Dist km)?", x+ 30, y+marginV+55, w-60, h-10);
          }else{
            text("Si un cuerpo orbita al rededor de otro y su velocidad en el perihélio ("+CG.rp+"km) es "+CG.vp+" m/s, ¿cual será su velocidad en el afelio ("+CG.ra+" km)?", x+ 30, y+marginV+55, w-60, h-10);
          }
          //Explicación:
          textSize(midaSubtitol-8);
          float Y1 = y+marginV+55+200;
          text("El campo gravitatorio se caracteriza por ser conservativo, lo que significa que la energía mecánica se conserva. Además, según las leyes de Keppler, en una orbita cerrada elíptica, se conserva el movimiento angular. Para simplificar el caso estudiado, se van a considerar los puntos correspondientes al afelio y el perifelio ya que se conoce su distancia y velocidad.", x+ 30,Y1, w-50, h-10);
          textSize(midaParagraf);
          float Y2 = Y1 + 125;
          text("Lp = La", w/2 + 150,Y2, w-50, h-10);
          float Y3 = Y2 + 50;
          text("Rp*Pp = Ra*Pa", w/2 + 150,Y3, w-50, h-10);
          textSize(midaSubtitol-8);
          float Y4 = Y3 + 50;
          text("Donde p es la cantidad de movimiento. Entonces, esta se puede escribir como masa por velocidad donde la masa es igual ya que se trata del mismo cuerpo.", x+ 30,Y4, w-50, h-10);
          textSize(midaParagraf);
          float Y5 = Y4 + 75;
          text("Rp*m*Vp = Ra*m*Va", w/2 + 150,Y5, w-50, h-10);
          float Y6 = Y5 + 50;
          text("Rp*Vp = Ra*Va", w/2 + 150,Y6, w-50, h-10);
          textSize(midaSubtitol-8);
          float Y7 = Y6 + 50;
          text("Entonces, aislamos:", x+ 30,Y7, w-50, h-10);
          textSize(midaParagraf);
          text("Va = (Rp*Vp)/Ra", w/2 + 150,Y7, w-50, h-10);
          
          if(objetos > 0){
            textSize(midaSubtitol-8);
            float Y8 = Y7 + 50;
            text("I finalmente, substituimos:", x+ 30,Y8, w-50, h-10);
            float Resp = calcularEjercicioG2();
            textSize(midaParagraf);
            text("Va = ("+CG.rp+"*"+CG.vp+")/"+CG.ra+" = "+Resp, w/2 + 150,Y8, w-50, h-10);
            textSize(midaSubtitol-8);
            float Y9 = Y8 + 50;
            text("Solución: En el afelio tiene una velocidad de "+Resp+"km/s", x+ 30,Y9, w-50, h-10);
          } 
        }
        
        
      }else if(tema == TEMA.ELECTRIC){
        if(ejercicio==1){
          textSize(midaTitol-16); fill(0); textAlign(CENTER);
          text("Explicación Partículas cargadas", width/2, marginV+25);//titol
          fill(200); noStroke();
          rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
          textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
          //Pregunta
          if(objetos == 0){
            text("¿Cual és la fuerza entre dos particulas cargadas (C1 nC y C2 nC) que se encuentran a D mm de distancia?",x+ 30, y+marginV+55, w-60, h-10);
          }else{
            text("¿Cual és la fuerza entre dos particulas cargadas ("+P.c1+"nC y "+P.c2+"nC) que se encuentran a "+P.distancia+"mm de distancia?", x+ 30, y+marginV+55, w-60, h-10);
          }
          //Explicación:
          textSize(midaSubtitol-8);
          float Y1 = y+marginV+55+200;
          text("La fuerza de atracción entre cuerpoes es debido al campo electrico. De hecho, exsite una fórmula para calcular la fuerza de atracción entre dos partículas cargadas. Esta es la siguiente:", x+ 30,Y1, w-50, h-10);
          float Y2 = Y1 + 100;
          textSize(midaParagraf);
          text("F = K*(C1*C2)/(r^2)", w/2 + 150,Y2, w-50, h-10);
          textSize(midaSubtitol-8);
          float Y3 = Y2 + 50;
          text("En esta ecuación, K es la constante del campo eléctrico que se aproxima que equivale a 9*(10^9)\nEntonces, lo único que hace falta es substituir.", x+ 30,Y3, w-50, h-10);
          
          if(objetos > 0){
            float Y4 = Y3 + 100;
            float Resp = calcularEjercicioE1();
            textSize(midaParagraf);
            text("F = (9*(10^9))*("+P.c1+"*"+P.c2+")/("+P.distancia+"^2) = "+Resp, w/2,Y4, w-50, h-10);
            
            textSize(midaSubtitol-8);
            float Y5 = Y4 + 50;
            if(P.c1 > 0 && P.c2 > 0 || P.c1 < 0 && P.c2 < 0){
              text("La fuerza entre las partículas es de "+Resp+"F repulsiva", x+30, Y5, w-30, h);
            }else{
              text("La fuerza entre las partículas es de "+Resp+"F atractiva", x+30, Y5, w-30, h);
            }        
          }
        }else if(ejercicio==2){
          textSize(midaTitol-16); fill(0); textAlign(CENTER);
          text("Explicación Equilibrio eléctrico", width/2, marginV+25);//titol
          fill(200); noStroke();
          rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
          textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
          //Pregunta
          if(objetos == 0){
            text("¿Cuál debe ser la separación entre dos placas infinits con diferencia de potencial v V para mantener unelectrón en equilibrio?", x+ 30, y+marginV+55, w-60, h-10);
          }else{
            text("¿Cuál debe ser la separación entre dos placas infinitas con diferencia de potencial "+P.V+" V para mantener unelectrón en equilibrio?", x+ 30, y+marginV+55, w-60, h-10);
          }
          float Y1 = y+marginV+55+200;
          textSize(midaSubtitol-8);
          text("Cuando dos planos cargados eléctricamente se encuentran cerca, se establece una diferencia de potenciasl. Al acercarse más y ser paralelos e infinitos, esta diferencia de potencial crea un campo eléctrico constante que se define de la siguiente manera:", x+30, Y1, w-30, h);
          textSize(midaParagraf);
          float Y2 = Y1+ 150;
          text("E = DV/d", w/2+ 250,Y2, w-50, h-10);
          float Y3 = Y2 +50;
          textSize(midaSubtitol-8);
          text("Que estén en equilibrio significa que la fuerza eléctrica se iguala con el peso. por lo tanto, se pueden igualar los módulos", x+30, Y3, w-30, h);
          textSize(midaParagraf);
          float Y4 = Y3+ 50;
          text("F = P", w/2 + 250,Y4, w-50, h-10);
          float Y5 = Y4+ 50;
          text("q*E = m*g", w/2+ 250,Y5, w-50, h-10);
          float Y6 = Y5+ 50;
          text("q*V/d = m*g", w/2+ 250,Y6, w-50, h-10);
          float Y7 = Y6 +50;
          textSize(midaSubtitol-8);
          text("Seguidamente, de aisla la distancia:", x+30, Y7, w-30, h);
          textSize(midaParagraf);
          text("d = (q*V)/(m*g)", w/2+ 250,Y7, w-50, h-10);
          if(objetos > 0){
           float Y8 = Y7 +50;
           textSize(midaSubtitol-8);
           text("Finalmente, se substituye:", x+30, Y8, w-30, h);
           textSize(midaParagraf);
           float Resp = calcularEjercicioE2();
           text("d = (1.6*(10^-19)*"+P.V+")/(9.1*(10^-31)*9.81) = "+Resp, w/2+ 250,Y8, w-50, h-10);
           float Y9 = Y8+50;
           textSize(midaSubtitol-8);
           if(P.V > 0){
             text("Solución: Tendrá que tener una carga de "+Resp+"C para mantenerse en equilibrio", x+30, Y9, w-30, h);
           }else{
             text("Solución: No se podrá aguantar", x+30, Y9, w-30, h);
           }
          }
          
          
        }
      }else if(tema == TEMA.MEGNETIC){
        if(ejercicio==1){
          textSize(midaTitol-16); fill(0); textAlign(CENTER);
          text("Explicación Fuerza entre hilos", width/2, marginV+25);//titol
          fill(200); noStroke();
          rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
          textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
          //Pregunta
          if(objetos == 0){
            text("Si se consideran dos hilos conductores con intensidades I1 A y I2 A que distan de Dist m ¿Qué valdrá la fuerza producida entre ellos?", x+ 30, y+marginV+55, w-60, h-10);
          }else{
            text("Si se consideran dos hilos conductores con intensidades "+CM.I1+"A y "+CM.I2+"A que distan de "+CM.distancia+"mm  ¿Qué valdrá la fuerza producida entre ellos?", x+ 30, y+marginV+55, w-60, h-10);
          }
          //Explicación:
          float Y1 = y+marginV+55+200;
          textSize(midaSubtitol-8);
          text("En esto problema, existen dos casos. Por un lado, si los verctores de la intensidad de los hilos van en el mismo sentido, la fuerza será actractiva, en cambio, si van en sentido contrario, será repulsiva. De igual manera, su valor se puede calcular con el módulo siguiendo la siguiente expresión:", x+30, Y1, w-30, h);
          float Y2 = Y1 + 125;
          textSize(midaParagraf);
          text("F = NUo*(I1*I2)/(2*PI*r)", w/2 + 150,Y2, w-50, h-10);
          textSize(midaSubtitol-8);
          float Y3 = Y2 + 50;
          text("En esta ecuación, NUo es la resistivitat magnética del medio que equivale a 4*PI*(10^-7)\nEntonces, lo único que hace falta es substituir.", x+ 30,Y3, w-50, h-10);
          
          if(objetos > 0){
            float Y4 = Y3 + 75;
            float Resp = calcularEjercicioM1();
            textSize(midaParagraf);
            text("F = (4*PI*(10^-7))*("+CM.I1+"*"+CM.I2+")/(2*PI*"+CM.distancia+") = "+Resp, w/2-150,Y4, w-50, h-10);
            
            textSize(midaSubtitol-8);
            float Y5 = Y4 + 50;
            if(CM.I1< 0 && CM.I2< 0 || CM.I1> 0 && CM.I2> 0){
              text("Solución: La fuerza entre los hilos es de "+Resp+"F atractiva", x+30, Y5, w-30, h);
            }else{
              text("Solución: La fuerza entre los hilos es de "+Resp+"F repulsiva", x+30, Y5, w-30, h);
            }        
          }
          
        }else if(ejercicio==2){
          textSize(midaTitol-16); fill(0); textAlign(CENTER);
          text("Explicación Espira conductora", width/2, marginV+25);//titol
          fill(200); noStroke();
          rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
          textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
          //Pregunta
          if(objetos == 0){
            text("¿Cual es el valor del campo magnético en una espira de radio R mm que conduce una intensidad de I A?", x+ 30, y+marginV+55, w-60, h-10);
          }else{
            text("¿Cual es el valor del campo magnético en una espira de radio "+CM.distancia+" mm que conduce una intensidad de "+CM.I1+" A?", x+ 30, y+marginV+55, w-60, h-10);
          }
          //Explicación:
          float Y1 = y+marginV+55+200;
          textSize(midaSubtitol-8);
          text("En esto problema, existen dos casos. Por un lado, si la intensidad es positiva(es decir, circula en sentido horario) el vecor del campo magnético irá hacia dentro del plano del papel. En cambio, si es negativa, irá hacia fuera. De igual manera, su valor se puede calcular con el módulo siguiendo la siguiente expresión:", x+30, Y1, w-30, h);
          float Y2 = Y1 + 125;
          textSize(midaParagraf);
          text("B = NUo*(I)/(2*r)", w/2 + 150,Y2, w-50, h-10);
          textSize(midaSubtitol-8);
          float Y3 = Y2 + 50;
          text("En esta ecuación, NUo es la resistivitat magnética del medio que equivale a 4*PI*(10^-7)\nEntonces, lo único que hace falta es substituir.", x+ 30,Y3, w-50, h-10);
          if(objetos > 0){
            float Y4 = Y3 + 75;
            float Resp = calcularEjercicioM2();
            textSize(midaParagraf);
            text("F = (4*PI*(10^-7))*("+CM.I1+")/(2*"+CM.distancia+") = "+Resp, w/2,Y4, w-50, h-10);
            
            textSize(midaSubtitol-8);
            float Y5 = Y4 + 50;
            if(CM.I1>0){
              text("El campo magnetico generado es de "+Resp+"T hacia dentro de la pantalla", x+30, Y5, w-30, h);
            }else{
              text("El campo magnetico generado es de "+Resp+"T hacia fuera de la pantalla", x+30, Y5, w-30, h);
            } 
          }
        }
      }
    popStyle();
}

public void pantallaExercicis(TEMA tema, int exercici){
  PImage star;
  pushStyle();
  fill(0);
    if(tema == TEMA.CINEMATICA){
      if(exercici == 1){
        //Titol
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Choque de móbiles", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[0];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        //Visualització d'exercici
        visualitzacioCinematica1(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }else if(exercici == 2){
        //Titol
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Tiro parabólico", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[0];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        visualitzacioCinematica2(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }
    }else if(tema == TEMA.DINAMICA){
      if(exercici == 1){
        //Titol
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Polea en plano inclinado", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[2];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        visualitzacioDinamica1(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }else if(exercici == 2){
        //Titol
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Caja rozante", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[1];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        visualitzacioDinamica2(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }
    }else if(tema == TEMA.OPTICA){
      if(exercici == 1){
        //Titol
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Espejo", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[2];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        visualitzacioOptica1(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }else if(exercici == 2){
        //Titol
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Separación de rayos", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[3];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        visualitzacioOptica2(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }
    }else if(tema == TEMA.GRAVITATORI){
      if(exercici == 1){
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Atracción Estrella-Planeta", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[3];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        visualitzacioGravitatori1(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }else if(exercici == 2){
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Velocitat planeta orbital", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[3];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        visualitzacioGravitatori2(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }
    }else if(tema == TEMA.ELECTRIC){
      if(exercici == 1){
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Particulas cargadas", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[3];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        visualitzacioElectric1(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }else if(exercici == 2){
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Equilibrio Eléctrico", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[3];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        visualitzacioElectric2(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }
    }else if(tema == TEMA.MEGNETIC){
      if(exercici == 1){
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Fuerza entre conductores", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[3];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        visualitzacioMagnetic1(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }else if(exercici == 2){
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Espira conductora", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[3];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        visualitzacioMagnetic2(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }
    }
    drawExercici();
  popStyle();
}

public void drawExercici(){
     pushStyle();
      //Selecció
      s1.setMides(marginH+100+ 900 +200 ,height/3-70, width-2*(marginH+100)-900-200, 60); s1.display();
      fill(255);
      rect(marginH+100+ 900 +200 ,height/3-70+60, width-2*(marginH+100)-900-200, 600-60);
      if(s1.getSelected().equals("Enunciado")){
        fill(0);textSize(midaParagraf);textAlign(TOP, LEFT);
        drawExerciceText(tema, exercici);
        if(objetos == objetoLimite){
          bRESET.setMides((marginH+100+ 900 +200 )+20, (height/3-70+60)+ (600-60) -(80+20), width-2*(marginH+100)-900-200 -(2*20), 80); bRESET.display();
        }
      }else{
        fill(255);
        textAlign(TOP, LEFT);
        drawExerciceResolucion(tema, exercici);
        bEXPLICACION.setMides((marginH+100+ 900 +200 )+20, (height/3-70+60)+ (600-60) -(80+20), width-2*(marginH+100)-900-200 -(2*20), 80); bEXPLICACION.display();
      }
      
      //BOTONES
        //Añadir
        bADD.setMides(marginH+100+ 900 +200 ,height/3-70+60+ (600-60) + 50, width-2*(marginH+100)-900-200, 80); bADD.display();
        //Formulario
        bFORMULARIO.setMides(marginH+100 ,height/3-70+60+ (600-60) + 50, width-2*(marginH+100)-900-200, 80);bFORMULARIO.display();
        //Exportar
        bEXPORT.setMides(marginH+100 + 900- (width-2*(marginH+100)-900-200) ,height/3-70+60+ (600-60) + 50, width-2*(marginH+100)-900-200, 80);bEXPORT.display();
        
        //Añadir
        checkLimit();
        canAdd = objetos < objetoLimite;
        if(currentState == ESTADO.ANADIR){
          drawAdd(canAdd);
        }else if(currentState == ESTADO.EXPORTAR){
          drawExport();
        }        
    popStyle();
}

public void checkLimit(){
  if(tema == TEMA.CINEMATICA){
    if(exercici == 1){
      objetoLimite = 2;
    }else if(exercici == 2){
      objetoLimite = 1;
    }
  }else if(tema == TEMA.DINAMICA){
    if(exercici == 1){
      objetoLimite = 1;
    } else if(exercici == 2){
      objetoLimite = 1;
    }
  }else if(tema == TEMA.OPTICA){
    if(exercici == 1){
      objetoLimite = 1;
    }else if(exercici == 2){
      objetoLimite = 1;
    }
  }else if(tema == TEMA.GRAVITATORI){
    if(exercici == 1){
      objetoLimite = 1;
    }else if(exercici == 2){
      objetoLimite = 1;
    }
  }else if(tema == TEMA.ELECTRIC){
    if(exercici == 1){
      objetoLimite = 1;
    }else if(exercici == 2){
      objetoLimite = 1;
    }
  }else if(tema == TEMA.MEGNETIC){
    if(exercici == 1){
      objetoLimite = 1;
    }else if(exercici == 2){
      objetoLimite = 1;
    }
  }
}

public void drawExerciceResolucion(TEMA tema, int exercici){
  float Resp;
  
  float x = marginH+100+ 900 +200+ 20;
  float y = height/3-70+60+40;
  float w = width-2*(marginH+100)-900-200; 
  float h = 600-60;
  textSize(24); fill(0);
  text("Datos:", x, y);
  text("RESPUESTA:", x, y+h/2);
  textSize(20);
  if(tema == TEMA.CINEMATICA){
    if(exercici == 1 && objetos>1){
        text("Posición primer móbil: ("+m0.p.x+", "+m0.p.y+")", x, y+40, w-30, h);
        text("Posición segundo móbil: ("+m1.p.x+", "+m1.p.y+")", x, y+80, w-30, h);
        text("Velocidad primer móbil: "+m0.vel+"m/s", x, y+120, w-30, h);
        text("Velocidad segundo móbil: "+m0.vel+"m/s", x, y+160, w-30, h);
        Resp = calcularEjercicioC1();
        text("Se chocarán cuando hayan pasado "+Resp+"s", x, y+h/2+40, w-30, h);
    }else if(exercici == 2 && objetos>0){
        text("Angulo con la horizontal: "+m0.angulo+"º", x, y+40, w-30, h);
        text("Velocidad inicial del mobil: "+m0.vel+"m/s", x, y+80, w-30, h);
        text("Altura del precipicio: "+m0.altura+"m", x, y+120, w-30, h);
        Resp = calcularEjercicioC2();
        text("Xocará contra el suelo a "+Resp+"m del precipicio", x, y+h/2+40, w-30, h);
    }
  }else if(tema == TEMA.DINAMICA){
    if(exercici == 1 && objetos > 0){
      text("Masa de la primera caja: "+c0.masa+"kg",x, y+40, w-30, h);
      text("Inclinación del plano: "+c0.angulo+"N", x, y+80, w-30, h);
      Resp = calcularEjercicioD1();
      text("Para que el sistema esté en equilibrio la segunda caja debe tener una masa de "+Resp+"kg", x, y+h/2+40, w-30, h);
    }else if(exercici == 2 && objetos>0){
      text("Masa de la caja: "+c0.masa+"kg", x, y+40, w-30, h);
      text("Fuerza aplicada: "+c0.Fuerza+"N", x, y+80, w-30, h);
      text("Coeficiente de fricción: "+c0.Nu+"m/(s^2)", x, y+120, w-30, h);
      Resp = calcularEjercicioD2();
      if(Resp > 0){
        text("Se moverá; concretamente a "+Resp+"m/(s^2)", x, y+h/2+40, w-30, h);
      }else{
        text("No se moverá", x, y+h/2+40, w-30, h);
      }
    }
  }else if(tema == TEMA.OPTICA){
    if(exercici == 1 && objetos >0){
      text("Distancia Obs.-Vidrio: "+l.XObsVi+"m", x, y+40, w-30, h);
      text("Distancia x Obs-Abeja: "+l.xAbeja+"m", x, y+80, w-30, h);
      text("Distancia y Obs-Abeja: "+l.yAbeja+"m", x, y+120, w-30, h);
      Resp = calcularEjercicioO1();
      text("La imagen se formará a "+Resp+"m del observador", x, y+h/2+40, w-30, h);
    }else if(exercici == 2 && objetos >0){
      text("Ángulo de incidencia: "+l.angulo+"º", x, y+40, w-30, h);
      text("n1: "+l.n1, x, y+80, w-30, h);
      text("n2: "+l.n2, x, y+120, w-30, h);
      Resp = calcularEjercicioO2();
      text("La separación de los rayos será por "+Resp+"º", x, y+h/2+40, w-30, h);
    }
  }else if(tema == TEMA.GRAVITATORI){
    if(exercici == 1 && objetos >0){
      text("Masa Planeta: "+CG.m1+"Kg", x, y+40, w-30, h);
      text("Masa Sol: "+CG.m2+"Kg", x, y+80, w-30, h);
      text("Distancia: "+CG.distancia+"km", x, y+120, w-30, h);
      Resp = calcularEjercicioG1();
      text("La fuerza de atracción entre los cuerpos astonómicos es "+Resp+"N", x, y+h/2+40, w-30, h);
    }else if(exercici == 2 && objetos >0){
      text("Distancia del perihelio: "+CG.rp+"Km", x, y+40, w-30, h);
      text("Distancia del afelio: "+CG.vp+"Km", x, y+80, w-30, h);
      text("velocidad Perihelio: "+CG.rp+"m/s", x, y+120, w-30, h);
      Resp =  calcularEjercicioG2();
      text("En el afelio tiene una velocidad de "+Resp+"m/s", x, y+h/2+40, w-30, h);
    }
  }else if(tema == TEMA.ELECTRIC){
    if(exercici == 1 && objetos >0){
      text("Carga primera partícula: "+P.c1+"nC", x, y+40, w-30, h);
      text("Carga segunda partícula: "+P.c2+"nC", x, y+80, w-30, h);
      text("Distancia entre partículas: "+P.distancia+"mm", x, y+120, w-30, h);
      Resp =  calcularEjercicioE1();
      if(P.c1 > 0 && P.c2 > 0 || P.c1 < 0 && P.c2 < 0){
        text("La fuerza entre las partículas es de "+Resp+"F repulsiva", x, y+h/2+40, w-30, h);
      }else{
        text("La fuerza entre las partículas es de "+Resp+"F atractiva", x, y+h/2+40, w-30, h);
      }
      
    }else if(exercici == 2 && objetos > 0){
      text("Diferencia de potencial: "+P.V+"V", x, y+40, w-30, h);
      if(P.V > 0){
        Resp =  calcularEjercicioE2();
        text("Tendrá que tener una carga de "+Resp+"C para mantenerse en equilibrio", x, y+h/2+40, w-30, h);
      }else{
        text("No se podrá aguantar", x, y+h/2+40, w-30, h);
      }
    }
  }else if(tema == TEMA.MEGNETIC){
    if(exercici == 1 && objetos >0){
      text("Intensidad del primer hilo: "+CM.I1+"A", x, y+40, w-30, h);
      text("Intensidad del segundo hilo: "+CM.I2+"A", x, y+80, w-30, h);
      text("Distancia entre hilos: "+CM.distancia+"mm", x, y+120, w-30, h);
      Resp =  calcularEjercicioM1();
      if(CM.I1< 0 && CM.I2< 0 || CM.I1> 0 && CM.I2> 0){
        text("La fuerza entre los hilos es de "+Resp+"F atractiva", x, y+h/2+40, w-30, h);
      }else{
        text("La fuerza entre los hilos es de "+Resp+"F repulsiva", x, y+h/2+40, w-30, h);
      }
      
    }else if(exercici == 2){
      text("Intensidad del la espira: "+CM.I1+"A", x, y+40, w-30, h);
      text("Radio de la espira: "+CM.distancia+"mm", x, y+80, w-30, h);
      Resp =  calcularEjercicioM2();
      if(CM.I1>0){
        text("El campo magnetico generado es de "+Resp+"T hacia dentro de la pantalla", x, y+h/2+40, w-30, h);
      }else{
        text("El campo magnetico generado es de "+Resp+"T hacia fuera de la pantalla", x, y+h/2+40, w-30, h);
      }
    }
  }
}

public void drawExerciceText(TEMA tema, int exercici){
  float x = marginH+100+ 900 +200+ 20;
  float y = height/3-70+60+40;
  float w = width-2*(marginH+100)-900-200; 
  float h = 600-60;
  textSize(24);//textFont(fonts[0]);
  text("ENUNCIADO:", x, y);
  textSize(20);
  if(tema == TEMA.CINEMATICA){
    if(exercici == 1){
      if(objetos<2){
       text("Dos mobiles, uno situado en la coordenada (X1, Y1) de un eje de cordenadas cartegianas y otro situado en (X2, Y2) se mueven en un MRU (que empieza en t=0s) en dirección de xocar. Si la velocidad del primero es V1m/s y la del segundo es V2m/2, ¿cuando xocarán?", x, y+26, w-30, h-10);
      }else{
        text("Dos mobiles, uno situado en la coordenada ("+m0.p.x+", "+m0.p.y+") de un eje de cordenadas cartegianas y otro situado en ("+m1.p.x+", "+m1.p.y+") se mueven en un MRU (que empieza en t=0s) en dirección de xocar. Si la velocidad del primero es "+m0.vel+"m/s y la del segundo es "+m1.vel+",m/s ¿cuando xocarán?", x, y+26, w-30, h-10);
      }
    }else if(exercici == 2){
      if(objetos == 0){
        text("Si un mobil se situa en un precipicio cuya altura es H y se lanza a una velocidad V en un ángulo A respeto a la horizontal; ¿a cuantos metros del precicpicio xocará contra el suelo?", x, y+26, w-30, h-10);
      }else if(objetos >0){
        text("Si un mobil se situa en un precipicio cuya altura es "+m0.altura+" y se lanza a una velocidad "+m0.vel+" en un ángulo "+m0.angulo+" respeto a la horizontal; ¿a cuantos metros del precicpicio xocará contra el suelo?", x, y+26, w-30, h-10);
      }
      
    }
  }else if(tema == TEMA.DINAMICA){
    if(exercici == 1){
      if(objetos == 0){
        text("Si se considera una polea en un plano inclinado de ángulo Alpha que sujeta dos objetos, y el que está en el plano inclinado tiene una masa de M1 kg, ¿qué masa tiene que tener el segundo objeto para que el sistema esté en equilibrio?", x, y+26, w-30, h-10);
      }else if(objetos == 1){
        text("Si se considera una polea en un plano inclinado de ángulo "+c0.angulo+" que sujeta dos objetos, y el que está en el plano inclinado tiene una masa de "+c0.masa+" kg, ¿qué masa tiene que tener el segundo objeto para que el sistema esté en equilibrio?", x, y+26, w-30, h-10);
      }
    }else if(exercici == 2){
      if(objetos == 0){
        text("Si a un cuerpo de massa M kg se le aplica una fuerza F N, teniendo en cuenta que entre el cuerpo y el suelo hay un coeficiente de fricción Nu, ¿Se moverá? En caso afirmativo ¿Cual será su acceleración?", x, y+26, w-30, h-10);      
      }else{
        text("Si a un cuerpo de massa "+c0.masa+" kg se le aplica una fuerza "+c0.Fuerza+" N, teniendo en cuenta que entre el cuerpo y el suelo hay un coeficiente de fricción "+c0.Nu+", ¿Se moverá? En caso afirmativo ¿Cual será su acceleración?", x, y+26, w-30, h-10);
      }
    }  
  }else if(tema == TEMA.OPTICA){
    if(exercici == 1){
      if(objetos == 0){
         text("Se toma como punto de referencia el ojo de un observador. También se sabe que hay un vidrio a X1 m del ojo y una abeja stiuada a X2 y Y2 m de distáncia,¿en que posición se produce la imagen de la abeja?", x, y+26, w-30, h-10);
      }else if(objetos == 1){
         text("Se toma como punto de referencia el ojo de un observador. También se sabe que hay un vidrio a "+l.XObsVi+" m del ojo y una abeja stiuada a "+l.xAbeja+" y "+l.yAbeja+" m de distáncia,¿en que posición se produce la imagen de la abeja?", x, y+26, w-30, h-10);
      }
   }else if(exercici == 2){
     if(objetos == 0){
        text("Si un rayo de luz que se translada por el aire incide en un vidrio formando un ángulo de Aº con la normal y se separa en dos rayos de coeficientes de refracción n1 y n2, ¿cual será la separación angular de los rayos?", x, y+26, w-30, h-10);
     }else if(objetos == 1){
        text("Si un rayo de luz que se translada por el aire incide en un vidrio formando un ángulo de "+l.angulo+"º con la normal y se separa en dos rayos de coeficientes de refracción "+l.n1+" y "+l.n2+", ¿cual será la separación angular de los rayos?", x, y+26, w-30, h-10);
     }
   }
  }else if(tema == TEMA.GRAVITATORI){
    if(exercici == 1){
      if(objetos == 0){
        text("Si un planeta de massa M1 Kg se encuentra a Dist Km de una estrella de massa M2 Kg, ¿cual será la fuerza de atracción entre los dos cuerpos?", x, y+26, w-30, h-10);
      }else{
        text("Si un planeta de massa "+CG.m1+"Kg se encuentra a "+CG.distancia+"Km de una estrella de massa "+CG.m2+"Kg, ¿cual será la fuerza de atracción entre los dos cuerpos?", x, y+26, w-30, h-10);
      }
    }else if(exercici == 2){
      if(objetos == 0){
        text("Si un cuerpo orbita al rededor de otro y su velocidad en el perihélio (Dist km) es V1 m/s, ¿cual será su velocidad en el afelio (Dist km)?", x, y+26, w-30, h-10);
      }else{
        text("Si un cuerpo orbita al rededor de otro y su velocidad en el perihélio ("+CG.rp+"km) es "+CG.vp+" m/s, ¿cual será su velocidad en el afelio ("+CG.ra+" km)?", x, y+26, w-30, h-10);
      }
    }
  }else if(tema == TEMA.ELECTRIC){
    if(exercici == 1){
      if(objetos == 0){
        text("¿Cual és la fuerza entre dos particulas cargadas (C1 nC y C2 nC) que se encuentran a D mm de distancia?", x, y+26, w-30, h-10);
      }else{
        text("¿Cual és la fuerza entre dos particulas cargadas ("+P.c1+"nC y "+P.c2+"nC) que se encuentran a "+P.distancia+"mm de distancia?", x, y+26, w-30, h-10);
      }
    }else if(exercici == 2){
      if(objetos == 0){
        text("¿Cuál debe ser la separación entre dos placas infinits con diferencia de potencial v V para mantener unelectrón en equilibrio?", x, y+26, w-30, h-10);
      }else{
        text("¿Cuál debe ser la separación entre dos placas infinitas con diferencia de potencial "+P.V+" V para mantener unelectrón en equilibrio?", x, y+26, w-30, h-10);
      }
    }
  }else if(tema == TEMA.MEGNETIC){
    if(exercici == 1){
      if(objetos == 0){
        text("Si se consideran dos hilos conductores con intensidades I1 A y I2 A que distan de Dist m ¿Qué valdrá la fuerza producida entre ellos?", x, y+26, w-30, h-10);  
      }else{
        text("Si se consideran dos hilos conductores con intensidades "+CM.I1+"A y "+CM.I2+"A que distan de "+CM.distancia+"mm  ¿Qué valdrá la fuerza producida entre ellos?", x, y+26, w-30, h-10);
      }
      
    }else if(exercici == 2){
      if(objetos == 0){
        text("¿Cual es el valor del campo magnético en una espira de radio R mm que conduce una intensidad de I A?", x, y+26, w-30, h-10);
      }else{
        text("¿Cual es el valor del campo magnético en una espira de radio "+CM.distancia+" mm que conduce una intensidad de "+CM.I1+" A?", x, y+26, w-30, h-10);
      }
    }
  }
}
//text("", x, y+26, w-30, h-10);
public void drawAdd(boolean canAdd){
  
  //Cantidad de objetos
    if(objetos==2){
      canAdd = false;
    }
  pushStyle();
    fill(getColor("Fondo"));
    rectMode(CENTER); textAlign(CENTER);
    rect(width/2, height/2, width/3+150, height/3+150);
    if(canAdd){
      textSize(midaSubtitol+15); fill(0);
      text("Dar Valores",width/2, height/2- (height/3+150)/2 +70);
      rectMode(CORNER);
      bADDLeave.setMides(width/2 -(200/2) -150, height/2 +(height/3+150)/2 -70 -(80/2), 200, 80); bADDLeave.display();
      bADDRanValues.setMides(width/2 -(200/2) + 150, height/2 +(height/3+150)/2 -70 -(80/2), 200, 80); bADDRanValues.display();
      DisplayAddInformation(tema, exercici); //serà per cada una distinta.
    }else if(!canAdd){
      fill(0);
      text("No puedes añadir más objetos", width/2, height/2);
    }
  popStyle();
}

public void DisplayAddInformation(TEMA tema, int ejercicio){
  pushStyle();
    textAlign(CORNER); textFont(fonts[1]);textSize(30);
    int nFields;
    float xF = width/2-25;
    float xT = width/2-200;
    if(tema == TEMA.CINEMATICA){
      if(ejercicio==1){
        nFields = 3;
        //Nom
        tfCaddName.display(xF, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfCaddName.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Velocitat
        tfCaddVel.display(xF, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)), 200, 40);
        text(tfCaddVel.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        //Posició
        text("X:", xF- 30, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        tfCaddPos1.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 70, 40);
        text("Y:", xF+70+(200-70-70)-30, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        tfCaddPos2.display(xF+70+(200-70-70), (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 70, 40);
        text(tfCaddPos1.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        
        //Magnitudes:
        text("en m", xT+ 400, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        text("m/s", xT+ 400, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
      }else if(ejercicio==2){
        nFields = 4;
        //Nom
        tfCaddName.display(xF, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfCaddName.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Velocitat
        tfCaddVel.display(xF, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)), 200, 40);
        text(tfCaddVel.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        //Angle
        tfCaddAngle.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfCaddAngle.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+35));
        tfCaddHigh.display(xF, -20+(height/2 -(height/3+150)/2-10)+ (4*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfCaddHigh.tipo + ":", xT, -20+(height/2 -(height/3+150)/2-10)+ (4*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+35));
        
        //Magnitudes:
        text("º", xT+ 400, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+35));
        text("m/s", xT+400, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        text("m", xT+400, -20+(height/2 -(height/3+150)/2-10)+ (4*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+35));
      }  
    }else if(tema == TEMA.DINAMICA){
      if(ejercicio==1){
        nFields = 2;
        tfCaddAngle.display(xF,-20+(height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfCaddAngle.tipo + ":", xT, -20+(height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Posició
        tfDaddMasa.display(xF, -20+(height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfDaddMasa.tipo + ":", xT, -20+(height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        
        //Magnitudes:
        text("kg", xT+400, -20+(height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        text("º",  xT+400, -20+(height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
      }else if(ejercicio==2){
        nFields = 3;
        //Nom
        tfDaddMasa.display(xF, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfDaddMasa.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Velocitat
        tfDaddF.display(xF, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)), 200, 40);
        text(tfDaddF.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        //Posició
        tfDaddNu.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfDaddNu.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        
        //Magnitudes:
        text("kg", xT+400, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        text("N", xT+400, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
      }
    }else if(tema == TEMA.OPTICA){
      if(ejercicio==1){
        nFields=3;
        tfOXobs.display(xF+32, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfOXobs.tipo + ":", xT-32,(height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Velocitat
        tfOXabeja.display(xF+95, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)), 200, 40);
        text(tfOXabeja.tipo + ":", xT-95,(height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        //Posició
        tfOYabeja.display(xF+95, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfOYabeja.tipo + ":", xT-95,(height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        
        //Magnitudes:
        text("m", xT+432,(height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        text("m", xT+495,(height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        text("m",  xT+495,(height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
      }else if(ejercicio==2){
        nFields = 3;
        //Nom
        tfOAngulo.display(xF, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfOAngulo.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Velocitat
        tfOn1.display(xF, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)), 200, 40);
        text(tfOn1.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        //Posició
        tfOn2.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfOn2.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        
        //Magnitudes:
        text("º", xT+400, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30) );
      }
    }else if(tema == TEMA.GRAVITATORI){
      if(ejercicio==1){
        nFields = 3;
        tfGm1.display(xF, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfGm1.tipo + ":", xT-40, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Velocitat
        tfGm2.display(xF, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)), 200, 40);
        text(tfGm2.tipo + ":", xT-40, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        //Posició
        tfGDistancias.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfGDistancias.tipo + ":", xT-30, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        
        //Magnitudes:
        text("Kg", xT+400, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30) );
        text("Kg", xT+400, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        text("Km", xT+400, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
      }else if(ejercicio==2){
        nFields = 3;
        tfGr1.display(xF, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfGr1.tipo + ":", xT-65, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Velocitat
        tfGv1.display(xF, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)), 200, 40);
        text(tfGv1.tipo + ":", xT-65, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
       
        tfGr2.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfGr2.tipo + ":", xT-65, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
      
        //Magnitudes;
        text("Km", xT+400, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        text("m/s", xT+400, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        text("Km", xT+400, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
      }
    }else if(tema == TEMA.ELECTRIC){
      if(ejercicio==1){
        nFields = 3;
        tfEc1.display(xF, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfEc1.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Velocitat
        tfEc2.display(xF, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)), 200, 40);
        text(tfEc2.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
       
        tfGDistancias.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfGDistancias.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        
        //Magnitudes:
        text("nC", xT+400, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        text("nC", xT+400, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        text("mm", xT+400, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
      }else if(ejercicio==2){
        nFields = 1;
        tfEV.display(xF+95, height/2-30, 200, 40);
        text(tfEV.tipo+ ":", xT-95, height/2);
        
        //Magnitudes:
        text("V", xT+495, height/2);
      }
    }else if(tema == TEMA.MEGNETIC){
      if(ejercicio==1){
        nFields = 3;
        tfMI1.display(xF, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfMI1.tipo + ":", xT-20, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Velocitat
        tfGDistancias.display(xF, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)), 200, 40);
        text(tfGDistancias.tipo + ":", xT-20, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
       
        tfMI2.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfMI2.tipo + ":", xT-20, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        
        //Magnitudes:
        text("A", xT+400, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        text("mm", xT+400, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        text("A", xT+400, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
      }else if(ejercicio==2){
        nFields=2;
        ftMIntensidad.display(xF, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(ftMIntensidad.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Posició
        tfMRadio.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfMRadio.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        
        //Magnitudes:
        text("A", xT+400, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        text("mm", xT+400, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
      }
    }
  popStyle();
}
int t = 0; boolean exportFeedBack = false;
public void drawExport(){
  pushStyle();
    fill(getColor("Fondo"));
      rectMode(CENTER); textAlign(CENTER); textSize(midaSubtitol+15);
      rect(width/2, height/2, width/3-150, height/3-150);
      fill(0);
      text("Exportar",width/2, height/2- (height/3-150)/2 +70);
      rectMode(CORNER);
      bEXPORTRes.setMides(width/2 -(width/3-150)/2 +20, height/2, ((width/3-150) -20 -2*20 -20)/2, 80); bEXPORTRes.display();
      bEXPORTEnu.setMides(width/2 +(width/3-150)/2 -20 - ((width/3-150) -20 -2*20 -20)/2, height/2, ((width/3-150) -20 -2*20 -20)/2, 80); bEXPORTEnu.display();
  popStyle();
}

public void drawPantallaError(){
  pushStyle();
    fill(255, 0, 0);
    rect(0, 0, width, height);
  popStyle();
}
class Particula{
  //Atributos Especificos
  float c1, c2;
  float distancia;
  float V;
  
  Particula(){}
  
  public void setValores1(float c1, float c2, float dist){
    this.c1 = c1;
    this.c2 = c2;
    this.distancia = dist;
  }
    
  public void setValores2(float V ){
    this.V = V;
  }
  
  public void display(){
    int c;
    if(exercici == 1){
      
      //Primera partícula
      if(c1 > 0){
        c = paleta[2];
      }else{
        c = paleta[3];
      }
      fill(c); noStroke();
      circle(-200, 0, 150);
      
      //Segunda partícula
      if(c2 > 0){
        c = paleta[2];
      }else{
        c = paleta[3];
      }
      fill(c);noStroke();
      circle(200, 0, 150);
      
      if((c1 < 0 && c2>0)||(c1>0 && c2<0)   ||    (c1 > 0 && c2<0)||(c1<0 && c2>0)){
        f.changePoints(-200,0,-100,0);f.display(0);
        f.changePoints(200,0,100,0);f.display(0);
        fill(0);textSize(20);
        text("F", 150, -30);
        text("F", -150, -30);
      }else{
        f.changePoints(-200,0,-300,0);f.display(0);
        f.changePoints(200,0,300,0);f.display(0);
        fill(0);textSize(20);
        text("F", 250, -30);
        text("F", -250, -30);
      }
      
      
      text(distancia, 0, 60);
      f.changePoints(-200,80,200,80);f.display(0);
      f.changePoints(200,80,-200,80);f.display(0);
    }else if(exercici == 2){
      //Damos valores para la fletxa
      float xF = -wVisualitzacio/3+20; float y1F = hVisualitzacio/5-20; float y2F = -hVisualitzacio/5+20;
    
      Fletxa f = new Fletxa(xF, y1F, xF, y2F);
      for(float x0 = xF; x0<wVisualitzacio/3+40; x0+=50.9f){     
        f.display(paleta[4]);
        f.changePoints(x0, y1F, x0, y2F); 
      }
      
      c = paleta[3];
      fill(c);noStroke();
      circle(0, 0, 75);
      textSize(20); fill(0);
      text("Fe", 10, -40);
      f.changePoints(0,0,0,-60);f.display(0);
      text("P",  10,  40);
      f.changePoints(0,0,0, 60);f.display(0);
    }
  }
  
  public void reset(){
    c1 = 0;
    c2 = 0;
    distancia = 0;
    V = 0;
  }
}
public void resetCinematica(){
    objetos = 0;
    m0.reset();
    m1.reset();
    scaleEjercicio = 1;
}
public void resetDinamica(){
  objetos = 0;
  c0.reset();
}

public void resetOptica(){
  objetos = 0;
  l.reset();
}

public void resetCampoGravitatorio(){
  objetos = 0;
  CG.reset();
}

public void resetCampoElectrico(){
  objetos = 0;
  P.reset();
}

public void resetCampoMagnetico(){
  objetos = 0;
  CM.reset();
}
class Seleccionador{
  //Botons necessaris
  Button[] opcions;
  // x, y, emplada,...
  float x, y, w, h;
  //Pels botons
  float wBotons;
  int n;
  
  Seleccionador(){
    
  }
  
  public void setMides(float x, float y, float w, float h){
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
        this.wBotons = this.w/n;
  }
  
  public void setBotons(int n, Button ... p){//Així li passam els botons
    //n és el nombre d'opcions
    opcions = new Button[n];
    this.n = n;
    for(int i=0; i<p.length; i++){
      this.opcions[i] = p[i];
    }
    opcions[0].isSelected= true;
  }
  
  public void setSelec(int n){
    for(int i=0; i<opcions.length; i++){
      opcions[i].isSelected = false;
    }
    opcions[n].isSelected= true;
  }
  
  public String getSelected(){
    for(int i = 0; i<opcions.length; i++){
      if(opcions[i].isSelected){
        return opcions[i].textBoto;
      }
    }
    return null;
  }
  
  public void display(){
    for(int i=0; i<this.opcions.length; i++){
      opcions[i].setMides(this.x+i*wBotons, this.y, wBotons, this.h);
      strokeWeight(5);
      opcions[i].selecUse();
      opcions[i].display();
      //Arreglo
        noStroke();
        if(opcions[i].mouseOverButton()&&!opcions[i].isSelected){
          fill(getColor("BotonPulsado"));
        }else if(opcions[i].isSelected){
          fill(getColor("Seleccionado"));
        }else{
          fill(getColor("BotonSinPulsar"));
        }
        rect(opcions[i].x, opcions[i].y+opcions[i].redondetjat, wBotons, this.h-opcions[i].redondetjat);
        stroke(0); strokeWeight(2); 
        line(opcions[i].x, opcions[i].y+opcions[i].redondetjat, opcions[i].x, opcions[i].y+this.h);
        line(opcions[i].x+wBotons, opcions[i].y+opcions[i].redondetjat, opcions[i].x+wBotons, opcions[i].y+this.h);
        line(opcions[i].x, opcions[i].y+this.h, opcions[i].x+wBotons, opcions[i].y+this.h);
      //Text
        fill(0); textAlign(CENTER); textSize(20); textFont(fonts[1]);
        text(opcions[i].textBoto, opcions[i].x+wBotons/2, opcions[i].y+this.h/2+ 10);
    }
  }
}
class Table {

  String[] tableHeaders;   // Títols de les columnes
  String[][] tableData;    // Dades de la taula
  float[] columnWidths;    // Amplades de les columnes
  
  int numCols, numRows;  // Número de files i columnes
  
  // Constructor
  Table(int nr, int nc){
    this.numRows = nr;
    this.numCols = nc;
  }
  
  // Setters
  
  public void setHeaders(String[] h){
    this.tableHeaders = h;
  }
  
  public void setData(String[][] d){
    this.tableData = d;
  }
  
  public void setValueAt(String value, int nr, int nc){
    this.tableData[nr][nc] = value;
  }
  
  public void setColumnWidths(float[] w){
    this.columnWidths = w;
  }
  
  // Dibuixa taula
  public void display(float x, float y, float w, float h){
    pushMatrix();
      fill(240); stroke(0);strokeWeight(3);
      rect(x, y, w, h);
      
      float rowHeight = h / numRows;
      fill(colors[4]); stroke(0);strokeWeight(3);
      rect(x, y, w, rowHeight);
      
      // Dibuixa files
      stroke(0);
      for(int r = 1; r <numRows; r++){
        if(r==1){ strokeWeight(3); }
        else {    strokeWeight(1); }
        line(x, y + r*rowHeight, x + w, y + r*rowHeight);
      }
      
      // Dibuixa Columnes
      float xCol = x;
      for(int c = 0; c<numCols; c++){
        xCol += w*columnWidths[c]/100.0f;
        line(xCol, y, xCol, y + h);
      }
      
      // Dibuixa textos
      fill(0); textSize(midaSubtitol-5);textAlign(CORNER);
      
      for(int r = 0; r< numRows; r++){
        xCol = x;
        for(int c = 0; c< numCols; c++){
          if(r==0){
            text(tableHeaders[c], xCol + 10, y + (r+1)*rowHeight - 30);
          }
          else{
            int wR = 478;
            if( tableHeaders [0] == "Formules"){
              textSize(midaParagraf);
              wR = 350;
            }
            text(tableData[r-1][c], xCol + 10, y + (r+1)*rowHeight- 80, wR, 100);
          }
          xCol += w*columnWidths[c]/100.0f;
        }
      }
    popMatrix();
    }
}
// Component Camp de Text

class TextField {
  
  // Propietats del camp de text
  float x, y, h, w;
  String tipo;
  
  // Colors
  int bgColor = color(140, 140, 140);
  int fgColor = color(0, 0, 0);
  int selectedColor = color(190, 190, 60);
  int borderColor = color(30, 30, 30);
  int borderWeight = 1;
  
  // Text del camp
  String text = "";
  int textLength = 0;
  int textSize = 20;

  boolean selected = false;
  boolean numerical = false;
   
  // Constructor
  TextField(String tipo) {
      this.tipo = tipo;
   }
  
  // Dibuixa el Camp de Text
  public void display(float x, float y, float w, float h) {
   pushStyle();
     this.x = x; this.y = y; this.w = w; this.h = h;
      
      if (selected) {
         fill(selectedColor);
      } else {
         fill(bgColor);
      }
      
      strokeWeight(borderWeight);
      stroke(borderColor);
      rect(x, y, w, h, 5);
      
      fill(fgColor);
      textSize(textSize); textAlign(CORNER);
      text(text, x + 5, y + this.h/2+ textSize/2);
  popStyle();
 }
   
   // Afegeix, lleva el text que es tecleja
   public void keyPressed(char key, int keyCode) {
      if (selected) {
         if (keyCode == (int)BACKSPACE) {
            removeText();
         } else if (keyCode == 32) {
            addText(' '); // SPACE
         }else if(keyCode == 46 || keyCode == 44){
            addText('.'); // Coma decimal
         }else if(keyCode == 45){
           addText('-'); //Menos
         }else {
            
           boolean isKeyCapitalLetter = (key >= 'A' && key <= 'Z');
           boolean isKeySmallLetter = (key >= 'a' && key <= 'z');
           boolean isKeyNumber = (key >= '0' && key <= '9');
           
           if(numerical){
             if (isKeyNumber || (keyCode == 46 || keyCode == 44) || keyCode == 45) {
               addText(key);
             }
           }
           else{
      
           if (isKeyCapitalLetter || isKeySmallLetter || isKeyNumber) {
               addText(key);
           }
           }
         }
      }
   }
   public void resetText(){
     this.text = "";
   }
   
   // Afegeix la lletra c al final del text
   public void addText(char c) {
      if (textWidth(this.text + c)*0.25f   < w) {
         this.text += c;
         textLength++;
      }
   }
   
   // Lleva la darrera lletra del text
   public void removeText() {
      if (textLength - 1 >= 0){
         text = text.substring(0, text.length() - 1);
         textLength--;
      }
   }

   // Indica si el ratolí està sobre el camp de text
   public boolean mouseOverTextField() {
      if (mouseX >= this.x && mouseX <= this.x + this.w) {
         if (mouseY >= this.y && mouseY <= this.y + this.h) {
            return true;
         }
      }
      return false;
   }
   
   // Selecciona el camp de text si pitjam a sobre
   // Deselecciona el camp de text si pitjam a fora
   public void isPressed() {
      if (mouseOverTextField()) {
         selected = true;
      } else {
         selected = false;
      }
   }
}
class Vector{
  //Atributos
  Mobil m1, m2;
  float distX, distY;
  float componentX, componentY;
  Fletxa f1, f2;
  
  Vector(Mobil m1, Mobil m2){
    this.m1 = m1;
    this.m2 = m2;
  }
  
  Vector (Mobil m){
    
  }
  
  public void displayVector(){
    strokeWeight(5);
    //line(this.m.displayX, this.m.displayY, this.m.displayX+);
  }
  
  public void displayBothVectors(float w, float h){
    
    distX = this.m2.displayX - this.m1.displayX;
    componentX = map(distX, 0, this.m2.displayX- this.m1.displayX, this.m1.displayX, this.m2.displayX);
    distY = this.m1.displayY - this.m2.displayY;
    componentY = map(distY, 0, this.m2.displayY- this.m1.displayY, this.m1.displayY, this.m2.displayY);

    //Display una línea
    if(objetoInVisualization(m1, w, h)){//Si se ve, se dibuja
      float xm1 = lerp(this.m1.displayX, this.m2.displayX, m1.vel/150);
      float ym1 = lerp(this.m1.displayY, this.m2.displayY, m1.vel/150);
      f1 = new Fletxa(m1.displayX, m1.displayY, xm1, ym1);
      f1.display(0);
      
    }
    if(objetoInVisualization(m2, w, h)){//Si se ve, se dibuja
      float xm2 = lerp(this.m2.displayX, this.m1.displayX, m2.vel/150);
      float ym2 = lerp(this.m2.displayY, this.m1.displayY, m2.vel/150);
      f2 = new Fletxa(m2.displayX, m2.displayY, xm2, ym2);
      f2.display(0);
    }
    
  }
}
float scaleEjercicio = 0;


public void dibujarRectangulo(float x, float y, float w, float h){
  pushStyle();
  fill(255);
    rectMode(CENTER);
    strokeWeight(3);
    rect(x, y, w, h, 10); 
  popStyle();
}
public void visualitzacioCinematica1(float x, float y, float w, float h){
  //RECTANGLE
  dibujarRectangulo(x, y, w, h);
    
  //VISUALITZACIÓ EXERCICI
  pushMatrix();
    translate(x, y);
    float separacioLineasX = ((w/2)/(20+scaleEjercicio));
    float separacioLineasY = ((h/2)/(15+scaleEjercicio));
    eixDeCoordenadesCart(w, h, separacioLineasX, separacioLineasY);
    if(objetos == 1){
      m0.calculateDisplay(separacioLineasX, separacioLineasY);
      if(objetoInVisualization(m0, w, h)){
        m0.display(separacioLineasX, separacioLineasY);
      }
    }else if(objetos > 1){
      m0.calculateDisplay(separacioLineasX, separacioLineasY);
      m1.calculateDisplay(separacioLineasX, separacioLineasY);
      C1vectors.displayBothVectors(w, h);
      if(objetoInVisualization(m0, w, h)){
        m0.display(separacioLineasX, separacioLineasY);
      }
      if(objetoInVisualization(m1, w, h)){
        m1.display(separacioLineasX, separacioLineasY);
      }
    }
  popMatrix();
  bzoomMas.setMides(x+w/2-wZoom*2, y-h/2, wZoom, hZoom); bzoomMas.displayTransparencia(150);
  bzoomMenos.setMides(x+w/2-wZoom*1,y-h/2, wZoom, hZoom); bzoomMenos.displayTransparencia(150);
}

float precipicioXSacled;
float precipicioX;
float floor;
public void visualitzacioCinematica2(float x, float y, float w, float h){
  //RECTANGLE
  dibujarRectangulo(x, y, w, h);
    
  //VISUALITZACIÓ EXERCICI
  pushMatrix();
    translate(x, y);
    //Dibujar el precipicio
    precipicioX = -w/2+300;
    precipicioXSacled = precipicioX*(1+ scaleEjercicio);
    floor = h/2-100;
    strokeWeight(5);
    if(scaleEjercicio>1){
      line(-w/2, floor, w/2, floor);
    }else{
    line(-w/2, 0,precipicioXSacled ,0);
    line(precipicioXSacled,0, precipicioXSacled, floor);
    line(precipicioXSacled, floor, w/2, floor);
    }
    //Dibujar altura
    strokeWeight(2);
    if(scaleEjercicio<=1){
      line(precipicioXSacled-20, 0, precipicioXSacled-20, floor);
      line(precipicioXSacled, floor, precipicioXSacled-30, floor);
    }
    
    
    //Dibujar las líneas del suelo 
    strokeWeight(2);
    float separacioLineas = 80; int metros =0;
    for(float xL=precipicioXSacled; xL<w/2; xL+=separacioLineas){
      if(xL>-w/2){
        line(xL, floor, xL, floor+8);
        textSize(10);textAlign(CENTER);fill(0);
        text(metros, xL, floor+ 24);
      }
      metros+=20;
    }
    
  popMatrix();
  if(scaleEjercicio!=0){
    bIzquierda.setMides(x+w/2-wZoom*2,y-h/2, wZoom, hZoom); bIzquierda.displayTransparencia(150);
  }
  bDerecha.setMides(x+w/2-wZoom*1, y-h/2, wZoom, hZoom); bDerecha.displayTransparencia(150);
  
  
  //Dibujar mobil
  checkLimit();
  if(objetos==objetoLimite){
    m0.display(m0.p.x, m0.p.y);
    pushMatrix();
      translate(xVisualitzacio, yVisualitzacio);
      float xF = (m0.p.x+ m0.vel*cos(radians(m0.angulo)));
      float yF = (m0.p.y+ m0.vel*sin(radians(-m0.angulo)));
      Fletxa f = new Fletxa();
      f.changePoints(m0.p.x, m0.p.y, xF, yF); f.display(0);
    popMatrix();
  }
}

  float floorD1;
  float xEmpiezaTriangulo; 
  float xAcabaTriangulo;
public void visualitzacioDinamica1(float x, float y, float w, float h){
  floorD1 = h/2-100;
  xEmpiezaTriangulo= -170; 
  xAcabaTriangulo = -xEmpiezaTriangulo;
  //RECTANGLE
  dibujarRectangulo(x, y, w, h);
 
  pushMatrix();
  pushStyle();
    strokeWeight(5);
    translate(x, y);
    //Floor
    line(-w/2, floorD1, xEmpiezaTriangulo, floorD1);
    for(float xL = xEmpiezaTriangulo+ 20; xL<xAcabaTriangulo; xL+=40){
      line(xL, floorD1, xL+20, floorD1);
    }
    line(xAcabaTriangulo, floorD1, w/2, floorD1);
    //Triangle
    line(xEmpiezaTriangulo, floorD1, xAcabaTriangulo, floorD1-300);
    line(xAcabaTriangulo, floorD1-300, xAcabaTriangulo, floorD1);
    //Polea
    line(xAcabaTriangulo, floorD1-300, xAcabaTriangulo+ 30, floorD1-300- 30);
    circle(xAcabaTriangulo+ 30, floorD1-300- 30, 50);
    checkLimit();
    if(objetos == objetoLimite){
      c0.display();
    }
  popStyle();
  popMatrix(); 
}

public void visualitzacioDinamica2(float x, float y, float w, float h){
  float floor = h/2-100;
  //RECTANGLE
  dibujarRectangulo(x, y, w, h);
  
  pushMatrix();
  pushStyle();
    strokeWeight(5);
    translate(x, y);
    float xCaja = 100; float wCaja = 200;
    float yCaja = floor-wCaja/2;
    //Floor
    fill(0);
    line(-w/2, floor, w/2, floor);
    //Caja
    rectMode(CENTER);
    fill(paleta[0]);
    rect(xCaja, yCaja, wCaja, wCaja);
    checkLimit();
    if(objetos == objetoLimite){
      c0.display();
    }
  popStyle();
  popMatrix();
}

public void visualitzacioOptica1(float x, float y, float w, float h){
  //RECTANGLE
  dibujarRectangulo(x, y, w, h);
 
  pushMatrix();
  pushStyle();
    strokeWeight(5);
    translate(x, y);
    //Vidrio
    imageMode(CENTER);
    vidrio.resize(200, (int)h-100);
    image(vidrio, w/3, 0);
    //Ojo
    ojo.resize(200, 200);
    image(ojo, -w/3+20, h/4+50);
    //Display
    checkLimit();
    if(objetos == objetoLimite){
      l.display();
    } 
  popStyle();
  popMatrix(); 
}

public void visualitzacioOptica2(float x, float y, float w, float h){
  //RECTANGLE
  dibujarRectangulo(x, y, w, h);
  pushMatrix();
  pushStyle();
    strokeWeight(5);
    translate(x, y);
    //Vidrio
    imageMode(CENTER);
    vidrio.resize(200, (int)h-100);
    image(vidrio, 0, 0);
    
    checkLimit();
    if(objetos == objetoLimite){
      l.display();
    } 
  popStyle();
  popMatrix(); 
}

public void visualitzacioGravitatori1(float x, float y, float w, float h){
  //RECTANGLE
  dibujarRectangulo(x, y, w, h);
  pushMatrix();
  pushStyle();
    strokeWeight(5);
    translate(x, y);
    //Sol
    noStroke();fill(paleta[1]);
    arc(0, h/2+99, 400, 400, -PI/1.2f, -PI/6, OPEN);
    
    //Display
    checkLimit();
    if(objetos == objetoLimite){
      CG.display();
    }
    
  popStyle();
  popMatrix(); 
}

public void visualitzacioGravitatori2(float x, float y, float w, float h){
  //RECTANGLE
  dibujarRectangulo(x, y, w, h);
  pushMatrix();
  pushStyle();
    strokeWeight(5);
    translate(x, y);
    //Sol
    noStroke();fill(paleta[1]);
    circle(0, 0, 200);
    
    checkLimit();
    if(objetos == objetoLimite){
      CG.display();
    }
  popStyle();
  popMatrix(); 
}  

public void visualitzacioElectric1(float x, float y, float w, float h){
  //RECTANGLE
  dibujarRectangulo(x, y, w, h);
  pushMatrix();
  pushStyle();
    strokeWeight(5);
    translate(x, y);
    checkLimit();
    if(objetos == objetoLimite){
      P.display();
    }
    
  popStyle();
  popMatrix(); 
}

public void visualitzacioElectric2(float x, float y, float w, float h){
  //RECTANGLE
  dibujarRectangulo(x, y, w, h);
  pushMatrix();
  pushStyle();
    strokeWeight(5);
    translate(x, y);
    line(-w/3, h/5, w/3, h/5);
    line(-w/3, -h/5, w/3, -h/5);
    
    checkLimit();
    if(objetos == objetoLimite){
      P.display();
    }
    
  popStyle();
  popMatrix(); 
}

public void visualitzacioMagnetic1(float x, float y, float w, float h){
  //RECTANGLE
  dibujarRectangulo(x, y, w, h);
  pushMatrix();
  pushStyle();
    strokeWeight(5);
    translate(x, y);
    line(w/5, h/2, w/5, -h/2);
    line(-w/5, h/2, -w/5, -h/2);
    
    checkLimit();
    if(objetos==objetoLimite){
      CM.display();
    }
  popStyle();
  popMatrix(); 
}    

public void visualitzacioMagnetic2(float x, float y, float w, float h){
  //RECTANGLE
  dibujarRectangulo(x, y, w, h);
  pushMatrix();
  pushStyle();
    strokeWeight(5);
    translate(x, y);
    fill(0);
    circle(0, 0, 4);
    //Dibuja Espira
    noFill();stroke(3);
    arc(0, 0, 400, 400, -6*PI/7, 6*PI/7);
    line(-w/2+100, 200*sin(-6*PI/7), 200*cos(-6*PI/7), 200*sin(-6*PI/7));
    line(-w/2+100, -200*sin(-6*PI/7), 200*cos(-6*PI/7), -200*sin(-6*PI/7));
    checkLimit();
    if(objetos==objetoLimite){
      CM.display();
    }
  popStyle();
  popMatrix(); 
}   
public boolean objetoInVisualization(Objeto o, float w, float h){
  return (o.displayX<w/2&&o.displayX>-w/2)&&(-o.displayY<h/2&& -o.displayY>-h/2);
}
public void eixDeCoordenadesCart(float w, float h, float separacioLineasX, float separacioLineasY){
    //cuadrícula:
    strokeWeight(1); stroke(200);
      //Verticals
      for(float xL=-w/2 + separacioLineasX; xL<w/2; xL+=separacioLineasX){
        line(xL, -h/2, xL, h/2);
      }
      //Horitzontals
      for(float yL=-h/2 + separacioLineasY; yL<h/2; yL+=separacioLineasY){
        line(-w/2, yL, w/2, yL);
      }
      
    //Eixos principals
      //X y Y
      strokeWeight(3); stroke(0);
      line(0, -h/2, 0, h/2);
      line(-w/2, 0, w/2, 0);
      //miniLineas
        //X
        for(float xL=-w/2; xL<w/2; xL+=separacioLineasX){
          line(xL, -4, xL, 4);
        }
        //Y
        for(float yL=-h/2; yL<h/2; yL+=separacioLineasY){
          line(-4, yL, 4, yL);
        }
}





Desktop desktop;

public void openWebPage(String siteUrl) {
  try {
    URI site = new URI(siteUrl);
    if (Desktop.isDesktopSupported() && desktop.isSupported(Desktop.Action.BROWSE)) {
      desktop.browse(site);
    } else {
      println("App no suporta el navegador");
    }
  } catch(URISyntaxException e) {
    e.printStackTrace();
  } catch(IOException e) {
    e.printStackTrace();
  }
}
  public void settings() {  fullScreen(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "Soluci__inform_tica" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
