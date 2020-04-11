package it.intersistemi.corsojava.esercizi;

public class PointSwap {
	
public static void main(String[] args) {
	Point p1 = new Point(100,200);
    Point p2 = new Point(300,400);
    System.out.println("p1= " + p1);
    System.out.println("p2= "  + p2);
    swap1( p1, p2 );
    System.out.println("p1= " + p1);
    System.out.println("p2= " + p2);
    }

//public static void swap(Point p1, Point p2) { 
//	Point temp = p1;
//    p1 = p2;
//    p2 = temp;
//    }

public static void swap1(Point p1, Point p2) {         // Metodo giusto 
    int tempx = p1.x ;
    int tempy = p1.y ;
    p1.x = p2.x ;
    p1.y = p2.y ;
    p2.x = tempx ;
    p2.y = tempy ;
    }
}
