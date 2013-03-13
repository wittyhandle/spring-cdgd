package com.mike.service;

import com.mike.dao.ProjectDao;
import com.mike.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * User: mike
 * Date: 3/2/13
 * Time: 4:59 PM
 */
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService
{
    @Autowired
    private ProjectDao projectDao;

    @Override
    public void saveProject(Project project)
    {
        projectDao.persist(project);
    }
}
