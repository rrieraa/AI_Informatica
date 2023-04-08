float scaleEjercicio = 0;


void dibujarRectangulo(float x, float y, float w, float h){
  pushStyle();
  fill(255);
    rectMode(CENTER);
    strokeWeight(3);
    rect(x, y, w, h, 10); 
  popStyle();
}
void visualitzacioCinematica1(float x, float y, float w, float h){
  //RECTANGLE
  dibujarRectangulo(x, y, w, h);
    
  //VISUALITZACIÓ EXERCICI
  pushMatrix();
    translate(x, y);
    float separacioLineasX = ((w/2)/(20+scaleEjercicio));
    float separacioLineasY = ((h/2)/(15+scaleEjercicio));
    eixDeCoordenadesCart(w, h, separacioLineasX, separacioLineasY);
    if(objetos == 1){
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
  bzoomMas.setMides(x+w/2-wZoom*2, y-h/2, wZoom, hZoom); bzoomMas.displayTransparencia(150);
  bzoomMenos.setMides(x+w/2-wZoom*1,y-h/2, wZoom, hZoom); bzoomMenos.displayTransparencia(150);
}

float precipicioXSacled;
float precipicioX;
float floor;
void visualitzacioCinematica2(float x, float y, float w, float h){
  //RECTANGLE
  dibujarRectangulo(x, y, w, h);
    
  //VISUALITZACIÓ EXERCICI
  pushMatrix();
    translate(x, y);
    //Dibujar el precipicio
    precipicioX = -w/2+300;
    precipicioXSacled = precipicioX*(1+ scaleEjercicio);
    floor = h/2-100;
    strokeWeight(5);
    if(scaleEjercicio>1){
      line(-w/2, floor, w/2, floor);
    }else{
    line(-w/2, 0,precipicioXSacled ,0);
    line(precipicioXSacled,0, precipicioXSacled, floor);
    line(precipicioXSacled, floor, w/2, floor);
    }
    //Dibujar altura
    strokeWeight(2);
    if(scaleEjercicio<=1){
      line(precipicioXSacled-20, 0, precipicioXSacled-20, floor);
      line(precipicioXSacled, floor, precipicioXSacled-30, floor);
    }
    
    
    //Dibujar las líneas del suelo 
    strokeWeight(2);
    float separacioLineas = 80; int metros =0;
    for(float xL=precipicioXSacled; xL<w/2; xL+=separacioLineas){
      if(xL>-w/2){
        line(xL, floor, xL, floor+8);
        textSize(10);textAlign(CENTER);fill(0);
        text(metros, xL, floor+ 24);
      }
      metros+=20;
    }
    
  popMatrix();
  if(scaleEjercicio!=0){
    bIzquierda.setMides(x+w/2-wZoom*2,y-h/2, wZoom, hZoom); bIzquierda.displayTransparencia(150);
  }
  bDerecha.setMides(x+w/2-wZoom*1, y-h/2, wZoom, hZoom); bDerecha.displayTransparencia(150);
  
  
  //Dibujar mobil
  checkLimit();
  if(objetos==objetoLimite){
    m0.display(m0.p.x, m0.p.y);
    pushMatrix();
      translate(xVisualitzacio, yVisualitzacio);
      float xF = (m0.p.x+ m0.vel*cos(radians(m0.angulo)));
      float yF = (m0.p.y+ m0.vel*sin(radians(-m0.angulo)));
      Fletxa f = new Fletxa();
      f.changePoints(m0.p.x, m0.p.y, xF, yF); f.display(0);
    popMatrix();
  }
}

  float floorD1;
  float xEmpiezaTriangulo; 
  float xAcabaTriangulo;
void visualitzacioDinamica1(float x, float y, float w, float h){
  floorD1 = h/2-100;
  xEmpiezaTriangulo= -170; 
  xAcabaTriangulo = -xEmpiezaTriangulo;
  //RECTANGLE
  dibujarRectangulo(x, y, w, h);
 
  pushMatrix();
  pushStyle();
    strokeWeight(5);
    translate(x, y);
    //Floor
    line(-w/2, floorD1, xEmpiezaTriangulo, floorD1);
    for(float xL = xEmpiezaTriangulo+ 20; xL<xAcabaTriangulo; xL+=40){
      line(xL, floorD1, xL+20, floorD1);
    }
    line(xAcabaTriangulo, floorD1, w/2, floorD1);
    //Triangle
    line(xEmpiezaTriangulo, floorD1, xAcabaTriangulo, floorD1-300);
    line(xAcabaTriangulo, floorD1-300, xAcabaTriangulo, floorD1);
    //Polea
    line(xAcabaTriangulo, floorD1-300, xAcabaTriangulo+ 30, floorD1-300- 30);
    circle(xAcabaTriangulo+ 30, floorD1-300- 30, 50);
    checkLimit();
    if(objetos == objetoLimite){
      c0.display();
    }
  popStyle();
  popMatrix(); 
}

void visualitzacioDinamica2(float x, float y, float w, float h){
  float floor = h/2-100;
  //RECTANGLE
  dibujarRectangulo(x, y, w, h);
  
  pushMatrix();
  pushStyle();
    strokeWeight(5);
    translate(x, y);
    float xCaja = 100; float wCaja = 200;
    float yCaja = floor-wCaja/2;
    //Floor
    fill(0);
    line(-w/2, floor, w/2, floor);
    //Caja
    rectMode(CENTER);
    fill(paleta[0]);
    rect(xCaja, yCaja, wCaja, wCaja);
    checkLimit();
    if(objetos == objetoLimite){
      c0.display();
    }
  popStyle();
  popMatrix();
}

void visualitzacioOptica1(float x, float y, float w, float h){
  //RECTANGLE
  dibujarRectangulo(x, y, w, h);
 
  pushMatrix();
  pushStyle();
    strokeWeight(5);
    translate(x, y);
    //Vidrio
    imageMode(CENTER);
    vidrio.resize(200, (int)h-100);
    image(vidrio, w/3, 0);
    //Ojo
    ojo.resize(200, 200);
    image(ojo, -w/3+20, h/4+50);
    //Display
    checkLimit();
    if(objetos == objetoLimite){
      l.display();
    } 
  popStyle();
  popMatrix(); 
}

void visualitzacioOptica2(float x, float y, float w, float h){
  //RECTANGLE
  dibujarRectangulo(x, y, w, h);
  pushMatrix();
  pushStyle();
    strokeWeight(5);
    translate(x, y);
    //Vidrio
    imageMode(CENTER);
    vidrio.resize(200, (int)h-100);
    image(vidrio, 0, 0);
    
    checkLimit();
    if(objetos == objetoLimite){
      l.display();
    } 
  popStyle();
  popMatrix(); 
}

void visualitzacioGravitatori1(float x, float y, float w, float h){
  //RECTANGLE
  dibujarRectangulo(x, y, w, h);
  pushMatrix();
  pushStyle();
    strokeWeight(5);
    translate(x, y);
    //Sol
    noStroke();fill(paleta[1]);
    arc(0, h/2+99, 400, 400, -PI/1.2, -PI/6, OPEN);
    
    //Display
    checkLimit();
    if(objetos == objetoLimite){
      CG.display();
    }
    
  popStyle();
  popMatrix(); 
}

void visualitzacioGravitatori2(float x, float y, float w, float h){
  //RECTANGLE
  dibujarRectangulo(x, y, w, h);
  pushMatrix();
  pushStyle();
    strokeWeight(5);
    translate(x, y);
    //Sol
    noStroke();fill(paleta[1]);
    circle(0, 0, 200);
    
    checkLimit();
    if(objetos == objetoLimite){
      CG.display();
    }
  popStyle();
  popMatrix(); 
}  

void visualitzacioElectric1(float x, float y, float w, float h){
  //RECTANGLE
  dibujarRectangulo(x, y, w, h);
  pushMatrix();
  pushStyle();
    strokeWeight(5);
    translate(x, y);
    checkLimit();
    if(objetos == objetoLimite){
      P.display();
    }
    
  popStyle();
  popMatrix(); 
}

void visualitzacioElectric2(float x, float y, float w, float h){
  //RECTANGLE
  dibujarRectangulo(x, y, w, h);
  pushMatrix();
  pushStyle();
    strokeWeight(5);
    translate(x, y);
    line(-w/3, h/5, w/3, h/5);
    line(-w/3, -h/5, w/3, -h/5);
    
    checkLimit();
    if(objetos == objetoLimite){
      P.display();
    }
    
  popStyle();
  popMatrix(); 
}

void visualitzacioMagnetic1(float x, float y, float w, float h){
  //RECTANGLE
  dibujarRectangulo(x, y, w, h);
  pushMatrix();
  pushStyle();
    strokeWeight(5);
    translate(x, y);
    line(w/5, h/2, w/5, -h/2);
    line(-w/5, h/2, -w/5, -h/2);
    
    checkLimit();
    if(objetos==objetoLimite){
      CM.display();
    }
  popStyle();
  popMatrix(); 
}    

void visualitzacioMagnetic2(float x, float y, float w, float h){
  //RECTANGLE
  dibujarRectangulo(x, y, w, h);
  pushMatrix();
  pushStyle();
    strokeWeight(5);
    translate(x, y);
    fill(0);
    circle(0, 0, 4);
    //Dibuja Espira
    noFill();stroke(3);
    arc(0, 0, 400, 400, -6*PI/7, 6*PI/7);
    line(-w/2+100, 200*sin(-6*PI/7), 200*cos(-6*PI/7), 200*sin(-6*PI/7));
    line(-w/2+100, -200*sin(-6*PI/7), 200*cos(-6*PI/7), -200*sin(-6*PI/7));
    checkLimit();
    if(objetos==objetoLimite){
      CM.display();
    }
  popStyle();
  popMatrix(); 
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
