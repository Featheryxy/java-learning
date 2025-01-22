package com.feather.gof.interpreter.Sample;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            String path = "F:\\GitHubNote\\java-learning\\src\\main\\java\\com\\feather\\gof\\interpreter\\Sample\\program.txt";
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String text;
            while ((text = reader.readLine()) != null) {
                System.out.println("text = \"" + text + "\"");
                Node node = new ProgramNode();
                node.parse(new Context(text));
                System.out.println("node = " + node);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
