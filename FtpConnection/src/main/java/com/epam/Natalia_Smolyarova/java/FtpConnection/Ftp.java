package com.epam.Natalia_Smolyarova.java.FtpConnection;

import java.net.SocketException;
import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class Ftp {
	final static String server = ("ftp.mozilla.org");
	final static String user = ("anonymous");
	final static String pass = ("");

	public static void main(String[] args) throws SocketException, IOException {
		Ftp connection = new Ftp();
		FTPClient ftp = connection.FtpConnect();
		FTPFile[] files = ftp.listFiles();
		connection.Printer(files);
	}

	public FTPClient FtpConnect() throws SocketException, IOException {
		FTPClient ftp = new FTPClient();
		ftp.connect(server);
		ftp.enterLocalPassiveMode();
		ftp.login(user, pass);
		return ftp;
	}

	public void Printer(FTPFile[] g) throws SocketException, IOException {
		for (FTPFile afile : g) {
			System.out.println(afile.getName());
		}
	
	}
}
