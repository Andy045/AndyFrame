package com.andy.frame.module.start

import android.content.Intent
import android.os.Bundle
import androidx.annotation.DrawableRes
import com.andy.basic.mvp.BasePresenter
import com.andy.frame.R
import com.andy.frame.base.FrameActivity
import com.andy.frame.util.MaterialDialogUtil
import kotlinx.android.synthetic.main.hd_activity_start.*

/**
 * @title: StartActivity
 * @projectName HandyFrame
 * @description: TODO
 * @author LiuJie https://github.com/Handy045
 * @date Created in 2020-01-08 17:20
 */
abstract class StartActivity : FrameActivity<BasePresenter>() {

    init {
        this.isCheckPermissions = true
    }

    var isFinishCurrent: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hd_activity_start)

        val resId = setBackgroundImage()
        if (resId != null) {
            image.setImageResource(resId)
        }
    }

    override fun onPermissionSuccessHD() {
        super.onPermissionSuccessHD()

        val intent = setIntentTargetActivity()
        if (intent != null) {
            startActivity(intent)
            if (isFinishCurrent) {
                finish()
            }
        }
    }

    override fun onPermissionRejectionHD(permissions: Array<String>) {
        super.onPermissionRejectionHD(permissions)
        MaterialDialogUtil.instance.showProgress("正在查询，请稍候")
//        MaterialDialogUtil.instance.showSuccess("AAA", "BBBB", "CCCC", null)
//        MaterialDialogUtil.instance.showError("AAA", "BBBB", "CCCC", null)
//        MaterialDialogUtil.instance.showWarning("AAA", "BBBB", "CCCC", null)
//        MaterialDialogUtil.instance.showNormal(
//            "AAA",
//            "BBBB",
//            "CCCC",
//            null,
//            "CCCC",
//            null,
//            "CCCC",
//            null
//        )
    }


    @DrawableRes
    abstract fun setBackgroundImage(): Int?

    abstract fun setIntentTargetActivity(): Intent?
}