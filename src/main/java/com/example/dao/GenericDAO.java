package com.example.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class GenericDAO<T, ID extends Serializable>{

	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		if (sessionFactory == null) {
			return this.sessionFactory.openSession();
		}
		return sessionFactory.getCurrentSession();
	}
	
//	public void makeQueryConditions(Criteria criteria, PageParam pageParam) {
//		if (pageParam.isHaveKeyword()) {
//			criteria.add(Restrictions.ilike(pageParam.getCol(), "%" + pageParam.getKw() + "%"));
//		}
//	}
	
	public long countRow(Class<T> clazz) {
		Criteria criteria = getSession().createCriteria(clazz);
		criteria.setProjection(Projections.rowCount());
		return ((Long)criteria.list().get(0)).longValue();
	}
	
//	public long countRow(Class<T> clazz, PageParam pageParam) {
//		Criteria criteria = getSession().createCriteria(clazz);
//		criteria.setProjection(Projections.rowCount());
//		makeQueryConditions(criteria, pageParam);
//		return ((Long)criteria.list().get(0)).longValue();
//	}

	public void save(T entity) {//insert
		Session hibernateSession = this.getSession();
		hibernateSession.saveOrUpdate(entity);
	}

	public void merge(T entity) {//UPDATE
		Session hibernateSession = this.getSession();
		hibernateSession.merge(entity);
	}

	public void delete(T entity) {
		Session hibernateSession = this.getSession();
		hibernateSession.delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<T> findMany(Query query) {
		List<T> t;
		t = (List<T>)query.list();
		return t;
	}

	@SuppressWarnings("unchecked")
	public T findOne(Query query) {
		T t;
		t = (T)query.uniqueResult();
		return t;
	}

	@SuppressWarnings({"unchecked"})
	public T findById(Class<T> clazz, ID id) {
		Session hibernateSession = this.getSession();
		T t =  (T)hibernateSession.get(clazz, id);
		return t;
	}

	@SuppressWarnings({"unchecked"})
	public List<T> findAll(Class<T> clazz) {
		Session hibernateSession = this.getSession();
		String sql = "from " + clazz.getName();
		Query query = hibernateSession.createQuery( sql );
		List<T> list = query.list();
		return list;
	}
	
	@SuppressWarnings({"unchecked"})
	public List<T> findAllOrderBy(Class<T> clazz, String orderBy) {
		Session hibernateSession = this.getSession();
		Query query = hibernateSession.createQuery("from " + clazz.getName() + orderBy);
		List<T> list = query.list();
		return list;
	}
}