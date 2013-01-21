package com.mike.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Perform the lookup in the database based on username.
 * <p/>
 * User: mike
 * Date: 1/20/13
 * Time: 7:54 AM
 */
@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService
{
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {


        return null;
    }
}
