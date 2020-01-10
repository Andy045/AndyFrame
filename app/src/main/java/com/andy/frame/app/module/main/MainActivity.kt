package com.andy.frame.app.module.main

import android.os.Bundle
import android.view.LayoutInflater
import com.andy.basic.mvp.BasePresenter
import com.andy.frame.app.R
import com.andy.frame.module.drawer.DrawerActivity

/**
 * @title: StartActivity
 * @projectName HandyFrame
 * @description: 首页界面
 * @author LiuJie https://github.com/Handy045
 * @date Created in 2020-01-08 17:31
 */
class MainActivity : DrawerActivity<BasePresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getTitlebar().setTitleText("首页")
    }

    override fun initViewHD(savedInstanceState: Bundle?) {
        super.initViewHD(savedInstanceState)

        val view =
            LayoutInflater.from(mContext).inflate(R.layout.hd_include_main_drawer_right, null)
        addDrawerLeftView(view)
    }
}
