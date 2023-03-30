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
        Button bADD = new Button("Dar Valores");
        
      //Leave
        Button bADDLeave = new Button("Dar Valores");
      //Random Values
        Button bADDRanValues = new Button("Valores Aleatorios");
      
    //Formulari
      Button bFORMULARIO = new Button("Formulari");

    //Explicació
      Button bEXPLICACION = new Button("Explicar");
      
    //Reset
      Button bRESET = new Button("Nuevos valores");

    
    //Exportar
      //Enter
        Button bEXPORT = new Button("Exportar");

      //Enunciat  
        Button bEXPORTEnu = new Button("Enunciado");

      //Resposta
        Button bEXPORTRes = new Button("Respuesta");
      
      
  //Seleccionadors
    //Enunciado i respuestas
       Button Enunciado = new Button("Enunciado");
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
    s1.setBotons(2, Enunciado, Respuestas);
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
        int nc = 3;
      //Proportions
        float[] porportions = {20, 50, 30};
        
      //informació Taules:
        String[] header = {"Variable", "Definición", "Unidad en SI"};
      
        String[][] infoCt = {{"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""}};
        String[][] infoDt = {{"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""}};
        String[][] infoOt = {{"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""}};
        String[][] infoGt = {{"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""}};
        String[][] infoEt = {{"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""}};
        String[][] infoMt = {{"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""},
                             {"", "", ""}};
        
        
    //Talbes
    Table tCfor = new Table(nCr, nc); 
    Table tDfor = new Table(nGr, nc); 
    Table tOfor = new Table(nOr, nc); 
    Table tGfor = new Table(nGr, nc); 
    Table tEfor = new Table(nEr, nc); 
    Table tMfor = new Table(nMr, nc); 
    
    String[] formules = {"Formules"};
    float[] proportionsF = {100};
        String[][] infoCf = {{""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""}};
        String[][] infoDf = {{""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""}};
        String[][] infoOf = {{""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""}};
        String[][] infoGf = {{""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""}};
        String[][] infoEf = {{""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""}};
        String[][] infoMf = {{""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""},
                             {""}};    
                             
     Table fC = new Table(nCr, 1);
     Table fD = new Table(nDr, 1);
     Table fO = new Table(nOr, 1);
     Table fG = new Table(nGr, 1);
     Table fE = new Table(nEr, 1);
     Table fM = new Table(nMr, 1);
    
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
      
    //Proportions
      fC.setColumnWidths(proportionsF);
      fD.setColumnWidths(proportionsF);
      fO.setColumnWidths(proportionsF);
      fG.setColumnWidths(proportionsF);
      fE.setColumnWidths(proportionsF);
      fM.setColumnWidths(proportionsF);

    //Headers
      fC.setHeaders(formules);
      fD.setHeaders(formules);
      fO.setHeaders(formules);
      fG.setHeaders(formules);
      fE.setHeaders(formules);
      fM.setHeaders(formules);
    
    //Information
      fC.setData(infoCf);
      fD.setData(infoDf);
      fO.setData(infoOf);
      fG.setData(infoGf);
      fE.setData(infoEf);
      fM.setData(infoMf);
      
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
      
      //
      TextField tfCaddAngle = new TextField("Ángulo");
      TextField tfCaddHigh = new TextField ("Altura");
      
      TextField tfDaddF = new TextField("Fuerza");
      TextField tfDaddMasa = new TextField("Masa");
      TextField tfDaddNu = new TextField("Nu");
      
      TextField tfOXobs = new TextField("Distancia Obs-V");
      TextField tfOXabeja = new TextField("Distancia 'x' Abeja-Obs");
      TextField tfOYabeja = new TextField("Distancia 'y' Abeja-Obs");
      
      TextField tfOAngulo = new TextField("Ángulo");
      TextField tfOn1 = new TextField("n 1");
      TextField tfOn2 = new TextField("n 2");
      
      TextField tfGm1 = new TextField("Masa Planeta");
      TextField tfGm2 = new TextField("Masa Estrella");
      TextField tfGDistancias = new TextField("Distancia");
      
      TextField tfGr1 = new TextField("Radio Perihelio");
      TextField tfGr2 = new TextField("Radio Afelio");
      TextField tfGv1 = new TextField("Vel. Perihelio");
      
      
      TextField tfEc1 = new TextField("Carga 1");
      TextField tfEc2 = new TextField("Carga 2");
      
      TextField tfEV = new TextField("Diferencia de potencial");
      
      TextField tfMI1 = new TextField("Intensidad 1");
      TextField tfMI2 = new TextField("Intensidad 2");
      
      TextField ftMIntensidad = new TextField("Intensidad");
      TextField tfMRadio = new TextField ("Radio");
      
      
      //Set numerics
      void setTFnumbers(){
        tfCaddPos1.numerical = true;
        tfCaddPos2.numerical = true;
        
        tfCaddVel.numerical = true;
              
        tfCaddAngle.numerical = true;
        tfCaddHigh.numerical = true;
              
        tfDaddF.numerical = true;
        tfDaddMasa.numerical = true;
        tfDaddNu.numerical = true;
              
        tfOXobs.numerical = true;
        tfOXabeja.numerical = true;
        tfOYabeja.numerical = true;
              
        tfOAngulo.numerical = true;
        tfOn1.numerical = true;
        tfOn2.numerical = true;
              
        tfGm1.numerical = true;
        tfGm2.numerical = true;
        tfGDistancias.numerical = true;
              
        tfGr1.numerical = true;
        tfGr2.numerical = true;
        tfGv1.numerical = true;
              
              
        tfEc1.numerical = true;
        tfEc2.numerical = true;
              
        tfEV.numerical = true;
              
        tfMI1.numerical = true;
        tfMI2.numerical = true;
              
        ftMIntensidad.numerical = true;
        tfMRadio.numerical = true;
      }
//Objetos
  //Mobiles
    Mobil m0 = new Mobil();
    Mobil m1 = new Mobil();
  //Cajas
    Caja c0 = new Caja();
    
  //Luz
  Luz l = new Luz();
  
  //Campo Gravitatorio
  CampoGravitatorio CG = new CampoGravitatorio();
  
  //Campo Electrico
  Particula P = new Particula();
  
  //Campo Magnetico
  CampoMagnetico CM = new CampoMagnetico();
  
  //Vectores
    Vector C1vectors;
    
    
//PDFs
PGraphics pdfC1;

void createGraphicsPDF(){
  pushMatrix();
    translate(width/6, 0);
    pdfC1 = createGraphics(2*width/3, height);
  popMatrix();
  
}
