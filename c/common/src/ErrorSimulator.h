#ifndef ERROR_SIMULATOR_H
#define ERROR_SIMULATOR_H

#include <fogPlatform.h>

typedef struct ErrorSimulator *ErrorSimulator;

/**
 * Creates a new ErrorSimulator.
 *		errorProbability: The probability of an operation being an error in percent,
 *			the possible values range from 0 (every operation is successful) to 100 (every operation is an error).
 */
ErrorSimulator newErrorSimulator(int_t errorProbability);

void deleteErrorSimulator(ErrorSimulator target);

/** Returns true if the next operation should be a success, false if it should be an error. */
bool ErrorSimulator_isNextOperationSuccessful(ErrorSimulator target);

#endif // !ERROR_SIMULATOR_H
