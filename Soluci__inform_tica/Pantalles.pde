enum PANTALLA {INICI, SELECCIO, EXERCICI, FORMULARI, EXPLICACION};
PANTALLA Pantalla = PANTALLA.INICI;
PANTALLA PantallaPrevia = PANTALLA.INICI;
enum TEMA {CINEMATICA, DINAMICA, OPTICA, GRAVITATORI, MEGNETIC, ELECTRIC};
TEMA tema; int exercici; 
enum ESTADO {EJERCICIO, ANADIR, EXPORTAR};
ESTADO currentState = ESTADO.EJERCICIO;
int objetos = 0; int objetoLimite; boolean canAdd= true;

void seleccionaPantalla(PANTALLA p){
  if(p==PANTALLA.INICI){
    pantallaInicial();
  }else if(p==PANTALLA.SELECCIO){
    pantallaSeleccio(tema);
  }else if(p==PANTALLA.EXERCICI){
    pantallaExercicis(tema, exercici);
  }else if(p==PANTALLA.FORMULARI){
    pantallaFormulari(tema);
  }else if(p==PANTALLA.EXPLICACION){
    pantallaExplicacion(tema, exercici);
  }
  if(p!=PANTALLA.INICI){
    bAtras.setMides(marginV, marginH-40, 150, 75);
    bAtras.display();
  }
}


void pantallaInicial(){
  //Dibujar Cards
  for(int i = 0; i<cards.length+0; i++){
    if(i<cards.length/2){
       cards[i].display((1+2*i)*(width)/6-200, marginV+35);
    }else{
       cards[i].display((-5+2*i)*(width)/6-200, (height/2)+10);
    }
  }
   bApp.setMides((1)*(width)/6-200, height -125, wCard, 80);
   bApp.display();
   bFAQs.setMides((3)*(width)/6-200, height -125, wCard, 80);
   bFAQs.display();
   bProponer.setMides((5)*(width)/6-200, height -125, wCard, 80);
   bProponer.display();
}

void pantallaSeleccio(TEMA tema){
  pushStyle();
    if(tema == TEMA.CINEMATICA){
      textSize(midaTitol); fill(0);
    text("Cinemática", width/2, marginV+100);//titol
      //Exercicis
        bC1.setMides((width/2)-650, 250, 500, 750); bC1.DisplayWithImage(ejercicios[0], 255);
        bC2.setMides(width/2+150, 250, 500, 750); bC2.DisplayWithImage(ejercicios[1], 255);
    }else if(tema == TEMA.DINAMICA){
      //Exercicis
        bD1.setMides((width/2)-650, 250, 500, 750); bD1.DisplayWithImage(ejercicios[2], 255);
        bD2.setMides(width/2+150, 250, 500, 750); bD2.DisplayWithImage(ejercicios[3], 255);
        textSize(midaTitol); fill(0);
    text("Dinámica", width/2, marginV+100);//titol
    }else if(tema == TEMA.OPTICA){
      //Exercicis
        bO1.setMides((width/2)-650, 250, 500, 750); bO1.DisplayWithImage(ejercicios[4], 255);
        bO2.setMides(width/2+150, 250, 500, 750); bO2.DisplayWithImage(ejercicios[5], 255);
        textSize(midaTitol); fill(0);
    text("Óptica", width/2, marginV+100);//titol
    }else if(tema == TEMA.GRAVITATORI){
      //Exercicis
        bG1.setMides((width/2)-650, 250, 500, 750); bG1.DisplayWithImage(ejercicios[6], 255);
        bG2.setMides(width/2+150, 250, 500, 750); bG2.DisplayWithImage(ejercicios[7], 255);
        textSize(midaTitol); fill(0);
    text("Gravitatorio", width/2, marginV+100);//titol
    }else if(tema == TEMA.ELECTRIC){
      //Exercicis
        bE1.setMides((width/2)-650, 250, 500, 750); bE1.DisplayWithImage(ejercicios[8], 255);
        bE2.setMides(width/2+150, 250, 500, 750); bE2.DisplayWithImage(ejercicios[9], 255);
        textSize(midaTitol); fill(0);
    text("Eléctrico", width/2, marginV+100);//titol
    }else if(tema == TEMA.MEGNETIC){
      //Exercicis
        bM1.setMides((width/2)-650, 250, 500, 750); bM1.DisplayWithImage(ejercicios[10], 255);
        bM2.setMides(width/2+150, 250, 500, 750); bM2.DisplayWithImage(ejercicios[11], 255);
        textSize(midaTitol); fill(0);
    text("Magnético", width/2, marginV+100);//titol
    }
  popStyle();
}

void pantallaFormulari(TEMA tema){
  pushStyle();fill(0);
  float x1 = width/6;
  float w1 = width/2;
    textSize(midaTitol);
    if(tema == TEMA.CINEMATICA){
      float y = height/6+85;
      float h = 4*height/6;
      text("Formulario Cinemática", width/2, 175);
      tCfor.display(x1, y, w1, h);
      fC.display(x1 + w1 + 100, y, 350, h);
    }else if(tema == TEMA.DINAMICA){
      float y = height/6+85;
      float h = 4*height/6;
      text("Formulario Dinámica", width/2, 175);
      tDfor.display(x1, y, w1, h);
      fD.display(x1 + w1 + 100, y, 350, h);
    }else if(tema == TEMA.OPTICA){
      float y = height/6+85;
      float h = 4*height/6;
      text("Formulario Óptica", width/2, 175);
      tOfor.display(x1, y, w1, h);
      fO.display(x1 + w1 + 100, y, 350, h);
    }else if(tema == TEMA.GRAVITATORI){
      float y = height/6+85;
      float h = 4*height/6;
      text("Formulario Gravitatorio", width/2, 175);
      tGfor.display(x1, y, w1, h);
      fG.display(x1 + w1 + 100, y, 350, h);
    }else if(tema == TEMA.ELECTRIC){
      float y = height/6+85;
      float h = 4*height/6;
      text("Formulario Eléctrico", width/2, 175);
      tEfor.display(x1, y, w1, h);
      fE.display(x1 + w1 + 100, y, 350, h);
    }else if(tema == TEMA.MEGNETIC){
      float y = height/6+85;
      float h = 4*height/6;
      text("Formulario Magnético", width/2, 175);
      tMfor.display(x1, y, w1, h);
      fM.display(x1 + w1 + 100, y, 350, h);
    }
  popStyle();  
}

Fletxa f = new Fletxa();
void pantallaExplicacion(TEMA tema, int ejercicio){
  pushStyle();
    fill(255); noStroke();
    float x = width/6; float y = 0;
    float w = 2*width/3; float h = height;
    rect(width/6, 0, 2*width/3, height);
    fill(0);
      if(tema == TEMA.CINEMATICA){
        if(ejercicio==1){
          textSize(midaTitol-5); fill(0); textAlign(CENTER);
          text("Explicación choque entre cuerpos", width/2, marginV+25);//titol
          fill(200); noStroke();
          rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
          textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
          if(objetos>1){
            text("Enunciado: Dos mobiles, uno situado en la coordenada ("+m0.p.x+", "+m0.p.y+") de un eje de cordenadas cartegianas y otro situado en ("+m1.p.x+", "+m1.p.y+") se mueven en un MRU (que empieza en t=0s) en dirección de chocar. Si la velocidad del primero es "+m0.vel+"m/s y la del segundo es "+m1.vel+",m/s ¿cuándo chocarán?", x+ 30, y+marginV+55, w-60, h-10);
          }else{
            text("Enunciado: Dos mobiles, uno situado en la coordenada (X1, Y1) de un eje de cordenadas cartegianas y otro situado en (X2, Y2) se mueven en un MRU (que empieza en t=0s) en dirección de chocar. Si la velocidad del primero es V1m/s y la del segundo es V2m/2, ¿cuándo chocarán?", x+ 30, y+marginV+55, w-60, h-10);
          }
          //Escrito de resolución
          textSize(midaSubtitol-8);
          text("En primer lugar, se halla la distancia entre los dos móbiles usando el teorema de pitágoras:", x+ 30, y+marginV+55+200, w-50, h-10);
          //Pitagoras:
            pit1.resize(240, 240); pit2.resize(500, 150);
            float xBorde = x+30;
            float yImg1 = y+marginV+55+200 + 100;
            image(pit1, xBorde, yImg1); 
            float x1F1 = xBorde + 240; float x2F1 =x1F1 + 60;
            float yF = yImg1 + 240/2;
            f.changePoints(x1F1, yF, x2F1, yF);f.display(0);
            float xDist = x2F1 + 10;
            textAlign(LEFT, CENTER); textSize(midaParagraf);
            text("Dist = sqrt((Dx)^2 + (Dy)^2   \nDist = sqrt((X2-X1)^2 + (Y2-Y1)^2)",xDist, yF);
            float xImg2 = xDist+ 400;
            image(pit2, xImg2, y+marginV+55+200 + 100 + 45);
          
          textAlign(LEFT, TOP); textSize(midaSubtitol-8); float yText = yF + 240/2; fill(0);
          text("Que los coches choquen significa que su posición es la misma; por lo tanto, igualamos sus ecuaciones de movimiento:", x+ 30, yText, w-50, h-10);
          //Igualación de Ecuaciones:
          textAlign(CENTER, TOP); textMode(CENTER);textSize(midaParagraf+4);
          float xExpr = x+w/2-400; float yExpr = yText + 60;
          text("p1 =p2   \np01+v1*t = p02+v2*t   \n0+v1*t = dist+v2*t \nen modulo: v1*t = dist -v2*t \nt = (dist)/(v1+v2)    \nt = (sqrt((X2-X1)^2 + (Y2-Y1)^2))/(v1+v2)", xExpr, yExpr, 800, 600);
          textAlign(LEFT, TOP); textSize(midaSubtitol-8);
          float ySub = yExpr + 180;
          text("Entonces, substituimos en la ecuación:", xBorde, ySub);
          //Substitución:
          if(objetos>1){
            
            float yRes = ySub+40;
            float Resp = calcularEjercicioC1();
            text("t = (sqrt(("+m1.p.x+"-"+m0.p.x+")^2 + ("+m1.p.y+"-"+m0.p.y+"^2))/("+m0.vel+"+"+m1.vel+") = "+Resp, xExpr, yRes, w, 600);
            text("SOLUCIÓN: Se chocarán cuando hayan passado "+Resp+"s", xBorde, ySub+100);
          }
          
          
        }else if(ejercicio==2){
          textSize(midaTitol-5); fill(0); textAlign(CENTER);
          text("Explicación tiro parabólico", width/2, marginV+25);//titol
          fill(200); noStroke();
          rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
          textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
          //Pregunta
          if(objetos == 0){
            text("Si un mobil se situa en un precipicio cuya altura es H y se lanza a una velocidad V en un ángulo A respeto a la horizontal; ¿a cuantos metros del precicpicio xocará contra el suelo?", x+ 30, y+marginV+55, w-60, h-10);
          }else if(objetos >0){
            text("Si un mobil se situa en un precipicio cuya altura es "+m0.altura+" y se lanza a una velocidad "+m0.vel+" en un ángulo "+m0.angulo+" respeto a la horizontal; ¿a cuantos metros del precicpicio xocará contra el suelo?", x+ 30, y+marginV+55, w-60, h-10);
          }
          //Explicación:
          textSize(midaSubtitol-8);
          float Y1 = y+marginV+55+200;
          text("En primer lugar, se halla el tiempo en que el objeto tocará el suelo. Para esto, se utiliza la fórmula de MRUA:", x+ 30,Y1, w-50, h-10);
          float Y2 = Y1 + 100;
          textSize(midaParagraf);
          text("0 = h + Vy*t +(g*t^2)/2", w/2 + 125, Y2, w-50, h-10);
          textSize(midaSubtitol-8);
          float Y3 = Y2 + 50;
          text("Entonces, según la ecuación de segundo grado, se calcula el tiempo:", x+ 30, Y3, w-50, h-10);
          float Y4 = Y3 + 50;
          textSize(midaParagraf);
          text("t = [ -(Vy) +sqrt[(Vy)^2 +4*h*4.9] ]/(-9.81)", w/2, Y4, w-50, h-10);
          textSize(midaSubtitol-8);
          float Y5 = Y4 + 50;
          text("Este es el tiempo que se debe introducir en la ecuación del MRU horizonal del móbil para calcular a qué distancia xocará con el suelo. La ecuación resultante es la siguiente: ", x+ 30, Y5, w-50, h-10);
          textSize(midaParagraf);
          float Y6 = Y5 + 100;
          text("X = Vx * t", w/2 + 200, Y6, w-50, h-10);
          float Y7 = Y6 + 50;
          text("X = Vx * [ -(Vy) +sqrt[(Vy)^2 +4*h*4.9] ]/(-9.81)", w/2, Y7, w-50, h-10);
          textSize(midaSubtitol-8);
          float Y8 = Y7 + 50;
          text("Las componentes Y y X de la velocidad se conseguirán multiplicando la velocidad por el sinus y el cosinus respectivamente.", x+ 30, Y8, w-50, h-10);
          textSize(midaParagraf);float Y9 = Y8 + 100;
          text("Vx = V*cos(A)     Vy = v*sin(A)", w/2, Y9, w-50, h-10);
          float Y10 = Y9 + 50;
          textSize(midaSubtitol-8);
          text("Entonces:", x+ 30, Y10, w-50, h-10);
          textSize(midaParagraf);
          text("X = V*cos(A) * [ -(V*sin(A)) +sqrt[(V*sin(A))^2 +4*h*4.9] ]/(-9.81)", w/2, Y10+2, w-50, h-10);
          float Y11 = Y10 + 50;
          textSize(midaSubtitol-8);
          text("Substituimos:", x+ 30, Y11, w-50, h-10);
          if(objetos > 0){
            textSize(midaParagraf);
            float Resp = calcularEjercicioC2();
            text("X = "+m0.vel+"*cos("+m0.angulo+") * [ -("+m0.vel+"*sin("+m0.angulo+")) +sqrt[("+m0.vel+"*sin("+m0.angulo+"))^2 +4*"+m0.altura+"*4.9] ]/(-9.81) = "+Resp, w/2, Y11+2, w/2+ 350, h-10);
            float Y12 = Y11 + 50;
            textSize(midaSubtitol-8);
            text("Solición: Chocará con el suelo a "+Resp+" m del precipicio", x+ 30, Y12, w-50, h-10);
          }
        }
      }else if(tema == TEMA.DINAMICA){
        if(ejercicio==1){
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
        }else if(ejercicio==2){
          textSize(midaTitol-5); fill(0); textAlign(CENTER);
          text("Explicación Cajas Rozantes", width/2, marginV+25);//titol
          fill(200); noStroke();
          rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
          textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
          //Pregunta
          if(objetos == 0){
            text("Si a un cuerpo de massa M kg se le aplica una fuerza F N, teniendo en cuenta que entre el cuerpo y el suelo hay un coeficiente de fricción Nu, ¿Se moverá? En caso afirmativo ¿Cual será su acceleración?",x+ 30, y+marginV+55, w-60, h-10);      
          }else{
            text("Si a un cuerpo de massa "+c0.masa+" kg se le aplica una fuerza "+c0.Fuerza+" N, teniendo en cuenta que entre el cuerpo y el suelo hay un coeficiente de fricción "+c0.Nu+", ¿Se moverá? En caso afirmativo ¿Cual será su acceleración?", x+ 30, y+marginV+55, w-60, h-10);
          }
          //Explicación:
          textSize(midaSubtitol-8);
          float Y1 = y+marginV+55+200;
          text("Para que el cuerpo se mueva, la fuerza aplicada debe ser superior a la fuerza de resistencia; es decir, la fuerza de fricción. Es por esto que se tiene que aplicar la segunda ley Newton.\nEsta dice que el sumatorio de las ferzas da como resultado la masa del cuerpo multiplicado por su acceleración. En este caso, la ecuación sería así:", x+ 30,Y1, w-50, h-10);
          textSize(midaParagraf);
          float Y2 = Y1+150;
          text(" F - Ff = m * a", w/2 + 150,Y2, w-50, h-10);
          float Y3 = Y2 + 50;
          textSize(midaSubtitol-8);
          text("En este problema, ya que se consideran los módulos, la acceleración puede ser negativa. Que sea negativa significa que el objeto no se moverá, en cambio, si la acceleración es positiva, se moverá.", x+ 30,Y3, w-50, h-10);
          float Y4 = Y3 + 100;
          text("La fuerza de fricción se calcula multiplicando la normal, que es el peso de la caja con el coeficiente de fricción. Es decir:", x+ 30,Y4, w-50, h-10); 
          textSize(midaParagraf);
          float Y5 = Y4+70;
          text("Ff = m*g * nu", w/2 + 150,Y5, w-50, h-10);
          textSize(midaSubtitol-8);
          float Y6 = Y5 + 50;
          text("Entonces, la acceleración se puede calcular a partir de la siguiente ecuación:", x+ 30, Y6, w-50, h-10); 
          textSize(midaParagraf);
          float Y7 = Y6+50;
          text("a = (F-m*g*nu)/m", w/2 + 150,Y7, w-50, h-10);
          textSize(midaSubtitol-8);
          float Y8 = Y7 + 50;
          text("A continación, se substituyen los valores:", x+ 30, Y8, w-50, h-10); 
          
          float Y9 = Y8+50;
          if(objetos > 0){
            textSize(midaParagraf);
            float Resp = calcularEjercicioD2();
            text("a = ("+c0.Fuerza+"-"+c0.masa+"*9.81*"+c0.Nu+")/"+c0.masa+" = "+ Resp, w/2 + 150,Y9, w-50, h-10);
            float Y10 = Y9 + 50;
            textSize(midaSubtitol-8);
            if(Resp > 0){
              text("Solución: Se moverá; concretamente a "+Resp+"m/(s^2)", x+30, Y10, w-30, h);
            }else{
              text("Solución: No se moverá", x+30, Y10, w-30, h);
            }
          }
          
        }
      }else if(tema == TEMA.OPTICA){
        if(ejercicio==1){
          textSize(midaTitol-16); fill(0); textAlign(CENTER);
          text("Explicación Espejo", width/2, marginV+25);//titol
          fill(200); noStroke();
          rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
          textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
          //Pregunta
          if(objetos == 0){
            text("Se toma como punto de referencia el ojo de un observador. También se sabe que hay un vidrio a X1 m del ojo y una abeja stiuada a X2 y Y2 m de distáncia,¿en que posición se produce la imagen de la abeja?", x+ 30, y+marginV+55, w-60, h-10);
          }else if(objetos == 1){
            text("Se toma como punto de referencia el ojo de un observador. También se sabe que hay un vidrio a "+l.XObsVi+" m del ojo y una abeja stiuada a "+l.xAbeja+" y "+l.yAbeja+" m de distáncia,¿en que posición se produce la imagen de la abeja?", x+ 30, y+marginV+55, w-60, h-10);
          }
          //Explicación
          textSize(midaSubtitol-8);
          float Y1 = y+marginV+55+200;
          text("Cuando se ve un objeto reflejado en un espejo, se ve como una imagen virtual. Además, se puede afirmar que la distancia entre el objto y el vidrio será la mismo que entre la imagen y el vídrio. Además, su posición Y será también identica. Entonces, se puede afirmar lo siguiente:", x+ 30,Y1, w-50, h-10);
          float Y2 = Y1+125;
          textSize(midaParagraf);
          text("Ax = DXvo + DXva     ;     Ay = DYao", w/2 + 150,Y2, w-50, h-10);
          float Y3 = Y2 + 50;
          textSize(midaSubtitol-8);
          text("Donde DXvo se refiere a la distancia horizontal entre el vidrio y el ojo; DXva, a la distancia horizontal entre el vidrio y la abeja y finalmente, DYao, a la vertical entre la abeja y el ojo. \nEntonces, la posición de la abeja se escribe como A(Ax, Ay). Seguidamente, se debe hacer el módulo de este vector.", x+ 30,Y3, w-50, h-10);
          if(objetos > 0){
            float Y4 = Y3 + 150;
            text("Primero, se substituye:", x+ 30,Y4, w-50, h-10);
            textSize(midaParagraf);
            text("Ax = "+l.XObsVi+" + "+l.xAbeja+"     ;     Ay = "+l.yAbeja+"", w/2+150,Y4, w-50, h-10);
            float Y5 = Y4 + 50;
            textSize(midaSubtitol-8);
            text("Y luego, se calcula el módulo:", x+ 30,Y5, w-50, h-10);
            textSize(midaParagraf);
            float Resp = calcularEjercicioO1();
            text("|A| = sqrt[("+l.XObsVi+" + "+l.xAbeja+")^2 + ("+l.yAbeja+")^2] = "+Resp, w/2+ 150,Y5, w-50, h-10);
            float Y6 = Y5+50;
            textSize(midaSubtitol-8);
            text("Solución: La imagen se formará a "+Resp+"m del observador", x+30, Y6, w-30, h);
          }
          
          
          textSize(midaSubtitol-8);
        }else if(ejercicio==2){
          textSize(midaTitol-16); fill(0); textAlign(CENTER);
          text("Explicación Separación de rayos", width/2, marginV+25);//titol
          fill(200); noStroke();
          rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
          textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
          //Pregunta
          if(objetos == 0){
            text("Si un rayo de luz que se translada por el aire incide en un vidrio formando un ángulo de Aº con la normal y se separa en dos rayos de coeficientes de refracción n1 y n2, ¿cual será la separación angular de los rayos?", x+ 30, y+marginV+55, w-60, h-10);
         }else if(objetos == 1){
            text("Si un rayo de luz que se translada por el aire incide en un vidrio formando un ángulo de "+l.angulo+"º con la normal y se separa en dos rayos de coeficientes de refracción "+l.n1+" y "+l.n2+", ¿cual será la separación angular de los rayos?", x+ 30, y+marginV+55, w-60, h-10);
         }
         textSize(midaSubtitol-8);
         float Y1 = y+marginV+55+200;
         text("Para calcular la separación, se tienen que calcular cada uno de los ángulos y encontrar la diferencia. \nPara esto, se tiene que aplicar la ley de Snell, que dice:", x+ 30,Y1, w-50, h-10);
         float Y2 = Y1 + 100;
         textSize(midaParagraf);
         text("n sin(a) = n' sin(a')", w/2 + 100,Y2, w-50, h-10);
         float Y3 = Y2 + 50;
         textSize(midaSubtitol-8);
         text("Entonces, se tienen que calcular esto para los dos casos.", x+ 30,Y3, w-50, h-10);
         float Y4 = Y3 + 50;
         textSize(midaParagraf);
         text("1* sin(A) = n1' sin(a1)", w/2 + 100,Y4, w-50, h-10);
         float Y5 = Y4 + 50;
         text("a1 = arcsin[(sin(A))/n1]", w/2 + 100,Y5, w-50, h-10);
         float Y6 = Y5 + 50;
         text("1* sin(A) = n2' sin(a2)", w/2 + 100,Y6, w-50, h-10);
         float Y7 = Y6 + 50;
         text("a2 = arcsin[(sin(A))/n2]", w/2 + 100,Y7, w-50, h-10);
         textSize(midaSubtitol-8);
         float Y8 = Y7 + 50;
         text("La sparación, será la resta entre los dos ángulos", x+ 30,Y8, w-50, h-10);
         float Y9 = Y8 +50;
         textSize(midaParagraf);
         text("S = arcsin[(sin(A))/n1]-arcsin[(sin(A))/n2]", w/2 + 100,Y9, w-50, h-10);
         if(objetos > 0){
           textSize(midaSubtitol-8);
           float Y10 = Y9 + 50;
           text("Finalmente, substituimos:", x+ 30,Y10, w-50, h-10);
           textSize(midaParagraf);
           float Resp = calcularEjercicioO2();
           text("S = arcsin[(sin("+l.angulo+"))/"+l.n1+"]-arcsin[(sin("+l.angulo+"))/"+l.n2+"] = "+Resp, w/2 + 100,Y10, w-250, h-10);
           float Y11 = Y10 + 50;
           textSize(midaSubtitol-8);
           text("La separación de los rayos será por "+Resp+"º", x+30, Y11, w-30, h);
         }
        }
      }else if(tema == TEMA.GRAVITATORI){
        if(ejercicio==1){
          textSize(midaTitol-16); fill(0); textAlign(CENTER);
          text("Explicación Atreacción Estrella-Planeta", width/2, marginV+25);//titol
          fill(200); noStroke();
          rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
          textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
          //Pregunta
          if(objetos == 0){
            text("Si un planeta de massa M1 Kg se encuentra a Dist Km de una estrella de massa M2 Kg, ¿cual será la fuerza de atracción entre los dos cuerpos?", x+ 30, y+marginV+55, w-60, h-10);
          }else{
            text("Si un planeta de massa "+CG.m1+"Kg se encuentra a "+CG.distancia+"Km de una estrella de massa "+CG.m2+"Kg, ¿cual será la fuerza de atracción entre los dos cuerpos?", x+ 30, y+marginV+55, w-60, h-10);
          }
          //Explicación:
          textSize(midaSubtitol-8);
          float Y1 = y+marginV+55+200;
          text("La fuerza de atracción entre cuerpoes es debido al campo gravitatorio. De hecho, exsite una fórmula para calcular la fuerza de atracción entre dos cuerpos. Esta es la siguiente:", x+ 30,Y1, w-50, h-10);
          float Y2 = Y1 + 100;
          textSize(midaParagraf);
          text("F = G*(M1*M2)/(r^2)", w/2 + 150,Y2, w-50, h-10);
          textSize(midaSubtitol-8);
          float Y3 = Y2 + 50;
          text("En esta ecuación, G es la constante de gravitación que equivale a 6.67*(10^-11)\nEntonces, lo único que hace falta es substituir.", x+ 30,Y3, w-50, h-10);
          
          if(objetos > 0){
            float Y4 = Y3 + 75;
            float Resp = calcularEjercicioG1();
            textSize(midaParagraf);
            text("F = (6.67*(10^-11))*("+CG.m1+"*"+CG.m2+")/("+CG.distancia+"^2) = "+Resp, w/2-150,Y4, w-50, h-10);
            
            textSize(midaSubtitol-8);
            float Y5 = Y4 + 50;
            text("Solución: La fuerza de atracción entre los cuerpos astonómicos es "+Resp+"N", x+ 30,Y5, w-50, h-10);          
          }
          
        }else if(ejercicio==2){
          textSize(midaTitol-16); fill(0); textAlign(CENTER);
          text("Explicación Velocidad planeta orbital", width/2, marginV+25);//titol
          fill(200); noStroke();
          rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
          textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
          //Pregunta
          if(objetos == 0){
            text("Si un cuerpo orbita al rededor de otro y su velocidad en el perihélio (Dist km) es V1 m/s, ¿cual será su velocidad en el afelio (Dist km)?", x+ 30, y+marginV+55, w-60, h-10);
          }else{
            text("Si un cuerpo orbita al rededor de otro y su velocidad en el perihélio ("+CG.rp+"km) es "+CG.vp+" m/s, ¿cual será su velocidad en el afelio ("+CG.ra+" km)?", x+ 30, y+marginV+55, w-60, h-10);
          }
          //Explicación:
          textSize(midaSubtitol-8);
          float Y1 = y+marginV+55+200;
          text("El campo gravitatorio se caracteriza por ser conservativo, lo que significa que la energía mecánica se conserva. Además, según las leyes de Keppler, en una orbita cerrada elíptica, se conserva el movimiento angular. Para simplificar el caso estudiado, se van a considerar los puntos correspondientes al afelio y el perifelio ya que se conoce su distancia y velocidad.", x+ 30,Y1, w-50, h-10);
          textSize(midaParagraf);
          float Y2 = Y1 + 125;
          text("Lp = La", w/2 + 150,Y2, w-50, h-10);
          float Y3 = Y2 + 50;
          text("Rp*Pp = Ra*Pa", w/2 + 150,Y3, w-50, h-10);
          textSize(midaSubtitol-8);
          float Y4 = Y3 + 50;
          text("Donde p es la cantidad de movimiento. Entonces, esta se puede escribir como masa por velocidad donde la masa es igual ya que se trata del mismo cuerpo.", x+ 30,Y4, w-50, h-10);
          textSize(midaParagraf);
          float Y5 = Y4 + 75;
          text("Rp*m*Vp = Ra*m*Va", w/2 + 150,Y5, w-50, h-10);
          float Y6 = Y5 + 50;
          text("Rp*Vp = Ra*Va", w/2 + 150,Y6, w-50, h-10);
          textSize(midaSubtitol-8);
          float Y7 = Y6 + 50;
          text("Entonces, aislamos:", x+ 30,Y7, w-50, h-10);
          textSize(midaParagraf);
          text("Va = (Rp*Vp)/Ra", w/2 + 150,Y7, w-50, h-10);
          
          if(objetos > 0){
            textSize(midaSubtitol-8);
            float Y8 = Y7 + 50;
            text("I finalmente, substituimos:", x+ 30,Y8, w-50, h-10);
            float Resp = calcularEjercicioG2();
            textSize(midaParagraf);
            text("Va = ("+CG.rp+"*"+CG.vp+")/"+CG.ra+" = "+Resp, w/2 + 150,Y8, w-50, h-10);
            textSize(midaSubtitol-8);
            float Y9 = Y8 + 50;
            text("Solución: En el afelio tiene una velocidad de "+Resp+"km/s", x+ 30,Y9, w-50, h-10);
          } 
        }
        
        
      }else if(tema == TEMA.ELECTRIC){
        if(ejercicio==1){
          textSize(midaTitol-16); fill(0); textAlign(CENTER);
          text("Explicación Partículas cargadas", width/2, marginV+25);//titol
          fill(200); noStroke();
          rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
          textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
          //Pregunta
          if(objetos == 0){
            text("¿Cual és la fuerza entre dos particulas cargadas (C1 nC y C2 nC) que se encuentran a D mm de distancia?",x+ 30, y+marginV+55, w-60, h-10);
          }else{
            text("¿Cual és la fuerza entre dos particulas cargadas ("+P.c1+"nC y "+P.c2+"nC) que se encuentran a "+P.distancia+"mm de distancia?", x+ 30, y+marginV+55, w-60, h-10);
          }
          //Explicación:
          textSize(midaSubtitol-8);
          float Y1 = y+marginV+55+200;
          text("La fuerza de atracción entre cuerpoes es debido al campo electrico. De hecho, exsite una fórmula para calcular la fuerza de atracción entre dos partículas cargadas. Esta es la siguiente:", x+ 30,Y1, w-50, h-10);
          float Y2 = Y1 + 100;
          textSize(midaParagraf);
          text("F = K*(C1*C2)/(r^2)", w/2 + 150,Y2, w-50, h-10);
          textSize(midaSubtitol-8);
          float Y3 = Y2 + 50;
          text("En esta ecuación, K es la constante del campo eléctrico que se aproxima que equivale a 9*(10^9)\nEntonces, lo único que hace falta es substituir.", x+ 30,Y3, w-50, h-10);
          
          if(objetos > 0){
            float Y4 = Y3 + 100;
            float Resp = calcularEjercicioE1();
            textSize(midaParagraf);
            text("F = (9*(10^9))*("+P.c1+"*"+P.c2+")/("+P.distancia+"^2) = "+Resp, w/2,Y4, w-50, h-10);
            
            textSize(midaSubtitol-8);
            float Y5 = Y4 + 50;
            if(P.c1 > 0 && P.c2 > 0 || P.c1 < 0 && P.c2 < 0){
              text("La fuerza entre las partículas es de "+Resp+"F repulsiva", x+30, Y5, w-30, h);
            }else{
              text("La fuerza entre las partículas es de "+Resp+"F atractiva", x+30, Y5, w-30, h);
            }        
          }
        }else if(ejercicio==2){
          textSize(midaTitol-16); fill(0); textAlign(CENTER);
          text("Explicación Equilibrio eléctrico", width/2, marginV+25);//titol
          fill(200); noStroke();
          rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
          textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
          //Pregunta
          if(objetos == 0){
            text("¿Cuál debe ser la separación entre dos placas infinits con diferencia de potencial v V para mantener unelectrón en equilibrio?", x+ 30, y+marginV+55, w-60, h-10);
          }else{
            text("¿Cuál debe ser la separación entre dos placas infinitas con diferencia de potencial "+P.V+" V para mantener unelectrón en equilibrio?", x+ 30, y+marginV+55, w-60, h-10);
          }
          float Y1 = y+marginV+55+200;
          textSize(midaSubtitol-8);
          text("Cuando dos planos cargados eléctricamente se encuentran cerca, se establece una diferencia de potenciasl. Al acercarse más y ser paralelos e infinitos, esta diferencia de potencial crea un campo eléctrico constante que se define de la siguiente manera:", x+30, Y1, w-30, h);
          textSize(midaParagraf);
          float Y2 = Y1+ 150;
          text("E = DV/d", w/2+ 250,Y2, w-50, h-10);
          float Y3 = Y2 +50;
          textSize(midaSubtitol-8);
          text("Que estén en equilibrio significa que la fuerza eléctrica se iguala con el peso. por lo tanto, se pueden igualar los módulos", x+30, Y3, w-30, h);
          textSize(midaParagraf);
          float Y4 = Y3+ 50;
          text("F = P", w/2 + 250,Y4, w-50, h-10);
          float Y5 = Y4+ 50;
          text("q*E = m*g", w/2+ 250,Y5, w-50, h-10);
          float Y6 = Y5+ 50;
          text("q*V/d = m*g", w/2+ 250,Y6, w-50, h-10);
          float Y7 = Y6 +50;
          textSize(midaSubtitol-8);
          text("Seguidamente, de aisla la distancia:", x+30, Y7, w-30, h);
          textSize(midaParagraf);
          text("d = (q*V)/(m*g)", w/2+ 250,Y7, w-50, h-10);
          if(objetos > 0){
           float Y8 = Y7 +50;
           textSize(midaSubtitol-8);
           text("Finalmente, se substituye:", x+30, Y8, w-30, h);
           textSize(midaParagraf);
           float Resp = calcularEjercicioE2();
           text("d = (1.6*(10^-19)*"+P.V+")/(9.1*(10^-31)*9.81) = "+Resp, w/2+ 250,Y8, w-50, h-10);
           float Y9 = Y8+50;
           textSize(midaSubtitol-8);
           if(P.V > 0){
             text("Solución: Tendrá que tener una carga de "+Resp+"C para mantenerse en equilibrio", x+30, Y9, w-30, h);
           }else{
             text("Solución: No se podrá aguantar", x+30, Y9, w-30, h);
           }
          }
          
          
        }
      }else if(tema == TEMA.MEGNETIC){
        if(ejercicio==1){
          textSize(midaTitol-16); fill(0); textAlign(CENTER);
          text("Explicación Fuerza entre hilos", width/2, marginV+25);//titol
          fill(200); noStroke();
          rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
          textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
          //Pregunta
          if(objetos == 0){
            text("Si se consideran dos hilos conductores con intensidades I1 A y I2 A que distan de Dist m ¿Qué valdrá la fuerza producida entre ellos?", x+ 30, y+marginV+55, w-60, h-10);
          }else{
            text("Si se consideran dos hilos conductores con intensidades "+CM.I1+"A y "+CM.I2+"A que distan de "+CM.distancia+"mm  ¿Qué valdrá la fuerza producida entre ellos?", x+ 30, y+marginV+55, w-60, h-10);
          }
          //Explicación:
          float Y1 = y+marginV+55+200;
          textSize(midaSubtitol-8);
          text("En esto problema, existen dos casos. Por un lado, si los verctores de la intensidad de los hilos van en el mismo sentido, la fuerza será actractiva, en cambio, si van en sentido contrario, será repulsiva. De igual manera, su valor se puede calcular con el módulo siguiendo la siguiente expresión:", x+30, Y1, w-30, h);
          float Y2 = Y1 + 125;
          textSize(midaParagraf);
          text("F = NUo*(I1*I2)/(2*PI*r)", w/2 + 150,Y2, w-50, h-10);
          textSize(midaSubtitol-8);
          float Y3 = Y2 + 50;
          text("En esta ecuación, NUo es la resistivitat magnética del medio que equivale a 4*PI*(10^-7)\nEntonces, lo único que hace falta es substituir.", x+ 30,Y3, w-50, h-10);
          
          if(objetos > 0){
            float Y4 = Y3 + 75;
            float Resp = calcularEjercicioM1();
            textSize(midaParagraf);
            text("F = (4*PI*(10^-7))*("+CM.I1+"*"+CM.I2+")/(2*PI*"+CM.distancia+") = "+Resp, w/2-150,Y4, w-50, h-10);
            
            textSize(midaSubtitol-8);
            float Y5 = Y4 + 50;
            if(CM.I1< 0 && CM.I2< 0 || CM.I1> 0 && CM.I2> 0){
              text("Solución: La fuerza entre los hilos es de "+Resp+"F atractiva", x+30, Y5, w-30, h);
            }else{
              text("Solución: La fuerza entre los hilos es de "+Resp+"F repulsiva", x+30, Y5, w-30, h);
            }        
          }
          
        }else if(ejercicio==2){
          textSize(midaTitol-16); fill(0); textAlign(CENTER);
          text("Explicació Espira conductora", width/2, marginV+25);//titol
          fill(200); noStroke();
          rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
          textSize(midaSubtitol-2);textAlign(TOP, LEFT); fill(0);
          //Pregunta
          if(objetos == 0){
            text("¿Cual es el valor del campo magnético en una espira de radio R mm que conduce una intensidad de I A?", x+ 30, y+marginV+55, w-60, h-10);
          }else{
            text("¿Cual es el valor del campo magnético en una espira de radio "+CM.distancia+" mm que conduce una intensidad de "+CM.I1+" A?", x+ 30, y+marginV+55, w-60, h-10);
          }
          //Explicación:
          float Y1 = y+marginV+55+200;
          textSize(midaSubtitol-8);
          text("En esto problema, existen dos casos. Por un lado, si la intensidad es positiva(es decir, circula en sentido horario) el vecor del campo magnético irá hacia dentro del plano del papel. En cambio, si es negativa, irá hacia fuera. De igual manera, su valor se puede calcular con el módulo siguiendo la siguiente expresión:", x+30, Y1, w-30, h);
          float Y2 = Y1 + 125;
          textSize(midaParagraf);
          text("B = NUo*(I)/(2*r)", w/2 + 150,Y2, w-50, h-10);
          textSize(midaSubtitol-8);
          float Y3 = Y2 + 50;
          text("En esta ecuación, NUo es la resistivitat magnética del medio que equivale a 4*PI*(10^-7)\nEntonces, lo único que hace falta es substituir.", x+ 30,Y3, w-50, h-10);
          if(objetos > 0){
            float Y4 = Y3 + 75;
            float Resp = calcularEjercicioM2();
            textSize(midaParagraf);
            text("F = (4*PI*(10^-7))*("+CM.I1+")/(2*"+CM.distancia+") = "+Resp, w/2,Y4, w-50, h-10);
            
            textSize(midaSubtitol-8);
            float Y5 = Y4 + 50;
            if(CM.I1>0){
              text("El campo magnetico generado es de "+Resp+"T hacia dentro de la pantalla", x+30, Y5, w-30, h);
            }else{
              text("El campo magnetico generado es de "+Resp+"T hacia fuera de la pantalla", x+30, Y5, w-30, h);
            } 
          }
        }
      }
    popStyle();
}

void pantallaExercicis(TEMA tema, int exercici){
  PImage star;
  pushStyle();
  fill(0);
    if(tema == TEMA.CINEMATICA){
      if(exercici == 1){
        //Titol
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Choque de móbiles", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[0];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        //Visualització d'exercici
        visualitzacioCinematica1(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }else if(exercici == 2){
        //Titol
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Tiro parabólico", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[0];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        visualitzacioCinematica2(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }
    }else if(tema == TEMA.DINAMICA){
      if(exercici == 1){
        //Titol
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Polea en plano inclinado", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[2];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        visualitzacioDinamica1(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }else if(exercici == 2){
        //Titol
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Caja rozante", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[1];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        visualitzacioDinamica2(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }
    }else if(tema == TEMA.OPTICA){
      if(exercici == 1){
        //Titol
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Espejo", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[2];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        visualitzacioOptica1(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }else if(exercici == 2){
        //Titol
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Separación de rayos", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[3];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        visualitzacioOptica2(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }
    }else if(tema == TEMA.GRAVITATORI){
      if(exercici == 1){
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Atracción Estrella-Planeta", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[3];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        visualitzacioGravitatori1(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }else if(exercici == 2){
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Velocitat planeta orbital", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[3];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        visualitzacioGravitatori2(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }
    }else if(tema == TEMA.ELECTRIC){
      if(exercici == 1){
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Particulas cargadas", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[3];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        visualitzacioElectric1(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }else if(exercici == 2){
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Equilibrio Eléctrico", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[3];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        visualitzacioElectric2(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }
    }else if(tema == TEMA.MEGNETIC){
      if(exercici == 1){
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Fuerza entre conductores", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[3];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        visualitzacioMagnetic1(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }else if(exercici == 2){
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Espira conductora", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[3];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        visualitzacioMagnetic2(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }
    }
    drawExercici();
  popStyle();
}

void drawExercici(){
     pushStyle();
      //Selecció
      s1.setMides(marginH+100+ 900 +200 ,height/3-70, width-2*(marginH+100)-900-200, 60); s1.display();
      fill(255);
      rect(marginH+100+ 900 +200 ,height/3-70+60, width-2*(marginH+100)-900-200, 600-60);
      if(s1.getSelected().equals("Enunciado")){
        fill(0);textSize(midaParagraf);textAlign(TOP, LEFT);
        drawExerciceText(tema, exercici);
        if(objetos == objetoLimite){
          bRESET.setMides((marginH+100+ 900 +200 )+20, (height/3-70+60)+ (600-60) -(80+20), width-2*(marginH+100)-900-200 -(2*20), 80); bRESET.display();
        }
      }else{
        fill(255);
        textAlign(TOP, LEFT);
        drawExerciceResolucion(tema, exercici);
        bEXPLICACION.setMides((marginH+100+ 900 +200 )+20, (height/3-70+60)+ (600-60) -(80+20), width-2*(marginH+100)-900-200 -(2*20), 80); bEXPLICACION.display();
      }
      
      //BOTONES
        //Añadir
        bADD.setMides(marginH+100+ 900 +200 ,height/3-70+60+ (600-60) + 50, width-2*(marginH+100)-900-200, 80); bADD.display();
        //Formulario
        bFORMULARIO.setMides(marginH+100 ,height/3-70+60+ (600-60) + 50, width-2*(marginH+100)-900-200, 80);bFORMULARIO.display();
        //Exportar
        bEXPORT.setMides(marginH+100 + 900- (width-2*(marginH+100)-900-200) ,height/3-70+60+ (600-60) + 50, width-2*(marginH+100)-900-200, 80);bEXPORT.display();
        
        //Añadir
        checkLimit();
        canAdd = objetos < objetoLimite;
        if(currentState == ESTADO.ANADIR){
          drawAdd(canAdd);
        }else if(currentState == ESTADO.EXPORTAR){
          drawExport();
        }        
    popStyle();
}

void checkLimit(){
  if(tema == TEMA.CINEMATICA){
    if(exercici == 1){
      objetoLimite = 2;
    }else if(exercici == 2){
      objetoLimite = 1;
    }
  }else if(tema == TEMA.DINAMICA){
    if(exercici == 1){
      objetoLimite = 1;
    } else if(exercici == 2){
      objetoLimite = 1;
    }
  }else if(tema == TEMA.OPTICA){
    if(exercici == 1){
      objetoLimite = 1;
    }else if(exercici == 2){
      objetoLimite = 1;
    }
  }else if(tema == TEMA.GRAVITATORI){
    if(exercici == 1){
      objetoLimite = 1;
    }else if(exercici == 2){
      objetoLimite = 1;
    }
  }else if(tema == TEMA.ELECTRIC){
    if(exercici == 1){
      objetoLimite = 1;
    }else if(exercici == 2){
      objetoLimite = 1;
    }
  }else if(tema == TEMA.MEGNETIC){
    if(exercici == 1){
      objetoLimite = 1;
    }else if(exercici == 2){
      objetoLimite = 1;
    }
  }
}

void drawExerciceResolucion(TEMA tema, int exercici){
  float Resp;
  
  float x = marginH+100+ 900 +200+ 20;
  float y = height/3-70+60+40;
  float w = width-2*(marginH+100)-900-200; 
  float h = 600-60;
  textSize(24); fill(0);
  text("Datos:", x, y);
  text("RESPUESTA:", x, y+h/2);
  textSize(20);
  if(tema == TEMA.CINEMATICA){
    if(exercici == 1 && objetos>1){
        text("Posición primer móbil: ("+m0.p.x+", "+m0.p.y+")", x, y+40, w-30, h);
        text("Posición segundo móbil: ("+m1.p.x+", "+m1.p.y+")", x, y+80, w-30, h);
        text("Velocidad primer móbil: "+m0.vel+"m/s", x, y+120, w-30, h);
        text("Velocidad segundo móbil: "+m0.vel+"m/s", x, y+160, w-30, h);
        Resp = calcularEjercicioC1();
        text("Se chocarán cuando hayan pasado "+Resp+"s", x, y+h/2+40, w-30, h);
    }else if(exercici == 2 && objetos>0){
        text("Angulo con la horizontal: "+m0.angulo+"º", x, y+40, w-30, h);
        text("Velocidad inicial del mobil: "+m0.vel+"m/s", x, y+80, w-30, h);
        text("Altura del precipicio: "+m0.altura+"m", x, y+120, w-30, h);
        Resp = calcularEjercicioC2();
        text("Xocará contra el suelo a "+Resp+"m del precipicio", x, y+h/2+40, w-30, h);
    }
  }else if(tema == TEMA.DINAMICA){
    if(exercici == 1 && objetos > 0){
      text("Masa de la primera caja: "+c0.masa+"kg",x, y+40, w-30, h);
      text("Inclinación del plano: "+c0.angulo+"N", x, y+80, w-30, h);
      Resp = calcularEjercicioD1();
      text("Para que el sistema esté en equilibrio la segunda caja debe tener una masa de "+Resp+"kg", x, y+h/2+40, w-30, h);
    }else if(exercici == 2 && objetos>0){
      text("Masa de la caja: "+c0.masa+"kg", x, y+40, w-30, h);
      text("Fuerza aplicada: "+c0.Fuerza+"N", x, y+80, w-30, h);
      text("Coeficiente de fricción: "+c0.Nu+"m/(s^2)", x, y+120, w-30, h);
      Resp = calcularEjercicioD2();
      if(Resp > 0){
        text("Se moverá; concretamente a "+Resp+"m/(s^2)", x, y+h/2+40, w-30, h);
      }else{
        text("No se moverá", x, y+h/2+40, w-30, h);
      }
    }
  }else if(tema == TEMA.OPTICA){
    if(exercici == 1 && objetos >0){
      text("Distancia Obs.-Vidrio: "+l.XObsVi+"m", x, y+40, w-30, h);
      text("Distancia x Obs-Abeja: "+l.xAbeja+"m", x, y+80, w-30, h);
      text("Distancia y Obs-Abeja: "+l.yAbeja+"m", x, y+120, w-30, h);
      Resp = calcularEjercicioO1();
      text("La imagen se formará a "+Resp+"m del observador", x, y+h/2+40, w-30, h);
    }else if(exercici == 2 && objetos >0){
      text("Ángulo de incidencia: "+l.angulo+"º", x, y+40, w-30, h);
      text("n1: "+l.n1, x, y+80, w-30, h);
      text("n2: "+l.n2, x, y+120, w-30, h);
      Resp = calcularEjercicioO2();
      text("La separación de los rayos será por "+Resp+"º", x, y+h/2+40, w-30, h);
    }
  }else if(tema == TEMA.GRAVITATORI){
    if(exercici == 1 && objetos >0){
      text("Masa Planeta: "+CG.m1+"Kg", x, y+40, w-30, h);
      text("Masa Sol: "+CG.m2+"Kg", x, y+80, w-30, h);
      text("Distancia: "+CG.distancia+"km", x, y+120, w-30, h);
      Resp = calcularEjercicioG1();
      text("La fuerza de atracción entre los cuerpos astonómicos es "+Resp+"N", x, y+h/2+40, w-30, h);
    }else if(exercici == 2 && objetos >0){
      text("Distancia del perihelio: "+CG.rp+"Km", x, y+40, w-30, h);
      text("Distancia del afelio: "+CG.vp+"Km", x, y+80, w-30, h);
      text("velocidad Perihelio: "+CG.rp+"m/s", x, y+120, w-30, h);
      Resp =  calcularEjercicioG2();
      text("En el afelio tiene una velocidad de "+Resp+"km/s", x, y+h/2+40, w-30, h);
    }
  }else if(tema == TEMA.ELECTRIC){
    if(exercici == 1 && objetos >0){
      text("Carga primera partícula: "+P.c1+"nC", x, y+40, w-30, h);
      text("Carga segunda partícula: "+P.c2+"nC", x, y+80, w-30, h);
      text("Distancia entre partículas: "+P.distancia+"mm", x, y+120, w-30, h);
      Resp =  calcularEjercicioE1();
      if(P.c1 > 0 && P.c2 > 0 || P.c1 < 0 && P.c2 < 0){
        text("La fuerza entre las partículas es de "+Resp+"F repulsiva", x, y+h/2+40, w-30, h);
      }else{
        text("La fuerza entre las partículas es de "+Resp+"F atractiva", x, y+h/2+40, w-30, h);
      }
      
    }else if(exercici == 2 && objetos > 0){
      text("Diferencia de potencial: "+P.V+"V", x, y+40, w-30, h);
      if(P.V > 0){
        Resp =  calcularEjercicioE2();
        text("Tendrá que tener una carga de "+Resp+"C para mantenerse en equilibrio", x, y+h/2+40, w-30, h);
      }else{
        text("No se podrá aguantar", x, y+h/2+40, w-30, h);
      }
    }
  }else if(tema == TEMA.MEGNETIC){
    if(exercici == 1 && objetos >0){
      text("Intensidad del primer hilo: "+CM.I1+"A", x, y+40, w-30, h);
      text("Intensidad del segundo hilo: "+CM.I2+"A", x, y+80, w-30, h);
      text("Distancia entre hilos: "+CM.distancia+"mm", x, y+120, w-30, h);
      Resp =  calcularEjercicioM1();
      if(CM.I1< 0 && CM.I2< 0 || CM.I1> 0 && CM.I2> 0){
        text("La fuerza entre los hilos es de "+Resp+"F atractiva", x, y+h/2+40, w-30, h);
      }else{
        text("La fuerza entre los hilos es de "+Resp+"F repulsiva", x, y+h/2+40, w-30, h);
      }
      
    }else if(exercici == 2){
      text("Intensidad del la espira: "+CM.I1+"A", x, y+40, w-30, h);
      text("Radio de la espira: "+CM.distancia+"mm", x, y+80, w-30, h);
      Resp =  calcularEjercicioM2();
      if(CM.I1>0){
        text("El campo magnetico generado es de "+Resp+"T hacia dentro de la pantalla", x, y+h/2+40, w-30, h);
      }else{
        text("El campo magnetico generado es de "+Resp+"T hacia fuera de la pantalla", x, y+h/2+40, w-30, h);
      }
    }
  }
}

void drawExerciceText(TEMA tema, int exercici){
  float x = marginH+100+ 900 +200+ 20;
  float y = height/3-70+60+40;
  float w = width-2*(marginH+100)-900-200; 
  float h = 600-60;
  textSize(24);//textFont(fonts[0]);
  text("ENUNCIADO:", x, y);
  textSize(20);
  if(tema == TEMA.CINEMATICA){
    if(exercici == 1){
      if(objetos<2){
       text("Dos mobiles, uno situado en la coordenada (X1, Y1) de un eje de cordenadas cartegianas y otro situado en (X2, Y2) se mueven en un MRU (que empieza en t=0s) en dirección de xocar. Si la velocidad del primero es V1m/s y la del segundo es V2m/2, ¿cuando xocarán?", x, y+26, w-30, h-10);
      }else{
        text("Dos mobiles, uno situado en la coordenada ("+m0.p.x+", "+m0.p.y+") de un eje de cordenadas cartegianas y otro situado en ("+m1.p.x+", "+m1.p.y+") se mueven en un MRU (que empieza en t=0s) en dirección de xocar. Si la velocidad del primero es "+m0.vel+"m/s y la del segundo es "+m1.vel+",m/s ¿cuando xocarán?", x, y+26, w-30, h-10);
      }
    }else if(exercici == 2){
      if(objetos == 0){
        text("Si un mobil se situa en un precipicio cuya altura es H y se lanza a una velocidad V en un ángulo A respeto a la horizontal; ¿a cuantos metros del precicpicio xocará contra el suelo?", x, y+26, w-30, h-10);
      }else if(objetos >0){
        text("Si un mobil se situa en un precipicio cuya altura es "+m0.altura+" y se lanza a una velocidad "+m0.vel+" en un ángulo "+m0.angulo+" respeto a la horizontal; ¿a cuantos metros del precicpicio xocará contra el suelo?", x, y+26, w-30, h-10);
      }
      
    }
  }else if(tema == TEMA.DINAMICA){
    if(exercici == 1){
      if(objetos == 0){
        text("Si se considera una polea en un plano inclinado de ángulo Alpha que sujeta dos objetos, y el que está en el plano inclinado tiene una masa de M1 kg, ¿qué masa tiene que tener el segundo objeto para que el sistema esté en equilibrio?", x, y+26, w-30, h-10);
      }else if(objetos == 1){
        text("Si se considera una polea en un plano inclinado de ángulo "+c0.angulo+" que sujeta dos objetos, y el que está en el plano inclinado tiene una masa de "+c0.masa+" kg, ¿qué masa tiene que tener el segundo objeto para que el sistema esté en equilibrio?", x, y+26, w-30, h-10);
      }
    }else if(exercici == 2){
      if(objetos == 0){
        text("Si a un cuerpo de massa M kg se le aplica una fuerza F N, teniendo en cuenta que entre el cuerpo y el suelo hay un coeficiente de fricción Nu, ¿Se moverá? En caso afirmativo ¿Cual será su acceleración?", x, y+26, w-30, h-10);      
      }else{
        text("Si a un cuerpo de massa "+c0.masa+" kg se le aplica una fuerza "+c0.Fuerza+" N, teniendo en cuenta que entre el cuerpo y el suelo hay un coeficiente de fricción "+c0.Nu+", ¿Se moverá? En caso afirmativo ¿Cual será su acceleración?", x, y+26, w-30, h-10);
      }
    }  
  }else if(tema == TEMA.OPTICA){
    if(exercici == 1){
      if(objetos == 0){
         text("Se toma como punto de referencia el ojo de un observador. También se sabe que hay un vidrio a X1 m del ojo y una abeja stiuada a X2 y Y2 m de distáncia,¿en que posición se produce la imagen de la abeja?", x, y+26, w-30, h-10);
      }else if(objetos == 1){
         text("Se toma como punto de referencia el ojo de un observador. También se sabe que hay un vidrio a "+l.XObsVi+" m del ojo y una abeja stiuada a "+l.xAbeja+" y "+l.yAbeja+" m de distáncia,¿en que posición se produce la imagen de la abeja?", x, y+26, w-30, h-10);
      }
   }else if(exercici == 2){
     if(objetos == 0){
        text("Si un rayo de luz que se translada por el aire incide en un vidrio formando un ángulo de Aº con la normal y se separa en dos rayos de coeficientes de refracción n1 y n2, ¿cual será la separación angular de los rayos?", x, y+26, w-30, h-10);
     }else if(objetos == 1){
        text("Si un rayo de luz que se translada por el aire incide en un vidrio formando un ángulo de "+l.angulo+"º con la normal y se separa en dos rayos de coeficientes de refracción "+l.n1+" y "+l.n2+", ¿cual será la separación angular de los rayos?", x, y+26, w-30, h-10);
     }
   }
  }else if(tema == TEMA.GRAVITATORI){
    if(exercici == 1){
      if(objetos == 0){
        text("Si un planeta de massa M1 Kg se encuentra a Dist Km de una estrella de massa M2 Kg, ¿cual será la fuerza de atracción entre los dos cuerpos?", x, y+26, w-30, h-10);
      }else{
        text("Si un planeta de massa "+CG.m1+"Kg se encuentra a "+CG.distancia+"Km de una estrella de massa "+CG.m2+"Kg, ¿cual será la fuerza de atracción entre los dos cuerpos?", x, y+26, w-30, h-10);
      }
    }else if(exercici == 2){
      if(objetos == 0){
        text("Si un cuerpo orbita al rededor de otro y su velocidad en el perihélio (Dist km) es V1 m/s, ¿cual será su velocidad en el afelio (Dist km)?", x, y+26, w-30, h-10);
      }else{
        text("Si un cuerpo orbita al rededor de otro y su velocidad en el perihélio ("+CG.rp+"km) es "+CG.vp+" m/s, ¿cual será su velocidad en el afelio ("+CG.ra+" km)?", x, y+26, w-30, h-10);
      }
    }
  }else if(tema == TEMA.ELECTRIC){
    if(exercici == 1){
      if(objetos == 0){
        text("¿Cual és la fuerza entre dos particulas cargadas (C1 nC y C2 nC) que se encuentran a D mm de distancia?", x, y+26, w-30, h-10);
      }else{
        text("¿Cual és la fuerza entre dos particulas cargadas ("+P.c1+"nC y "+P.c2+"nC) que se encuentran a "+P.distancia+"mm de distancia?", x, y+26, w-30, h-10);
      }
    }else if(exercici == 2){
      if(objetos == 0){
        text("¿Cuál debe ser la separación entre dos placas infinits con diferencia de potencial v V para mantener unelectrón en equilibrio?", x, y+26, w-30, h-10);
      }else{
        text("¿Cuál debe ser la separación entre dos placas infinitas con diferencia de potencial "+P.V+" V para mantener unelectrón en equilibrio?", x, y+26, w-30, h-10);
      }
    }
  }else if(tema == TEMA.MEGNETIC){
    if(exercici == 1){
      if(objetos == 0){
        text("Si se consideran dos hilos conductores con intensidades I1 A y I2 A que distan de Dist m ¿Qué valdrá la fuerza producida entre ellos?", x, y+26, w-30, h-10);  
      }else{
        text("Si se consideran dos hilos conductores con intensidades "+CM.I1+"A y "+CM.I2+"A que distan de "+CM.distancia+"mm  ¿Qué valdrá la fuerza producida entre ellos?", x, y+26, w-30, h-10);
      }
      
    }else if(exercici == 2){
      if(objetos == 0){
        text("¿Cual es el valor del campo magnético en una espira de radio R mm que conduce una intensidad de I A?", x, y+26, w-30, h-10);
      }else{
        text("¿Cual es el valor del campo magnético en una espira de radio "+CM.distancia+" mm que conduce una intensidad de "+CM.I1+" A?", x, y+26, w-30, h-10);
      }
    }
  }
}
//text("", x, y+26, w-30, h-10);
void drawAdd(boolean canAdd){
  
  //Cantidad de objetos
    if(objetos==2){
      canAdd = false;
    }
  pushStyle();
    fill(getColor("Fondo"));
    rectMode(CENTER); textAlign(CENTER);
    rect(width/2, height/2, width/3+150, height/3+150);
    if(canAdd){
      textSize(midaSubtitol+15); fill(0);
      text("Dar Valores",width/2, height/2- (height/3+150)/2 +70);
      rectMode(CORNER);
      bADDLeave.setMides(width/2 -(200/2) -150, height/2 +(height/3+150)/2 -70 -(80/2), 200, 80); bADDLeave.display();
      bADDRanValues.setMides(width/2 -(200/2) + 150, height/2 +(height/3+150)/2 -70 -(80/2), 200, 80); bADDRanValues.display();
      DisplayAddInformation(tema, exercici); //serà per cada una distinta.
    }else if(!canAdd){
      fill(0);
      text("No puedes añadir más objetos", width/2, height/2);
    }
  popStyle();
}

void DisplayAddInformation(TEMA tema, int ejercicio){
  pushStyle();
    textAlign(CORNER); textFont(fonts[1]);textSize(30);
    int nFields;
    float xF = width/2-25;
    float xT = width/2-200;
    if(tema == TEMA.CINEMATICA){
      if(ejercicio==1){
        nFields = 3;
        //Nom
        tfCaddName.display(xF, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfCaddName.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Velocitat
        tfCaddVel.display(xF, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)), 200, 40);
        text(tfCaddVel.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        //Posició
        text("X:", xF- 30, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        tfCaddPos1.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 70, 40);
        text("Y:", xF+70+(200-70-70)-30, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        tfCaddPos2.display(xF+70+(200-70-70), (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 70, 40);
        text(tfCaddPos1.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        
        //Magnitudes:
        text("en m", xT+ 400, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        text("m/s", xT+ 400, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
      }else if(ejercicio==2){
        nFields = 4;
        //Nom
        tfCaddName.display(xF, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfCaddName.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Velocitat
        tfCaddVel.display(xF, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)), 200, 40);
        text(tfCaddVel.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        //Angle
        tfCaddAngle.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfCaddAngle.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+35));
        tfCaddHigh.display(xF, -20+(height/2 -(height/3+150)/2-10)+ (4*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfCaddHigh.tipo + ":", xT, -20+(height/2 -(height/3+150)/2-10)+ (4*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+35));
        
        //Magnitudes:
        text("º", xT+ 400, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+35));
        text("m/s", xT+400, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        text("m", xT+400, -20+(height/2 -(height/3+150)/2-10)+ (4*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+35));
      }  
    }else if(tema == TEMA.DINAMICA){
      if(ejercicio==1){
        nFields = 2;
        tfCaddAngle.display(xF,-20+(height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfCaddAngle.tipo + ":", xT, -20+(height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Posició
        tfDaddMasa.display(xF, -20+(height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfDaddMasa.tipo + ":", xT, -20+(height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        
        //Magnitudes:
        text("kg", xT+400, -20+(height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        text("º",  xT+400, -20+(height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
      }else if(ejercicio==2){
        nFields = 3;
        //Nom
        tfDaddMasa.display(xF, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfDaddMasa.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Velocitat
        tfDaddF.display(xF, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)), 200, 40);
        text(tfDaddF.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        //Posició
        tfDaddNu.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfDaddNu.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        
        //Magnitudes:
        text("kg", xT+400, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        text("N", xT+400, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
      }
    }else if(tema == TEMA.OPTICA){
      if(ejercicio==1){
        nFields=3;
        tfOXobs.display(xF+32, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfOXobs.tipo + ":", xT-32,(height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Velocitat
        tfOXabeja.display(xF+95, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)), 200, 40);
        text(tfOXabeja.tipo + ":", xT-95,(height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        //Posició
        tfOYabeja.display(xF+95, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfOYabeja.tipo + ":", xT-95,(height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        
        //Magnitudes:
        text("m", xT+432,(height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        text("m", xT+495,(height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        text("m",  xT+495,(height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
      }else if(ejercicio==2){
        nFields = 3;
        //Nom
        tfOAngulo.display(xF, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfOAngulo.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Velocitat
        tfOn1.display(xF, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)), 200, 40);
        text(tfOn1.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        //Posició
        tfOn2.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfOn2.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        
        //Magnitudes:
        text("º", xT+400, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30) );
      }
    }else if(tema == TEMA.GRAVITATORI){
      if(ejercicio==1){
        nFields = 3;
        tfGm1.display(xF, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfGm1.tipo + ":", xT-40, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Velocitat
        tfGm2.display(xF, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)), 200, 40);
        text(tfGm2.tipo + ":", xT-40, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        //Posició
        tfGDistancias.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfGDistancias.tipo + ":", xT-30, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        
        //Magnitudes:
        text("Kg", xT+400, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30) );
        text("Kg", xT+400, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        text("Km", xT+400, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
      }else if(ejercicio==2){
        nFields = 3;
        tfGr1.display(xF, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfGr1.tipo + ":", xT-65, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Velocitat
        tfGv1.display(xF, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)), 200, 40);
        text(tfGv1.tipo + ":", xT-65, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
       
        tfGr2.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfGr2.tipo + ":", xT-65, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
      
        //Magnitudes;
        text("Km", xT+400, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        text("Km/s", xT+400, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        text("Km", xT+400, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
      }
    }else if(tema == TEMA.ELECTRIC){
      if(ejercicio==1){
        nFields = 3;
        tfEc1.display(xF, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfEc1.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Velocitat
        tfEc2.display(xF, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)), 200, 40);
        text(tfEc2.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
       
        tfGDistancias.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfGDistancias.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        
        //Magnitudes:
        text("nC", xT+400, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        text("nC", xT+400, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        text("mm", xT+400, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
      }else if(ejercicio==2){
        nFields = 1;
        tfEV.display(xF+95, height/2-30, 200, 40);
        text(tfEV.tipo+ ":", xT-95, height/2);
        
        //Magnitudes:
        text("V", xT+495, height/2);
      }
    }else if(tema == TEMA.MEGNETIC){
      if(ejercicio==1){
        nFields = 3;
        tfMI1.display(xF, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfMI1.tipo + ":", xT-20, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Velocitat
        tfGDistancias.display(xF, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)), 200, 40);
        text(tfGDistancias.tipo + ":", xT-20, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
       
        tfMI2.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfMI2.tipo + ":", xT-20, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        
        //Magnitudes:
        text("A", xT+400, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        text("mm", xT+400, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        text("A", xT+400, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
      }else if(ejercicio==2){
        nFields=2;
        ftMIntensidad.display(xF, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(ftMIntensidad.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Posició
        tfMRadio.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfMRadio.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        
        //Magnitudes:
        text("A", xT+400, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        text("mm", xT+400, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
      }
    }
  popStyle();
}

void drawExport(){
  pushStyle();
    fill(getColor("Fondo"));
      rectMode(CENTER); textAlign(CENTER); textSize(midaSubtitol+15);
      rect(width/2, height/2, width/3-150, height/3-150);
      fill(0);
      text("Exportar",width/2, height/2- (height/3-150)/2 +70);
      rectMode(CORNER);
      bEXPORTRes.setMides(width/2 -(width/3-150)/2 +20, height/2, ((width/3-150) -20 -2*20 -20)/2, 80); bEXPORTRes.display();
      bEXPORTEnu.setMides(width/2 +(width/3-150)/2 -20 - ((width/3-150) -20 -2*20 -20)/2, height/2, ((width/3-150) -20 -2*20 -20)/2, 80); bEXPORTEnu.display();
  popStyle();
}

void drawPantallaError(){
  pushStyle();
    fill(255, 0, 0);
    rect(0, 0, width, height);
  popStyle();
}
