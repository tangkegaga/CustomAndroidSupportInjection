package au.com.kaiwu.nestfragmentdagger.main.customview

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.widget.FrameLayout
import android.support.v4.content.ContextCompat.getSystemService
import android.view.LayoutInflater
import au.com.kaiwu.nestfragmentdagger.R
import au.com.kaiwu.nestfragmentdagger.main.childfragment.ChildFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import kotlinx.android.synthetic.main.custom_view.view.*
import javax.inject.Inject
import dagger.android.support.HasSupportFragmentInjector


class CustomView(context: Context, fragmentManager: FragmentManager) : FrameLayout(context), HasSupportFragmentInjector {
    @Inject
    internal lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>


    private lateinit var customViewDaggerComponent: CustomViewDaggerComponent


    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingFragmentInjector
    }


    init {
        LayoutInflater.from(context).inflate(R.layout.custom_view, this, true)

        /*
        to make the following possible
        @Inject
        internal lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>
        * */
        customViewDaggerComponent = DaggerCustomViewDaggerComponent.builder().customView(this).build()
        customViewDaggerComponent.inject(this)

        fragmentManager.beginTransaction()
                .replace(R.id.container, ChildFragment.newInstance())
                .commit()

    }
}