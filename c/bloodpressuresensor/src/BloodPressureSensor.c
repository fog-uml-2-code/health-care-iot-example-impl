
#include <fogPlatform.h>
#include <BloodPressure.h>


#include <BloodPressureSensor.h>

struct BloodPressureSensor {
	
};

BloodPressureSensor newBloodPressureSensor() {
	return calloc(1, sizeof(struct BloodPressureSensor));
}

void deleteBloodPressureSensor(BloodPressureSensor target) {
	free(target);
}


bool BloodPressureSensor_getBatteryLevel(BloodPressureSensor target, int_t *result) {
	// ToDo: Set the value(s) of *result (if data type is a struct, copy all values) and then return true on success or false on failure.
	return true;
}

bool BloodPressureSensor_measureBloodPressure(BloodPressureSensor target, BloodPressure result) {
	// ToDo: Set the value(s) of *result (if data type is a struct, copy all values) and then return true on success or false on failure.
	return true;
}


