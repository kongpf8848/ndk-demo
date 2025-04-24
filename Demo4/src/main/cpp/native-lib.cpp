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

extern "C" JNIEXPORT jstring JNICALL
Java_io_github_kongpf8848_ndk_demo_MainActivity_stringFromKotlin(
        JNIEnv* env,
        jobject /* this */) {
    LOGD("stringFromKotlin");
    jclass jclazz = env->FindClass("io/github/kongpf8848/ndk/demo/Util");
    if (jclazz == NULL) {
        LOGW("+++++++++++++FindClass ERROR+++++++++++");
    }
    jmethodID jmethodID = env->GetStaticMethodID(jclazz, "getMsg","()Ljava/lang/String;");
    if(jmethodID==NULL){
        LOGW("+++++++++++++GetMethodID ERROR+++++++++++");
    }
    jstring jstr=static_cast<jstring>(env->CallStaticObjectMethod(jclazz,jmethodID));
    return jstr;
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