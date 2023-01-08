float scaleEjercicio = 0;


void dibujarRectangulo(float x, float y, float w, float h){
  pushStyle();
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
  dibujarRectangulo(x, y, w, h);
    
  //VISUALITZACIÓ EXERCICI
  pushMatrix();
    translate(x, y);
    //Dibujar el precipicio
    float precipicioX = -w/2+300;
    float precipicioXSacled = precipicioX*(1+ scaleEjercicio);
    float floor = h/2-100;
    strokeWeight(5);
    if(scaleEjercicio>1){
      line(-w/2, floor, w/2, floor);
    }else{
    line(-w/2, 0,precipicioXSacled ,0);
    line(precipicioXSacled,0, precipicioXSacled, floor);
    line(precipicioXSacled, floor, w/2, floor);
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
  bDerecha.setMides(x+w/2-wZoom*2, y-h/2, wZoom, hZoom); bDerecha.display();
  bIzquierda.setMides(x+w/2-wZoom*3,y-h/2, wZoom, hZoom); bIzquierda.display();
}

void visualitzacioDinamica1(float x, float y, float w, float h){
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
    //Monigote NO MOSTRAR FINS QUE SE POSA SA FORÇA
    monigote.resize(130, 200);
    imageMode(CENTER);
    image(monigote, -67, 98);
  popStyle();
  popMatrix();
}

void visualitzacioDinamica2(float x, float y, float w, float h){
  float floor = h/2-100;
  float xEmpiezaTriangulo= -170; 
  float xAcabaTriangulo = -xEmpiezaTriangulo;
  //RECTANGLE
  dibujarRectangulo(x, y, w, h);
 
  pushMatrix();
  pushStyle();
    strokeWeight(5);
    translate(x, y);
    //Floor
    line(-w/2, floor, xEmpiezaTriangulo, floor);
    for(float xL = xEmpiezaTriangulo+ 20; xL<xAcabaTriangulo; xL+=40){
      line(xL, floor, xL+20, floor);
    }
    line(xAcabaTriangulo, floor, w/2, floor);
    //Triangle
    line(xEmpiezaTriangulo, floor, xAcabaTriangulo, floor-300);
    line(xAcabaTriangulo, floor-300, xAcabaTriangulo, floor);
    //Polea
    line(xAcabaTriangulo, floor-300, xAcabaTriangulo+ 30, floor-300- 30);
    circle(xAcabaTriangulo+ 30, floor-300- 30, 50);
    
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
    image(ojo, -w/3, h/3-2);
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
    //Planeta
    fill(paleta[0]);
    circle(0, -h/2+100, 125);
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
    noFill();stroke(1);strokeWeight(2);
    ellipse(0, 0, 750, 450);
    //Planeta
    fill(paleta[0]); noStroke();
    circle(375, 0, 75);
    circle(-375, 0, 75);
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
    Particules p = new Particules("a", 1, "b", 1);
    p.display(w);
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
    //Damos valores para la fletxa
    float xF = -w/3+20; float y1F = h/5-20; float y2F = -h/5+20;
    
    Fletxa f = new Fletxa(xF, y1F, xF, y2F);
    for(float x0 = xF; x0<w/3+40; x0+=50.9){     
      f.display(paleta[4]);
      f.changePoints(x0, y1F, x0, y2F);
    }
    Particula p = new Particula("a", 2); noStroke();
    p.display();
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
    //Fletxas orientadas según la corriente
    Fletxa f = new Fletxa(w/5, 100, w/5, -100);
    f.display(paleta[4]);
    f.changePoints(-w/5, 100, -w/5, -100);
    f.display(paleta[4]);
    
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
    Particula p = new Particula("a", 2);
    p.display();
    //Dibuja Espira
    noFill();stroke(3);
    arc(0, 0, 400, 400, -6*PI/7, 6*PI/7);
    line(-w/2+100, 200*sin(-6*PI/7), 200*cos(-6*PI/7), 200*sin(-6*PI/7));
    line(-w/2+100, -200*sin(-6*PI/7), 200*cos(-6*PI/7), -200*sin(-6*PI/7));
    //Sentido
    Fletxa f = new Fletxa(-w/2+110, 200*sin(-6*PI/7),-w/2+260, 200*sin(-6*PI/7));
    f.display(paleta[4]);
    f.changePoints(-w/2+260, -200*sin(-6*PI/7), -w/2+110, -200*sin(-6*PI/7));
    f.display(paleta[4]);
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
