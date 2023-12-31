package com.lyh;

import com.lyh.bean.Info;
import com.lyh.bean.Manager;
import com.lyh.bean.News;
import com.lyh.controller.result.Result;
import com.lyh.dao.InfoDao;
import com.lyh.dao.ManagerDao;
import com.lyh.dao.NewsDao;
import com.lyh.dao.UserDao;
import com.lyh.service.InfoService;
import com.lyh.service.MessageService;
import com.lyh.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Fruitshop3ApplicationTests {
    @Autowired
    UserDao userDao;
    @Autowired
    UserService userService;
    @Autowired
    ManagerDao managerDao;
    @Autowired
    InfoDao infoDao;
    @Autowired
    NewsDao newsDao;
    @Autowired
    InfoService infoService;
    @Autowired
    MessageService messageService;

    @Test
    void contextLoads() {
        Manager manager = new Manager("admin", "admin");
        Manager byUsernameAndPassword = managerDao.getByUsernameAndPassword(manager);
        System.out.println(byUsernameAndPassword);
    }

    @Test
    void testInfoDao() {
        Info info = infoDao.selectById(1);
        System.out.println(info);
    }

    @Test
    void testDate() {
        List<News> news = newsDao.selectByMap(null);
        System.out.println(news);
    }

    @Test
    void testGetAll() {
        Result all = infoService.getAll();
    }


    @Test
    void test() {
        Result contentById = messageService.getContentById(1);
        System.out.println(contentById.toString());
    }

    @Test
    void test2() {
        // Bubble Sort
        infoService.getByPage(3,1);

    }
}
