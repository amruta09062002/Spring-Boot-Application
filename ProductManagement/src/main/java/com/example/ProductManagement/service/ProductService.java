package com.example.ProductManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProductManagement.dao.ProductDao;
import com.example.ProductManagement.entity.Product;
import com.example.ProductManagement.message.Message;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public String insertProduct(Product product) {
		return productDao.insertProduct(product);
	}

	public String updateProduct(Long id, Product product) {
		if (productDao.updateProduct(id, product) != null) {
			return Message.update();
		} else {
			return Message.notUpdated();
		}
	}

	public List<Product> priceGreaterThan() {
		return productDao.priceGreaterThan();
	}

	public int getSales(long id) {
		return productDao.getSales(id);
	}

	public List<Product> topExpensive(int n) {
		return productDao.topExpensive(n);
	}

}
