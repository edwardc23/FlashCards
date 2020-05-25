package com.example.flashcards.Impl;

import com.example.flashcards.Entity.Login;

public interface LoginDAO {

    Login saveAdmin(Login admin);
    Login getAdmin(int id);
   boolean checkAdmin(Login Admin);
}
