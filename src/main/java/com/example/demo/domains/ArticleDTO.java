package com.example.demo.domains;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

// create tabel article(
// 	artNum int auto_increment primary key
// 	writerId varchar(10)
// 	title varchar(10)
// 	content text
// 	regDate timestamp default now()
// );

@Component @Data @Lazy
public class ArticleDTO {
    private String artNum,writerId, title, content, regDate,count;
}
