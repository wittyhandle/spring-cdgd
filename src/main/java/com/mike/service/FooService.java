package com.mike.service;

import com.mike.domain.Foo;

/**
 * Defines the interface for a foo related service
 * <p/>
 * User: mike
 * Date: 1/6/13
 * Time: 10:46 AM
 */
public interface FooService
{
    Foo getFooById(long id);
}
