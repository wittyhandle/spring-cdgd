package com.mike.service;

import com.mike.dao.FooDao;
import com.mike.domain.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The foo service.
 * <p/>
 * User: mike
 * Date: 1/6/13
 * Time: 10:47 AM
 */
@Service("fooService")
public class FooServiceImpl implements FooService
{
    @Autowired
    private FooDao fooDao;

    @Override
    public Foo getFooById(long id)
    {
        return fooDao.findById(id);
    }
}
