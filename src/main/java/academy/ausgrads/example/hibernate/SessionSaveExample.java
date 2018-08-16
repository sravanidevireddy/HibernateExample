package academy.ausgrads.example.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import academy.ausgrads.example.entity.Name;

public class SessionSaveExample {
  public static void main(String[] args) {
    Session session = null;
    Transaction transaction = null;

    try {

      session = HibernateUtil.getSessionFactory().openSession();
      transaction = session.beginTransaction();
      //transaction.begin();

      Name name = new Name();
      name.setId(1l);
      name.setName("Peter");
      session.save(name);

      transaction.commit();

    } catch (Exception e) {
      e.printStackTrace();
      if (transaction != null) {
        transaction.rollback();
      }
    } finally {
      if (session != null) {
        session.close();
      }
    }

    HibernateUtil.shutdown();
  }
}
