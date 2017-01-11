package com.magicbeans.filter;

import com.magicbeans.controller.BaseController;
import com.magicbeans.util.AnalysisParam;
import com.magicbeans.util.StatusConstant;
import com.magicbeans.util.rsa.Base64;
import com.magicbeans.util.rsa.RSAConfig;
import com.magicbeans.util.rsa.RSAEncrypt;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.interfaces.RSAPublicKey;
import java.util.Enumeration;

/**
 * Created by Eric Xie on 2017/1/11 0011.
 */


@WebFilter("/app/*")
public class AuthenticationFilter extends BaseController implements Filter {


    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        String param = req.getParameter(RSAConfig.PARAM_NAME);
        // 如果参数未加密
        if(null == param){
            Enumeration enumeration = req.getParameterNames();
            JSONObject json = new JSONObject();
            while (enumeration.hasMoreElements()){
                String key = (String) enumeration.nextElement();
                json.put(key,req.getParameter(key));
            }
            req.setAttribute(RSAConfig.PARAM_OBJECT,json);
            filterChain.doFilter(req,servletResponse);
            return;
        }
        // 验证参数
        if(param.trim().length() == 0 ){
            servletResponse.getWriter().print(JSONObject.fromObject(buildFailureJson(StatusConstant.ARGUMENTS_EXCEPTION,"Arguments Exception")));
            return;
        }
        try {
            // 解密
            RSAPublicKey publicKey = RSAEncrypt.loadPublicKeyByStr(RSAConfig.getPublicKey());
            String paramUrl = new String(RSAEncrypt.decrypt(publicKey, Base64.decode(param)),"UTF-8");
            JSONObject json = AnalysisParam.analysis(paramUrl);
            // 验证 请求时间 10分钟以内 超出10分钟则不能继续请求 时间戳 需要除1000
            long timestamp =  json.getLong("timestamp");
            if(System.currentTimeMillis() / 1000 - timestamp > 10 * 60){
                servletResponse.getWriter().print(JSONObject.fromObject(buildFailureJson(StatusConstant.Fail_CODE,"ERROR REQUEST")));
                return;
            }
            // 验证请求类型 当前为APP 请求类型 其他类型 不能请求
            String type = json.getString("type");
            if(!"APP".equals(type)){
                servletResponse.getWriter().print(JSONObject.fromObject(buildFailureJson(StatusConstant.Fail_CODE,"ERROR SERVER")));
                return;
            }
            // 合法请求
            servletRequest.setAttribute(RSAConfig.PARAM_OBJECT,json);
            filterChain.doFilter(servletRequest,servletResponse);
        } catch (Exception e) {
            e.printStackTrace();
            servletResponse.getWriter().print(JSONObject.fromObject(buildFailureJson(StatusConstant.Fail_CODE,"ERROR PARAMS")));
        }
    }

    public void destroy() {

    }

}
