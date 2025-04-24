# ndk-demo

NDK入门实战Demo，由浅入深，一步一步讲解NDK的使用。

## Demo

* [Demo1](https://github.com/kongpf8848/ndk-demo/tree/master/Demo1) - 最简单的示例，使用Kotlin调用C++代码

* [Demo2](https://github.com/kongpf8848/ndk-demo/tree/master/Demo2) - 在C++代码中打印Log输出到Logcat

* [Demo3](https://github.com/kongpf8848/ndk-demo/tree/master/Demo3) - 使用JNI_OnLoad和JNI_OnUnload方法

* [Demo4](https://github.com/kongpf8848/ndk-demo/tree/master/Demo4) - 使用Kotlin调用C++代码，在C++代码中调用Kotlin

* [Demo5](https://github.com/kongpf8848/ndk-demo/tree/master/Demo5) - 使用Kotlin调用C++代码获取应用程序包名和签名

* [Demo6](https://github.com/kongpf8848/ndk-demo/tree/master/Demo6) - 动态注册jni函数

* [Demo7](https://github.com/kongpf8848/ndk-demo/tree/master/Demo7) - Kotlin传递数组给C++代码&&C++传递数组给Kotlin代码

* [Demo8](https://github.com/kongpf8848/ndk-demo/tree/master/Demo8) - 一次性生成多个so库


## 签名机制 
函数签名就是函数的参数与返回值的结合体，用来进行精准匹配。函数签名由字符串组成，第一部分是包含在圆括号()里的，用来说明参数类型，第二部分则是返回值类型。比如```([Ljava/lang/Object;)Z```就是参数为```Object[]```，返回值是```boolean```的函数的签名。

| Java类型 | jni类型|类型标识 |
| :-: | :-: | :-: |
| boolean   |jboolean|   Z   |
| byte | jbyte | B |
| char | jchar | C |
| short | jshort | S |
| int | jint | I |
| long | jlong | J |
| float | jfloat | F |
| double | jdouble | D |
| void | void | V |
| String | jstring | Ljava/lang/String; |
| Class | jclass | Ljava/lang/Class; |
| int[] | jintArray | [I |
| Object[] | jobjectArray | [Ljava/lang/Object; |

## 其他

- [NDK官方文档](https://developer.android.google.cn/ndk/guides)
- [CMake官方文档](https://cmake.org/documentation)
- [CMake入门实战-文档](https://www.hahack.com/codes/cmake)
- [CMake入门实战-GitHub](https://github.com/wzpan/cmake-demo)

