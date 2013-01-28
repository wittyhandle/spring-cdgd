package com.mike.dao;

import com.mike.config.PersistenceConfig;
import com.mike.domain.Foo;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Tinkering with my first attempt at a Spring-based integration test with annotations.
 * <p/>
 * User: mike
 * Date: 1/21/13
 * Time: 1:55 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class SimpleIntegrationTest
{

    @Autowired
    private FooDao fooDao;

    @Test
    public void testFooQuery() throws Exception
    {
        Foo foo = fooDao.findById(0);
        assertEquals("frank", foo.getName());
    }

    @Test
    public void testNoFoo() throws Exception
    {
        Foo foo = fooDao.findById(10);
        assertNull(foo);
    }

    @Configuration
    @ComponentScan({"com.mike.dao"})
    @EnableTransactionManagement
    static class ContextConfiguration extends PersistenceConfig
    {
        @Bean
        public DataSource configureDataSource()
        {
            return new EmbeddedDatabaseBuilder()
                    .setType(EmbeddedDatabaseType.HSQL)
                    .addDefaultScripts()
                    .build();
        }

    }


}