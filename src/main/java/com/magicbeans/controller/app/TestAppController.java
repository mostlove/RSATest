package com.magicbeans.controller.app;

import com.magicbeans.controller.BaseController;
import com.magicbeans.util.StatusConstant;
import com.magicbeans.util.ViewData;
import com.magicbeans.util.rsa.RSAConfig;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Eric Xie on 2017/1/10 0010.
 */

@Controller
@RequestMapping("/app/test")
public class TestAppController extends BaseController{


    private Logger logger = Logger.getLogger(TestAppController.class);

    @RequestMapping("/login")
    @ResponseBody
    public ViewData login(HttpServletRequest req){
        try {
            return  buildSuccessJson(StatusConstant.SUCCESS_CODE,"获取成功",req.getAttribute(RSAConfig.PARAM_OBJECT));
        }catch (Exception e){
            e.printStackTrace();
            return  buildFailureJson(StatusConstant.Fail_CODE,"解密失败");
        }
    }

}
