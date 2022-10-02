package com.drs.shangxuan.controller;

import com.alibaba.fastjson2.JSONObject;
import com.drs.shangxuan.bean.Student;
import com.drs.shangxuan.common.R;
import com.drs.shangxuan.service.imp.WxServiceImp;
import com.drs.shangxuan.tool.AesCbcUtil;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jasmine-drs
 * @date 2022/8/17 11:08
 */
@RestController
@RequestMapping("/wxs")
public class WxController {

    public final WxServiceImp wxServiceImp;

    public WxController(Student student, WxServiceImp wxServiceImp) {
        this.wxServiceImp = wxServiceImp;
    }

    /**
     * 微信登录
     *
     * @param code          小程序返回的登陆凭证
     * @param encryptedData 加密数据
     * @param iv            加密算法的初始向量
     * @return 自定义状态
     */
    @GetMapping
    public R<String> loginByWx(String code, String encryptedData, String iv) {
        System.out.println(code);
        System.out.println("encryptedData = " + encryptedData);
        System.out.println("iv = " + iv);
        /*通过code获取 session_key openid*/
        String s = wxServiceImp.loginByWx(code);

        /*转化JSON数据*/
        JSONObject json = JSONObject.parseObject(s);
        System.out.println("返回过来的json数据:" + json.toString());
        String sessionKey = json.get("session_key").toString(); //会话秘钥
        String openId = json.get("openid").toString(); //用户唯一标识

        /*通过用户的session_key和微信小程序传过来的iv和encryptedData进行解密*/
        String decrypt = AesCbcUtil.decrypt(encryptedData, sessionKey, iv, "utf-8");
        System.out.println(decrypt);

        return R.success("成功");
    }

    /**
     * 获取用户信息
     *
     * @param student 用户对象
     * @return 自定义状态
     */
    @PostMapping
    public R<Student> getUserInfo(@RequestBody Student student) {
        String nickName = student.getNickName();
        String avatarUrl = student.getAvatarUrl();

        System.out.println("nickName = " + nickName);
        System.out.println("avatarUrl = " + avatarUrl);

        Student save = wxServiceImp.save(nickName, avatarUrl);
        if (save != null) {
//            存在数据则返回到页面显示信息
            return R.success(save);
        } else {
            return R.err("数据异常");
        }
    }

    @PutMapping
    public void putUserInfo(@RequestBody Student student) {
        System.out.println("WxController.putUserInfo");
        System.out.println("student = " + student);
        wxServiceImp.putUserInfo(student);
    }

}
