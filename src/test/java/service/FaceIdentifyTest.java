package service;

import entity.User;
import org.junit.Test;
import serviceimpl.UserServicesImpl;

/**
 * Created by Administrator on 2017/3/4 0004.
 */
public class FaceIdentifyTest {
    String url = "https://imgsa.baidu.com/forum/w%3D580/sign=618df9f487d6277fe912323018391f63/3f209258d109b3de7a0e8927ccbf6c81810a4cbe.jpg";
    @Test
    public void testcreateUserPersonId(){
        User user=new User();
        user.setUserName("zp7");
        user.setUserImageUrl(url);
        UserServicesImpl a= new UserServicesImpl();
        a.createUserPersonId(user);

    }
    @Test
    public void testidentifyUser()
    {
        UserServicesImpl a= new UserServicesImpl();
        a.identifyUser(url);
    }
//    public  void testcreateaperson() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
//
//     String str= FaceIdentifyUtil.createaperson("zp", "zp2", "This is a good man");
//        System.out.println(str);
//    }
//    @Test
//    public void testfactdect() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
//        PersonEntity personEntity = new PersonEntity();
//        personEntity = FaceIdentifyUtil.factdect(url);
//        System.out.println(personEntity.getFaceid());
//    }
//    @Test
//    public void testtraingroup() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
//
//        FaceIdentifyUtil.traingroup("zp");
//
//    }
//    @Test
//    public void testaddface() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
//        String str;
//        str = FaceIdentifyUtil.addface(url, "38e6c360-ceba-40f1-9450-71da32b74626", "zp");
//        System.out.println(str);
//    }
//
//    @Test
//    public void testfaceident() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
//        PersonEntity personEntity = new PersonEntity();
//        personEntity=FaceIdentifyUtil.faceident("zp","15c9cdae-fa54-4f28-b129-d6f7cce497ef",1,0.5);
//        System.out.println(personEntity.getFaceid());
//        System.out.println(personEntity.getPersonid());
//        System.out.println(personEntity.getConfidence());
//    }
}

