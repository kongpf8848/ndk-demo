
cmake_minimum_required(VERSION 3.4.1)
add_library(one-lib SHARED one.cpp)
find_library(one-lib log )
target_link_libraries(one-lib ${log-lib} )