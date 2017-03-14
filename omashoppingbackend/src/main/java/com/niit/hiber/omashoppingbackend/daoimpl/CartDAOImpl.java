package com.niit.hiber.omashoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.hiber.omashoppingbackend.dao.CartDAO;
import com.niit.hiber.omashoppingbackend.dto.Cart;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public Cart get(int id) {
		return sessionFactory.getCurrentSession().get(Cart.class, Integer.valueOf(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cart> list() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM Cart WHERE active = true").getResultList();
	}

	@Override
	public boolean add(Cart cart) {
		try
		{
			// persist cart in db
			sessionFactory.getCurrentSession().persist(cart);
			return true;	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}	
	}

	@Override
	public boolean update(Cart cart) {
		try
		{
			// update cart in db
			sessionFactory.getCurrentSession().update(cart);
			return true;	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}		
	}

	@Override
	public boolean delete(int id) {
		Cart cart = this.get(id); 
		try
		{
			// delete cart in db
			sessionFactory.getCurrentSession().delete(cart);
			return true;	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}	
	}

	@Override
	public Cart getCartByUserId(int userId) {
		return sessionFactory.getCurrentSession().createQuery("FROM Cart where userid = '" + userId+"'" , Cart.class).getSingleResult();
	}

}
