package com.andy.frame.base

import com.andy.basic.base.BaseActivity
import com.andy.basic.mvp.BasePresenter

/**
 * @title: FrameActivity
 * @projectName HandyFrame
 * @description: TODO
 * @author LiuJie https://github.com/Handy045
 * @date Created in 2019-12-30 17:20
 */
abstract class FrameActivity<P : BasePresenter> : BaseActivity<P>()