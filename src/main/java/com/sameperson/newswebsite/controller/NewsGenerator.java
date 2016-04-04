package com.sameperson.newswebsite.controller;

import com.sameperson.newswebsite.model.NewsBean;

import java.util.Random;

public class NewsGenerator {

    private Random random = new Random();

    private char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private String[] nouns = {"cat", "dog", "man", "woman", "citizen of Kiev", "firefighter", "policeman", "user", "python programmer", "java programmer", "writer", "janitor", "german", "ghost",
            "soldier", "horse", "major", "president", "web designer", "QA engineer", "teacher", "lead developer", "comic fan", "forex trader", "famous singer", "candidate for president", "theologist",
            "astronomer", "sea captain", "corrupted judge"};
    private String[] verbs = {"started teaching", "burned", "vandalized", "hit", "jumped on", "ran away from", "wrote to", "went to", "left his", "slapped", "insulted", "danced with",
            "bought drugs from", "robbed", "attacked", "wonders how to become a", "volunteered to help", "bit", "dislikes", "addicted to", "thinks about", "suspicious"};
    private String[] adjectives = {"kind", "white", "black", "depressed", "evil", "generous", "infamous", "large", "tiny", "expensive", "cheap", "cruel", "chinese", "bored", "famous", "forgotten",
            "naive", "talented", "poor"};

    public NewsBean generateNews() {
        return new NewsBean(generateName(), getRandomSentence(),  generateBody());
    }

    private String generateBody() {
        int numberOfSentences = random.nextInt(20)+21;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfSentences; i++) {
            sb.append(getRandomSentence()+". ");
        }
        return sb.toString();
    }

    private String generateName() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    private String getRandomSentence() {
        String firstWord = nouns[random.nextInt(nouns.length)];
        String sentence = firstWord.substring(0, 1).toUpperCase() + firstWord.substring(1) + " "
                + verbs[random.nextInt(verbs.length)] + " "
                + adjectives[random.nextInt(adjectives.length)] + " "
                + nouns[random.nextInt(nouns.length)];
        return sentence;
    }
}
