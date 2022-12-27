void mousePressed(){
  //Escuchar botones de las pantallas
  if(Pantalla == PANTALLA.INICI){
    checkBotonsInici();
  }else if(Pantalla == PANTALLA.SELECCIO){
    checkBotonsSeleccio();
  }else if(Pantalla == PANTALLA.EXERCICI){
    checkBotonsExercici();
  }else if(Pantalla == PANTALLA.FORMULARI || Pantalla == PANTALLA.EXPLICACION){
    checkBotonsFormulariOExplicacion();
  }
  //Escuchar botón atrás
  if(Pantalla != PANTALLA.INICI){
    checkAtras();
  }
}

void checkAtras(){
   if(bAtras.mouseOverButton()){
     //Se cuelve al ejercicio
     if(currentState==ESTADO.ANADIR || currentState==ESTADO.EXPORTAR){
       currentState=ESTADO.EJERCICIO;
     }
     //Se vuelve a la pantalla anterior
     else{
       Pantalla = PantallaPrevia;
     }
   }
}

void checkBotonsInici(){
  for(int i = 0; i<cards.length; i++){
    if(cards[i].boto.mouseOverButton()){
    tema = cards[i].tema;
    Pantalla= PANTALLA.SELECCIO;
    
    } 
  }
  
  if(bProponer.mouseOverButton()){
    openWebPage("https://forms.gle/ff2SHGXzBjkzugaU6");
  }
  
}

void checkBotonsSeleccio(){
  PantallaPrevia = PANTALLA.INICI;
  for(int i = 0; i<buttonsExercicis.length ; i++){
    if(buttonsExercicis[i].mouseOverButton()){
      exercici = (i%2 +1);
      Pantalla = PANTALLA.EXERCICI;
      PantallaPrevia = PANTALLA.SELECCIO;
    }
  }
}

void checkBotonsExercici(){
  PantallaPrevia = PANTALLA.SELECCIO;
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
        bADDLeave.enabled = true;
      }else if(bADDLeave.mouseOverButton() && bADDLeave.enabled == true){
        currentState = ESTADO.EJERCICIO;
        createMobils();
        objetos++;
        bADDLeave.enabled = false;
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
    //INTERACIÓN CON EL EJERCICIO:
      if(bzoomMas.mouseOverButton()){
        scaleEjercicio-=1;
      }else if(bzoomMenos.mouseOverButton()){
        scaleEjercicio+=1;
      }
    
  //TextFields:
    tfCaddName.isPressed();
    tfCaddPos1.isPressed(); tfCaddPos2.isPressed();
    tfCaddVel.isPressed();
}

void checkBotonsFormulariOExplicacion(){
  PantallaPrevia = PANTALLA.EXERCICI;
}

void keyPressed() {
   tfCaddName.keyPressed(key, (int)keyCode);
   tfCaddPos1.keyPressed(key, (int)keyCode); tfCaddPos2.keyPressed(key, (int)keyCode);
   tfCaddVel.keyPressed(key, (int)keyCode);
}
