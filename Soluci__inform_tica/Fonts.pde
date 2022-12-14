// Fitxer amb la informació dels Fonts de l'App
  
// Array de tipografies
PFont[] fonts;
  
// Estableix les fonts de l'App
void setFonts(){
    this.fonts = new PFont[3];
    this.fonts[0] = createFont("fonts/jackinput.ttf", midaTitol); //Título
    this.fonts[1] = createFont("fonts/Monocode.ttf", midaSubtitol); //Subtítulo
    this.fonts[2] = createFont("fonts/Sono-medium.TTF", midaParagraf); //texto
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
