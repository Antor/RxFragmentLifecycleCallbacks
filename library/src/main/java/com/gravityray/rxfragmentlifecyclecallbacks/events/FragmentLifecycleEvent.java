package com.gravityray.rxfragmentlifecyclecallbacks.events;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


@SuppressWarnings({"unused", "WeakerAccess"})
public abstract class FragmentLifecycleEvent<F extends Fragment> {

    private final FragmentManager fragmentManager;
    private final F fragment;

    public FragmentLifecycleEvent(
            @NonNull FragmentManager fragmentManager,
            @NonNull F fragment) {
        this.fragmentManager = fragmentManager;
        this.fragment = fragment;
    }

    @NonNull
    public FragmentManager getFragmentManager() {
        return fragmentManager;
    }

    @NonNull
    public F getFragment() {
        return fragment;
    }

}
