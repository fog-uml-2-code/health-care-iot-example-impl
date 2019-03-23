
#include <fogPlatform.h>
#include <BloodSugarLevel.h>
#include <BloodSugarLevel_private.h>
#include <jansson.h>

BloodSugarLevel newBloodSugarLevel() {
	return calloc(1, sizeof(struct BloodSugarLevel));
}

void deleteBloodSugarLevel(BloodSugarLevel target) {
	free(target);
}

BloodSugarLevel BloodSugarLevel_deserializeFromJson(json_t *json) {
	if (json_equal(json, json_null())) {
		return NULL;
	}
	BloodSugarLevel target = newBloodSugarLevel();
	target->mmolPerLiter = json_integer_value(json_object_get(json, "mmolPerLiter"));
	
	return target;
}

json_t *BloodSugarLevel_serializeToJson(BloodSugarLevel target) {
	if (!target) {
		return json_null();
	}
	json_t *json = json_object();
	json_object_set_new(json, "mmolPerLiter", json_integer(target->mmolPerLiter));
	return json;
}

int_t BloodSugarLevel_getMmolPerLiter(BloodSugarLevel target) {
	return target->mmolPerLiter;
}

bool BloodSugarLevel_setMmolPerLiter(BloodSugarLevel target, int_t mmolPerLiter) {
target->mmolPerLiter = mmolPerLiter;	bool validationResult = true;
	
	return validationResult;
}





