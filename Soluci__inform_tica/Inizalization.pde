void setDesktop(){
  //Desktop
  desktop = Desktop.getDesktop();
}
//BUTTONS
  //Atrás
    Button bAtras = new Button("Atras");
  //Inici
    //Exercicis
    Button bCinematica = new Button("CINEMÀTICA");
    Button bDinamica = new Button("DINÀMICA");
    Button bOptica = new Button("ÒPTICA");
    Button bGravitatori = new Button("CAMP GRAVITATÒRI");
    Button bElectric = new Button("CAMP ELÈCTRIC");
    Button bMagnetic = new Button("CAMP MAGNÈTIC");
    //Otros
    Button bApp = new Button("Información App");
    Button bFAQs = new Button("FAQs");
    Button bProponer = new Button("Proponer Ejercicio");
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
  
    //Visualització
      //Zoom
        Button bzoomMas = new Button("+");
        Button bzoomMenos = new Button("-");
        
      //Dreta/esquerra
        Button bDerecha = new Button("->");
        Button bIzquierda = new Button ("<-");
    //Añadir
      //Enter
        Button bADD = new Button("Añadir");
        
      //Leave
        Button bADDLeave = new Button("Añadir");
      
    //Formulari
      Button bFORMULARIO = new Button("Formulari");

    //Explicació
      Button bEXPLICACION = new Button("Explicar");

    
    //Exportar
      //Enter
        Button bEXPORT = new Button("Exportar");

      //Enunciat  
        Button bEXPORTEnu = new Button("Enunciado");

      //Resposta
        Button bEXPORTRes = new Button("Respuesta");
      
      
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
    }
    
    
//CARDS
  Card[] cards;
  
  void setCards(){
    cards = new Card[6];
    
    cards[0] = new Card(TEMA.CINEMATICA, 1, bCinematica);
    cards[1] = new Card(TEMA.DINAMICA, 2, bDinamica);
    cards[2] = new Card(TEMA.OPTICA, 3, bOptica);
    cards[3] = new Card(TEMA.GRAVITATORI, 4, bGravitatori);
    cards[4] = new Card(TEMA.ELECTRIC, 4, bElectric);
    cards[5] = new Card(TEMA.MEGNETIC, 5, bMagnetic);
  }
  
//Selecionadors
  Seleccionador s1 = new Seleccionador(); 
  
  void setSeleccionador(){
    s1.setBotons(2, Datos, Respuestas);
  }
  
//TABLES
  //FORMULARIS:
    //Informació:
      //Nombre de files:
        int nCr = 8;
        int nDr = 8;
        int nOr = 8;
        int nGr = 8;
        int nEr = 8;
        int nMr = 8;
      //Nombre columnes:
        int nc = 4;
      //Proportions
        float[] porportions = {15, 32.5, 32.5, 20};
        
      //informació Taules:
        String[] header = {"Variable", "Definición", "Fórmula", "Unidad en SI"};
      
        String[][] infoCt = {{"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""}};
        String[][] infoDt = {{"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""}};
        String[][] infoOt = {{"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""}};
        String[][] infoGt = {{"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""}};
        String[][] infoEt = {{"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""}};
        String[][] infoMt = {{"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""},
                             {"", "", "", ""}};
        
    //Tales
    Table tCfor = new Table(nCr, nc); 
    Table tDfor = new Table(nGr, nc); 
    Table tOfor = new Table(nOr, nc); 
    Table tGfor = new Table(nGr, nc); 
    Table tEfor = new Table(nEr, nc); 
    Table tMfor = new Table(nMr, nc); 
    
  void setTaules(){
    //Proportions
      tCfor.setColumnWidths(porportions);
      tDfor.setColumnWidths(porportions);
      tOfor.setColumnWidths(porportions);
      tGfor.setColumnWidths(porportions);
      tEfor.setColumnWidths(porportions);
      tMfor.setColumnWidths(porportions);
    //Headers
      tCfor.setHeaders(header);
      tDfor.setHeaders(header);
      tOfor.setHeaders(header);
      tGfor.setHeaders(header);
      tEfor.setHeaders(header);
      tMfor.setHeaders(header);
    //Information
      tCfor.setData(infoCt);
      tDfor.setData(infoDt);
      tOfor.setData(infoOt);
      tGfor.setData(infoGt);
      tEfor.setData(infoEt);
      tMfor.setData(infoMt);
  }
  
//TextFields
  //ADD:
    //Cinemática:
      //Nombre
      TextField tfCaddName = new TextField("Nombre");
      //Posición
      TextField tfCaddPos1 = new TextField("Posición");
      TextField tfCaddPos2 = new TextField("Posición");
      //Velocidad
      TextField tfCaddVel = new TextField("Velocitat");
      
//Objetos
  //Mobiles
    Mobil m0;
    Mobil m1;
  //Vectores
    Vector C1vectors;
