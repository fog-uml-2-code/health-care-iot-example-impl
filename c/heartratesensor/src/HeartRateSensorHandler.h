#ifndef HEARTRATESENSORHANDLER_H
#define HEARTRATESENSORHANDLER_H

#include <fogPlatform.h>

#include <HeartRateSensor.h>
#include <HttpServer.h>
#include "HeartRateSensorHandler.h"

bool HeartRateSensor_setUpHandler(HttpServer server);

void HeartRateSensor_shutdownHandler();

int HeartRateSensor_getBatteryLevelHandler(const HttpRequest request, HttpResponse response, void *userData);

int HeartRateSensor_getHeartRateHandler(const HttpRequest request, HttpResponse response, void *userData);

#endif /* HEARTRATESENSORHANDLER_H */

