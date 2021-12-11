package com.surfsocial.feature.main.ui.elements

import androidx.annotation.StringRes
import com.surfsocial.R

sealed class TabItem(
    @StringRes val title: Int
) {
    object Workers : TabItem(R.string.workers)

    object Projects : TabItem(R.string.projects)

    object About : TabItem(R.string.about)
}