package com.umbrella.financialteaching.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import butterknife.ButterKnife
import com.umbrella.financialteaching.R
import com.umbrella.financialteaching.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        // Example of a call to a native method
//        sample_text.text = stringFromJNI()
//    }

    override fun loadViewLayout() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    override fun bindViews() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setListener() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun processLogic(saveInstanceState: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
