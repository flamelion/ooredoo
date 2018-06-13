package com.ghg.index.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBInitialize {
	public static  Connection getConnection() throws SQLException, IOException  {
		 
		FileInputStream	input=new FileInputStream("config"+File.separator+"p.properties");
		Properties pros=new Properties();
		pros.load(input);
		Statement statement ;
		String connector="jdbc:mysql://";
		String key=pros.getProperty("db_sr");
		String address=Decrpt(pros.getProperty("db_address"),key);
		String port=Decrpt(pros.getProperty("db_port"),key);
		String dbname=Decrpt(pros.getProperty("db_name"),key);
		String usr=Decrpt(pros.getProperty("db_user"),key);
		String pass=Decrpt(pros.getProperty("db_pass"),key);
		Connection connection = DriverManager.getConnection(connector+address+":"+port+"/"+dbname, usr,pass);	

return connection;

}
public static String Decrpt(String encryp,String key)
{
return encryp;
}

}
