package cn.kidjoker.activeMQ.spring;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class Stage {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring/spring-context.xml");
		MessageService messageService = ctx.getBean(MessageService.class);
		
		messageService.sendQueueMessage("快递已发送");
		
		messageService.sendTopicMessage("快递正在揽件");
	}
}
