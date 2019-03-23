
#include <fogPlatform.h>
#include <BasalRate.h>
#include <BasalRate_private.h>
#include <jansson.h>

BasalRate newBasalRate() {
	return calloc(1, sizeof(struct BasalRate));
}

void deleteBasalRate(BasalRate target) {
	free(target);
}

BasalRate BasalRate_deserializeFromJson(json_t *json) {
	if (json_equal(json, json_null())) {
		return NULL;
	}
	BasalRate target = newBasalRate();
	target->insulinUnitsPerHour = json_integer_value(json_object_get(json, "insulinUnitsPerHour"));
	
	return target;
}

json_t *BasalRate_serializeToJson(BasalRate target) {
	if (!target) {
		return json_null();
	}
	json_t *json = json_object();
	json_object_set_new(json, "insulinUnitsPerHour", json_integer(target->insulinUnitsPerHour));
	return json;
}

int_t BasalRate_getInsulinUnitsPerHour(BasalRate target) {
	return target->insulinUnitsPerHour;
}

bool BasalRate_setInsulinUnitsPerHour(BasalRate target, int_t insulinUnitsPerHour) {
target->insulinUnitsPerHour = insulinUnitsPerHour;	bool validationResult = true;
	
	return validationResult;
}





