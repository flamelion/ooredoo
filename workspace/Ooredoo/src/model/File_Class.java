package model;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

import javax.imageio.ImageIO;

import com.ghg.index.index;

import javafx.scene.control.IndexedCell;
import javafx.scene.image.Image;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import jcifs.smb.SmbFileOutputStream;

public class File_Class {
	private String extendedpath = "";

	private File file;
	private SmbFile sFile;

	public String getFullPath() {
		return index.Folderpath + File.separator + extendedpath;
	}

	public File_Class()
	{}
	public File_Class(String extendedpathFile) throws MalformedURLException, URISyntaxException {
		extendedpath=extendedpathFile;
		if (getFullPath().contains("File")) {
			file = new File(new  URI(getFullPath()));	
		} else {
			sFile = new SmbFile(getFullPath(), index.auth);
		}
	}
	public Object getFile()
	{
		if(index.Folderpath.contains("File"))
			return file;
		else
			return sFile;
	}
	public void  deleteFile() throws Exception 
	{
		if (index.Folderpath.contains("File")) {
			if(file.exists())
				file.delete();
		}
		else
		{
			if(sFile.exists())
				sFile.delete();
		}
	}
	
	public static InputStream readImage(Object file) throws IOException {
		if (file instanceof File) {
			File f = (File) file;
			return new FileInputStream(f);
		} else if (file instanceof SmbFile) {
			SmbFile f = (SmbFile) file;
			InputStream in = new SmbFileInputStream(f);
			return in;
		}
		return null;
	}
	public static String  copyfoldertoClient(String copyfolder,String pastfolder) throws Exception
	{
		String newfolderuri="";
		if(index.Folderpath.contains("File"))
		{
			File copy = new File(new URI(index.Folderpath+File.separator+copyfolder+File.separator));
			if(!copy.isDirectory())
				throw new Exception();
			File past = new File("config"+File.separator+"temp"+File.separator+pastfolder+File.separator);
			if(!past.isDirectory())
				throw new Exception();
			else
			{
				if(past.exists())
					past.delete();
				past.mkdir();
				File[] copiedfiles=copy.listFiles();
				for(int i=0;i<copiedfiles.length;i++)
				{
					File copyedfile=copiedfiles[i];
					String filename=copyedfile.getName();
					File target = new File("config"+File.separator+"temp"+File.separator+pastfolder+File.separator+filename);
					target.createNewFile();
					FileOutputStream fos = new FileOutputStream(target, false);
					InputStream fin=new FileInputStream(copyedfile);
					byte[] buf = new byte[1024];
					int bytesRead;
					while ((bytesRead = fin.read(buf)) > 0) {
						fos.write(buf, 0, bytesRead);
						if (fin.available() < 1024) {
							buf = new byte[fin.available()];
						}
					}
					fos.close();
					fin.close();
				}
				
			}
			newfolderuri="File://"+past.getAbsolutePath();
		}
		else
		{
			SmbFile copy = new SmbFile(index.Folderpath+File.separator+copyfolder+File.separator);
			if(!copy.isDirectory())
				throw new Exception();
			File past = new File("config"+File.separator+"temp"+File.separator+pastfolder+File.separator);
			if(!past.isDirectory())
				throw new Exception();
			else
			{
				if(past.exists())
					past.delete();
				past.mkdir();
				SmbFile[] copiedfiles=copy.listFiles();
				for(int i=0;i<copiedfiles.length;i++)
				{
					SmbFile copyedfile=copiedfiles[i];
					String filename=copyedfile.getName();
					File target = new File("config"+File.separator+"temp"+File.separator+pastfolder+File.separator+filename);
					target.createNewFile();
					FileOutputStream fos = new FileOutputStream(target, false);
					InputStream fin=new SmbFileInputStream(copyedfile);
					byte[] buf = new byte[1024];
					int bytesRead;
					while ((bytesRead = fin.read(buf)) > 0) {
						fos.write(buf, 0, bytesRead);
						if (fin.available() < 1024) {
							buf = new byte[fin.available()];
						}
					}
					fos.close();
					fin.close();
				}
				
			}
			newfolderuri="File://"+past.getAbsolutePath();
		}
		return newfolderuri;
		
	}
	
	public static String renameFolder(String oldFoldername,String newfoldername) throws Exception
	{
		if (index.Folderpath.contains("File")) {
			File dir = new File(new URI(index.Folderpath+File.separator+oldFoldername+File.separator));
			if(!dir.isDirectory())
				throw new Exception();
			 File newDir = new File(index.Folderpath+File.separator+ newfoldername+File.separator);
			dir.renameTo(newDir);
			return index.Folderpath+File.separator+newfoldername;
		}
		else
		{
			SmbFile dir = new SmbFile(index.Folderpath+File.separator+oldFoldername+File.separator,index.auth);			
			if(!dir.isDirectory())
				throw new Exception();
			SmbFile newDir = new SmbFile(index.Folderpath+File.separator+ newfoldername+File.separator,index.auth);	
			dir.renameTo(newDir);
			return index.Folderpath+File.separator+newfoldername;
		}
		
	}
	public static void deleteFolder(String foldername) throws Exception
	{
		if (index.Folderpath.contains("File")) {
			File dir = new File(new URI(index.Folderpath+File.separator+foldername+File.separator));
			if(!dir.isDirectory())
				throw new Exception();
			dir.delete();
		}
		else
		{
			SmbFile dir = new SmbFile(index.Folderpath+File.separator+foldername+File.separator,index.auth);
			if(!dir.isDirectory())
				throw new Exception();
			dir.delete();
		}
		
	}


	public static String copytoHost(String pastfoldername, String pastfilename, Object cpfile) throws IOException, URISyntaxException {
		if (index.Folderpath.contains("File")) {
			File outfile = new File(new  URI(index.Folderpath  + File.separator + pastfoldername + File.separator + pastfilename));
			if (!outfile.getParentFile().exists()) {
				outfile.getParentFile().mkdir();
			}
			if (!outfile.exists()) {
				outfile.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(outfile, false);
			InputStream fin;
			if (cpfile instanceof File) {
				File infile = (File) cpfile;
				fin = new FileInputStream(infile);
			} else {
				SmbFile infile = (SmbFile) cpfile;
				fin = new SmbFileInputStream(infile);
			}

			byte[] buf = new byte[1024];
			int bytesRead;
			while ((bytesRead = fin.read(buf)) > 0) {
				fos.write(buf, 0, bytesRead);
				if (fin.available() < 1024) {
					buf = new byte[fin.available()];
				}
			}
			fos.close();
			fin.close();
		} else {
			SmbFile outfile = new SmbFile(
					index.Folderpath  + File.separator + pastfoldername + File.separator + pastfilename, index.auth);
			SmbFile parent = new SmbFile(outfile.getParent(), index.auth);

			if (!parent.exists()) {
				parent.mkdir();
			}
			if (!outfile.exists()) {
				outfile.createNewFile();
			}
			InputStream fin;
			if (cpfile instanceof File) {
				File infile = (File) cpfile;
				fin = new FileInputStream(infile);
			} else {
				SmbFile infile = (SmbFile) cpfile;
				fin = new SmbFileInputStream(infile);
			}
			OutputStream fos = new SmbFileOutputStream(outfile);
			byte[] buf = new byte[1024];
			int bytesRead;
			while ((bytesRead = fin.read(buf)) > 0) {
				fos.write(buf, 0, bytesRead);
				if (fin.available() < 1024) {
					buf = new byte[fin.available()];
				}
			}
			fos.close();
			fin.close();

		}
		return  File.separator + pastfoldername + File.separator + pastfilename;
	}

}
