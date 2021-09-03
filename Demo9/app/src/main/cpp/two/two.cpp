#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_io_github_kongpf8848_ndk_demo_MainActivity_stringFromJNI2(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "stringFromJNI_2";
    return env->NewStringUTF(hello.c_str());
}
