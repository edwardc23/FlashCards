package Impl;

import Entity.Cards;
import Entity.Login;

import java.util.List;

public interface FlashcardDAO {
    List<Cards> listInventory();
    Cards getCard(int theId);
    void saveAdmin(Login admin);
    Cards getRandomCard();
    void createCard(Cards card);
    void deleteById(int theId);
}
