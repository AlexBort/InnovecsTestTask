Migration of liveData into flow:

MainViewModel:
mtbDataStateFlow - mutable (for setting values into it) hot flow (will be active immediately after creation of it)
readDataFlow - asSharedFlow (does not have ability to change it - read only) 

MainActivity:
By collect we subscribe to result of flow
We subscribe to flow by launching on lifecycleScope: lifecycleScope.launchWhenStarted { }
we don't call repeatOnLifecycle, because we need to handle state by 1 click on button only 1 time 