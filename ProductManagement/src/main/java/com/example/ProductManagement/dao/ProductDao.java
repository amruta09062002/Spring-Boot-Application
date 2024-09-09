package com.example.ProductManagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ProductManagement.entity.Product;
import com.example.ProductManagement.message.Message;

@Repository
public class ProductDao {

	@Autowired
	SessionFactory factory;

	public String insertProduct(Product product) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(product);
		transaction.commit();
		session.close();
		return "product inserted successfully";
	}

	public String updateProduct(Long id, Product product) {
		//Transaction transaction = null;
		//Product prod = null;
		try  {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Product prod = session.get(Product.class, id);
			if (prod != null) {
				//prod.setId(product.getId());
				prod.setName(product.getName());
				prod.setPrice(product.getPrice());
				prod.setQuantity(product.getQuantity());
				session.update(prod);
				transaction.commit();
				return Message.update();
			} else {
				return Message.notUpdated();
			}
		} catch (Exception e) {
			//return Message.errorMessage();
			return e.getMessage();
		}
	}

	public List<Product> priceGreaterThan() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Product.class);
		criteria.add(Restrictions.ge("price", 500.0));
		transaction.commit();
		return criteria.list();
	}

	public int getSales(long id) {
		Session session= factory.openSession();
		Transaction transaction = session.beginTransaction();
		Product product = session.get(Product.class,id);
		transaction.commit();
		return product.getQuantity();
	}

	public List<Product> topExpensive(int n) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria=session.createCriteria(Product.class);
		criteria.addOrder(Order.desc("price"));
		criteria.setMaxResults(n);
		List<Product> plist = criteria.list();
		session.close();
		transaction.commit();
		return plist;
	}

}
