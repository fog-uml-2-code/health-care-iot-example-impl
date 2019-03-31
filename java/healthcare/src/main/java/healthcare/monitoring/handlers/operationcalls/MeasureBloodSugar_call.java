package healthcare.monitoring.handlers.operationcalls;

import io.micronaut.context.annotation.Prototype;
import io.micronaut.http.client.exceptions.HttpClientException;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pusztai.thomas.architecture.fog.activity.realization.CallOperationActionHandler;
import healthcare.monitoring.state.ActivityState;

import healthcare.models.BloodSugarLevel;

/**
 * This is the CallOperationAction handler for measureBloodSugar_call.
 * 
 * @generated
 */
@Prototype
public class MeasureBloodSugar_call implements CallOperationActionHandler<Void, BloodSugarLevel> {

	private static final Logger LOG = LoggerFactory.getLogger(MeasureBloodSugar_call.class);

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
	public void handleResult(BloodSugarLevel result) {
		LOG.info("measureBloodSugar() = {} mmolPerLiter", result.getMmolPerLiter());
		activityState.updateBloodSugarLevel(result);
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

