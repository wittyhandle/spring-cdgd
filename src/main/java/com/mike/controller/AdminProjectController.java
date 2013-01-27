package com.mike.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The controller for management of projects within the admin space.
 * <p/>
 * User: mike
 * Date: 1/26/13
 * Time: 6:02 PM
 */
@Controller
@RequestMapping("/admin")
public class AdminProjectController extends BaseAdminController
{
    private static final Logger log = LoggerFactory.getLogger(AdminProjectController.class);

    @RequestMapping("home")
    public String listProjects()
    {
        log.debug("Not much in here for now.");

        return "admin";
    }


}
