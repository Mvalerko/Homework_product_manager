package org.example;

public class Book extends Product {
    private String author;
    private String title;

    public Book(int idOpt, String nameOpt, int priceOpt, String authorOpt, String titleOpt) {
        super(idOpt, nameOpt, priceOpt);
        this.author = authorOpt;
        this.title = titleOpt;

    }

    @Override
    public void use() {
        System.out.println("Читаем книгу: " + name);
    }

    @Override
    public boolean isTooExpensive() {
        if (price > 10_000) {
            return true;
        } else {
            return false;
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String authorOpt) {
        this.author = authorOpt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String titleOpt) {
        this.title = titleOpt;
    }

}
