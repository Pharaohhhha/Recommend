package service;

import dao.RecommendDao;
import entity.ProductItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by alienware on 2017/3/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/spring-dao.xml" ,"/spring/spring-service.xml"})
public class TestRecommendService {

    @Resource
    private RecommendService recommendService;

    @Test
    public void testRecommend(){
        List<ProductItem> lists = recommendService.recommend("王萱妞");
        if(lists.size()!=0){
            for (ProductItem item:lists) {
                System.out.println("产品名:"+item.getProductName()+"\t 产品目录:"+item.getProductCatagory());
            }
        }else{
                System.out.println("没有对应的推荐，可能为新用户");
        }
    }
}
