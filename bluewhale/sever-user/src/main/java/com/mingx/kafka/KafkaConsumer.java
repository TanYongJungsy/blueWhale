package com.mingx.kafka;

// 消费监听

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class KafkaConsumer {
    // 消费监听
//    @KafkaListener(topics = {"test"} ,groupId = "0")
//    public void onMessage1(ConsumerRecord<?, ?> record){
//        // 消费的哪个topic、partition的消息,打印出消息内容
//        System.out.println("简单消费："+record.topic()+"-"+record.partition()+"-"+record.value());
//    }

    /**
     * @Title 指定topic、partition、offset消费
     * @Description 同时监听topic1和topic2，监听topic1的0号分区、topic2的 "0号和1号" 分区，指向1号分区的offset初始值为8
     * @Author long.yuan
     * @Date 2020/3/22 13:38
     * @Param [record]
     * @return void
     **/
//    @KafkaListener(id = "consumer1",groupId = "felix-group",topicPartitions = {
//            @TopicPartition(topic = "topic1", partitions = { "0" }),
//            @TopicPartition(topic = "topic2", partitions = "0", partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "8"))
//    })
//    public void onMessage2(ConsumerRecord<?, ?> record) {
//        System.out.println("topic:"+record.topic()+"|partition:"+record.partition()+"|offset:"+record.offset()+"|value:"+record.value());
//    }

    @KafkaListener(id = "consumer3",groupId = "fe", topics = "test1")
    public void onMessage3(List<ConsumerRecord<?, ?>> records) {
        System.out.println(">>>批量消费一次，records.size()="+records.size());
        for (ConsumerRecord<?, ?> record : records) {
            System.out.println(record.value());
        }
    }

    @Autowired
    ConsumerFactory consumerFactory;
    // 消息过滤器
   // @Bean
    public ConcurrentKafkaListenerContainerFactory filterContainerFactory() {
        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory);
        // 被过滤的消息将被丢弃
        factory.setAckDiscarded(true);
        // 消息过滤策略
        factory.setRecordFilterStrategy(consumerRecord -> {

            if (Integer.parseInt(consumerRecord.value().toString()) % 2 == 0) {
                return false;
            }
            //返回true消息则被过滤
            return true;
        });
        return factory;
    }

     //消息过滤监听
    @KafkaListener(topics = {"test1"},containerFactory = "filterContainerFactory",groupId = "feli")
    public void onMessage6(ConsumerRecord<?, ?> record) {
        System.out.println(record.value());
    }
//    /**
//     * @Title 消息转发
//     * @Description 从topic1接收到的消息经过处理后转发到topic2
//     * @Author long.yuan
//     * @Date 2020/3/23 22:15
//     * @Param [record]
//     * @return void
//     **/
////    @KafkaListener(topics = {"topic1"})
////    @SendTo("topic2")
////    public String onMessage7(ConsumerRecord<?, ?> record) {
////        return record.value()+"-forward message";
////    }

}