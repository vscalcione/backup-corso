package it.intersistemi.corsojava.amazon.jpadao;

import it.intersistemi.corsojava.amazon.dao.model.SellerReview;
import it.intersistemi.corsojava.amazon.dao.model.SellerReviewPK;

public interface SellerReviewRepository extends CrudRepository<SellerReview, SellerReviewPK> {
	Iterable<SellerReview> findByUsername(String username);
	Iterable<SellerReview> findByPIva (String pIva);
	Iterable<SellerReview> findByPIvaAndPunteggio (String pIva, int punteggio);
}
