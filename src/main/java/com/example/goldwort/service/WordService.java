package com.example.goldwort.service;

import com.example.goldwort.entity.Word;
import com.example.goldwort.util.FileWorker;

import java.util.List;

public class WordService {
    private static final String ANSWERTRUE = "TRUE";
    private static final String ANSWERFALSE = "FALSE";
    private static WordService exercises;
    private final List<Word> wordList;
    private int i = 0;
    private int rightCount = 0;
    private String checkAnswer = "";

    public WordService(String path) {
        this.wordList = FileWorker.getWords(path);
    }

    public WordService() {
        this.wordList = FileWorker.getWords();
    }

    public static String getANSWERTRUE() {
        return ANSWERTRUE;
    }

    public static String getANSWERFALSE() {
        return ANSWERFALSE;
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
            if (tested.equalsIgnoreCase(inputWord)) {
                this.checkAnswer = ANSWERTRUE;
                point = 1;
                break;
            }
        }
        if (point == 0) {
            this.checkAnswer = ANSWERFALSE;
        }
        return point;
    }

    public String getCheckAnswer() {
        return checkAnswer;
    }

    public int getRightCount() {
        return rightCount;
    }

    public String getCount() {
        return i + "/" + wordList.size();
    }

    public Word getCurrentWord() {
        try {
            return wordList.get(i);
        } catch (Exception e) {
            return new Word(new String[]{"End"}, new String[]{"End"});
        }
    }

    public List<Word> getWordList() {
        return wordList;
    }

    public String rightMode(String answer) {
        try {
            Word word = wordList.get(i);
            rightCount += checkWord(word.getLeft(), answer);
            i++;
            return "Right answer :\n" + String.join(",", word.getLeft()) + " - " + String.join(",", word.getRight());
        } catch (Exception e) {
            return "Finish";
        }
    }

    public String leftMode(String answer) {
        try {
            Word word = wordList.get(i);
            rightCount += checkWord(word.getRight(), answer);
            i++;
            return "Richtige antwort:\n" + String.join(",", word.getRight()) + " - " + String.join(",", word.getLeft());
        } catch (Exception e) {
            return "Die Wörte sind vorbei";
        }
    }
}
