package test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * Created by xyd on 16/7/4.
 */
public class Car implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean{
    private String name;
    private String id;

    private BeanFactory beanFactory;
    private String beanName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void setBeanName(String s) {
        this.beanName = s;
    }

    public void destroy() throws Exception {
        System.out.println("DisposableBean.destroy");

    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("InitalizingBean.afterPropertiesSet");

    }

    public void myInit(){
        System.out.println("init-method");
    }

    public void myDestroy(){
        System.out.println("destroy-method");
    }
}
