//BUTTONS
  //Inici
    Button bCinematica = new Button("CINEMÀTICA");
    Button bDinamica = new Button("DINÀMICA");
    Button bOptica = new Button("ÒPTICA");
    Button bGravitatori = new Button("CAMP GRAVITATÒRI");
    Button bElectric = new Button("CAMP ELÈCTRIC");
    Button bMagnetic = new Button("CAMP MAGNÈTIC");
    
  //Selecció d'exercicis
    Button[] buttonsExercicis = new Button[12];
    //Cienamàtica
      Button bC1 = new Button("CINEMÀTICA 1");
      Button bC2 = new Button("CINEMÀTICA 2");
    //Dinamica
      Button bD1 = new Button("DINÀMICA 1");
      Button bD2 = new Button("DINÀMICA 2");
    //Optica
      Button bO1 = new Button("ÒPTICA 1");
      Button bO2 = new Button("ÒPTICA 2");
    //CAMP GRAVITATORI
      Button bG1 = new Button("CAMP GRAVITATÒRI 1");
      Button bG2 = new Button("CAMP GRAVITATÒRI 2");
    //CAMP ELECTRIC
      Button bE1 = new Button("CAMP ELÈCTRIC 1");
      Button bE2 = new Button("CAMP ELÈCTRIC 2");
    //CAMP MAGNETIC
      Button bM1 = new Button("CAMP MAGNÈTIC 1");
      Button bM2 = new Button("CAMP MAGNÈTIC 2");
    
  
  //Interacció d'exercicis
    //Añadir
      //Enter
        Button bCadd = new Button("Añadir");
        Button bDadd = new Button("Añadir");
        Button bOadd = new Button("Añadir");
        Button bGadd = new Button("Añadir");
        Button bEadd = new Button("Añadir");
        Button bMadd = new Button("Añadir");
      //Leave
        Button bCaddLeave = new Button("Añadir");
        Button bDaddLeave = new Button("Añadir");
        Button bOaddLeave = new Button("Añadir");
        Button bGaddLeave = new Button("Añadir");
        Button bEaddLeave = new Button("Añadir");
        Button bMaddLeave = new Button("Añadir");
      
    //Formulari
      Button[] buttonsFormulari = new Button[6];
    
      Button bCf = new Button("Formulari");
      Button bDf = new Button("Formulari");
      Button bOf = new Button("Formulari");
      Button bGf = new Button("Formulari");
      Button bEf = new Button("Formulari");
      Button bMf = new Button("Formulari");
    
    //Explicació
      Button bCexpli = new Button("Explicar");
      Button bDexpli = new Button("Explicar");
      Button bOexpli = new Button("Explicar");
      Button bGexpli = new Button("Explicar");
      Button bEexpli = new Button("Explicar");
      Button bMexpli = new Button("Explicar");
    
    //Exportar
      Button bCexpor = new Button("Exportar");
      Button bDexpor = new Button("Exportar");
      Button bOexpor = new Button("Exportar");
      Button bGexpor = new Button("Exportar");
      Button bEexpor = new Button("Exportar");
      Button bMexpor = new Button("Exportar");
      
  //Seleccionadors
    //Datos i respuestas
       Button Datos = new Button("Datos");
       Button Respuestas = new Button("Respuestas");
    
    void setButtons(){
      //Exercicis
        buttonsExercicis[0] = bC1;
        buttonsExercicis[1] = bC2;
        buttonsExercicis[2] = bD1;
        buttonsExercicis[3] = bD2;
        buttonsExercicis[4] = bO1;
        buttonsExercicis[5] = bO2;
        buttonsExercicis[6] = bG1;
        buttonsExercicis[7] = bG2;
        buttonsExercicis[8] = bE1;
        buttonsExercicis[9] = bE2;
        buttonsExercicis[10] = bM1;
        buttonsExercicis[11] = bM2;
      //Formularis
        buttonsFormulari[0] = bCf;
        buttonsFormulari[1] = bDf;
        buttonsFormulari[2] = bOf;
        buttonsFormulari[3] = bGf;
        buttonsFormulari[4] = bEf;
        buttonsFormulari[5] = bMf;
    }
    
    
//CARDS
  Card[] cards;
  
  void setCards(){
    cards = new Card[6];
    
    cards[0] = new Card("CINEMÀTICA", 1, bCinematica);
    cards[1] = new Card("DINÀMICA", 2, bDinamica);
    cards[2] = new Card("ÒPTICA", 3, bOptica);
    cards[3] = new Card("CAMP GRAVITATÒRI", 4, bGravitatori);
    cards[4] = new Card("CAMP ELÈCTRIC", 4, bElectric);
    cards[5] = new Card("CAMP MAGNÈTIC", 5, bMagnetic);
  }
  
//Selecionadors
  Seleccionador s1 = new Seleccionador(); 
  
  void setSeleccionador(){
    s1.setBotons(2, Datos, Respuestas);
    print("arr");
  }
