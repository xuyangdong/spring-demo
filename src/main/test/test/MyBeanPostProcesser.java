package test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by xyd on 16/7/7.
 */
public class MyBeanPostProcesser implements BeanPostProcessor{


    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if(s.equals("car")){
            System.out.println("MyBeanPostProcesser.postProcessBeforeInitialization");
        }
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if(s.equals("car")){
            System.out.println("MyBeanPostProcesser.postProcessAfterInitialization");
        }
        return o;
    }
}
