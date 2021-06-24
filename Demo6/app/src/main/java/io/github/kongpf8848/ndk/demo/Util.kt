package io.github.kongpf8848.ndk.demo

import android.content.Context
import android.content.pm.PackageManager

object Util {

    @JvmStatic
    fun getMsg():String{
        return "Hello from Kotlin"
    }

    /**
     * 获取应用程序签名
     */
    fun getAppSignature(context: Context): String? {
        try {
            val packageInfo = context.packageManager.getPackageInfo(context.packageName, PackageManager.GET_SIGNATURES)
            val signatures = packageInfo.signatures
            return signatures[0].toCharsString()
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return null
    }
}