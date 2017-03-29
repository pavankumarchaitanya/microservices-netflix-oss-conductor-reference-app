package notification.reference.provider;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.conductor.client.http.WorkflowClient;

import notification.reference.model.EmailNotification;
import notification.reference.model.Notification;
import notification.reference.model.SMSNotification;
import notification.reference.model.WebhookNotification;

/*
 * @author Pavan Kumar Chaitanya Landa
 * 
 */
@Component
public class NotificationWorkflowProvider implements NotificationProvider {

	@Autowired
	RestTemplate restTemplate;
	public static Logger logger = org.slf4j.LoggerFactory.getLogger(NotificationWorkflowProvider.class);

	@Autowired
	private WorkflowClient wc;

	/*
	 * invoke for conductor ui //TODO: Take this out after debugging
	 * http://104.198.150.92:3000
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * notification.reference.provider.NotificationProvider#publishNotification(
	 * notification.reference.model.Notification)
	 */
	@Override
	public void publishNotification(Notification notification) {
		logger.debug("Inside publishNotification [{}]", notification);
		Map<String, Object> inputParamMap = new HashMap<>();
		inputParamMap.put("notification", notification);
		logger.debug("[{}]Starting workflow..", notification.getUserID());
		wc.startWorkflow("kitchensink", 1, notification.getUserID(), inputParamMap);
		logger.debug("[{}]Workflow invocation complete..", notification.getUserID());

	}

	@Override
	public void publishSMSNotification(SMSNotification smsNotification) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void publishEmailNotification(EmailNotification smsNotification) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void publishWebhookNotification(WebhookNotification smsNotification) {
		// TODO Auto-generated method stub
		
	}

}
