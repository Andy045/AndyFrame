package com.andy.frame.app.module.main

import android.os.Bundle
import com.andy.basic.mvp.BasePresenter
import com.andy.frame.module.drawer.DrawerActivity
import com.andy.titlebar.entity.Action

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
        initTitlebar(getTitlebar(), "首页")

        getTitlebar().addRightAction(object : Action() {
            init {
                this.setText("OPEN")
            }

            override fun onClick() {
                openDrawerRight()
            }
        })
    }
}
