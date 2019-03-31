#ifndef TREATMENTPLAN_PRIVATE_H
#define TREATMENTPLAN_PRIVATE_H

#include <fogPlatform.h>
#include <BasalRate.h>
#include <BasalRate_private.h>
#include <Bolus.h>
#include <Bolus_private.h>
#include <TreatmentPlan.h>
#include <TreatmentPlan_private.h>
#include <jansson.h>

struct TreatmentPlan {
	int_t maxInsulinUnitsPerDay;
	int_t maxHourlyBasalRate;
	bool bolus_isSet;
	struct Bolus bolus;
	bool basalRate_isSet;
	struct BasalRate basalRate;
	int_t minHourlyBasalRate;
	int_t maxInsulinUnitsPerHour;
	int_t maxUnitsPerBolus;
	
};

#endif /* TREATMENTPLAN_PRIVATE_H */

