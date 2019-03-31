package healthcare.monitoring.state;

import java.time.Instant;

/**
 * Represents a measurement at a certain point in time.
 * @param <T> the type of measurement
 */
public class Measurement<T> {

	private final T measurement;
	private final Instant measuredAt;

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
