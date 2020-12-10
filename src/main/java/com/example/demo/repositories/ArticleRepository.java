package com.example.demo.repositories;

import java.util.List;

import com.example.demo.domains.ArticleDTO;

import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository {

	public int insert(ArticleDTO a);

	public int count();

	public List<ArticleDTO> selectAll();

	public ArticleDTO selectById(String artNum);

	public int updateCount(String artNum);

	public int update(ArticleDTO a);

	public int delete(ArticleDTO a);
    
}
