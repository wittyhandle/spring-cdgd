package com.mike.controller;

import com.mike.domain.Project;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * User: mike
 * Date: 2/2/13
 * Time: 4:28 PM
 */
public class AdminProjectControllerTest
{
    private AdminProjectController adminProjectController = new AdminProjectController();

    @Test
    public void testListProjects() throws Exception
    {
        String result = adminProjectController.listProjects();

        assertEquals("admin", result);
    }

    @Test
    public void testNewProjectForm() throws Exception
    {
        Project emptyProject = new Project();

        ModelMap modelMap = new ModelMap();
        String result = adminProjectController.newProjectForm(modelMap);

        assertEquals(emptyProject, modelMap.get("project"));
        assertEquals("project.new", result);
    }
}
