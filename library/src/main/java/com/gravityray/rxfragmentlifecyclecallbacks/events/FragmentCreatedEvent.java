package com.gravityray.rxfragmentlifecyclecallbacks.events;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

@SuppressWarnings({"unused", "WeakerAccess"})
public class FragmentCreatedEvent<F extends Fragment> extends FragmentLifecycleEvent<F> {

    private final Bundle savedInstanceState;

    public FragmentCreatedEvent(
            @NonNull FragmentManager fragmentManager,
            @NonNull F fragment,
            @Nullable Bundle savedInstanceState) {
        super(fragmentManager, fragment);
        this.savedInstanceState = savedInstanceState;
    }

    @Nullable
    public Bundle getSavedInstanceState() {
        return savedInstanceState;
    }
}
