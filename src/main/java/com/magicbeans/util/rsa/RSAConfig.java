package com.magicbeans.util.rsa;

import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Eric Xie on 2017/1/10 0010.
 */
public class RSAConfig {


    private static final String PROPERTIES_PATH = "keystore/key.properties";

    private static Logger logger = Logger.getLogger(RSAConfig.class);

    private static Map<String,String> result = new HashMap<String, String>();

    /**参数名*/
    public static final String PARAM_NAME = "param_rsa";

    /**结果获取参数的Key*/
    public static final String PARAM_OBJECT = "params";

    private RSAConfig(){}

    static {
        init();
    }

    private static void init() {
        try {
            Properties properties  = new Properties();
            InputStream in = RSAConfig.class.getClassLoader().getResourceAsStream(PROPERTIES_PATH);
            properties.load(in);
            Enumeration enumeration = properties.keys();
            while (enumeration.hasMoreElements()){
                String key = (String)enumeration.nextElement();
                result.put(key,properties.getProperty(key));
            }
        }catch (Exception e){
            logger.error("初始化配置文件失败",e);
        }
    }

    public static String getPublicKey(){
        return result.get("publicKey");
    }
    public static String getPrivateKey(){
        return result.get("privateKey");
    }
}
