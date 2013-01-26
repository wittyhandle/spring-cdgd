package com.mike.service;

import com.mike.config.PersistenceConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.sql.DataSource;

import static org.junit.Assert.assertNull;

/**
 * Test class for the UserDetailServiceImpl.
 * <p/>
 * User: mike
 * Date: 1/20/13
 * Time: 7:56 AM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class UserDetailServiceImplTest
{
    private UserDetailServiceImpl userDetailService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Before
    public void setUp() throws Exception
    {
        userDetailService = new UserDetailServiceImpl();
    }

    @Test
    public void testLoadUserByUsername() throws Exception
    {
        UserDetails userDetails = userDetailService.loadUserByUsername("fred");
        assertNull(userDetails);
    }

    @Test
    public void testEncodePassword() throws Exception
    {
        String encoded = passwordEncoder.encodePassword("Lawrence", "mike");
        System.out.println("encoded = " + encoded);
    }

    @Configuration
    static class ContextConfiguration
    {
        @Bean
        PasswordEncoder configurePasswordEncoder()
        {
            return new Md5PasswordEncoder();
        }

    }
}
