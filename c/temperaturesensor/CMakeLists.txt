project(temperaturesensor C)

include("../common/CMakeLists.txt" "src/platform-include")

set(SRCS
	"src/main.c"
	"src/TemperatureSensor.c"
	"src/TemperatureSensorHandler.c"
)

add_executable(temperaturesensor ${SRCS} ${COMMON_LIB_SRCS})

target_include_directories(temperaturesensor PUBLIC "../common/src" "src/platform-include")

target_link_libraries(temperaturesensor "jansson" "ulfius")

