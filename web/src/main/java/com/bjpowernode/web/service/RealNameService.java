package com.bjpowernode.web.service;

import com.bjpowernode.pojo.JsonResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jiangrenbao
 * @date 2021/11/28
 * @description
 */
public interface RealNameService {
    /**
     * 京东万象实名认证接口
     * @param request
     * @return
     */
    JsonResult jdwxRealNameApi(HttpServletRequest request);
}
