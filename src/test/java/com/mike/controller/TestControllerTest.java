package com.mike.controller;

import com.mike.domain.Foo;
import com.mike.service.FooService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test the, ahem, testController.
 * <p/>
 * User: mike
 * Date: 1/20/13
 * Time: 9:09 AM
 */
@RunWith(MockitoJUnitRunner.class)
public class TestControllerTest
{
    @InjectMocks
    private TestController testController = new TestController();

    @Mock
    private FooService fooService;

    @Test
    public void testIdFound() throws Exception
    {
        Foo foo = new Foo();
        foo.setId(0L);
        foo.setName("fred");
        when(fooService.getFooById(0l)).thenReturn(foo);

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setParameter("id", "0");

        testController.test(request);

        verify(fooService).getFooById(0L);
    }
}
