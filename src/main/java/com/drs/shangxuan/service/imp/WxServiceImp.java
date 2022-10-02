package com.drs.shangxuan.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.drs.shangxuan.bean.Student;
import com.drs.shangxuan.mapper.WxMapper;
import com.drs.shangxuan.service.WxService;
import com.drs.shangxuan.tool.MyHttp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 这是微信登录的接口 GET:https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
 *
 * @author Jasmine-drs
 * @date 2022/8/18 17:52
 */
@Service
@Slf4j
public class WxServiceImp extends ServiceImpl<WxMapper, Student> implements WxService {

    public final String APP_ID = "wx3a32731a06a3d150";//小程序ID
    public final String APP_SECRET = "fe9090c75129e04814b373c965faee1d";//小程序密钥 fe9090c75129e04814b373c965faee1d
    public WxMapper mapper;
    public String url = "";

    public WxServiceImp(WxMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 用于微信登录获取 session_key openid
     *
     * @param code 前端传递的code
     * @return session_key、openid的json格式字符串
     */
    public String loginByWx(String code) {
        /*grant_type 是请求的类型由微信固定，不用改
         * appid、secret、js_code
         *  appID、APP_SECRET、code
         * 上下一一对应*/
        url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + APP_ID + "&secret=" + APP_SECRET + "&js_code="
                + code + "&grant_type=authorization_code";
        return MyHttp.getUtil(url);
    }

    /**
     * 获取用户信息
     * <p>没有则保存到数据库，有则返回对象</p>
     *
     * @param nickName  用户昵称
     * @param avatarUrl 用户头像
     * @return 状态码
     */
    public Student save(String nickName, String avatarUrl) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("nick_name", nickName);
        map.put("avatar_url", avatarUrl);
        List<Student> users = mapper.selectByMap(map);
        if (users.size() == 0) {
//            创建新对象，之后进行保存
            Student student = new Student();
            student.setNickName(nickName);
            student.setAvatarUrl(avatarUrl);
//            添加新用户
            mapper.insert(student);
            log.info("添加新用户完成");
            return student;
        }
        if (users.size() == 1) {
            return users.get(0);
        }
        return null;
    }

    public void putUserInfo(String nickName, String value, Integer flag) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("nick_name", nickName);

        List<Student> students = mapper.selectByMap(hashMap);
        System.out.println("students = " + students);
        Student student = students.get(0);
        if (flag == 1) {
            student.setName(value);
        } else if (flag == 2) {
            student.setSchool(value);
        } else if (flag == 3) {
            student.setClasses(value);
        } else {
            student.setSex(value);
        }
        mapper.insert(student);
        log.info("更新成功");
    }

    public void putUserInfo(Student student) {

        int insert = mapper.updateById(student);
    }
}
