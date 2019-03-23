
#include <fogPlatform.h>
#include <Bolus.h>
#include <Bolus_private.h>
#include <jansson.h>

Bolus newBolus() {
	return calloc(1, sizeof(struct Bolus));
}

void deleteBolus(Bolus target) {
	free(target);
}

Bolus Bolus_deserializeFromJson(json_t *json) {
	if (json_equal(json, json_null())) {
		return NULL;
	}
	Bolus target = newBolus();
	target->insulinUnits = json_integer_value(json_object_get(json, "insulinUnits"));
	
	target->durationMinutes = json_integer_value(json_object_get(json, "durationMinutes"));
	
	return target;
}

json_t *Bolus_serializeToJson(Bolus target) {
	if (!target) {
		return json_null();
	}
	json_t *json = json_object();
	json_object_set_new(json, "insulinUnits", json_integer(target->insulinUnits));
	json_object_set_new(json, "durationMinutes", json_integer(target->durationMinutes));
	return json;
}

int_t Bolus_getInsulinUnits(Bolus target) {
	return target->insulinUnits;
}

bool Bolus_setInsulinUnits(Bolus target, int_t insulinUnits) {
target->insulinUnits = insulinUnits;	bool validationResult = true;
	
	return validationResult;
}

int_t Bolus_getDurationMinutes(Bolus target) {
	return target->durationMinutes;
}

bool Bolus_setDurationMinutes(Bolus target, int_t durationMinutes) {
target->durationMinutes = durationMinutes;	bool validationResult = true;
	
	return validationResult;
}





