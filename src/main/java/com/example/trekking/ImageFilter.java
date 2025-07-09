package com.example.trekking;

import javax.servlet.*;
import java.util.*;

public class ImageFilter implements Filter {
    private List<String> images;

    public void init(FilterConfig config) {
        String contextPath = config.getServletContext().getContextPath();
        images = Arrays.asList(
            contextPath + "/images/trekking1.jpg",
            contextPath + "/images/trekking2.jpg",
            contextPath + "/images/trekking3.jpg"
        );
        config.getServletContext().setAttribute("trekImages", images);
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws java.io.IOException, ServletException {
        chain.doFilter(req, res);
    }

    public void destroy() {}
}
