package com.ecfront.dew.core.interceptor;

import com.ecfront.dew.core.Dew;
import com.ecfront.dew.core.DewContext;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DewHandlerInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getParameter(Dew.VIEW_TOKEN_FLAG);
        DewContext context = new DewContext();
        context.setId(Dew.Util.createUUID());
        context.setSourceIP(Dew.Util.getRealIP(request));
        context.setToken(token);
        DewContext.setContext(context);
        return super.preHandle(request, response, handler);
    }
}