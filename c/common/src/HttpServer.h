#ifndef HTTPSERVER_H
#define HTTPSERVER_H

#include <fogPlatform.h>
#include <ulfius.h>
#include <jansson.h>

/** An HttpServer handle */
typedef struct HttpServer *HttpServer;

typedef struct _u_request *HttpRequest;
typedef struct _u_response *HttpResponse;

/** Handler function type for an HTTP request. */
typedef int(*HttpRequestHandler)(const HttpRequest request, HttpResponse response, void *userData);

#define GET "GET"
#define POST "POST"

/**
 * Creates a new HttpServer on the specified port.
 */
HttpServer newHttpServer(int_t port);

/**
 * Deletes the specified HttpServer.
 */
void deleteHttpServer(HttpServer server);

/**
 * Adds an endpoint to the specified HttpServer
 * server: The HttpServer on which to add the endpoint.
 * httpMethod: The HTTP method (GET, POST, etc.)
 * url: The URL on which to register the endpoint. Variables can be defined with ':'
 *      e.g., "/resource/:var"
 * handler: A pointer to an HttpRequestHandler function.
 * userData: An arbitrary pointer that will also be passed to the HttpRequestHandler function.
 */
bool HttpServer_addEndpoint(HttpServer server, const char *httpMethod, const char *url, HttpRequestHandler handler, void *userData);

/**
 * Starts the specified HttpServer.
 */
bool HttpServer_start(HttpServer server);

/**
 * Stops the specified HttpServer.
 */
void HttpServer_stop(HttpServer server);

/**
 * Gets whether the HttpServer is currently started.
 */
bool HttpServer_isStarted(HttpServer server);

/**
 * Gets the Ulfius instance of the specified HttpServer.
 */
struct _u_instance *HttpServer_getUlfiusInstance(HttpServer server);

/**
 * Gets the JSON body from the specified HttpRequest.
 */
json_t *HttpRequest_getJsonBody(HttpRequest request);

/**
 * Sets the JSON body and Content-Type header of the specified HttpResponse.
 */
bool HttpResponse_setJsonBody(HttpResponse response, const unsigned int statusCode, const json_t *body);

#endif /* HTTPSERVER_H */

