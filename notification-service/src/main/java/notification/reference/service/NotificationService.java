package notification.reference.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.conductor.client.http.WorkflowClient;
import com.netflix.conductor.common.metadata.workflow.WorkflowDef;
import com.netflix.conductor.common.metadata.workflow.WorkflowTask;
import com.netflix.conductor.common.metadata.workflow.WorkflowTask.Type;

import notification.reference.model.Notification;
import notification.reference.provider.ConductorServerProvider;

/*
 * @author Pavan Kumar Chaitanya Landa
 * 
 */
@RestController
public class NotificationService {

	@Autowired
	private  WorkflowClient wc;

	@Autowired
	ConductorServerProvider conductorServerProvider;
	public static Logger logger = org.slf4j.LoggerFactory.getLogger(NotificationService.class);

	@RequestMapping(method = RequestMethod.POST, value = "/notifications")
	public void sendNotification(Notification notification) {
		WorkflowDef def = new WorkflowDef();
		def.setName("test");
		WorkflowTask t0 = new WorkflowTask();
		t0.setName("t0");
		t0.setWorkflowTaskType(Type.SIMPLE);
		t0.setTaskReferenceName("t0");

		WorkflowTask t1 = new WorkflowTask();
		t1.setName("t1");
		t1.setWorkflowTaskType(Type.SIMPLE);
		t1.setTaskReferenceName("t1");

		def.getTasks().add(t0);
		def.getTasks().add(t1);

		wc.registerWorkflow(def);
		// return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
	}

}
