enum PANTALLA {INICI, SELECCIO, EXERCICI, FORMULARI, AFERGIR, EXPORTAR};
//enum EXERCICI {CINEMATICA, DINAMICA, OPTICA, GRAVITATORI, MEGNATIC, ELECTRIC};
String tema; int exercici;

void seleccionaPantalla(PANTALLA p){
  if(p==PANTALLA.INICI){
    pantallaInicial();
  }else if(p==PANTALLA.SELECCIO){
    pantallaSeleccio(tema);
  }else if(p==PANTALLA.FORMULARI){
    pantallaFormulari(tema);
  }else if(p==PANTALLA.EXERCICI){
    pantallaExercicis(tema, exercici);
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
        bD1.setMides((width/2)-650, 250, 500, 640); bD1.display();
        bD2.setMides(width/2+150, 250, 500, 640); bD2.display();
      //Formularis
        bDf.setMides(width/2-250, height-160, 500, 100); bDf.display();
    }else if(tema == "ÒPTICA"){
      //Exercicis
        bO1.setMides((width/2)-650, 250, 500, 640); bO1.display();
        bO2.setMides(width/2+150, 250, 500, 640); bO2.display();
      //Formularis
        bOf.setMides(width/2-125, height-160, 250, 100); bOf.display();
    }else if(tema == "CAMP GRAVITATÒRI"){
      //Exercicis
        bG1.setMides((width/2)-650, 250, 500, 640); bG1.display();
        bG2.setMides(width/2+150, 250, 500, 640); bG2.display();
      //Formularis
        bGf.setMides(width/2-125, height-160, 250, 100); bGf.display();
    }else if(tema == "CAMP ELÈCTRIC"){
      //Exercicis
        bE1.setMides((width/2)-650, 250, 500, 640); bE1.display();
        bE2.setMides(width/2+150, 250, 500, 640); bE2.display();
      //Formularis
        bEf.setMides(width/2-125, height-160, 250, 100); bEf.display();
    }else if(tema == "CAMP MAGNÈTIC"){
      //Exercicis
        bM1.setMides((width/2)-650, 250, 500, 640); bM1.display();
        bM2.setMides(width/2+150, 250, 500, 640); bM2.display();
      //Formularis
        bMf.setMides(width/2-125, height-160, 250, 100); bMf.display();
    }
  popStyle();
}

void pantallaFormulari(String tema){
  pushStyle();
    if(tema == "CINEMÀTICA"){
      text("Formulari Cinemàtica", width/2, height/2);
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

void pantallaExercicis(String tema, int exercici){
  pushStyle();
    if(tema == "CINEMÀTICA"){
      exercicisCienamatica(exercici);
    }else if(tema == "DINÀMICA"){
      exercicisDinamica(exercici);
    }else if(tema == "ÒPTICA"){
      exercicisOptica(exercici);
    }else if(tema == "CAMP GRAVITATÒRI"){
      exercicisGravitatori(exercici);
    }else if(tema == "CAMP ELÈCTRIC"){
      exercicisElectric(exercici);
    }else if(tema == "CAMP MAGNÈTIC"){
      exercicisMagnetic(exercici);
    }
  popStyle();
}

void exercicisCienamatica(int exercici){
  pushStyle();
    if(exercici == 1){
      //Titol
      textSize(midaTitol);
      text("CINEMÀTICA: Intersecció entre mòbils", width/2, marginV+100);
      //Visualització d'exercici
      rect(marginH+100, height/3-70, 900, 600); 
      fill(0);textSize(midaSubtitol);
      text("Visualització d'exercici", marginH+100+900/2, height/3-70+600/2);
      //Selecc
      s1.setMides(marginH+100+ 900 +200 ,height/3-70, width-2*(marginH+100)-900-200, 60); s1.display();
      if(s1.getSelected().equals("Datos")){
        fill(255, 0, 0);
      }else{
        fill(0, 255, 0);
      }
      
      //Dades i respostes
      rect(marginH+100+ 900 +200 ,height/3-70+60, width-2*(marginH+100)-900-200, 600-60);
      fill(0);textSize(midaParagraf);
      text("enunciat \n dades: \n- \n- \n-", marginH+100+ 900 +200+ 40, height/3-70+60+20);
      
      //Añadir
      bCadd.setMides(marginH+100+ 900 +200 ,height/3-70+60+ (600-60) + 50, width-2*(marginH+100)-900-200, 80); bCadd.display();

      
      fill(255);
      rect(marginH+100 ,height/3-70+60+ (600-60) + 50, width-2*(marginH+100)-900-200, 80);
      fill(0);textSize(midaSubtitol);
      text("formulari", (marginH+100)+ (width-2*(marginH+100)-900-200)/2, (height/3-70+60+ (600-60) + 50)+ (80)/2);
      fill(255);
      rect(marginH+100 + 900- (width-2*(marginH+100)-900-200) ,height/3-70+60+ (600-60) + 50, width-2*(marginH+100)-900-200, 80);
      fill(0);textSize(midaSubtitol);
      text("exportar", (marginH+100 + 900- (width-2*(marginH+100)-900-200))+ ( width-2*(marginH+100)-900-200)/2, (height/3-70+60+ (600-60) + 50)+ (80)/2);
      
    }else if(exercici == 2){
      text("exercici 2", width/2, height/2);
    }else{
      drawPantallaError();
    }
  popStyle();
}

void exercicisDinamica(int exercici){
  pushStyle();
    if(exercici == 1){
      text("exercici 1", width/2, height/2);
    }else if(exercici == 2){
      text("exercici 2", width/2, height/2);
    }else{
      drawPantallaError();
    }
  popStyle();
}

void exercicisOptica(int exercici){
  pushStyle();
    if(exercici == 1){
      text("exercici 1", width/2, height/2);
    }else if(exercici == 2){
      text("exercici 2", width/2, height/2);
    }else{
      drawPantallaError();
    }
  popStyle();
}

void exercicisGravitatori(int exercici){
  pushStyle();
    if(exercici == 1){
      text("exercici 1", width/2, height/2);
    }else if(exercici == 2){
      text("exercici 2", width/2, height/2);
    }else{
      drawPantallaError();
    }
  popStyle();
}

void exercicisMagnetic(int exercici){
  pushStyle();
    if(exercici == 1){
      text("exercici 1", width/2, height/2);
    }else if(exercici == 2){
      text("exercici 2", width/2, height/2);
    }else{
      drawPantallaError();
    }
  popStyle();
}

void exercicisElectric(int exercici){
  pushStyle();
    if(exercici == 1){
      text("exercici 1", width/2, height/2);
    }else if(exercici == 2){
      text("exercici 2", width/2, height/2);
    }else{
      drawPantallaError();
    }
  popStyle();
}

void drawPantallaError(){
  pushStyle();
    fill(255, 0, 0);
    rect(0, 0, width, height);
  popStyle();
}
