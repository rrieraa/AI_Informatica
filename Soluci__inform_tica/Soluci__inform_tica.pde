//Librarias
import processing.pdf.*;
import de.bezier.data.sql.*;


void setup() {
  fullScreen();
  textAlign(CENTER);
  setGUI();
}
int shading = 0;
void draw() {
  if (frameCount < 75) {
    
    background.resize(width, height);
    image(background, 0, 0);
    textAlign(CENTER, CENTER); 
    textFont(fonts[0]); 
    textSize(120); 
    fill(shading);
    text("FísicAprobada", width/2, height/2);
    shading+=1.2;
  } else {
    noTint();
    //Background
    background.resize(width, height);
    image(background, 0, 0);
    seleccionaPantalla(Pantalla);
  }

  
}
