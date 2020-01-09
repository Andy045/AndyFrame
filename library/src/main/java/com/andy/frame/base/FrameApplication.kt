package com.andy.frame.base

import android.app.Application
import com.andy.basic.base.BaseApplication
import com.andy.frame.util.MaterialDialogUtil

/**
 * @title: FrameApplication
 * @projectName HandyFrame
 * @description: TODO
 * @author LiuJie https://github.com/Handy045
 * @date Created in 2019-12-30 17:21
 */
open class FrameApplication : BaseApplication() {

    override fun onCreateHD(application: Application) {
        super.onCreateHD(application)
        MaterialDialogUtil.registerActivityLifecycle(this)
    }
}