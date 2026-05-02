package com.klef.fsad.exam;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.*;

public class BookingDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // 1️⃣ Insert Records (Persistent Object)
        Booking b1 = new Booking("Harsha", new Date(), "Confirmed", "Hyderabad", 5000);
        Booking b2 = new Booking("Ravi", new Date(), "Pending", "Chennai", 3000);

        session.save(b1);
        session.save(b2);

        tx.commit();

        // 2️⃣ View All Records using HQL (No WHERE Clause)
        Session session2 = factory.openSession();

        String hql = "FROM Booking";
        Query query = session2.createQuery(hql);

        List<Booking> list = query.list();

        System.out.println("\nAll Booking Records:");
        for (Booking b : list) {
            System.out.println(
                b.getId() + " " +
                b.getName() + " " +
                b.getDate() + " " +
                b.getStatus() + " " +
                b.getLocation() + " " +
                b.getAmount()
            );
        }

        session2.close();
        factory.close();
    }
}