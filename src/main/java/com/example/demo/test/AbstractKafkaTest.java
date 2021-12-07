package com.example.demo.test;


/**
 * Kafka 测试基类
 *
 * @author machengyuan @ 2018-6-12
 * @version 1.0.0
 */
public abstract class AbstractKafkaTest extends BaseCanalClientTest {

    public static String  topic     = "ainews_mq_topic";
    public static Integer partition = null;
    public static String  groupId   = "test";
    // public static String  servers   = "172.16.100.50:6667";
    public static String  servers   = "172.16.100.50:9092";
    public static String  zkServers = "172.16.100.50:2181";

    public void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }
}
