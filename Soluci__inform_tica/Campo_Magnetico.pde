class CampoMagnetico{
  //Atributos
  float I1, I2;
  float distancia;
  
  CampoMagnetico(){}
  
  void setValues1(float I1, float I2, float dist){
    this.I1 = I1;
    this.I2 = I2;
    this.distancia = dist;
  }
  
  void setValues2(float I, float dist){
    this.I1 = I;
    this.distancia = dist;
  }
  
  void display(){
    if(exercici == 1){
      //Flechas orientadas según la corriente
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
  
  void reset(){
    this.I1 = 0;
    this.I2 = 0;
    this.distancia = 0;
  }
}
