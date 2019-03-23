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
 @Invariant(MaxBolus.class)
 @Invariant(BasalRateLimits.class)
 @Invariant(MaxHourlyBasalRate.class)
public class TreatmentPlan {

	private int maxInsulinUnitsPerDay;
	
	private int maxHourlyBasalRate;
	
	private Bolus bolus;
	
	private BasalRate basalRate;
	
	private int minHourlyBasalRate;
	
	private int maxInsulinUnitsPerHour;
	
	private int maxUnitsPerBolus;
	
	
	/**
	 * @return the maxInsulinUnitsPerDay
	 * 
	 * @generated
	 */
	public int getMaxInsulinUnitsPerDay() {
		return maxInsulinUnitsPerDay;
	}
	
	/**
	 * @param maxInsulinUnitsPerDay the maxInsulinUnitsPerDay to set.
	 * 
	 * @generated
	 */
	public void setMaxInsulinUnitsPerDay(int maxInsulinUnitsPerDay) {
		this.maxInsulinUnitsPerDay = maxInsulinUnitsPerDay;
	}
	
	/**
	 * @return the maxHourlyBasalRate
	 * 
	 * @generated
	 */
	public int getMaxHourlyBasalRate() {
		return maxHourlyBasalRate;
	}
	
	/**
	 * @param maxHourlyBasalRate the maxHourlyBasalRate to set.
	 * 
	 * @generated
	 */
	public void setMaxHourlyBasalRate(int maxHourlyBasalRate) {
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
	 * @return the minHourlyBasalRate
	 * 
	 * @generated
	 */
	public int getMinHourlyBasalRate() {
		return minHourlyBasalRate;
	}
	
	/**
	 * @param minHourlyBasalRate the minHourlyBasalRate to set.
	 * 
	 * @generated
	 */
	public void setMinHourlyBasalRate(int minHourlyBasalRate) {
		this.minHourlyBasalRate = minHourlyBasalRate;
	}
	
	/**
	 * @return the maxInsulinUnitsPerHour
	 * 
	 * @generated
	 */
	public int getMaxInsulinUnitsPerHour() {
		return maxInsulinUnitsPerHour;
	}
	
	/**
	 * @param maxInsulinUnitsPerHour the maxInsulinUnitsPerHour to set.
	 * 
	 * @generated
	 */
	public void setMaxInsulinUnitsPerHour(int maxInsulinUnitsPerHour) {
		this.maxInsulinUnitsPerHour = maxInsulinUnitsPerHour;
	}
	
	/**
	 * @return the maxUnitsPerBolus
	 * 
	 * @generated
	 */
	public int getMaxUnitsPerBolus() {
		return maxUnitsPerBolus;
	}
	
	/**
	 * @param maxUnitsPerBolus the maxUnitsPerBolus to set.
	 * 
	 * @generated
	 */
	public void setMaxUnitsPerBolus(int maxUnitsPerBolus) {
		this.maxUnitsPerBolus = maxUnitsPerBolus;
	}
	
	
	
}
