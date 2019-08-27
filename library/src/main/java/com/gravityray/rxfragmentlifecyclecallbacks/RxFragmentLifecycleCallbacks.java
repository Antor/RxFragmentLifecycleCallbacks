package com.gravityray.rxfragmentlifecyclecallbacks;

import androidx.annotation.NonNull;
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

import io.reactivex.Observable;


@SuppressWarnings({"unused", "WeakerAccess"})
public class RxFragmentLifecycleCallbacks {

    public static Observable<FragmentLifecycleEvent<Fragment>> getAllEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive) {
        return new FragmentLifecycleObservable(fragmentManager, recursive);
    }

    // region onFragmentPreAttached

    public static <F extends Fragment> Observable<F> getOnFragmentPreAttached(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {
        return getFragmentPreAttachedEvents(fragmentManager, recursive, fragmentClass)
                .map(FragmentLifecycleEvent::getFragment);
    }

    public static <F extends Fragment> Observable<FragmentPreAttachedEvent<F>> getFragmentPreAttachedEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {

        //noinspection unchecked
        return getFragmentPreAttachedEvents(fragmentManager, recursive)
                .filter(event -> fragmentClass.isInstance(event.getFragment()))
                .map(event -> (FragmentPreAttachedEvent<F>) event);
    }

    public static Observable<FragmentPreAttachedEvent<Fragment>> getFragmentPreAttachedEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive) {
        return getAllEvents(fragmentManager, recursive)
                .filter(FragmentPreAttachedEvent.class::isInstance)
                .map(event -> (FragmentPreAttachedEvent<Fragment>) event);
    }

    // endregion

    // region onFragmentAttached

    public static <F extends Fragment> Observable<F> getOnFragmentAttached(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {
        return getFragmentAttachedEvents(fragmentManager, recursive, fragmentClass)
                .map(FragmentLifecycleEvent::getFragment);
    }

    public static <F extends Fragment> Observable<FragmentAttachedEvent<F>> getFragmentAttachedEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {

        //noinspection unchecked
        return getFragmentAttachedEvents(fragmentManager, recursive)
                .filter(event -> fragmentClass.isInstance(event.getFragment()))
                .map(event -> (FragmentAttachedEvent<F>) event);
    }

    public static Observable<FragmentAttachedEvent<Fragment>> getFragmentAttachedEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive) {
        return getAllEvents(fragmentManager, recursive)
                .filter(FragmentAttachedEvent.class::isInstance)
                .map(event -> (FragmentAttachedEvent<Fragment>) event);
    }

    // endregion

    // region onFragmentPreCreated

    public static <F extends Fragment> Observable<F> getOnFragmentPreCreated(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {
        return getFragmentPreCreatedEvents(fragmentManager, recursive, fragmentClass)
                .map(FragmentLifecycleEvent::getFragment);
    }

    public static <F extends Fragment> Observable<FragmentPreCreatedEvent<F>> getFragmentPreCreatedEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {

        //noinspection unchecked
        return getFragmentPreCreatedEvents(fragmentManager, recursive)
                .filter(event -> fragmentClass.isInstance(event.getFragment()))
                .map(event -> (FragmentPreCreatedEvent<F>) event);
    }

    public static Observable<FragmentPreCreatedEvent<Fragment>> getFragmentPreCreatedEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive) {
        return getAllEvents(fragmentManager, recursive)
                .filter(FragmentPreCreatedEvent.class::isInstance)
                .map(event -> (FragmentPreCreatedEvent<Fragment>) event);
    }

    // endregion

    // region onFragmentCreated

    public static <F extends Fragment> Observable<F> getOnFragmentCreated(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {
        return getFragmentCreatedEvents(fragmentManager, recursive, fragmentClass)
                .map(FragmentLifecycleEvent::getFragment);
    }

    public static <F extends Fragment> Observable<FragmentCreatedEvent<F>> getFragmentCreatedEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {

        //noinspection unchecked
        return getFragmentCreatedEvents(fragmentManager, recursive)
                .filter(event -> fragmentClass.isInstance(event.getFragment()))
                .map(event -> (FragmentCreatedEvent<F>) event);
    }

    public static Observable<FragmentCreatedEvent<Fragment>> getFragmentCreatedEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive) {
        return getAllEvents(fragmentManager, recursive)
                .filter(FragmentCreatedEvent.class::isInstance)
                .map(event -> (FragmentCreatedEvent<Fragment>) event);
    }

    // endregion

    // region onFragmentActivityCreated

    public static <F extends Fragment> Observable<F> getOnFragmentActivityCreated(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {
        return getFragmentActivityCreatedEvents(fragmentManager, recursive, fragmentClass)
                .map(FragmentLifecycleEvent::getFragment);
    }

    public static <F extends Fragment> Observable<FragmentActivityCreatedEvent<F>> getFragmentActivityCreatedEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {

        //noinspection unchecked
        return getFragmentActivityCreatedEvents(fragmentManager, recursive)
                .filter(event -> fragmentClass.isInstance(event.getFragment()))
                .map(event -> (FragmentActivityCreatedEvent<F>) event);
    }

    public static Observable<FragmentActivityCreatedEvent<Fragment>> getFragmentActivityCreatedEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive) {
        return getAllEvents(fragmentManager, recursive)
                .filter(FragmentActivityCreatedEvent.class::isInstance)
                .map(event -> (FragmentActivityCreatedEvent<Fragment>) event);
    }

    // endregion

    // region onFragmentViewCreated

    public static <F extends Fragment> Observable<F> getOnFragmentViewCreated(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {
        return getFragmentViewCreatedEvents(fragmentManager, recursive, fragmentClass)
                .map(FragmentLifecycleEvent::getFragment);
    }

    public static <F extends Fragment> Observable<FragmentViewCreatedEvent<F>> getFragmentViewCreatedEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {

        //noinspection unchecked
        return getFragmentViewCreatedEvents(fragmentManager, recursive)
                .filter(event -> fragmentClass.isInstance(event.getFragment()))
                .map(event -> (FragmentViewCreatedEvent<F>) event);
    }

    public static Observable<FragmentViewCreatedEvent<Fragment>> getFragmentViewCreatedEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive) {
        return getAllEvents(fragmentManager, recursive)
                .filter(FragmentViewCreatedEvent.class::isInstance)
                .map(event -> (FragmentViewCreatedEvent<Fragment>) event);
    }

    // endregion

    // region onFragmentStarted

    public static <F extends Fragment> Observable<F> getOnFragmentStarted(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {
        return getFragmentStartedEvents(fragmentManager, recursive, fragmentClass)
                .map(FragmentLifecycleEvent::getFragment);
    }

    public static <F extends Fragment> Observable<FragmentStartedEvent<F>> getFragmentStartedEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {

        //noinspection unchecked
        return getFragmentStartedEvents(fragmentManager, recursive)
                .filter(event -> fragmentClass.isInstance(event.getFragment()))
                .map(event -> (FragmentStartedEvent<F>) event);
    }

    public static Observable<FragmentStartedEvent<Fragment>> getFragmentStartedEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive) {
        return getAllEvents(fragmentManager, recursive)
                .filter(FragmentStartedEvent.class::isInstance)
                .map(event -> (FragmentStartedEvent<Fragment>) event);
    }

    // endregion

    // region onFragmentResumed

    public static <F extends Fragment> Observable<F> getOnFragmentResumed(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {
        return getFragmentResumedEvents(fragmentManager, recursive, fragmentClass)
                .map(FragmentLifecycleEvent::getFragment);
    }

    public static <F extends Fragment> Observable<FragmentResumedEvent<F>> getFragmentResumedEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {

        //noinspection unchecked
        return getFragmentResumedEvents(fragmentManager, recursive)
                .filter(event -> fragmentClass.isInstance(event.getFragment()))
                .map(event -> (FragmentResumedEvent<F>) event);
    }

    public static Observable<FragmentResumedEvent<Fragment>> getFragmentResumedEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive) {
        return getAllEvents(fragmentManager, recursive)
                .filter(FragmentResumedEvent.class::isInstance)
                .map(event -> (FragmentResumedEvent<Fragment>) event);
    }

    // endregion

    // region onFragmentPaused

    public static <F extends Fragment> Observable<F> getOnFragmentPaused(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {
        return getFragmentPausedEvents(fragmentManager, recursive, fragmentClass)
                .map(FragmentLifecycleEvent::getFragment);
    }

    public static <F extends Fragment> Observable<FragmentPausedEvent<F>> getFragmentPausedEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {

        //noinspection unchecked
        return getFragmentPausedEvents(fragmentManager, recursive)
                .filter(event -> fragmentClass.isInstance(event.getFragment()))
                .map(event -> (FragmentPausedEvent<F>) event);
    }

    public static Observable<FragmentPausedEvent<Fragment>> getFragmentPausedEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive) {
        return getAllEvents(fragmentManager, recursive)
                .filter(FragmentPausedEvent.class::isInstance)
                .map(event -> (FragmentPausedEvent<Fragment>) event);
    }

    // endregion

    // region onFragmentStopped

    public static <F extends Fragment> Observable<F> getOnFragmentStopped(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {

        return getFragmentStoppedEvents(fragmentManager, recursive, fragmentClass)
                .map(FragmentLifecycleEvent::getFragment);
    }

    public static <F extends Fragment> Observable<FragmentStoppedEvent<F>> getFragmentStoppedEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {

        //noinspection unchecked
        return getFragmentStoppedEvents(fragmentManager, recursive)
                .filter(event -> fragmentClass.isInstance(event.getFragment()))
                .map(event -> (FragmentStoppedEvent<F>) event);
    }

    public static Observable<FragmentStoppedEvent<Fragment>> getFragmentStoppedEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive) {

        return getAllEvents(fragmentManager, recursive)
                .filter(FragmentStoppedEvent.class::isInstance)
                .map(event -> (FragmentStoppedEvent<Fragment>) event);
    }

    // endregion

    // region onFragmentSaveInstanceState

    public static <F extends Fragment> Observable<F> getOnFragmentSaveInstanceState(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {

        return getFragmentSaveInstanceStateEvents(fragmentManager, recursive, fragmentClass)
                .map(FragmentLifecycleEvent::getFragment);
    }

    public static <F extends Fragment> Observable<FragmentSaveInstanceStateEvent<F>> getFragmentSaveInstanceStateEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {

        //noinspection unchecked
        return getFragmentSaveInstanceStateEvents(fragmentManager, recursive)
                .filter(event -> fragmentClass.isInstance(event.getFragment()))
                .map(event -> (FragmentSaveInstanceStateEvent<F>) event);
    }

    public static Observable<FragmentSaveInstanceStateEvent<Fragment>> getFragmentSaveInstanceStateEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive) {

        return getAllEvents(fragmentManager, recursive)
                .filter(FragmentSaveInstanceStateEvent.class::isInstance)
                .map(event -> (FragmentSaveInstanceStateEvent<Fragment>) event);
    }

    // endregion

    // region onFragmentViewDestroyed

    public static <F extends Fragment> Observable<F> getOnFragmentViewDestroyed(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {

        return getFragmentViewDestroyedEvents(fragmentManager, recursive, fragmentClass)
                .map(FragmentLifecycleEvent::getFragment);
    }

    public static <F extends Fragment> Observable<FragmentViewDestroyedEvent<F>> getFragmentViewDestroyedEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {

        //noinspection unchecked
        return getFragmentViewDestroyedEvents(fragmentManager, recursive)
                .filter(event -> fragmentClass.isInstance(event.getFragment()))
                .map(event -> (FragmentViewDestroyedEvent<F>) event);
    }

    public static Observable<FragmentViewDestroyedEvent<Fragment>> getFragmentViewDestroyedEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive) {

        return getAllEvents(fragmentManager, recursive)
                .filter(FragmentViewDestroyedEvent.class::isInstance)
                .map(event -> (FragmentViewDestroyedEvent<Fragment>) event);
    }

    // endregion

    // region onFragmentDestroyed

    public static <F extends Fragment> Observable<F> getOnFragmentDestroyed(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {

        return getFragmentDestroyedEvents(fragmentManager, recursive, fragmentClass)
                .map(FragmentLifecycleEvent::getFragment);
    }

    public static <F extends Fragment> Observable<FragmentDestroyedEvent<F>> getFragmentDestroyedEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {

        //noinspection unchecked
        return getFragmentDestroyedEvents(fragmentManager, recursive)
                .filter(event -> fragmentClass.isInstance(event.getFragment()))
                .map(event -> (FragmentDestroyedEvent<F>) event);
    }

    public static Observable<FragmentDestroyedEvent<Fragment>> getFragmentDestroyedEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive) {

        return getAllEvents(fragmentManager, recursive)
                .filter(FragmentDestroyedEvent.class::isInstance)
                .map(event -> (FragmentDestroyedEvent<Fragment>) event);
    }

    // endregion

    // region onFragmentDetached

    public static <F extends Fragment> Observable<F> getOnFragmentDetached(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {

        return getFragmentDetachedEvents(fragmentManager, recursive, fragmentClass)
                .map(FragmentLifecycleEvent::getFragment);
    }

    public static <F extends Fragment> Observable<FragmentDetachedEvent<F>> getFragmentDetachedEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive,
            @NonNull Class<F> fragmentClass) {

        //noinspection unchecked
        return getFragmentDetachedEvents(fragmentManager, recursive)
                .filter(event -> fragmentClass.isInstance(event.getFragment()))
                .map(event -> (FragmentDetachedEvent<F>) event);
    }

    public static Observable<FragmentDetachedEvent<Fragment>> getFragmentDetachedEvents(
            @NonNull FragmentManager fragmentManager,
            boolean recursive) {

        return getAllEvents(fragmentManager, recursive)
                .filter(FragmentDetachedEvent.class::isInstance)
                .map(event -> (FragmentDetachedEvent<Fragment>) event);
    }

    // endregion
}
