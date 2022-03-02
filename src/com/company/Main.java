package com.company;


import com.company.lesson44.Webinar23Server;

public class Main {
    public static void main(String[] args) {
        try {
            new Webinar23Server("localhost", 8080).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
