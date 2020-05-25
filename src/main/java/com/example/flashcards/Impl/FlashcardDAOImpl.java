package com.example.flashcards.Impl;

import com.example.flashcards.Entity.Cards;
import com.example.flashcards.Entity.Login;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Repository
public class FlashcardDAOImpl implements FlashcardDAO {
    private EntityManager manager;
    private Session sesh;
    private Random rand;

    @Autowired
    public FlashcardDAOImpl(EntityManager manager){this.manager=manager;}

    @Override
    @Transactional
    public List<Cards> listInventory() {
        sesh = manager.unwrap(Session.class);
        Query<Cards> listQuery = sesh.createQuery("from Parts");
        return listQuery.getResultList();
    }
    @Transactional
    @Override
    public Cards getCard(int theId) {
        sesh = manager.unwrap(Session.class);
        Cards card =sesh.get(Cards.class, theId);
        return card ;
    }
    @Transactional
    @Override
    public void saveAdmin(Login admin) {
        sesh = manager.unwrap(Session.class);
        sesh.saveOrUpdate(admin);
    }

    @Transactional
    @Override
    public Cards getRandomCard() {
        sesh = manager.unwrap(Session.class);
        ArrayList<Cards> cardList =(ArrayList<Cards>) listInventory();
        int limit = cardList.size()-1;
        int id =rand.nextInt(limit);
        System.out.println(limit);
        Cards card =sesh.get(Cards.class, id );
        return card ;
    }

    @Transactional
    @Override
    public void createCard(Cards card) {
        sesh= manager.unwrap(Session.class);
        sesh.saveOrUpdate(card);
    }
    @Transactional
    @Override
    public void updateCard(Cards card)
    {
        sesh = manager.unwrap(Session.class);
        sesh.update(card);
    }

    @Override
    public void deleteById(int theId) {
        sesh= manager.unwrap(Session.class);
        Cards card = sesh.get(Cards.class, theId);
        sesh.delete(card);
    }
}
