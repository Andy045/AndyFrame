package com.andy.frame.app.module.start

import android.content.Intent
import com.andy.basic.mvp.BasePresenter
import com.andy.frame.app.R
import com.andy.frame.module.start.BaseStartActivity

/**
 * @title: StartActivity
 * @projectName HandyFrame
 * @description: 欢迎界面
 * @author LiuJie https://github.com/Handy045
 * @date Created in 2020-01-08 17:31
 */
class StartActivity : BaseStartActivity<BasePresenter>() {

    override fun setBackgroundImage(): Int? {
        return R.drawable.hd_img_start_bg
    }

    override fun setIntentTargetActivity(): Intent? {
        return null
    }
}