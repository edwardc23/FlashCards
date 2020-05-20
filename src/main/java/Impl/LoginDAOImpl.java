package Impl;

import Entity.Login;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Random;

public class LoginDAOImpl implements  LoginDAO{
    private EntityManager manager;
    private Session sesh;
    private Random rand;
    @Autowired
    public LoginDAOImpl(EntityManager manager){this.manager=manager;}

    @Transactional
    @Override
    public Login saveAdmin(Login admin) {
        sesh = manager.unwrap(Session.class);
        sesh.saveOrUpdate(admin);
        return admin;
    }

    public List<Login> listInventory() {
        sesh = manager.unwrap(Session.class);
        Query<Login> listQuery = sesh.createQuery("from Admininfo");
        return listQuery.getResultList();
    }
    @Transactional
    @Override
    public Login getAdmin(int id) {
        sesh= manager.unwrap(Session.class);
        Login user= sesh.get(Login.class,id);
        return user;
    }

    @Transactional
    @Override
    public boolean checkAdmin(Login Admin) {
    List<Login> list = listInventory();
    for(Login a :list)
    {
        if(a.getUsername().equals(Admin.getUsername())){
            if (a.getPassword().equals(Admin.getPassword()))
            {
                return true;
            }
        }

    }
        return false;
    }
}
