class CampoGravitatorio{
  //Atributos
  float m1, m2;
  float distancia;
  
  float rp, ra;
  float vp;
  
  CampoGravitatorio(){}
  
  void setValues1(float m1, float m2, float d){
    this.m1 = m1;
    this.m2 = m2;
    this.distancia = d;
  }
  
  void setValues2(float r1, float r2, float v){
     this.rp = r1;
     this.ra = r2;
     this.vp = v;
  }
  
  void display(){
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
  
  void reset(){
    m1 = 0;
    m2 = 0;
    distancia = 0;
  }
}
