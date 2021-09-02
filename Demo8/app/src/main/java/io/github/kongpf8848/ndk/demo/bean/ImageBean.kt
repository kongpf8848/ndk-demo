package io.github.kongpf8848.ndk.demo.bean

import androidx.annotation.DrawableRes
import java.io.Serializable

class ImageBean(@DrawableRes val resId: Int, val name: String) : Serializable