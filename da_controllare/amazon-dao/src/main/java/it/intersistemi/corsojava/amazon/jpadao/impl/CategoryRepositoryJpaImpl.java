package it.intersistemi.corsojava.amazon.jpadao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.intersistemi.corsojava.amazon.jpadao.CategoryRepository;
import it.intersistemi.corsojavajava.amazon.jpadao.model.Categoria;


@Transactional
@Repository
public class CategoryRepositoryJpaImpl extends AbstractCrudRepository<Category, Integer> implements CategoryRepository {

	public CategoryRepositoryJpaImpl() {
		super(Category.class);		
	}

	@PersistenceContext
	private EntityManager em;

	@Override
	public Iterable<Category> findChildrenCategories(Integer id) {
		if(id != null) {
			Category categoriaPadre = this.findById(id);
			return em.createQuery("from Categoria c where c.categoriaPadre = :id", Category.class)
				.setParameter("id", categoriaPadre)
				.getResultList();
		}else {
			return this.findRootCategories();
		}
		
	}

	@Override
	public Iterable<Category> findRootCategories() {
		return em.createQuery("from Categoria c where c.categoriaPadre is null", Category.class)
				.getResultList();
	}

	@Override
	protected Integer getPkValue(Category obj) {		
		return obj.getId();
	}

	@Override
	protected void executeUpdate(Category current, Category obj) {
		current.setId(obj.getId());
		current.setNome(obj.getNome());
		current.setCategoriaPadre(obj.getCategoriaPadre());
		current.setCategorieFiglie(obj.getCategorieFiglie());		
	}
		
}

