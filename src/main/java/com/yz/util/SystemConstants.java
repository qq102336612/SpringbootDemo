package com.yz.util;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName :SystemConstants
 * @Description : 系统常量
 * @Author :文金文
 * @Date :2019/9/2 17:36
 **/
public class SystemConstants {

    public static final String USER_INFO = "userinfo"; // 登录的用户信息

    public static final String DEFAULT_TOKEN_NAME = "X-Token";

    /**************************************session线程池************************************/
    public static Map<String, HttpSession> SESSION_MAP = new HashMap<String, HttpSession>();

    public static int CURRENT_LOGIN_COUNT = 0;

    public static int TOTAL_HISTORY_COUNT = 0;

    public static int MAX_ONLINE_COUNT = 0;

    public static Date START_DATE = new Date();

    public static Date MAX_ONLINE_COUNT_DATE = new Date();
}
