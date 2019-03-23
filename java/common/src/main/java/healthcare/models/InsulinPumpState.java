package healthcare.models;

// Start of user code for imports
import java.util.*;
import pusztai.thomas.architecture.fog.validation.*;
import healthcare.models.constraints.*;

import healthcare.treatment.TreatmentPlan;

// End of user code

/**
 * Describes a InsulinPumpState model type.
 * 
 * @generated
 */
 @Invariant(MaxInsulinDosage.class)
public class InsulinPumpState {

	private int insulinUnitsAdministeredLast24Hours;
	
	private int timeLastBolusEnded;
	
	private int currentTime;
	
	private TreatmentPlan treatmentPlan;
	
	private int insulinUnitsAdministeredLastHour;
	
	private Bolus bolus;
	
	
	/**
	 * @return the insulinUnitsAdministeredLast24Hours
	 * 
	 * @generated
	 */
	public int getInsulinUnitsAdministeredLast24Hours() {
		return insulinUnitsAdministeredLast24Hours;
	}
	
	/**
	 * @param insulinUnitsAdministeredLast24Hours the insulinUnitsAdministeredLast24Hours to set.
	 * 
	 * @generated
	 */
	public void setInsulinUnitsAdministeredLast24Hours(int insulinUnitsAdministeredLast24Hours) {
		this.insulinUnitsAdministeredLast24Hours = insulinUnitsAdministeredLast24Hours;
	}
	
	/**
	 * @return the timeLastBolusEnded
	 * 
	 * @generated
	 */
	public int getTimeLastBolusEnded() {
		return timeLastBolusEnded;
	}
	
	/**
	 * @param timeLastBolusEnded the timeLastBolusEnded to set.
	 * 
	 * @generated
	 */
	public void setTimeLastBolusEnded(int timeLastBolusEnded) {
		this.timeLastBolusEnded = timeLastBolusEnded;
	}
	
	/**
	 * @return the currentTime
	 * 
	 * @generated
	 */
	public int getCurrentTime() {
		return currentTime;
	}
	
	/**
	 * @param currentTime the currentTime to set.
	 * 
	 * @generated
	 */
	public void setCurrentTime(int currentTime) {
		this.currentTime = currentTime;
	}
	
	/**
	 * @return the treatmentPlan
	 * 
	 * @generated
	 */
	public TreatmentPlan getTreatmentPlan() {
		return treatmentPlan;
	}
	
	/**
	 * @param treatmentPlan the treatmentPlan to set.
	 * 
	 * @generated
	 */
	public void setTreatmentPlan(TreatmentPlan treatmentPlan) {
		this.treatmentPlan = treatmentPlan;
	}
	
	/**
	 * @return the insulinUnitsAdministeredLastHour
	 * 
	 * @generated
	 */
	public int getInsulinUnitsAdministeredLastHour() {
		return insulinUnitsAdministeredLastHour;
	}
	
	/**
	 * @param insulinUnitsAdministeredLastHour the insulinUnitsAdministeredLastHour to set.
	 * 
	 * @generated
	 */
	public void setInsulinUnitsAdministeredLastHour(int insulinUnitsAdministeredLastHour) {
		this.insulinUnitsAdministeredLastHour = insulinUnitsAdministeredLastHour;
	}
	
	/**
	 * @return the bolus
	 * 
	 * @generated
	 */
	public Bolus getBolus() {
		return bolus;
	}
	
	/**
	 * @param bolus the bolus to set.
	 * 
	 * @generated
	 */
	public void setBolus(Bolus bolus) {
		this.bolus = bolus;
	}
	
	
	
}
