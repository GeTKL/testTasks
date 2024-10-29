package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MsgConsumer {
	private final RedisSendMsg redisSendMsg;
	
	@Autowired
	public 
	MsgConsumer (RedisSendMsg redisSendMsg) {
		this.redisSendMsg = redisSendMsg;
	}
	
	@KafkaListener(topics = "messages", groupId = "group_id")
	public void consumer(String message) {
		System.out.println("Msg from Kafka: " + message);
		redisSendMsg.saveMessage(message);
	}
}
