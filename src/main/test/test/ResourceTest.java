package test;

import org.junit.Assert;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.context.support.ServletContextResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by xyd on 16/7/4.
 */
public class ResourceTest {
    public static void main(String[] args){
        Resource res = new ClassPathResource("dao/LoginLogDao.class");
        //Resource resourceLoader = new ClassPathResource("dao/LoginLogDao.class");
        //Resource res2 = new ClassPathResource(new ClassPathResourceLoader());
        //ResourceLoader resourceLoader = new ClassPath
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("dao/LoginLogDao.class");
        Assert.assertTrue(resource instanceof ClassPathResource);

    }
}
