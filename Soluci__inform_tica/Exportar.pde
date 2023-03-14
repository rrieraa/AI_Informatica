void exportarC1(){
  print("aaaaa");
  pdfC1.beginDraw();
    pushStyle();
      pdfC1.fill(255); pdfC1.noStroke();
      float x = width/6; float y = 0;
      float w = 2*width/3; float h = height;
      pdfC1.rect(width/6, 0, 2*width/3, height);
      pdfC1.fill(0);
      pdfC1.textSize(midaTitol-5); pdfC1.fill(0); pdfC1.textAlign(CENTER);
      pdfC1.text("Explicación choque entre cuerpos", width/2, marginV+25);//titol
      pdfC1.fill(200); pdfC1.noStroke();
      pdfC1.rect(x+ 30 -10, y+marginV+55-10, w-50, 190 ,10);
      pdfC1.textSize(midaSubtitol-2); pdfC1.textAlign(TOP, LEFT); pdfC1.fill(0);
      if(objetos>1){
        pdfC1.text("Enunciado: Dos mobiles, uno situado en la coordenada ("+m0.p.x+", "+m0.p.y+") de un eje de cordenadas cartegianas y otro situado en ("+m1.p.x+", "+m1.p.y+") se mueven en un MRU (que empieza en t=0s) en dirección de chocar. Si la velocidad del primero es "+m0.vel+"m/s y la del segundo es "+m1.vel+",m/s ¿cuándo chocarán?", x+ 30, y+marginV+55, w-60, h-10);
      }else{
        pdfC1.text("Enunciado: Dos mobiles, uno situado en la coordenada (X1, Y1) de un eje de cordenadas cartegianas y otro situado en (X2, Y2) se mueven en un MRU (que empieza en t=0s) en dirección de chocar. Si la velocidad del primero es V1m/s y la del segundo es V2m/2, ¿cuándo chocarán?", x+ 30, y+marginV+55, w-60, h-10);
      }
      //Escrito de resolución
      pdfC1.textSize(midaSubtitol-8);
      pdfC1.text("En primer lugar, se halla la distancia entre los dos móbiles usando el teorema de pitágoras:", x+ 30, y+marginV+55+200, w-50, h-10);
      //Pitagoras:
        pit1.resize(240, 240); pit2.resize(500, 150);
        float xBorde = x+30;
        float yImg1 = y+marginV+55+200 + 100;
        pdfC1.image(pit1, xBorde, yImg1); 
        float x1F1 = xBorde + 240; float x2F1 =x1F1 + 60;
        float yF = yImg1 + 240/2;
        f.changePoints(x1F1, yF, x2F1, yF); f.display(0);
        float xDist = x2F1 + 10;
        pdfC1.textAlign(LEFT, CENTER); pdfC1.textSize(midaParagraf);
        pdfC1.text("Dist = sqrt((Dx)^2 + (Dy)^2   \nDist = sqrt((X2-X1)^2 + (Y2-Y1)^2)",xDist, yF);
        float xImg2 = xDist+ 400;
        pdfC1.image(pit2, xImg2, y+marginV+55+200 + 100 + 45);
      
      pdfC1.textAlign(LEFT, TOP); pdfC1.textSize(midaSubtitol-8); float yText = yF + 240/2; pdfC1.fill(0);
      pdfC1.text("Que los coches choquen significa que su posición es la misma; por lo tanto, igualamos sus ecuaciones de movimiento:", x+ 30, yText, w-50, h-10);
      //Igualación de Ecuaciones:
      pdfC1.textAlign(CENTER, TOP); pdfC1.textSize(midaParagraf+4);
      float xExpr = x+w/2-400; float yExpr = yText + 60;
      pdfC1.text("p1 =p2   \np01+v1*t = p02+v2*t   \n0+v1*t = dist+v2*t \nen modulo: v1*t = dist -v2*t \nt = (dist)/(v1+v2)    \nt = (sqrt((X2-X1)^2 + (Y2-Y1)^2))/(v1+v2)", xExpr, yExpr, 800, 600);
      
      //Substitución:
      if(objetos>1){
        pdfC1.textAlign(LEFT, TOP); pdfC1.textSize(midaSubtitol-8);
        float ySub = yExpr + 180;
        pdfC1.text("Entonces, substituimos en la ecuación:", xBorde, ySub);
        float yRes = ySub+40;
        float Resp = calcularEjercicioC1();
        pdfC1.text("t = (sqrt(("+m1.p.x+"-"+m0.p.x+")^2 + ("+m1.p.y+"-"+m0.p.y+"^2))/("+m0.vel+"+"+m1.vel+") = "+Resp, xExpr, yRes, w, 600);
        pdfC1.text("SOLUCIÓN: Se chocarán cuando hayan passado "+Resp+"s", xBorde, ySub+100);
      }
    pdfC1.dispose();
    pdfC1.endDraw();
}
