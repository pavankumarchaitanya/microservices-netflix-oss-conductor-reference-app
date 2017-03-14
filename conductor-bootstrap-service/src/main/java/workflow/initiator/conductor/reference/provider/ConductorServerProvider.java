package workflow.initiator.conductor.reference.provider;

import org.slf4j.Logger;
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
	public static Logger logger = org.slf4j.LoggerFactory.getLogger(ConductorServerProvider.class);

	public ResponseEntity<String> getTaskDefs() {

		ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/api/metadata/taskdefs",
				HttpMethod.GET, null, String.class);
		logger.debug("response: " + response.getBody());
		return response;
	}

}
