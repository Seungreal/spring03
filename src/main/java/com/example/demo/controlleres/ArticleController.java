package com.example.demo.controlleres;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.domains.ArticleDTO;
import com.example.demo.services.ArticleService;
import com.example.demo.utils.Printer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
    @Autowired ArticleService articleService;
    @Autowired Printer printer;
    @PostMapping("/articles")
    public Map<?,?> write(@RequestBody ArticleDTO a){
        var map = new HashMap<>();
        int result = articleService.write(a);
        if(result==1){
            map.put("message", "SUCCESS");
        }else{
            map.put("message", "FAILURE");
        }
        return map;
    }
}
