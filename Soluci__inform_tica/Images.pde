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
    
    this.portadas = new PImage[6];
    portadas[0] = loadImage(URL_IMGS+URL_PORTADAS+"Cinematica.png");
    portadas[1] = loadImage(URL_IMGS+URL_PORTADAS+"Dinamica.png");
    portadas[2] = loadImage(URL_IMGS+URL_PORTADAS+"Optica.png");
    portadas[3] = loadImage(URL_IMGS+URL_PORTADAS+"Gravitatori.png");
    portadas[4] = loadImage(URL_IMGS+URL_PORTADAS+"Electric.png");
    portadas[5] = loadImage(URL_IMGS+URL_PORTADAS+"Magnetic.png");
    
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
