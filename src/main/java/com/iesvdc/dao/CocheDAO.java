package com.iesvdc.dao;

import com.iesvdc.model.Coche;
import com.iesvdc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class CocheDAO {

    public void saveCoche(Coche coche) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(coche);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Coche getCocheById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Coche.class, id);
        }
    }

    public void updateCoche(Coche coche) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(coche);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteCoche(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Coche coche = session.get(Coche.class, id);
            if (coche != null) {
                session.delete(coche);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public List<Coche> getCochesVendidosEnRango(Date fechaInicio, Date fechaFin) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT c FROM Coche c JOIN c.venta v WHERE v.fecha BETWEEN :fechaInicio AND :fechaFin";
            Query<Coche> query = session.createQuery(hql, Coche.class);
            query.setParameter("fechaInicio", fechaInicio);
            query.setParameter("fechaFin", fechaFin);
            return query.getResultList();
        }
    }
    public List<Coche> getCochesCompradosPorCliente(int clienteId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT c FROM Coche c JOIN c.clientes cl WHERE cl.id = :clienteId";
            Query<Coche> query = session.createQuery(hql, Coche.class);
            query.setParameter("clienteId", clienteId);
            return query.getResultList();
        }
    }
}
