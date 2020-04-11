package it.intersistemi.corsojava.ereditarieta.esercizi.poligoni;

public class PoligoniGeneratorMain {
	public static void main(String[] args) {	
		//cerchio
		Cerchio cerchio = new Cerchio(10);
		System.out.println("Creazione nuovo oggetto di tipo Cerchio ");
		double result = cerchio.calcolaPerimetro();
		result = Math.round(result);
		System.out.println("Perimetro del tuo cerchio: "+result+" centimetri");
		System.out.println("******************************************");
		
		//triangolo
		Triangolo triangolo=new Triangolo(7);
		System.out.println("Creazione nuovo oggetto di tipo Triangolo ");
		result=triangolo.calcolaPerimetro();
		result=Math.round(result);
		System.out.println("Perimetro del tuo triangolo: "+result+" centimetri");
		System.out.println("******************************************");
		
		//quadrato
		Quadrato quadrato=new Quadrato(26);
		System.out.println("Creazione nuovo oggetto di tipo Quadrato ");
		result=quadrato.calcolaPerimetro();
		result=Math.round(result);
		System.out.println("Perimetro del tuo quadrato: "+result+" centimetri");
		System.out.println("******************************************");
		
		//rettangolo
		Rettangolo rettangolo=new Rettangolo(10,5);
		System.out.println("Creazione nuovo oggetto di tipo Rettangolo");
		result=rettangolo.calcolaPerimetro();
		System.out.println("Perimetro del tuo rettangolo: "+result+" centimetri");
		System.out.println("******************************************");
		 
		//trapezio
		Trapezio trapezio=new Trapezio(7,4,3.2);
		System.out.println("Creazione nuovo oggetto di tipo Trapezio");
		result=trapezio.calcolaPerimetro();
		System.out.println("Perimetro del tuo trapezio: "+result+" centimetri");
		System.out.println("*****************************************");
	}
}
