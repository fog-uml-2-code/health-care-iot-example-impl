project(heartratesensor C)

include("../common/CMakeLists.txt" "src/platform-include")

set(SRCS
	"src/main.c"
	"src/HeartRateSensor.c"
	"src/HeartRateSensorHandler.c"
)

add_executable(heartratesensor ${SRCS} ${COMMON_LIB_SRCS})

target_include_directories(heartratesensor PUBLIC "../common/src" "src/platform-include")

target_link_libraries(heartratesensor "jansson" "ulfius")

