package com.ty.onetoonecruduni.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetoonecruduni.dao.InvoiceDao;
import com.ty.onetoonecruduni.dto.Invoice;
import com.ty.onetoonecruduni.dto.Items;

public class TestInvoice {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		InvoiceDao invoiceDao=new InvoiceDao();
		
		Invoice invoice=new Invoice();
		invoice.setId(2);
		invoice.setName("Swamy");
		invoice.setBillingAddress("BLR_BLR");
		invoice.setGst_No("BLR_657432");
		invoice.setTax(23.65);
		
		Items items=new Items();
		items.setId(2);
		items.setName("book");
		items.setPrice(50.0);
		items.setQuantity(2);
		
		invoice.setItems(items);
		
		invoiceDao.saveInvoiceAndItems(invoice, items);
				
	}

}
