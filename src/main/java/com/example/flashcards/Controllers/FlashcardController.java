package com.example.flashcards.Controllers;

import com.example.flashcards.Entity.Cards;
import com.example.flashcards.Impl.FlashcardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class FlashcardController {

        private final FlashcardDAO flashcardDao;
        @Autowired
        public FlashcardController(FlashcardDAO flashcardDao) {
            this.flashcardDao = flashcardDao;
        }


        //grabs entire inventory listing
        @GetMapping("/grabAll")
        public List<Cards> listInventory(){return flashcardDao.listInventory();}


        //retrieves a single item by ID
        @GetMapping("/retrieveItem/{cardID}")
        public Cards item(@PathVariable int cardID){
            Cards item = flashcardDao.getCard(cardID);
            if(item == null){
                throw new RuntimeException("Couldn't find an item in inventory with ID:" + cardID);
            }

            return item;
        }
//
//
        //updates item by ID
        @PutMapping("/update")
        public Cards updateItem(@RequestBody Cards card){
            flashcardDao.updateCard(card);
            return card;
        }

        //adds and stores a new item
        @PostMapping("/addCard")
        public Cards addItem(@RequestBody Cards card){
            card.setId(0);
            flashcardDao.createCard(card);

            return card;
        }



        @DeleteMapping("/delete/{cardID}")
        public String removeItem(@PathVariable int cardID){
            Cards card = flashcardDao.getCard(cardID);
            if(card== null){
                throw new RuntimeException("Couldn't find an item in inventory with ID:" + cardID);
            }
            flashcardDao.deleteById(cardID);
            return "Deleted item from inventory with ID:" + cardID;
        }
    }


