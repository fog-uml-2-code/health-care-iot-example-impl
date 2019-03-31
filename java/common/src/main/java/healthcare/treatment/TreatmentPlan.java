package healthcare.treatment;

// Start of user code for imports
import java.util.*;
import pusztai.thomas.architecture.fog.validation.*;
import healthcare.treatment.constraints.*;

import healthcare.models.BasalRate;
import healthcare.models.Bolus;

// End of user code

/**
 * Describes a TreatmentPlan model type.
 * 
 * @generated
 */
 @Invariant(MaxHourlyBasalRate.class)
 @Invariant(MaxBolus.class)
 @Invariant(BasalRateLimits.class)
public class TreatmentPlan {

	private Integer maxInsulinUnitsPerDay;
	
	private Integer minHourlyBasalRate;
	
	private Integer maxUnitsPerBolus;
	
	private Integer maxInsulinUnitsPerHour;
	
	private BasalRate basalRate;
	
	private Integer maxHourlyBasalRate;
	
	private Bolus bolus;
	
	
	/**
	 * @return the maxInsulinUnitsPerDay
	 * 
	 * @generated
	 */
	public Integer getMaxInsulinUnitsPerDay() {
		return maxInsulinUnitsPerDay;
	}
	
	/**
	 * @param maxInsulinUnitsPerDay the maxInsulinUnitsPerDay to set.
	 * 
	 * @generated
	 */
	public void setMaxInsulinUnitsPerDay(Integer maxInsulinUnitsPerDay) {
		this.maxInsulinUnitsPerDay = maxInsulinUnitsPerDay;
	}
	
	/**
	 * @return the minHourlyBasalRate
	 * 
	 * @generated
	 */
	public Integer getMinHourlyBasalRate() {
		return minHourlyBasalRate;
	}
	
	/**
	 * @param minHourlyBasalRate the minHourlyBasalRate to set.
	 * 
	 * @generated
	 */
	public void setMinHourlyBasalRate(Integer minHourlyBasalRate) {
		this.minHourlyBasalRate = minHourlyBasalRate;
	}
	
	/**
	 * @return the maxUnitsPerBolus
	 * 
	 * @generated
	 */
	public Integer getMaxUnitsPerBolus() {
		return maxUnitsPerBolus;
	}
	
	/**
	 * @param maxUnitsPerBolus the maxUnitsPerBolus to set.
	 * 
	 * @generated
	 */
	public void setMaxUnitsPerBolus(Integer maxUnitsPerBolus) {
		this.maxUnitsPerBolus = maxUnitsPerBolus;
	}
	
	/**
	 * @return the maxInsulinUnitsPerHour
	 * 
	 * @generated
	 */
	public Integer getMaxInsulinUnitsPerHour() {
		return maxInsulinUnitsPerHour;
	}
	
	/**
	 * @param maxInsulinUnitsPerHour the maxInsulinUnitsPerHour to set.
	 * 
	 * @generated
	 */
	public void setMaxInsulinUnitsPerHour(Integer maxInsulinUnitsPerHour) {
		this.maxInsulinUnitsPerHour = maxInsulinUnitsPerHour;
	}
	
	/**
	 * @return the basalRate
	 * 
	 * @generated
	 */
	public BasalRate getBasalRate() {
		return basalRate;
	}
	
	/**
	 * @param basalRate the basalRate to set.
	 * 
	 * @generated
	 */
	public void setBasalRate(BasalRate basalRate) {
		this.basalRate = basalRate;
	}
	
	/**
	 * @return the maxHourlyBasalRate
	 * 
	 * @generated
	 */
	public Integer getMaxHourlyBasalRate() {
		return maxHourlyBasalRate;
	}
	
	/**
	 * @param maxHourlyBasalRate the maxHourlyBasalRate to set.
	 * 
	 * @generated
	 */
	public void setMaxHourlyBasalRate(Integer maxHourlyBasalRate) {
		this.maxHourlyBasalRate = maxHourlyBasalRate;
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
