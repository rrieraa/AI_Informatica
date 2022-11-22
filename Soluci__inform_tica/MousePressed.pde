void mousePressed(){
  if(Pantalla == PANTALLA.INICI){
    checkBotonsInici();
  }else if(Pantalla == PANTALLA.SELECCIO){
    checkBotonsSeleccio();
  }else if(Pantalla == PANTALLA.EXERCICI){
    checkBotonsExercici();
  }
}

void checkBotonsInici(){
  for(int i = 0; i<cards.length; i++){
    if(cards[i].boto.mouseOverButton()){
    tema = cards[i].nom;
    Pantalla= PANTALLA.SELECCIO;
    } 
  }
}

void checkBotonsSeleccio(){
  for(int i = 0; i<buttonsExercicis.length ; i++){
    if(buttonsExercicis[i].mouseOverButton()){
      exercici = (i%2 +1);
      Pantalla = PANTALLA.EXERCICI;
    }
  }
}

void checkBotonsExercici(){
  //Selecció datos/respuestas
    for(int i=0; i<s1.opcions.length; i++){
      if(s1.opcions[i].mouseOverButton()){
        s1.opcions[i].isSelected = true;
        s1.setSelec(i);
      }
    }
  //Botons:    
    //Añadir
      if(bADD.mouseOverButton()){
        currentState = ESTADO.ANADIR;
      }else if(bADDLeave.mouseOverButton()){
        currentState = ESTADO.EJERCICIO;
      }
    //Exportar
      //Enunciado
      else if(bEXPORT.mouseOverButton()){
        currentState = ESTADO.EXPORTAR;
      }else if(bEXPORTEnu.mouseOverButton()){
        //Iniciar exportacion Enunciado();
        currentState = ESTADO.EJERCICIO;
      }
      //Respuestas
      else if(bEXPORTRes.mouseOverButton()){
        //Iniciar exportacion Respuesas();
        currentState = ESTADO.EJERCICIO;
      }
      //Explicación
      else if(bEXPLICACION.mouseOverButton()){
        Pantalla = PANTALLA.EXPLICACION;
      }
      //Formulari
      else if(bFORMULARIO.mouseOverButton()){
        Pantalla = PANTALLA.FORMULARI;
      }
}
