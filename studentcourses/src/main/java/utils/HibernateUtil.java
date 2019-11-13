package utils;



import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
public class HibernateUtil{

	@Autowired
	private static EntityManager entityManager;

    public static void closeSession() {
    	getSession().close();
    }

    public static Session getSession() {
    	
    	return entityManager.getEntityManagerFactory().unwrap(SessionFactory.class).openSession();
    	
    }
}
