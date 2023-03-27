class Particula{
  //Atributos Especificos
  float c1, c2;
  float distancia;
  
  Particula(){}
  
  void setValores1(float c1, float c2, float dist){
    this.c1 = c1;
    this.c2 = c2;
    this.distancia = dist;
  }
  
  void setValores2(float c ){
    this.c1 = c;
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
      if(c1 > 0){
        c = paleta[2];
      }else{
        c = paleta[3];
      }
      
      fill(c);
      circle(0, 0, 100);
    }
  }
  
  void reset(){
    c1 = 0;
    c2 = 0;
    distancia = 0;
  }
}
