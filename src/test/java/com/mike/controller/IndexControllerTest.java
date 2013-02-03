package com.mike.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.Assert.assertEquals;

/**
 * Test the indexController.
 * <p/>
 * User: mike
 * Date: 1/20/13
 * Time: 9:09 AM
 */
@RunWith(MockitoJUnitRunner.class)
public class IndexControllerTest
{
    @InjectMocks
    private IndexController indexController = new IndexController();

    @Test
    public void testIdFound() throws Exception
    {
        MockHttpServletRequest request = new MockHttpServletRequest();

        String result = indexController.test(request);

        assertEquals("index", result);
    }
}
