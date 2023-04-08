// Objeto de connexión a la BBDD
MySQL msql;

void setBBDD(){
    String user     = "admin";
    String pass     = "12345";   
    String database = "fisica";
    
    //Conexión
    msql = new MySQL( this, "localhost", database, user, pass );
    
    // Si la connexió s'ha establert
    if (msql.connect()){
      println("Connected to DDBB");
    }
    else {
      // La connexió ha fallat!!!
      println("Connection failed !");
    }
}

void setFormulario(){
  
}

void setFormulas(){
  
}


String[] getInfoFormulario(int idFormulario){
  String q = "SELECT `variable`, `definicion`, `unidadSI` FROM `formulario` WHERE `idformulario`='"+idFormulario+"'";
  msql.query(q);
  msql.next();
  
  String[] data = new String[3];
      data[0]= msql.getString("variable");
      data[1]= msql.getString("definicion");
      data[2]= msql.getString("unidadSI");
  return data;
}

String getInfoFormula(int idFormula){
  String q = "SELECT `formula` FROM `formula` WHERE `idformula` ='"+idFormula+"'";
  msql.query(q);
  msql.next();
  
  String data;
      data = msql.getString("formula");
  return data;
}
