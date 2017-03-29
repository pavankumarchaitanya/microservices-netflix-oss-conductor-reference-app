package notification.reference.provider;

import notification.reference.model.EmailNotification;
import notification.reference.model.SMSNotification;
import notification.reference.model.WebhookNotification;

public interface NotificationProvider {

	void publishSMSNotification(SMSNotification smsNotification);

	void publishEmailNotification(EmailNotification smsNotification);

	void publishWebhookNotification(WebhookNotification smsNotification);

}
