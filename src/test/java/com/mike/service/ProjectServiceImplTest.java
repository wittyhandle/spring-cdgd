package com.mike.service;

import com.mike.dao.ProjectDao;
import com.mike.domain.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * User: mike
 * Date: 3/12/13
 * Time: 8:18 PM
 */
@RunWith(MockitoJUnitRunner.class)
public class ProjectServiceImplTest
{
    @InjectMocks
    private ProjectServiceImpl personService = new ProjectServiceImpl();

    @Mock
    private ProjectDao projectDao;

    @Test
    public void testSaveProject() throws Exception
    {
        Project project = new Project();
        project.setName("Jim");
        project.setDescription("Desc");

        personService.saveProject(project);

        verify(projectDao).persist(project);
    }
}
