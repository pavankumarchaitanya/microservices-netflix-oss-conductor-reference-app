import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import notification.reference.model.Notification;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class NotificationServiceTest {

	@Test
	public void notificationServiceTest() throws JsonProcessingException{
		PodamFactory factory = new PodamFactoryImpl();

		Notification notification = factory.manufacturePojoWithFullData(Notification.class);
		ObjectMapper om = new ObjectMapper();
		String notificationAsString  = om.writeValueAsString(notification);
		System.out.println("Notification JSON : " + notificationAsString);
	}
}

