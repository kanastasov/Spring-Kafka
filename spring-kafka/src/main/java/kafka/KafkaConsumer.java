package kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Value("${spring.kafka.topic.name}")
    private String topicName;


    private static Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId="groupId")
    public void consume(String message) {
        logger.info(message);
    }
}
