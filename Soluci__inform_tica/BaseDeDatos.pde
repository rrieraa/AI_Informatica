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


String[][] getInfoXXXX(int idFormulario){
  String q = "SELECT `variable`, `definicion`, `unidadSI` FROM `formulario` WHERE `idformulario`='"+idFormulario+"'";
  msql.query(q);
  
  String[][] data = new String[8][3];
  int nr=0;
  while(msql.next()){
    data[nr][0]= msql.getString("variable");
    data[nr][1]= msql.getString("definicion");
    data[nr][2]= msql.getString("unidadSI");
    print(data[nr][0]);
    nr++;
  }
  
  return data;
}
