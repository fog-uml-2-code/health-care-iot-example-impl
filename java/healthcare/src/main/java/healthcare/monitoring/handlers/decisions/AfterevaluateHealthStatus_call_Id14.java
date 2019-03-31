package healthcare.monitoring.handlers.decisions;

import healthcare.models.BloodPressure;
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
public class AfterevaluateHealthStatus_call_Id14 {

	@Inject
	private ActivityState activityState;

	/**
	 * @generated
	 * @return true if the ActivityEdge guarded by this condition should be taken, otherwise false.
	 */
	public boolean BloodPressureCritical() {
		Measurement<BloodPressure> bloodPressureM = activityState.getLastBloodPressure();
		boolean isCritical = false;
		if (Measurement.isValid(bloodPressureM)) {
			BloodPressure bloodPressure = bloodPressureM.getMeasurement();
			isCritical = bloodPressure.getMmHgSystolic() > 190 || bloodPressure.getMmHgSystolic() < 80;
			isCritical &= bloodPressure.getMmHgDiastolic() > 120 || bloodPressure.getMmHgDiastolic() < 40;
		}
		return isCritical;
	}

}

