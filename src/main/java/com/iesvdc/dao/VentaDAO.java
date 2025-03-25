package com.iesvdc.dao;

import com.iesvdc.model.Venta;
import com.iesvdc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class VentaDAO {

    public void saveVenta(Venta venta) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(venta);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Venta getVentaById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Venta.class, id);
        }
    }

    public void updateVenta(Venta venta) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(venta);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteVenta(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Venta venta = session.get(Venta.class, id);
            if (venta != null) {
                session.delete(venta);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public double getIngresosPorMes(int mes, int año) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT SUM(v.monto) FROM Venta v WHERE MONTH(v.fecha) = :mes AND YEAR(v.fecha) = :año";
            Query<Double> query = session.createQuery(hql, Double.class);
            query.setParameter("mes", mes);
            query.setParameter("año", año);
            Double resultado = query.uniqueResult();
            return resultado != null ? resultado : 0.0;
        }
    }
}