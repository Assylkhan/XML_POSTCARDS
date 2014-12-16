package com.epam.entity;

import java.time.Year;

public class PostCard {
    private long id;
    private Theme theme;
    private CardType cardType;
    private String country;
    private Year year;
    private String author;
    private Valuable valuable;

    public PostCard(){}

    public PostCard(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Valuable getValuable() {
        return valuable;
    }

    public void setValuable(Valuable valuable) {
        this.valuable = valuable;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "PostCard{" +
                "id=" + id +
                ", theme=" + theme +
                ", cardType=" + cardType +
                ", country='" + country + '\'' +
                ", year='" + year + '\'' +
                ", author='" + author + '\'' +
                ", valuable=" + valuable +
                '}';
    }
}
