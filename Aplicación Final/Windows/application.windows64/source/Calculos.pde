float calcularEjercicioC1(){
  float t;
  float distX = m0.p.x -m1.p.x;
  float distY = m0.p.y -m1.p.y;
  if(distX<0){
    distX = -distX;
  }
  if(distY<0){
    distY = -distY;
  }
  float dist = sqrt((float)(Math.pow(distX, 2) + Math.pow(distY, 2)));
  //Se calcula el momento donde se xocarán
  t =(dist/(m0.vel+m1.vel));
  return t;
}

float calcularEjercicioC2(){
  float x;
  float an = radians(m0.angulo);
  println("a: "+an);
  double a = (-9.81)/2;  double b = (m0.vel*sin(an));  double c = 26;
  double Arriba = -b -Math.sqrt(Math.pow(b, 2) -4*a*c);
  double Abajo = 2*a;
  float t = (float)(Arriba/Abajo);
  println("t:"+Arriba/Abajo);
  x = (m0.vel*cos(an))*t;
  return x;
}
float calcularEjercicioD1(){
  float m2;
  float a = radians(c0.angulo);
  m2 = c0.masa * sin(a);
  return m2;
}

float calcularEjercicioD2(){
  float nu;
  nu = (c0.Fuerza-(c0.masa*9.81*c0.Nu))/(c0.masa);
  return nu;
}

float calcularEjercicioO1(){
  float distX = 2*l.XObsVi -l.xAbeja;
  float distY = l.yAbeja;
  return sqrt((distX)*(distX) + (distY)*(distY));
}

float calcularEjercicioO2(){
  float A1, A2, res;
  float a = radians(l.angulo);
  A1 = (float)Math.toDegrees(Math.asin((1/l.n1)*sin(a)));
  println("Angulo: " + Math.toDegrees(Math.asin(0.5)));
  println(A1);
  A2 = (float)Math.toDegrees(Math.asin((1/l.n2)*sin(a)));
  res = abs(A1-A2);
  return res;
}

float calcularEjercicioG1(){
  float a = (float)(6.67*Math.pow(10, -11))*CG.m1 * CG.m2;
  float b = (float)(Math.pow(CG.distancia * 1000, 2));
  return a/b;
}

float calcularEjercicioG2(){
  float v = (CG.rp*(float)Math.pow(10,3) * CG.vp)/(CG.ra*(float)Math.pow(10,3));
  return v;
}

float calcularEjercicioE1(){
  float F;
  float a = (float)(9*Math.pow(10, 9) * P.c1/1000000000 * P.c2/1000000000);
  float b = (float) (Math.pow(P.distancia/1000, 2));
  F = a/b;
  return F;
}

float calcularEjercicioE2(){
  float a = 1.6* (float)Math.pow(10,-19) * P.V;
  float b = 9.81* 9.31 * (float)Math.pow(10, -31);
  return a/b;
}

float calcularEjercicioM1(){
  float a =  4*PI*(float)Math.pow(10,-7) * CM.I1 * CM.I2;
  float b = 2*PI*CM.distancia*(float)Math.pow(10,-4);
  return a/b;
}

float calcularEjercicioM2(){
  float a =  4*PI* (float)Math.pow(10,-7) * CM.I1;
  float b = 2*CM.distancia*(float)Math.pow(10,-3);
  return a/b;
}
