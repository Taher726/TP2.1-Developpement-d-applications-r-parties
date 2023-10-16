package server;
import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[]args)  {
		try {
		System.out.println("je suis un serveur");
		ServerSocket serverSocket=new ServerSocket(1234);
		Socket socket=serverSocket.accept();
		System.out.println("Un client est connecté");
		InputStream is = socket.getInputStream();
		OutputStream os=socket.getOutputStream();
		InputStreamReader isr= new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		int nb1= Integer.parseInt(br.readLine());
		int nb2=Integer.parseInt(br.readLine());
		String op=br.readLine();
		int res=0;
		switch(op) {
		case "+":
			res=nb1+nb2;
			break;
		case "-":
			res=nb1-nb2;
			break;
		case "*":
			res=nb1*nb2;
			break;
		case "/":
			res= nb1/nb2;
			break;
		}
		PrintWriter pw= new PrintWriter(os,true);
		pw.println(Integer.toString(res));
		serverSocket.close();
	}catch(IOException e){
		e.printStackTrace();
	}
		}

	}

