# Health Care IoT Example Implementation

A demo implementation of the code generated using [FogUML2Code](https://github.com/fog-uml-2-code/fog-uml-2-code) from the [health-care-iot-example](https://github.com/fog-uml-2-code/health-care-iot-example) model.


## Disclaimer
We would like to note that we are NOT medical doctors and that this application only serves as a theoretic example use case for our software engineering approach.


## Fog Device Languages and Port Configurations

The following table shows in which language the code for each fog device from the *health-care-iot-example* model is generated and on which port it is configured to run:

| Fog Device          | Target Language | Listen Port |
| ------------------- | --------------- | ----------- |
| HeartRateSensor     | C               | 8081        |
| TemperatureSensor   | C               | 8082        |
| BloodPressureSensor | C               | 8083        |
| BloodSugarSensor    | Java            | 8084        |
| InsulinPump         | Java            | 8085        |

Since this is a demo for testing FogUML2Code, the ports are all different, such that all applications can be run on a single machine.


## Compiling and Running the Demo

To compile the programs in the [c](./c) folder you need [CMake](https://cmake.org) and the [ulfius](https://github.com/babelouest/ulfius) headers and link library (and all dependencies).

To compile the programs in the [java](./java) folder you need [Maven](https://maven.apache.org) and you must install the [fog-execution-framework-java](https://github.com/fog-uml-2-code/fog-execution-framework-java) into your local Maven repository before building the demo modules.

Once you have built all modules with CMake and Maven, you need to run all of the built executables (the sensors, the insulin pump, and the health care application).
