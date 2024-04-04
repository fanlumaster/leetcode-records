cmake_minimum_required(VERSION 3.0.0)
project(leetsolu VERSION 1.0)

# specify the C++ standard
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED True)

include_directories("./src/utils")
include_directories("./src/utils/includes/")

add_compile_options("$<$<C_COMPILER_ID:MSVC>:/utf-8>")
add_compile_options("$<$<CXX_COMPILER_ID:MSVC>:/utf-8>")

add_executable(leetsolu "./src/leet101/solu1.cpp" "./src/utils/datastructures.cpp")
