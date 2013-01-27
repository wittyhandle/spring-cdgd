package com.mike.controller;

import org.junit.Before;
import org.junit.Test;
import sun.security.acl.PrincipalImpl;

import java.security.Principal;

import static org.junit.Assert.assertEquals;

/**
 * Test for the BaseAdminController.
 * <p/>
 * User: mike
 * Date: 1/26/13
 * Time: 6:28 PM
 */
public class BaseAdminControllerTest
{
    BaseAdminController baseAdminController;

    @Before
    public void setUp() throws Exception
    {
        baseAdminController = new BaseAdminController();
    }

    @Test
    public void testRetrieveUserName() throws Exception
    {
        Principal principal = new PrincipalImpl("testUser");

        String actualUserName = baseAdminController.retrieveUsername(principal);

        assertEquals("testUser", actualUserName);
    }
}
