package com.niit.ColorsBackEnd.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ColorsBackEnd.model.Shipping;

public class ShippingDaoImpl implements ShippingDao{

	@Autowired
	Shipping shipping;
	
	@Autowired
	ShippingDao shippingDao;
	
	@Autowired
	SessionFactory sessionFactory;
	
	public ShippingDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void saveOrUpdateOrdres(Shipping shipping) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(shipping);
	}
	
	
	@Transactional
	public void delete(String id) {
	Shipping todelete=new Shipping();
	todelete.setId(id);
	sessionFactory.getCurrentSession().delete(todelete);
	}
	
	
	@Transactional
	public Shipping get(String id) {
		String hql = "from Supplier where id='" + id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Shipping> listSupplier = (List<Shipping>) query.list();
		
		if (listSupplier != null && !listSupplier.isEmpty()) {
			return listSupplier.get(0);
		}
		return null;
	}
	
	@Transactional
	public List<Shipping> list() {
		@SuppressWarnings("unchecked")
		List<Shipping> listSupplier = (List<Shipping>) sessionFactory.getCurrentSession()
				.createCriteria(Shipping.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		        return listSupplier;
		
	}

}
