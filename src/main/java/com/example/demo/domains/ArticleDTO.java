package com.example.demo.domains;

import org.springframework.stereotype.Component;

import lombok.Data;

// create tabel article(
// 	artNum int auto_increment primary key
// 	writerId varchar(10)
// 	title varchar(10)
// 	content text
// 	regDate timestamp default now()
// );

@Component @Data
public class ArticleDTO {
    private int artNum, count;
    private String writerId, title, content, regDate;
}
