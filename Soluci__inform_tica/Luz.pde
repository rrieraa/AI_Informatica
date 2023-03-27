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
  
  void setValues1(float Xo, float Xa, float Ya){
    this.XObsVi = Xo;
    this.xAbeja = Xa;
    this.yAbeja = Ya;
  }
  void setValues2(float a, float n1, float n2){
    this.angulo = a;
    this.n1 = n1;
    this.n2 = n2;
  }
  
  void display(){
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
  
  void reset(){
    XObsVi = 0;
    xAbeja = 0; 
    yAbeja = 0;
    angulo = 0;
    n1 = 0;
    n2 = 0;
  }
}
