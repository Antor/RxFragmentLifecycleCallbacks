package com.gravityray.rxfragmentlifecyclecallbacks.events;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

@SuppressWarnings({"WeakerAccess", "unused"})
public class FragmentSaveInstanceStateEvent<F extends Fragment> extends FragmentLifecycleEvent<F> {

    private final Bundle outState;

    public FragmentSaveInstanceStateEvent(
            @NonNull FragmentManager fragmentManager,
            @NonNull F fragment,
            @NonNull Bundle outState) {
        super(fragmentManager, fragment);
        this.outState = outState;
    }

    @NonNull
    public Bundle getOutState() {
        return outState;
    }
}
