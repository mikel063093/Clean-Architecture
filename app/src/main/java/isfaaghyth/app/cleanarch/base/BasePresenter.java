package isfaaghyth.app.cleanarch.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import isfaaghyth.app.cleanarch.network.Network;
import isfaaghyth.app.cleanarch.network.Routes;

/**
 * Created by isfaaghyth on 1/9/18.
 * github: @isfaaghyth
 */

public class BasePresenter<V> {

    protected V view;
    protected Routes service;
    private CompositeDisposable composite;

    protected void attachView(V view) {
        this.view = view;
        service = Network.builder().create(Routes.class);
    }

    protected void dettachView() {
        this.view = null;
        if (composite != null) {
            composite.clear();
        }
    }

    protected void subscribe(Disposable disposable) {
        if (composite == null) composite = new CompositeDisposable();
        composite.add(disposable);
    }

}
