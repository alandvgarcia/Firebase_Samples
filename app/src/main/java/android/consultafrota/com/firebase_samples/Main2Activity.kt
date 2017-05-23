package android.consultafrota.com.firebase_samples

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class Main2Activity : AppCompatActivity() {

    private var mRecyclerView:RecyclerView? = null
    private var mAdapater:MyAdapter? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        mRecyclerView = findViewById(R.id.my_recycle_view) as RecyclerView
        mRecyclerView?.setHasFixedSize(true)

        mLayoutManager = LinearLayoutManager(this)
        mRecyclerView?.layoutManager = mLayoutManager

        val asc = Array(50, { i -> (i).toString() })
        mAdapater = MyAdapter(asc)

        mRecyclerView?.adapter = mAdapater
    }

    companion object{
        fun getStartActivityIntent(context: Context): Intent
        {
            val intent = Intent(context, Main2Activity::class.java)
            return intent
        }
    }
}
