
#include <fogPlatform.h>
#include <BasalRate.h>
#include <BasalRate_private.h>
#include <Bolus.h>
#include <Bolus_private.h>
#include <TreatmentPlan.h>
#include <TreatmentPlan_private.h>
#include <jansson.h>

TreatmentPlan newTreatmentPlan() {
	return calloc(1, sizeof(struct TreatmentPlan));
}

void deleteTreatmentPlan(TreatmentPlan target) {
	free(target);
}

TreatmentPlan TreatmentPlan_deserializeFromJson(json_t *json) {
	if (json_equal(json, json_null())) {
		return NULL;
	}
	TreatmentPlan target = newTreatmentPlan();
	target->maxInsulinUnitsPerDay = json_integer_value(json_object_get(json, "maxInsulinUnitsPerDay"));
	
	target->maxHourlyBasalRate = json_integer_value(json_object_get(json, "maxHourlyBasalRate"));
	
	Bolus temp_bolus = Bolus_deserializeFromJson(json_object_get(json, "bolus"));
	if (temp_bolus) {
		target->bolus = *temp_bolus;
		target->bolus_isSet = true;
		free(temp_bolus);
	}
	
	BasalRate temp_basalRate = BasalRate_deserializeFromJson(json_object_get(json, "basalRate"));
	if (temp_basalRate) {
		target->basalRate = *temp_basalRate;
		target->basalRate_isSet = true;
		free(temp_basalRate);
	}
	
	target->minHourlyBasalRate = json_integer_value(json_object_get(json, "minHourlyBasalRate"));
	
	target->maxInsulinUnitsPerHour = json_integer_value(json_object_get(json, "maxInsulinUnitsPerHour"));
	
	target->maxUnitsPerBolus = json_integer_value(json_object_get(json, "maxUnitsPerBolus"));
	
	return target;
}

json_t *TreatmentPlan_serializeToJson(TreatmentPlan target) {
	if (!target) {
		return json_null();
	}
	json_t *json = json_object();
	json_object_set_new(json, "maxInsulinUnitsPerDay", json_integer(target->maxInsulinUnitsPerDay));
	json_object_set_new(json, "maxHourlyBasalRate", json_integer(target->maxHourlyBasalRate));
	json_object_set_new(json, "bolus", Bolus_serializeToJson(TreatmentPlan_getBolus(target)));
	json_object_set_new(json, "basalRate", BasalRate_serializeToJson(TreatmentPlan_getBasalRate(target)));
	json_object_set_new(json, "minHourlyBasalRate", json_integer(target->minHourlyBasalRate));
	json_object_set_new(json, "maxInsulinUnitsPerHour", json_integer(target->maxInsulinUnitsPerHour));
	json_object_set_new(json, "maxUnitsPerBolus", json_integer(target->maxUnitsPerBolus));
	return json;
}

int_t TreatmentPlan_getMaxInsulinUnitsPerDay(TreatmentPlan target) {
	return target->maxInsulinUnitsPerDay;
}

bool TreatmentPlan_setMaxInsulinUnitsPerDay(TreatmentPlan target, int_t maxInsulinUnitsPerDay) {
target->maxInsulinUnitsPerDay = maxInsulinUnitsPerDay;	bool validationResult = true;
	
	validationResult &= (*target).bolus.insulinUnits <=  (*target).maxUnitsPerBolus;
	validationResult &= (*target).basalRate.insulinUnitsPerHour >=  (*target).minHourlyBasalRate &&
	     (*target).basalRate.insulinUnitsPerHour <=  (*target).maxHourlyBasalRate;
	validationResult &= (*target).maxHourlyBasalRate <=  (*target).maxInsulinUnitsPerHour &&
	     (*target).maxHourlyBasalRate * 24 <  (*target).maxInsulinUnitsPerDay;
	return validationResult;
}

int_t TreatmentPlan_getMaxHourlyBasalRate(TreatmentPlan target) {
	return target->maxHourlyBasalRate;
}

bool TreatmentPlan_setMaxHourlyBasalRate(TreatmentPlan target, int_t maxHourlyBasalRate) {
target->maxHourlyBasalRate = maxHourlyBasalRate;	bool validationResult = true;
	
	validationResult &= (*target).bolus.insulinUnits <=  (*target).maxUnitsPerBolus;
	validationResult &= (*target).basalRate.insulinUnitsPerHour >=  (*target).minHourlyBasalRate &&
	     (*target).basalRate.insulinUnitsPerHour <=  (*target).maxHourlyBasalRate;
	validationResult &= (*target).maxHourlyBasalRate <=  (*target).maxInsulinUnitsPerHour &&
	     (*target).maxHourlyBasalRate * 24 <  (*target).maxInsulinUnitsPerDay;
	return validationResult;
}

Bolus TreatmentPlan_getBolus(TreatmentPlan target) {
	return target->bolus_isSet ? &target->bolus : NULL;
}

bool TreatmentPlan_setBolus(TreatmentPlan target, Bolus bolus) {
if (bolus) {
		target->bolus = *bolus;
		target->bolus_isSet = true;
	} else {
		target->bolus_isSet = false;
	}
	bool validationResult = true;
	
	validationResult &= (*target).bolus.insulinUnits <=  (*target).maxUnitsPerBolus;
	validationResult &= (*target).basalRate.insulinUnitsPerHour >=  (*target).minHourlyBasalRate &&
	     (*target).basalRate.insulinUnitsPerHour <=  (*target).maxHourlyBasalRate;
	validationResult &= (*target).maxHourlyBasalRate <=  (*target).maxInsulinUnitsPerHour &&
	     (*target).maxHourlyBasalRate * 24 <  (*target).maxInsulinUnitsPerDay;
	return validationResult;
}

BasalRate TreatmentPlan_getBasalRate(TreatmentPlan target) {
	return target->basalRate_isSet ? &target->basalRate : NULL;
}

bool TreatmentPlan_setBasalRate(TreatmentPlan target, BasalRate basalRate) {
if (basalRate) {
		target->basalRate = *basalRate;
		target->basalRate_isSet = true;
	} else {
		target->basalRate_isSet = false;
	}
	bool validationResult = true;
	
	validationResult &= (*target).bolus.insulinUnits <=  (*target).maxUnitsPerBolus;
	validationResult &= (*target).basalRate.insulinUnitsPerHour >=  (*target).minHourlyBasalRate &&
	     (*target).basalRate.insulinUnitsPerHour <=  (*target).maxHourlyBasalRate;
	validationResult &= (*target).maxHourlyBasalRate <=  (*target).maxInsulinUnitsPerHour &&
	     (*target).maxHourlyBasalRate * 24 <  (*target).maxInsulinUnitsPerDay;
	return validationResult;
}

int_t TreatmentPlan_getMinHourlyBasalRate(TreatmentPlan target) {
	return target->minHourlyBasalRate;
}

bool TreatmentPlan_setMinHourlyBasalRate(TreatmentPlan target, int_t minHourlyBasalRate) {
target->minHourlyBasalRate = minHourlyBasalRate;	bool validationResult = true;
	
	validationResult &= (*target).bolus.insulinUnits <=  (*target).maxUnitsPerBolus;
	validationResult &= (*target).basalRate.insulinUnitsPerHour >=  (*target).minHourlyBasalRate &&
	     (*target).basalRate.insulinUnitsPerHour <=  (*target).maxHourlyBasalRate;
	validationResult &= (*target).maxHourlyBasalRate <=  (*target).maxInsulinUnitsPerHour &&
	     (*target).maxHourlyBasalRate * 24 <  (*target).maxInsulinUnitsPerDay;
	return validationResult;
}

int_t TreatmentPlan_getMaxInsulinUnitsPerHour(TreatmentPlan target) {
	return target->maxInsulinUnitsPerHour;
}

bool TreatmentPlan_setMaxInsulinUnitsPerHour(TreatmentPlan target, int_t maxInsulinUnitsPerHour) {
target->maxInsulinUnitsPerHour = maxInsulinUnitsPerHour;	bool validationResult = true;
	
	validationResult &= (*target).bolus.insulinUnits <=  (*target).maxUnitsPerBolus;
	validationResult &= (*target).basalRate.insulinUnitsPerHour >=  (*target).minHourlyBasalRate &&
	     (*target).basalRate.insulinUnitsPerHour <=  (*target).maxHourlyBasalRate;
	validationResult &= (*target).maxHourlyBasalRate <=  (*target).maxInsulinUnitsPerHour &&
	     (*target).maxHourlyBasalRate * 24 <  (*target).maxInsulinUnitsPerDay;
	return validationResult;
}

int_t TreatmentPlan_getMaxUnitsPerBolus(TreatmentPlan target) {
	return target->maxUnitsPerBolus;
}

bool TreatmentPlan_setMaxUnitsPerBolus(TreatmentPlan target, int_t maxUnitsPerBolus) {
target->maxUnitsPerBolus = maxUnitsPerBolus;	bool validationResult = true;
	
	validationResult &= (*target).bolus.insulinUnits <=  (*target).maxUnitsPerBolus;
	validationResult &= (*target).basalRate.insulinUnitsPerHour >=  (*target).minHourlyBasalRate &&
	     (*target).basalRate.insulinUnitsPerHour <=  (*target).maxHourlyBasalRate;
	validationResult &= (*target).maxHourlyBasalRate <=  (*target).maxInsulinUnitsPerHour &&
	     (*target).maxHourlyBasalRate * 24 <  (*target).maxInsulinUnitsPerDay;
	return validationResult;
}





