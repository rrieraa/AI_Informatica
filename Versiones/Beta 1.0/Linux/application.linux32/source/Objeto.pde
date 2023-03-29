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
  
  void calculateDisplay(float sX, float sY){
    displayX = this.p.x*sX;
    displayY = -this.p.y*sY;
  }
}
