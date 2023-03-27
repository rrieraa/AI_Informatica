void resetCinematica(){
    objetos = 0;
    m0.reset();
    m1.reset();
    scaleEjercicio = 1;
}
void resetDinamica(){
  objetos = 0;
  c0.reset();
}

void resetOptica(){
  objetos = 0;
  l.reset();
}

void resetCampoGravitatorio(){
  objetos = 0;
  CG.reset();
}

void resetCampoElectrico(){
  objetos = 1;
  P.reset();
}
