package com.example.minicrm.ui.addCustomer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.minicrm.R
import com.example.minicrm.base.BaseActivity
import com.example.minicrm.databinding.ActivityAddCustomerBinding
import com.example.minicrm.ui.main.MainActivity

class AddCustomerActivity : BaseActivity<ActivityAddCustomerBinding,AddCustomerViewModel>(),Navigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding.vm = viewModel
        viewModel.navigator = this
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_add_customer
    }

    override fun initViewModel(): AddCustomerViewModel {
        return ViewModelProvider(this)[AddCustomerViewModel::class.java]
    }

    override fun getContext(): Context? {
        return this.applicationContext
    }

    override fun openMainScreen() {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }


}