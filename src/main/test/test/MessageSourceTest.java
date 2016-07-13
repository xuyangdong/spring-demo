package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.StaticMessageSource;

import java.util.Locale;

/**
 * Created by xyd on 16/7/10.
 */
public class MessageSourceTest {
    StaticMessageSource staticMessageSource;
    @Before
    public void set(){
        staticMessageSource = new StaticMessageSource();
    }

    @Test
    public void test(){
        staticMessageSource.addMessage("menu.file", Locale.US,"File");
        staticMessageSource.addMessage("menu.edit",Locale.US,"Edit");
        Assert.assertEquals("Edit",staticMessageSource.getMessage("menu.edit",null,Locale.US));
    }
}
