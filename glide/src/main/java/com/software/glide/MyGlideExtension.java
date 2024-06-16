package com.software.glide;

import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;

@GlideExtension
public class MyGlideExtension {
    private MyGlideExtension() {}

    @GlideOption
    public static BaseRequestOptions<?> defaultImage(BaseRequestOptions<?>options){
        return options
                .placeholder(R.mipmap.loading)
                .error(R.mipmap.error)
                .fallback(R.mipmap.empty)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .circleCrop();//新版本圆形框
    }
}
