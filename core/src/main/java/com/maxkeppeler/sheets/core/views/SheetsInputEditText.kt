/*
 *  Copyright (C) 2020. Maximilian Keppeler (https://www.maxkeppeler.com)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.maxkeppeler.sheets.core.views

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.textfield.TextInputEditText
import com.maxkeppeler.sheets.core.R
import com.maxkeppeler.sheets.core.utils.colorOfAttr

/** Custom EditTextView used for text input. */
class SheetsInputEditText
@JvmOverloads constructor(
    ctx: Context,
    attrs: AttributeSet? = null
) : TextInputEditText(ctx, attrs) {

    init {

        // Ignore that this custom view uses the same styleable as SheetContent, as it is supposed to look the same

        val a = ctx.obtainStyledAttributes(attrs, R.styleable.SheetsContent, 0, 0)

        val colorDefault = colorOfAttr(ctx, android.R.attr.textColorPrimary)
        val color = a.getColor(R.styleable.SheetsContent_sheetsContentColor, colorDefault)
        setTextColor(color)

        val fontResId = a.getResourceId(R.styleable.SheetsContent_sheetsContentFont, 0)
        fontResId.takeIf { it != 0 }?.let { typeface = ResourcesCompat.getFont(ctx, it) }

        val spacing =
            a.getFloat(R.styleable.SheetsContent_sheetsContentLetterSpacing, 0f)
        spacing.takeIf { it != 0f }?.let { letterSpacing = it }

        a.recycle()
    }
}
