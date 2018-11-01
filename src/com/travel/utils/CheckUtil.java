package com.travel.utils;

import java.util.Arrays;

/**
 * 微信后台参数的校验工具
 */
public class CheckUtil {

    //后台定义的Token   须与微信公众号后台的token一致，
    //作用：用于接口校验
    private static final String TOKEN = "iBestTravel_Token";

    //检验参数的方法
    public static boolean checkTravelParameter(String signature, String timestamp, String nonce) {
        //定义数组，存放 signature  timestamp  nonce
        String[] arr={TOKEN,timestamp,nonce};
        //对数组进行排序--->升序
        Arrays.sort(arr);
        //将参数拼接生成字符串
        StringBuffer sb = new StringBuffer();
        for (String s : arr) {
            sb.append(s);
        }
        //对参数进行SHA1加密
        String sha1 = SHA1Util.getSha1(sb.toString());
        return signature.equals(sha1);
    }


}
