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
       if(Pantalla == PANTALLA.EXERCICI){
         if(tema == TEMA.CINEMATICA){
           resetCinematica();
         }else if(tema == TEMA.DINAMICA){
           resetDinamica();
         }else if(tema == TEMA.OPTICA){
           resetOptica();
         }else if(tema == TEMA.GRAVITATORI){
           resetCampoGravitatorio();
         }
       }
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
      exercici = i%2 == 0 ? 1: 2;
      Pantalla = PANTALLA.EXERCICI;
      PantallaPrevia = PANTALLA.SELECCIO;
    }
  }
}

void checkBotonsExercici(){
  PantallaPrevia = PANTALLA.SELECCIO;
  //Selecció Enunciado/respuestas
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
      }else if(bADDLeave.mouseOverButton() && bADDLeave.enabled == true && canAdd){
        currentState = ESTADO.EJERCICIO;
        bADDLeave.enabled = false;
        if(tema == TEMA.CINEMATICA){
          if(exercici == 1){
            createMobilsC1();
            objetos++;
          }else if(exercici == 2){
            createMobilC2();
            objetos++;
          }
        }else if(tema == TEMA.DINAMICA){
          if(exercici == 1){
            createCajasD1();
            objetos ++;
          }else if(exercici == 2){
            createCajaD2();
            objetos ++;
          }
        }else if(tema == TEMA.OPTICA){
          if(exercici == 1){
            createLuzO1();
            objetos ++;
          }else if(exercici == 2){
            createLuzO2();
            objetos ++;
          }
        }else if(tema == TEMA.GRAVITATORI){
          if(exercici == 1){
            createCampoGravitatorioG1();
            objetos++;
          }else if(exercici == 2){
            createCampoGravitatorioG2();
            objetos++;
          }
        }else if(tema == TEMA.ELECTRIC){
          if(exercici == 1){
            createCampoElectrico1();
            objetos++;
          }
          
        }
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
        exportarC1();
      }
    //Explicación
      else if(bEXPLICACION.mouseOverButton()&& !s1.getSelected().equals("Enunciado")){
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
        //TextFields:
           tfCaddName.isPressed();
           tfCaddHigh.isPressed();
           tfCaddAngle.isPressed();
           tfCaddVel.isPressed();
      }  
    }else if(tema == TEMA.DINAMICA){
      if(ejercicio==1){
        tfDaddMasa.isPressed();
        tfCaddAngle.isPressed();
      }else if(ejercicio==2){
        tfDaddMasa.isPressed();
        tfDaddF.isPressed();
        tfDaddNu.isPressed();
      }
    }else if(tema == TEMA.OPTICA){
      if(ejercicio==1){
        tfOXobs.isPressed();
        tfOXabeja.isPressed();
        tfOYabeja.isPressed();
      }else if(ejercicio==2){
        tfOAngulo.isPressed();
        tfOn1.isPressed();
        tfOn2.isPressed();
      }
    }else if(tema == TEMA.GRAVITATORI){
      if(ejercicio==1){
        tfGm1.isPressed();
        tfGm2.isPressed();
        tfGDistancias.isPressed();
      }else if(ejercicio==2){
        tfGr1.isPressed();
        tfGr2.isPressed();
        tfGv1.isPressed();
      }
    }else if(tema == TEMA.ELECTRIC){
      if(ejercicio==1){
        tfEc1.isPressed();
        tfEc2.isPressed();
        tfGDistancias.isPressed();
      }else if(ejercicio==2){
        tfEV.isPressed();
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
  if(tema == TEMA.CINEMATICA){
    tfCaddName.keyPressed(key, (int)keyCode);
    tfCaddVel.keyPressed(key, (int)keyCode);
    if(exercici == 1){
      tfCaddPos1.keyPressed(key, (int)keyCode); tfCaddPos2.keyPressed(key, (int)keyCode);
    }else if(exercici == 2){
      tfCaddHigh.keyPressed(key, (int)keyCode);
      tfCaddAngle.keyPressed(key, (int)keyCode);
    }
  }else if(tema == TEMA.DINAMICA){
    if(exercici == 1){
      tfDaddMasa.keyPressed(key, (int)keyCode);
      tfCaddAngle.keyPressed(key, (int)keyCode);
    }else if(exercici == 2){
      tfDaddMasa.keyPressed(key, (int)keyCode);
      tfDaddF.keyPressed(key, (int)keyCode);
      tfDaddNu.keyPressed(key, (int)keyCode);
    }
  }else if(tema == TEMA.OPTICA){
    if(exercici == 1){
      tfOXobs.keyPressed(key, (int)keyCode);
      tfOXabeja.keyPressed(key, (int)keyCode);
      tfOYabeja.keyPressed(key, (int)keyCode);
    }else if(exercici == 2){
      tfOAngulo.keyPressed(key, (int)keyCode);
      tfOn1.keyPressed(key, (int)keyCode);
      tfOn2.keyPressed(key, (int)keyCode);
    }
  }else if(tema == TEMA.GRAVITATORI){
    if(exercici == 1){
      tfGm1.keyPressed(key, (int)keyCode);
      tfGm2.keyPressed(key, (int)keyCode);
      tfGDistancias.keyPressed(key, (int)keyCode);
    }else if(exercici == 2){
      tfGr1.keyPressed(key, (int)keyCode);
      tfGr2.keyPressed(key, (int)keyCode);
      tfGv1.keyPressed(key, (int)keyCode);
    }
  }else if(tema == TEMA.ELECTRIC){
    if(exercici == 1){
      tfEc1.keyPressed(key, (int)keyCode);
      tfEc2.keyPressed(key, (int)keyCode);
      tfGDistancias.keyPressed(key, (int)keyCode);
    }else if(exercici == 2){
      tfEV.keyPressed(key, (int)keyCode);
    }
  }
   
}
