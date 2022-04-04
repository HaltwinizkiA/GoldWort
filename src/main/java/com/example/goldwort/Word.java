package com.example.goldwort;

public class Word {
    private String[] deutsch;
    private String[] russian;

    public String[] getDeutsch() {
        return deutsch;
    }

    public void setDeutsch(String[] deutsch) {
        this.deutsch = deutsch;
    }

    public String[] getRussian() {
        return russian;
    }

    public void setRussian(String[] russian) {
        this.russian = russian;
    }

    public Word(String[] deutsch, String[] russian) {
        this.deutsch = deutsch;
        this.russian = russian;
    }
}
