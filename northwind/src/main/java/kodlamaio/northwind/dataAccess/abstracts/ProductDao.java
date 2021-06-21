/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 8 May 2021
 */
package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer> {

	Product getByProductName(String productName);

	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

	List<Product> getByCategoryIn(List<Integer> categories);

	List<Product> getByProductNameContains(String productName);

	List<Product> getByProductNameStartsWith(String productName);

	//Product entity adı
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product> getByNameAndCategory(String productName,int categoryId);
	
	//JPQL
	
	@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto"
			+ "(p.id,p.productName,c.categoryName) "
			+ "From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
	
}

