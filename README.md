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


## Q&A:
1.   navController.popBackStack() 和 navController.navigateUp() 区别?
正常情况是一样的效果，如果当前的activity是由其他app，跳转过来的，那么navigateUp（）会留在我们的app，并打开我们app的根布局。
而popBackStack()会直接finish我们的app的页面，返回用户跳转来的那个app
2. Dialog和PopupWindow穿透

我只是个搬运工
3. Navigation 是怎么解决fragment 背景透明，导致穿透的问题?
Navigation 切换fragment 是 replace fragment ,fragment的view，不在栈顶的fragment的View，会被销毁
4. Navigation 是怎么解决fragment 点击事件穿透到后面的fragment的问题?
同上
5. 如果一个Fragment.onCreateView() 返回null,
那么它的onFragmentViewCreated()不会执行，在销毁时onFragmentViewDestroyed()依然会执行



## 后记
为什么要写这个，因为我工作4年多了，这玩意我也不6，所以想系统学习一下。
大家有问题请提issues，希望大家都能用fragment做出非常流畅的app
