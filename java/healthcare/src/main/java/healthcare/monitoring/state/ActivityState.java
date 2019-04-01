package healthcare.monitoring.state;

import healthcare.models.BloodPressure;
import healthcare.models.BloodSugarLevel;
import healthcare.models.BodyTemperature;

import javax.inject.Singleton;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * This is the singleton activity state service for the realization of the HealthCare activity.
 * 
 * Note that this class MUST be thread safe.
 */
@Singleton
public class ActivityState {

	private final AtomicReference<Measurement<Integer>> heartRate = new AtomicReference<>();
	private final AtomicReference<Measurement<BloodPressure>> bloodPressure = new AtomicReference<>();
	private final AtomicReference<Measurement<BloodSugarLevel>> bloodSugar = new AtomicReference<>();
	private final AtomicReference<Measurement<BodyTemperature>> bodyTemp = new AtomicReference<>();

	private final AtomicReference<Instant> lastSubmissionToDoctor = new AtomicReference<>(Instant.now());
	private final AtomicReference<Instant> lastCheckForTreatmentUpdates = new AtomicReference<>(Instant.now().minusSeconds(60 * 60 * 48));
	private final AtomicBoolean healthStatusCritical = new AtomicBoolean(false);

	public Measurement<Integer> getLastHeartRate() {
		return heartRate.get();
	}

	public void updateHeartRate(Integer heartRate) {
		this.heartRate.set(new Measurement<>(heartRate));
	}

	public Measurement<BloodPressure> getLastBloodPressure() {
		return bloodPressure.get();
	}

	public void updateBloodPressure(BloodPressure bloodPressure) {
		this.bloodPressure.set(new Measurement<>(bloodPressure));
	}

	public Measurement<BloodSugarLevel> getLastBloodSugarLevel() {
		return bloodSugar.get();
	}

	public void updateBloodSugarLevel(BloodSugarLevel bloodSugarLevel) {
		this.bloodSugar.set(new Measurement<>(bloodSugarLevel));
	}

	public Measurement<BodyTemperature> getLastBodyTemperature() {
		return bodyTemp.get();
	}

	public void updateBodyTemperature(BodyTemperature bodyTemp) {
		this.bodyTemp.set(new Measurement<>(bodyTemp));
	}

	public Instant getLastSubmissionToDoctor() {
		return lastSubmissionToDoctor.get();
	}

	public void updateLastSubmissionToDoctor() {
		lastSubmissionToDoctor.set(Instant.now());
	}

	public Instant getLastCheckForTreatmentUpdates() {
		return lastCheckForTreatmentUpdates.get();
	}

	public void updateLastCheckForTreatmentUpdates() {
		lastCheckForTreatmentUpdates.set(Instant.now());
	}

	public boolean isHealthStatusCritical() {
		return healthStatusCritical.get();
	}

	public void updateHealthStatusCritical(boolean value) {
		healthStatusCritical.set(value);
	}

}

