package com.mike.dao;

import com.mike.domain.Project;
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
public class ProjectDao
{
    private static final Logger log = LoggerFactory.getLogger(ProjectDao.class);

    @PersistenceContext
    private EntityManager entityManager;

    public Project findWorkByName(String name)
    {
        Project project;

        try
        {
            project = entityManager.createNamedQuery(Project.FIND_BY_NAME, Project.class)
                    .setParameter("name", name)
                    .getSingleResult();
        }
        catch (NoResultException nre)
        {
            project = null;
        }

        return project;
    }


    public Project findWorkById(long id)
    {
        Project project;

        try
        {
            project = entityManager.createNamedQuery(Project.FIND_BY_ID, Project.class)
                    .setParameter("id", id)
                    .getSingleResult();
        }
        catch (NoResultException nre)
        {
            project = null;
        }

        return project;
    }

    public void persist(Project project)
    {
        log.debug("Persisting the project: {}", project);

        entityManager.persist(project);
    }
}
