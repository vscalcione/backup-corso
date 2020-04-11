package it.intersistemi.corsojava.amazon.jpadao;

import it.intersistemi.corsojava.amazon.dao.model.ProductReview;
import it.intersistemi.corsojava.amazon.dao.model.ProductReviewPK;

public interface ProductReviewRepository extends CrudRepository<ProductReview, ProductReviewPK> {
	Iterable<ProductReview> findByUsername(String username);
	Iterable<ProductReview> findByAsinAndPunteggio(String asin, int punteggio);
}