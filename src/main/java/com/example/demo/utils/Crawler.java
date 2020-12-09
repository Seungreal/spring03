package com.example.demo.utils;

import com.example.demo.domains.ArticleDTO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Crawler extends Proxy{
    @Autowired Box<ArticleDTO> artBox;
    @Autowired ArticleDTO article;
    public Box<ArticleDTO> crawling(String url){
        try{
            Document rawData = Jsoup.connect(url).timeout(10*1000).get();
            Elements titles = rawData.select("a[class=albumTitle hyrend]");
            Elements contents = rawData.select("aside[class=recommendReview] h1");
            for(int i=0;i<titles.size();i++){
                article = new ArticleDTO();
                article.setTitle(titles.get(i).text());
                article.setContent(contents.get(i).text());
                printer(article.toString());
                artBox.add(article);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return artBox;
    }
}
