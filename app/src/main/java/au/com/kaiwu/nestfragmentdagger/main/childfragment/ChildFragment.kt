package au.com.kaiwu.nestfragmentdagger.main.childfragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import au.com.kaiwu.nestfragmentdagger.AndroidSectionViewInjection
import au.com.kaiwu.nestfragmentdagger.R
import au.com.kaiwu.nestfragmentdagger.TestData
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import javax.inject.Named

class ChildFragment : /*Dagger*/Fragment() {


    companion object {
        fun newInstance() = ChildFragment()
    }

    private lateinit var viewModel: ChildViewModel

    @Inject
    @field:Named("provideCustomViewTestData")
    lateinit var testData: TestData


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        AndroidSectionViewInjection.inject(container, this)
        if (testData != null) {

        }
        return inflater.inflate(R.layout.child_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ChildViewModel::class.java)
        // TODO: Use the ViewModel


    }

}
