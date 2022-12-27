class Card{
  
  String nom;
  int estrelles;
  Button boto;
  TEMA tema;
  PImage image;
  
  Card(TEMA tema, int e, Button b){
    this.tema = tema;
    this.nom = this.tema.toString();
    this.estrelles = e;
    this.boto = b;
    
  }
  void display(float x, float y){
    pushStyle();
      textSize(midaSubtitol); //textFont(fonts[2]);
      text(this.nom, x+wCard/2, y);
      displayStars(estrelles, x, y-20);
      selectImage();
      this.boto.setMides(x, y+100, wCard, 250); this.boto.DisplayWithImage(this.image);
    popStyle();
  }
  void displayStars(int e, float x, float y){ //<>//
    stars[e-1].resize((int)wCard, 95);
    image(stars[e-1], x, y+30);
  }
  void selectImage(){
    if(this.tema == TEMA.CINEMATICA){
      this.image = portadas[0];
    }else if(this.tema == TEMA.DINAMICA){
      this.image = portadas[1];
    }else if(this.tema == TEMA.OPTICA){
      this.image = portadas[2];
    }else if(this.tema == TEMA.GRAVITATORI){
      this.image = portadas[3];
    }else if(this.tema == TEMA.ELECTRIC){
      this.image = portadas[4];
    }else if(this.tema == TEMA.MEGNETIC){
      this.image = portadas[5];
    }
  }
}
