
#include <fogPlatform.h>
#include <BodyTemperature.h>
#include <BodyTemperature_private.h>
#include <jansson.h>

BodyTemperature newBodyTemperature() {
	return calloc(1, sizeof(struct BodyTemperature));
}

void deleteBodyTemperature(BodyTemperature target) {
	free(target);
}

BodyTemperature BodyTemperature_deserializeFromJson(json_t *json) {
	if (json_equal(json, json_null())) {
		return NULL;
	}
	BodyTemperature target = newBodyTemperature();
	target->degCelsius = json_real_value(json_object_get(json, "degCelsius"));
	
	return target;
}

json_t *BodyTemperature_serializeToJson(BodyTemperature target) {
	if (!target) {
		return json_null();
	}
	json_t *json = json_object();
	json_object_set_new(json, "degCelsius", json_real(target->degCelsius));
	return json;
}

real_t BodyTemperature_getDegCelsius(BodyTemperature target) {
	return target->degCelsius;
}

bool BodyTemperature_setDegCelsius(BodyTemperature target, real_t degCelsius) {
target->degCelsius = degCelsius;	bool validationResult = true;
	
	return validationResult;
}





