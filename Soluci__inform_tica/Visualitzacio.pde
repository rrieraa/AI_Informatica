
void visualitzacioCinematica1(float x, float y, float w, float h){
  float scale = 1;
  pushStyle();
        rectMode(CENTER);
        strokeWeight(3);
        rect(x, y, w, h, 10); 
        fill(0);textSize(midaSubtitol);
      popStyle();
  eixDeCoordenades(x, y, w, h, scale);
}

void eixDeCoordenades(float x, float y, float w, float h, float scale){
  float separacioLineasX = (w/50)*scale;
  float separacioLineasY = (h/20)*scale;
  pushMatrix();
    translate(x, y);
    //Eixos principals
      strokeWeight(3);
      line(0, -h/2, 0, h/2);
      line(-w/2, 0, w/2, 0);
    //miniLineas
      //X
      for(float xL=-w/2; xL<w/2; xL+=separacioLineasX){
        line(xL, -4, xL, 4);
      }
      //Y
      for(float yL=-h/2; yL<h/2; yL+=separacioLineasY){
        line(-4, yL, 4, yL);
      }
  popMatrix();
}
