package kh.edu.rupp.ite.iteonlineshop.Api.Model;

import com.google.gson.annotations.SerializedName;
public class Profile {
    private String first_name;
    private String last_name;
    private String email;
    @SerializedName("phone-number")

    private String phone_Number;
    private String gender;
    @SerializedName("image-url")

    private String imageUrl;
    private String birthday;
    private String address;
    public String getFirstName() {
        return first_name;
    }
    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }
    public String getLastName() {
        return last_name;
    }
    public void setLastName(String lastName) {
        this.last_name = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phone_Number;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phone_Number = phoneNumber;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}