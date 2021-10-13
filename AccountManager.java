package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

interface AccountManager {

    FailedLoginCounter count = new FailedLoginCounter();

    default void register(Account account) throws IOException, AccountAlreadyExistsException {
        FileService ii = new FileService();
        ii.doing("C:\\Users\\User\\IdeaProjects\\hw_4\\src\\com\\company\\Basa.txt");
        if (ii.getStr1().equals("")) {
            FileWriter filew = null;
            filew = new FileWriter("C:\\Users\\User\\IdeaProjects\\hw_4\\src\\com\\company\\Basa.txt");
            String container = ii.getStr1() + account + "\n";
            filew.write(container);
            filew.close();
        } else {
            for (String bb : ii.getStr1().split("\n")) {
                if (account.getEmail().equals(bb.split(", ")[2])) {
                    throw new AccountAlreadyExistsException("Аккаунт уже создан");
                }
            }
            FileWriter filew = null;
            filew = new FileWriter("C:\\Users\\User\\IdeaProjects\\hw_4\\src\\com\\company\\Basa.txt");
            String container = ii.getStr1() + account + "\n";
            filew.write(container);
            filew.close();
        }
    }


    default Account login(String email, String password) throws IOException {
        FileService ii = new FileService();
        ii.doing("C:\\Users\\User\\IdeaProjects\\hw_4\\src\\com\\company\\Basa.txt");
        FileReader filew = null;
        Account b = new Account("", "", "", "", false);
        try {
            filew = new FileReader("C:\\Users\\User\\IdeaProjects\\hw_4\\src\\com\\company\\Basa.txt");

            for (String bb : ii.getStr1().split("\n")) {
                if (bb.split(", ")[2].equals(email) & "true".equals(bb.split(", ")[4])) {
                    throw new AccountBlockedException("Не вспомнил пароль, лох");
                }
                if (bb.split(", ")[2].equals(email) & !bb.split(", ")[3].equals(password)) {
                    throw new WrongCredentialsException("Неверный пароль и/или логин");
                }
                if (Objects.equals(email, bb.split(", ")[2]) & password.equals(bb.split(", ")[2]) & Objects.equals(bb.split(", ")[4], "false")) {
                    b = new Account(bb.split(", ")[0], bb.split(", ")[1], bb.split(", ")[2], bb.split(", ")[3], false);
                }
                if ((bb.split(", ")[3].equals(email) & !bb.split(", ")[2].equals(password)) | (!bb.split(", ")[3].equals(email) & bb.split(", ")[2].equals(password))) {
                    count.increaseCount(email);
                    throw new WrongCredentialsException("Неверный пароль и/или логин");
                }


            }
        } catch (WrongCredentialsException e) {
            System.out.println(e.getMessage());
            count.increaseCount(email);
        } catch (AccountBlockedException e){
            System.out.println(e.getMessage());
        }finally {
            if (filew != null) {
                filew.close();
            }
        }
        return b;
    }

    default void removeAccount(String email, String password) throws IOException, WrongCredentialsException {
        FileService ii = new FileService();
        ii.doing("C:\\Users\\User\\IdeaProjects\\hw_4\\src\\com\\company\\Basa.txt");
        FileWriter filew = null;
        filew = new FileWriter("C:\\Users\\User\\IdeaProjects\\hw_4\\src\\com\\company\\Basa.txt");
        String container = "";
        for (String bb : ii.getStr1().split("\n")) {
            if (!email.equals(bb.split(", ")[2]) | !password.equals(bb.split(", ")[3])) {
                container += bb;
            }
            if (ii.getStr1().length() == container.length()) {
                throw new WrongCredentialsException("Нет такого аккаунта");
            }
        }
        filew.write(container);
        filew.close();
    }
}

