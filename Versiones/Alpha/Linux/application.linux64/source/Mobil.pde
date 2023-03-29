class Mobil extends Objeto{
  //Atributos
  float vel;
  color c;
  float angulo;
  float altura;
  
  Mobil(){
    super("");
  }
  void setValues1(String n, float x, float y, float Vel, color c){
    //Atributos genéricos
    super.nombre = n;
    super.p = new PVector(x, y);
    //Atributos específicos
    this.vel = Vel;
    this.c = c;
  }
  
  void setValues2(String n, float v, float h, float a, color c){
    //Atributos genéricos
    super.nombre = n;
    super.p = new PVector(precipicioXSacled-30, -30);
    print(precipicioXSacled-10); print(floor-10);
    this.altura = h;
    this.angulo = a;
    this.vel = v;
    this.c = c;
  }
  
  void reset(){
    super.nombre = "";
    super.p = null;
    this.vel = 0;
    this.altura = 0;
    this.angulo = 0;
  }
  
  void display(float sX, float sY){
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
