package android.consultafrota.com.firebase_samples

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder>
{
    var mDataset:Array<String>? = null;

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
         val v = LayoutInflater.from(parent?.context).inflate(R.layout.my_text_view,parent,false)
         val vh = ViewHolder(v)
        return vh
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.mText?.text = mDataset?.get(position)
    }

    override fun getItemCount(): Int {
        return mDataset?.count() as Int
    }

    class ViewHolder : RecyclerView.ViewHolder
    {
        var mText:TextView?=null
        constructor(v:View): super(v)
        {
            mText = v.findViewById(R.id.info_text) as TextView
        }
    }

    constructor(myDataset: Array<String>)
    {
        mDataset = myDataset
    }
}

