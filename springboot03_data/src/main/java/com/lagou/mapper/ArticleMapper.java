package com.lagou.mapper;

import com.lagou.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

public interface ArticleMapper {
    //
    public Article selectArticle(Integer id);



}
