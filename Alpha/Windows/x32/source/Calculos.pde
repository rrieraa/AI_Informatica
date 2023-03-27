float calcularEjercicioC1(){
  float t;
  float dist = dist(m0.p.x, m0.p.y, m1.p.x, m1.p.y);
  //Se calcula el momento donde se xocarán
  t =(dist/(m0.vel+m1.vel));
  return t;
}

float calcularEjercicioC2(){
  float x;
  float a = radians(m0.angulo);
  float t = (-(m0.vel*sin(a))+sqrt(  ( m0.vel*sin(a)*(m0.vel*sin(a) )   )  +(2*9.81*m0.altura)))/(2*m0.altura);
  x = (m0.vel*cos(a))*t;
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
  nu = (c0.Fuerza-(c0.masa*c0.Nu))/(c0.masa*9.81);
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
  A1 = asin((1/l.n1)*sin(a));
  A2 = asin((1/l.n2)*sin(a));
  res = abs(A1-A2);
  return res;
}
