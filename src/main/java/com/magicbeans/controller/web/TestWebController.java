package com.magicbeans.controller.web;

import com.magicbeans.controller.BaseController;
import com.magicbeans.util.StatusConstant;
import com.magicbeans.util.ViewData;
import com.magicbeans.util.rsa.RSAEncrypt;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Map;

/**
 * Created by Eric Xie on 2017/1/10 0010.
 */

@Controller
@RequestMapping("/web")
public class TestWebController extends BaseController {


    private static Logger logger = Logger.getLogger(TestWebController.class);

    @RequestMapping("/createKey")
    @ResponseBody
    public ViewData createKeyStore(){
        try {
            String path= this.getClass().getClassLoader().getResource("keystore").getPath();
            Map<String,String> keys = RSAEncrypt.genKeyPair(path);
            return buildSuccessJson(StatusConstant.SUCCESS_CODE,"成功",keys);
        }catch (Exception e){
            logger.debug(e.getMessage(),e);
            return  buildFailureJson(StatusConstant.Fail_CODE,"生成失败");
        }



    }


}
