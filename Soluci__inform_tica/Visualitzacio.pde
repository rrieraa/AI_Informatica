float scaleEjercicio = 0;

void visualitzacioCinematica1(float x, float y, float w, float h){
  //RECTANGLE
  pushStyle();
    rectMode(CENTER);
    strokeWeight(3);
    rect(x, y, w, h, 10); 
  popStyle();
    
  //VISUALITZACIÓ EXERCICI
  pushMatrix();
    translate(x, y);
    float separacioLineasX = ((w/2)/(20+scaleEjercicio));
    float separacioLineasY = ((h/2)/(15+scaleEjercicio));
    eixDeCoordenadesCart(w, h, separacioLineasX, separacioLineasY);
    if(objetos == 1){
      //Se dibuja si se encuentra dentro de la visualización
      m0.calculateDisplay(separacioLineasX, separacioLineasY);
      if(objetoInVisualization(m0, w, h)){
        m0.display(separacioLineasX, separacioLineasY);
      }
    }else if(objetos > 1){
      m0.calculateDisplay(separacioLineasX, separacioLineasY);
      m1.calculateDisplay(separacioLineasX, separacioLineasY);
      C1vectors.displayBothVectors(w, h);
      if(objetoInVisualization(m0, w, h)){
        m0.display(separacioLineasX, separacioLineasY);
      }
      if(objetoInVisualization(m1, w, h)){
        m1.display(separacioLineasX, separacioLineasY);
      }
    }
  popMatrix();
  bzoomMas.setMides(x+w/2-wZoom*3, y-h/2, wZoom, hZoom); bzoomMas.display();
  bzoomMenos.setMides(x+w/2-wZoom*2,y-h/2, wZoom, hZoom); bzoomMenos.display();
}

void visualitzacioCinematica2(float x, float y, float w, float h){
  //RECTANGLE
  pushStyle();
    rectMode(CENTER);
    strokeWeight(3);
    rect(x, y, w, h, 10); 
  popStyle();
    
  //VISUALITZACIÓ EXERCICI
  pushMatrix();
    translate(x, y);
}

boolean objetoInVisualization(Objeto o, float w, float h){
  return (o.displayX<w/2&&o.displayX>-w/2)&&(-o.displayY<h/2&& -o.displayY>-h/2);
}
void eixDeCoordenadesCart(float w, float h, float separacioLineasX, float separacioLineasY){
    //cuadrícula:
    strokeWeight(1); stroke(200);
      //Verticals
      for(float xL=-w/2 + separacioLineasX; xL<w/2; xL+=separacioLineasX){
        line(xL, -h/2, xL, h/2);
      }
      //Horitzontals
      for(float yL=-h/2 + separacioLineasY; yL<h/2; yL+=separacioLineasY){
        line(-w/2, yL, w/2, yL);
      }
      
    //Eixos principals
      //X y Y
      strokeWeight(3); stroke(0);
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
}
