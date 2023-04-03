//CINEMATICA
void exportarRC1() {
  pdfRC1.beginDraw();
  pushStyle();
  pdfRC1.fill(255); 
  pdfRC1.noStroke();
  float x = width/6; 
  float y = 0;
  float w = 2*width/3; 
  float h = height;
  pdfRC1.rect(width/6, 0, 2*width/3, height);
  pdfRC1.fill(0);
  pdfRC1.textSize(midaTitol-5); 
  pdfRC1.fill(0); 
  pdfRC1.textAlign(CENTER);
  pdfRC1.text("Explicación choque entre cuerpos", width/2, marginV+25);//titol
  pdfRC1.fill(200); 
  pdfRC1.noStroke();
  pdfRC1.rect(x+ 30 -10, y+marginV+55-10, w-50, 190, 10);
  pdfRC1.textSize(midaSubtitol-2); 
  pdfRC1.textAlign(TOP, LEFT); 
  pdfRC1.fill(0);
  if (objetos>1) {
    pdfRC1.text("Enunciado: Dos mobiles, uno situado en la coordenada ("+m0.p.x+", "+m0.p.y+") de un eje de cordenadas cartegianas y otro situado en ("+m1.p.x+", "+m1.p.y+") se mueven en un MRU (que empieza en t=0s) en dirección de chocar. Si la velocidad del primero es "+m0.vel+"m/s y la del segundo es "+m1.vel+",m/s ¿cuándo chocarán?", x+ 30, y+marginV+55, w-60, h-10);
  } else {
    pdfRC1.text("Enunciado: Dos mobiles, uno situado en la coordenada (X1, Y1) de un eje de cordenadas cartegianas y otro situado en (X2, Y2) se mueven en un MRU (que empieza en t=0s) en dirección de chocar. Si la velocidad del primero es V1m/s y la del segundo es V2m/2, ¿cuándo chocarán?", x+ 30, y+marginV+55, w-60, h-10);
  }
  //Escrito de resolución
  pdfRC1.textSize(midaSubtitol-8);
  pdfRC1.text("En primer lugar, se halla la distancia entre los dos móbiles usando el teorema de pitágoras:", x+ 30, y+marginV+55+200, w-50, h-10);
  //Pitagoras:
  pit1.resize(240, 240); 
  pit2.resize(500, 150);
  float xBorde = x+30;
  float yImg1 = y+marginV+55+200 + 100;
  pdfRC1.image(pit1, xBorde, yImg1); 
  float x1F1 = xBorde + 240; 
  float x2F1 =x1F1 + 60;
  float yF = yImg1 + 240/2;
  f.changePoints(x1F1, yF, x2F1, yF); 
  f.display(0);
  float xDist = x2F1 + 10;
  pdfRC1.textAlign(LEFT, CENTER); 
  pdfRC1.textSize(midaParagraf);
  pdfRC1.text("Dist = sqrt((Dx)^2 + (Dy)^2   \nDist = sqrt((X2-X1)^2 + (Y2-Y1)^2)", xDist, yF);
  float xImg2 = xDist+ 400;
  pdfRC1.image(pit2, xImg2, y+marginV+55+200 + 100 + 45);

  pdfRC1.textAlign(LEFT, TOP); 
  pdfRC1.textSize(midaSubtitol-8); 
  float yText = yF + 240/2; 
  pdfRC1.fill(0);
  pdfRC1.text("Que los coches choquen significa que su posición es la misma; por lo tanto, igualamos sus ecuaciones de movimiento:", x+ 30, yText, w-50, h-10);
  //Igualación de Ecuaciones:
  pdfRC1.textAlign(CENTER, TOP); 
  pdfRC1.textSize(midaParagraf+4);
  float xExpr = x+w/2-400; 
  float yExpr = yText + 60;
  pdfRC1.text("p1 =p2   \np01+v1*t = p02+v2*t   \n0+v1*t = dist+v2*t \nen modulo: v1*t = dist -v2*t \nt = (dist)/(v1+v2)    \nt = (sqrt((X2-X1)^2 + (Y2-Y1)^2))/(v1+v2)", xExpr, yExpr, 800, 600);

  //Substitución:
  if (objetos>1) {
    pdfRC1.textAlign(LEFT, TOP); 
    pdfRC1.textSize(midaSubtitol-8);
    float ySub = yExpr + 180;
    pdfRC1.text("Entonces, substituimos en la ecuación:", xBorde, ySub);
    float yRes = ySub+40;
    float Resp = calcularEjercicioC1();
    pdfRC1.text("t = (sqrt(("+m1.p.x+"-"+m0.p.x+")^2 + ("+m1.p.y+"-"+m0.p.y+"^2))/("+m0.vel+"+"+m1.vel+") = "+Resp, xExpr, yRes, w, 600);
    pdfRC1.text("SOLUCIÓN: Se chocarán cuando hayan passado "+Resp+"s", xBorde, ySub+100);
  }
  pdfRC1.dispose();
  pdfRC1.endDraw();
}
void exportarEC1() {
  pdfEC1.beginDraw();
    pushStyle();
    pdfEC1.fill(255); 
    pdfRC1.noStroke();
    float x = width/6; 
    float y = 0;
    float w = 2*width/3; 
    float h = height;
    pdfEC1.rect(width/6, 0, 2*width/3, height);
    pdfEC1.fill(0);
    pdfEC1.textSize(midaTitol-5); 
    pdfEC1.fill(0); 
    pdfEC1.textAlign(CENTER);
    pdfEC1.text("Explicación choque entre cuerpos", width/2, marginV+25);//titol
    pdfEC1.fill(200); 
    pdfRC1.noStroke();
    pdfEC1.rect(x+ 30 -10, y+marginV+55-10, w-50, 190, 10);
    pdfEC1.textSize(midaSubtitol-2); 
    pdfEC1.textAlign(TOP, LEFT); 
    pdfEC1.fill(0);
    if (objetos>1) {
      pdfEC1.text("Enunciado: Dos mobiles, uno situado en la coordenada ("+m0.p.x+", "+m0.p.y+") de un eje de cordenadas cartegianas y otro situado en ("+m1.p.x+", "+m1.p.y+") se mueven en un MRU (que empieza en t=0s) en dirección de chocar. Si la velocidad del primero es "+m0.vel+"m/s y la del segundo es "+m1.vel+",m/s ¿cuándo chocarán?", x+ 30, y+marginV+55, w-60, h-10);
    } else {
      pdfEC1.text("Enunciado: Dos mobiles, uno situado en la coordenada (X1, Y1) de un eje de cordenadas cartegianas y otro situado en (X2, Y2) se mueven en un MRU (que empieza en t=0s) en dirección de chocar. Si la velocidad del primero es V1m/s y la del segundo es V2m/2, ¿cuándo chocarán?", x+ 30, y+marginV+55, w-60, h-10);
    }
  pdfEC1.dispose();
  pdfEC1.endDraw();
}

void exportarRC2(){
  pdfRC2.beginDraw();
    float x = width/6; 
    float y = 0;
    float w = 2*width/3; 
    float h = height;
    pdfRC2.rect(width/6, 0, 2*width/3, height);
    pdfRC2.textSize(midaTitol-5); pdfRC2.fill(0); pdfRC2.textAlign(CENTER);
    pdfRC2.text("Explicación tiro parabólico", width/2, marginV+25);//titol
    pdfRC2.fill(200); pdfRC2.noStroke();
    pdfRC2.rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
    pdfRC2.textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
    //Pregunta
    if(objetos == 0){
      pdfRC2.text("Si un mobil se situa en un precipicio cuya altura es H y se lanza a una velocidad V en un ángulo A respeto a la horizontal; ¿a cuantos metros del precicpicio xocará contra el suelo?", x+ 30, y+marginV+55, w-60, h-10);
    }else if(objetos >0){
      pdfRC2.text("Si un mobil se situa en un precipicio cuya altura es "+m0.altura+" y se lanza a una velocidad "+m0.vel+" en un ángulo "+m0.angulo+" respeto a la horizontal; ¿a cuantos metros del precicpicio xocará contra el suelo?", x+ 30, y+marginV+55, w-60, h-10);
    }
    //Explicación:
    pdfRC2.textSize(midaSubtitol-8);
    float Y1 = y+marginV+55+200;
    pdfRC2.text("En primer lugar, se halla el tiempo en que el objeto tocará el suelo. Para esto, se utiliza la fórmula de MRUA:", x+ 30,Y1, w-50, h-10);
    float Y2 = Y1 + 100;
    pdfRC2.textSize(midaParagraf);
    pdfRC2.text("0 = h + Vy*t +(g*t^2)/2", w/2 + 125, Y2, w-50, h-10);
    pdfRC2.textSize(midaSubtitol-8);
    float Y3 = Y2 + 50;
    pdfRC2.text("Entonces, según la ecuación de segundo grado, se calcula el tiempo:", x+ 30, Y3, w-50, h-10);
    float Y4 = Y3 + 50;
    pdfRC2.textSize(midaParagraf);
    pdfRC2.text("t = [ -(Vy) +sqrt[(Vy)^2 +4*h*4.9] ]/(-9.81)", w/2, Y4, w-50, h-10);
    pdfRC2.textSize(midaSubtitol-8);
    float Y5 = Y4 + 50;
    pdfRC2.text("Este es el tiempo que se debe introducir en la ecuación del MRU horizonal del móbil para calcular a qué distancia xocará con el suelo. La ecuación resultante es la siguiente: ", x+ 30, Y5, w-50, h-10);
    pdfRC2.textSize(midaParagraf);
    float Y6 = Y5 + 100;
    pdfRC2.text("X = Vx * t", w/2 + 200, Y6, w-50, h-10);
    float Y7 = Y6 + 50;
    pdfRC2.text("X = Vx * [ -(Vy) +sqrt[(Vy)^2 +4*h*4.9] ]/(-9.81)", w/2, Y7, w-50, h-10);
    pdfRC2.textSize(midaSubtitol-8);
    float Y8 = Y7 + 50;
    pdfRC2.text("Las componentes Y y X de la velocidad se conseguirán multiplicando la velocidad por el sinus y el cosinus respectivamente.", x+ 30, Y8, w-50, h-10);
    pdfRC2.textSize(midaParagraf);float Y9 = Y8 + 100;
    pdfRC2.text("Vx = V*cos(A)     Vy = v*sin(A)", w/2, Y9, w-50, h-10);
    float Y10 = Y9 + 50;
    pdfRC2.textSize(midaSubtitol-8);
    pdfRC2.text("Entonces:", x+ 30, Y10, w-50, h-10);
    pdfRC2.textSize(midaParagraf);
    pdfRC2.text("X = V*cos(A) * [ -(V*sin(A)) +sqrt[(V*sin(A))^2 +4*h*4.9] ]/(-9.81)", w/2, Y10+2, w-50, h-10);
    float Y11 = Y10 + 50;
    pdfRC2.textSize(midaSubtitol-8);
    pdfRC2.text("Substituimos:", x+ 30, Y11, w-50, h-10);
    if(objetos > 0){
      pdfRC2.textSize(midaParagraf);
      float Resp = calcularEjercicioC2();
      pdfRC2.text("X = "+m0.vel+"*cos("+m0.angulo+") * [ -("+m0.vel+"*sin("+m0.angulo+")) +sqrt[("+m0.vel+"*sin("+m0.angulo+"))^2 +4*"+m0.altura+"*4.9] ]/(-9.81) = "+Resp, w/2, Y11+2, w/2+ 350, h-10);
      float Y12 = Y11 + 50;
      pdfRC2.textSize(midaSubtitol-8);
      pdfRC2.text("Solición: Chocará con el suelo a "+Resp+" m del precipicio", x+ 30, Y12, w-50, h-10);
    }
  pdfRC2.dispose();
  pdfRC2.endDraw();
}

void exportarEC2(){
  pdfEC2.beginDraw();
    float x = width/6; 
    float y = 0;
    float w = 2*width/3; 
    float h = height;
    pdfEC2.rect(width/6, 0, 2*width/3, height);
    pdfEC2.textSize(midaTitol-5); pdfEC2.fill(0); pdfEC2.textAlign(CENTER);
    pdfEC2.text("Explicación tiro parabólico", width/2, marginV+25);//titol
    pdfEC2.fill(200); pdfEC2.noStroke();
    pdfEC2.rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
    pdfEC2.textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
    //Pregunta
    if(objetos == 0){
      pdfEC2.text("Si un mobil se situa en un precipicio cuya altura es H y se lanza a una velocidad V en un ángulo A respeto a la horizontal; ¿a cuantos metros del precicpicio xocará contra el suelo?", x+ 30, y+marginV+55, w-60, h-10);
    }else if(objetos >0){
      pdfEC2.text("Si un mobil se situa en un precipicio cuya altura es "+m0.altura+" y se lanza a una velocidad "+m0.vel+" en un ángulo "+m0.angulo+" respeto a la horizontal; ¿a cuantos metros del precicpicio xocará contra el suelo?", x+ 30, y+marginV+55, w-60, h-10);
    }
  
  pdfEC2.dispose();
  pdfEC2.endDraw();
}
//DINAMICA
void exportarRD1(){
  /*pdfRD1.beginDraw();
    textSize(midaTitol-12); fill(0); textAlign(CENTER);
    text("Explicación Polea en plano inclinado", width/2, marginV+25);//titol
    fill(200); noStroke();
    rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
    textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
    //Pregunta
    if(objetos == 0){
      text("Si se considera una polea en un plano inclinado de ángulo Alpha que sujeta dos objetos, y el que está en el plano inclinado tiene una masa de M1 kg, ¿qué masa tiene que tener el segundo objeto para que el sistema esté en equilibrio?", x+ 30, y+marginV+55, w-60, h-10);
    }else if(objetos == 1){
      text("Si se considera una polea en un plano inclinado de ángulo "+c0.angulo+" que sujeta dos objetos, y el que está en el plano inclinado tiene una masa de "+c0.masa+" kg, ¿qué masa tiene que tener el segundo objeto para que el sistema esté en equilibrio?", x+ 30, y+marginV+55, w-60, h-10);
    }
    
    //Explicación:
    textSize(midaSubtitol-8);
    float Y1 = y+marginV+55+200;
    text("La tensión de la cuerda es la misma en toda ella, lo que significa que la fuerza que hacen las cajas sobre ella es igual. La primera caja está apoyada sobre un plano inclinado; por este motivo, la fuerza que ejerce este es la componente x del peso sobre el plano. Por este motivo, se puede afirmar que:", x+ 30,Y1, w-50, h-10);
    float Y2 = Y1 + 150;
    textSize(midaParagraf);
    text(" P1x = P1*sin(A)", w/2 + 150,Y2, w-50, h-10);
    textSize(midaSubtitol-8);
    float Y3 = Y2 + 50;
    text("En relación a la fuerza de la seguna caja, debido a que no está apoyada, es su masa multiplicado por el peso", x+ 30,Y3, w-50, h-10);
    float Y4 = Y3 + 50;
    textSize(midaParagraf);
    text(" P2 = m2* g", w/2 + 150,Y4, w-50, h-10);
    float Y5 = Y4+50;
    textSize(midaSubtitol-8);
    text("Entonces, igualamos las ecuaciones", x+ 30,Y5, w-50, h-10); 
    float Y6 = Y5 + 50;
    textSize(midaParagraf);
    text("P1 * sin(A) = m2* g", w/2 + 150,Y6, w-50, h-10);
    float Y7 = Y6 + 50;
    text("m1* g * sin(A) = m2* g", w/2 + 150,Y7, w-50, h-10);
    float Y8 = Y7 + 50;
    text("m2 = m1 * sin(A)", w/2 + 150,Y8, w-50, h-10);
    float Y9 = Y8+50;
    textSize(midaSubtitol-8);
    text("Finalmente, se substituye:", x+ 30,Y9, w-50, h-10); 
    if(objetos > 0){
      float Resp = calcularEjercicioD1();
      textSize(midaParagraf);
      text("m2 = "+c0.masa+" * sin("+c0.angulo+") = "+ Resp, w/2 + 150,Y9, w-50, h-10);
      float Y10 = Y9 + 50;
      text("Solución: Para que el sistema esté en equilibrio la segunda caja debe tener una masa de "+Resp+"kg", x + 30, Y10, w-30, h);
    }
  pdfRD1.dispose();
  pdfRD1.endDraw();*/
}

void exportarED1(){
  
}

void exportarRD2(){
  pdfRD2.beginDraw();
    float x = width/6; 
    float y = 0;
    float w = 2*width/3; 
    float h = height;
    pdfRD2.textSize(midaTitol-5); 
    pdfRD2.fill(0); 
    pdfRD2.textAlign(CENTER);
    pdfRD2.text("Explicación Cajas Rozantes", width/2, marginV+25);//titol
    pdfRD2.fill(200); 
    pdfRD2.noStroke();
    pdfRD2.rect(x+ 30 -10, y+marginV+55-10, w-50, 190, 10);
    pdfRD2.textSize(midaSubtitol-2);
    pdfRD2.textAlign(TOP, LEFT); 
    pdfRD2.fill(0);
    //Prgunta
    if (objetos == 0) {
      pdfRD2.text("Si a un cuerpo de massa M kg se le aplica una fuerza F N, teniendo en cuenta que entre el cuerpo y el suelo hay un coeficiente de fricción Nu, ¿Se moverá? En caso afirmativo ¿Cual será su acceleración?", x+ 30, y+marginV+55, w-60, h-10);
    } else {
      pdfRD2.text("Si a un cuerpo de massa "+c0.masa+" kg se le aplica una fuerza "+c0.Fuerza+" N, teniendo en cuenta que entre el cuerpo y el suelo hay un coeficiente de fricción "+c0.Nu+", ¿Se moverá? En caso afirmativo ¿Cual será su acceleración?", x+ 30, y+marginV+55, w-60, h-10);
    }
    //Explicación:
    pdfRD2.textSize(midaSubtitol-8);
    float Y1 = y+marginV+55+200;
    pdfRD2.text("Para que el cuerpo se mueva, la fuerza aplicada debe ser superior a la fuerza de resistencia; es decir, la fuerza de fricción. Es por esto que se tiene que aplicar la segunda ley Newton.\nEsta dice que el sumatorio de las ferzas da como resultado la masa del cuerpo multiplicado por su acceleración. En este caso, la ecuación sería así:", x+ 30, Y1, w-50, h-10);
    pdfRD2.textSize(midaParagraf);
    float Y2 = Y1+150;
    pdfRD2.text(" F - Ff = m * a", w/2 + 150, Y2, w-50, h-10);
    float Y3 = Y2 + 50;
    pdfRD2.textSize(midaSubtitol-8);
    pdfRD2.text("En este problema, ya que se consideran los módulos, la acceleración puede ser negativa. Que sea negativa significa que el objeto no se moverá, en cambio, si la acceleración es positiva, se moverá.", x+ 30, Y3, w-50, h-10);
    float Y4 = Y3 + 100;
    pdfRD2.text("La fuerza de fricción se calcula multiplicando la normal, que es el peso de la caja con el coeficiente de fricción. Es decir:", x+ 30, Y4, w-50, h-10); 
    pdfRD2.textSize(midaParagraf);
    float Y5 = Y4+70;
    pdfRD2.text("Ff = m*g * nu", w/2 + 150, Y5, w-50, h-10);
    pdfRD2.textSize(midaSubtitol-8);
    float Y6 = Y5 + 50;
    pdfRD2.text("Entonces, la acceleración se puede calcular a partir de la siguiente ecuación:", x+ 30, Y6, w-50, h-10); 
    pdfRD2.textSize(midaParagraf);
    float Y7 = Y6+50;
    pdfRD2.text("a = (F-m*g*nu)/m", w/2 + 150, Y7, w-50, h-10);
    pdfRD2.textSize(midaSubtitol-8);
    float Y8 = Y7 + 50;
    pdfRD2.text("A continación, se substituyen los valores:", x+ 30, Y8, w-50, h-10); 
  
    float Y9 = Y8+50;
    if (objetos > 0) {
      pdfRD2.textSize(midaParagraf);
      float Resp = calcularEjercicioD2();
      pdfRD2.text("a = ("+c0.Fuerza+"-"+c0.masa+"*9.81*"+c0.Nu+")/"+c0.masa+" = "+ Resp, w/2 + 150, Y9, w-50, h-10);
      float Y10 = Y9 + 50;
      pdfRD2.textSize(midaSubtitol-8);
      if (Resp > 0) {
        pdfRD2.text("Solución: Se moverá; concretamente a "+Resp+"m/(s^2)", x+30, Y10, w-30, h);
      } else {
        pdfRD2.text("Solución: No se moverá", x+30, Y10, w-30, h);
      }
    }
  pdfRD2.dispose();
  pdfRD2.endDraw();
}

void exportarED2(){
  pdfED2.beginDraw();
    float x = width/6; 
    float y = 0;
    float w = 2*width/3; 
    float h = height;
    pdfED2.textSize(midaTitol-5); 
    pdfED2.fill(0); 
    pdfED2.textAlign(CENTER);
    pdfED2.text("Explicación Cajas Rozantes", width/2, marginV+25);//titol
    pdfED2.fill(200); 
    pdfED2.noStroke();
    pdfED2.rect(x+ 30 -10, y+marginV+55-10, w-50, 190, 10);
    pdfED2.textSize(midaSubtitol-2);
    pdfED2.textAlign(TOP, LEFT); 
    pdfED2.fill(0);
    //Pregunta
    if (objetos == 0) {
      pdfED2.text("Si a un cuerpo de massa M kg se le aplica una fuerza F N, teniendo en cuenta que entre el cuerpo y el suelo hay un coeficiente de fricción Nu, ¿Se moverá? En caso afirmativo ¿Cual será su acceleración?", x+ 30, y+marginV+55, w-60, h-10);
    } else{
      pdfED2.text("Si a un cuerpo de massa "+c0.masa+" kg se le aplica una fuerza "+c0.Fuerza+" N, teniendo en cuenta que entre el cuerpo y el suelo hay un coeficiente de fricción "+c0.Nu+", ¿Se moverá? En caso afirmativo ¿Cual será su acceleración?", x+ 30, y+marginV+55, w-60, h-10);
    }
  pdfED2.dispose();
  pdfED2.endDraw();
}
