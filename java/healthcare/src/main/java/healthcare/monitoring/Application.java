package healthcare.monitoring;

import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;
import javax.inject.Inject;
import pusztai.thomas.architecture.fog.activity.realization.execution.ActivityExecutionManager;
import pusztai.thomas.architecture.fog.activity.realization.dto.ActivityInfoDto;


public class Application {

	@Inject
	private ActivityExecutionManager executionManager;

	public static void main(String[] args) {
		Micronaut.run(Application.class);
	}

	@EventListener
    void onStartup(StartupEvent event) {
        ActivityInfoDto activityInfo = ActivityInfoDto.loadFromResource("/Activity.json");
		this.executionManager.loadActivity(activityInfo);
		this.executionManager.startActivity();
    }

}

