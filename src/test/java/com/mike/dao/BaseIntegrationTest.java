package com.mike.dao;

import com.mike.config.PersistenceConfig;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * User: mike
 * Date: 2/2/13
 * Time: 1:00 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
@TransactionConfiguration(defaultRollback=true)
@Transactional
public class BaseIntegrationTest
{
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
