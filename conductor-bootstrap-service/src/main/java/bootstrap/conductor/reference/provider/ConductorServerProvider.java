package bootstrap.conductor.reference.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/*
 * @author Pavan Kumar Chaitanya Landa
 * 
 */
@Component
public class ConductorServerProvider {

	@Autowired
	RestTemplate restTemplate;

	public ResponseEntity<String> getTaskDefs() {

		return restTemplate.exchange("http://localhost:8080/metadata/taskdefs", HttpMethod.GET, null, String.class);

	}

}
