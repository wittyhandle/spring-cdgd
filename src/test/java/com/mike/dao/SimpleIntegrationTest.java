package com.mike.dao;

import com.mike.domain.Foo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Tinkering with my first attempt at a Spring-based integration test with annotations.
 * <p/>
 * User: mike
 * Date: 1/21/13
 * Time: 1:55 PM
 */
public class SimpleIntegrationTest extends BaseIntegrationTest
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
}
