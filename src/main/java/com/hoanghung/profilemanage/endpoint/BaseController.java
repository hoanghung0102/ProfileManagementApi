package com.hoanghung.profilemanage.endpoint;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by hxhung on 8/24/2017.
 */
public abstract class BaseController {

    String getUsername() {
        return getAuthentication().getName();
    }

    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
