package com.mike.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

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

    /**
     * Have spring call for the username and store is as a model attribute. Spring will also pass in the current
     * Principal object from which the username is determined.
     *
     * @param principal contains the current username
     * @return the current username
     */
    @ModelAttribute("username")
    public String retrieveUsername(Principal principal)
    {
        return principal.getName();
    }
}
