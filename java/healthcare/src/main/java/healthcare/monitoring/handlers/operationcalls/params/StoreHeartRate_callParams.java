package healthcare.monitoring.handlers.operationcalls.params;

import pusztai.thomas.architecture.fog.activity.realization.ParameterSequenceBase;


/**
 * This is the class for the input parameters for storeHeartRate_call.
 * 
 * @generated
 */
public class StoreHeartRate_callParams extends ParameterSequenceBase {

	public StoreHeartRate_callParams() {
		super(2);
	}

	public Integer getTimestamp() {
		return (Integer) getParam(0);	
	}

	public void setTimestamp(Integer value) {
		setParam(0, value);
	}
	public Integer getBpm() {
		return (Integer) getParam(1);	
	}

	public void setBpm(Integer value) {
		setParam(1, value);
	}

}

