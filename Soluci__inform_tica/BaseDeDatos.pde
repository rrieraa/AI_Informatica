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
