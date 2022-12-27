void calcularExerciciCinematica1(){
  float t=0;
  float dist = dist(m0.p.x, m0.p.y, m1.p.x, m1.p.y);
  print(" DIST:"+ dist);
  //Se calcula el momento donde se xocarán
  t =(dist/(m0.vel+m1.vel));
  
  // se calcula la posición donde se encuentran:
  //float componentX = dist(C1vectors.f1.);
  //float xInter = m1.x + *t;
  float yInter = m1.p.y + C1vectors.f1.cy*t;
  print("t:"+ t);
  //print(" X:"+xInter +", Y:"+ yInter);
  
  
}
