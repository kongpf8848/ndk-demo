#include <jni.h>
#include <string>
#include<android/log.h>

#define TAG    "NDKLOG"
#define LOGV(...)  __android_log_print(ANDROID_LOG_VERBOSE,TAG,__VA_ARGS__)
#define LOGD(...)  __android_log_print(ANDROID_LOG_DEBUG,TAG,__VA_ARGS__)
#define LOGI(...)  __android_log_print(ANDROID_LOG_INFO,TAG,__VA_ARGS__)
#define LOGW(...)  __android_log_print(ANDROID_LOG_WARN,TAG,__VA_ARGS__)
#define LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,TAG,__VA_ARGS__)

extern "C" JNIEXPORT jstring JNICALL
Java_io_github_kongpf8848_ndk_demo_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    LOGD("stringFromJNI");
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
