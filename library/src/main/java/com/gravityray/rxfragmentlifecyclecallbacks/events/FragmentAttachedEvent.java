package com.gravityray.rxfragmentlifecyclecallbacks.events;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

@SuppressWarnings({"unused", "WeakerAccess"})
public class FragmentAttachedEvent<F extends Fragment> extends FragmentLifecycleEvent<F> {

    private final Context context;

    public FragmentAttachedEvent(
            @NonNull FragmentManager fragmentManager,
            @NonNull F fragment,
            @NonNull Context context) {
        super(fragmentManager, fragment);
        this.context = context;
    }

    @NonNull
    public Context getContext() {
        return context;
    }
}
