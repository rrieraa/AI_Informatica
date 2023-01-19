// Fitxer amb la informació dels Medias de l'App

// URL de la carpeta on hi ha les imatges
String URL_IMGS = "imgs/";
String URL_RATING = "Rating/";
String URL_PORTADAS = "Portadas/";
String URL_EJERCICIOS = "Ejercicios/";


//IMAGES
PImage background;
// Array d'imatges (JPG, PNG, GIF)
PImage[] imgs;

PImage[] stars;

PImage[] portadas;

PImage[] ejercicios;
  
//IMATGES EXERCICIS
PImage monigote, vidrio, ojo;

// Estableix les imatges de l'App
void setMedias(){
  background = loadImage(URL_IMGS+"Background.png");
  
    this.imgs = new PImage[3];
    this.imgs[0] = loadImage(URL_IMGS+"Electron.png"); //Electron
    this.imgs[1] = loadImage(URL_IMGS+"Proton.png"); //Proton
    
    //Iniciar imagen de estrellas
    this.stars = new PImage[5];
    for(int i = 0; i<stars.length; i++){
      int n = i+1;
      this.stars[i] = loadImage(URL_IMGS+URL_RATING+n+".png"); 
    }
    
    this.portadas = new PImage[6];//C:\IB\AI_Informatica\Soluci__inform_tica\data\imgs\Portadas\Ejercicios
    portadas[0] = loadImage(URL_IMGS+URL_PORTADAS+"Cinematica.png");
    portadas[1] = loadImage(URL_IMGS+URL_PORTADAS+"Dinamica.png");
    portadas[2] = loadImage(URL_IMGS+URL_PORTADAS+"Optica.png");
    portadas[3] = loadImage(URL_IMGS+URL_PORTADAS+"Gravitatori.png");
    portadas[4] = loadImage(URL_IMGS+URL_PORTADAS+"Electric.png");
    portadas[5] = loadImage(URL_IMGS+URL_PORTADAS+"Magnetic.png");
    
    ejercicios = new PImage[12];
    ejercicios[0] = loadImage(URL_IMGS+URL_PORTADAS+URL_EJERCICIOS+"C1.png");
    ejercicios[1] = loadImage(URL_IMGS+URL_PORTADAS+URL_EJERCICIOS+"C2.png");
    ejercicios[2] = loadImage(URL_IMGS+URL_PORTADAS+URL_EJERCICIOS+"D1.png");
    ejercicios[3] = loadImage(URL_IMGS+URL_PORTADAS+URL_EJERCICIOS+"D2.png");
    ejercicios[4] = loadImage(URL_IMGS+URL_PORTADAS+URL_EJERCICIOS+"O1.png");
    ejercicios[5] = loadImage(URL_IMGS+URL_PORTADAS+URL_EJERCICIOS+"O2.png");
    ejercicios[6] = loadImage(URL_IMGS+URL_PORTADAS+URL_EJERCICIOS+"G1.png");
    ejercicios[7] = loadImage(URL_IMGS+URL_PORTADAS+URL_EJERCICIOS+"G2.png");
    ejercicios[8] = loadImage(URL_IMGS+URL_PORTADAS+URL_EJERCICIOS+"E1.png");
    ejercicios[9] = loadImage(URL_IMGS+URL_PORTADAS+URL_EJERCICIOS+"E2.png");
    ejercicios[10] = loadImage(URL_IMGS+URL_PORTADAS+URL_EJERCICIOS+"M1.png");
    ejercicios[11] = loadImage(URL_IMGS+URL_PORTADAS+URL_EJERCICIOS+"M2.png");
    
    monigote = loadImage(URL_IMGS+URL_EJERCICIOS+"Monigote.png");
    vidrio = loadImage(URL_IMGS+URL_EJERCICIOS+"Vidrio.png");
    ojo =loadImage(URL_IMGS+URL_EJERCICIOS+"Ojo.png");
}
  
  PImage getImage(String s){
    if(s.equals("Proton")){
      return this.imgs[0];
    }else if(s.equals("Electron")){
      return this.imgs[1];
    }else if(s.equals("Estrella")){
    }
    return loadImage(URL_IMGS+"/red.png");
  }
