package com.bwie.myxutilsdate0829;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.bwie.myxutilsdate0829.adapter.MyAdapter;
import com.bwie.myxutilsdate0829.bean.NewsBean;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewInject(R.id.lv_list)
    ListView mListView;
    List<NewsBean.ResultBean.DataBean> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       x.view().inject(this);


        getRequest();



    }

    /**
     * get请求
     */
    private void getRequest() {
        RequestParams params=new RequestParams(UtilsApi.URL);
        params.addQueryStringParameter("key",UtilsApi.KEY);

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result){
                System.out.println("====="+result);
               list = pauseData(result);
                //展示数据
                MyAdapter myAdapter=new MyAdapter(MainActivity.this,list);
                mListView.setAdapter(myAdapter);

            }

            /**
             * 解析数据
             * @param result
             */
            private  List<NewsBean.ResultBean.DataBean> pauseData(String result) {

                Gson gson=new Gson();
                NewsBean newsBean = gson.fromJson(result, NewsBean.class);

                NewsBean.ResultBean result1 = newsBean.result;

                List<NewsBean.ResultBean.DataBean> data = result1.data;

                return data;


            }



            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });



    }


}
