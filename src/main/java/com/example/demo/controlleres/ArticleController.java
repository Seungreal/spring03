package com.example.demo.controlleres;

import java.util.Map;

import com.example.demo.domains.ArticleDTO;
import com.example.demo.services.ArticleService;
import com.example.demo.utils.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
    @Autowired ArticleService articleService;
    @Autowired Proxy px;
    @PostMapping("/articles")
    public Map<?,?> write(@RequestBody ArticleDTO a){
        var map = px.hashMap();
        map.put("message", px.message(articleService.write(a)));
        return map;
    }
    @GetMapping("/articles")
    public Map<?,?> list(){
        var map = px.hashMap();
        map.put("list", articleService.list());
        return map;
    }
    @GetMapping("/articles/crawling/{site}")
    public Map<?,?> crawling(@PathVariable String site){
        var map = px.hashMap();
        if(px.equals(site, "bugs")){
            int count = articleService.crawling("https://music.bugs.co.kr/recomreview?&order=listorder&page=2");
            map.put("count",count);
        }
        return map;
    }
}
