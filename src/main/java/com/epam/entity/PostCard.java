package com.epam.entity;

public class PostCard {
    private long id;
    private Theme theme;
    private CardType cardType;
    private String country;
    private String year;
    private String author;
    private Valueable valueable;

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Valueable getValueable() {
        return valueable;
    }

    public void setValueable(Valueable valueable) {
        this.valueable = valueable;
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
                ", valueable=" + valueable +
                '}';
    }
}
