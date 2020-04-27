package com.lagou.springboot03_data;

import com.lagou.mapper.ArticleMapper;
import com.lagou.mapper.CommentMapper;
import com.lagou.pojo.Address;
import com.lagou.pojo.Article;
import com.lagou.pojo.Comment;
import com.lagou.pojo.Person;
import com.lagou.repository.CommentRepository;
import com.lagou.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
class Springboot03DataApplicationTests {

    @Autowired
    private CommentMapper commentMapper;

    @Test
    void contextLoads() {
        Comment comment = commentMapper.findById(1);
        System.out.println(comment);
    }

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    public void selectArticle() {
        Article article = articleMapper.selectArticle(1);
        System.out.println(article);
    }
    //测试整合JPA
    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void selectComment(){
        Optional<Comment> byId = commentRepository.findById(1);
        if(byId.isPresent()){}
        System.out.println(byId.get());
    }
    //测试整合redis
    @Autowired
    private PersonRepository personRepository;
@Test
    public void savePerson() {

        Person person = new Person();
        person.setFirstname("张");
        person.setLastname("三");

        Address address = new Address();
        address.setCity("北京");
        address.setCountry("中国");
        person.setAddress(address);

        // 向redis数据库中添加了数据
        personRepository.save(person);
    }
    @Test
    public void selectPerson() {
        List<Person> list = personRepository.findByAddress_City("北京");
        for (Person person : list) {
            System.out.println(person);
        }

    }}







