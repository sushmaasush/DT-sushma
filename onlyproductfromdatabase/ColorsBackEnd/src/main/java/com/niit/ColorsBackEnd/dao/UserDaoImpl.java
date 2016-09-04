package com.niit.ColorsBackEnd.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ColorsBackEnd.model.Users;
@Repository("userDao")

public class UserDaoImpl implements UserDao {
	
	

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	public Users users;
	
	@Autowired
	public UserDao userDao;
	
	
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


	

	@Transactional
	public void saveOrUpdateUsers(Users users) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(users);
		
	}

	@Transactional
	public void delete(String id) {
		
		
		/*users.setMail_Id(id);;
		userDetails.setMail_id(users);
		sessionFactory.getCurrentSession().delete(userDetails);*/
		
		
		Users user = new Users();
		user.setUserid(id);
		sessionFactory.getCurrentSession().delete(user);
		
	}
	@Transactional
	public boolean isValidUser(String id, String pwd) {
		String hql = "from User where id= '" + id + "' and " + " password ='" + pwd+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Users> list = (List<Users>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return true;
		}
		
		return false;
	}
	
	@Transactional
	public Users getValidate(String s1) {
		String hql = "from Users where user_id= '" + s1+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Users> list = (List<Users>) query.list();
		if(list.size()>0)
		{
			System.out.println(list.size());
			for(Object obj:list){
				users =(Users) obj;
			}
			return users;
		}else
		
		
			return null;
	
	}


   
}
