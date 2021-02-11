package com.example.demo.crud;

import com.example.demo.entity.Bill;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.*;
@Repository
public class BillIMPL implements CRUD{
    private final EntityManager manager;

    @Autowired
    public BillIMPL(EntityManager manager){
        this.manager = manager;
    }
    @Override
    @Transactional
    public List<Object> searchAll() {
        Session current = manager.unwrap(Session.class);
        Query<Object> query = current.createQuery("from Bill");
        return query.getResultList();
    }

    @Override
    @Transactional
    public Object searchId(int theId) {
        Session currentSession = manager.unwrap(Session.class);
        return currentSession.get(Bill.class, theId);    }

    @Override
    @Transactional
    public void saveUpdate(Object object) {
        Session currentSession = manager.unwrap(Session.class);
        currentSession.saveOrUpdate(object);
    }

    @Override
    @Transactional
    public void deleteId(int theId) {
        Session currentSession = manager.unwrap(Session.class);
        Bill bill = currentSession.get(Bill.class, theId);
        currentSession.delete(bill);

    }
}
