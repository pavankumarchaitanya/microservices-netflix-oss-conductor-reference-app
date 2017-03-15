package notification.reference.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.conductor.client.http.WorkflowClient;

import notification.reference.exception.ProcessorException;
import notification.reference.model.Notification;
import notification.reference.processor.NotificationProcessor;

/*
 * @author Pavan Kumar Chaitanya Landa
 * 
 */
@RestController
public class NotificationService {

	@Autowired
	NotificationProcessor notificationProcessor;

	public static Logger logger = org.slf4j.LoggerFactory.getLogger(NotificationService.class);

	@RequestMapping(method = RequestMethod.POST, value = "/notifications")
	public ResponseEntity<?> sendNotification(
			@RequestBody(required = true) Notification notification) {
		ResponseEntity<?> responseEntity = null;
		try {
			notificationProcessor.validateNotification(notification);

			notificationProcessor.processNotification(notification);
		} catch (ProcessorException pe) {
			responseEntity = new ResponseEntity<>("Error processing notification", HttpStatus.INTERNAL_SERVER_ERROR);
			return responseEntity;
		}

		responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
		// return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);

	}

}
