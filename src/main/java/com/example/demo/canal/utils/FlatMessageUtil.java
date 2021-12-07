package com.example.demo.canal.utils;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.otter.canal.protocol.FlatMessage;

import java.util.HashMap;
import java.util.Map;

public class FlatMessageUtil {

    public static Map<String, String> getData(FlatMessage msg) {
        HashMap<String, String> map = new HashMap<>();
        if (CollUtil.isNotEmpty(msg.getData())) {
            map.putAll(msg.getData().get(0));
        }
        return map;
    }
}
