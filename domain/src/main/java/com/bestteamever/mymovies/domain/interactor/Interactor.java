package com.bestteamever.mymovies.domain.interactor;

import com.bestteamever.mymovies.domain.executor.PostExecutionThread;
import com.bestteamever.mymovies.domain.executor.ThreadExecutor;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

public abstract class Interactor {

    private final PostExecutionThread postExecutionThread;
    private Subscription subscription = Subscriptions.empty();
    private ThreadExecutor threadExecutor;

    protected Interactor(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    /**
     * Executes the current use case.
     *
     * @param useCaseSubscriber The guy who will be listen to the observable build with {@link
     * #buildUseCaseObservable()}.
     */
    @SuppressWarnings ("unchecked")
    public void execute(Subscriber useCaseSubscriber) {
        this.subscription = this.buildUseCaseObservable()
                                .subscribeOn(Schedulers.from(threadExecutor))
                                .observeOn(postExecutionThread.getScheduler())
                                .subscribe(useCaseSubscriber);
    }

    protected abstract Observable buildUseCaseObservable();

    /**
     * Unsubscribes from current {@link rx.Subscription}.
     */
    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
