package test;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * Created by xyd on 16/7/6.
 */
public class MyInstantiantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter{
    public Object postProcessBeforeInstantiation(Class beanClass,String beanName) throws BeansException{
        if("car".equals(beanName)){
            System.out.println("InstantiationAwareBeanPostProcessorAdapter.postProcessBeforeInstantiation");
        }
        return null;
    }

    public boolean postProcessAfterInstantiation(Object bean,String beanName) throws BeansException{
        if("car".equals(beanName)){
            System.out.println("InstantiationAwareBeanPostProcessorAdapter.postProcessAfterInstantiation");
        }
        return true;
    }

    public PropertyValues postProcessPropertyValues(PropertyValues pvs,PropertyDescriptor[] pds,String beanName)throws BeansException {
        if ("car".equals(beanName)) {
            System.out.println("InstantiationAwareBeanPostProcessorAdapter.postProcessPropertyValues");
        }
        return pvs;
    }
}
