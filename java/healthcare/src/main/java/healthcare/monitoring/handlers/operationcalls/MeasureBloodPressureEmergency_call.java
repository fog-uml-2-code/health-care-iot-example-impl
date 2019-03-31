package healthcare.monitoring.handlers.operationcalls;

import io.micronaut.context.annotation.Prototype;
import io.micronaut.http.client.exceptions.HttpClientException;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pusztai.thomas.architecture.fog.activity.realization.CallOperationActionHandler;
import healthcare.monitoring.state.ActivityState;

import healthcare.models.BloodPressure;

/**
 * This is the CallOperationAction handler for measureBloodPressureEmergency_call.
 * 
 * @generated
 */
@Prototype
public class MeasureBloodPressureEmergency_call implements CallOperationActionHandler<Void, BloodPressure> {

	private static final Logger LOG = LoggerFactory.getLogger(MeasureBloodPressureEmergency_call.class);

	@Inject
	private ActivityState activityState;

	/**
	 * @generated
	 * @return The parameter(s) that should be passed to the upcoming call of the operation.
	 */
	@Override
	public Void assembleParameters() {
		return null;
	}

	/**
	 * Handles the return value of the operation.
	 * @generated
	 * @param result The return value of the last operation call.
	 */
	@Override
	public void handleResult(BloodPressure result) {
		LOG.info("measureBloodPressureEmergency() = {}/{}", result.getMmHgSystolic(), result.getMmHgDiastolic());
		activityState.updateBloodPressure(result);
	}

	/**
	 * Handles an error, if one occurred while making the REST request.
	 * @generated
	 * @param error The exception describing the error.
	 */
	public void handleError(HttpClientException error) {
		LOG.error("Error", error);
	}

}

