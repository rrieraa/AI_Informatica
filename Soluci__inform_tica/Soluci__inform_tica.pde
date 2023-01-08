
void setup(){
  fullScreen();
  textAlign(CENTER);
  setColors(); setFonts();
  setCards(); setButtons();setSeleccionador();setTaules(); setDesktop();
  setMedias();
}

void draw(){
  //Background
  background.resize(width, height);
  image(background, 0, 0);
  seleccionaPantalla(Pantalla);
}

/*DEMANAR:
  -Alinear Text
  -Alinear text fins el text Field
*/
