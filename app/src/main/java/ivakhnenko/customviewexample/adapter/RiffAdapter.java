package ivakhnenko.customviewexample.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.bumptech.glide.Glide;

import java.util.List;

import ivakhnenko.customviewexample.databinding.RiffLayoutBinding;
import ivakhnenko.customviewexample.model.User;

/**
 * Created by Ruslan Ivakhnenko on 07.02.18.
 */

public class RiffAdapter extends ArrayAdapter<User> {

    private LayoutInflater inflater;

    public RiffAdapter(@NonNull Context context, int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        RiffLayoutBinding layoutBinding = RiffLayoutBinding.inflate(inflater, parent, false);
        User user = getItem(position);
        layoutBinding.setUser(user);
        Glide.with(getContext()).load(user.getUrl()).into(layoutBinding.imageView2);
        return layoutBinding.getRoot();
    }
}
