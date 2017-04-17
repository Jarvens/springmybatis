package com.kunlun.api.common.interceptor;

import com.alibaba.fastjson.JSON;
import com.kunlun.api.common.annotations.AccessAnnotation;
import com.kunlun.api.common.annotations.UserTypeAnnotation;
import com.kunlun.api.common.constants.Constants;
import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.common.utils.TokenUtils;
import com.kunlun.api.domain.SysUser;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by kunlun on 2017/4/17.
 */
public class SystemInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        UserTypeAnnotation userTypeAnnotation = handlerMethod.getMethodAnnotation(UserTypeAnnotation.class);
        AccessAnnotation accessAnnotation = handlerMethod.getMethodAnnotation(AccessAnnotation.class);
        if (accessAnnotation == null) {
            return true;
        } else {
            String token = request.getHeader("hcon_token");
            if (null == token) {
                response.getWriter().write(JSON.toJSONString(BaseResult.error("need_token", "需要Token")));
                return false;
            }
            String decryptContent = TokenUtils.aesDecrypt(token, Constants.TOKEN_KEY);
            SysUser sysUser = JSON.parseObject(decryptContent, SysUser.class);
            if (null == sysUser) {
                response.getWriter().write(JSON.toJSONString(BaseResult.error("token_error", "Token信息非法")));
                return false;
            } else {
                if (userTypeAnnotation == null) {
                    return true;
                }
                if (!sysUser.getAccount().equals("admin")) {
                    response.getWriter().write(JSON.toJSONString(BaseResult.error("permission_denied", "此操作需要管理员权限")));
                    return false;
                }
            }
        }
        return super.preHandle(request, response, handler);
    }
}
