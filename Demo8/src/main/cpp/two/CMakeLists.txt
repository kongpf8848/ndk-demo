
cmake_minimum_required(VERSION 3.4.1)
add_library(two-lib SHARED two.cpp)
find_library(two-lib log )
target_link_libraries(two-lib ${log-lib} )