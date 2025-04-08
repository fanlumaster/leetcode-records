cmake_minimum_required(VERSION 3.27.0)
project(leetsolu VERSION 1.0 LANGUAGES CXX)

# specify the C++ standard
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED True)
# set output executable file directory
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/bin)

include_directories("./src/utils/includes/")

set(MY_EXECUTABLE_NAME "leetsolu")

add_executable(
  ${MY_EXECUTABLE_NAME}
  "src/leet06/solu1.cpp"
)
