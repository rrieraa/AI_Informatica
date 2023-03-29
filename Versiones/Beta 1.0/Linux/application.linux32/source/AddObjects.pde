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

void createMobilC2() {
  if (objetos == 0) {
    m0.setValues2(tfCaddName.text, Float.parseFloat(tfCaddVel.text), Float.parseFloat(tfCaddHigh.text), Float.parseFloat(tfCaddAngle.text), paleta[1]);
  }
  tfCaddName.resetText();
  tfCaddHigh.resetText();
  tfCaddAngle.resetText();
  tfCaddVel.resetText();
}

void createCajasD1() {
  if (objetos == 0) {
    c0.setValues1(Float.parseFloat(tfDaddMasa.text), Float.parseFloat(tfCaddAngle.text));
  }
  tfDaddMasa.resetText();
  tfCaddAngle.resetText();
}

void createCajaD2() {
  if (objetos == 0) {
    c0.setValues2(Float.parseFloat(tfDaddMasa.text), Float.parseFloat(tfDaddF.text), Float.parseFloat(tfDaddNu.text));
  }
  tfDaddMasa.resetText();
  tfDaddF.resetText();
  tfDaddNu.resetText();
}

void createLuzO1() {
  if (objetos == 0) {
    l.setValues1(Float.parseFloat(tfOXobs.text), Float.parseFloat(tfOXabeja.text), Float.parseFloat(tfOYabeja.text));
  }
  tfOXobs.resetText();
  tfOXabeja.resetText();
  tfOYabeja.resetText();
}

void createLuzO2() {
  if (objetos == 0) {
    l.setValues2(Float.parseFloat(tfOAngulo.text), Float.parseFloat(tfOn1.text), Float.parseFloat(tfOn2.text));
  }
  tfOAngulo.resetText();
  tfOn1.resetText();
  tfOn2.resetText();
}

void createCampoGravitatorioG1() {
  if (objetos == 0) {
    CG.setValues1(Float.parseFloat(tfGm1.text), Float.parseFloat(tfGm1.text), Float.parseFloat(tfGDistancias.text));
  }
  tfGm1.resetText();
  tfGm2.resetText();
  tfGDistancias.resetText();
}

void createCampoGravitatorioG2() {
  if (objetos == 0) {
    CG.setValues2(Float.parseFloat(tfGr1.text), Float.parseFloat(tfGr2.text), Float.parseFloat(tfGv1.text));
  }
  tfGr1.resetText();
  tfGv1.resetText();
  tfGr2.resetText();
}

void createCampoElectrico1(){
  if(objetos == 0){
    P.setValores1(Float.parseFloat(tfEc1.text), Float.parseFloat(tfEc2.text), Float.parseFloat(tfGDistancias.text));
  }
  tfEc1.resetText();
  tfEc2.resetText();
  tfGDistancias.resetText();
}

void createCampoElectrico2(){
  if(objetos == 0){
    P.setValores2(Float.parseFloat(tfEV.text));
    tfEV.resetText();
  }
}

void createCampoMagnetico1(){
  if(objetos == 0){
    CM.setValues1(Float.parseFloat(tfMI1.text), Float.parseFloat(tfMI2.text), Float.parseFloat(tfGDistancias.text));
  }
  tfMI1.resetText();
  tfGDistancias.resetText();
  tfMI2.resetText();
}

void createCampoMagnetico2(){
  if(objetos == 0){
    CM.setValues2(Float.parseFloat(ftMIntensidad.text), Float.parseFloat(tfMRadio.text));
  }
  ftMIntensidad.resetText();
  tfMRadio.resetText();
}
