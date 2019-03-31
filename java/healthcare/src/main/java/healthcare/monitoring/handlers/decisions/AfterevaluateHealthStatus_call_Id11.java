package healthcare.monitoring.handlers.decisions;

import healthcare.monitoring.state.Measurement;
import io.micronaut.context.annotation.Prototype;
import javax.inject.Inject;

import healthcare.monitoring.state.ActivityState;

/**
 * This is the DecisionNode handler for .
 * 
 * @generated
 */
@Prototype
public class AfterevaluateHealthStatus_call_Id11 {

	@Inject
	private ActivityState activityState;

	/**
	 * @generated
	 * @return true if the ActivityEdge guarded by this condition should be taken, otherwise false.
	 */
	public boolean HeartRateIsAbnormal() {
		Measurement<Integer> heartRateM = activityState.getLastHeartRate();
		if (Measurement.isValid(heartRateM)) {
			int heartRate = heartRateM.getMeasurement();
			return heartRate > 220 || heartRate < 30;
		}
		return false;
	}

}

