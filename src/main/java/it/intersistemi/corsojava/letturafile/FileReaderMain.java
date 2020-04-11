package it.intersistemi.corsojava.letturafile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputStringa;

public class FileReaderMain {
	public static void main(String[] args) throws IOException, IllegalArgumentException{
		createAndWriteFile();
		readFile();
	}
	
	public static void createAndWriteFile() {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		String pathFileText = "C:/Users/Vincenzo Scalcione/Desktop/Workspace3/Lettura-File/src/main/java/txtFile.txt";
		try {
			File txtFile = new File(pathFileText);
			FileWriter fileWriter = new FileWriter(txtFile);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (int i = 0; i < 3; i++) {
				String stringaFile = ConsoleInputStringa.leggiStringa(console, "Inserisci stringa: ");
				bufferedWriter.write(stringaFile+" ");
				bufferedWriter.flush();				
			}
			bufferedWriter.close();
		}catch(IOException e) { e.printStackTrace(); }
	}
	
	public static void readFile() {
		String pathFile = "C:/Users/Vincenzo Scalcione/Desktop/Workspace3/Lettura-File/src/main/java/txtFile.txt";
		char[] input = new char[50];
		int sizeFile = 0;
		try {
			File txtFile = new File(pathFile);
			FileReader fileReader = new FileReader(txtFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			sizeFile = bufferedReader.read(input);
			System.out.println("Caratteri presenti nel file: "+sizeFile);
			System.out.println("Il contenuto del file � il seguente: ");
			for (int i = 0; i < sizeFile; i++) {
				System.out.print(input[i]+"");
			}
			bufferedReader.close();	
		}catch(IOException e) { e.printStackTrace(); }
	}
}
