package bootstrap.conductor.reference.provider;

import org.springframework.beans.factory.annotation.Autowired;
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

}
