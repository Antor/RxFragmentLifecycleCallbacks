package com.gravityray.rxfragmentlifecyclecallbacks.events;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

@SuppressWarnings({"unused", "WeakerAccess"})
public class FragmentViewCreatedEvent<F extends Fragment> extends FragmentLifecycleEvent<F> {

    private final View view;
    private final Bundle savedInstanceState;

    public FragmentViewCreatedEvent(
            @NonNull FragmentManager fragmentManager,
            @NonNull F fragment,
            @NonNull View view,
            @Nullable Bundle savedInstanceState) {
        super(fragmentManager, fragment);
        this.view = view;
        this.savedInstanceState = savedInstanceState;
    }

    @NonNull
    public View getView() {
        return view;
    }

    @Nullable
    public Bundle getSavedInstanceState() {
        return savedInstanceState;
    }
}
