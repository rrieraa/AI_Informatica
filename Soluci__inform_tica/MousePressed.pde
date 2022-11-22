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
  for(int i = 0; i<buttonsFormulari.length; i++){
    if(buttonsFormulari[i].mouseOverButton()){
      Pantalla = PANTALLA.FORMULARI;
    }
  }
}

void checkBotonsExercici(){
  if(tema == "CINEMÀTICA"&& exercici == 1){
    for(int i=0; i<s1.opcions.length; i++){
      if(s1.opcions[i].mouseOverButton()){
        s1.opcions[i].isSelected = true;
        s1.setSelec(i);
      }
    }
    if(bCadd.mouseOverButton()){
      interaccio = true;
    }else if(bCaddLeave.mouseOverButton()){
      interaccio = false;
    }
  }
}
