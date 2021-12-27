package com.play.playground.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DelayTaskConfig {

    public static final String DELAY_EXCHANGE = "delay_exchange";

    public static final String BLACK_QUEUE = "black_queue";

    public static final String BLACK_KEY = "black_key";

    public static final String ORDER_QUEUE = "order_queue";

    public static final String ORDER_KEY = "order_key";

    public static final String ATTEND_QUEUE = "attend_queue";

    public static final String ATTEND_KEY = "attend_queue";

    /**
     * 延时队列交换机
     * 注意这里的交换机类型：CustomExchange
     *
     * @return
     */
    @Bean
    public CustomExchange delayExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(DELAY_EXCHANGE,
                "x-delayed-message",
                true,
                false,
                args);
    }

    @Bean
    public Queue blackQueue() {
        return new Queue(BLACK_QUEUE, true);
    }

    @Bean
    public Queue orderQueue() {
        return new Queue(ORDER_QUEUE, true);
    }
    @Bean
    public Queue attendQueue() {
        return new Queue(ATTEND_QUEUE, true);
    }

    @Bean
    public Binding blackDelayBinding(Queue blackQueue, CustomExchange delayExchange){
        return BindingBuilder.bind(blackQueue).to(delayExchange).with(BLACK_KEY).noargs();
    }

    @Bean
    public Binding orderDelayBinding(Queue orderQueue, CustomExchange delayExchange){
        return BindingBuilder.bind(orderQueue).to(delayExchange).with(ORDER_KEY).noargs();
    }

    @Bean
    public Binding attendDelayBinding(Queue attendQueue, CustomExchange delayExchange){
        return BindingBuilder.bind(attendQueue).to(delayExchange).with(ATTEND_KEY).noargs();
    }
}
