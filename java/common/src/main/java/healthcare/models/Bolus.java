package healthcare.models;

// Start of user code for imports
import java.util.*;
import pusztai.thomas.architecture.fog.validation.*;



// End of user code

/**
 * Describes a Bolus model type.
 * 
 * @generated
 */
public class Bolus {

	private Integer insulinUnits;
	
	private Integer durationMinutes;
	
	
	/**
	 * @return the insulinUnits
	 * 
	 * @generated
	 */
	public Integer getInsulinUnits() {
		return insulinUnits;
	}
	
	/**
	 * @param insulinUnits the insulinUnits to set.
	 * 
	 * @generated
	 */
	public void setInsulinUnits(Integer insulinUnits) {
		this.insulinUnits = insulinUnits;
	}
	
	/**
	 * @return the durationMinutes
	 * 
	 * @generated
	 */
	public Integer getDurationMinutes() {
		return durationMinutes;
	}
	
	/**
	 * @param durationMinutes the durationMinutes to set.
	 * 
	 * @generated
	 */
	public void setDurationMinutes(Integer durationMinutes) {
		this.durationMinutes = durationMinutes;
	}
	
	
	
}
