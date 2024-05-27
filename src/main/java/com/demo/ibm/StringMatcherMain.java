package com.demo.ibm;

import com.demo.ibm.matcher.StringMatcher;
import com.demo.ibm.reader.FileReader;
import javafx.util.Pair;

import java.util.List;

public class StringMatcherMain {

    public static void main(String[] args) {
        FileReader reader = new FileReader();
        StringMatcher matcher = new StringMatcher();
        List<String> inputList = reader.read();
        Pair<Integer, List<String>> resultPair = matcher.match(inputList);
        System.out.println("Longest String: " + resultPair.getValue().get(0));
        System.out.println("Second Longest String: " + resultPair.getValue().get(1));
        System.out.println("Number of strings that can be formed: " + resultPair.getKey());
    }


}
