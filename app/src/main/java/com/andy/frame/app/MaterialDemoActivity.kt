package com.andy.frame.app

import android.os.Bundle
import com.andy.basic.mvp.BasePresenter
import com.andy.frame.base.FrameActivity
import kotlinx.android.synthetic.main.activity_material_demo.*

/**
 * @title: MaterialDemoActivity
 * @projectName HandyFrame
 * @description: TODO
 * @author LiuJie https://github.com/Handy045
 * @date Created in 2020-01-03 15:21
 */
class MaterialDemoActivity : FrameActivity<BasePresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_demo)
        initTitlebar(titlebar, "Material Demo")
    }
}