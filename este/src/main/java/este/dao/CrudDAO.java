/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package este.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration; 

import este.exceptions.CrudInsertException;
import este.exceptions.CrudListException;
import este.exceptions.CrudRecoverException;
import este.exceptions.CrudRemoveException;
import este.model.Crud;
import este.util.HibernateUtil;

public class CrudDAO {
	private Session session;
	private SessionFactory sf;

	public CrudDAO() {

	}

	public void insertCrud(Crud i) throws CrudInsertException{
		try {
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();

			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(i);
			session.flush();
			tx.commit();

		} catch (SessionException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void removeCrud(Crud crud) throws CrudRemoveException{
		try {
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(crud);

			session.flush();
			tx.commit();
		} catch (SessionException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void updateCrud(Crud i) throws CrudInsertException{
		try {
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();

			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(i);
			session.flush();
			tx.commit();
		} catch (SessionException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public List listCrud(String query) throws CrudListException {
		List<Crud> cruds = new ArrayList<Crud>();
		try {
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			cruds = session.createQuery(query).getResultList();
		} catch (SessionException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cruds;
	}

	public Crud recoverInstituicao(long id) throws CrudRecoverException {
		Crud i = new Crud();
		try {
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
			i = (Crud) session.get(Crud.class, id);
			
		} catch (SessionException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return i;
	}
	 
}