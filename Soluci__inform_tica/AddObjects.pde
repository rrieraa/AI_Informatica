//Crear los móbiles de el ejercicio de cinemática
void createMobilsC1() {
  if (objetos == 0) {
    m0.setValues1(tfCaddName.text, Float.parseFloat(tfCaddPos1.text), Float.parseFloat(tfCaddPos2.text), Float.parseFloat(tfCaddVel.text), paleta[0]);
  } else if (objetos == 1) {
    m1.setValues1(tfCaddName.text, Float.parseFloat(tfCaddPos1.text), Float.parseFloat(tfCaddPos2.text), Float.parseFloat(tfCaddVel.text), paleta[1]);
    C1vectors = new Vector(m0, m1);
  }
  tfCaddName.resetText();
  tfCaddPos1.resetText();
  tfCaddPos2.resetText();
  tfCaddVel.resetText();
}

void createMobilC2(){
  if (objetos == 0) {
    m0.setValues2(tfCaddName.text, Float.parseFloat(tfCaddVel.text),Float.parseFloat(tfCaddHigh.text), Float.parseFloat(tfCaddAngle.text), paleta[1]);
  }
  tfCaddName.resetText();
  tfCaddHigh.resetText();
  tfCaddAngle.resetText();
  tfCaddVel.resetText();
}

void createCajasD1(){
  if(objetos == 0){
    c0.setValues1(Float.parseFloat(tfDaddMasa.text), Float.parseFloat(tfCaddAngle.text));
  }
  tfDaddMasa.resetText();
  tfCaddAngle.resetText();
}

void createCajaD2(){
  if(objetos == 0){
    c0.setValues2(Float.parseFloat(tfDaddMasa.text), Float.parseFloat(tfDaddF.text), Float.parseFloat(tfDaddNu.text));
  }
  tfDaddMasa.resetText();
  tfDaddF.resetText();
  tfDaddNu.resetText();
}

void createLuzO1(){
  if(objetos == 0){
    l.setValues1(Float.parseFloat(tfOXobs.text), Float.parseFloat(tfOXabeja.text), Float.parseFloat(tfOYabeja.text));
  }
  tfOXobs.resetText();
  tfOXabeja.resetText();
  tfOYabeja.resetText();
}

void createLuzO2(){
  if(objetos == 0){
    l.setValues2(Float.parseFloat(tfOAngulo.text), Float.parseFloat(tfOn1.text), Float.parseFloat(tfOn2.text));
  }
  tfOAngulo.resetText();
  tfOn1.resetText();
  tfOn2.resetText();
}
