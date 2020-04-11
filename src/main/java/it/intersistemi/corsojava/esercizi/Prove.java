package it.intersistemi.corsojava.esercizi;

public class Prove {

	public static void main(String[] args) {
		int i;
		int a;
		int b[][]={{01,02,03,04},{11,12,13,14},{21,22,23,24},{31,32,33,34}};
		for(i=0, a=0 ; i<4 ; a++, i += a/4, a= (a<4) ? a : 0){
			System.out.println("i;"+i+" a:"+a+"\nb:"+b[i][a]);
		}
	}

}
