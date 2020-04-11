package it.intersistemi.corsojava.letturafile;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class WriterMain {

	public static void main(String[] args) throws IOException {
	 
		
	OutputStreamWriter fw = new OutputStreamWriter (new FileOutputStream("C:\\Nuova cartella\\sonoio.txt"),"KOI8_U");
	
		//FileWriter fw = new FileWriter(nuovoFile);
		
       fw.write("semo cotti  ");
       fw.write("semo cotti, la vendetta ������ '''''' ??????");
       fw.close();
	}

}
