package com.gokhand.spring.roomcleanernotifier;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RoomCleanerNotifierApplication {
    private static final String QUE_name = "room cleaner";
    private static final String Exchange_name = "operations";

    @Bean
    public Queue queue(){
        return new Queue(QUE_name, false);
    }
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(Exchange_name);
    }
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("landon.rooms.cleaner");

    }
    public static void main(String[] args) {
        SpringApplication.run(RoomCleanerNotifierApplication.class, args);
    }

}
