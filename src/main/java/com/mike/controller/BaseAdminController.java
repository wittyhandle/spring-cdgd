package com.mike.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Collection;

/**
 * Controllers within the admin section extend this to leverage functionality for retrieving the currently logged in
 * user.
 * <p/>
 * User: mike
 * Date: 1/26/13
 * Time: 5:39 PM
 */
@Controller
public class BaseAdminController
{
    private static final Logger log = LoggerFactory.getLogger(BaseAdminController.class);

    @ModelAttribute("username")
    public String retrieveUsername()
    {
        log.debug("The retrieveUsername method was called, returning 'freddy' for now.");
        return "freddy";
    }
}
