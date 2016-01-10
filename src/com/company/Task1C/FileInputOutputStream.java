package com.company.Task1C;

import com.company.KeyWords;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ira on 11.12.2015.
 */
public class FileInputOutputStream {

    private Map<String, Integer> mapKeyWords = new HashMap<>();
    KeyWords keyWords = new KeyWords();

    // полный путь к файлу
    private String fNameInput;
    private String fNameOutput;

    public FileInputOutputStream(String fNameInput, String fNameOutput) {
        this.fNameInput = fNameInput;
        this.fNameOutput = fNameOutput;
    }

    public void read() throws IOException {

        FileInputStream inputStream = new FileInputStream(fNameInput);  // Класс для работы потоком вывода из файла
        // читаем первый символ с потока байтов

        try {
            int data = inputStream.read();
            char content;
            char delimiter = ' ';
            String tmp = "";
            while (data != -1) {
                // переводим байты в символ
                content = (char) data;
                if (content != delimiter) {
                    tmp += content;
                } else {
                    if (keyWords.findString(tmp) == 1) {
                        putStringToMap(tmp);
                    }
                    tmp = "";
                }
                data = inputStream.read(); // читаем следующий байты символа
            }
            //System.out.println(mapKeyWords);
        } finally {
            inputStream.close(); //закрываем поток
        }


    }

    public void write() throws IOException {
        try {
            FileOutputStream outputStream = new FileOutputStream(fNameOutput);

            for (String key : mapKeyWords.keySet()) {
                outputStream.write(key.getBytes());
                outputStream.write("=".getBytes());

                outputStream.write((mapKeyWords.get(key)).toString().getBytes());
                outputStream.write(",".getBytes());
            }

            outputStream.close();    // !!! уточнить, где закрывать поток
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void putStringToMap(String str) {

        if (mapKeyWords.get(str) != null) {
            int value = mapKeyWords.get(str) + 1;
            mapKeyWords.put(str, value);
        } else {
            mapKeyWords.put(str, 1);
        }

    }


}
