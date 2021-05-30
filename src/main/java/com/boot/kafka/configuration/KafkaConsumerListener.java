package com.boot.kafka.configuration;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.boot.kafka.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaConsumerListener {
	
	@KafkaListener(topics="springProducerTopic", groupId="group_id")
	public void consumeMessg(String message) {
		
		System.out.println("Message received is "+ message );
		
	}
	
	@KafkaListener(topics="springProducerJsonTopic", groupId="group_json", containerFactory="userKafkaListenerContianerFactory")
	public void consumeMessgJson(User user) throws JsonProcessingException {
		
		String jsonForm = new ObjectMapper().writeValueAsString(user);
		System.out.println("Json Message received is "+ jsonForm);
		
	}
	
	

}
