package healthcare.monitoring.handlers.operationcalls;

import io.micronaut.context.annotation.Prototype;
import io.micronaut.http.client.exceptions.HttpClientException;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pusztai.thomas.architecture.fog.activity.realization.CallOperationActionHandler;
import healthcare.monitoring.state.ActivityState;

import healthcare.models.Bolus;

/**
 * This is the CallOperationAction handler for startBolus_call.
 * 
 * @generated
 */
@Prototype
public class StartBolus_call implements CallOperationActionHandler<Bolus, Void> {

	private static final Logger LOG = LoggerFactory.getLogger(StartBolus_call.class);

	@Inject
	private ActivityState activityState;

	/**
	 * @generated
	 * @return The parameter(s) that should be passed to the upcoming call of the operation.
	 */
	@Override
	public Bolus assembleParameters() {
		Bolus bolus = new Bolus();
		bolus.setDurationMinutes(10);
		bolus.setInsulinUnits(10);
		return bolus;
	}

	/**
	 * Handles the return value of the operation.
	 * @generated
	 * @param result The return value of the last operation call.
	 */
	@Override
	public void handleResult(Void result) {
		LOG.info("startBolus() successful");
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

