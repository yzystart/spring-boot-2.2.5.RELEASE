package com.yezhiyuan.filter;


import com.yezhiyuan.controller.TestController;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class ClearThreadPageLocalFilter implements Filter{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

      try {
          filterChain.doFilter(servletRequest,servletResponse);
      }finally {
          System.out.println("执行结束");
          TestController.t.remove();
      }
//        PageHelper.clearPage();
    }
}
