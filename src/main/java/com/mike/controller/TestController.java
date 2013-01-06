package com.mike.controller;

import com.mike.domain.Foo;
import com.mike.service.FooService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController
{
    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private FooService fooService;

    @RequestMapping("/carl")
    public String test(HttpServletRequest request)
    {
        String idStr = request.getParameter("id");
        long id =Long.parseLong(idStr);

        log.debug("Looking for foo with id {}", id);

        Foo foo = fooService.getFooById(id);

        if (foo == null)
        {
            log.debug("The foo is null");
        }
        else
        {
            log.debug("Found foo {}", foo.getName());
        }


        return "index";
    }
}
