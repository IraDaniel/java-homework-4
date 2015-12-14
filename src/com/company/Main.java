package com.company;

import com.company.Task1.FileInputOutputStream;
import com.company.Task2.ReaderWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

       /* FileInputOutputStream fileInputOutputStream = new FileInputOutputStream("Notebook.java","result1.txt");
        fileInputOutputStream.read();
        fileInputOutputStream.write();

        ReaderWriter readerWriter = new ReaderWriter("Notebook.java","result2.txt");
        readerWriter.read();
        readerWriter.write();
        */

        Map<String,Integer> mp = new HashMap<>();
        mp.put("a",1);
        mp.put("b",1);

        System.out.println(mp);
        mp.put("a",2);
        System.out.println(mp);

        /*
        * BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(tmpFile), Charset.forName("UTF-8")));
        * */

	// write your code here
    }
}
