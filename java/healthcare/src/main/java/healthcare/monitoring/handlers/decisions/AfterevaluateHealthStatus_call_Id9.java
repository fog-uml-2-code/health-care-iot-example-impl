package healthcare.monitoring.handlers.decisions;

import healthcare.models.BloodSugarLevel;
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
public class AfterevaluateHealthStatus_call_Id9 {

	@Inject
	private ActivityState activityState;

	/**
	 * @generated
	 * @return true if the ActivityEdge guarded by this condition should be taken, otherwise false.
	 */
	public boolean BloodSugarIsCritical() {
		Measurement<BloodSugarLevel> bloodSugarM = activityState.getLastBloodSugarLevel();
		if (Measurement.isValid(bloodSugarM)) {
			double bloodSugar = bloodSugarM.getMeasurement().getMmolPerLiter();
			return bloodSugar < 3.0 || bloodSugar > 10;
		}
		return false;
	}
	/**
	 * @generated
	 * @return true if the ActivityEdge guarded by this condition should be taken, otherwise false.
	 */
	public boolean BloodSugarIsHigh() {
		Measurement<BloodSugarLevel> bloodSugarM = activityState.getLastBloodSugarLevel();
		if (Measurement.isValid(bloodSugarM)) {
			double bloodSugar = bloodSugarM.getMeasurement().getMmolPerLiter();
			return bloodSugar > 7.5;
		}
		return false;
	}
	/**
	 * @generated
	 * @return true if the ActivityEdge guarded by this condition should be taken, otherwise false.
	 */
	public boolean BloodSugarIsLow() {
		Measurement<BloodSugarLevel> bloodSugarM = activityState.getLastBloodSugarLevel();
		if (Measurement.isValid(bloodSugarM)) {
			double bloodSugar = bloodSugarM.getMeasurement().getMmolPerLiter();
			return bloodSugar < 3.5;
		}
		return false;
	}

}

