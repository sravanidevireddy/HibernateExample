package academy.ausgrads.example.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import academy.ausgrads.example.entity.Name;

public class SessionPersistExample {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Name name = new Name();
			name.setId(2l);
			name.setName("Devireddy");// set the name
			session.persist(name);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		HibernateUtil.shutdown();
	}
}
