//Crear los móbiles de el ejercicio de cinemática
void createMobils(int ejercicio){
  if(ejercicio == 1){
    if(objetos == 0){
      m0 = new Mobil(tfCaddName.text, Float.parseFloat(tfCaddPos1.text), Float.parseFloat(tfCaddPos2.text), Float.parseFloat(tfCaddVel.text), paleta[0]);
    }else if(objetos == 1){
      m1 = new Mobil(tfCaddName.text, Float.parseFloat(tfCaddPos1.text), Float.parseFloat(tfCaddPos2.text), Float.parseFloat(tfCaddVel.text), paleta[1]);
      C1vectors = new Vector(m0, m1);
    }
    tfCaddName.resetText();
    tfCaddPos1.resetText();
    tfCaddPos2.resetText();
    tfCaddVel.resetText();
  }
  
}
