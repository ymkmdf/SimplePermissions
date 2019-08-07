
## Android 动态权限申请

Android简单动态获取权限获取

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
