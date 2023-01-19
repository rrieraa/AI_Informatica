enum PANTALLA {INICI, SELECCIO, EXERCICI, FORMULARI, EXPLICACION};
PANTALLA Pantalla = PANTALLA.INICI;
PANTALLA PantallaPrevia = PANTALLA.INICI;
enum TEMA {CINEMATICA, DINAMICA, OPTICA, GRAVITATORI, MEGNETIC, ELECTRIC};
TEMA tema; int exercici; 
enum ESTADO {EJERCICIO, ANADIR, EXPORTAR};
ESTADO currentState = ESTADO.EJERCICIO;
int objetos = 0; boolean canAdd= true;

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
void pantallaExplicacion(TEMA tema, int ejercicio){
  fill(0);
    if(tema == TEMA.CINEMATICA){
      if(ejercicio==1){
        text("Explicación Cinemàtica 1", width/2, height/2);
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
          if(objetos>1){
            calcularExerciciCinematica1();
          }
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
        text("Caja rozante", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[1];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        visualitzacioDinamica1(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }else if(exercici == 2){
        //Titol
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Polea en plano inclinado", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[2];
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
      if(s1.getSelected().equals("Datos")){
        fill(255);
        rect(marginH+100+ 900 +200 ,height/3-70+60, width-2*(marginH+100)-900-200, 600-60);
        fill(0);textSize(midaParagraf);textAlign(TOP, LEFT);
        drawExerciceText(tema, exercici);
        
      }else{
        fill(255);
        rect(marginH+100+ 900 +200 ,height/3-70+60, width-2*(marginH+100)-900-200, 600-60);
        bEXPLICACION.setMides((marginH+100+ 900 +200 )+20, (height/3-70+60)+ (600-60) -(80+20), width-2*(marginH+100)-900-200 -(2*20), 80); bEXPLICACION.display();
      }
      
      //BOTONES
        //Añadir
        bADD.setMides(marginH+100+ 900 +200 ,height/3-70+60+ (600-60) + 50, width-2*(marginH+100)-900-200, 80); bADD.display();
        //Formulario
        bFORMULARIO.setMides(marginH+100 ,height/3-70+60+ (600-60) + 50, width-2*(marginH+100)-900-200, 80);bFORMULARIO.display();
        //Exportar
        bEXPORT.setMides(marginH+100 + 900- (width-2*(marginH+100)-900-200) ,height/3-70+60+ (600-60) + 50, width-2*(marginH+100)-900-200, 80);bEXPORT.display();
        
        if(currentState == ESTADO.ANADIR){
          drawAdd(canAdd);
        }else if(currentState == ESTADO.EXPORTAR){
          drawExport();
        }        
    popStyle();
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
      text("Dos mobiles, uno situado en la coordenada X1, Y1 de un eje de cordenadas cartegianas y otro situado en X2, Y2 se mueven en un MRU (que empieza en t0) en dirección de xocar. Si la velocidad del primero es V1 y la del segundo es V2, ¿cuando xocarán?", x, y+26, w-30, h-10);
    }else if(exercici == 2){
      text("Si un mobil se situa en un precipicio cuya altura es H y se lanza a una velocidad V en un ángulo A respeto a la horizontal; ¿a cuantos metros del precicpicio xocará contra el suelo?", x, y+26, w-30, h-10);
    }
  }else if(tema == TEMA.DINAMICA){
    if(exercici == 1){
      text("Si a un cuerpo de massa M se le aplica una fuerza F teniendo en cuenta que entre el suelo y dicho objeto hay un coeficiente de fricción Nu, ¿cual será la acceleración del cuerpo?", x, y+26, w-30, h-10);
    }else if(exercici == 2){
      text("Si se considera una polea en un plano inclinado de ángulo Alpha que sujeta dos objetos, de massa M1 y M2, ¿cual será la acceleración del sistema?", x, y+26, w-30, h-10);
    }
  }else if(tema == TEMA.OPTICA){
    if(exercici == 1){
      text("Si un observador se situa a X1 de un espejo y observa a una abeja en su misma posición, ¿cual será la posición donde se produce la imagen de la abeja?", x, y+26, w-30, h-10);
    }else if(exercici == 2){
      text("Si se disparan dos rayos de frecuencias F1 y F2 que inciden en un vidrio al mismo sitio, ¿cual será la separación entre los dos rayos tras salir del vidrio?", x, y+26, w-30, h-10);
    }
  }else if(tema == TEMA.GRAVITATORI){
    if(exercici == 1){
      text("Si un planeta de massa M1 se encuentra a Dist de una estrella de massa M2, ?cual será la fuerza de atracción entre los dos cuerpos?", x, y+26, w-30, h-10);
    }else if(exercici == 2){
      text("Si un cuerpo orbita al rededor de otro y su velocidad en el perihélio (Dist) es V1, ¿cual será su velocidad en R2?", x, y+26, w-30, h-10);
    }
  }else if(tema == TEMA.ELECTRIC){
    if(exercici == 1){
      text("¿Cual és la fuerza que ejercen dos posticulas cargades (C1 y C2) que se encuentran a Dist de distancia?", x, y+26, w-30, h-10);
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
        text(tfCaddAngle.tipo + ":", xT, -20+(height/2 -(height/3+150)/2-10)+ (4*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+35));
      }  
    }else if(tema == TEMA.DINAMICA){
      if(ejercicio==1){
        nFields = 3;
        //Nom
        tfDaddMasa.display(xF, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfDaddMasa.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Velocitat
        tfDaddF.display(xF, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)), 200, 40);
        text(tfDaddF.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        //Posició
        tfDaddNu.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 70, 40);
        text(tfDaddNu.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
   
  
   
      }else if(ejercicio==2){
        nFields = 3;
        //Nom
        tfDaddMasas.display(xF, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfDaddMasas.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Velocitat
        tfCaddAngle.display(xF, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)), 200, 40);
        text(tfCaddAngle.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        //Posició
        tfDaddNu.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 70, 40);
        text(tfDaddNu.tipo + ":", xT, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));

      }
    }else if(tema == TEMA.OPTICA){
      if(ejercicio==1){
        nFields=2;
        tfODistanciaX.display(xF, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfODistanciaX.tipo + ":", xT-90, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Posició
        tfODistanciaY.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfODistanciaY.tipo + ":", xT-90, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
      }else if(ejercicio==2){
        nFields=2;
        tfOF1.display(xF, -40+(height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfOF1.tipo + ":", xT-20, -40+(height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Posició
        tfOF2.display(xF, -40+(height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfOF2.tipo + ":", xT-20, -40+(height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
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
        tfGDistancias.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 70, 40);
        text(tfGDistancias.tipo + ":", xT-30, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
      }else if(ejercicio==2){
        nFields = 3;
        tfGr1.display(xF, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfGr1.tipo + ":", xT-65, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Velocitat
        tfGv1.display(xF, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)), 200, 40);
        text(tfGv1.tipo + ":", xT-65, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
       
        tfGDistancias.display(xF, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 200, 40);
        text(tfGDistancias.tipo + ":", xT-65, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
      
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
        tfECarga.display(xF, height/2-30, 200, 40);
        text(tfECarga.tipo+ ":", xT, height/2);
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
