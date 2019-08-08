
## Android 动态权限申请

Android简单动态获取权限获取

Android 6.0把权限分为两种：Normal Permissions（正常权限）和Dangerous Permissions（危险权限）。其中危险权限又进行了分类。把所有的危险权限分成了几个组。正常权限不会给用户的隐私带来不安全，不需要动态申请，在应用安装的时候就已经被授予了。危险权限需要动态处理，只有用户批准了这些权限，应用才能被授予这些权限。


**如何使用**

> 添加依赖

~~~ JAVA 

    allprojects {
        repositories {
            ...
            maven { url 'https://www.jitpack.io' }
        }
    }
    
    
    dependencies {
        implementation 'com.github.ymkmdf:SimplePermissions:v1.0.0'
    }
~~~

> 项目中调用

~~~ JAVA
 private void requestPermissions(){
        MPermission.with(this)
                .addRequestCode(23231)
                .permissions(Manifest.permission.CAMERA)
                .request();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        MPermission.onRequestPermissionsResult(this,requestCode,permissions,grantResults);
    }

    @OnMPermissionDenied(23231)
    public void onMpermission(){
        Toast.makeText(this,"拒绝了",Toast.LENGTH_SHORT).show();
    }

    @OnMPermissionGranted(23231)
    public void onMPermissionGranted(){
        Toast.makeText(this,"成功了",Toast.LENGTH_SHORT).show();
    }

    @OnMPermissionNeverAskAgain(23231)
    public void onMPermissionNeverAskAgain(){
        Toast.makeText(this,"勾选拒绝了",Toast.LENGTH_SHORT).show();
    }
~~~

(*￣︶￣) (*￣︶￣)
