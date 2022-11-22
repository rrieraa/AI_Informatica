PANTALLA Pantalla = PANTALLA.INICI;
void setup(){
  fullScreen();
  textAlign(CENTER);
  setColors(); setFonts();
  setCards(); setButtons();setSeleccionador();
  setMedias();
}

void draw(){
  background(getColor("Fondo"));
  seleccionaPantalla(Pantalla);
}
