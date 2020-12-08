package com.example.demo.imples;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.domains.ArticleDTO;
import com.example.demo.repositories.ArticleRepository;
import com.example.demo.services.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    @Override
    public int write(ArticleDTO a) {
        a.setRegDate(LocalDate.now().toString());
        return articleRepository.insert(a);
    }

    @Override
    public List<ArticleDTO> list() {
        return null;
    }

    @Override
    public int crawling(String string) {
        return 0;
    }
    
}
