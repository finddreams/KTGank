package com.finddreams.ktgrank.ui


import android.content.Intent
import com.finddreams.ktgrank.R
import com.finddreams.ktgrank.adapter.BindRecyclerAdapter
import com.finddreams.ktgrank.base.App
import com.finddreams.ktgrank.bean.GankResponse
import com.finddreams.ktgrank.databinding.FragmentAndroidBinding
import com.finddreams.ktgrank.utils.toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_android.*
import java.util.ArrayList
import kotlin.math.log


/**
 *
 */
class AndroidFragment : BaseFragment<FragmentAndroidBinding>() {
    private lateinit var mAdapter: BindRecyclerAdapter
    private var gank = ArrayList<GankResponse>()

    override fun getBindLayoutId(): Int {
        return R.layout.fragment_android
    }


    override fun initData() {
        mAdapter= BindRecyclerAdapter(gank)
        mBinding.recycleView.adapter=mAdapter
        getAndroidData(1)
        mBinding.refreshLayout.setOnRefreshListener {
            toast("刷新")
        }
        mBinding.refreshLayout.setOnLoadmoreListener{
            toast("加载更多")
            getAndroidData(2)
        }
        mAdapter.setOnItemClickListener {
            pos->
        val gankResponse = gank[pos]
            val url = gankResponse.url
            val intent=Intent(context,WebActivity::class.java)
            intent.putExtra(WebActivity.URL,url)
            startActivity(intent)
        }
    }

    private fun getAndroidData(page: Int) {
        App.instance.appComponent.getApi().getAndroid(page).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                { response ->
                    gank.addAll(response.results)
                    mAdapter.notifyDataSetChanged()
                    mBinding.refreshLayout.finishLoadmore()
                })
    }

}
