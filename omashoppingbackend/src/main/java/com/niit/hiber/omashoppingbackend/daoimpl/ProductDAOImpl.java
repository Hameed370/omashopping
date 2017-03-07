package com.niit.hiber.omashoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.hiber.omashoppingbackend.dao.ProductDAO;
import com.niit.hiber.omashoppingbackend.dto.Product;


@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {


	@Autowired
	private SessionFactory sessionFactory;
	
	
	//private static List<Product> products = new ArrayList<Product>();

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM Product").list();
	}

	@Override
	public Product get(int id) {
		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id)) ;
		}

	@Override
	public boolean add(Product product) {
		try	
		{
			sessionFactory.getCurrentSession().persist(product);
			
			
			return true;
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product product) {try	
	{
		sessionFactory.getCurrentSession().update(product);
		
		
		return true;
	}catch(Exception ex)
	{
		ex.printStackTrace();
		return false;
	}
	}

	@Override
	public boolean delete(Product product) {
		product.setActive(false);
		try	
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	
		/*static 
	{
		Product prod = new Product();
		
		product 1
		prod.setId(1);
		prod.setPname("Defender Case");
		prod.setDescription("This is a defender case for mobiles");
		prod.setImageUrl("defender_case.jpg");
		products.add(prod);
	
	}
	
*/	
	


/*	public Product getProduct(int id)
	{
		for(Product product : products)
		{
			if(product.getId() == id) return product;
		}
		return null;
	}
	*/
	
}
