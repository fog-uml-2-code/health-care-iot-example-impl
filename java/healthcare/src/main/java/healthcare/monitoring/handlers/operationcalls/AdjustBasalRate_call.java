package healthcare.monitoring.handlers.operationcalls;

import io.micronaut.context.annotation.Prototype;
import io.micronaut.http.client.exceptions.HttpClientException;
import javax.inject.Inject;
import pusztai.thomas.architecture.fog.activity.realization.CallOperationActionHandler;
import healthcare.monitoring.state.ActivityState;

import healthcare.models.BasalRate;

/**
 * This is the CallOperationAction handler for adjustBasalRate_call.
 * 
 * @generated
 */
@Prototype
public class AdjustBasalRate_call implements CallOperationActionHandler<BasalRate, Void> {

	@Inject
	private ActivityState activityState;

	/**
	 * @generated
	 * @return The parameter(s) that should be passed to the upcoming call of the operation.
	 */
	@Override
	public BasalRate assembleParameters() {
		// ToDo: Implement this method.
		throw new UnsupportedOperationException("This method is not yet implemented");
	}

	/**
	 * Handles the return value of the operation.
	 * @generated
	 * @param result The return value of the last operation call.
	 */
	@Override
	public void handleResult(Void result) {
		// ToDo: Implement this method.
		throw new UnsupportedOperationException("This method is not yet implemented");
	}

	/**
	 * Handles an error, if one occurred while making the REST request.
	 * @generated
	 * @param error The exception describing the error.
	 */
	public void handleError(HttpClientException error) {
		// ToDo: Implement this method.
		throw new UnsupportedOperationException("This method is not yet implemented");
	}

}

