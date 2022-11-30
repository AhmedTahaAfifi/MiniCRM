package com.example.minicrm.ui.main


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.minicrm.base.BaseActivity
import com.example.minicrm.database.MyDataBase
import com.example.minicrm.databinding.ActivityMainBinding
import com.example.minicrm.ui.addCustomer.AddCustomerActivity


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), Navigator {
    val adapter = CustomerAdapter(null)
    override lateinit var viewDataBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding.vm = viewModel
        viewModel.navigator = this
        viewDataBinding.recyclerView.adapter = adapter
        adapter.onClickListener = object : CustomerAdapter.OnClickListener{
            override fun onItemClick(position: Int, itemView: Unit) {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.putExtra("phone",adapter.getItemId(position))
                val p = "tel:" + MyDataBase.getInstance(applicationContext).miniCrmDao().gatAllCustomer()[position].phoneNumber
                intent.data = Uri.parse(p)
                startActivity(intent)
            }

        }
    }

    override fun getLayoutId(): Int {
        return com.example.minicrm.R.layout.activity_main
    }

    override fun initViewModel(): MainViewModel {
        return ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun openAddCustomer() {
        val intent = Intent(this, AddCustomerActivity::class.java)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        getCustomerListFromDB()
    }


    override fun getCustomerListFromDB() {
        val customerList = MyDataBase.getInstance(this).miniCrmDao()
            .gatAllCustomer()
        adapter.changeData(customerList.toMutableList())
    }




}


