package notification.reference.model;

import java.util.Date;

public class NotificationEvent {
	private UserProfileUpdate userProfileUpdate;

	private Date timeStamp;

	public UserProfileUpdate getUserProfileUpdate() {
		return userProfileUpdate;
	}

	public void setUserProfileUpdate(UserProfileUpdate userProfileUpdate) {
		this.userProfileUpdate = userProfileUpdate;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
}
