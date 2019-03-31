package healthcare.monitoring.handlers.decisions;

import healthcare.models.BloodPressure;
import healthcare.monitoring.state.Measurement;
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
public class AfterQueryData_Id7 {

	private static final long ONE_HOUR = 60 * 60 * 1000;

	@Inject
	private ActivityState activityState;

	/**
	 * @generated
	 * @return true if the ActivityEdge guarded by this condition should be taken, otherwise false.
	 */
	public boolean LastBloodPressureCheckOlderThan1Hour() {
		Measurement<BloodPressure> bloodPressureM = activityState.getLastBloodPressure();
		if (bloodPressureM != null) {
			long now = Instant.now().toEpochMilli();
			return now - bloodPressureM.getMeasuredAt().toEpochMilli() > ONE_HOUR;
		}
		return true;
	}

}

