//Librarias
import processing.pdf.*;
import de.bezier.data.sql.*;


void setup(){
  fullScreen();
  textAlign(CENTER);
  setColors(); setFonts();
  setCards(); setButtons();setSeleccionador();setTaules(); setDesktop(); setTFnumbers();
  setMedias(); setBBDD();
  createGraphicsPDF();
}

void draw(){
  //Background
  background.resize(width, height);
  image(background, 0, 0);
  seleccionaPantalla(Pantalla);
}
