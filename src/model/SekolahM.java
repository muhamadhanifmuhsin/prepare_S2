/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Sekolah;
import interfaces.SekolahIF;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author hanif
 */
public class SekolahM implements SekolahIF {

    Session s;
    Transaction t;

    @Override
    public void save(Sekolah b) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        s = HibernateUtil.getSessionFactory().openSession();
        t = s.beginTransaction();
        s.save(b);
        t.commit();
        s.close();
    }

    @Override
    public void update(Sekolah b) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        s = HibernateUtil.getSessionFactory().openSession();
        t = s.beginTransaction();
        s.update(b);
        t.commit();
        s.close();
    }

    @Override
    public void delete(Sekolah b) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        s = HibernateUtil.getSessionFactory().openSession();
        t = s.beginTransaction();
        s.delete(b);
        t.commit();
        s.close();
    }

    @Override
    public List<Sekolah> read() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("FROM Sekolah");
        List<Sekolah> ls = q.list();
        return ls;
    }

    @Override
    public List<Sekolah> find(String key) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("FROM Sekolah WHERE nama_sekolah LIKE :nama_sekolah");
        q.setString("nama_sekolah", "%"+key+"%");
        List<Sekolah> ls = q.list();
        return ls;
    }

}
