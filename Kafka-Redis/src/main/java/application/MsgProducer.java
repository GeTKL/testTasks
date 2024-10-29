package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MsgProducer {
	private static final String TOPIC_NAME = "messages";
	private final KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	public MsgProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(String message) {
		kafkaTemplate.send(TOPIC_NAME, "Received: " + message);
	}
}
