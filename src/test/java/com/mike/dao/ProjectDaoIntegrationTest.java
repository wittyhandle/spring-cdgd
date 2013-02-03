package com.mike.dao;

import com.mike.domain.Project;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * User: mike
 * Date: 2/2/13
 * Time: 8:38 AM
 */
public class ProjectDaoIntegrationTest extends BaseIntegrationTest
{
    @Autowired
    private ProjectDao projectDao;

    @Before
    public void setUp() throws Exception
    {
        Project testProject = new Project();
        testProject.setName("Foo Name");
        testProject.setDescription("This is the test description");

        projectDao.persist(testProject);
    }

    @Test
    public void testFindWorkByName() throws Exception
    {
        Project project = projectDao.findWorkByName("Foo Name");
        assertNotNull(project);
    }
}
