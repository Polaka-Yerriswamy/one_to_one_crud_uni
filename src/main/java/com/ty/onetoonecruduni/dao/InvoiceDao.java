package com.ty.onetoonecruduni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import com.ty.onetoonecruduni.dto.Invoice;
import com.ty.onetoonecruduni.dto.Items;

public class InvoiceDao {
	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;
	EntityTransaction entityTransaction = null;

	public EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		entityManager = entityManagerFactory.createEntityManager();

		return entityManager;
	}

	public void saveInvoiceAndItems(Invoice invoice, Items items) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.persist(items);
		entityManager.persist(invoice);

		entityTransaction.commit();
	}

}
