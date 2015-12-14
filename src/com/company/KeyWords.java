package com.company;

import java.util.Map;

/**
 * Created by Ira on 11.12.2015.
 */
public class KeyWords {

    private final String[] keyWords = {"abstract", "continue", "for", "new", "switch",
            "assert", "default", "goto", "package", "synchronized",
            "boolean", "do", "if", "private", "this",
            "break", "double", "implements", "protected", "throw",
            "byte", "else", "import", "public", "throws",
            "case", "enum", "instanceof", "return", "transient",
            "catch", "extends", "int", "short", "try",
            "char", "final", "interface", "static", "void",
            "class", "finally", "long", "strictfp", "volatile",
            "const", "float", "native", "super", "while"};

    public int findString(String str) {

        for (String s : keyWords) {
            if (s.hashCode() == str.hashCode()) {
                if (s.equals(str)) {
                    System.out.println(str);
                    return 1;
                } else {
                    return 0;
                }
            }
        }
        return -1;
    }


}
