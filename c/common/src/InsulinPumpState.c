
#include <fogPlatform.h>
#include <TreatmentPlan.h>
#include <TreatmentPlan_private.h>
#include <InsulinPumpState.h>
#include <InsulinPumpState_private.h>
#include <jansson.h>

InsulinPumpState newInsulinPumpState() {
	return calloc(1, sizeof(struct InsulinPumpState));
}

void deleteInsulinPumpState(InsulinPumpState target) {
	free(target);
}

InsulinPumpState InsulinPumpState_deserializeFromJson(json_t *json) {
	if (json_equal(json, json_null())) {
		return NULL;
	}
	InsulinPumpState target = newInsulinPumpState();
	target->insulinUnitsAdministeredLast24Hours = json_integer_value(json_object_get(json, "insulinUnitsAdministeredLast24Hours"));
	
	target->timeLastBolusEnded = json_integer_value(json_object_get(json, "timeLastBolusEnded"));
	
	target->currentTime = json_integer_value(json_object_get(json, "currentTime"));
	
	TreatmentPlan temp_treatmentPlan = TreatmentPlan_deserializeFromJson(json_object_get(json, "treatmentPlan"));
	if (temp_treatmentPlan) {
		target->treatmentPlan = *temp_treatmentPlan;
		target->treatmentPlan_isSet = true;
		free(temp_treatmentPlan);
	}
	
	target->insulinUnitsAdministeredLastHour = json_integer_value(json_object_get(json, "insulinUnitsAdministeredLastHour"));
	
	Bolus temp_bolus = Bolus_deserializeFromJson(json_object_get(json, "bolus"));
	if (temp_bolus) {
		target->bolus = *temp_bolus;
		target->bolus_isSet = true;
		free(temp_bolus);
	}
	
	return target;
}

json_t *InsulinPumpState_serializeToJson(InsulinPumpState target) {
	if (!target) {
		return json_null();
	}
	json_t *json = json_object();
	json_object_set_new(json, "insulinUnitsAdministeredLast24Hours", json_integer(target->insulinUnitsAdministeredLast24Hours));
	json_object_set_new(json, "timeLastBolusEnded", json_integer(target->timeLastBolusEnded));
	json_object_set_new(json, "currentTime", json_integer(target->currentTime));
	json_object_set_new(json, "treatmentPlan", TreatmentPlan_serializeToJson(InsulinPumpState_getTreatmentPlan(target)));
	json_object_set_new(json, "insulinUnitsAdministeredLastHour", json_integer(target->insulinUnitsAdministeredLastHour));
	json_object_set_new(json, "bolus", Bolus_serializeToJson(InsulinPumpState_getBolus(target)));
	return json;
}

int_t InsulinPumpState_getInsulinUnitsAdministeredLast24Hours(InsulinPumpState target) {
	return target->insulinUnitsAdministeredLast24Hours;
}

bool InsulinPumpState_setInsulinUnitsAdministeredLast24Hours(InsulinPumpState target, int_t insulinUnitsAdministeredLast24Hours) {
target->insulinUnitsAdministeredLast24Hours = insulinUnitsAdministeredLast24Hours;	bool validationResult = true;
	
	validationResult &= (*target).insulinUnitsAdministeredLast24Hours <=  (*target).treatmentPlan.maxInsulinUnitsPerDay && 
	     (*target).insulinUnitsAdministeredLastHour <=  (*target).treatmentPlan.maxInsulinUnitsPerHour;
	return validationResult;
}

int_t InsulinPumpState_getTimeLastBolusEnded(InsulinPumpState target) {
	return target->timeLastBolusEnded;
}

bool InsulinPumpState_setTimeLastBolusEnded(InsulinPumpState target, int_t timeLastBolusEnded) {
target->timeLastBolusEnded = timeLastBolusEnded;	bool validationResult = true;
	
	validationResult &= (*target).insulinUnitsAdministeredLast24Hours <=  (*target).treatmentPlan.maxInsulinUnitsPerDay && 
	     (*target).insulinUnitsAdministeredLastHour <=  (*target).treatmentPlan.maxInsulinUnitsPerHour;
	return validationResult;
}

int_t InsulinPumpState_getCurrentTime(InsulinPumpState target) {
	return target->currentTime;
}

bool InsulinPumpState_setCurrentTime(InsulinPumpState target, int_t currentTime) {
target->currentTime = currentTime;	bool validationResult = true;
	
	validationResult &= (*target).insulinUnitsAdministeredLast24Hours <=  (*target).treatmentPlan.maxInsulinUnitsPerDay && 
	     (*target).insulinUnitsAdministeredLastHour <=  (*target).treatmentPlan.maxInsulinUnitsPerHour;
	return validationResult;
}

TreatmentPlan InsulinPumpState_getTreatmentPlan(InsulinPumpState target) {
	return target->treatmentPlan_isSet ? &target->treatmentPlan : NULL;
}

bool InsulinPumpState_setTreatmentPlan(InsulinPumpState target, TreatmentPlan treatmentPlan) {
if (treatmentPlan) {
		target->treatmentPlan = *treatmentPlan;
		target->treatmentPlan_isSet = true;
	} else {
		target->treatmentPlan_isSet = false;
	}
	bool validationResult = true;
	
	validationResult &= (*target).insulinUnitsAdministeredLast24Hours <=  (*target).treatmentPlan.maxInsulinUnitsPerDay && 
	     (*target).insulinUnitsAdministeredLastHour <=  (*target).treatmentPlan.maxInsulinUnitsPerHour;
	return validationResult;
}

int_t InsulinPumpState_getInsulinUnitsAdministeredLastHour(InsulinPumpState target) {
	return target->insulinUnitsAdministeredLastHour;
}

bool InsulinPumpState_setInsulinUnitsAdministeredLastHour(InsulinPumpState target, int_t insulinUnitsAdministeredLastHour) {
target->insulinUnitsAdministeredLastHour = insulinUnitsAdministeredLastHour;	bool validationResult = true;
	
	validationResult &= (*target).insulinUnitsAdministeredLast24Hours <=  (*target).treatmentPlan.maxInsulinUnitsPerDay && 
	     (*target).insulinUnitsAdministeredLastHour <=  (*target).treatmentPlan.maxInsulinUnitsPerHour;
	return validationResult;
}

Bolus InsulinPumpState_getBolus(InsulinPumpState target) {
	return target->bolus_isSet ? &target->bolus : NULL;
}

bool InsulinPumpState_setBolus(InsulinPumpState target, Bolus bolus) {
if (bolus) {
		target->bolus = *bolus;
		target->bolus_isSet = true;
	} else {
		target->bolus_isSet = false;
	}
	bool validationResult = true;
	
	validationResult &= (*target).insulinUnitsAdministeredLast24Hours <=  (*target).treatmentPlan.maxInsulinUnitsPerDay && 
	     (*target).insulinUnitsAdministeredLastHour <=  (*target).treatmentPlan.maxInsulinUnitsPerHour;
	return validationResult;
}





