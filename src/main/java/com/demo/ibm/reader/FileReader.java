package com.demo.ibm.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public List<String>  read() {
        List<String> stringList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/wordsforproblem.txt"));
            while(scanner.hasNextLine()) {
                stringList.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return stringList;
    }
}
