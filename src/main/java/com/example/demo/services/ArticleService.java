package com.example.demo.services;

import com.example.demo.domains.ArticleDTO;

import org.springframework.stereotype.Component;

@Component
public interface ArticleService {

	public int write(ArticleDTO a);
    
}
