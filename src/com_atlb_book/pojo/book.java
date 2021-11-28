package com_atlb_book.pojo;

/**
 * @ClassName book
 * @Description TODO
 * @Author 城南
 * @Date 2021/11/28 11:14
 * @Version 1.0
 **/
public class book {
    private String name;
    private int oprice;
    private int num;
    private String author;
    private int inventory;
    private int kind;

    public book(String name, int oprice, int num, String author, int inventory, int kind) {
        this.name = name;
        this.oprice = oprice;
        this.num = num;
        this.author = author;
        this.inventory = inventory;
        this.kind = kind;
    }

    public book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOprice() {
        return oprice;
    }

    public void setOprice(int oprice) {
        this.oprice = oprice;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "book{" +
                "name='" + name + '\'' +
                ", oprice=" + oprice +
                ", num=" + num +
                ", author='" + author + '\'' +
                ", inventory=" + inventory +
                ", kind=" + kind +
                '}';
    }
}
