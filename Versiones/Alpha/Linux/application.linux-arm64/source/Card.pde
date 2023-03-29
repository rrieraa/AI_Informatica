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
      selectImage();
      textSize(midaSubtitol); textFont(fonts[0]); fill(0);
      text(this.nom, x+wCard/2, y);
      //Se muestran las estrellas
      displayStars(estrelles, x, y-20);
      this.boto.setMides(x, y+100, wCard, 250); this.boto.DisplayWithImage(this.image, 255);
    popStyle();
  }
  void displayStars(int e, float x, float y){
    //Se redimensionan al tamaño deseado
    stars[e-1].resize((int)wCard, 95);
    image(stars[e-1], x, y+30);
  }
  void selectImage(){
    if(this.tema == TEMA.CINEMATICA){
      this.nom = "Cinemática";
      this.image = portadas[0];
    }else if(this.tema == TEMA.DINAMICA){
      this.nom = "Dinámica";
      this.image = portadas[1];
    }else if(this.tema == TEMA.OPTICA){
      this.nom = "Óptica";
      this.image = portadas[2];
    }else if(this.tema == TEMA.GRAVITATORI){
      this.nom = "Gravitatorio";
      this.image = portadas[3];
    }else if(this.tema == TEMA.ELECTRIC){
      this.nom = "Electrico";
      this.image = portadas[4];
    }else if(this.tema == TEMA.MEGNETIC){
      this.nom = "Magnético";
      this.image = portadas[5];
    }
  }
}
