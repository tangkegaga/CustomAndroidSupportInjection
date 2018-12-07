package au.com.kaiwu.nestfragmentdagger.main.customview

import au.com.kaiwu.nestfragmentdagger.main.childfragment.ChildFragmentBuilder
import au.com.kaiwu.nestfragmentdagger.scope.CustomViewScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        ChildFragmentBuilder::class,
        CustomViewDaggerModule::class
))
@CustomViewScope
interface CustomViewDaggerComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun sectionView(customView: CustomView): Builder

        fun build(): CustomViewDaggerComponent

    }

    fun inject(customView: CustomView)

}
