#ifndef TEMPERATURESENSORHANDLER_H
#define TEMPERATURESENSORHANDLER_H

#include <fogPlatform.h>
#include <BodyTemperature.h>


#include <TemperatureSensor.h>
#include <HttpServer.h>
#include "TemperatureSensorHandler.h"

bool TemperatureSensor_setUpHandler(HttpServer server);

void TemperatureSensor_shutdownHandler();

int TemperatureSensor_getBatteryLevelHandler(const HttpRequest request, HttpResponse response, void *userData);

int TemperatureSensor_measureTemperatureHandler(const HttpRequest request, HttpResponse response, void *userData);

#endif /* TEMPERATURESENSORHANDLER_H */

