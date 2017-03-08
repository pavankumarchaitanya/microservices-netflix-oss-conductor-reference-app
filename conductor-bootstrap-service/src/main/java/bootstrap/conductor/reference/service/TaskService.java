package bootstrap.conductor.reference.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.conductor.client.http.TaskClient;
import com.netflix.conductor.common.metadata.tasks.TaskDef;
import com.netflix.conductor.common.metadata.tasks.TaskDef.TimeoutPolicy;

import bootstrap.conductor.reference.provider.ConductorServerProvider;

/*
 * @author Pavan Kumar Chaitanya Landa
 * 
 */
@RestController
public class TaskService {

	@Autowired
	private TaskClient tc;

	@Autowired
	ConductorServerProvider conductorServerProvider;

	public static Logger logger = org.slf4j.LoggerFactory.getLogger(TaskService.class);

	@RequestMapping(method = RequestMethod.PUT, value = "/tasks")
	public void createTasks() {
		List<TaskDef> defs = new LinkedList<>();
		for (int i = 0; i < 5; i++) {
			TaskDef def = new TaskDef("t" + i, "task " + i);
			Date current = new Date();

			def.setUpdateTime(current.getTime());
			def.setTimeoutPolicy(TimeoutPolicy.RETRY);
			defs.add(def);
		}
		tc.registerTaskDefs(defs);
		// return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/swagger-ui")
	public String swaggerUi() {
		logger.debug("insided swagger ui..");
		return "redirect:swagger-ui.html";
	}

}
