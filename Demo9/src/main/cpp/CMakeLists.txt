cmake_minimum_required(VERSION 3.4.1)

include_directories(breakpad/src breakpad/src/common/android/include)

add_library(native-lib
        SHARED
        native-lib.cpp)

add_subdirectory(breakpad)

find_library(log-lib log)

target_link_libraries(native-lib ${log-lib} breakpad)