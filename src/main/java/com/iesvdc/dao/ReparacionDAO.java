package com.iesvdc.dao;

import com.iesvdc.model.Reparacion;
import com.iesvdc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ReparacionDAO {

    public void saveReparacion(Reparacion reparacion) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(reparacion);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Reparacion getReparacionById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Reparacion.class, id);
        }
    }

    public void updateReparacion(Reparacion reparacion) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(reparacion);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteReparacion(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Reparacion reparacion = session.get(Reparacion.class, id);
            if (reparacion != null) {
                session.delete(reparacion);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public List<Reparacion> getReparacionesPorMecanico(int empleadoId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Reparacion r WHERE r.empleado.id = :empleadoId";
            Query<Reparacion> query = session.createQuery(hql, Reparacion.class);
            query.setParameter("empleadoId", empleadoId);
            return query.getResultList();
        }
    }
}
