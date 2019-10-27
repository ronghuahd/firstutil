package org.practice.firstutil;

import org.junit.jupiter.api.Test;
import org.practice.firstutil.templateutil.HttpTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FirstutilApplicationTests {

    @Test
    void contextLoads() {
        HttpTest httpTest=new HttpTest();
        httpTest.doExcute();

    }

}
