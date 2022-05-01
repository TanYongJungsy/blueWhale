//package com.mingx.kafka;
//
//import io.netty.util.internal.StringUtil;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//public class KafkaProducer {
//
//    @Autowired
//    private KafkaTemplate<String, Object> kafkaTemplate;
//
//    // 发送消息
//    @GetMapping ("/kafka/normal")
//    public void sendMessage1() {
//        List<String> list=new ArrayList<>();
//        for (int i = 0; i <10 ; i++) {
//            list.add((String.valueOf(i+1)));
//        }
//        list.forEach(msg -> kafkaTemplate.send("test1", msg));
//
//    }
//
//    @GetMapping("/kafka/callbackOne/{message}")
//    public void sendMessage2(@PathVariable("message") String callbackMessage) {
//        kafkaTemplate.send("test", callbackMessage).addCallback(success -> {
//            // 消息发送到的topic
//            String topic = success.getRecordMetadata().topic();
//            // 消息发送到的分区
//            int partition = success.getRecordMetadata().partition();
//            // 消息在分区内的offset
//            long offset = success.getRecordMetadata().offset();
//            System.out.println("发送消息成功:" + topic + "-" + partition + "-" + offset);
//        }, failure -> {
//            System.out.println("发送消息失败:" + failure.getMessage());
//        });
//    }
//
//    @GetMapping("/kafka/transaction")
//    public void sendMessage7(){
//        // 声明事务：后面报错消息不会发出去
//        kafkaTemplate.executeInTransaction(operations -> {
//            operations.send("topic1","test executeInTransaction");
//            throw new RuntimeException("fail");
//        });
//        // 不声明事务：后面报错但前面消息已经发送成功了
//        kafkaTemplate.send("topic1","test executeInTransaction");
//        throw new RuntimeException("fail");
//    }
//}package com.mingx.kafka;
//
//import io.netty.util.internal.StringUtil;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//public class KafkaProducer {
//
//    @Autowired
//    private KafkaTemplate<String, Object> kafkaTemplate;
//
//    // 发送消息
//    @GetMapping ("/kafka/normal")
//    public void sendMessage1() {
//        List<String> list=new ArrayList<>();
//        for (int i = 0; i <10 ; i++) {
//            list.add((String.valueOf(i+1)));
//        }
//        list.forEach(msg -> kafkaTemplate.send("test1", msg));
//
//    }
//
//    @GetMapping("/kafka/callbackOne/{message}")
//    public void sendMessage2(@PathVariable("message") String callbackMessage) {
//        kafkaTemplate.send("test", callbackMessage).addCallback(success -> {
//            // 消息发送到的topic
//            String topic = success.getRecordMetadata().topic();
//            // 消息发送到的分区
//            int partition = success.getRecordMetadata().partition();
//            // 消息在分区内的offset
//            long offset = success.getRecordMetadata().offset();
//            System.out.println("发送消息成功:" + topic + "-" + partition + "-" + offset);
//        }, failure -> {
//            System.out.println("发送消息失败:" + failure.getMessage());
//        });
//    }
//
//    @GetMapping("/kafka/transaction")
//    public void sendMessage7(){
//        // 声明事务：后面报错消息不会发出去
//        kafkaTemplate.executeInTransaction(operations -> {
//            operations.send("topic1","test executeInTransaction");
//            throw new RuntimeException("fail");
//        });
//        // 不声明事务：后面报错但前面消息已经发送成功了
//        kafkaTemplate.send("topic1","test executeInTransaction");
//        throw new RuntimeException("fail");
//    }
//}