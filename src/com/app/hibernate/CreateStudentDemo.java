package com.app.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.lhibernate.entity.Student;

public class CreateStudentDemo {
	
	public static void main(String[] args) {
		
		// Create session factory
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
			
		}finally {
			
		}
		
		
		}
}
