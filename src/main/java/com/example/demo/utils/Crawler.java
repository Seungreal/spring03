package com.example.demo.utils;

import java.util.Map;

public class Crawler extends Proxy{
    public Map<?,?> crawling(String url){
        printer(url);
        var map = hashMap();
        return map;
    }
}
