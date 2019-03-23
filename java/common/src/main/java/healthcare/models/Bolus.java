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

	private int insulinUnits;
	
	private int durationMinutes;
	
	
	/**
	 * @return the insulinUnits
	 * 
	 * @generated
	 */
	public int getInsulinUnits() {
		return insulinUnits;
	}
	
	/**
	 * @param insulinUnits the insulinUnits to set.
	 * 
	 * @generated
	 */
	public void setInsulinUnits(int insulinUnits) {
		this.insulinUnits = insulinUnits;
	}
	
	/**
	 * @return the durationMinutes
	 * 
	 * @generated
	 */
	public int getDurationMinutes() {
		return durationMinutes;
	}
	
	/**
	 * @param durationMinutes the durationMinutes to set.
	 * 
	 * @generated
	 */
	public void setDurationMinutes(int durationMinutes) {
		this.durationMinutes = durationMinutes;
	}
	
	
	
}
