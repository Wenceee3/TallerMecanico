package com.iesvdc;

import com.iesvdc.dao.CocheDAO;
import com.iesvdc.dao.ReparacionDAO;
import com.iesvdc.dao.VentaDAO;
import com.iesvdc.model.Coche;
import com.iesvdc.model.Empleado;
import com.iesvdc.model.Reparacion;
import com.iesvdc.model.Venta;
import com.iesvdc.model.*;
import com.iesvdc.dao.*;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de DAOs
        CocheDAO cocheDAO = new CocheDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        ReparacionDAO reparacionDAO = new ReparacionDAO();
        VentaDAO ventaDAO = new VentaDAO();

        // Insertar datos de prueba
        insertarDatosDePrueba(cocheDAO, clienteDAO, empleadoDAO, reparacionDAO, ventaDAO);

        // Ejecutar consultas
        ejecutarConsultas(cocheDAO, reparacionDAO, ventaDAO);
    }

    private static void insertarDatosDePrueba(CocheDAO cocheDAO, ClienteDAO clienteDAO, EmpleadoDAO empleadoDAO, ReparacionDAO reparacionDAO, VentaDAO ventaDAO) {
        // Insertar 5 clientes
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Juan Pérez");
        cliente1.setEmail("juan@example.com");
        cliente1.setTelefono("123456789");
        clienteDAO.saveCliente(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setNombre("María López");
        cliente2.setEmail("maria@example.com");
        cliente2.setTelefono("987654321");
        clienteDAO.saveCliente(cliente2);

        Cliente cliente3 = new Cliente();
        cliente3.setNombre("Carlos Sánchez");
        cliente3.setEmail("carlos@example.com");
        cliente3.setTelefono("555555555");
        clienteDAO.saveCliente(cliente3);

        Cliente cliente4 = new Cliente();
        cliente4.setNombre("Ana García");
        cliente4.setEmail("ana@example.com");
        cliente4.setTelefono("666666666");
        clienteDAO.saveCliente(cliente4);

        Cliente cliente5 = new Cliente();
        cliente5.setNombre("Luis Martínez");
        cliente5.setEmail("luis@example.com");
        cliente5.setTelefono("777777777");
        clienteDAO.saveCliente(cliente5);

        // Insertar 10 empleados
        Empleado empleado1 = new Empleado();
        empleado1.setNombre("Carlos Gómez");
        empleado1.setPuesto("Mecánico");
        empleado1.setSalario(2000.0);
        empleadoDAO.saveEmpleado(empleado1);

        Empleado empleado2 = new Empleado();
        empleado2.setNombre("Laura Fernández");
        empleado2.setPuesto("Vendedor");
        empleado2.setSalario(1800.0);
        empleadoDAO.saveEmpleado(empleado2);

        Empleado empleado3 = new Empleado();
        empleado3.setNombre("Pedro Ramírez");
        empleado3.setPuesto("Mecánico");
        empleado3.setSalario(2100.0);
        empleadoDAO.saveEmpleado(empleado3);

        Empleado empleado4 = new Empleado();
        empleado4.setNombre("Sofía Torres");
        empleado4.setPuesto("Vendedor");
        empleado4.setSalario(1900.0);
        empleadoDAO.saveEmpleado(empleado4);

        Empleado empleado5 = new Empleado();
        empleado5.setNombre("Miguel Ruiz");
        empleado5.setPuesto("Mecánico");
        empleado5.setSalario(2050.0);
        empleadoDAO.saveEmpleado(empleado5);

        Empleado empleado6 = new Empleado();
        empleado6.setNombre("Elena Vargas");
        empleado6.setPuesto("Vendedor");
        empleado6.setSalario(1850.0);
        empleadoDAO.saveEmpleado(empleado6);

        Empleado empleado7 = new Empleado();
        empleado7.setNombre("Jorge Morales");
        empleado7.setPuesto("Mecánico");
        empleado7.setSalario(2200.0);
        empleadoDAO.saveEmpleado(empleado7);

        Empleado empleado8 = new Empleado();
        empleado8.setNombre("Carmen Díaz");
        empleado8.setPuesto("Vendedor");
        empleado8.setSalario(1950.0);
        empleadoDAO.saveEmpleado(empleado8);

        Empleado empleado9 = new Empleado();
        empleado9.setNombre("Roberto Jiménez");
        empleado9.setPuesto("Mecánico");
        empleado9.setSalario(2150.0);
        empleadoDAO.saveEmpleado(empleado9);

        Empleado empleado10 = new Empleado();
        empleado10.setNombre("Isabel Castro");
        empleado10.setPuesto("Vendedor");
        empleado10.setSalario(2000.0);
        empleadoDAO.saveEmpleado(empleado10);

        // Insertar 5 coches
        Coche coche1 = new Coche();
        coche1.setMarca("Toyota");
        coche1.setModelo("Corolla");
        coche1.setAño(2020);
        coche1.setPrecio(20000.0);
        cocheDAO.saveCoche(coche1);

        Coche coche2 = new Coche();
        coche2.setMarca("Ford");
        coche2.setModelo("Mustang");
        coche2.setAño(2019);
        coche2.setPrecio(35000.0);
        cocheDAO.saveCoche(coche2);

        Coche coche3 = new Coche();
        coche3.setMarca("Honda");
        coche3.setModelo("Civic");
        coche3.setAño(2021);
        coche3.setPrecio(22000.0);
        cocheDAO.saveCoche(coche3);

        Coche coche4 = new Coche();
        coche4.setMarca("Volkswagen");
        coche4.setModelo("Golf");
        coche4.setAño(2018);
        coche4.setPrecio(18000.0);
        cocheDAO.saveCoche(coche4);

        Coche coche5 = new Coche();
        coche5.setMarca("BMW");
        coche5.setModelo("X5");
        coche5.setAño(2022);
        coche5.setPrecio(50000.0);
        cocheDAO.saveCoche(coche5);

        // Insertar 3 ventas
        Venta venta1 = new Venta();
        venta1.setFecha(new Date(2023 - 1900, 9, 15)); // 15 de octubre de 2023
        venta1.setMonto(20000.0);
        venta1.setCliente(cliente1);
        venta1.setEmpleado(empleado2);
        ventaDAO.saveVenta(venta1);

        Venta venta2 = new Venta();
        venta2.setFecha(new Date(2023 - 1900, 9, 20)); // 20 de octubre de 2023
        venta2.setMonto(35000.0);
        venta2.setCliente(cliente2);
        venta2.setEmpleado(empleado4);
        ventaDAO.saveVenta(venta2);

        Venta venta3 = new Venta();
        venta3.setFecha(new Date(2023 - 1900, 9, 25)); // 25 de octubre de 2023
        venta3.setMonto(50000.0);
        venta3.setCliente(cliente3);
        venta3.setEmpleado(empleado6);
        ventaDAO.saveVenta(venta3);

        // Asociar coches a las ventas
        coche1.setVenta(venta1);
        cocheDAO.updateCoche(coche1);

        coche2.setVenta(venta2);
        cocheDAO.updateCoche(coche2);

        coche5.setVenta(venta3);
        cocheDAO.updateCoche(coche5);

        // Insertar 10 reparaciones
        Reparacion reparacion1 = new Reparacion();
        reparacion1.setDescripcion("Cambio de aceite");
        reparacion1.setFecha(new Date(2023 - 1900, 9, 10)); // 10 de octubre de 2023
        reparacion1.setCosto(100.0);
        reparacion1.setCoche(coche1);
        reparacion1.setEmpleado(empleado1);
        reparacionDAO.saveReparacion(reparacion1);

        Reparacion reparacion2 = new Reparacion();
        reparacion2.setDescripcion("Cambio de frenos");
        reparacion2.setFecha(new Date(2023 - 1900, 9, 12)); // 12 de octubre de 2023
        reparacion2.setCosto(200.0);
        reparacion2.setCoche(coche2);
        reparacion2.setEmpleado(empleado3);
        reparacionDAO.saveReparacion(reparacion2);

        Reparacion reparacion3 = new Reparacion();
        reparacion3.setDescripcion("Alineación y balanceo");
        reparacion3.setFecha(new Date(2023 - 1900, 9, 14)); // 14 de octubre de 2023
        reparacion3.setCosto(150.0);
        reparacion3.setCoche(coche3);
        reparacion3.setEmpleado(empleado5);
        reparacionDAO.saveReparacion(reparacion3);

        Reparacion reparacion4 = new Reparacion();
        reparacion4.setDescripcion("Cambio de bujías");
        reparacion4.setFecha(new Date(2023 - 1900, 9, 16)); // 16 de octubre de 2023
        reparacion4.setCosto(80.0);
        reparacion4.setCoche(coche4);
        reparacion4.setEmpleado(empleado7);
        reparacionDAO.saveReparacion(reparacion4);

        Reparacion reparacion5 = new Reparacion();
        reparacion5.setDescripcion("Revisión general");
        reparacion5.setFecha(new Date(2023 - 1900, 9, 18)); // 18 de octubre de 2023
        reparacion5.setCosto(120.0);
        reparacion5.setCoche(coche5);
        reparacion5.setEmpleado(empleado9);
        reparacionDAO.saveReparacion(reparacion5);

        Reparacion reparacion6 = new Reparacion();
        reparacion6.setDescripcion("Cambio de neumáticos");
        reparacion6.setFecha(new Date(2023 - 1900, 9, 20)); // 20 de octubre de 2023
        reparacion6.setCosto(300.0);
        reparacion6.setCoche(coche1);
        reparacion6.setEmpleado(empleado1);
        reparacionDAO.saveReparacion(reparacion6);

        Reparacion reparacion7 = new Reparacion();
        reparacion7.setDescripcion("Reparación de motor");
        reparacion7.setFecha(new Date(2023 - 1900, 9, 22)); // 22 de octubre de 2023
        reparacion7.setCosto(500.0);
        reparacion7.setCoche(coche2);
        reparacion7.setEmpleado(empleado3);
        reparacionDAO.saveReparacion(reparacion7);

        Reparacion reparacion8 = new Reparacion();
        reparacion8.setDescripcion("Cambio de correa de distribución");
        reparacion8.setFecha(new Date(2023 - 1900, 9, 24)); // 24 de octubre de 2023
        reparacion8.setCosto(250.0);
        reparacion8.setCoche(coche3);
        reparacion8.setEmpleado(empleado5);
        reparacionDAO.saveReparacion(reparacion8);

        Reparacion reparacion9 = new Reparacion();
        reparacion9.setDescripcion("Limpieza de inyectores");
        reparacion9.setFecha(new Date(2023 - 1900, 9, 26)); // 26 de octubre de 2023
        reparacion9.setCosto(90.0);
        reparacion9.setCoche(coche4);
        reparacion9.setEmpleado(empleado7);
        reparacionDAO.saveReparacion(reparacion9);

        Reparacion reparacion10 = new Reparacion();
        reparacion10.setDescripcion("Cambio de líquido de frenos");
        reparacion10.setFecha(new Date(2023 - 1900, 9, 28)); // 28 de octubre de 2023
        reparacion10.setCosto(70.0);
        reparacion10.setCoche(coche5);
        reparacion10.setEmpleado(empleado9);
        reparacionDAO.saveReparacion(reparacion10);
    }

    private static void ejecutarConsultas(CocheDAO cocheDAO, ReparacionDAO reparacionDAO, VentaDAO ventaDAO) {
        // Ejemplo de uso de las consultas HQL
        Date fechaInicio = new Date(2023 - 1900, 9, 1); // 1 de octubre de 2023
        Date fechaFin = new Date(2023 - 1900, 9, 31);   // 31 de octubre de 2023
        List<Coche> cochesVendidos = cocheDAO.getCochesVendidosEnRango(fechaInicio, fechaFin);
        System.out.println("Coches vendidos en octubre de 2023: " + cochesVendidos.size());

        List<Reparacion> reparacionesMecanico = reparacionDAO.getReparacionesPorMecanico(1); // ID del mecánico
        System.out.println("Reparaciones realizadas por el mecánico con ID 1: " + reparacionesMecanico.size());

        List<Coche> cochesCliente = cocheDAO.getCochesCompradosPorCliente(1); // ID del cliente
        System.out.println("Coches comprados por el cliente con ID 1: " + cochesCliente.size());

        double ingresosOctubre2023 = ventaDAO.getIngresosPorMes(10, 2023); // Octubre de 2023
        System.out.println("Ingresos por ventas en octubre de 2023: " + ingresosOctubre2023);
    }
}