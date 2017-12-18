/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import po.Datum;

/**
 *
 * @author Administrator
 */
public class DatumDao {

    private SessionFactory sessionFactory = SessionFactoryUtil.sessionFactory;

    public Datum match(String str) {
        Session session = sessionFactory.openSession();
        List<Datum> list = session.createNativeQuery("select * from datum", Datum.class).list();
        for (int i = 0; i < list.size(); i++) {
            if (str.contains(list.get(i).getNum())) {
                session.close();
                return list.get(i);
            }
        }
        return null;
    }

    public Datum findByNum(String num) {
        Session session = sessionFactory.openSession();
        List<Datum> list = session.createNativeQuery("select * from datum where num=" + num + "", po.Datum.class).list();
        if (!list.isEmpty()) {
            session.close();
            return list.get(0);
        }
        return null;
    }

    public void DeleteByNum(String num) {
        Session session = sessionFactory.openSession();
        Datum datum = findByNum(num);
        if (datum != null) {
            session.getTransaction().begin();
            try {
                session.delete(datum);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
            }
        }
    }

    public void add(Datum datum) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        try {
            session.save(datum);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        session.close();
    }
}
