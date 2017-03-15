package notification.reference.provider;

import notification.reference.model.Notification;

public interface NotificationProvider {

	void publishNotification(Notification notification);

}
