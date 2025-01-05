package kafka;

import com.kafka.spring_kafka.payload.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class JsonKafkaProducer {
    private static Logger logger = Logger.getLogger(JsonKafkaProducer.class.getName());

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    private KafkaTemplate<String, User> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, User user) {
    logger.info("Sending user: " + user);
        Message<User> message = MessageBuilder.withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, topicName).build();
        kafkaTemplate.send(message);
    }
}
