#ifndef INSULINPUMPSTATE_PRIVATE_H
#define INSULINPUMPSTATE_PRIVATE_H

#include <fogPlatform.h>
#include <TreatmentPlan.h>
#include <TreatmentPlan_private.h>
#include <InsulinPumpState.h>
#include <InsulinPumpState_private.h>
#include <jansson.h>

struct InsulinPumpState {
	int_t insulinUnitsAdministeredLast24Hours;
	int_t timeLastBolusEnded;
	int_t currentTime;
	bool treatmentPlan_isSet;
	struct TreatmentPlan treatmentPlan;
	int_t insulinUnitsAdministeredLastHour;
	bool bolus_isSet;
	struct Bolus bolus;
	
};

#endif /* INSULINPUMPSTATE_PRIVATE_H */

