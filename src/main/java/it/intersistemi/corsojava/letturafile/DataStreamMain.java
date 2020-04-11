package it.intersistemi.corsojava.letturafile;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamMain {

	public static void main(String[] args) {
		
		try (FileOutputStream fos = new FileOutputStream("prova.dat");
				DataOutputStream dos = new DataOutputStream(fos);
				){
			dos.writeInt(45);
			dos.writeDouble(15.5);
			dos.writeUTF("prova di scrittura");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
