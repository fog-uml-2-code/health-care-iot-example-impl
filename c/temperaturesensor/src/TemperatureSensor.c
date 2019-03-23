
#include <fogPlatform.h>
#include <BodyTemperature.h>


#include <TemperatureSensor.h>

struct TemperatureSensor {
	
};

TemperatureSensor newTemperatureSensor() {
	return calloc(1, sizeof(struct TemperatureSensor));
}

void deleteTemperatureSensor(TemperatureSensor target) {
	free(target);
}


bool TemperatureSensor_getBatteryLevel(TemperatureSensor target, int_t *result) {
	// ToDo: Set the value(s) of *result (if data type is a struct, copy all values) and then return true on success or false on failure.
	return true;
}

bool TemperatureSensor_measureTemperature(TemperatureSensor target, BodyTemperature result) {
	// ToDo: Set the value(s) of *result (if data type is a struct, copy all values) and then return true on success or false on failure.
	return true;
}


