package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.ghg.index.MainFrame_Controller;
import com.ghg.index.db.DBstatement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import jcifs.smb.SmbFileOutputStream;

public class test extends Application {
	    
	public static void main(String[] args) throws IOException
	{
        String fileContent = "This is a test file";

		String USER_NAME ="MAT";
	    String PASSWORD = "ghg";
	    String NETWORK_FOLDER="smb://192.168.1.9/CV FORM/";
		String user = USER_NAME + ":" + PASSWORD;
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(user);
        String path = NETWORK_FOLDER + "hello/nnt.txt";
        SmbFile sFile = new SmbFile(path, auth);
        SmbFile parent=new SmbFile(sFile.getParent(),auth);
        if(!parent.exists())
        {
        		parent.mkdir();
        }
    

	}
	@Override
	public void start(Stage primaryStage) throws IOException {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/test/ui/ui.fxml"));
				Pane root = loader.load();
			    primaryStage.setScene(new Scene(root, 1200, 800));
			    primaryStage.show();
	
		
	}
}
