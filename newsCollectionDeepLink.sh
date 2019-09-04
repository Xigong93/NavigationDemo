#!/bin/bash
# 测试深度链接
adb shell am start \
        -W -a android.intent.action.VIEW \
        -d "https://pokercc.com/android/newsCollection" pokercc.android.navigationdemo