package healthcare.monitoring.handlers.decisions;

import io.micronaut.context.annotation.Prototype;
import javax.inject.Inject;

import healthcare.monitoring.state.ActivityState;

import java.time.Instant;

/**
 * This is the DecisionNode handler for .
 * 
 * @generated
 */
@Prototype
public class AfterStoreData_Id17 {

	private static final long ONE_DAY = 24 * 60 * 60 * 1000;

	@Inject
	private ActivityState activityState;

	/**
	 * @generated
	 * @return true if the ActivityEdge guarded by this condition should be taken, otherwise false.
	 */
	public boolean Is24HoursSinceLastDataSubmission() {
		long now = Instant.now().toEpochMilli();
		return now - activityState.getLastSubmissionToDoctor().toEpochMilli() >= ONE_DAY;
	}

}

