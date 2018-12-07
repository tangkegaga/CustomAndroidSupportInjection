package au.com.kaiwu.nestfragmentdagger.main.customview

import android.content.Context
import android.support.v4.app.FragmentManager
import android.widget.FrameLayout
import android.support.v4.content.ContextCompat.getSystemService
import android.view.LayoutInflater
import au.com.kaiwu.nestfragmentdagger.R
import au.com.kaiwu.nestfragmentdagger.main.childfragment.ChildFragment
import kotlinx.android.synthetic.main.custom_view.view.*


class CustomView(context: Context, fragmentManager: FragmentManager) : FrameLayout(context) {


    init {
        LayoutInflater.from(context).inflate(R.layout.custom_view, this, true)
        fragmentManager.beginTransaction()
                .replace(R.id.container, ChildFragment.newInstance())
                .commit()

    }
}