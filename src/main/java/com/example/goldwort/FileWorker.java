package com.example.goldwort;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileWorker {

    public static List<Word> getWords(String path) {
        List<Word> wortList = new ArrayList<>();
        path="C:\\Users\\golds\\IdeaProjects\\GoldWort\\src\\main\\java\\com\\example\\goldwort\\all";
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                new FileInputStream(path), StandardCharsets.UTF_8))) {

            String line = bufferedReader.readLine();
            while (line != null) {
                String[] word = line.split("-");
                String[] de = word[0].split(",");
                String[] ru = word[1].split(",");
                wortList.add(new Word(de, ru));
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return wortList;
    }
    public static List<Word> getWords(){
        List<Word> wortList = new ArrayList<>();
        String path="C:\\Users\\golds\\IdeaProjects\\GoldWort\\src\\main\\java\\com\\example\\goldwort\\all";
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                new FileInputStream(path), StandardCharsets.UTF_8))) {

            String line = bufferedReader.readLine();
            while (line != null) {
                String[] word = line.split("-");
                String[] de = word[0].split(",");
                String[] ru = word[1].split(",");
                wortList.add(new Word(de, ru));
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return wortList;
    }
}

