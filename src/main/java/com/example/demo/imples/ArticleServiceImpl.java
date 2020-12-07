package com.example.demo.imples;

import java.time.LocalDate;

import com.example.demo.domains.ArticleDTO;
import com.example.demo.repositories.ArticleRepository;
import com.example.demo.services.ArticleService;
import com.example.demo.utils.Printer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired ArticleRepository articleRepository;
    @Autowired Printer printer;
    @Override
    public int write(ArticleDTO a) {
        a.setRegDate(LocalDate.now().toString());
        printer.accept("전송된 데이터: "+a.toString());
        return articleRepository.insert(a);
    }
    
}
