package com.annton.web_lab3;



import com.annton.web_lab3.entity.Result;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DatabaseManager {
    private final SessionFactory sessionFactory;

    DatabaseManager() {
        // Создание фабрики сессий на основе конфигурации Hibernate
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Result.class); // Подключение класса Result к Hibernate
        sessionFactory = configuration.buildSessionFactory();
    }

    public Result createRow(float x, float y, float r, boolean isHit) {
        Result result = new Result();
        result.setX(x);
        result.setY(y);
        result.setR(r);
        result.setHit(isHit);

        return result;
    }

    public void add(Result result) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(result);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clear() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Result").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Result> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Result ORDER BY id DESC", Result.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

