
#include <fogPlatform.h>

#include <HeartRateSensor.h>
#include <HttpServer.h>
#include "HeartRateSensorHandler.h"

HeartRateSensor restController;

bool HeartRateSensor_setUpHandler(HttpServer server) {
	restController = newHeartRateSensor();

	// Register all endpoints
	HttpServer_addEndpoint(server, GET, "/heartratesensor/getbatterylevel", &HeartRateSensor_getBatteryLevelHandler, restController);
	HttpServer_addEndpoint(server, GET, "/heartratesensor/getheartrate", &HeartRateSensor_getHeartRateHandler, restController);
	return true;
}

void HeartRateSensor_shutdownHandler() {
	deleteHeartRateSensor(restController);
	restController = NULL;
}

int HeartRateSensor_getBatteryLevelHandler(const HttpRequest request, HttpResponse response, void *userData) {
	HeartRateSensor target = (HeartRateSensor) userData;

	bool validationResult = true;
	
	if (!validationResult) {
		goto End;
	}
	int_t result;


	bool opSuccess = HeartRateSensor_getBatteryLevel(target, &result);
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

int HeartRateSensor_getHeartRateHandler(const HttpRequest request, HttpResponse response, void *userData) {
	HeartRateSensor target = (HeartRateSensor) userData;

	bool validationResult = true;
	
	if (!validationResult) {
		goto End;
	}
	int_t result;


	bool opSuccess = HeartRateSensor_getHeartRate(target, &result);
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


