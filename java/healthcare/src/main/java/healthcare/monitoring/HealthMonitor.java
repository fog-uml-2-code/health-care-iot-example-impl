package healthcare.monitoring;

// Start of user code for imports
import java.time.Instant;
import java.util.*;

import healthcare.models.BloodPressure;
import healthcare.models.BloodSugarLevel;
import healthcare.models.BodyTemperature;
import healthcare.monitoring.state.ActivityState;
import healthcare.monitoring.state.Measurement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pusztai.thomas.architecture.fog.validation.*;



import javax.inject.*;
// End of user code

/**
 * This is the singleton service class for HealthMonitor.
 * 
 * @generated
 */
@Singleton
public class HealthMonitor {

	private final static long MAX_MEASUREMENT_AGE_MSEC = 10 * 60 * 1000;
	private static final Logger LOG = LoggerFactory.getLogger(HealthMonitor.class);

	@Inject
	private ActivityState activityState;

	/**
	 * Documentation of the method evaluateHealthStatus.
	 * 
	 * 
	 * @generated
	 */
	public void evaluateHealthStatus() {
		// This is NOT a real medical evaluation, it's just an example.
		Measurement<Integer> heartRateM = activityState.getLastHeartRate();
		Measurement<BloodPressure> bloodPressureM = activityState.getLastBloodPressure();
		Measurement<BodyTemperature> bodyTempM = activityState.getLastBodyTemperature();
		Measurement<BloodSugarLevel> bloodSugarM = activityState.getLastBloodSugarLevel();

		boolean isCritical = false;
		if (isMeasurementValid(heartRateM)) {
			int heartRate = heartRateM.getMeasurement();
			isCritical &= heartRate > 220 || heartRate < 30;
		}
		if (isMeasurementValid(bloodPressureM)) {
			BloodPressure bloodPressure = bloodPressureM.getMeasurement();
			isCritical &= bloodPressure.getMmHgSystolic() > 190 || bloodPressure.getMmHgSystolic() < 80;
			isCritical &= bloodPressure.getMmHgDiastolic() > 120 || bloodPressure.getMmHgDiastolic() < 40;
		}
		if (isMeasurementValid(bodyTempM)) {
			double bodyTemp = bodyTempM.getMeasurement().getDegCelsius();
			isCritical &= bodyTemp > 40.0 || bodyTemp < 34.0;
		}
		if (isMeasurementValid(bloodSugarM)) {
			double bloodSugar = bloodSugarM.getMeasurement().getMmolPerLiter();
			isCritical &= bloodSugar < 3.0 || bloodSugar > 10;
		}

		activityState.updateHealthStatusCritical(isCritical);
	}
	
	/**
	 * Documentation of the method sendAggregatedDataToDoctor.
	 * 
	 * 
	 * @generated
	 */
	public void sendAggregatedDataToDoctor() {
		LOG.info("sendAggregatedDataToDoctor()");
		activityState.updateLastSubmissionToDoctor();
	}
	
	/**
	 * Documentation of the method callAmbulance.
	 * 
	 * 
	 * @generated
	 */
	public void callAmbulance() {
		LOG.info("callAmbulance()");
	}
	
	/**
	 * Documentation of the method checkForTreatmentUpdates.
	 * 
	 * 
	 * @generated
	 */
	public void checkForTreatmentUpdates() {
		LOG.info("checkForTreatmentUpdates()");
		activityState.updateLastCheckForTreatmentUpdates();
	}

	private <T> boolean  isMeasurementValid(Measurement<T> measurement) {
		if (measurement != null && measurement.getMeasurement() != null) {
			long now = Instant.now().toEpochMilli();
			return (now - measurement.getMeasuredAt().toEpochMilli()) < MAX_MEASUREMENT_AGE_MSEC;
		}
		return false;
	}
	

}
