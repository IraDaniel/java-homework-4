package com.company;

import com.company.task1.FileInputOutputStream;
import com.company.task2.ReaderWriter;
import com.company.task3.ReaderWriterEncode;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        FileInputOutputStream fileInputOutputStream = new FileInputOutputStream();
        fileInputOutputStream.run("Notebook.java","result1.txt");

        fileInputOutputStream.run("test.java","result3.txt");

        /*ReaderWriter readerWriter = new ReaderWriter();
        readerWriter.run("Notebook.java","result2.txt");

        ReaderWriterEncode readerWriterEncode = new ReaderWriterEncode();
        readerWriterEncode.run("new.txt", "a.txt");
        */
    }
}
