package com.example.demo.controlleres;

import java.util.List;
import java.util.Map;

import com.example.demo.domains.ArticleDTO;
import com.example.demo.services.ArticleService;
import com.example.demo.utils.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        map.put("count", articleService.count());
        return map;
    }
    @GetMapping("/articles/{artNum}")
    public ArticleDTO detail(@PathVariable String artNum){
        return articleService.getArticleById(artNum);
    }
    @GetMapping("/articles/{artNum}/count")
    public Map<?,?> increasecount(@PathVariable String artNum){
        var map = px.hashMap();
        map.put("message", px.message(articleService.increaseCount(artNum)));
        return map;
    }
    @GetMapping("/articles/crawling/{site}")
    public Map<?,?> crawling(@PathVariable String site){
        var map = px.hashMap();
        var count = articleService.count();
        if(count==0){
            switch(site){
                case "bugs":
                count = articleService.crawling("https://music.bugs.co.kr/recomreview?&order=listorder&page=2");
                map.put("count",count);
                break;
            }
        }else{map.put("count", count);}
        return map;
    }
    @PutMapping("/articles")
    public Map<?,?> update(@RequestBody ArticleDTO a){
        var map = px.hashMap();
        map.put("message", px.message(articleService.update(a)));
        return map;
    }
    @DeleteMapping("/articles")
    public Map<?,?> delete(@RequestBody ArticleDTO a){
        var map = px.hashMap();
        map.put("message", px.message(articleService.delete(a)));
        return map;
    }
}
