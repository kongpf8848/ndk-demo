#include <jni.h>
#include <string>
#include<android/log.h>

#define TAG    "NDKLOG"
#define LOGV(...)  __android_log_print(ANDROID_LOG_VERBOSE,TAG,__VA_ARGS__)
#define LOGD(...)  __android_log_print(ANDROID_LOG_DEBUG,TAG,__VA_ARGS__)
#define LOGI(...)  __android_log_print(ANDROID_LOG_INFO,TAG,__VA_ARGS__)
#define LOGW(...)  __android_log_print(ANDROID_LOG_WARN,TAG,__VA_ARGS__)
#define LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,TAG,__VA_ARGS__)

#define JNI_PACKAGE "io/github/kongpf8848/ndk/demo"
#define METHOD_COUNT(methodArray) (sizeof(methodArray) / sizeof((methodArray)[0]))

/**
 * 获取应用程序包名
 */
jstring jniGetPackageName(JNIEnv *env, jobject clazz, jobject context) {
    LOGD("jniGetPackageName");

    jclass contextClass = env->GetObjectClass(context);
    jmethodID jmethodId = env->GetMethodID(contextClass, "getPackageName", "()Ljava/lang/String;");
    jstring packageName = static_cast<jstring>(env->CallObjectMethod(context, jmethodId));
    return packageName;
}

/**
 * 获取应用程序签名
 */
jstring jniGetSignature(JNIEnv *env, jobject clazz, jobject context) {
    LOGD("jniGetSignature");

    jclass native_class = env->GetObjectClass(context);

    /**
     * 获取PackageManager
     */
    jmethodID pm_id = env->GetMethodID(native_class, "getPackageManager","()Landroid/content/pm/PackageManager;");
    jobject pm_obj = env->CallObjectMethod(context, pm_id);
    jclass pm_clazz = env->GetObjectClass(pm_obj);

    /**
     * 获取PackageInfo
     */
    jmethodID package_info_id = env->GetMethodID(pm_clazz, "getPackageInfo","(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;");
    jstring pkg_str = jniGetPackageName(env, clazz, context);
    jobject pi_obj = env->CallObjectMethod(pm_obj, package_info_id, pkg_str, 64);
    jclass pi_clazz = env->GetObjectClass(pi_obj);

    jfieldID signatures_fieldId = env->GetFieldID(pi_clazz, "signatures","[Landroid/content/pm/Signature;");
    jobject signatures_obj = env->GetObjectField(pi_obj, signatures_fieldId);
    jobjectArray signaturesArray = (jobjectArray) signatures_obj;

    jobject signature_obj = env->GetObjectArrayElement(signaturesArray, 0);
    jclass signature_clazz = env->GetObjectClass(signature_obj);
    jmethodID string_id = env->GetMethodID(signature_clazz, "toCharsString","()Ljava/lang/String;");
    jstring str = static_cast<jstring>(env->CallObjectMethod(signature_obj, string_id));

    return str;
}

/**
 * Kotlin传递数组给C++代码
 */
void jniIntArrayTest(JNIEnv *env, jobject clazz, jintArray array){
    LOGD("jniIntArrayTest");

    jint *buf = env->GetIntArrayElements(array, JNI_FALSE);
    if (buf == NULL) {
        return;
    }
    int length = env->GetArrayLength(array);
    LOGD("array length is %d", length);
    for (int i = 0; i < length; ++i) {
        LOGD("array[%d] is %d",i,buf[i]);
    }
    env->ReleaseIntArrayElements(array, buf, 0);
}

/**
 * C++传递数组给Kotlin代码
 */
void kotlinIntArrayTest(JNIEnv *env, jobject clazz){
    LOGD("kotlinIntArrayTest");

    jclass utilClass = env->FindClass(JNI_PACKAGE"/Util");
    if (utilClass == NULL) {
        LOGW("+++++++++++++FindClass ERROR+++++++++++");
    }
    jintArray array = env->NewIntArray(3);
    jint buf[] = {5, 4, 8};
    env->SetIntArrayRegion(array, 0, 3, buf);
    jmethodID mid = env->GetStaticMethodID(utilClass, "IntArrayMsg", "([I)V");
    env->CallStaticVoidMethod(utilClass, mid, array);
}


static JNINativeMethod methods[] = {
        {"jniGetPackageName",
                "(Landroid/content/Context;)Ljava/lang/String;",
                (void *) jniGetPackageName
        },
        {"jniGetSignature",
                "(Landroid/content/Context;)Ljava/lang/String;",
                (void *) jniGetSignature
        },
        {
            "jniIntArrayTest",
                "([I)V",
           (void *) jniIntArrayTest
        },
        {
            "kotlinIntArrayTest",
                    "()V",
                    (void *) kotlinIntArrayTest
        }
};

extern "C" JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *vm, void *reserved) {
    LOGD("JNI_OnLoad");
    JNIEnv *env = NULL;
    jint result = -1;

    if (vm->GetEnv((void **) &env, JNI_VERSION_1_6) != JNI_OK) {
        LOGW("+++++++++++++GetEnv ERROR+++++++++++");
        return JNI_ERR;
    }
    jclass clazz = env->FindClass(JNI_PACKAGE "/MainActivity");
    if (!clazz) {
        LOGW("Failed to find " JNI_PACKAGE "/MainActivity");
        return JNI_ERR;
    }
    if (env->RegisterNatives(clazz, methods, METHOD_COUNT(methods)) < 0) {
        LOGW("Failed to RegisterNatives");
        return JNI_ERR;
    }
    LOGD("RegisterNatives OK");

    result = JNI_VERSION_1_6;
    return result;
}

extern "C" JNIEXPORT void JNICALL JNI_OnUnload(JavaVM *vm, void *reserved) {
    LOGD("JNI_OnUnload");
}