package com.andy.frame.module.drawer

import android.os.Bundle
import android.view.View
import com.andy.basic.mvp.BasePresenter
import com.andy.frame.R
import com.andy.frame.base.FrameActivity
import kotlinx.android.synthetic.main.hd_activity_drawer.*

/**
 * @title: DrawerActivity
 * @projectName HandyFrame
 * @description: 抽屉界面
 * @author LiuJie https://github.com/Handy045
 * @date Created in 2020-01-10 08:50
 */
open class DrawerActivity<P : BasePresenter> : FrameActivity<P>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hd_activity_drawer)
    }

    fun setCenterFrameLayout(view: View) {
        frameLayoutCenter.addView(view)
    }

    fun setLeftDrawerFrameLayout(view: View) {
        frameLayoutLeft.addView(view)
    }

    fun setRightDrawerFrameLayout(view: View) {
        frameLayoutRight.addView(view)
    }
}