package com.bwie.myxutilsdate0829;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;

/**
 * Time:2017/8/29 19:30
 * Author:王才文
 * Description:
 */

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ImageLoader();
       Xutils();

    }

    private void ImageLoader() {
        DisplayImageOptions options=new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .build();

        ImageLoaderConfiguration config=new ImageLoaderConfiguration.Builder(this)
                .writeDebugLogs()
                .defaultDisplayImageOptions(options)
                .build();

        ImageLoader.getInstance().init(config);

    }

    private void Xutils() {
        x.Ext.init(this);
    }
}
