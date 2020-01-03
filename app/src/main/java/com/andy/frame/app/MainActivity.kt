package com.andy.frame.app

import android.os.Bundle
import com.andy.basic.mvp.BasePresenter
import com.andy.frame.base.FrameActivity

class MainActivity : FrameActivity<BasePresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initTitlebar(R.id.titlebar, "首页")
    }
}
