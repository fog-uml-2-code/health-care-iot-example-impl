package healthcare.monitoring.handlers.opaqueactions;

import healthcare.models.BloodPressure;
import healthcare.models.BloodSugarLevel;
import healthcare.models.BodyTemperature;
import healthcare.monitoring.HealthDataStore;
import healthcare.monitoring.state.Measurement;
import io.micronaut.context.annotation.Prototype;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pusztai.thomas.architecture.fog.activity.realization.OpaqueActionHandler;

import healthcare.monitoring.state.ActivityState;

/**
 * This is the OpaqueAction handler for Store Data.
 * 
 * @generated
 */
@Prototype
public class StoreData implements OpaqueActionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(StoreData.class);

	@Inject
	private ActivityState activityState;

	@Inject
	private HealthDataStore healthDataStore;

	/**
	 * Executes the OpaqueAction.
	 * @generated
	 * @return The parameter(s) that should be passed to the upcoming call of the operation.
	 */
	@Override
	public void executeAction() {
		LOG.info("StoreData");
		Measurement<BloodPressure> bloodPressureM = activityState.getLastBloodPressure();
		Measurement<BodyTemperature> bodyTempM = activityState.getLastBodyTemperature();
		Measurement<BloodSugarLevel> bloodSugarM = activityState.getLastBloodSugarLevel();

		if (bloodPressureM != null) {
			healthDataStore.storeBloodPressure((int) bloodPressureM.getMeasuredAt().toEpochMilli(), bloodPressureM.getMeasurement());
		}
		if (bodyTempM != null) {
			healthDataStore.storeBodyTemperature((int) bodyTempM.getMeasuredAt().toEpochMilli(), bodyTempM.getMeasurement());
		}
		if (bloodSugarM != null) {
			healthDataStore.storeBloodSugarLevel((int) bloodSugarM.getMeasuredAt().toEpochMilli(), bloodSugarM.getMeasurement());
		}
	}

}

