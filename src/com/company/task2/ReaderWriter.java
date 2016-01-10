package com.company.task2;

import com.company.KeyWords;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ira on 11.12.2015.
 */
public class ReaderWriter {

    private String fNameInput;
    private String fNameOutput;
    KeyWords keyWords = new KeyWords();
    private Map<String,Integer> mapKeyWords = new HashMap<>();

    public ReaderWriter() {

    }

    private void read() throws FileNotFoundException {

        StringBuilder sb = new StringBuilder();
        try {

            BufferedReader in = new BufferedReader(new FileReader( fNameInput));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);

                    sb.append("\n");
                }
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        String [] str = sb.toString().split(" ");
        for( String s: str){
            if( keyWords.findString(s) == 1){
                putStringToMap(s);
            }

        }
        System.out.println(mapKeyWords);

    }



    private void write(){
        //Определяем файл
        File file = new File(fNameOutput);

        try {
            //проверяем, что если файл не существует то создаем его
            if(!file.exists()){
                file.createNewFile();
            }

            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file);

            try {
                for(String key: mapKeyWords.keySet()){
                    out.print(key + "=" + mapKeyWords.get(key) + ",");

                }

            } finally {

                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void run(String fNameInput, String fNameOutput)throws IOException{
        this.fNameInput = fNameInput;
        this.fNameOutput = fNameOutput;
        read();
        write();
    }

    private void putStringToMap(String str){

        if(mapKeyWords.get(str)!= null){
            int value = mapKeyWords.get(str) + 1;
            mapKeyWords.put(str, value);
        }else{
            mapKeyWords.put(str,1);
        }

    }
}
