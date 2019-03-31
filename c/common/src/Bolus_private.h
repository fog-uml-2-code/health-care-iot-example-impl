#ifndef BOLUS_PRIVATE_H
#define BOLUS_PRIVATE_H

#include <fogPlatform.h>
#include <Bolus.h>
#include <Bolus_private.h>
#include <jansson.h>

struct Bolus {
	int_t insulinUnits;
	int_t durationMinutes;
	
};

#endif /* BOLUS_PRIVATE_H */

