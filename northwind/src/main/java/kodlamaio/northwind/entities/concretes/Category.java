/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 5 Haz 2021
 */
package kodlamaio.northwind.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="categories")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class Category {
	
	@Id
	@Column(name="category_id")
	private int categoryId; 
	
	@Column(name="category_name")
	private String categoryName;	

	@OneToMany(mappedBy = "category")
	private List<Product> products;
	
	
}
