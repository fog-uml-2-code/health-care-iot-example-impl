
#include <fogPlatform.h>
#include <BloodPressure.h>
#include <BloodPressure_private.h>
#include <jansson.h>

BloodPressure newBloodPressure() {
	return calloc(1, sizeof(struct BloodPressure));
}

void deleteBloodPressure(BloodPressure target) {
	free(target);
}

BloodPressure BloodPressure_deserializeFromJson(json_t *json) {
	if (json_equal(json, json_null())) {
		return NULL;
	}
	BloodPressure target = newBloodPressure();
	target->mmHgSystolic = json_integer_value(json_object_get(json, "mmHgSystolic"));
	
	target->mmHgDiastolic = json_integer_value(json_object_get(json, "mmHgDiastolic"));
	
	return target;
}

json_t *BloodPressure_serializeToJson(BloodPressure target) {
	if (!target) {
		return json_null();
	}
	json_t *json = json_object();
	json_object_set_new(json, "mmHgSystolic", json_integer(target->mmHgSystolic));
	json_object_set_new(json, "mmHgDiastolic", json_integer(target->mmHgDiastolic));
	return json;
}

int_t BloodPressure_getMmHgSystolic(BloodPressure target) {
	return target->mmHgSystolic;
}

bool BloodPressure_setMmHgSystolic(BloodPressure target, int_t mmHgSystolic) {
target->mmHgSystolic = mmHgSystolic;	bool validationResult = true;
	
	return validationResult;
}

int_t BloodPressure_getMmHgDiastolic(BloodPressure target) {
	return target->mmHgDiastolic;
}

bool BloodPressure_setMmHgDiastolic(BloodPressure target, int_t mmHgDiastolic) {
target->mmHgDiastolic = mmHgDiastolic;	bool validationResult = true;
	
	return validationResult;
}





