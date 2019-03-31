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
		LOG.info("evaluateHealthStatus()");
	}
	
	/**
	 * Documentation of the method sendAggregatedDataToDoctor.
	 * 
	 * 
	 * @generated
	 */
	public void sendAggregatedDataToDoctor() {
		LOG.info("sendAggregatedDataToDoctor()");
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
	}

}
