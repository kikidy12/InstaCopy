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

        photoDatas.add(new NewsfeedData(0, "가가가", 1, users.get(0)));
        photoDatas.add(new NewsfeedData(1, "나나나", 1, users.get(0)));
        photoDatas.add(new NewsfeedData(2, "다다다", 1, users.get(1)));
        photoDatas.add(new NewsfeedData(3, "라라라", 1, users.get(1)));
        photoDatas.add(new NewsfeedData(4, "마마마", 1, users.get(2)));
        photoDatas.add(new NewsfeedData(5, "바바바", 1, users.get(3)));

        newsfeedDatas.add(new NewsfeedData(0, "가가가", 1, users.get(0)));
        newsfeedDatas.add(new NewsfeedData(1, "나나나", 1, users.get(0)));
        newsfeedDatas.add(new NewsfeedData(2, "다다다", 1, users.get(1)));
        newsfeedDatas.add(new NewsfeedData(3, "라라라", 1, users.get(1)));
        newsfeedDatas.add(new NewsfeedData(4, "마마마", 1, users.get(2)));
        newsfeedDatas.add(new NewsfeedData(5, "바바바", 1, users.get(3)));

        NotidataList.add(new NotificationData(0, "reply", users.get(0), newsfeedDatas.get(0)));
        NotidataList.add(new NotificationData(1, "reply", users.get(0), newsfeedDatas.get(1)));
        NotidataList.add(new NotificationData(2, "like", users.get(2), newsfeedDatas.get(2)));
        NotidataList.add(new NotificationData(3, "reply", users.get(3), newsfeedDatas.get(3)));
        NotidataList.add(new NotificationData(4, "like", users.get(1), newsfeedDatas.get(0)));
        NotidataList.add(new NotificationData(5, "reply", users.get(2), newsfeedDatas.get(1)));
    }
}
