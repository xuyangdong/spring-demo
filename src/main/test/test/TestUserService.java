package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.UserService;

/**
 * Created by xyd on 16/6/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)//基于junit4的spring测试框架
@ContextConfiguration(locations = {"/applicationContext.xml"})//启动spring容器
public class TestUserService {
    @Autowired
    private UserService userService;

    @Test
    public void hasMatchUser(){
        boolean b1 = userService.hasMatchUser("admin","1234");
        boolean b2 = userService.hasMatchUser("admin","1111");
        assert(b1);
        assert(!b2);
    }
}
