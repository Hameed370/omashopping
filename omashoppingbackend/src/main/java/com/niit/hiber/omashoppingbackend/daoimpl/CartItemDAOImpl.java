package com.niit.hiber.omashoppingbackend.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.hiber.omashoppingbackend.dao.CartItemDAO;
import com.niit.hiber.omashoppingbackend.dto.Cart;
import com.niit.hiber.omashoppingbackend.dto.CartItem;

@Repository("cartItemDAO")
@Transactional
public class CartItemDAOImpl implements CartItemDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public CartItem get(int id) {
		return sessionFactory.getCurrentSession().get(CartItem.class, Integer.valueOf(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CartItem> list(Cart  cart) {
		String selectActiveCategory = "FROM CartItem WHERE id = :parameter";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("parameter", cart.getId());
		System.out.println(query.getResultList());
		return query.getResultList();
		
		
		
		//return sessionFactory.getCurrentSession().createQuery("From CartItem  where userid = '" + userid + "'", CartItem.class).getResultList();
	}

	@Override
	public boolean add(CartItem cartItem) {
		try
		{
			
			sessionFactory.getCurrentSession().save(cartItem);
			return true;	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}	
	}

	@Override
	public boolean update(CartItem cartItem) {
		try
		{
			sessionFactory.getCurrentSession().update(cartItem);
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
		CartItem cartItem = this.get(id); 
		try
		{
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}	
		
	}

	@Override
	public CartItem getCartByUserId(int userId) {
		/* String selectActiveCategory = "FROM CartItem WHERE userid = :parameter";
		 * Query<CartItem> query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory, CartItem.class);
		 * query.setParameter("parameter", userId);
		 * return query.getSingleResult();
		 */
		return sessionFactory.getCurrentSession()
				.createQuery("From CartItem  where userid = '" + userId + "'", CartItem.class).getSingleResult();

	}

}
