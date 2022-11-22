// Classe Botó

class Button {
  
 // Propietats d'un botó:
 float x, y, w, h;  // Posició i dimensions 
 String textBoto;  // Text
 boolean enabled;  // Abilitat / desabilitat
 boolean text = true;
 boolean isSelected = false;
 float redondetjat = 10;
 
 
 // Mètode Constructor
 Button(String text){
   this.textBoto = text;
   this.enabled = true;
 }
 
 // Setters
 
 void setMides(float x, float y, float w, float h){
   this.x = x;
   this.y = y;
   this.w = w;
   this.h = h;
 }
 void selecUse(){
   redondetjat = 35;
 }
 
 // Dibuixa el botó
 void display(){
   pushStyle();
     if(mouseOverButton()&&!isSelected){
       fill(getColor("BotonPulsado"));      // Color quan ratolí a sobre
     }
     else if(isSelected){
       fill(getColor("Seleccionado"));          // Color actiu però ratolí fora
     }else{
       fill(getColor("BotonSinPulsar"));
     }
     stroke(0); strokeWeight(2);        //Color i gruixa del contorn
     rect(this.x, this.y, this.w, this.h, redondetjat);   // Rectangle del botó
  
     
     // Icona del botó
     //imageMode(CENTER);
     //image(icona, this.x, this.y, this.s, this.s);
     
     // Text (color, alineació i mida)
     if(text){
       fill(0); textAlign(CENTER); textSize(20);
       text(textBoto, this.x + this.w/2, this.y + this.h/2 + 10);
     }
   popStyle();
 }
 
 // Indica si el cursor està sobre el botó
 boolean mouseOverButton(){
   return (mouseX >= this.x) && 
          (mouseX<=this.x + this.w) && 
          (mouseY>= this.y) && 
          (mouseY<= this.y + this.h); 
 }
  
}
