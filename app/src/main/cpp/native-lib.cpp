#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring

JNICALL
Java_com_yhcloud_mykotlinproject_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Kotlin Project";
    return env->NewStringUTF(hello.c_str());
}
