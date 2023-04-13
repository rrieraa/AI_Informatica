// Classe Botó

class Button {
 //Atributos
 float x, y, w, h; 
 String textBoto; 
 boolean enabled;  
 boolean text = true;
 boolean isSelected = false;
 float redondetjat = 10;
 
 
 //Constructor
 Button(String text){
   this.textBoto = text;
   this.enabled = false;
 }
 
 // Setters
 void setMides(float x, float y, float w, float h){
   this.x = x;
   this.y = y;
   this.w = w;
   this.h = h;
 }
 
 //Se utiliza para el seleccionador
 void selecUse(){
   redondetjat = 35;
 }
 
 void display(){
   pushStyle();
     if(mouseOverButton()&&!isSelected){
       fill(getColor("BotonPulsado"));      
     }
     else if(isSelected){
       fill(getColor("Seleccionado"));          
     }else{
       fill(getColor("BotonSinPulsar"));
     }
     stroke(0); strokeWeight(2);       
     rect(this.x, this.y, this.w, this.h, redondetjat);  
     
     //Text
     if(text){
       fill(0); textAlign(CENTER); textFont(fonts[1]);
       if(textBoto == "Valores Aleatorios"){
         textSize(20);
       }
       
       text(textBoto, this.x + this.w/2, this.y + this.h/2 + (20/2));
     }
   popStyle();
 }
 
 void DisplayWithImage(PImage icona, color c){
   pushStyle();
     imageMode(CORNER);
     if(mouseOverButton()&&!isSelected){
       tint(200); fill(200);
     }else{
       fill(c);
     }
     
     rect(this.x, this.y, this.w, this.h, redondetjat);
     stroke(0); strokeWeight(2);  
     image(icona, this.x+3, this.y+3, this.w-6, this.h-6);
     
   popStyle();
 }
 
 void displayTransparencia(float t){
   pushStyle();
     if(mouseOverButton()&&!isSelected){
       fill(getColor("BotonPulsado"), t);  
     }
     else if(isSelected){
       fill(getColor("Seleccionado"), t);          
     }else{
       fill(getColor("BotonSinPulsar"), t);
     }
     stroke(0); strokeWeight(2);        
     rect(this.x, this.y, this.w, this.h, redondetjat);   
     
     //Text
     if(text){
       fill(0); textAlign(CENTER); textSize(20);
       text(textBoto, this.x + this.w/2, this.y + this.h/2 + (20/2));
     }
   popStyle();
 }
 
 //Indica si el cursor está sobre el botón
 boolean mouseOverButton(){
   return (mouseX >= this.x) && 
          (mouseX<=this.x + this.w) && 
          (mouseY>= this.y) && 
          (mouseY<= this.y + this.h); 
 }
}
