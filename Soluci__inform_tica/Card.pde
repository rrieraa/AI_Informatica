class Card{
  
  String nom;
  int estrelles;
  Button boto;
  
  Card(String n, int e, Button b){
    this.nom = n;
    this.estrelles = e;
    this.boto = b;
    
  }
  void display(float x, float y){
    pushStyle();
      textSize(midaSubtitol); //textFont(fonts[2]);
      text(this.nom,x+wCard/2, y);
      displayStars(estrelles, x, y);
      this.boto.setMides(x, y+120, wCard, 250); this.boto.display();
    popStyle();
  }
  void displayStars(int e, float x, float y){ //<>//
    stars[e-1].resize((int)wCard, 95);
    image(stars[e-1], x, y+30);
  }
}
