import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.pdf.*; 
import java.awt.Desktop; 
import java.net.URI; 
import java.io.IOException; 
import java.net.URISyntaxException; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Soluci__inform_tica extends PApplet {

//Libraries


public void setup(){
  
  textAlign(CENTER);
  setColors(); setFonts();
  setCards(); setButtons();setSeleccionador();setTaules(); setDesktop();
  setMedias();
  createGraphicsPDF();
}

public void draw(){
  //Background
  background.resize(width, height);
  image(background, 0, 0);
  seleccionaPantalla(Pantalla);
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

public void createMobilC2() {
  if (objetos == 0) {
    m0.setValues2(tfCaddName.text, Float.parseFloat(tfCaddVel.text), Float.parseFloat(tfCaddHigh.text), Float.parseFloat(tfCaddAngle.text), paleta[1]);
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

public void createCajaD2() {
  if (objetos == 0) {
    c0.setValues2(Float.parseFloat(tfDaddMasa.text), Float.parseFloat(tfDaddF.text), Float.parseFloat(tfDaddNu.text));
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

public void createLuzO2() {
  if (objetos == 0) {
    l.setValues2(Float.parseFloat(tfOAngulo.text), Float.parseFloat(tfOn1.text), Float.parseFloat(tfOn2.text));
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

public void createCampoGravitatorioG2() {
  if (objetos == 0) {
    CG.setValues2(Float.parseFloat(tfGr1.text), Float.parseFloat(tfGr2.text), Float.parseFloat(tfGv1.text));
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

public void createCampoElectrico2(){
  if(objetos == 0){
    P.setValores2(Float.parseFloat(tfEV.text));
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

public void createCampoMagnetico2(){
  if(objetos == 0){
    CM.setValues2(Float.parseFloat(ftMIntensidad.text), Float.parseFloat(tfMRadio.text));
  }
  ftMIntensidad.resetText();
  tfMRadio.resetText();
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
       /*if(textBoto == "Valores Aleatorios"){
         textSize(20);
       }*/
       
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
       fill(getColor("BotonPulsado"), t);      // Color quan ratolí a sobre
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
  float dist = dist(m0.p.x, m0.p.y, m1.p.x, m1.p.y);
  //Se calcula el momento donde se xocarán
  t =(dist/(m0.vel+m1.vel));
  return t;
}

public float calcularEjercicioC2(){
  float x;
  float a = radians(m0.angulo);
  float t = (-(m0.vel*sin(a))+sqrt(  ( m0.vel*sin(a)*(m0.vel*sin(a) )   )  +(2*9.81f*m0.altura)))/(2*m0.altura);
  x = (m0.vel*cos(a))*t;
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
  nu = (c0.Fuerza-(c0.masa*c0.Nu))/(c0.masa*9.81f);
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
  A1 = asin((1/l.n1)*sin(a));
  A2 = asin((1/l.n2)*sin(a));
  res = abs(A1-A2);
  return res;
}

public float calcularEjercicioG1(){
  float a = (float)(6.67f*Math.pow(10, -11))*CG.m1 * CG.m2;
  float b = (float)(Math.pow(CG.distancia, 2));
  return a/b;
}

public float calcularEjercicioG2(){
  float v = (CG.rp * CG.vp)/CG.ra;
  return v;
}

public float calcularEjercicioE1(){
  float F;
  float a = (float)(9*Math.pow(10, 9) * P.c1 * P.c2);
  float b = (float) (Math.pow(P.distancia, 2));
  F = a/b;
  return F;
}

public float calcularEjercicioE2(){
  float a = 1.6f* (float)Math.pow(10,-19) * P.V;
  float b = 9.81f* 9.31f * (float)Math.pow(10, -31);
  return a/b;
}

public float calcularEjercicioM1(){
  float a =  4*PI* (float)Math.pow(10,-7) * CM.I1 * CM.I2;
  float b = 2*PI*CM.distancia;
  return a/b;
}

public float calcularEjercicioM2(){
  float a =  4*PI* (float)Math.pow(10,-7) * CM.I1;
  float b = 2*CM.distancia;
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
      fill(0);
      textSize(25);
      text("F", 20, -hVisualitzacio/2 + 150);
    }else if(exercici == 2){
      noFill();stroke(1);strokeWeight(2);
      ellipse(0, 0, 750, 450);
      //Planeta
      fill(paleta[0]); noStroke();
      circle(375, 0, 75);
      circle(-375, 0, 75);
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
    }else if(exercici == 2){
      if(CM.I1 < 0){
        f.changePoints(-wVisualitzacio/2+260, 200*sin(-6*PI/7),-wVisualitzacio/2+110, 200*sin(-6*PI/7));
        f.display(paleta[4]);
        f.changePoints(-wVisualitzacio/2+110, -200*sin(-6*PI/7), -wVisualitzacio/2+260, -200*sin(-6*PI/7));
        f.display(paleta[4]);
      }else{
        f.changePoints(-wVisualitzacio/2+110, 200*sin(-6*PI/7),-wVisualitzacio/2+260, 200*sin(-6*PI/7));
        f.display(paleta[4]);
        f.changePoints(-wVisualitzacio/2+260, -200*sin(-6*PI/7), -wVisualitzacio/2+110, -200*sin(-6*PI/7));
        f.display(paleta[4]);
      }
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
      text(this.nom, x+wCard/2, y);
      //Se muestran las estrellas
      displayStars(estrelles, x, y-20);
      this.boto.setMides(x, y+100, wCard, 250); this.boto.DisplayWithImage(this.image, 255);
    popStyle();
  }
  public void displayStars(int e, float x, float y){ //<>//
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
public void exportarC1(){
  print("aaaaa");
  pdfC1.beginDraw();
    pushStyle();
      pdfC1.fill(255); pdfC1.noStroke();
      float x = width/6; float y = 0;
      float w = 2*width/3; float h = height;
      pdfC1.rect(width/6, 0, 2*width/3, height);
      pdfC1.fill(0);
      pdfC1.textSize(midaTitol-5); pdfC1.fill(0); pdfC1.textAlign(CENTER);
      pdfC1.text("Explicación choque entre cuerpos", width/2, marginV+25);//titol
      pdfC1.fill(200); pdfC1.noStroke();
      pdfC1.rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
      pdfC1.textSize(midaSubtitol-2); pdfC1.textAlign(TOP, LEFT); pdfC1.fill(0);
      if(objetos>1){
        pdfC1.text("Enunciado: Dos mobiles, uno situado en la coordenada ("+m0.p.x+", "+m0.p.y+") de un eje de cordenadas cartegianas y otro situado en ("+m1.p.x+", "+m1.p.y+") se mueven en un MRU (que empieza en t=0s) en dirección de chocar. Si la velocidad del primero es "+m0.vel+"m/s y la del segundo es "+m1.vel+",m/s ¿cuándo chocarán?", x+ 30, y+marginV+55, w-60, h-10);
      }else{
        pdfC1.text("Enunciado: Dos mobiles, uno situado en la coordenada (X1, Y1) de un eje de cordenadas cartegianas y otro situado en (X2, Y2) se mueven en un MRU (que empieza en t=0s) en dirección de chocar. Si la velocidad del primero es V1m/s y la del segundo es V2m/2, ¿cuándo chocarán?", x+ 30, y+marginV+55, w-60, h-10);
      }
      //Escrito de resolución
      pdfC1.textSize(midaSubtitol-8);
      pdfC1.text("En primer lugar, se halla la distancia entre los dos móbiles usando el teorema de pitágoras:", x+ 30, y+marginV+55+200, w-50, h-10);
      //Pitagoras:
        pit1.resize(240, 240); pit2.resize(500, 150);
        float xBorde = x+30;
        float yImg1 = y+marginV+55+200 + 100;
        pdfC1.image(pit1, xBorde, yImg1); 
        float x1F1 = xBorde + 240; float x2F1 =x1F1 + 60;
        float yF = yImg1 + 240/2;
        f.changePoints(x1F1, yF, x2F1, yF); f.display(0);
        float xDist = x2F1 + 10;
        pdfC1.textAlign(LEFT, CENTER); pdfC1.textSize(midaParagraf);
        pdfC1.text("Dist = sqrt((Dx)^2 + (Dy)^2   \nDist = sqrt((X2-X1)^2 + (Y2-Y1)^2)",xDist, yF);
        float xImg2 = xDist+ 400;
        pdfC1.image(pit2, xImg2, y+marginV+55+200 + 100 + 45);
      
      pdfC1.textAlign(LEFT, TOP); pdfC1.textSize(midaSubtitol-8); float yText = yF + 240/2; pdfC1.fill(0);
      pdfC1.text("Que los coches choquen significa que su posición es la misma; por lo tanto, igualamos sus ecuaciones de movimiento:", x+ 30, yText, w-50, h-10);
      //Igualación de Ecuaciones:
      pdfC1.textAlign(CENTER, TOP); pdfC1.textSize(midaParagraf+4);
      float xExpr = x+w/2-400; float yExpr = yText + 60;
      pdfC1.text("p1 =p2   \np01+v1*t = p02+v2*t   \n0+v1*t = dist+v2*t \nen modulo: v1*t = dist -v2*t \nt = (dist)/(v1+v2)    \nt = (sqrt((X2-X1)^2 + (Y2-Y1)^2))/(v1+v2)", xExpr, yExpr, 800, 600);
      
      //Substitución:
      if(objetos>1){
        pdfC1.textAlign(LEFT, TOP); pdfC1.textSize(midaSubtitol-8);
        float ySub = yExpr + 180;
        pdfC1.text("Entonces, substituimos en la ecuación:", xBorde, ySub);
        float yRes = ySub+40;
        float Resp = calcularEjercicioC1();
        pdfC1.text("t = (sqrt(("+m1.p.x+"-"+m0.p.x+")^2 + ("+m1.p.y+"-"+m0.p.y+"^2))/("+m0.vel+"+"+m1.vel+") = "+Resp, xExpr, yRes, w, 600);
        pdfC1.text("SOLUCIÓN: Se chocarán cuando hayan passado "+Resp+"s", xBorde, ySub+100);
      }
    pdfC1.dispose();
    pdfC1.endDraw();
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
    Button bApp = new Button("Información App");
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
      
        String[][] infoCt = {{"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""}};
        String[][] infoDt = {{"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""}};
        String[][] infoOt = {{"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""}};
        String[][] infoGt = {{"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""}};
        String[][] infoEt = {{"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""}};
        String[][] infoMt = {{"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""}};
        
        
    //Talbes
    Table tCfor = new Table(nCr, nc); 
    Table tDfor = new Table(nGr, nc); 
    Table tOfor = new Table(nOr, nc); 
    Table tGfor = new Table(nGr, nc); 
    Table tEfor = new Table(nEr, nc); 
    Table tMfor = new Table(nMr, nc); 
    
    String[] formules = {"Formules"};
    float[] proportionsF = {100};
        String[][] infoCf = {{""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""}};
        String[][] infoDf = {{""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""}};
        String[][] infoOf = {{""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""}};
        String[][] infoGf = {{""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""}};
        String[][] infoEf = {{""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""}};
        String[][] infoMf = {{""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""}};    
                             
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
PGraphics pdfC1;

public void createGraphicsPDF(){
  pushMatrix();
    translate(width/6, 0);
    pdfC1 = createGraphics(2*width/3, height);
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
      //Discontínuas
      line(wVisualitzacio/3 - 100, 0, wVisualitzacio/3-50, -20);
      line( wVisualitzacio/3 , -40, wVisualitzacio/3 +50, -60);
      line( wVisualitzacio/3 +100, -80, wVisualitzacio/3 +150, -100);
      
    }else if(exercici == 2){
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
      }
    //Exportar
      //Enunciado
      else if(bEXPORT.mouseOverButton()){
        currentState = ESTADO.EXPORTAR;
      }else if(bEXPORTEnu.mouseOverButton()){
        //Iniciar exportacion Enunciado();
        currentState = ESTADO.EJERCICIO;
      }
      //Respuestas
      else if(bEXPORTRes.mouseOverButton()){
        //Iniciar exportacion Respuesas();
        currentState = ESTADO.EJERCICIO;
        exportarC1();
      }
    //Explicación
      else if(bEXPLICACION.mouseOverButton()&& !s1.getSelected().equals("Enunciado")){
        Pantalla = PANTALLA.EXPLICACION;
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
          
          //Substitución:
          if(objetos>1){
            textAlign(LEFT, TOP); textSize(midaSubtitol-8);
            float ySub = yExpr + 180;
            text("Entonces, substituimos en la ecuación:", xBorde, ySub);
            float yRes = ySub+40;
            float Resp = calcularEjercicioC1();
            text("t = (sqrt(("+m1.p.x+"-"+m0.p.x+")^2 + ("+m1.p.y+"-"+m0.p.y+"^2))/("+m0.vel+"+"+m1.vel+") = "+Resp, xExpr, yRes, w, 600);
            text("SOLUCIÓN: Se chocarán cuando hayan passado "+Resp+"s", xBorde, ySub+100);
          }
          
        }else if(ejercicio==2){
          text("Explicación Cinemàtica 2", width/2, height/2);
        }  
      }else if(tema == TEMA.DINAMICA){
        if(ejercicio==1){
          text("Explicación Dinamica 1", width/2, height/2);
        }else if(ejercicio==2){
          text("Explicación Dinamica 2", width/2, height/2);
        }
      }else if(tema == TEMA.OPTICA){
        if(ejercicio==1){
          text("Explicación Optica 1", width/2, height/2);
        }else if(ejercicio==2){
          text("Explicación Optica 2", width/2, height/2);
        }
      }else if(tema == TEMA.GRAVITATORI){
        if(ejercicio==1){
          text("Explicación Campo Gravitatorio 1", width/2, height/2);
        }else if(ejercicio==2){
          text("Explicación Campo Gravitatorio 2", width/2, height/2);
        }
      }else if(tema == TEMA.ELECTRIC){
        if(ejercicio==1){
          text("Explicación Campo Electrico 1", width/2, height/2);
        }else if(ejercicio==2){
          text("Explicación Campo Electrico 2", width/2, height/2);
        }
      }else if(tema == TEMA.MEGNETIC){
        if(ejercicio==1){
          text("Explicación Campo Magnetico 1", width/2, height/2);
        }else if(ejercicio==2){
          text("Explicación Campo Magnetico 2", width/2, height/2);
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
          //bRESET.setMides((marginH+100+ 900 +200 )+20, (height/3-70+60)+ (600-60) -(80+20), width-2*(marginH+100)-900-200 -(2*20), 80); bRESET.display();
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
      text("Distancia: "+CG.distancia+"m", x, y+120, w-30, h);
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
      text("Carga primera partícula: "+P.c1+"mC", x, y+40, w-30, h);
      text("Carga segunda partícula: "+P.c2+"mC", x, y+80, w-30, h);
      text("Distancia entre partículas: "+P.distancia+"m", x, y+120, w-30, h);
      Resp =  calcularEjercicioE1();
      if(P.c1 > 0 && P.c2 > 0 || P.c1 < 0 && P.c2 < 0){
        text("La fuerza entre las partículas es de "+Resp+"F repulsiva", x, y+h/2+40, w-30, h);
      }else{
        text("La fuerza entre las partículas es de "+Resp+"F atractiva", x, y+h/2+40, w-30, h);
      }
      
    }else if(exercici == 2 && objetos > 0){
      text("Diferencia de potencial: "+P.V+"mC", x, y+40, w-30, h);
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
      text("Distancia entre hilos: "+CM.distancia+"m", x, y+120, w-30, h);
      Resp =  calcularEjercicioM1();
      if(CM.I1< 0 && CM.I2< 0 || CM.I1> 0 && CM.I2> 0){
        text("La fuerza entre los hilos es de "+Resp+"F atractiva", x, y+h/2+40, w-30, h);
      }else{
        text("La fuerza entre los hilos es de "+Resp+"F repulsiva", x, y+h/2+40, w-30, h);
      }
      
    }else if(exercici == 2){
      text("Intensidad del la espira: "+CM.I1+"A", x, y+40, w-30, h);
      text("Radio de la espira: "+CM.distancia+"A", x, y+80, w-30, h);
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
        text("Si un planeta de massa M1 se encuentra a Dist de una estrella de massa M2, ¿cual será la fuerza de atracción entre los dos cuerpos?", x, y+26, w-30, h-10);
      }else{
        text("Si un planeta de massa "+CG.m1+" se encuentra a "+CG.distancia+" de una estrella de massa "+CG.m2+", ¿cual será la fuerza de atracción entre los dos cuerpos?", x, y+26, w-30, h-10);
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
        text("¿Cual és la fuerza entre dos particulas cargadas (C1 mC y C2 mC) que se encuentran a D m de distancia?", x, y+26, w-30, h-10);
      }else{
        text("¿Cual és la fuerza entre dos particulas cargadas ("+P.c1+"mC y "+P.c2+"mC) que se encuentran a "+P.distancia+"m de distancia?", x, y+26, w-30, h-10);
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
        text("Si se consideran dos hilos conductores con intensidades "+CM.I1+"A y "+CM.I2+"A que distan de "+CM.distancia+"m  ¿Qué valdrá la fuerza producida entre ellos?", x, y+26, w-30, h-10);
      }
      
    }else if(exercici == 2){
      if(objetos == 0){
        text("¿Cual es el valor del campo magnético en una espira de radio R m que conduce una intensidad de I A?", x, y+26, w-30, h-10);
      }else{
        text("¿Cual es el valor del campo magnético en una espira de radio "+CM.distancia+" m que conduce una intensidad de "+CM.I1+" A?", x, y+26, w-30, h-10);
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
      bADDLeave.setMides(width/2 -(200/2), height/2 +(height/3+150)/2 -70 -(80/2), 200, 80); bADDLeave.display();
      //bADDLeave.setMides(width/2 -(200/2) -150, height/2 +(height/3+150)/2 -70 -(80/2), 200, 80); bADDLeave.display();
      //bADDRanValues.setMides(width/2 -(200/2) + 150, height/2 +(height/3+150)/2 -70 -(80/2), 200, 80); bADDRanValues.display();
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
      }  
    }else if(tema == TEMA.DINAMICA){
      if(ejercicio==1){
        nFields = 2;
        tfCaddAngle.display(xF,-20+(height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfCaddAngle.tipo + ":", xT, -20+(height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Posició
        tfDaddMasa.display(xF, -20+(height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfDaddMasa.tipo + ":", xT, -20+(height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));

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
      }else if(ejercicio==2){
        nFields = 3;
        tfGr1.display(xF, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfGr1.tipo + ":", xT-65, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Velocitat
        tfGv1.display(xF, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)), 200, 40);
        text(tfGv1.tipo + ":", xT-65, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
       
        tfGr2.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfGr2.tipo + ":", xT-65, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
      
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
  
      }else if(ejercicio==2){
        nFields = 1;
        tfEV.display(xF+95, height/2-30, 200, 40);
        text(tfEV.tipo+ ":", xT-95, height/2);
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
      }else if(ejercicio==2){
        nFields=2;
        ftMIntensidad.display(xF, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(ftMIntensidad.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Posició
        tfMRadio.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfMRadio.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
     
      }
    }
  popStyle();
}

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
      fill(c);
      circle(-200, 0, 150);
      
      //Segunda partícula
      if(c2 > 0){
        c = paleta[2];
      }else{
        c = paleta[3];
      }
      fill(c);
      circle(200, 0, 150);
      
      f.changePoints(-200,0,-100,0);f.display(0);
      f.changePoints(200,0,100,0);f.display(0);
    }else if(exercici == 2){
      //Damos valores para la fletxa
      float xF = -wVisualitzacio/3+20; float y1F = hVisualitzacio/5-20; float y2F = -hVisualitzacio/5+20;
    
      Fletxa f = new Fletxa(xF, y1F, xF, y2F);
      for(float x0 = xF; x0<wVisualitzacio/3+40; x0+=50.9f){     
        f.display(paleta[4]);
        f.changePoints(x0, y1F, x0, y2F); 
      }
      
      c = paleta[3];
      fill(c);
      circle(0, 0, 75);
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
      fill(200, 100, 100); stroke(0);strokeWeight(3);
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
            text(tableData[r-1][c], xCol + 10, y + (r+1)*rowHeight - 30);
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
      
           if (isKeyCapitalLetter || isKeySmallLetter || isKeyNumber) {
               addText(key);
           }
         }
      }
   }
   public void resetText(){
     this.text = "";
   }
   
   // Afegeix la lletra c al final del text
   public void addText(char c) {
      if (textWidth(this.text + c)*0.5f   < w) {
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
