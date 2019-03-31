package healthcare.monitoring.state;

import java.time.Instant;

/**
 * Represents a measurement at a certain point in time.
 * @param <T> the type of measurement
 */
public class Measurement<T> {

	private final static long MAX_MEASUREMENT_AGE_MSEC = 10 * 60 * 1000;

	private final T measurement;
	private final Instant measuredAt;

	public static <T> boolean isValid(Measurement<T> measurement) {
		if (measurement != null && measurement.getMeasurement() != null) {
			long now = Instant.now().toEpochMilli();
			return (now - measurement.getMeasuredAt().toEpochMilli()) < MAX_MEASUREMENT_AGE_MSEC;
		}
		return false;
	}

	public Measurement(T measurement) {
		this.measurement = measurement;
		this.measuredAt = Instant.now();
	}


	public T getMeasurement() {
		return measurement;
	}

	public Instant getMeasuredAt() {
		return measuredAt;
	}

}
