package cn.kidjoker.activeMQ.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


public class QueueListener implements MessageListener {
	
	public void onMessage(Message message) {
		if(message instanceof TextMessage) {
			try {
				TextMessage textMsg = (TextMessage)message;
				String msgStr = textMsg.getText();
				System.out.println("队列监听器接收到文本消息：" + msgStr);
			}
			catch(JMSException e) {
				e.printStackTrace();
			}
		}
		else {
			throw new IllegalArgumentException("只支持TextMessage类型的消息");
		}
		
	}
	
}
