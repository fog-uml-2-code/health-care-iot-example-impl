
#include <fogPlatform.h>
#include <BodyTemperature.h>


#include <TemperatureSensor.h>
#include <HttpServer.h>
#include "TemperatureSensorHandler.h"

TemperatureSensor restController;

bool TemperatureSensor_setUpHandler(HttpServer server) {
	restController = newTemperatureSensor();

	// Register all endpoints
	HttpServer_addEndpoint(server, GET, "/temperaturesensor/getbatterylevel", &TemperatureSensor_getBatteryLevelHandler, restController);
	HttpServer_addEndpoint(server, GET, "/temperaturesensor/measuretemperature", &TemperatureSensor_measureTemperatureHandler, restController);
	return true;
}

void TemperatureSensor_shutdownHandler() {
	deleteTemperatureSensor(restController);
	restController = NULL;
}

int TemperatureSensor_getBatteryLevelHandler(const HttpRequest request, HttpResponse response, void *userData) {
	TemperatureSensor target = (TemperatureSensor) userData;

	bool validationResult = true;
	
	if (!validationResult) {
		goto End;
	}
	int_t result;


	bool opSuccess = TemperatureSensor_getBatteryLevel(target, &result);
	if (!opSuccess) {
		validationResult = opSuccess;
	}

	
	if (validationResult) {
		json_t *jsonBody = json_integer(result);
		HttpResponse_setJsonBody(response, 200, jsonBody);
		json_decref(jsonBody);
	}

End:
	
	return validationResult ? U_CALLBACK_COMPLETE : U_CALLBACK_ERROR;
}

int TemperatureSensor_measureTemperatureHandler(const HttpRequest request, HttpResponse response, void *userData) {
	TemperatureSensor target = (TemperatureSensor) userData;

	bool validationResult = true;
	
	if (!validationResult) {
		goto End;
	}
	BodyTemperature result;
result = newBodyTemperature();

	bool opSuccess = TemperatureSensor_measureTemperature(target, result);
	if (!opSuccess) {
		validationResult = opSuccess;
	}

	
	if (validationResult) {
		json_t *jsonBody = BodyTemperature_serializeToJson(result);
		HttpResponse_setJsonBody(response, 200, jsonBody);
		json_decref(jsonBody);
	}
	deleteBodyTemperature(result);

End:
	
	return validationResult ? U_CALLBACK_COMPLETE : U_CALLBACK_ERROR;
}


