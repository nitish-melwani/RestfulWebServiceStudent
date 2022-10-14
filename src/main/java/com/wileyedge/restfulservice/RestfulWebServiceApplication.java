package com.wileyedge.restfulservice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RestfulWebServiceApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(RestfulWebServiceApplication.class, args);
//		EntityManagerFactory factory = context.getBean("entityManagerFactory", EntityManagerFactory.class);
//		System.out.println("factory " + factory);
//		EntityManager em = factory.createEntityManager();
//		
//		
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		System.out.println("entity manager " + em);
//		tx.commit();
//		em.close();
	}

}
