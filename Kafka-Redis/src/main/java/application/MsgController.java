package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MsgController {
	private final MsgProducer msgProducer;
	
	@Autowired
	public MsgController(MsgProducer msgProducer) {
		this.msgProducer = msgProducer;
	}
	
	@PostMapping("/msgSend")
	public String sendMessage(@RequestBody String message) {
		msgProducer.sendMessage(message);
		return "Message send in Kafka: " + message;
	}
}
