package com.customizeln

import android.content.res.Resources
import android.util.TypedValue

/**
 * @author: hs-johnny
 * @date: 2020/7/22
 * @description:
 */

val Float.dp2px
    get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, this, Resources.getSystem().displayMetrics)