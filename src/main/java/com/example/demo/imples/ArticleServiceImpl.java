package com.example.demo.imples;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.domains.ArticleDTO;
import com.example.demo.repositories.ArticleRepository;
import com.example.demo.services.ArticleService;
import com.example.demo.utils.Box;
import com.example.demo.utils.Crawler;
import com.example.demo.utils.UserGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired ArticleRepository articleRepository;
    @Autowired Crawler crawler;
    @Autowired UserGenerator ug;
    @Override
    public int write(ArticleDTO a) {
        a.setRegDate(LocalDate.now().toString());
        return articleRepository.insert(a);
    }

    @Override
    public List<ArticleDTO> list() {
        return articleRepository.selectAll();
    }

    @Override
    public int crawling(String url) {
        Box<ArticleDTO> artBox=crawler.crawling(url);
        for(int i=0;i<artBox.size();i++){
            artBox.get(i).setWriterId(ug.makeuserid());
            write(artBox.get(i));
        }
        return count();
    }

    @Override
    public int count() {
        return articleRepository.count();
    }
    
}
