package au.com.kaiwu.nestfragmentdagger.main.customview

import au.com.kaiwu.nestfragmentdagger.TestData
import au.com.kaiwu.nestfragmentdagger.scope.CustomViewScope
import dagger.*
import javax.inject.Named

@Module
class CustomViewDaggerModule {

    @Provides
    @CustomViewScope
    @Named("provideCustomViewTestData")
    fun provideCustomViewTestData(customView: CustomView): TestData {
        return TestData("CustomViewTestData")
    }

}
