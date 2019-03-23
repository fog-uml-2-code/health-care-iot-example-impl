#include <HttpServer.h>

struct HttpServer {
	struct _u_instance ulfiusInstance;
	bool isStarted;
};

HttpServer newHttpServer(int_t port) {
	HttpServer server = calloc(1, sizeof(struct HttpServer));
	if (ulfius_init_instance(&server->ulfiusInstance, port, NULL, NULL) != U_OK) {
		free(server);
		return NULL;
	}
	return server;
}

void deleteHttpServer(HttpServer server) {
	if (server->isStarted) {
		HttpServer_stop(server);
	}
	ulfius_clean_instance(&server->ulfiusInstance);
	free(server);
}

bool HttpServer_addEndpoint(HttpServer server, const char *httpMethod, const char *url, HttpRequestHandler handler, void *userData) {
	return ulfius_add_endpoint_by_val(&server->ulfiusInstance, httpMethod, NULL, url, 0, handler, userData) == U_OK;
}

bool HttpServer_start(HttpServer server) {
	server->isStarted = ulfius_start_framework(&server->ulfiusInstance) == U_OK;
	return server->isStarted;
}

void HttpServer_stop(HttpServer server) {
	ulfius_stop_framework(&server->ulfiusInstance);
	server->isStarted = false;
}

bool HttpServer_isStarted(HttpServer server) {
	return server->isStarted;
}

struct _u_instance *HttpServer_getUlfiusInstance(HttpServer server) {
	return &server->ulfiusInstance;
}

json_t *HttpRequest_getJsonBody(HttpRequest request) {
	json_error_t jsonError;
	return ulfius_get_json_body_request(request, &jsonError);
}

bool HttpResponse_setJsonBody(HttpResponse response, const unsigned int statusCode, const json_t *body) {
	if (ulfius_add_header_to_response(response, "Content-Type", "application/json") != U_OK) {
		return false;
	}
	if (body == NULL) {
		return ulfius_set_empty_body_response(response, statusCode);
	}
	if (json_is_object(body) || json_is_array(body)) {
		return ulfius_set_json_body_response(response, statusCode, body) == U_OK;
	} else {
		// Ulfius only sets JSON responses if they are objects or arrays, even though single values are also valid JSON.
		// So we need to set those values as a binary body. binaryBody is freed by ulfius.
		char *binaryBody = json_dumps(body, JSON_COMPACT | JSON_ENCODE_ANY);
		if (binaryBody != NULL) {
			int length = strlen(binaryBody);
			return ulfius_set_binary_body_response(response, statusCode, binaryBody, length);
		} else {
			return false;
		}
	}
}

