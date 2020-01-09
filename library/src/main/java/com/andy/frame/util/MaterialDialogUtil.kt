package com.andy.frame.util

import android.app.Activity
import android.app.Application
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.Space
import androidx.appcompat.app.AlertDialog
import com.andy.frame.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

/**
 * @title: MaterialDialogUtil
 * @projectName StudyAndroid
 * @description: TODO
 * @author LiuJie https://github.com/Handy045
 * @date Created in 2019-12-16 14:16
 */
class MaterialDialogUtil {

    enum class Type {
        Normal,
        Progress,
        Success,
        Error,
        Warning
    }

    companion object {
        var mDialog: AlertDialog? = null
        var mActivity: Activity? = null


        val instance: MaterialDialogUtil by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            MaterialDialogUtil()
        }

        fun registerActivityLifecycle(application: Application) {
            application.registerActivityLifecycleCallbacks(object :
                Application.ActivityLifecycleCallbacks {

                override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                    mActivity = activity
                }

                override fun onActivityStarted(activity: Activity) {
                    mActivity = activity
                }

                override fun onActivityResumed(activity: Activity) {
                    mActivity = activity
                }

                override fun onActivityPaused(activity: Activity) {
                    if (activity.isFinishing) {
                        mActivity = null
                        if (mDialog != null && mDialog!!.isShowing) {
                            mDialog?.dismiss()
                        }
                    }
                }

                override fun onActivityDestroyed(activity: Activity) {
                }

                override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
                }

                override fun onActivityStopped(activity: Activity) {
                }
            })
        }
    }

    /**
     * 通用提示框
     *
     * @param title 标题
     * @param message 内容
     * @param rBtnText 右侧按钮文本内容
     * @param rBtnClickListener 右侧按钮点击事件
     * @param lBtnText 左侧按钮文本内容
     * @param lBtnClickListener 左侧按钮点击事件
     * @param lastDismiss 如果上一个提示框还在呈现中，是否需要关闭
     * @param backDismiss 通过返回键关闭提示框
     * @param outsideDismiss 通过点击外部关闭提示框
     */
    fun showNormal(
        title: String = "",
        message: String = "",
        rBtnText: String = "",
        rBtnClickListener: DialogInterface.OnClickListener? = null,
        lBtnText: String = "",
        lBtnClickListener: DialogInterface.OnClickListener? = null,
        cBtnText: String = "",
        cBtnClickListener: DialogInterface.OnClickListener? = null,
        lastDismiss: Boolean = true,
        backDismiss: Boolean = true,
        outsideDismiss: Boolean = true
    ) {
        if (mActivity != null && !mActivity!!.isFinishing) {
            if (lastDismiss && mDialog != null && mDialog!!.isShowing) {
                mDialog?.dismiss()
            }

            val builder = getBuilder(Type.Normal)
            builder.setTitle(title)
                .setMessage(message)
                .setNeutralButton(lBtnText, lBtnClickListener)
                .setNegativeButton(cBtnText, cBtnClickListener)
                .setPositiveButton(rBtnText, rBtnClickListener)
            mDialog = builder.show()
            mDialog?.window?.findViewById<Space>(R.id.spacer)?.visibility = View.GONE
            mDialog?.window?.findViewById<FrameLayout>(R.id.contentPanel)?.minimumHeight = 0
            mDialog?.setCancelable(backDismiss)
            mDialog?.setCanceledOnTouchOutside(outsideDismiss)
        }
    }

    /**
     * 进度提示框
     *
     * @param message 提示内容
     * @param lastDismiss 如果上一个提示框还在呈现中，是否需要关闭
     * @param backDismiss 通过返回键关闭提示框
     * @param outsideDismiss 通过点击外部关闭提示框
     */
    fun showProgress(
        title: String = "",
        lastDismiss: Boolean = true,
        backDismiss: Boolean = false,
        outsideDismiss: Boolean = false
    ) {
        if (mActivity != null && !mActivity!!.isFinishing) {
            if (lastDismiss && mDialog != null && mDialog!!.isShowing) {
                mDialog?.dismiss()
            }

            val builder = getBuilder(Type.Progress)
            builder.setIcon(R.drawable.hd_anim_materialdialog_progress)
            builder.setMessage(title)
            mDialog = builder.show()
            mDialog?.window?.findViewById<Space>(R.id.spacer)?.visibility = View.GONE
            mDialog?.window?.findViewById<FrameLayout>(R.id.contentPanel)?.minimumHeight = 0
            mDialog?.setCancelable(backDismiss)
            mDialog?.setCanceledOnTouchOutside(outsideDismiss)
        }
    }

    /**
     * 成功提示框
     *
     * @param title 标题
     * @param message 内容
     * @param cBtnText 中间按钮文本内容
     * @param cBtnClickListener 中间按钮点击事件
     * @param lastDismiss 如果上一个提示框还在呈现中，是否需要关闭
     * @param backDismiss 通过返回键关闭提示框
     * @param outsideDismiss 通过点击外部关闭提示框
     */
    fun showSuccess(
        title: String = "",
        message: String = "",
        cBtnText: String = "",
        cBtnClickListener: DialogInterface.OnClickListener? = null,
        lastDismiss: Boolean = true,
        backDismiss: Boolean = true,
        outsideDismiss: Boolean = true
    ) {
        if (mActivity != null && !mActivity!!.isFinishing) {
            if (lastDismiss && mDialog != null && mDialog!!.isShowing) {
                mDialog?.dismiss()
            }

            val builder = getBuilder(Type.Success)
            builder.setTitle(title)
                .setMessage(message)
                .setNegativeButton(cBtnText, cBtnClickListener)
            mDialog = builder.show()
            mDialog?.window?.findViewById<Space>(R.id.spacer)?.visibility = View.GONE
            mDialog?.window?.findViewById<FrameLayout>(R.id.contentPanel)?.minimumHeight = 0
            mDialog?.setCancelable(backDismiss)
            mDialog?.setCanceledOnTouchOutside(outsideDismiss)
        }
    }

    /**
     * 错误提示框
     *
     * @param title 标题
     * @param message 内容
     * @param cBtnText 中间按钮文本内容
     * @param cBtnClickListener 中间按钮点击事件
     * @param lastDismiss 如果上一个提示框还在呈现中，是否需要关闭
     * @param backDismiss 通过返回键关闭提示框
     * @param outsideDismiss 通过点击外部关闭提示框
     */
    fun showError(
        title: String = "",
        message: String = "",
        cBtnText: String = "",
        cBtnClickListener: DialogInterface.OnClickListener? = null,
        lastDismiss: Boolean = true,
        backDismiss: Boolean = true,
        outsideDismiss: Boolean = true
    ) {
        if (mActivity != null && !mActivity!!.isFinishing) {
            if (lastDismiss && mDialog != null && mDialog!!.isShowing) {
                mDialog?.dismiss()
            }

            val builder = getBuilder(Type.Error)
            builder.setTitle(title)
                .setMessage(message)
                .setNegativeButton(cBtnText, cBtnClickListener)
            mDialog = builder.show()
            mDialog?.window?.findViewById<Space>(R.id.spacer)?.visibility = View.GONE
            mDialog?.window?.findViewById<FrameLayout>(R.id.contentPanel)?.minimumHeight = 0
            mDialog?.setCancelable(backDismiss)
            mDialog?.setCanceledOnTouchOutside(outsideDismiss)
        }
    }

    /**
     * 警告提示框
     *
     * @param title 标题
     * @param message 内容
     * @param cBtnText 中间按钮文本内容
     * @param cBtnClickListener 中间按钮点击事件
     * @param lastDismiss 如果上一个提示框还在呈现中，是否需要关闭
     * @param backDismiss 通过返回键关闭提示框
     * @param outsideDismiss 通过点击外部关闭提示框
     */
    fun showWarning(
        title: String = "",
        message: String = "",
        cBtnText: String = "",
        cBtnClickListener: DialogInterface.OnClickListener? = null,
        lastDismiss: Boolean = true,
        backDismiss: Boolean = true,
        outsideDismiss: Boolean = true
    ) {
        if (mActivity != null && !mActivity!!.isFinishing) {
            if (lastDismiss && mDialog != null && mDialog!!.isShowing) {
                mDialog?.dismiss()
            }

            val builder = getBuilder(Type.Warning)
            builder.setTitle(title)
                .setMessage(message)
                .setNegativeButton(cBtnText, cBtnClickListener)
            mDialog = builder.show()
            mDialog?.window?.findViewById<Space>(R.id.spacer)?.visibility = View.GONE
            mDialog?.window?.findViewById<FrameLayout>(R.id.contentPanel)?.minimumHeight = 0
            mDialog?.setCancelable(backDismiss)
            mDialog?.setCanceledOnTouchOutside(outsideDismiss)
        }
    }

    fun dismiss() {
        if (mDialog != null && mDialog!!.isShowing) {
            mDialog?.dismiss()
        }
    }

    fun getBuilder(type: Type): MaterialAlertDialogBuilder {
        return when (type) {
            Type.Normal -> {
                MaterialAlertDialogBuilder(mActivity, R.style.AD_MaterialDialogTheme_Normal)
            }
            Type.Progress -> {
                MaterialAlertDialogBuilder(mActivity, R.style.AD_MaterialDialogTheme)
            }
            Type.Success -> {
                MaterialAlertDialogBuilder(mActivity, R.style.AD_MaterialDialogTheme_Success)
            }
            Type.Error -> {
                MaterialAlertDialogBuilder(mActivity, R.style.AD_MaterialDialogTheme_Error)
            }
            Type.Warning -> {
                MaterialAlertDialogBuilder(mActivity, R.style.AD_MaterialDialogTheme_Warning)
            }
        }
    }
}