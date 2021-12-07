package com.example.demo.canal;

import com.example.demo.canal.service.SyncCommonService;
import com.example.demo.canal.service.SyncSKLService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SyncFactory {
    static Map<String, SyncCommonService> serviceMap = new HashMap<>();
    // static Map<String, Class<?>> beanMap = new HashMap<>();

    static {
        serviceMap.put("core_comparison_platform_goods_item", new SyncSKLService());
        serviceMap.put("tags", new SyncSKLService());
    }

    public static Optional<SyncCommonService> getService(String tableName) {
        return Optional.ofNullable(serviceMap.get(tableName));
    }

    // static {
    //     beanMap.put("core_comparison_platform_goods_item", ComparisonPlatformGoodsItem.class);
    //     beanMap.put("tags", ComparisonPlatformGoodsItem.class);
    // }

    // public static Optional<? extends Class<?>> getBeanClass(String tableName) {
    //     return Optional.ofNullable(beanMap.get(tableName));
    // }
}
