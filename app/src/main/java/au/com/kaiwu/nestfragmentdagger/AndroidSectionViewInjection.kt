package au.com.kaiwu.nestfragmentdagger

import android.support.v4.app.Fragment
import android.util.Log
import dagger.android.AndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import dagger.internal.Beta


import android.util.Log.DEBUG
import android.view.ViewGroup
import android.view.ViewParent

import dagger.internal.Preconditions.checkNotNull


/** Injects core Android types from support libraries.  */
@Beta
object AndroidSectionViewInjection {
    private val TAG = "dagger.android.support"

    /**
     * Injects `fragment` if an associated [dagger.android.AndroidInjector] implementation
     * can be found, otherwise throws an [IllegalArgumentException].
     *
     *
     * Uses the following algorithm to find the appropriate `AndroidInjector<Fragment>` to
     * use to inject `fragment`:
     *
     *
     *  1. Walks the parent-fragment hierarchy to find the a fragment that implements [       ], and if none do
     *  1. Uses the `fragment`'s [activity][Fragment.getActivity] if it implements
     * [HasSupportFragmentInjector], and if not
     *  1. Uses the [android.app.Application] if it implements [       ].
     *
     *
     * If none of them implement [HasSupportFragmentInjector], a [ ] is thrown.
     *
     * @throws IllegalArgumentException if no parent fragment, activity, or application implements
     * [HasSupportFragmentInjector].
     */
    fun inject(viewGroup: ViewGroup?, fragment: Fragment) {
        if (viewGroup == null) return

        val hasFragmentInjector = findViewHasFragmentInjector(viewGroup, fragment)
        if (Log.isLoggable(TAG, DEBUG)) {
            Log.d(
                    TAG,
                    String.format(
                            "An injector for %s was found in %s",
                            viewGroup.javaClass.canonicalName,
                            hasFragmentInjector.javaClass.canonicalName))
        }

        val fragmentInjector = hasFragmentInjector.supportFragmentInjector()
        checkNotNull<AndroidInjector<Fragment>>(
                fragmentInjector,
                "%s.supportFragmentInjector() returned null",
                hasFragmentInjector.javaClass)

        fragmentInjector.inject(fragment)
    }

    private fun findViewHasFragmentInjector(viewGroup: ViewGroup, fragment: Fragment): HasSupportFragmentInjector {

        var parentV: ViewParent? = viewGroup
        if (parentV != null) {
            do {
                if (parentV is HasSupportFragmentInjector) {
                    return parentV
                }
                parentV = parentV!!.parent

            } while (parentV != null)

        }



        throw IllegalArgumentException(
                String.format("No injector was found for %s", fragment.javaClass.canonicalName))


    }
}
