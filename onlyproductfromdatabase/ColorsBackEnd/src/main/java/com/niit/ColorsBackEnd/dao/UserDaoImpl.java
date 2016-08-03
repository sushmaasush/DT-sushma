package com.niit.ColorsBackEnd.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ColorsBackEnd.model.UserDetails;
import com.niit.ColorsBackEnd.model.Users;

public class UserDaoImpl implements UserDao {
	
	

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	public Users users;
	
	
	public UserDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
		
	}

	@Transactional
	public List<Users> list() {
		@SuppressWarnings("unchecked")
		List<Users> listUsers = (List<Users>) sessionFactory.getCurrentSession()
				.createCriteria(Users.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		        return listUsers;
	}


	public Users get(String id) {
		String hql = "from User where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Users> listUsers = (List<Users>) query.list();
		
		if (listUsers != null && !listUsers.isEmpty()) {
			return listUsers.get(0);
		}
		return null;
	}

	@Transactional
	public void saveOrUpdate(Users users) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(users);
		
	}

	@Transactional
	public void delete(String id) {
		Users UserToDelete = new Users();
		UserToDelete.setUser_ID(id);
		sessionFactory.getCurrentSession().delete(UserToDelete);
		
	}

	public void saveOrUpdate(UserDetails userDetails) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(userDetails);
		
	}

	public boolean isValidUser(String id, String name, boolean isAdmin) {
		return false;
	}
   
}
