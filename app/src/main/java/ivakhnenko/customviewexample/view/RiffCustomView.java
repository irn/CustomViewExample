package ivakhnenko.customviewexample.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.databinding.DataBindingUtil;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import ivakhnenko.customviewexample.R;
import ivakhnenko.customviewexample.databinding.RiffLayoutBinding;
import ivakhnenko.customviewexample.model.User;

/**
 * Created by Ruslan Ivakhnenko on 07.02.18.
 */

public class RiffCustomView extends ConstraintLayout {

    private User user;

    private RiffLayoutBinding binding;

    public RiffCustomView(Context context) {
        super(context);

        initialize(context, null);
    }

    public RiffCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initialize(context, attrs);
    }

    public RiffCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context, attrs);
    }

    private void initialize(Context context, AttributeSet attrs){
        user = new User();

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.riff_layout, this, true);

        if (attrs != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.RiffCustomView,
                    0, 0);

            try {
                String name = typedArray.getString(R.styleable.RiffCustomView_riffName);
                setName(name);
            } catch (RuntimeException ex){
                ex.printStackTrace();
            }
            typedArray.recycle();

        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        binding.setUser(user);
    }

    public void setName(String name){
        user.setName(name);
        binding.setUser(user);
    }
}
