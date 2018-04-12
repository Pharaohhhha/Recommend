package dao;

import dao.ProductDao;
import entity.Product;
import entity.ProductItem;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by magenta9 on 2017/2/28.
 */
public class ProductTest {

    private static ProductDao productDao;

    @Before
    public void before() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
        productDao = (ProductDao) ctx.getBean("productDao");
    }

    @Test
    public void testAdd() {
        Product product = new Product();
        product.setCatagoryId(2);
        product.setProduceBrand("蒙牛");
        product.setProduceContext("精典有机奶");
        product.setProduceImage("//img10.360buyimg.com/n1/g13/M01/0A/09/rBEhVFIq7DYIAAAAAACpXiP8SPAAAC54wCdIFQAAKl2682.png");
        product.setProduceName("蒙牛牛奶");
        product.setProducePrice(35.5);
        product.setProduceSerialNumber("JD1022050149");
//        JD1016539316;JD1037502827;
//        JD1016103433;JD1020124778;
//        JD1022050149
        System.out.println(productDao.add(product));
    }

    @Test
    public void testFindAll() {
        List<Product> list = productDao.findAll();
        for (Product product : list) {
            System.out.println(product.getProduceContext());
        }
    }

    @Test
    public void testAddList() {
        productDao.addList(productDao.findAll());
    }

    @Test
    public void testFindbyCatagoryId() {
        List<Product> list = productDao.findbyCatagoryId(2);
        for (Product product : list) {
            System.out.println(product.getProduceName());
        }
    }

    @Test
    public void testGetProductItem(){
        ProductItem  item = productDao.findBySerId("JD1001412818");
        String result = item==null?"空的":item.toString();
        System.out.println(result+item.getProduceContext()+item.getProductCatagory());
    }
}
