#ifndef BLOODPRESSURESENSORHANDLER_H
#define BLOODPRESSURESENSORHANDLER_H

#include <fogPlatform.h>
#include <BloodPressure.h>


#include <BloodPressureSensor.h>
#include <HttpServer.h>
#include "BloodPressureSensorHandler.h"

bool BloodPressureSensor_setUpHandler(HttpServer server);

void BloodPressureSensor_shutdownHandler();

int BloodPressureSensor_getBatteryLevelHandler(const HttpRequest request, HttpResponse response, void *userData);

int BloodPressureSensor_measureBloodPressureHandler(const HttpRequest request, HttpResponse response, void *userData);

#endif /* BLOODPRESSURESENSORHANDLER_H */

