// Fitxer amb la informació dels Fonts de l'App
  
// Array de tipografies
PFont[] fonts;
  
// Estableix les fonts de l'App
void setFonts(){
    this.fonts = new PFont[3];
    this.fonts[0] = createFont("fonts/jackinput.TTF", midaTitol); //Título
    this.fonts[1] = createFont("fonts/monofonto.otf", 23); //Subtítulo
    this.fonts[2] = createFont("fonts/Sono-medium.ttf", midaParagraf); //texto
}
  
  PFont getFont(String s){
    if(s.equals("Titulo")){
      return this.fonts[0];
    }else if(s.equals("Subtítulo")){
      return this.fonts[1];
    }else{
      return this.fonts[2];
    }
  }
