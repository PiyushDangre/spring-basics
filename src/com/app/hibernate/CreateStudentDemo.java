package com.app.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.lhibernate.entity.Student;

public class CreateStudentDemo {
	
	public static void main(String[] args) {
		
		// Create session factory (To be done only once in the app. )
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		// Get session from factory
		Session session = sessionFactory.getCurrentSession();
		
		// Try finaly block
		try {
			// Use the session object
			Student st = new Student();
			st.setFirstName("Piyush");
			st.setLastName("Dangre");
			st.setAge("26");
			st.setStudentClass("4th yr");
			
			session.beginTransaction();  // Begin transaction
			
			session.save(st);		// Save the data
			
			session.getTransaction().commit();		// Commit the transaction
			
			/**
			 * Read Object.
			 * Hibernate automatically stores the ID of the inserted object in Id attribute of Student object.
			 * Get a new session everytime. Otherwise  Session/EntityManager is closed exception comes.
			 * As after every transaction, the session is closed.
			 */
			
			session = sessionFactory.getCurrentSession(); // This needs to be done before every transaction
			
			session.beginTransaction();
			
			Student st1 = session.get(Student.class, st.getId());
			
			session.getTransaction().commit();
					
			System.out.println("\nStudent object Read - "+st1);
			
		}finally {
			
		}
		
		
		}
}
