#ifndef FOGPLATFORM_H
#define FOGPLATFORM_H

#include <inttypes.h>
#include <math.h>
#include <stdbool.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

/** Defines the port on which the REST server (if any) should listen. */
#define LISTEN_PORT 8083

/**
 * These integer types have at least the specified number of bits.
 */

typedef int_least8_t int8;
typedef int_least16_t int16;
typedef int_least32_t int32;
typedef int_least64_t int64;

/**
 * The include files and C99 also define the following types:
 * - bool
 * - wchar_t
 * - float_t
 * - double_t
 */

/**
 * The following types are the most commonly used ones and are defined according 
 * to the resources of the platform, e.g., on most platforms int_t will be defined as int32,
 * but on certain microcontrollers int_t will be defined as int16 or maybe even int8.
 */

typedef int32 int_t;

typedef char char_t;
typedef char_t* string_t;

typedef double_t real_t;

/**
 * Define lowercase null, because it is used by the OCL expressions.
 */
#define null NULL

#endif /* FOGPLATFORM_H */

