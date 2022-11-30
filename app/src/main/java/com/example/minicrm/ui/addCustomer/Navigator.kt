package com.example.minicrm.ui.addCustomer

import android.content.Context

interface Navigator {
    fun getContext(): Context?
    fun openMainScreen()
}