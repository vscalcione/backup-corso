package it.intersistemi.corsojava.amazon.jpadao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.intersistemi.corsojava.amazon.jpadao.ProductRepository;
import it.intersistemi.corsojava.amazon.jpadao.model.Product;

@Transactional
@Repository
public class ProductRepositoryJpaImpl extends AbstractCrudRepository<Product, String>
											implements ProductRepository {

	public ProductRepositoryJpaImpl() {
		super(Product.class);
	}

	@Override
	protected String getPkValue(Product obj) {
		return obj.getAsin();
	}

	@Override
	protected void executeUpdate(Product current, Product obj) {
		current.setNome(obj.getNome());
		current.setDescrizione(obj.getDescrizione());
		current.setMarca(obj.getMarca());
		current.setModello(obj.getModello());
		current.setCategoria(obj.getCategoria());
	}
	
	@Override
	public Iterable<Product> findByNome(String nome) {
		return super.getEm().createQuery("from Prodotto p where p.nome like :nome", Product.class)
				.setParameter("nome", nome+"%").getResultList();
	}
	
}
