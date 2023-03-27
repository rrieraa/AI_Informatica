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
          
          //Substitución:
          if(objetos>1){
            textAlign(LEFT, TOP); textSize(midaSubtitol-8);
            float ySub = yExpr + 180;
            text("Entonces, substituimos en la ecuación:", xBorde, ySub);
            float yRes = ySub+40;
            float Resp = calcularEjercicioC1();
            text("t = (sqrt(("+m1.p.x+"-"+m0.p.x+")^2 + ("+m1.p.y+"-"+m0.p.y+"^2))/("+m0.vel+"+"+m1.vel+") = "+Resp, xExpr, yRes, w, 600);
            text("SOLUCIÓN: Se chocarán cuando hayan passado "+Resp+"s", xBorde, ySub+100);
          }
          
        }else if(ejercicio==2){
          text("Explicación Cinemàtica 2", width/2, height/2);
        }  
      }else if(tema == TEMA.DINAMICA){
        if(ejercicio==1){
          text("Explicación Dinamica 1", width/2, height/2);
        }else if(ejercicio==2){
          text("Explicación Dinamica 2", width/2, height/2);
        }
      }else if(tema == TEMA.OPTICA){
        if(ejercicio==1){
          text("Explicación Optica 1", width/2, height/2);
        }else if(ejercicio==2){
          text("Explicación Optica 2", width/2, height/2);
        }
      }else if(tema == TEMA.GRAVITATORI){
        if(ejercicio==1){
          text("Explicación Campo Gravitatorio 1", width/2, height/2);
        }else if(ejercicio==2){
          text("Explicación Campo Gravitatorio 2", width/2, height/2);
        }
      }else if(tema == TEMA.ELECTRIC){
        if(ejercicio==1){
          text("Explicación Campo Electrico 1", width/2, height/2);
        }else if(ejercicio==2){
          text("Explicación Campo Electrico 2", width/2, height/2);
        }
      }else if(tema == TEMA.MEGNETIC){
        if(ejercicio==1){
          text("Explicación Campo Magnetico 1", width/2, height/2);
        }else if(ejercicio==2){
          text("Explicación Campo Magnetico 2", width/2, height/2);
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
          //bRESET.setMides((marginH+100+ 900 +200 )+20, (height/3-70+60)+ (600-60) -(80+20), width-2*(marginH+100)-900-200 -(2*20), 80); bRESET.display();
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
    }else if(exercici == 2){
      text("Ángulo de incidencia: "+l.angulo+"º", x, y+40, w-30, h);
      text("n1: "+l.n1, x, y+80, w-30, h);
      text("n2: "+l.n2, x, y+120, w-30, h);
      Resp = calcularEjercicioO2();
      text("La separación de los rayos será por "+Resp+"º", x, y+h/2+40, w-30, h);
    }
  }else if(tema == TEMA.GRAVITATORI){
    if(exercici == 1){
      text("Masa Planeta: "+CG.m1+"Kg", x, y+40, w-30, h);
      text("Masa Sol: "+CG.m2+"Kg", x, y+80, w-30, h);
      text("Distancia: "+CG.distancia+"m", x, y+120, w-30, h);
      Resp = calcularEjercicioG1();
      text("La fuerza de atracción entre los cuerpos astonómicos es "+Resp+"N", x, y+h/2+40, w-30, h);
    }else if(exercici == 2){
      text("Distancia del perihelio: "+CG.rp+"Km", x, y+40, w-30, h);
      text("Distancia del afelio: "+CG.vp+"Km", x, y+80, w-30, h);
      text("velocidad Perihelio: "+CG.rp+"m/s", x, y+120, w-30, h);
      Resp =  calcularEjercicioG2();
      text("En el afelio tiene una velocidad de "+Resp+"m/s", x, y+h/2+40, w-30, h);
    }
  }else if(tema == TEMA.ELECTRIC){
    if(exercici == 1){
      text("Carga primera partícula: "+P.c1+"mC", x, y+40, w-30, h);
      text("Carga segunda partícula: "+P.c2+"mC", x, y+80, w-30, h);
      text("Distancia entre partículas: "+P.distancia+"m", x, y+120, w-30, h);
      Resp =  calcularEjercicioE1();
      if(P.c1 > 0 && P.c2 > 0 || P.c1 < 0 && P.c2 < 0){
        text("La fuerza entre las partículas es de "+Resp+"F repulsiva", x, y+h/2+40, w-30, h);
      }else{
        text("La fuerza entre las partículas es de "+Resp+"F atractiva", x, y+h/2+40, w-30, h);
      }
      
    }else if(exercici == 2){
      text("¿Qué debe valer el potencial eléctrico para mantener en equilibrio a una partícula cargada de C?", x, y+26, w-30, h-10);
    }
  }else if(tema == TEMA.MEGNETIC){
    if(exercici == 1){
      text("Si se consideran dos hilos conductores con intensidades I1 y I2 que distan de Dist  ¿Qué valdrá la fuerza producida entre ellos?", x, y+26, w-30, h-10);
    }else if(exercici == 2){
      text("¿Cual es el valor del campo magnético en una espira de radio R que conduce una intensidad de I?", x, y+26, w-30, h-10);
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
        text("Si un planeta de massa M1 se encuentra a Dist de una estrella de massa M2, ¿cual será la fuerza de atracción entre los dos cuerpos?", x, y+26, w-30, h-10);
      }else{
        text("Si un planeta de massa "+CG.m1+" se encuentra a "+CG.distancia+" de una estrella de massa "+CG.m2+", ¿cual será la fuerza de atracción entre los dos cuerpos?", x, y+26, w-30, h-10);
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
        text("¿Cual és la fuerza entre dos particulas cargadas (C1 mC y C2 mC) que se encuentran a D m de distancia?", x, y+26, w-30, h-10);
      }else{
        text("¿Cual és la fuerza entre dos particulas cargadas ("+P.c1+"mC y "+P.c2+"mC) que se encuentran a "+P.distancia+"m de distancia?", x, y+26, w-30, h-10);
      }
    }else if(exercici == 2){
      text("¿Cuál debe ser la separación entre dos placas infinits con diferencia de potencial v V para mantener unelectrón en equilibrio?", x, y+26, w-30, h-10);
    }
  }else if(tema == TEMA.MEGNETIC){
    if(exercici == 1){
      text("Si se consideran dos hilos conductores con intensidades I1 y I2 que distan de Dist  ¿Qué valdrá la fuerza producida entre ellos?", x, y+26, w-30, h-10);
    }else if(exercici == 2){
      text("¿Cual es el valor del campo magnético en una espira de radio R que conduce una intensidad de I?", x, y+26, w-30, h-10);
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
      bADDLeave.setMides(width/2 -(200/2), height/2 +(height/3+150)/2 -70 -(80/2), 200, 80); bADDLeave.display();
      //bADDLeave.setMides(width/2 -(200/2) -150, height/2 +(height/3+150)/2 -70 -(80/2), 200, 80); bADDLeave.display();
      //bADDRanValues.setMides(width/2 -(200/2) + 150, height/2 +(height/3+150)/2 -70 -(80/2), 200, 80); bADDRanValues.display();
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
      }  
    }else if(tema == TEMA.DINAMICA){
      if(ejercicio==1){
        nFields = 2;
        tfCaddAngle.display(xF,-20+(height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfCaddAngle.tipo + ":", xT, -20+(height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Posició
        tfDaddMasa.display(xF, -20+(height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfDaddMasa.tipo + ":", xT, -20+(height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));

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
      }else if(ejercicio==2){
        nFields = 3;
        tfGr1.display(xF, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfGr1.tipo + ":", xT-65, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Velocitat
        tfGv1.display(xF, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)), 200, 40);
        text(tfGv1.tipo + ":", xT-65, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
       
        tfGr2.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfGr2.tipo + ":", xT-65, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
      
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
  
      }else if(ejercicio==2){
        nFields = 1;
        tfEV.display(xF+95, height/2-30, 200, 40);
        text(tfEV.tipo+ ":", xT-95, height/2);
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
      }else if(ejercicio==2){
        nFields=2;
        ftMIntensidad.display(xF, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(ftMIntensidad.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Posició
        tfMRadio.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfMRadio.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
     
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
