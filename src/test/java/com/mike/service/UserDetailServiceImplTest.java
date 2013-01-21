package com.mike.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.Assert.assertNull;

/**
 * Test class for the UserDetailServiceImpl.
 * <p/>
 * User: mike
 * Date: 1/20/13
 * Time: 7:56 AM
 */
public class UserDetailServiceImplTest
{
    private UserDetailServiceImpl userDetailService;

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
}
