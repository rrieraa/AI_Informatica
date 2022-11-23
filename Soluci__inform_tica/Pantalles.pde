enum PANTALLA {INICI, SELECCIO, EXERCICI, FORMULARI, EXPLICACION};
//enum EXERCICI {CINEMATICA, DINAMICA, OPTICA, GRAVITATORI, MEGNATIC, ELECTRIC};
String tema; int exercici; 
enum ESTADO {EJERCICIO, ANADIR, EXPORTAR};
ESTADO currentState = ESTADO.EJERCICIO;

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
}


void pantallaInicial(){
  for(int i = 0; i<cards.length+0; i++){
    if(i<cards.length/2){
       cards[i].display((1+2*i)*(width)/6-200, marginV+75);
    }else{
       cards[i].display((-5+2*i)*(width)/6-200, (height/2)+80);
    }
  }
}

void pantallaSeleccio(String tema){
  pushStyle();
    textSize(midaTitol);
    text(tema, width/2, marginV+100);//titol
    if(tema == "CINEMÀTICA"){
      //Exercicis
        bC1.setMides((width/2)-650, 250, 500, 750); bC1.display();
        bC2.setMides(width/2+150, 250, 500, 750); bC2.display();
    }else if(tema == "DINÀMICA"){
      //Exercicis
        bD1.setMides((width/2)-650, 250, 500, 750); bD1.display();
        bD2.setMides(width/2+150, 250, 500, 750); bD2.display();
    }else if(tema == "ÒPTICA"){
      //Exercicis
        bO1.setMides((width/2)-650, 250, 500, 750); bO1.display();
        bO2.setMides(width/2+150, 250, 500, 750); bO2.display();
    }else if(tema == "CAMP GRAVITATÒRI"){
      //Exercicis
        bG1.setMides((width/2)-650, 250, 500, 750); bG1.display();
        bG2.setMides(width/2+150, 250, 500, 750); bG2.display();
    }else if(tema == "CAMP ELÈCTRIC"){
      //Exercicis
        bE1.setMides((width/2)-650, 250, 500, 750); bE1.display();
        bE2.setMides(width/2+150, 250, 500, 750); bE2.display();
    }else if(tema == "CAMP MAGNÈTIC"){
      //Exercicis
        bM1.setMides((width/2)-650, 250, 500, 750); bM1.display();
        bM2.setMides(width/2+150, 250, 500, 750); bM2.display();
    }
  popStyle();
}

void pantallaFormulari(String tema){
  pushStyle();
    if(tema == "CINEMÀTICA"){
      text("Formulari Cinemàtica", width/2, 100);
      tCfor.display(width/6, height/6, 4*width/6, 4*height/6);
    }else if(tema == "DINÀMICA"){
      text("Formulari Dinàmica", width/2, height/2);
    }else if(tema == "ÒPTICA"){
      text("Formulari Optica", width/2, height/2);
    }else if(tema == "CAMP GRAVITATÒRI"){
      text("Formulari Gravitatori", width/2, height/2);
    }else if(tema == "CAMP ELÈCTRIC"){
      text("Formulari Elèctric", width/2, height/2);
    }else if(tema == "CAMP MAGNÈTIC"){
      text("Formulari Magnètic", width/2, height/2);
    }
  popStyle();  
}
void pantallaExplicacion(String tema, int ejercicio){
    if(tema == "CINEMÀTICA"){
      if(ejercicio==1){
        text("Explicacion Cinemàtica 1", width/2, height/2);
      }else if(ejercicio==2){
        text("Explicacion Cinemàtica 2", width/2, height/2);
      }  
    }else if(tema == "DINÀMICA"){
      if(ejercicio==1){
        text("Explicacion Dinamica 1", width/2, height/2);
      }else if(ejercicio==2){
        text("Explicacion Dinamica 2", width/2, height/2);
      }
    }else if(tema == "ÒPTICA"){
      if(ejercicio==1){
        text("Explicacion Optica 1", width/2, height/2);
      }else if(ejercicio==2){
        text("Explicacion Optica 2", width/2, height/2);
      }
    }else if(tema == "CAMP GRAVITATÒRI"){
      if(ejercicio==1){
        text("Explicacion Campo Gravitatorio 1", width/2, height/2);
      }else if(ejercicio==2){
        text("Explicacion Campo Gravitatorio 2", width/2, height/2);
      }
    }else if(tema == "CAMP ELÈCTRIC"){
      if(ejercicio==1){
        text("Explicacion Campo Electrico 1", width/2, height/2);
      }else if(ejercicio==2){
        text("Explicacion Campo Electrico 2", width/2, height/2);
      }
    }else if(tema == "CAMP MAGNÈTIC"){
      if(ejercicio==1){
        text("Explicacion Campo Magnetico 1", width/2, height/2);
      }else if(ejercicio==2){
        text("Explicacion Campo Magnetico 2", width/2, height/2);
      }
    }
}

void pantallaExercicis(String tema, int exercici){
  pushStyle();
    drawExercici();
    displayExercici();
  popStyle();
}

void drawExercici(){
   //Titol
      textSize(midaTitol);
      text("CINEMÀTICA: Intersecció entre mòbils", width/2, marginV+100);
      //Visualització d'exercici
      rect(marginH+100, height/3-70, 900, 600); 
      fill(0);textSize(midaSubtitol);
      text("Visualització d'exercici", marginH+100+900/2, height/3-70+600/2);
      //Selecció
      s1.setMides(marginH+100+ 900 +200 ,height/3-70, width-2*(marginH+100)-900-200, 60); s1.display();
      if(s1.getSelected().equals("Datos")){
        fill(255, 0, 0);
        rect(marginH+100+ 900 +200 ,height/3-70+60, width-2*(marginH+100)-900-200, 600-60);
        fill(0);textSize(midaParagraf);
        text("enunciat \n dades: \n- \n- \n-", marginH+100+ 900 +200+ 40, height/3-70+60+20);
      }else{
        fill(0, 255, 0);
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
          drawAdd();
        }else if(currentState == ESTADO.EXPORTAR){
          drawExport();
        }        
}

void displayExercici(){
  //Aquí mostraré per pantalla l'exercici
}
void drawAdd(){
  pushStyle();
    fill(getColor("Fondo"));
    rectMode(CENTER); textAlign(CENTER); textSize(midaSubtitol+15);
    rect(width/2, height/2, width/3+150, height/3+150);
    fill(0);
    text("Añadir",width/2, height/2- (height/3+150)/2 +70);
    rectMode(CORNER);
    bADDLeave.setMides(width/2 -(200/2), height/2 +(height/3+150)/2 -70 -(80/2), 200, 80); bADDLeave.display();
    //DisplayAddInformation(tema, erecici); serà per cada una distinta.
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
