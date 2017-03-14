package com.niit.hiber.omashoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.hiber.omashoppingbackend.dao.UserDAO;
import com.niit.hiber.omashoppingbackend.dto.User;


@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM User where enabled = true").list();
	}

	public User get(int id) {
		
		return sessionFactory.getCurrentSession().get(User.class,Integer.valueOf(id));
	}

	@Override
	public boolean add(User user) {
		try	
		{
			sessionFactory.getCurrentSession().persist(user);	
			return true;
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(User user) {
sessionFactory.getCurrentSession().update(user);
		try{
		
		return true;
	}catch(Exception ex)
	{
		ex.printStackTrace();
		return false;
	}
}

	@Override
	public boolean delete(User user) {
		user.setEnabled(false);
		try	
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public User getUserByUserName(String username) {
		
		return sessionFactory.getCurrentSession().createQuery("FROM User where email = '" + username+"'" , User.class).getSingleResult();
	}

}
