package com.example.the.instacopy.utils;

import com.example.the.instacopy.data.NewsfeedData;
import com.example.the.instacopy.data.NotificationData;
import com.example.the.instacopy.data.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by the on 2017-09-05.
 */

public class GlobalData {

    public static List<User> users = new ArrayList<>();
    public static List<NewsfeedData> photoDatas = new ArrayList<>();
    public static List<NewsfeedData> newsfeedDatas = new ArrayList<>();
    public static List<NotificationData> NotidataList = new ArrayList<>();

    public static void initGlobalData() {
        users.clear();
        photoDatas.clear();
        newsfeedDatas.clear();
        NotidataList.clear();

        users.add(new User(0, "aaa", "aname", ""));
        users.add(new User(1, "bbb", "bname", ""));
        users.add(new User(2, "ccc", "cname", ""));
        users.add(new User(3, "ddd", "dname", ""));
        users.add(new User(4, "eee", "ename", ""));
        users.add(new User(5, "fff", "fname", ""));

    }
}
