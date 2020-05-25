package com.example.flashcards.Entity;

import javax.persistence.*;


@Entity
@Table(name="cards")
public class Cards {

    @Id //This will map the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This will auto increment your primary key
    @Column(name = "ID") //This is mapping the primary key to the id column in the table.
    private int id;

    @Column(name="Question")
    private String question;

    @Column(name="Answer")
    private  String answer;



    public Cards(){}

    public Cards(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Cards{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
