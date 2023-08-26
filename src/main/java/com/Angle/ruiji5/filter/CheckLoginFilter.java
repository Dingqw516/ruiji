package com.Angle.ruiji5.filter;

import com.Angle.ruiji5.common.R;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 功能描述
 *拦截请求，未登录用户跳转到登录界面    待实现 有Bug
 * @author: 启文
 * @date: 2023年08月26日 13:59
 */
//@WebFilter(filterName = "CheckLoginFilter",urlPatterns = "/*")
@Slf4j
public class CheckLoginFilter implements Filter {
    public static AntPathMatcher antPathMatcher=new AntPathMatcher();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;

        String url =request.getRequestURI();
        String[] urls=new String[]{
          "/employee/login",
          "/employee/logout",
          "/backend/**",
          "/front/**"
        };
        boolean checkurled = checkurl(urls, url);//获取是否存在数组中
        if (checkurled){
            filterChain.doFilter(request,response);
            return;
        }
        if (request.getSession().getAttribute("employee")!=null){
            filterChain.doFilter(request,response);
            return;
        }
        response.getWriter().write(JSON.toJSONString(R.error("111NOTLOGIN")));

        log.info("请求路径：{}",request.getRequestURI());
    }
    public boolean checkurl(String[] urls,String url){
      for(String i:urls){
          if (antPathMatcher.match(url,i)){
              return true;
          }
      }
        return false;
    }
}
