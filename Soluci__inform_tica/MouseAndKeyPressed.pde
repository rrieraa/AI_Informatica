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
        createMobils(exercici);
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
      else if(bEXPLICACION.mouseOverButton()&& !s1.getSelected().equals("Datos")){
        Pantalla = PANTALLA.EXPLICACION;
      }
    //Formulari
      else if(bFORMULARIO.mouseOverButton()){
        Pantalla = PANTALLA.FORMULARI;
      }
    //INTERACIÓN CON EL EJERCICIO:
      InteraccionEjercicio(tema, exercici);
      
    
  
}
void InteraccionEjercicio(TEMA tema, int ejercicio){
  pushStyle();
  if(tema == TEMA.CINEMATICA){
      if(ejercicio==1){
        if(bzoomMas.mouseOverButton()){
          scaleEjercicio-=1;
        }else if(bzoomMenos.mouseOverButton()){
          scaleEjercicio+=1;
        }
        
        //TextFields:
           tfCaddName.isPressed();
           tfCaddPos1.isPressed(); tfCaddPos2.isPressed();
           tfCaddVel.isPressed();
        
      }else if(ejercicio==2){
        if(bDerecha.mouseOverButton()){
          scaleEjercicio+=1;
        }else if(bIzquierda.mouseOverButton()&&scaleEjercicio>0){
          scaleEjercicio-=1;
        }
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

void checkBotonsFormulariOExplicacion(){
  PantallaPrevia = PANTALLA.EXERCICI;
}

void keyPressed() {
   tfCaddName.keyPressed(key, (int)keyCode);
   tfCaddPos1.keyPressed(key, (int)keyCode); tfCaddPos2.keyPressed(key, (int)keyCode);
   tfCaddVel.keyPressed(key, (int)keyCode);
}
