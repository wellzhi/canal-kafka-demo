package com.example.demo.canal.service;

import com.alibaba.otter.canal.protocol.FlatMessage;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class SyncSKLService extends SyncCommonService {
    @Override
    public void sync(FlatMessage msg) {
    }

    @Override
    public void add(Map<String, String> dataMap) {

    }

    @Override
    public void update(Map<String, String> oldDataMap, Map<String, String> dataMap) {

    }

    @Override
    public void delete(Map<String, String> dataMap) {

    }
}
