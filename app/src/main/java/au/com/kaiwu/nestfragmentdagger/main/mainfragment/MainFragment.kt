package au.com.kaiwu.nestfragmentdagger.main.mainfragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import au.com.kaiwu.nestfragmentdagger.R
import au.com.kaiwu.nestfragmentdagger.TestData
import au.com.kaiwu.nestfragmentdagger.main.childfragment.ChildFragment
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject
import javax.inject.Named

class MainFragment : DaggerFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    @Inject
    lateinit var testData: TestData/*singleton within life of app*/

    @Inject
    @field:Named("MainFragmentTestData")
    lateinit var testDataMainFragment: TestData/*singleton within life of MainFragment*/

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

        button.setOnClickListener {

            childFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .add(R.id.child_container, ChildFragment.newInstance())
                    .commit()

        }
    }

}
