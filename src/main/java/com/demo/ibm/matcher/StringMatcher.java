package com.demo.ibm.matcher;

import javafx.util.Pair;

import java.util.*;

public class StringMatcher {

    public Pair<Integer, List<String>> match(List<String> input) {
        int countOfStrings = 0;
        Collections.sort(input, Comparator.comparing(String::length).reversed());
        Set<String> wordSet = new HashSet<>(input);
        List<String> outputList = new ArrayList<>();
        for(String word : input) {
            wordSet.remove(word);
            if(calculatePrefix(word, wordSet)) {
                countOfStrings++;
                if(outputList.size() < 2)
                    outputList.add(word);
            }
        }
        return new Pair<>(countOfStrings, outputList);
    }

    public boolean calculatePrefix(String word, Set<String> wordSet) {

        boolean array[] = new boolean[word.length() + 1];
        array[0] = true;
        if(wordSet.size() == 0)
            return false;
        for(int j = 1 ; j <= word.length() ; j++) {
            for(int i = 0; i < j ; i++ )
                if(array[i]  && wordSet.contains(word.substring(i, j))) {
                    array[j] = true;
                    break;
                }
        }
        return array[word.length()];
    }
}
