package com.amur.home.auth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springblade.core.tool.utils.Func;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = HomeAuthApplication.class)
@RunWith(SpringRunner.class)
public class AuthTest {
    @Test
    public void test() {
        System.out.println(Func.encrypt("666"));
    }
}
