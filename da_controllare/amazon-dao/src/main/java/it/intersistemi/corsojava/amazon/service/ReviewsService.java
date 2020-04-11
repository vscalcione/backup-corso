package it.intersistemi.corsojava.amazon.service;

import it.intersistemi.corsojava.amazon.dao.model.ProductReview;
import it.intersistemi.corsojava.amazon.dao.model.SellerReview;

public interface ReviewsService {
	void addProductReview(ProductReview productReview);	
	Iterable<ProductReview> productReviewList (ProductReview productReview);
	void inserisciRecensioneVenditore(SellerReview sellerReview);
	Iterable<SellerReview> sellerReviewList (SellerReview sellerReview);
}