
#include <fogPlatform.h>

#include <HeartRateSensor.h>

struct HeartRateSensor {
	
};

HeartRateSensor newHeartRateSensor() {
	return calloc(1, sizeof(struct HeartRateSensor));
}

void deleteHeartRateSensor(HeartRateSensor target) {
	free(target);
}


bool HeartRateSensor_getBatteryLevel(HeartRateSensor target, int_t *result) {
	// ToDo: Set the value(s) of *result (if data type is a struct, copy all values) and then return true on success or false on failure.
	return true;
}

bool HeartRateSensor_getHeartRate(HeartRateSensor target, int_t *result) {
	// ToDo: Set the value(s) of *result (if data type is a struct, copy all values) and then return true on success or false on failure.
	return true;
}


