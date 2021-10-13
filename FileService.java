package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {

    private static FileService instance;
    private String str1 = "";

    public static synchronized FileService getInstance(){
        if (instance == null){
            instance = new FileService();
        }
        return instance;
    }

    public String getStr1(){
        return str1;
    }

    public void doing(String write) throws IOException {
        FileReader filew = null;
        try {

            filew = new FileReader(write);

            int count;

            while ((count = filew.read()) != -1){
                this.str1 += (char)count;
            }
        }finally {
            if(filew != null){
                filew.close();
            }
        }
    }

    public void block(String email) throws IOException {
        FileService fileService = new FileService();
        fileService.doing("C:\\Users\\User\\IdeaProjects\\hw_4\\src\\com\\company\\Basa.txt");
        FileReader filer = null;
        FileWriter filew = null;
        try {
            filer = new FileReader("C:\\Users\\User\\IdeaProjects\\hw_4\\src\\com\\company\\Basa.txt");
            filew = new FileWriter("C:\\Users\\User\\IdeaProjects\\hw_4\\src\\com\\company\\Basa.txt");
            String container = "";
            for (String bb :fileService.getStr1().split("\n")) {
                if (email.equals(bb.split(", ")[2])){
                    String bb1 = "";
                    bb1 += bb.split(", ")[0] + ", ";
                    bb1 += bb.split(", ")[1] + ", ";
                    bb1 += bb.split(", ")[2] + ", ";
                    bb1 += bb.split(", ")[3] + ", ";
                    bb1 += "true" + "\n";
                    container += bb1;
                }
            }
            filew.write(container);

        }finally {
            if(filer != null) {
                filer.close();
            }
            if(filew != null){
                filew.close();
            }
        }}
}
