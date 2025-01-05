package kafka;

import com.kafka.spring_kafka.payload.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

import static java.util.logging.Logger.*;

@Service
public class JsonKafkaConsumer {
    private static Logger logger = getLogger(String.valueOf(JsonKafkaConsumer.class));

    @KafkaListener(topics="topicBuilderJson", groupId = "groupId")
        public void consume(User user) {
        logger.info("Consumed message " +user.toString() );
    }

}
