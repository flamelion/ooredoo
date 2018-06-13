package com.ghg.index;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.ghg.index.db.DBstatement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import model.File_Class;

public class index extends Application {
	public static DBstatement dbstatement;
	public static String Folderpath;
	public static NtlmPasswordAuthentication auth;

	public static void main(String[] args) {


		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException, URISyntaxException {

		try {
			dbstatement = new DBstatement();
		} catch (SQLException | IOException e) {
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("Error");
			a.setContentText("SQL DB cannot be connected.");
			a.showAndWait();
			System.exit(0);
		}

		FileInputStream input = new FileInputStream("config" + File.separator + "p.properties");
		Properties pros = new Properties();
		pros.load(input);
		String dbaddress = pros.getProperty("db_address");
		Folderpath = pros.getProperty("img_src");
		if (!(Folderpath.contains("file://"))) {
			try {
				String USER_NAME = pros.getProperty("usr");
				String PASSWORD = pros.getProperty("pass");
				String NETWORK_FOLDER = pros.getProperty("img_src");
				String user = USER_NAME + ":" + PASSWORD;
			    auth = new NtlmPasswordAuthentication(user);
				SmbFile sFile = new SmbFile(NETWORK_FOLDER, auth);
				if (!(sFile.canRead() && sFile.exists()))
					throw new Exception();
				Folderpath = NETWORK_FOLDER;
			} catch (Exception e) {
				Alert a = new Alert(AlertType.ERROR);
				a.setTitle("Error");
				a.setContentText("Local File cannot be Access.");
				a.showAndWait();
				e.printStackTrace();
				System.exit(0);
			}

		} else {
			
			try {
				
			URI uri=new URI(Folderpath);
			File temp=new File(uri);
			if (!(temp.canRead() && temp.exists()))
				throw new Exception();
			} catch (Exception e) {
				Alert a = new Alert(AlertType.ERROR);
				a.setTitle("Error");
				a.setContentText("Romote File cannot be Access.");
				a.showAndWait();
				e.printStackTrace();
				System.exit(0);
			}
		
		}
	

		FXMLLoader loader = new FXMLLoader(getClass().getResource("mainview.fxml"));
		Pane root = loader.load();
		
		primaryStage.setScene(new Scene(root, 1200, 800));
		primaryStage.show();

	}
}
