class Vector{
  //Atributos
  Mobil m1, m2;
  float distX, distY;
  float componentX, componentY;
  Fletxa f1, f2;
  
  Vector(Mobil m1, Mobil m2){
    this.m1 = m1;
    this.m2 = m2;
  }
  
  Vector (Mobil m){
    
  }
  
  void displayVector(){
    strokeWeight(5);
    //line(this.m.displayX, this.m.displayY, this.m.displayX+);
  }
  
  void displayBothVectors(float w, float h){
    
    distX = this.m2.displayX - this.m1.displayX;
    componentX = map(distX, 0, this.m2.displayX- this.m1.displayX, this.m1.displayX, this.m2.displayX);
    distY = this.m1.displayY - this.m2.displayY;
    componentY = map(distY, 0, this.m2.displayY- this.m1.displayY, this.m1.displayY, this.m2.displayY);

    //Display una línea
    if(objetoInVisualization(m1, w, h)){//Si se ve, se dibuja
      float xm1 = lerp(this.m1.displayX, this.m2.displayX, componentX);
      float ym1 = lerp(this.m1.displayY, this.m2.displayY, componentY);
      f1 = new Fletxa(m1.displayX, m1.displayY, m1.displayX+componentX, m1.displayY+componentY);
      f1.display(0);
      
    }
    if(objetoInVisualization(m2, w, h)){//Si se ve, se dibuja
      float xm2 = lerp(this.m2.displayX, this.m1.displayX, m2.vel/100);
      float ym2 = lerp(this.m2.displayY, this.m1.displayY, m2.vel/100);
      f2 = new Fletxa(m2.displayX, m2.displayY, xm2, ym2);
      f2.display(0);
    }
    
  }
}
