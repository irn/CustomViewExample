package ivakhnenko.customviewexample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.List;

import ivakhnenko.customviewexample.adapter.RiffAdapter;
import ivakhnenko.customviewexample.databinding.ActivityMainBinding;
import ivakhnenko.customviewexample.model.User;
import ivakhnenko.customviewexample.presenter.RiffListPresenter;
import ivakhnenko.customviewexample.presenter.RiffPresenterImpl;
import ivakhnenko.customviewexample.view.UsersListView;

public class MainActivity extends AppCompatActivity implements UsersListView {

    private RiffListPresenter presenter;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLastCustomNonConfigurationInstance() != null){
            presenter = (RiffListPresenter) getLastCustomNonConfigurationInstance();
        } else {
            presenter = new RiffPresenterImpl();
        }
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume(this);
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return presenter;
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void setUsers(List<User> users) {
        RiffAdapter adapter = new RiffAdapter(getBaseContext(), 0, users);
        binding.listView.setEmptyView(binding.emptyView);
        binding.listView.setAdapter(adapter);
    }

    @Override
    public void showWaiting() {
        binding.progressBar2.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideWaiting() {
        binding.progressBar2.setVisibility(View.GONE);
    }

    @Override
    public void onUserClick(User user) {

    }
}
