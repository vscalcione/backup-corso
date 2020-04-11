package it.intersistemi.corsojava.letturafile;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class InputOutputStream {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		String fileBinario ="C:\\Nuova cartella\\images_APPLE.jpg";
	
		OutputStream os = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		try {
			os	= new FileOutputStream (fileBinario);
			dos = new DataOutputStream (os);
			dis = new DataInputStream(new FileInputStream(fileBinario));
			
		    dos.writeInt(885586464);
		    dos.writeBoolean(false);
		    
		    dos.writeUTF("Non sono stato io");
		    dos.writeUTF("Non sono stato io, e' stata Angela");
		    
		    dos.close();
		    
		    System.out.println(dis.readInt());
		    System.out.println(dis.readBoolean());
		    System.out.println(dis.readUTF());
		} finally {
		    dis.close();
			
		}
	}

}
