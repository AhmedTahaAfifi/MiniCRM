package com.example.minicrm.ui.main

import com.example.minicrm.base.BaseViewModel

class MainViewModel : BaseViewModel<Navigator>() {
    fun createCustomer() {
        navigator?.openAddCustomer()
    }


}