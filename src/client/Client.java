package client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		try {
			InetAddress id = InetAddress.getByName("192.168.1.2");
			InetSocketAddress isd = new InetSocketAddress(id, 1234);
			Socket s = new Socket();
			s.connect(isd);
			System.out.println("Je suis connecté");
			Scanner sc = new Scanner(System.in);
			String w;
			do {
				System.out.println("enter method (+, -, *, /): ");
				w = sc.nextLine();
			} while (!(w.equals("+") || w.equals("-") || w.equals("*") ||
					w.equals("/")));
			
			System.out.println("enter nombre 1: ");
			int nb1 = sc.nextInt();
			System.out.println("enter nombre 2: ");
			int nb2 = 0;
			if( w.equals("/")) {
				do {
					System.out.println("enter nombre 2: ");
					nb2 = sc.nextInt();
				} while (nb2 ==0);
			} else {
				nb2=sc.nextInt();
			}
			OutputStream os = s.getOutputStream();
			PrintWriter pw = new PrintWriter(os, true);
			pw.println(nb1);
			pw.println(nb2);
			pw.println(w);
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			System.out.println(nb1 + w + nb2 + "=" + br.readLine());
			s.close();
			sc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
