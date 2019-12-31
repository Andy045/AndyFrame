package com.andy.frame.base

import com.andy.basic.base.BaseActivity
import com.andy.basic.base.BaseFragment
import com.andy.basic.mvp.BasePresenter

/**
 * @title: FrameFragment
 * @projectName HandyFrame
 * @description: TODO
 * @author LiuJie https://github.com/Handy045
 * @date Created in 2019-12-30 17:21
 */
class FrameFragment<A : BaseActivity<P>, P : BasePresenter> : BaseFragment<A, P>()