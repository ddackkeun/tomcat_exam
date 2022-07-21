package com.ll.exam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.IIOException;
import javax.management.RuntimeMBeanException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class Rq {
    private final HttpServletRequest request;
    private final HttpServletResponse response;
    Map<String, Integer> model;

    public Rq(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;

        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
    }

    public int getIntParam(String key, int defaultValue) {
        String value = request.getParameter(key);

        if(value == null)
            return defaultValue;

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public void appendBody(String str) {
        try {
            response.getWriter().append(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
