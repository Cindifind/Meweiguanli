package com.example.demo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logRequest(request);
        return true; // 继续处理请求
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (ex != null) {
            logException(request, ex);
        }
    }

    private void logRequest(HttpServletRequest request) {
        try (FileWriter fileWriter = new FileWriter("logs/user.log", true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println("Request URL: " + request.getRequestURL());
            printWriter.println("HTTP Method: " + request.getMethod());
            printWriter.println("IP Address: " + request.getRemoteAddr());
            printWriter.println("Query String: " + request.getQueryString());
            printWriter.println("Headers:");
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                String headerValue = request.getHeader(headerName);
                printWriter.println("  " + headerName + ": " + headerValue);
            }
            // 可以添加更多日志信息，如请求参数、用户信息等
        } catch (IOException e) {
            logger.error("Error writing to log file: ", e);
        }
    }

    private void logException(HttpServletRequest request, Exception ex) {
        try (FileWriter fileWriter = new FileWriter("logs/user.log", true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println("Exception in request: " + request.getRequestURL());
            ex.printStackTrace(printWriter);
        } catch (IOException e) {
            logger.error("Error writing to log file: ", e);
        }
    }
}
