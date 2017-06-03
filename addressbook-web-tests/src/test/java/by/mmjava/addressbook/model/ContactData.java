package by.mmjava.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
@Entity
@Table(name = "addressbook")
@XStreamAlias("Contact")
public class ContactData {
    @XStreamOmitField
    @Id
    @Column(name="id")
    private int id=Integer.MAX_VALUE;

    @Expose
    @Column(name="firstname")

    private  String firstname;
    @Expose
    @Column(name="middlename")
    private  String middlename;
    @Expose
    @Column(name="lastname")
    private  String lastname;
    private  String nickname;
    @Transient
    private  String title;
    @Column(name="company")
    private  String companyName;
    @Column(name="address2")
    @Type(type="text")
    private  String address2;
    @Column(name="home")
    @Type(type="text")
    private  String homeNumber;
    @Column(name="mobile")
    @Type(type="text")
    private  String mobileNumber;
    @Column(name="work")
    @Type(type="text")
    private  String workNumber;
    @Transient
    private  String fax;
    @Column(name="email")
    @Type(type="text")
    private  String email;
    @Transient
    private  String email2;
    @Transient
    private  String email3;
    @Transient
    private  String homepage;
    @Column(name="address")
    @Type(type="text")
    private  String address;
    @Column(name="byear")
    private  String birthYear;
    @Column(name="ayear")
    private  String anniversaryYear;
    @Expose
    @Transient
    transient private  String group;  //пропуск поля либо анотацией @Transient либо ключевым словом transient из мапинга данных таблицы в базе данных
    @Transient
    private  String secondaryAddress;
    @Transient
    private  String secondaryPhone;
    @Transient
    private  String secondaryNotes;
    @Transient
    private  String allPhones;
    @Transient
    private  String allEmails;
    @Transient
    private String allContactData;
    @Column(name="photo")
    @Type(type="text")
    private String photo;

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", lastname='" + lastname + '\'' +
                ", companyName='" + companyName + '\'' +
                ", address2='" + address2 + '\'' +
                ", homeNumber='" + homeNumber + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", workNumber='" + workNumber + '\'' +
                ", email='" + email + '\'' +
                ", email2='" + email2 + '\'' +
                ", email3='" + email3 + '\'' +
                ", address='" + address + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", anniversaryYear='" + anniversaryYear + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

    public File getPhoto() {
        if (photo !=  null) {
            return new File(photo);
        } else {
            return null;
        }
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    public String getAllContactData() {
        return allContactData;
    }

    public ContactData withAllContactData(String allProfileData) {
        this.allContactData = allProfileData;
        return this;
    }
    public String getAllEmails() {
        return allEmails;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }



    public ContactData  withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;return this;
    }

    public ContactData withMiddlename(String middlename) {
        this.middlename = middlename; return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withNickname(String nickname) {
        this.nickname = nickname; return this;
    }

    public ContactData withTitle(String title) {
        this.title = title; return this;
    }

    public ContactData withCompanyName(String companyName) {
        this.companyName = companyName; return this;
    }

    public ContactData withAddress1(String address1) {
        this.address2 = address1; return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        return address != null ? address.equals(that.address) : that.address == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    public ContactData withHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber; return this;
    }

    public ContactData withMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber; return this;
    }

    public ContactData withWorkNumber(String workNumber) {
        this.workNumber = workNumber; return this;
    }

    public ContactData withFax(String fax) {
        this.fax = fax; return this;
    }

    public ContactData withEmail(String email) {
        this.email = email; return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2; return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3; return this;
    }

    public ContactData withHomepage(String homepage) {
        this.homepage = homepage; return this;
    }

    public ContactData withAddress(String address) {
        this.address = address; return this;
    }

    public ContactData withBirthYear(String birthYear) {
        this.birthYear = birthYear; return this;
    }

    public ContactData withAnniversaryYear(String anniversaryYear) {
        this.anniversaryYear = anniversaryYear; return this;
    }



    public ContactData withGroup(String group) {

        this.group = group; return this;
    }

    public ContactData withSecondaryAddress(String secondaryAddress) {
        this.secondaryAddress = secondaryAddress; return this;
    }

    public ContactData withSecondaryPhone(String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;return this;
    }

    public ContactData withSecondaryNotes(String secondaryNotes) {
        this.secondaryNotes = secondaryNotes; return this;
    }

    public int getId() {
        return id;
    }



    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress2() {
        return address2;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getAnniversaryYear() {
        return anniversaryYear;
    }

    public String getSecondaryAddress() {
        return secondaryAddress;
    }

    public String getSecondaryPhone() {
        return secondaryPhone;
    }

    public String getSecondaryNotes() {
        return secondaryNotes;
    }

    public String getGroup() {
        if (group!=  null) {
            return group;
        } else {
            return "new";
        }
    }


    public void setId(int id) {
        this.id = id;
    }

}