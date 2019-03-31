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

	private Integer timeLastBolusEnded;
	
	private TreatmentPlan treatmentPlan;
	
	private Bolus bolus;
	
	private Integer insulinUnitsAdministeredLastHour;
	
	private Integer currentTime;
	
	private Integer insulinUnitsAdministeredLast24Hours;
	
	
	/**
	 * @return the timeLastBolusEnded
	 * 
	 * @generated
	 */
	public Integer getTimeLastBolusEnded() {
		return timeLastBolusEnded;
	}
	
	/**
	 * @param timeLastBolusEnded the timeLastBolusEnded to set.
	 * 
	 * @generated
	 */
	public void setTimeLastBolusEnded(Integer timeLastBolusEnded) {
		this.timeLastBolusEnded = timeLastBolusEnded;
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
	
	/**
	 * @return the insulinUnitsAdministeredLastHour
	 * 
	 * @generated
	 */
	public Integer getInsulinUnitsAdministeredLastHour() {
		return insulinUnitsAdministeredLastHour;
	}
	
	/**
	 * @param insulinUnitsAdministeredLastHour the insulinUnitsAdministeredLastHour to set.
	 * 
	 * @generated
	 */
	public void setInsulinUnitsAdministeredLastHour(Integer insulinUnitsAdministeredLastHour) {
		this.insulinUnitsAdministeredLastHour = insulinUnitsAdministeredLastHour;
	}
	
	/**
	 * @return the currentTime
	 * 
	 * @generated
	 */
	public Integer getCurrentTime() {
		return currentTime;
	}
	
	/**
	 * @param currentTime the currentTime to set.
	 * 
	 * @generated
	 */
	public void setCurrentTime(Integer currentTime) {
		this.currentTime = currentTime;
	}
	
	/**
	 * @return the insulinUnitsAdministeredLast24Hours
	 * 
	 * @generated
	 */
	public Integer getInsulinUnitsAdministeredLast24Hours() {
		return insulinUnitsAdministeredLast24Hours;
	}
	
	/**
	 * @param insulinUnitsAdministeredLast24Hours the insulinUnitsAdministeredLast24Hours to set.
	 * 
	 * @generated
	 */
	public void setInsulinUnitsAdministeredLast24Hours(Integer insulinUnitsAdministeredLast24Hours) {
		this.insulinUnitsAdministeredLast24Hours = insulinUnitsAdministeredLast24Hours;
	}
	
	
	
}
