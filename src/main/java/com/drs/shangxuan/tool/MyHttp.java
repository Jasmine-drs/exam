package com.drs.shangxuan.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Jasmine-drs
 * @date 2022/8/18 10:54
 */
public class MyHttp {

    public static String getUtil(String path) {
        String result = "";
        try {
            URL url = new URL(path);
            /*打开url之间的链接*/
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            /*设置请求登录方式*/
            connection.setRequestMethod("GET");
            /*允许输出及读入*/
            connection.setDoOutput(true);
            connection.setDoInput(true);
            /*获取输入流*/
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String str = "";
            while ((str = reader.readLine()) != null) {
                System.out.println(str);
                result += str;
            }
            /*关闭流及断开链接*/
            reader.close();
            connection.disconnect();
            System.out.println("完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
