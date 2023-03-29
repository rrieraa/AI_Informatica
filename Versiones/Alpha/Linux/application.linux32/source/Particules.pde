class Particula{
  //Atributos Especificos
  float carrega;
  String nom;
  
  Particula(String n, float c){
    this.nom = n;
    this.carrega = c;
  }
  
  void display(){
    noStroke();
    if(this.carrega<0){
      fill(paleta[3]);
    }else if(this.carrega>0){
      fill(paleta[2]);
    }
    circle(0, 0, 50);
  }
}

class Particules{
  //Atributos especificos
  float carrega1, carrega2;
  String n1, n2;
  
  Particules(String n1, float c1, String n2, float c2){
    
    this.carrega1 = c1;
    this.carrega2 = c2;
    this.n1 = n1;
    this.n2 = n2;
  }
  void display(float w){
    noStroke();
    if (carrega1<0){
      fill(paleta[3]);
    }else if (carrega1>0){
      fill(paleta[2]);
    }
    circle(w/5, 0, 200);
    
    if (carrega2<0){
      fill(paleta[3]);
    }else if (carrega2>0){
      fill(paleta[2]);
    }
    circle(-w/5, 0, 200);
  }
}
