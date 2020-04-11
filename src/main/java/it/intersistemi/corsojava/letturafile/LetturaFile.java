/**
 * 
 */
package it.intersistemi.corsojava.letturafile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


/**
 * @author Spellucci
 *
 */
public class LetturaFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String foto = "E:\\Users\\Spellucci\\Desktop\\Lezioni JAVA\\ammazzon.sql";
				try (
						InputStream is = new FileInputStream(foto);
						)
				{
					int byteLetti = 0;
					int read;
					do {
						read = is.read();
						if(read != -1) {
							byteLetti++;
						}
						System.out.println(read);
					} while(read != -1);
					System.out.println("ho letto "+ byteLetti+" byte");
				}catch (FileNotFoundException e) {
					e.printStackTrace();
				}catch (IOException e) {
					e.printStackTrace();
				}

	}

}
