package com.mingx.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.listener.ConsumerAwareBatchErrorHandler;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Consumer;


@Component
@Slf4j
public class KafkaConsumer  {



    @KafkaListener(topics = "myTopic", groupId ="myGroup")
    public void topic_test(ConsumerRecords<String,String> record) {
        for (ConsumerRecord<String, String> temp : record) {
            String topic=temp.topic();
        String key= temp.key();
        String value=temp.value();
        int partition=temp.partition();
        long timestamp =temp.timestamp();
            log.info(""+topic+ "消费了key:" + key + ",value:" + value+",partition:"+partition+",timestamp:"+timestamp);
        }

//        String topic=record.topic();
//        String key= record.key();
//        String value=record.value();
//        int partition=record.partition();
//        long timestamp =record.timestamp();
//        log.info(""+topic+ "消费了key:" + key + "value," + value+",partition"+partition+",timestamp"+timestamp);
        //        Optional message = Optional.ofNullable(record.value());
//        if (message.isPresent()) {
//            Object msg = message.get();
//            log.info("topic_test1 消费了： Topic:" + topic + ",Message:" + msg);
//            ack.acknowledge();
//        }
        }
//    @KafkaListener(topics = "myTopic", groupId ="myGroup")
//    public void onMessage(ConsumerRecord<?, ?> record, Acknowledgment ack) {
//        String topic=record.topic();
//        String key= record.key().toString();
//        String value=record.value().toString();
//        int partition=record.partition();
//        long timestamp =record.timestamp();
//        log.info(""+topic+ "消费了key:" + key + "value," + value+",partition"+partition+",timestamp"+timestamp);
//    }

//    @KafkaListener(topics = "myTopic", groupId ="myGroup")
//    public void topic_test(ConsumerRecord<String,Object> record, Acknowledgment ack) {

//        Optional message = Optional.ofNullable(record.value());
//        if (message.isPresent()) {
//            Object msg = message.get();
//            log.info("topic_test 消费了： Topic:" + record.topic()+ ",Message:" + msg);
//            ack.acknowledge();
//        }
//    }
}


//
//    @KafkaListener(topics = KafkaProducer.TOPIC_TEST, groupId = KafkaProducer.TOPIC_GROUP2)
//    public void topic_test1(ConsumerRecord<?, ?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
//
//        Optional message = Optional.ofNullable(record.value());
//        if (message.isPresent()) {
//            Object msg = message.get();
//            log.info("topic_test1 消费了： Topic:" + topic + ",Message:" + msg);
//            ack.acknowledge();
//        }
//    }
//}
//}