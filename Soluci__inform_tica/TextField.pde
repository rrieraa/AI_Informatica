// Component Camp de Text

class TextField {
  
  // Propietats del camp de text
  float x, y, h, w;
  String tipo;
  
  // Colors
  color bgColor = color(140, 140, 140);
  color fgColor = color(0, 0, 0);
  color selectedColor = color(190, 190, 60);
  color borderColor = color(30, 30, 30);
  int borderWeight = 1;
  
  // Text del camp
  String text = "";
  int textLength = 0;
  int textSize = 20;

  boolean selected = false;
   
  // Constructor
  TextField(String tipo) {
      this.tipo = tipo;
   }
  
  // Dibuixa el Camp de Text
  void display(float x, float y, float w, float h) {
   pushStyle();
     this.x = x; this.y = y; this.w = w; this.h = h;
      
      if (selected) {
         fill(selectedColor);
      } else {
         fill(bgColor);
      }
      
      strokeWeight(borderWeight);
      stroke(borderColor);
      rect(x, y, w, h, 5);
      
      fill(fgColor);
      textSize(textSize); textAlign(CORNER);
      text(text, x + 5, y + this.h/2+ textSize/2);
  popStyle();
 }
   
   // Afegeix, lleva el text que es tecleja
   void keyPressed(char key, int keyCode) {
      if (selected) {
         if (keyCode == (int)BACKSPACE) {
            removeText();
         } else if (keyCode == 32) {
            addText(' '); // SPACE
         }else if(keyCode == 46 || keyCode == 44){
            addText('.'); // Coma decimal
         }else if(keyCode == 45){
           addText('-'); //Menos
         }else {
            
           boolean isKeyCapitalLetter = (key >= 'A' && key <= 'Z');
           boolean isKeySmallLetter = (key >= 'a' && key <= 'z');
           boolean isKeyNumber = (key >= '0' && key <= '9');
      
           if (isKeyCapitalLetter || isKeySmallLetter || isKeyNumber) {
               addText(key);
           }
         }
      }
   }
   void resetText(){
     this.text = "";
   }
   
   // Afegeix la lletra c al final del text
   void addText(char c) {
      if (textWidth(this.text + c)*0.5   < w) {
         this.text += c;
         textLength++;
      }
   }
   
   // Lleva la darrera lletra del text
   void removeText() {
      if (textLength - 1 >= 0) {
         text = text.substring(0, text.length() - 1);
         textLength--;
      }
   }

   // Indica si el ratolí està sobre el camp de text
   boolean mouseOverTextField() {
      if (mouseX >= this.x && mouseX <= this.x + this.w) {
         if (mouseY >= this.y && mouseY <= this.y + this.h) {
            return true;
         }
      }
      return false;
   }
   
   // Selecciona el camp de text si pitjam a sobre
   // Deselecciona el camp de text si pitjam a fora
   void isPressed() {
      if (mouseOverTextField()) {
         selected = true;
      } else {
         selected = false;
      }
   }
}
