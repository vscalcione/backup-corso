package it.intersistemi.corsojava.amazon.dao;

import it.intersistemi.corsojava.amazon.jdbc.ProductRepositoryImpl;

public class ProductRepositoryMain {
	public static void main(String[] args) {
		ProductRepository repo = new ProductRepositoryImpl();
//		for(int i=0 ; i<1000 ; i++) {
//			Prodotto p = new Prodotto();
//			String uuid = UUID.randomUUID().toString();
////			System.out.println(uuid.length()+" "+uuid);
//			p.setAsin(uuid);
//			p.setNome("Gioco_"+i);
//			p.setDescrizione("Descrizione_"+i);
//			p.setMarca("Marca_"+i);
//			p.setModello("Modello_"+i);
//			p.setCategoria(1);
//			
//			repo.insert(p);
//		}
		
//		repo.findAll().forEach(p -> System.out.println(p.getAsin() + " " +p.getNome()));
		System.out.println("=================================================================");
		repo.findByName("PRO")
			.forEach(p -> System.out.println(p.getAsin() + " " +p.getNome()));
	}
}