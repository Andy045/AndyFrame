package com.andy.frame.module.start

import android.os.Bundle
import androidx.annotation.DrawableRes
import com.andy.basic.mvp.BasePresenter
import com.andy.frame.R
import com.andy.frame.base.FrameActivity

/**
 * @title: StartActivity
 * @projectName HandyFrame
 * @description: TODO
 * @author LiuJie https://github.com/Handy045
 * @date Created in 2020-01-08 17:20
 */
abstract class StartActivity : FrameActivity<BasePresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hd_activity_start)
    }

    @DrawableRes
    abstract fun setBackgroundImage(): Int
}