#include <jni.h>
#include <string>
#include<android/log.h>

#define TAG    "NDKLOG"
#define LOGV(...)  __android_log_print(ANDROID_LOG_VERBOSE,TAG,__VA_ARGS__)
#define LOGD(...)  __android_log_print(ANDROID_LOG_DEBUG,TAG,__VA_ARGS__)
#define LOGI(...)  __android_log_print(ANDROID_LOG_INFO,TAG,__VA_ARGS__)
#define LOGW(...)  __android_log_print(ANDROID_LOG_WARN,TAG,__VA_ARGS__)
#define LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,TAG,__VA_ARGS__)

jstring jniGetPackageName(JNIEnv *env, jobject clazz, jobject context) {
    jclass contextClass = env->GetObjectClass(context);
    jmethodID jmethodId = env->GetMethodID(contextClass, "getPackageName", "()Ljava/lang/String;");
    jstring packageName = static_cast<jstring>(env->CallObjectMethod(context, jmethodId));
    return packageName;
}

/**
 * 获取应用程序包名
 */
extern "C" JNIEXPORT jstring JNICALL
Java_io_github_kongpf8848_ndk_demo_MainActivity_jniGetPackageName(
        JNIEnv* env,
        jobject clazz,jobject context) {
    LOGD("jniGetPackageName");
    return jniGetPackageName(env,clazz,context);
}

/**
 * 获取应用程序签名
 */
extern "C" JNIEXPORT jstring JNICALL
Java_io_github_kongpf8848_ndk_demo_MainActivity_jniGetSignature(
        JNIEnv* env,
        jobject clazz,jobject context) {
    LOGD("jniGetSignature");

    jclass native_class = env->GetObjectClass(context);

    /**
     * 获取PackageManager
     */
    jmethodID pm_id = env->GetMethodID(native_class, "getPackageManager", "()Landroid/content/pm/PackageManager;");
    jobject pm_obj = env->CallObjectMethod(context, pm_id);
    jclass pm_clazz = env->GetObjectClass(pm_obj);

    /**
     * 获取PackageInfo
     */
    jmethodID package_info_id = env->GetMethodID(pm_clazz, "getPackageInfo", "(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;");
    jstring pkg_str = jniGetPackageName(env, clazz, context);
    jobject pi_obj = env->CallObjectMethod(pm_obj, package_info_id, pkg_str, 64);
    jclass pi_clazz = env->GetObjectClass(pi_obj);

    jfieldID signatures_fieldId = env->GetFieldID(pi_clazz, "signatures", "[Landroid/content/pm/Signature;");
    jobject signatures_obj = env->GetObjectField(pi_obj, signatures_fieldId);
    jobjectArray signaturesArray = (jobjectArray)signatures_obj;

    jobject signature_obj = env->GetObjectArrayElement(signaturesArray, 0);
    jclass signature_clazz = env->GetObjectClass(signature_obj);
    jmethodID string_id = env->GetMethodID(signature_clazz, "toCharsString", "()Ljava/lang/String;");
    jstring str = static_cast<jstring>(env->CallObjectMethod(signature_obj, string_id));

    return str;
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