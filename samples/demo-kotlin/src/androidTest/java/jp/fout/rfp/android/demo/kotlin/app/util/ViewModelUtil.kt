package jp.fout.rfp.android.demo.kotlin.app.util

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

object ViewModelUtil {
    fun <T : ViewModel> createFor(model: T): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(model.javaClass)) {
                    @Suppress("UNCHECKED_CAST")
                    return model as T
                }
                throw IllegalArgumentException("unexpected model class $modelClass")
            }
        }
    }
}
