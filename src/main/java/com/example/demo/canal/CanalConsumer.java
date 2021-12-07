package com.example.demo.canal;

import com.alibaba.fastjson.JSON;
import com.alibaba.otter.canal.protocol.FlatMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Slf4j
@Component
public class CanalConsumer {
    //  @KafkaListener(topics = "ainews_mq_topic")
    // public void onMessage(String message){
    //     //insertIntoDb(buffer);//这里为插入数据库代码
    //     System.out.println(message);
    // }

    // @KafkaListener(topics = {"ainews_mq_topic"})
    // public void consumer(ConsumerRecord<?, ?> record) {
    //     Optional<?> kafkaMessage = Optional.ofNullable(record.value());
    //     if (kafkaMessage.isPresent()) {
    //         Object message = kafkaMessage.get();
    //         log.info("----------------- record =" + record);
    //         log.info("------------------ message =" + message);
    //     }
    // }


    // 【注意】使用此方法，canal.properties需要配置canal.mq.flatMessage = true
    @KafkaListener(topics = "ainews_mq_topic")
    public void receive(ConsumerRecord<?, ?> consumer) {
        String data = (String) consumer.value();
        log.info(">>>>>> topic=[{}]，key=[{}]，分区位置=[{}]，下标=[{}]", consumer.topic(), consumer.key(), consumer.partition(), consumer.offset());
        FlatMessage flatMsg = JSON.parseObject(data, FlatMessage.class);

        // 第一种，分散到service处理
        // **********************************************************************************************************************************************
        log.info(">>>>>> 表名=[{}]，DDL=[{}]，类型=[{}]，旧数据=[{}]", flatMsg.getTable(), flatMsg.getIsDdl(), flatMsg.getType(), flatMsg.getOld());
        // 1.1、表名不存在，显示抛异常
        // SyncFactory.getService(flatMsg.getTable())
        //         .orElseThrow(() -> new IllegalArgumentException("Invalid tableName"))
        //         .sync(flatMsg);
        // 1.2、表名不存在，直接忽略
        SyncFactory.getService(flatMsg.getTable()).ifPresent(service -> service.sync(flatMsg));
        // **********************************************************************************************************************************************


        // 第二种，区分增删改，调用不同的方法
        // **********************************************************************************************************************************************
        Boolean isDdl = flatMsg.getIsDdl();
        String type = flatMsg.getType();
        if (!isDdl) {
            //非DDL修改（数据修改）
            if ("INSERT".equals(type)) {
                //新增语句
                SyncFactory.getService(flatMsg.getTable()).ifPresent(service -> service.add(flatMsg.getData().get(0)));
            } else if ("UPDATE".equals(type)) {
                //更新语句
                SyncFactory.getService(flatMsg.getTable()).ifPresent(service -> service.update(flatMsg.getOld().get(0), flatMsg.getData().get(0)));
            } else {
                //删除语句
                SyncFactory.getService(flatMsg.getTable()).ifPresent(service -> service.delete(flatMsg.getData().get(0)));
            }
        } else {
            // DDL修改（表结构修改）
        }
        // **********************************************************************************************************************************************
    }
}
