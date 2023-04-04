//Librarias
import processing.pdf.*;
import de.bezier.data.sql.*;


void setup(){
  fullScreen();
  textAlign(CENTER);
  setColors(); setFonts();setBBDD();
  setCards(); setButtons();setSeleccionador();setFormulasTable();setFormularis();setTaules(); setDesktop(); setTFnumbers();
  setMedias(); 
  createGraphicsPDF();
}

void draw(){
  if(frameCount < 75){
    background.resize(width, height);
    image(background, 0, 0);
    textAlign(CENTER, CENTER); textFont(fonts[0]); textSize(120); fill(0);
    text("FísicAprobada", width/2, height/2);
  }else{
    noTint();
    //Background
    background.resize(width, height);
    image(background, 0, 0);
    seleccionaPantalla(Pantalla);
  }
}
