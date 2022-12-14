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
    textSize(midaTitol);
    text(tema.toString(), width/2, marginV+100);//titol
    if(tema == TEMA.CINEMATICA){
      //Exercicis
        bC1.setMides((width/2)-650, 250, 500, 750); bC1.display();
        bC2.setMides(width/2+150, 250, 500, 750); bC2.display();
    }else if(tema == TEMA.DINAMICA){
      //Exercicis
        bD1.setMides((width/2)-650, 250, 500, 750); bD1.display();
        bD2.setMides(width/2+150, 250, 500, 750); bD2.display();
    }else if(tema == TEMA.OPTICA){
      //Exercicis
        bO1.setMides((width/2)-650, 250, 500, 750); bO1.display();
        bO2.setMides(width/2+150, 250, 500, 750); bO2.display();
    }else if(tema == TEMA.GRAVITATORI){
      //Exercicis
        bG1.setMides((width/2)-650, 250, 500, 750); bG1.display();
        bG2.setMides(width/2+150, 250, 500, 750); bG2.display();
    }else if(tema == TEMA.ELECTRIC){
      //Exercicis
        bE1.setMides((width/2)-650, 250, 500, 750); bE1.display();
        bE2.setMides(width/2+150, 250, 500, 750); bE2.display();
    }else if(tema == TEMA.MEGNETIC){
      //Exercicis
        bM1.setMides((width/2)-650, 250, 500, 750); bM1.display();
        bM2.setMides(width/2+150, 250, 500, 750); bM2.display();
    }
  popStyle();
}

void pantallaFormulari(TEMA tema){
  pushStyle();
    textSize(midaTitol);
    if(tema == TEMA.CINEMATICA){
      text("Formulari Cinem??tica", width/2, 175);
      tCfor.display(width/6, height/6+85, 4*width/6, 4*height/6);
    }else if(tema == TEMA.DINAMICA){
      text("Formulari Din??mica", width/2, 175);
      tDfor.display(width/6, height/6+85, 4*width/6, 4*height/6);
    }else if(tema == TEMA.OPTICA){
      text("Formulari Optica", width/2, 175);
      tOfor.display(width/6, height/6+85, 4*width/6, 4*height/6);
    }else if(tema == TEMA.GRAVITATORI){
      text("Formulari Gravitatori", width/2, 175);
      tGfor.display(width/6, height/6+85, 4*width/6, 4*height/6);
    }else if(tema == TEMA.ELECTRIC){
      text("Formulari El??ctric", width/2, 175);
      tEfor.display(width/6, height/6+85, 4*width/6, 4*height/6);
    }else if(tema == TEMA.MEGNETIC){
      text("Formulari Magn??tic", width/2, 175);
      tMfor.display(width/6, height/6+85, 4*width/6, 4*height/6);
    }
  popStyle();  
}
void pantallaExplicacion(TEMA tema, int ejercicio){
    if(tema == TEMA.CINEMATICA){
      if(ejercicio==1){
        text("Explicacion Cinem??tica 1", width/2, height/2);
      }else if(ejercicio==2){
        text("Explicacion Cinem??tica 2", width/2, height/2);
      }  
    }else if(tema == TEMA.DINAMICA){
      if(ejercicio==1){
        text("Explicacion Dinamica 1", width/2, height/2);
      }else if(ejercicio==2){
        text("Explicacion Dinamica 2", width/2, height/2);
      }
    }else if(tema == TEMA.OPTICA){
      if(ejercicio==1){
        text("Explicacion Optica 1", width/2, height/2);
      }else if(ejercicio==2){
        text("Explicacion Optica 2", width/2, height/2);
      }
    }else if(tema == TEMA.GRAVITATORI){
      if(ejercicio==1){
        text("Explicacion Campo Gravitatorio 1", width/2, height/2);
      }else if(ejercicio==2){
        text("Explicacion Campo Gravitatorio 2", width/2, height/2);
      }
    }else if(tema == TEMA.ELECTRIC){
      if(ejercicio==1){
        text("Explicacion Campo Electrico 1", width/2, height/2);
      }else if(ejercicio==2){
        text("Explicacion Campo Electrico 2", width/2, height/2);
      }
    }else if(tema == TEMA.MEGNETIC){
      if(ejercicio==1){
        text("Explicacion Campo Magnetico 1", width/2, height/2);
      }else if(ejercicio==2){
        text("Explicacion Campo Magnetico 2", width/2, height/2);
      }
    }
}

void pantallaExercicis(TEMA tema, int exercici){
  PImage star;
  pushStyle();
    if(tema == TEMA.CINEMATICA){
      print("cine");
      if(exercici == 1){
        //Titol
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Xoque de mobiles", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[0];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        //Visualitzaci?? d'exercici
        visualitzacioCinematica1(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
          if(objetos>1){
            calcularExerciciCinematica1();
          }
      }else if(exercici == 2){
        //Titol
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Tiro parab??lico", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
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
        text("Separaci??n de rayos", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[3];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        visualitzacioOptica2(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }
    }else if(tema == TEMA.GRAVITATORI){
      if(exercici == 1){
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Atracci??n Estrella-Planeta", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
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
        text("Particulas cargadas", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
        star = stars[3];
        star.resize((int)(width-2*(marginH+100)-900-200), (int)100);
        image(star, marginH+100+ 900 +200 ,height/3-70-120);
        visualitzacioElectric2(xVisualitzacio,yVisualitzacio , wVisualitzacio, hVisualitzacio);
      }
    }else if(tema == TEMA.MEGNETIC){
      if(exercici == 1){
        textSize(midaTitol);textAlign(LEFT, TOP);
        text("Fuerza entre hilos", xVisualitzacio-wVisualitzacio/2, yVisualitzacio-hVisualitzacio/2 -120);
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
      //Selecci??
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
        //A??adir
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
  if(tema == TEMA.CINEMATICA){
    if(exercici == 1){
      textSize(24);//textFont(fonts[0]);
      text("ENUNCIADO:", x, y);
      textSize(20);
      text("Dos mobiles, uno situado en la coordenada X1, Y1 de un eje de cordenadas cartegianas y otro situado en X2, Y2 se mueven en un MRU (que empieza en t0) en direcci??n de xocar. Si la velocidad del primero es V1 y la del segundo es V2, ??cuando xocar??n?", x, y+26);
    }
  }
}

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
      text("A??adir",width/2, height/2- (height/3+150)/2 +70);
      rectMode(CORNER);
      bADDLeave.setMides(width/2 -(200/2), height/2 +(height/3+150)/2 -70 -(80/2), 200, 80); bADDLeave.display();
      DisplayAddInformation(tema, exercici); //ser?? per cada una distinta.
    }else if(!canAdd){
      fill(0);
      text("No puedes a??adir m??s objetos", width/2, height/2);
    }
  popStyle();
}

void DisplayAddInformation(TEMA tema, int ejercicio){
  pushStyle();
    textAlign(CORNER); textSize(30);
    int nFields;
    if(tema == TEMA.CINEMATICA){
      if(ejercicio==1){
        nFields = 3;
        //Nom
        tfCaddName.display(width/2-25, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20), 200, 40);
        text(tfCaddName.tipo + ":", width/2-200, (height/2 -(height/3+150)/2-10)+ (1*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+20)+(30));
        //Velocitat
        tfCaddVel.display(width/2-25, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)), 200, 40);
        text(tfCaddVel.tipo + ":", width/2-200, (height/2 -(height/3+150)/2-10)+ (3*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields))+30);
        //Posici??
        text("X:", width/2-25- 30, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        tfCaddPos1.display(width/2-25, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 70, 40);
        text("Y:", width/2-25+70+(200-70-70)-30, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));
        tfCaddPos2.display(width/2-25+70+(200-70-70), (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10), 70, 40);
        text(tfCaddPos1.tipo + ":", width/2-200, (height/2 -(height/3+150)/2-10)+ (2*(((height/2 +(height/3+150)/2 -70 -(80/2)) -(height/2- (height/3+150)/2 +70))/nFields)+10 + 30));

        
      }else if(ejercicio==2){
        
      }  
    }else if(tema == TEMA.DINAMICA){
      if(ejercicio==1){
        
      }else if(ejercicio==2){
        
      }
    }else if(tema == TEMA.OPTICA){
      if(ejercicio==1){
        
      }else if(ejercicio==2){
        
      }
    }else if(tema == TEMA.GRAVITATORI){
      if(ejercicio==1){
        
      }else if(ejercicio==2){
        
      }
    }else if(tema == TEMA.ELECTRIC){
      if(ejercicio==1){
        
      }else if(ejercicio==2){
        
      }
    }else if(tema == TEMA.MEGNETIC){
      if(ejercicio==1){
        
      }else if(ejercicio==2){
        
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
