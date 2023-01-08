class Mobil extends Objeto{
  //Atributos
  float vel, V1, V2;
  Vector velocidad;
  color c;
  
  Mobil(String n, float x, float y, float Vel, color c){
    //Atributos genéricos
    super(n, x, y);
    //Atributos específicos
    this.vel = Vel;
    this.c = c;
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
    fill(this.c); noStroke();
    circle(displayX, displayY, 10);
  }
}
