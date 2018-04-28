package cn.kidjoker.activeMQ.spring;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	
	@Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    @Resource(name = "queueTest")
    private Destination queueTest;

    @Resource(name = "topicTest")
    private Destination topicTest;
    
    /* 向队列发送消息 */
    public void sendQueueMessage(final String messageContent) {
    	jmsTemplate.send(queueTest, new MessageCreator() {
    		
    		public Message createMessage(Session session) throws JMSException {
				TextMessage msg = session.createTextMessage();
				msg.setText(messageContent);
				return msg;
			}
		});
    }
    
    /* 向主题推送消息 */
    public void sendTopicMessage(final String messageContent) {
    	jmsTemplate.send(topicTest, new MessageCreator() {
			
			public Message createMessage(Session session) throws JMSException {
				TextMessage msg = session.createTextMessage();
				msg.setText(messageContent);
				return msg;
			}
		});
    }

}
