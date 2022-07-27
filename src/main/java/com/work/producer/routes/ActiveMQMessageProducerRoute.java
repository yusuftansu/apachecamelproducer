package com.work.producer.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQMessageProducerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        //generates an event/constant message every 60 seconds
        from("timer:active-mq-timer?period=30000")
                .transform().constant("Message From Producer")
                .log("${body}")
                .to("activemq:my-queue"); /** send this message to ActiveMQ queue **/
    }
}