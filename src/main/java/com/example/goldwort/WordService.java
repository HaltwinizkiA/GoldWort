package com.example.goldwort;

import java.util.List;
import java.util.Scanner;

public class WordService {
    private static WordService exercises;
    private final Scanner scanner = new Scanner(System.in);
    private final int totalPoint;
    private final List<Word> wordList;
    private int i = 0;
    private int richtige = 0;

    public WordService(String path) {
        this.wordList = FileWorker.getWords(path);
        totalPoint = wordList.size();
    }

    public WordService() {
        this.wordList = FileWorker.getWords();
        totalPoint = wordList.size();
    }

    public static WordService getInstance() {
        if (exercises == null) {
            exercises = new WordService();
        }
        return exercises;
    }

    public int checkWord(String[] TestedWord, String inputWord) {
        int point = 0;
        for (String tested : TestedWord) {
            if (tested.equals(inputWord)) {
                System.out.println("Richtig");
                point = 1;
                break;
            }
        }
        if (point == 0) {
            System.out.println("Falsch");
        }
        return point;
    }

    public int getRight() {
        return richtige;
    }

    public String deMode(String answer) {
        try {
            Word word = wordList.get(i);
            richtige += checkWord(word.getRussian(), answer);
            i++;
            return "Richtige antwort:\n" + String.join(",", word.getRussian()) + " - " + String.join(",", word.getDeutsch());
        } catch (Exception e) {
            return "Die Wörte sind vorbei";
        }
    }

    public String getCount() {
        return i + "/" + wordList.size();
    }

    public Word getCurrentWord() {
        try {
            return wordList.get(i);
        } catch (Exception e) {
            return new Word(new String[]{"endet"}, new String[]{"закончились"});
        }
    }

    public String ruMode(String answer) {
        try {
            Word word = wordList.get(i);
            richtige += checkWord(word.getDeutsch(), answer);
            i++;
            return "Правильный ответ:\n" + String.join(",", word.getDeutsch()) + " - " + String.join(",", word.getRussian());
        } catch (Exception e) {
            return "Слова закончились";
        }
    }
}
// TODO: 04.04.2022 tun das alles worter,die Benutzer tippen und auch die aus document laden->In kleine Buch ändern,сделать что бы все буквы введенные и прочтенные в лов кейс и проверялись с лоу кейсом на правильность
//а превельный варик писался с большими буквами(wegen artikel und Nomens)