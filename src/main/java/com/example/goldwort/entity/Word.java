package com.example.goldwort.entity;

public class Word {
    private String[] left;
    private String[] right;

    public Word(String[] deutsch, String[] russian) {
        this.left = deutsch;
        this.right = russian;
    }

    public String[] getLeft() {
        return left;
    }

    public void setLeft(String[] left) {
        this.left = left;
    }

    public String[] getRight() {
        return right;
    }

    public void setRight(String[] right) {
        this.right = right;
    }
}
