package com.finddreams.ktgrank.ui


import android.content.Intent
import android.support.v7.widget.GridLayoutManager
import android.widget.ImageView
import com.finddreams.ktgrank.R
import com.finddreams.ktgrank.adapter.BindRecyclerAdapter
import com.finddreams.ktgrank.adapter.GirlAdapter
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
class MeiziFragment : BaseFragment<FragmentAndroidBinding>() {
    private lateinit var mAdapter: GirlAdapter
    private var gank = ArrayList<GankResponse>()
    var num:Int=1

    override fun getBindLayoutId(): Int {
        return R.layout.fragment_android
    }


    override fun initData() {
        mAdapter= GirlAdapter(gank)
        mBinding.recycleView.adapter=mAdapter
        mBinding.recycleView.layoutManager=GridLayoutManager(context,2)
        getAndroidData(1)
        mBinding.refreshLayout.setOnRefreshListener {
            getAndroidData(1)
        }
        mBinding.refreshLayout.setOnLoadmoreListener{
            getAndroidData(++num)
        }
        mAdapter.setOnItemClickListener {
            pos->
        val gankResponse = gank[pos]
            val url = gankResponse.url

            val imageView = mBinding.recycleView.findViewHolderForAdapterPosition(pos)?.itemView?.findViewById(R.id.iv_girl) as ImageView
            ImageActivity.startActivity(context!!,imageView,gank[pos].url)
        }
    }

    private fun getAndroidData(page: Int) {
        App.instance.appComponent.getApi().getMeizi(page).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                { response ->
                    if (page==1){
                        gank.clear()
                    }
                    gank.addAll(response.results)
                    mAdapter.notifyDataSetChanged()
                    mBinding.refreshLayout.finishLoadmore()
                    mBinding.refreshLayout.finishRefresh()
                })
    }

}
