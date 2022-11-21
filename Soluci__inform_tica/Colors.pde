// Fitxer amb la informació dels Colors de l'App
  
// Array de colors
color[] colors;
  
// Estableix colors de l'App
void setColors(){
    this.colors = new color[7];
    this.colors[0] = color(#FFFFFF);//Blanco
    this.colors[1] = color(#000000);//Negro
    this.colors[2] = color(#E0E0E0);//Fondo
    this.colors[3] = color(#434343);//Contorno
    this.colors[4] = color(#ADADAD);//Botón sin pulsar
    this.colors[5] = color(#959595);//Botón pulsado
    this.colors[6] = color(#7a7979);//Botón seleccionado
}
  
  
  color getColor(String s){
    if(s.equals("Blanco")){
      return this.colors[0];
    }else if(s.equals("Negro")){
      return this.colors[1];
    }else if(s.equals("Fondo")){
      return this.colors[2];
    }else if(s.equals("Contorno")){
      return this.colors[3];
    }else if(s.equals("BotonSinPulsar")){
      return this.colors[4];
    }else if(s.equals("BotonPulsado")){
      return this.colors[5];
    }else if(s.equals("Seleccionado")){
      return this.colors[6];
    }
    return color(255, 0, 0);
  }
