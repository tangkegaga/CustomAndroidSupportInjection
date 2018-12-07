# CustomAndroidSupportInjection
we want to follow this practice:
https://google.github.io/dagger/android.html
====
Use case: 
inside of AndroidSupportInjection.inject(this), there is a method called findHasFragmentInjector(fragment), which will 
track upwards to all its parent fragment and activity and application, to see if any one has implemented HasSupportFragmentInjector.

What if in this chains, I have another viewgroup like viewpager, which also have a scope. And that viewgroup is the very top 
Component, which doesn't neccessary to rely on upper chains.

====
so original code structure is : app->acitivity->mainfragment->customviewGroup->childFragment.
and dagger will start from customviewGroup. 
so code structure after dagger is : app->acitivity->mainfragment
                                   ->customviewGroup(Dagger provider)->childFragment(Dagger consumer).






