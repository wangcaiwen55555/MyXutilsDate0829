package com.bwie.myxutilsdate0829.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.myxutilsdate0829.R;
import com.bwie.myxutilsdate0829.bean.NewsBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Time:2017/8/29 19:59
 * Author:王才文
 * Description:
 */

public class MyAdapter extends BaseAdapter{

    private Context context;
    private List<NewsBean.ResultBean.DataBean> list;

    public MyAdapter(Context context, List<NewsBean.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder=null;
        if(view==null){
            holder=new ViewHolder();
            view = View.inflate(context, R.layout.item, null);
            holder.img= view.findViewById(R.id.iv_img);

            holder.date=view.findViewById(R.id.tv_date);

            holder.title=view.findViewById(R.id.tv_title);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        ImageLoader.getInstance().displayImage(list.get(i).thumbnail_pic_s02,holder.img);
        holder.title.setText(list.get(i).title);
        holder.date.setText(list.get(i).date);

        return view;
    }

    class ViewHolder{
        public ImageView img;
        public TextView title;
        public TextView date;
    }
}
