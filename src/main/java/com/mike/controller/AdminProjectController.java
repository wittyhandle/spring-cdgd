package com.mike.controller;

import com.mike.domain.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * The controller for management of projects within the admin space.
 * <p/>
 * User: mike
 * Date: 1/26/13
 * Time: 6:02 PM
 */
@Controller
@RequestMapping("/admin/project")
public class AdminProjectController extends BaseAdminController
{
    private static final Logger log = LoggerFactory.getLogger(AdminProjectController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String listProjects()
    {
        log.debug("Not much in here for now.");

        return "admin";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newProjectForm(ModelMap model)
    {
        log.debug("Returning a new instance of the Project pojo to the form");

        model.put("project", new Project());
        return "project.new";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String newProject(@Valid @ModelAttribute("project") Project project, BindingResult result,
                             HttpServletRequest request)
    {
        log.debug("The following form as been posted {}", project);

        if (result.hasErrors())
        {
            return "project.new";
        }

        return "admin";
    }

}
