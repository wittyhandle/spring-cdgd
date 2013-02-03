package com.mike.controller;

import org.junit.Test;

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
    public void testNewProject() throws Exception
    {
        String result = adminProjectController.newProject();

        assertEquals("project.new", result);
    }
}
