package com.nsw.configuration;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

//@Configuration
//@EnableRabbit
public class RabbitMQConfiguration implements RabbitListenerConfigurer {

    @Autowired
    private Environment environment;

    @Bean
    public ConnectionFactory connectionFactory() {
//        CachingConnectionFactory factory = new CachingConnectionFactory();
//        factory.setHost(environment.getProperty("activemq.host"));
//        factory.setUsername(environment.getProperty("activemq.user"));
//        factory.setPassword(environment.getProperty("activemq.password"));
//        factory.setVirtualHost(environment.getProperty("activemq.virtualHost"));
//        factory.setPort(Integer.valueOf(environment.getProperty("activemq.port")));
//        return factory;
        return null;
    }
    
    @Bean
    public TopicExchange signExchange() {
        return new TopicExchange("signExchange"); // Durable: true; Auto Delete: false
    }

    
    @Bean
    public Queue signDoneQueue() {
        return new Queue("Sign_Done_Queue"); // Durable: true;
    }
    
    @Bean
    public Binding declareBindingSignDone() {
        return BindingBuilder.bind(signDoneQueue()).to(signExchange()).with("signDone");
    }
 
    // You can comment all methods below and remove interface's implementation to use the default serialization / deserialization
    @Bean
    public RabbitTemplate rabbitTemplate() {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        //rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    
    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    
    @Bean
    public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
        return new MappingJackson2MessageConverter();
    }
     

    @Bean
    public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        factory.setMessageConverter(consumerJackson2MessageConverter());
        return factory;
    }

    @Override
    public void configureRabbitListeners(final RabbitListenerEndpointRegistrar registrar) {
        registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
    }
    
     @Bean
     public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
       SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
       factory.setConnectionFactory(connectionFactory());
       factory.setMaxConcurrentConsumers(5);
       return factory;
     }
}
