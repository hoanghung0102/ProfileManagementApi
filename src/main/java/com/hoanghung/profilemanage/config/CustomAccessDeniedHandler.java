package com.hoanghung.profilemanage.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest req, HttpServletResponse res, AccessDeniedException accessDeniedException) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        res.setContentType("application/json;charset=UTF-8");
        res.setStatus(403);

        JsonResponse jsRes = new JsonResponse();
        jsRes.setTimestamp(System.currentTimeMillis());
        jsRes.setStatus("403");
        jsRes.setMessage("Username: " + req.getParameter("username") + " => Access denied");

        res.getWriter().write(mapper.writeValueAsString(jsRes));
    }
}
