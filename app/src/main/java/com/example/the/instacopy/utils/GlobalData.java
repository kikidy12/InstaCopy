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

    public static List<NewsfeedData> photoDatas = new ArrayList<>();
    public static List<NewsfeedData> newsfeedDatas = new ArrayList<>();
    public static List<NotificationData> NotidataList = new ArrayList<>();

    public static void initGlobalData() {
        photoDatas.clear();
    }
}
