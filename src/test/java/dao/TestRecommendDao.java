package dao;

import entity.wechat.RecommendItem;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by alienware on 2017/3/16.
 */

public class TestRecommendDao {

  private static RecommendDao recommendDao;

    @Before
    public void before() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
        recommendDao = (RecommendDao) ctx.getBean("recommendDao");
    }

    @Test
    public void testGetRecommend(){
        System.out.println(recommendDao.getRecommend("王萱妞"));
    }

    @Test
    public void insert() throws IOException {
        FileReader q = new FileReader("E://recommend.csv");
        BufferedReader b = new BufferedReader(q);
        RecommendItem recommendItem = null;
        String str;
        while((str=b.readLine())!=null){
            String[] split = str.split(",");
            recommendItem = new RecommendItem();
            recommendItem.setUserId(split[0]);
            recommendItem.setProId(split[1]);
            recommendDao.insertRecommend(recommendItem);
        }

    }
}
