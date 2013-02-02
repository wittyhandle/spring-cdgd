package com.mike.dao;

import com.mike.domain.Work;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * Responsible for persisting and retrieving works data from the database.
 * <p/>
 * User: mike
 * Date: 2/2/13
 * Time: 8:32 AM
 */
@Repository
@Service
public class WorkDao
{
    private static final Logger log = LoggerFactory.getLogger(WorkDao.class);

    @PersistenceContext
    private EntityManager entityManager;

    public Work findWorkByName(String name)
    {
        Work work;

        try
        {
            work = entityManager.createNamedQuery(Work.FIND_BY_NAME, Work.class)
                    .setParameter("name", name)
                    .getSingleResult();
        }
        catch (NoResultException nre)
        {
            work = null;
        }

        return work;
    }


    public Work findWorkById(long id)
    {
        Work work;

        try
        {
            work = entityManager.createNamedQuery(Work.FIND_BY_ID, Work.class)
                    .setParameter("id", id)
                    .getSingleResult();
        }
        catch (NoResultException nre)
        {
            work = null;
        }

        return work;
    }

    public void persist(Work work)
    {
        log.debug("Persisting the work: {}", work);

        entityManager.persist(work);
    }
}
