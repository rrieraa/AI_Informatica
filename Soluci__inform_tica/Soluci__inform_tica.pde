PANTALLA Pantalla = PANTALLA.INICI;
void setup(){
  fullScreen();
  textAlign(CENTER);
  setColors(); setFonts();
  setCards(); setButtons();setSeleccionador();setTaules();
  setMedias();
}

void draw(){
  background(getColor("Fondo"));
  seleccionaPantalla(Pantalla);
}
