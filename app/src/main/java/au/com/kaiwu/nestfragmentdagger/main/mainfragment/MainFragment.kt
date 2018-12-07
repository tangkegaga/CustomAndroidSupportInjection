package au.com.kaiwu.nestfragmentdagger.main.mainfragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import au.com.kaiwu.nestfragmentdagger.R
import au.com.kaiwu.nestfragmentdagger.TestData
import au.com.kaiwu.nestfragmentdagger.main.childfragment.ChildFragment
import au.com.kaiwu.nestfragmentdagger.main.customview.CustomView
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject
import javax.inject.Named

class MainFragment : /*Dagger*/Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        var rootView: ViewGroup = inflater.inflate(R.layout.main_fragment, container, false) as ViewGroup

        context?.let {
            var customView = CustomView(it,childFragmentManager)
            rootView.addView(customView)
        }

        return rootView;
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
/*
        button.setOnClickListener {

            childFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .add(R.id.child_container, ChildFragment.newInstance())
                    .commit()

        }*/
    }

}
