package com.company.task3;

import java.io.*;

/**
 * Created by Ira on 11.12.2015.
 */
public class ReaderWriterEncode {


    public ReaderWriterEncode() {
    }


    public void run(String fNameInput, String fNameOutput) {

        try {
            Reader reader = new InputStreamReader(new FileInputStream(fNameInput), "UTF-8");
            BufferedReader fin = new BufferedReader(reader);
            Writer writer = new OutputStreamWriter(new FileOutputStream(fNameOutput), "UTF-16");
            BufferedWriter fout = new BufferedWriter(writer);
            String s;
            while ((s = fin.readLine()) != null) {
                fout.write(s);
                fout.newLine();
            }

            fin.close();
            fout.close();

        } catch (IOException e) {

            System.err.println(e);

        }
    }


}
