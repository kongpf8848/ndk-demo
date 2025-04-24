#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_io_github_kongpf8848_ndk_demo_MainActivity_stringFromJNI1(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "stringFromJNI_1";
    return env->NewStringUTF(hello.c_str());
}
