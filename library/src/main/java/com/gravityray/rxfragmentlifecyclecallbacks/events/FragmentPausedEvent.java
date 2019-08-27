package com.gravityray.rxfragmentlifecyclecallbacks.events;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

@SuppressWarnings("WeakerAccess")
public class FragmentPausedEvent<F extends Fragment> extends FragmentLifecycleEvent<F> {

    public FragmentPausedEvent(
            @NonNull FragmentManager fragmentManager,
            @NonNull F fragment) {
        super(fragmentManager, fragment);
    }
}
