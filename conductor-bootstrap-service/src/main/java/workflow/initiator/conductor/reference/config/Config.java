package workflow.initiator.conductor.reference.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.conductor.client.http.TaskClient;
import com.netflix.conductor.client.http.WorkflowClient;
/*
 * @author Pavan Kumar Chaitanya Landa
 */
@Configuration
public class Config {

	@Value("${conductor.server.api.endpoint}")
	String conductorServerEndpoint;

	@Bean
	public TaskClient getTaskClient() {
		TaskClient tc = new TaskClient();
		tc.setRootURI(conductorServerEndpoint);
		return tc;
	}

	@Bean
	public WorkflowClient getWorkflowClient() {
		WorkflowClient wc = new WorkflowClient();
		wc.setRootURI(conductorServerEndpoint);
		return wc;
	}

	@Bean
	public RestTemplate getRestTemplate() {

		return new RestTemplate();
	}

}
