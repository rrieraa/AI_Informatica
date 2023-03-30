class Caja extends Objeto{
  //Atributos
  float masa;
  float Fuerza;
  float Nu;
  float angulo;
  
  Caja(){
    super("", 0, 0);
  }
  
  void setValues2(float m, float F, float n){
    this.masa = m;
    this.Fuerza = F;
    this.Nu = n;
  }
  void setValues1(float m, float a){
    this.masa = m;
    this.angulo = a;
  }
  
  void display(){
    if(exercici == 1){
      pushMatrix();
        rotate(PI/4+0.05); fill(paleta[1]);
        rect(-80, 0, 115, 115);   
        rotate(-PI/2);
        textAlign(CENTER); textSize(17); fill(0);
        text(c0.masa+"kg",-60, 0);
      popMatrix();
      noFill();
      arc(xEmpiezaTriangulo, floorD1, 200, 200, 3*PI/2+ (PI/2-PI/4+0.08), 2*PI);
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
  
  void reset(){
    this.masa = 0;
    this.Fuerza = 0;
    this.Nu = 0;
  }
}
