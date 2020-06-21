package com.app.hibernate;

import java.util.List;

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
			
			/**
			 * ** -- QUERY THE TABLE
			 * We use HQL (Hibernate Query language)
			 * Inside the HQL, we use Entity class names instead of table names as in SQL.
			 * Inside the HQL, we use Entity class attribute names instead of column names as in SQL.
			 * We are not using SELECT * in the query as that is understood.
			 */
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			@SuppressWarnings("unchecked")
			List<Student> result = session.createQuery("from Student s where s.firstName='Piyush'")
			.getResultList();
			
			session.getTransaction().commit();
			
			System.out.println("\nFetched results");
			for(Student s : result) {
				System.out.println(s);
			}
			
			/**
			 * Updating objects.
			 * No need to call the .update or .save method explicitly. As the Student 
			 * Object is a persistent object. So just calling a setter on it will update 
			 * the DB.
			 */
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Student s = session.get(Student.class, st.getId());
			
			s.setFirstName("Ameer"); // This will automatically update in DB. As s is a persistent object. Magic of hibernate.
			
			session.getTransaction().commit();
			
			/**
			 * --- UPDATE QUERY
			 */
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student set lastName='Piku'").executeUpdate();
			session.getTransaction().commit();
			
			/**
			 * Delete an object
			 */
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.delete(st);
			session.getTransaction().commit();
			
			/**
			 * Deleting with query
			 */
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete from Student where id=2")
				   .executeUpdate();
			session.getTransaction().commit();

			
		}finally {
			
		}
		
		
		}
}
