# ndk-demo

NDK入门实战Demo，由浅入深，一步一步讲解NDK的使用。

## Demo

[1. 最简单的示例，使用Kotlin调用C++代码](https://github.com/kongpf8848/ndk-demo/tree/master/Demo1)

[2. 在C++代码中打印Log输出到Logcat](https://github.com/kongpf8848/ndk-demo/tree/master/Demo2)

[3. 使用JNI_OnLoad和JNI_OnUnload方法](https://github.com/kongpf8848/ndk-demo/tree/master/Demo3)

[4. 使用Kotlin调用C++代码，在C++代码中调用Kotlin](https://github.com/kongpf8848/ndk-demo/tree/master/Demo4)

[5. 使用Kotlin调用C++代码获取应用程序包名和签名](https://github.com/kongpf8848/ndk-demo/tree/master/Demo5)

[6. 动态注册jni函数](https://github.com/kongpf8848/ndk-demo/tree/master/Demo6

## CMake
[CMake](https://cmake.org/)语法可参考[CMake官方文档](https://cmake.org/documentation)，[CMake 入门实战-文档](https://www.hahack.com/codes/cmake)，[CMake 入门实战-GitHub](https://github.com/wzpan/cmake-demo)

## 签名机制 
函数签名就是函数的参数与返回值的结合体，用来进行精准匹配。函数签名由字符串组成，第一部分是包含在圆括号()里的，用来说明参数类型，第二部分则是返回值类型。比如```([Ljava/lang/Object;)Z```就是参数为```Object[]```，返回值是```boolean```的函数的签名。

| Java类型 | 类型标识 |
| :-: | :-: |
|   boolean   |   Z   |
| byte | B |
| char | C |
| short | S |
| int | I |
| long | J |
| float | F |
| double | D |
| void | V |
| String | Ljava/lang/String; |
| Class | Ljava/lang/Class; |
| int[] | [I |
| Object[] | [Ljava/lang/Object; |

## 其他

[NDK官方文档](https://developer.android.google.cn/ndk/guides)

