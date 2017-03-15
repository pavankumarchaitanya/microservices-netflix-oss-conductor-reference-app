package notification.reference.model;

public class Notification {

	private NotificationEvent event;

	private String userID;

	public NotificationEvent getEvent() {
		return event;
	}

	public void setEvent(NotificationEvent event) {
		this.event = event;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
}
