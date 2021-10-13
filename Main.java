package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args){
        Account acc1 = new Account("Силкачев Владимир Вадимыч", "02.09.01", "5в57геа@mail.ru", "наер4р", false);
        Account acc2 = new Account("Попов Кирилл Максимыч", "18.11.00", "апн8рг3@mail.ru", "r7fugkjj", false);
        try {
            FileReader filew = null;
            filew = new FileReader("C:\\Users\\User\\IdeaProjects\\hw_4\\src\\com\\company\\Basa.txt");
            BufferedReader read = new BufferedReader(filew);
            FileAccountManager file = new FileAccountManager();
            //file.register(acc2);
            //file.removeAccount("апн8г3@mail.ru", "r7fugkjj");
            file.login("апн8рг3@mail.ru", "");
            file.login("апн8рг3@mail.ru", "");
            file.login("апн8рг3@mail.ru", "");
            file.login("апн8рг3@mail.ru", "");
            file.login("апн8рг3@mail.ru", "");
            file.login("апн8рг3@mail.ru", "r7fugkjj");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}