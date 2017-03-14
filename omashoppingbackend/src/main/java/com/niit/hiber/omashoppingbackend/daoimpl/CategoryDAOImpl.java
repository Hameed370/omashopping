package com.niit.hiber.omashoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.hiber.omashoppingbackend.dao.CategoryDAO;
import com.niit.hiber.omashoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// private static List<Category> categories = new ArrayList<Category>();

	@SuppressWarnings("unchecked")
	public List<Category> list() {
		String selectActiveCategory = "FROM Category where is_active = true ";
		return sessionFactory.getCurrentSession().createQuery(selectActiveCategory).list();
		/*
		 * query.setParameter("active", true);
		 * 
		 * return query.getResultList();
		 */ }

	// get single category
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	public boolean add(Category category) {

		try {
			sessionFactory.getCurrentSession().save(category);

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

		// TODO Auto-generated method stub
		// return false;
	}

	// update a single cat
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Category cat = (Category) sessionFactory.getCurrentSession().load(Category.class, new Integer(id));
		if (cat != null) {
			sessionFactory.getCurrentSession().delete(cat);
		}
	}

	/*
	 * public boolean delete(Category category) { category.setActive(false); try
	 * { sessionFactory.getCurrentSession().update(category); return true;
	 * }catch(Exception ex) { ex.printStackTrace(); return false; } }
	 */

}
