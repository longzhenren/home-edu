package com.amur.home.tinyid;

import com.amur.home.tinyid.factory.impl.IdGeneratorFactoryServer;
import com.amur.home.tinyid.generator.IdGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author du_imba
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerTest {

    @Autowired
    IdGeneratorFactoryServer idGeneratorFactoryServer;

    @Test
    public void testNextId() {
        IdGenerator idGenerator = idGeneratorFactoryServer.getIdGenerator("test");
        Long id = idGenerator.nextId();
        System.out.println("current id is: " + id);
    }
}
