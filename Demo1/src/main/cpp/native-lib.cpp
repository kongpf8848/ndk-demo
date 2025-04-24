#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_io_github_kongpf8848_ndk_demo_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    int *a = (int *) NULL;
    *a = 1;
    return env->NewStringUTF(hello.c_str());
}
