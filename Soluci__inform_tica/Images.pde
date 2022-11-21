// Fitxer amb la informació dels Medias de l'App

// URL de la carpeta on hi ha les imatges
String URL_IMGS = "imgs/";

// Array d'imatges (JPG, PNG, GIF)
PImage[] imgs;

PImage[] stars;
  
// Estableix les imatges de l'App
void setMedias(){
    this.imgs = new PImage[3];
    this.imgs[0] = loadImage(URL_IMGS+"Electron.png"); //Electron
    this.imgs[1] = loadImage(URL_IMGS+"Proton.png"); //Proton
    
    this.stars = new PImage[5];
    this.stars[0] = loadImage(URL_IMGS+"Rating/1.png"); //Proton
    this.stars[1] = loadImage(URL_IMGS+"Rating/2.png");
    this.stars[2] = loadImage(URL_IMGS+"Rating/3.png");
    this.stars[3] = loadImage(URL_IMGS+"Rating/4.png");
    this.stars[4] = loadImage(URL_IMGS+"Rating/5.png");
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
