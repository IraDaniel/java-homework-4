package com.company.task1;

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

    private Map<String, Integer> mapKeyWords;
    KeyWords keyWords = new KeyWords();

    // ������ ���� � �����
    private String fNameInput;
    private String fNameOutput;

    public FileInputOutputStream() {    }

    private void read() throws IOException {
        mapKeyWords = new HashMap<>();
        FileInputStream inputStream = new FileInputStream(fNameInput);  // ����� ��� ������ ������� ������ �� �����
        // ������ ������ ������ � ������ ������

        try {
            int data = inputStream.read();
            char content;
            char delimiter = ' ';
            String tmp = "";
            while (data != -1) {
                // ��������� ����� � ������
                content = (char) data;
                if (content != delimiter) {
                    tmp += content;
                } else {
                    if (keyWords.findString(tmp) == 1) {
                        putStringToMap(tmp);
                    }
                    tmp = "";
                }
                data = inputStream.read(); // ������ ��������� ����� �������
            }
            //System.out.println(mapKeyWords);
        } finally {
            inputStream.close(); //��������� �����
        }


    }

    private void write() throws IOException {
        try {
            FileOutputStream outputStream = new FileOutputStream(fNameOutput);

            for (String key : mapKeyWords.keySet()) {
                outputStream.write(key.getBytes());
                outputStream.write("=".getBytes());

                outputStream.write((mapKeyWords.get(key)).toString().getBytes());
                outputStream.write(",".getBytes());
            }

            outputStream.close();    // !!! ��������, ��� ��������� �����
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * ������ ����, ���������� ��� �� ����� Java.
     * ������� �������� ����� � �� ���������� � ������ ����.
     * @param fNameInput ������� ����
     * @param fNameOutput �������� ����
     * @throws IOException
     */
    public void run(String fNameInput, String fNameOutput)throws IOException{
        this.fNameInput = fNameInput;
        this.fNameOutput = fNameOutput;
        read();
        write();
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
