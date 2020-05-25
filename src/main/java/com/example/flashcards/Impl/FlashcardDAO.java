package com.example.flashcards.Impl;

import com.example.flashcards.Entity.Cards;
import com.example.flashcards.Entity.Login;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FlashcardDAO {
    List<Cards> listInventory();
    Cards getCard(int theId);
    void saveAdmin(Login admin);
    Cards getRandomCard();
    void createCard(Cards card);

    @Transactional
    void updateCard(Cards card);

    void deleteById(int theId);
}
