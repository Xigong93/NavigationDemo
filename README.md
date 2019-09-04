Navigation 使用指南：

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


Q&A:
1.   navController.popBackStack() 和 navController.navigateUp() 区别?
正常情况是一样的效果，如果当前的activity是由其他app，跳转过来的，那么navigateUp（）会留在我们的app，并打开我们app的根布局。
而popBackStack()会直接finish我们的app的页面，返回用户跳转来的那个app
2. Dialog和PopupWindow穿透

我只是个搬运工