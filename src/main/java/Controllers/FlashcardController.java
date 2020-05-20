package Controllers;

import Entity.Cards;
import Entity.Login;
import Impl.FlashcardDAO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class FlashcardController {

        private final FlashcardDAO flashcardDao;

        public FlashcardController(FlashcardDAO flashcardDao) {
            this.flashcardDao = flashcardDao;
        }


        //grabs entire inventory listing
        @GetMapping("/grabInventory")
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
//        //deletes entire inventory
//        @DeleteMapping("/deleteStockList")
//        public String clearInventory(){
////        if (inventory.size() == 0){
////            throw new RuntimeException("The stock list is already empty");
////        }
//            dao.clearInventory();
//            return "The entire inventory has been wiped";
//        }
//
//        //updates item by ID
//        @PutMapping("/update")
//        public Parts updateItem(@RequestBody Parts newItem){
//            dao.saveNew(newItem);
//            return newItem;
//        }
//
//        //adds and stores a new item
//        @PostMapping("/addItem")
//        public Parts addItem(@RequestBody Parts item){
//            item.setId(0);
//            dao.saveNew(item);
//            System.out.println(item);
//            return item;
//        }
//

//
//        @PostMapping("/checkAdmin")
//        public String checker(@RequestBody Admin admin)
//        {
//            if(dao.checkUserAndPass(admin))
//            {
//                return "Success";
//            }
//            else
//            {
//                return "Failure";
//            }
////        return "Success";
//
//        }
        @DeleteMapping("/delete/{partID}")
        public String removeItem(@PathVariable int cardID){
            Cards card = flashcardDao.getCard(cardID);
            if(card== null){
                throw new RuntimeException("Couldn't find an item in inventory with ID:" + cardID);
            }
            flashcardDao.deleteById(cardID);
            return "Deleted item from inventory with ID:" + cardID;
        }
    }


