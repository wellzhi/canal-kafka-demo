package com.example.demo.canal.service;

import com.alibaba.otter.canal.protocol.FlatMessage;

import java.util.Map;

public abstract class SyncCommonService {
    public abstract void sync(FlatMessage message);

    public abstract void add(Map<String, String> dataMap);

    public abstract void update(Map<String, String> oldDataMap, Map<String, String> dataMap);

    public abstract void delete(Map<String, String> dataMap);
}
