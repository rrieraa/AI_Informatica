
void setup(){
  fullScreen();
  textAlign(CENTER);
  setColors(); setFonts();
  setCards(); setButtons();setSeleccionador();setTaules(); setDesktop();
  setMedias();
}

void draw(){
  background(getColor("Fondo"));
  seleccionaPantalla(Pantalla);
}

/*DEMANAR:
  -Alinear Text
  -Alinear text fins el text Field
*/
