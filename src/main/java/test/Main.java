package test;

import entities.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = config.buildSessionFactory();

        Session session = sessionFactory.openSession();

        //R read
        UserEntity dbEntity = session.get(UserEntity.class, 3);

        System.out.println(dbEntity);

        Transaction transaction = session.beginTransaction();

        UserEntity userEntity = new UserEntity();
        userEntity.setAge(100);
        userEntity.setName("my new name");
        userEntity.setBirthDate(LocalDate.now());
        //ENTITY IS IN STATE NEW/TRANSIENT

        //C - create
        session.persist(userEntity);
        //ENTITY IS STATE PERSISTENT

        transaction.commit();
        session.close();

        //ENTITY IS IN STATE DETACHED

        userEntity.setName("NEW NAMEEE");

        //ENTITY IS IN STAT4E DETACHED

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        //U - update
        UserEntity mergedEntity = session.merge(userEntity);
        //UPDATE NOT PERFORMED IN DB
        //ENTITY IS IN PERSISTENT STATE

        transaction.commit(); //UPDATE IS REFLECTED IN DB
        session.close();

        //ENTITY IS IN DETACHED STATE

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        //D - delete
        session.remove(mergedEntity);
        //ENTITY IS IN REMOVED STATE

        transaction.commit(); //UPDATE IS REFLECTED IN DB
        session.close();

    }
}
