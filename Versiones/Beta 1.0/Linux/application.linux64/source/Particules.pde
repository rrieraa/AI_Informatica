class Particula{
  //Atributos Especificos
  float c1, c2;
  float distancia;
  float V;
  
  Particula(){}
  
  void setValores1(float c1, float c2, float dist){
    this.c1 = c1;
    this.c2 = c2;
    this.distancia = dist;
  }
    
  void setValores2(float V ){
    this.V = V;
  }
  
  void display(){
    color c;
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
      for(float x0 = xF; x0<wVisualitzacio/3+40; x0+=50.9){     
        f.display(paleta[4]);
        f.changePoints(x0, y1F, x0, y2F); 
      }
      
      c = paleta[3];
      fill(c);
      circle(0, 0, 75);
    }
  }
  
  void reset(){
    c1 = 0;
    c2 = 0;
    distancia = 0;
    V = 0;
  }
}
