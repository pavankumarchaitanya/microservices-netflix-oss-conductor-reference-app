package notification.reference.processor;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import notification.reference.exception.ProcessorException;
import notification.reference.model.Notification;
import notification.reference.provider.NotificationProvider;

@Component
public class NotificationProcessor {

	@Autowired
	NotificationProvider notificationWorkflowProvider;

	public static Logger logger = org.slf4j.LoggerFactory.getLogger(NotificationProcessor.class);

	public void validateNotification(Notification notification) throws ProcessorException {

		if (notification.getEvent() == null || notification.getUserID() == null) {
			throw new ProcessorException("Notification Event cannot be null");
		}

	}

	public void processNotification(Notification notification) {
		notificationWorkflowProvider.publishNotification(notification);
	}
}
