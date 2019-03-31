package healthcare.monitoring;

// Start of user code for imports
import java.time.Instant;
import java.util.*;

import healthcare.monitoring.state.ActivityState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pusztai.thomas.architecture.fog.validation.*;


import healthcare.models.BloodPressure;
import healthcare.models.BloodSugarLevel;
import healthcare.models.BodyTemperature;

import javax.inject.*;
// End of user code

/**
 * This is the singleton service class for HealthDataStore.
 * 
 * @generated
 */
@Singleton
public class HealthDataStore {

	private static final Logger LOG = LoggerFactory.getLogger(HealthDataStore.class);

	/**
	 * Documentation of the method storeHeartRate.
	 * 
	 * @param timestamp
	 * @param bpm
	 * 
	 * @generated
	 */
	public void storeHeartRate(Integer timestamp, Integer bpm) {
		LOG.info("storeHeartRate(time: {}, bpm: {})", getTime(timestamp), bpm);
	}
	
	/**
	 * Documentation of the method storeBodyTemperature.
	 * 
	 * @param timestamp
	 * @param temperature
	 * 
	 * @generated
	 */
	public void storeBodyTemperature(Integer timestamp, BodyTemperature temperature) {
		LOG.info("storeBodyTemperature(time: {}, temp: {})", getTime(timestamp), temperature.getDegCelsius());
	}
	
	/**
	 * Documentation of the method storeBloodSugarLevel.
	 * 
	 * @param timestamp
	 * @param sugarLevel
	 * 
	 * @generated
	 */
	public void storeBloodSugarLevel(Integer timestamp, BloodSugarLevel sugarLevel) {
		LOG.info("storeBloodSugarLevel(time: {}, mmolPerLiter: {})", getTime(timestamp), sugarLevel.getMmolPerLiter());
	}
	
	/**
	 * Documentation of the method storeBloodPressure.
	 * 
	 * @param timestamp
	 * @param bloodPressure
	 * 
	 * @generated
	 */
	public void storeBloodPressure(Integer timestamp, BloodPressure bloodPressure) {
		LOG.info("storeBloodPressure(time: {}, bloodPressure: {}/{}", getTime(timestamp), bloodPressure.getMmHgSystolic(), bloodPressure.getMmHgDiastolic());
	}

	private String getTime(Integer timestamp) {
		if (timestamp != null) {
			return Instant.ofEpochMilli(timestamp).toString();
		}
		return "null";
	}

}
