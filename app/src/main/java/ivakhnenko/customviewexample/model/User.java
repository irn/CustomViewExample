package ivakhnenko.customviewexample.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ruslan Ivakhnenko on 07.02.18.
 */

@Entity
public class User implements Parcelable {

    @PrimaryKey
    private Integer id;

    private String name;

    private String address;

    private String url;

    @TypeConverters(User.class)
    private UserRole role;

    private Float rating;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.name);
        dest.writeString(this.address);
        dest.writeString(this.role.name());
        dest.writeValue(this.rating);
    }

    @TypeConverter
    public UserRole fromRoleId(int id){
        return UserRole.findById(id);
    }

    @TypeConverter
    public int toRole(UserRole userRole){
        return userRole != null ? userRole.id : 1;
    }

    public User() {
    }

    protected User(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.address = in.readString();
        this.role = UserRole.valueOf(in.readString());
        this.rating = in.readFloat();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
