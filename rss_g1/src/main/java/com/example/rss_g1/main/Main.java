package com.example.rss_g1.main;

import com.example.rss_g1.rome.Rome;

public class Main {
    public static void main(String[] args) {
        Rome rome = new Rome("https://g1.globo.com/rss/g1/tecnologia/");
        rome.lerFeed();
    }

}
