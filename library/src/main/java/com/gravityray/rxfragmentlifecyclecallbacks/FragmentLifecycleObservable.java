package com.gravityray.rxfragmentlifecyclecallbacks;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.gravityray.rxfragmentlifecyclecallbacks.events.FragmentActivityCreatedEvent;
import com.gravityray.rxfragmentlifecyclecallbacks.events.FragmentAttachedEvent;
import com.gravityray.rxfragmentlifecyclecallbacks.events.FragmentCreatedEvent;
import com.gravityray.rxfragmentlifecyclecallbacks.events.FragmentDestroyedEvent;
import com.gravityray.rxfragmentlifecyclecallbacks.events.FragmentDetachedEvent;
import com.gravityray.rxfragmentlifecyclecallbacks.events.FragmentLifecycleEvent;
import com.gravityray.rxfragmentlifecyclecallbacks.events.FragmentPausedEvent;
import com.gravityray.rxfragmentlifecyclecallbacks.events.FragmentPreAttachedEvent;
import com.gravityray.rxfragmentlifecyclecallbacks.events.FragmentPreCreatedEvent;
import com.gravityray.rxfragmentlifecyclecallbacks.events.FragmentResumedEvent;
import com.gravityray.rxfragmentlifecyclecallbacks.events.FragmentSaveInstanceStateEvent;
import com.gravityray.rxfragmentlifecyclecallbacks.events.FragmentStartedEvent;
import com.gravityray.rxfragmentlifecyclecallbacks.events.FragmentStoppedEvent;
import com.gravityray.rxfragmentlifecyclecallbacks.events.FragmentViewCreatedEvent;
import com.gravityray.rxfragmentlifecyclecallbacks.events.FragmentViewDestroyedEvent;

import java.util.concurrent.atomic.AtomicBoolean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


@SuppressWarnings("WeakerAccess")
public class FragmentLifecycleObservable extends Observable<FragmentLifecycleEvent<Fragment>> {

    @SuppressWarnings("NullableProblems")
    private static class Listener
            extends FragmentManager.FragmentLifecycleCallbacks
            implements Disposable {

        private final FragmentManager fragmentManager;
        private final Observer<? super FragmentLifecycleEvent<Fragment>> observer;

        private final AtomicBoolean disposed;

        Listener(FragmentManager fragmentManager,
                Observer<? super FragmentLifecycleEvent<Fragment>> observer) {
            this.fragmentManager = fragmentManager;
            this.observer = observer;

            this.disposed = new AtomicBoolean(false);
        }

        @Override
        public void onFragmentPreAttached(
                @NonNull FragmentManager fm,
                @NonNull Fragment f,
                @NonNull Context context) {
            observer.onNext(new FragmentPreAttachedEvent<>(fm, f, context));
        }

        @Override
        public void onFragmentAttached(
                @NonNull FragmentManager fm,
                @NonNull Fragment f,
                @NonNull Context context) {
            observer.onNext(new FragmentAttachedEvent<>(fm, f, context));
        }

        @Override
        public void onFragmentPreCreated(
                @NonNull FragmentManager fm,
                @NonNull Fragment f,
                @Nullable Bundle savedInstanceState) {
            observer.onNext(new FragmentPreCreatedEvent<>(fm, f, savedInstanceState));
        }

        @Override
        public void onFragmentCreated(
                @NonNull FragmentManager fm,
                @NonNull Fragment f,
                @Nullable Bundle savedInstanceState) {
            observer.onNext(new FragmentCreatedEvent<>(fm, f, savedInstanceState));
        }

        @Override
        public void onFragmentActivityCreated(
                @NonNull FragmentManager fm,
                @NonNull Fragment f,
                @Nullable Bundle savedInstanceState) {
            observer.onNext(new FragmentActivityCreatedEvent<>(fm, f, savedInstanceState));
        }

        @Override
        public void onFragmentViewCreated(
                @NonNull FragmentManager fm,
                @NonNull Fragment f,
                @NonNull View v,
                @Nullable Bundle savedInstanceState) {
            observer.onNext(new FragmentViewCreatedEvent<>(fm, f, v, savedInstanceState));
        }

        @Override
        public void onFragmentStarted(
                @NonNull FragmentManager fm,
                @NonNull Fragment f) {
            observer.onNext(new FragmentStartedEvent<>(fm, f));
        }

        @Override
        public void onFragmentResumed(
                @NonNull FragmentManager fm,
                @NonNull Fragment f) {
            observer.onNext(new FragmentResumedEvent<>(fm, f));
        }

        @Override
        public void onFragmentPaused(
                @NonNull FragmentManager fm,
                @NonNull Fragment f) {
            observer.onNext(new FragmentPausedEvent<>(fm, f));
        }

        @Override
        public void onFragmentStopped(
                @NonNull FragmentManager fm,
                @NonNull Fragment f) {
            observer.onNext(new FragmentStoppedEvent<>(fm, f));
        }

        @Override
        public void onFragmentSaveInstanceState(
                @NonNull FragmentManager fm,
                @NonNull Fragment f,
                @NonNull Bundle outState) {
            observer.onNext(new FragmentSaveInstanceStateEvent<>(fm, f, outState));
        }

        @Override
        public void onFragmentViewDestroyed(
                @NonNull FragmentManager fm,
                @NonNull Fragment f) {
            observer.onNext(new FragmentViewDestroyedEvent<>(fm, f));
        }

        @Override
        public void onFragmentDestroyed(
                @NonNull FragmentManager fm,
                @NonNull Fragment f) {
            observer.onNext(new FragmentDestroyedEvent<>(fm, f));
        }

        @Override
        public void onFragmentDetached(
                @NonNull FragmentManager fm,
                @NonNull Fragment f) {
            observer.onNext(new FragmentDetachedEvent<>(fm, f));
        }

        @Override
        public void dispose() {
            if (disposed.compareAndSet(false, true)) {
                fragmentManager.unregisterFragmentLifecycleCallbacks(this);
            }
        }

        @Override
        public boolean isDisposed() {
            return disposed.get();
        }
    }

    private final FragmentManager fragmentManager;
    private final boolean recursive;

    public FragmentLifecycleObservable(
            @NonNull FragmentManager fragmentManager,
            boolean recursive) {
        this.fragmentManager = fragmentManager;
        this.recursive = recursive;
    }

    @Override
    protected void subscribeActual(Observer<? super FragmentLifecycleEvent<Fragment>> observer) {
        Listener listener = new Listener(fragmentManager, observer);
        observer.onSubscribe(listener);
        fragmentManager.registerFragmentLifecycleCallbacks(listener, recursive);
    }
}
