//package com.yezhiyuan.filter;
//
//import com.yezhiyuan.anno.SkipCheckToken;
//import org.apache.catalina.connector.RequestFacade;
//import org.springframework.beans.factory.BeanFactoryUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerExecutionChain;
//import org.springframework.web.servlet.HandlerMapping;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
//
//import javax.annotation.Resource;
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.lang.annotation.Annotation;
//import java.lang.reflect.GenericDeclaration;
//import java.lang.reflect.Method;
//import java.util.Arrays;
//import java.util.Map;
//
//public class MyFilter implements Filter {
//
//
//    @Autowired
//    HandlerMapping handlerMapping;
//
//
//
//    public boolean isShouldSkipCheckToken(HttpServletRequest httpServletRequest){
//        try {
//
//            RequestMappingHandlerMapping requestMappingHandlerMapping = SpringUtils.getBean(RequestMappingHandlerMapping.class);
//            HandlerExecutionChain handlerO = requestMappingHandlerMapping.getHandler(httpServletRequest);
//            if (handlerO!=null){
//                HandlerMethod handler = (HandlerMethod)handlerO.getHandler();
//                Class<?> beanType = handler.getBeanType();
//                Method invoiceMethod = handler.getMethod();
//                boolean annotationOnController = beanType.isAnnotationPresent(SkipCheckToken.class);
//                if (annotationOnController){
//                    return true;
//                }
//
//                String methodName = invoiceMethod.getName();
//                Method foundMethod = null;
//
//                Method[] methods = beanType.getDeclaredMethods();
//
//                // 遍历方法，查找与请求方法名匹配的方法
//                for (Method method : methods) {
//                    if (method.getName().equals(methodName)) {
//                        foundMethod = method;
//                        break;
//                    }
//                }
//                if (foundMethod!=null){
//                    if (foundMethod.isAnnotationPresent(SkipCheckToken.class)){
//                        return true;
//                    }
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        ServletInputStream inputStream = servletRequest.getInputStream();
//        byte[] bytes = new byte[100];
//        inputStream.read(bytes);
//        for (byte aByte : bytes) {
//            System.out.println((char)aByte);
//        }
//        boolean shouldSkipCheckToken = isShouldSkipCheckToken((HttpServletRequest) servletRequest);
//        if (shouldSkipCheckToken){
//            filterChain.doFilter(servletRequest, servletResponse);
//        }else {
//            System.out.println("token校验失败");
//        }
//    }
//
//
//
//}
