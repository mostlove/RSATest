package com.magicbeans.util;

import net.sf.json.JSONObject;


/**
 * Created by Eric Xie on 2017/1/11 0011.
 *
 *
 * 解析请求参数 工具
 */
public class AnalysisParam {


    /**
     *  拆分 参数
     * @param paramStr user=admin&pwd=abc
     * @return JSONObject 对象
     */
    public static JSONObject analysis(String paramStr) throws Exception{
        JSONObject jsonObject = new JSONObject();
        if(null == paramStr || paramStr.trim().length() == 0){
            return jsonObject;
        }
        String[] strs = paramStr.split("&");
        for (int i = 0; i < strs.length; i++){
            String[] params = strs[i].split("=");
            jsonObject.put(params[0],params[1]);
        }
        return jsonObject;
    }

}
