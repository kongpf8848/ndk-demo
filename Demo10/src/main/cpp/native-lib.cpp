#include <jni.h>
#include <string>
#include<android/log.h>

#define TAG    "NDKLOG"
#define LOGV(...)  __android_log_print(ANDROID_LOG_VERBOSE,TAG,__VA_ARGS__)
#define LOGD(...)  __android_log_print(ANDROID_LOG_DEBUG,TAG,__VA_ARGS__)
#define LOGI(...)  __android_log_print(ANDROID_LOG_INFO,TAG,__VA_ARGS__)
#define LOGW(...)  __android_log_print(ANDROID_LOG_WARN,TAG,__VA_ARGS__)
#define LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,TAG,__VA_ARGS__)

#include <stdio.h>
#include "breakpad/src/client/linux/handler/exception_handler.h"
#include "breakpad/src/client/linux/handler/minidump_descriptor.h"

bool DumpCallback(const google_breakpad::MinidumpDescriptor &descriptor,
                  void *context,
                  bool succeeded) {
    LOGD("DumpPath: %s\n", descriptor.path());
    return succeeded;
}

extern "C" JNIEXPORT void JNICALL
Java_io_github_kongpf8848_ndk_demo_MainActivity_initBreakpad(
        JNIEnv *env,
        jobject clazz, jstring path) {
    LOGD("initBreakpad11");
    const char *dump_path = env->GetStringUTFChars(path, nullptr);

    google_breakpad::MinidumpDescriptor descriptor(dump_path);
    google_breakpad::ExceptionHandler eh(descriptor, nullptr, DumpCallback,
                                         nullptr, true, -1);
    env->ReleaseStringUTFChars(path, dump_path);
    LOGD("initBreakpad22");
}

extern "C" JNIEXPORT void JNICALL
Java_io_github_kongpf8848_ndk_demo_MainActivity_testCrash(
        JNIEnv *env,
        jobject clazz) {
    LOGD("testCrash");
    volatile int *a = nullptr;
    *a = 1;
}


extern "C" JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *vm, void *reserved) {
    LOGD("JNI_OnLoad");
    JNIEnv *env = NULL;
    jint result = -1;

    if (vm->GetEnv((void **) &env, JNI_VERSION_1_6) != JNI_OK) {
        LOGW("+++++++++++++GetEnv ERROR+++++++++++");
        return JNI_ERR;
    }

    result = JNI_VERSION_1_6;
    return result;
}

extern "C" JNIEXPORT void JNICALL JNI_OnUnload(JavaVM *vm, void *reserved) {
    LOGD("JNI_OnUnload");
}