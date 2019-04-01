package healthcare.monitoring.handlers.operationcalls;

import healthcare.monitoring.state.Measurement;
import io.micronaut.context.annotation.Prototype;
import io.micronaut.http.client.exceptions.HttpClientException;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pusztai.thomas.architecture.fog.activity.realization.CallOperationActionHandler;
import healthcare.monitoring.state.ActivityState;

import healthcare.monitoring.handlers.operationcalls.params.StoreHeartRate_callParams;

/**
 * This is the CallOperationAction handler for storeHeartRate_call.
 * 
 * @generated
 */
@Prototype
public class StoreHeartRate_call implements CallOperationActionHandler<StoreHeartRate_callParams, Void> {

	private static final Logger LOG = LoggerFactory.getLogger(StoreHeartRate_call.class);

	@Inject
	private ActivityState activityState;

	/**
	 * @generated
	 * @return The parameter(s) that should be passed to the upcoming call of the operation.
	 */
	@Override
	public StoreHeartRate_callParams assembleParameters() {
		Measurement<Integer> heartRateM = activityState.getLastHeartRate();
		StoreHeartRate_callParams params = new StoreHeartRate_callParams();
		if (heartRateM != null && heartRateM.getMeasurement() != null) {
			params.setBpm(heartRateM.getMeasurement());
			params.setTimestamp((int) heartRateM.getMeasuredAt().getEpochSecond());
		}
		return params;
	}

	/**
	 * Handles the return value of the operation.
	 * @generated
	 * @param result The return value of the last operation call.
	 */
	@Override
	public void handleResult(Void result) {
		LOG.info("storeHeartRate() successful");
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

