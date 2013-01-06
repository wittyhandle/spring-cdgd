package com.mike.dao;

import com.mike.domain.Foo;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * This is situated between the hibernate repository itself and the fooService
 * <p/>
 * User: mike
 * Date: 1/6/13
 * Time: 10:51 AM
 */
@Repository
@Service
@Transactional(readOnly = true)
public class FooDao
{
    @PersistenceContext
    private EntityManager entityManager;

    public Foo findById(long id)
    {
        Foo foo;

        try
        {
            foo = entityManager.createNamedQuery(Foo.FIND_BY_ID, Foo.class)
                    .setParameter("id", id)
                    .getSingleResult();
        }
        catch (NoResultException nre)
        {
            foo = null;
        }

        return foo;
    }

}
