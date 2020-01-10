package com.andy.frame.app.module.main

import android.os.Bundle
import com.andy.basic.mvp.BasePresenter
import com.andy.frame.app.R
import com.andy.frame.base.FrameActivity

/**
 * @title: StartActivity
 * @projectName HandyFrame
 * @description: 首页界面
 * @author LiuJie https://github.com/Handy045
 * @date Created in 2020-01-08 17:31
 */
class MainActivity : FrameActivity<BasePresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initTitlebar(R.id.titlebar, "首页")
    }
}
