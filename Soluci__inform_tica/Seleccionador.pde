class Seleccionador{
  //Botons necessaris
  Button[] opcions;
  // x, y, emplada,...
  float x, y, w, h;
  //Pels botons
  float wBotons;
  int n;
  
  Seleccionador(){
    
  }
  
  void setMides(float x, float y, float w, float h){
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
        this.wBotons = this.w/n;
  }
  
  void setBotons(int n, Button ... p){//Així li passam els botons
    //n és el nombre d'opcions
    opcions = new Button[n];
    this.n = n;
    for(int i=0; i<p.length; i++){
      this.opcions[i] = p[i];
    }
    opcions[0].isSelected= true;
  }
  
  void setSelec(int n){
    for(int i=0; i<opcions.length; i++){
      opcions[i].isSelected = false;
    }
    opcions[n].isSelected= true;
  }
  
  String getSelected(){
    for(int i = 0; i<opcions.length; i++){
      if(opcions[i].isSelected){
        return opcions[i].textBoto;
      }
    }
    return null;
  }
  
  void display(){
    for(int i=0; i<this.opcions.length; i++){
      opcions[i].setMides(this.x+i*wBotons, this.y, wBotons, this.h);
      strokeWeight(5);
      opcions[i].selecUse();
      opcions[i].display();
      //Arreglo
        noStroke();
        if(opcions[i].mouseOverButton()&&!opcions[i].isSelected){
          fill(getColor("BotonPulsado"));
        }else if(opcions[i].isSelected){
          fill(getColor("Seleccionado"));
        }else{
          fill(getColor("BotonSinPulsar"));
        }
        rect(opcions[i].x, opcions[i].y+opcions[i].redondetjat, wBotons, this.h-opcions[i].redondetjat);
        stroke(0); strokeWeight(2); 
        line(opcions[i].x, opcions[i].y+opcions[i].redondetjat, opcions[i].x, opcions[i].y+this.h);
        line(opcions[i].x+wBotons, opcions[i].y+opcions[i].redondetjat, opcions[i].x+wBotons, opcions[i].y+this.h);
        line(opcions[i].x, opcions[i].y+this.h, opcions[i].x+wBotons, opcions[i].y+this.h);
      //Text
        fill(0); textAlign(CENTER); textSize(20);
        text(opcions[i].textBoto, opcions[i].x+wBotons/2, opcions[i].y+this.h/2+ 10);
    }
  }
}
