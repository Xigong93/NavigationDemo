#Navigation 使用指南：

## 常用功能如何实现
- 简单跳转
- 监听返回键
- 返回之前的页面
- 登录处理（路由拦截）
    * 在目标页面，判断登录情况，并跳转登录页面
    * 使用监听器，监听到需要登录到页面，关闭该页面，跳转到登录页面
    * 登录页面使用另外一个activity，在MainActivity，没有登录，跳转到LoginActivity并关闭MainActivity,登录之后重新打开MainActivity
- 深度链接处理
- 组件化
- ui 效果处理
    * 多个Fragment公用ToolBar
    * 状态栏处理
    * 竖横屏处理
- ViewPager中使用
- 底部导航中使用
- DrawLayout中使用

## Q&A:
1.   navController.popBackStack() 和 navController.navigateUp() 区别?
正常情况是一样的效果，如果当前的activity是由其他app，跳转过来的，那么navigateUp（）会留在我们的app，并打开我们app的根布局。
而popBackStack()会直接finish我们的app的页面，返回用户跳转来的那个app
2. Dialog和PopupWindow穿透
如果你不想非栈顶的fragment，弹出dialog或者是popupwindows，导致挡住栈顶的fragment，需要在Fragment,onStart()和onStop()直接弹出浮层,推荐使用LiveData.
如果你想弹出浮层，挡住栈顶的fragment,那太和你心意了，默认就是这样
3. Navigation 是怎么解决fragment 背景透明，导致穿透的问题?
Navigation 切换fragment 是 replace fragment ,fragment的view，不在栈顶的fragment的View，会被销毁
4. Navigation 是怎么解决fragment 点击事件穿透到后面的fragment的问题?
同上
5. 如果一个Fragment.onCreateView() 返回null,
那么它的onFragmentViewCreated()不会执行，在销毁时onFragmentViewDestroyed()依然会执行
6. 默认情况下多次调用navigate 同一个id，也打开多个相同的fragment，怎么处理只显示一个呢?
通过代码，或者是设置xml 属性 launchSingleTop =true，启用栈顶复用


## 后记
为什么要写这个，因为我工作4年多了，这玩意我也不6，所以想系统学习一下。
我是一只菜鸡，什么地方如果搞错了，请啄我，哈哈。
大家有问题请提issues，希望大家都能用fragment做出非常流畅的app

## 参考文章
- [Google官方教程](https://developer.android.com/guide/navigation/navigation-getting-started)
- [Using Navigation Architecture Component in a large banking app](https://medium.com/google-developer-experts/using-navigation-architecture-component-in-a-large-banking-app-ac84936a42c2)