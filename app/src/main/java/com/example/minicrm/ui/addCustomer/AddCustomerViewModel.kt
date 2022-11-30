package com.example.minicrm.ui.addCustomer


import android.widget.Toast
import androidx.databinding.ObservableField
import com.example.minicrm.base.BaseViewModel
import com.example.minicrm.database.MyDataBase
import com.example.minicrm.database.model.MiniCrm

class AddCustomerViewModel : BaseViewModel<Navigator>() {

    val customerName = ObservableField<String>()
    val customerNameError = ObservableField<String>()
    val customerPhone = ObservableField<String>()
    val customerPhoneError = ObservableField<String>()
    val customerEmail = ObservableField<String>()


    fun createCustomer() {
        if (validate()){
            createCustomerInDataBase()
        }
    }


    private fun createCustomerInDataBase() {
        val miniCrm = MiniCrm(
            name = customerName.get(),
            phoneNumber = customerPhone.get(),
            email = customerEmail.get(),
        )
        MyDataBase.getInstance(navigator?.getContext()!!).miniCrmDao().addCustomers(miniCrm)
        Toast.makeText(navigator?.getContext(),"Add successfull",Toast.LENGTH_LONG).show()
        navigator?.openMainScreen()
    }

    private fun validate():Boolean {
        var valid = true
        if (customerName.get().isNullOrBlank()) {
            customerNameError.set("Please Enter Customer Name")
            valid = false
        }else {
            customerNameError.set(null)
        }
        if (customerPhone.get().isNullOrBlank()) {
            customerPhoneError.set("Please Enter Customer Phone Number")
            valid = false
        }else {
            customerPhoneError.set(null)
        }
        return valid
    }
}