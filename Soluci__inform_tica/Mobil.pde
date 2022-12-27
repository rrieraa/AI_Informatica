class Mobil extends Objeto{
  //Atributos
  float vel, V1, V2;
  Vector velocidad;
  
  Mobil(String n, float x, float y, float Vel){
    //Atributos genéricos
    super(n, x, y);
    //Atributos específicos
    this.vel = Vel;
  }
  
  Mobil(String n, float x, float y, float V1, float V2){
    //Atributos genéricos
    super(n, x, y);
    //Atributos específicos
    this.V1 = V1;
    this.V2 = V2;
  }
  
  void display(float sX, float sY){
    calculateDisplay(sX, sY);
    circle(displayX, displayY, 8);
  }
}
