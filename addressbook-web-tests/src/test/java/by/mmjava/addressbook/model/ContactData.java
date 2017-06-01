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
    @Transient
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
    @Transient
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
    @Transient
    private  String birthYear;
    @Transient
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

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", lastname='" + lastname + '\'' +
                ", nickname='" + nickname + '\'' +
                ", title='" + title + '\'' +
                ", companyName='" + companyName + '\'' +
                ", address2='" + address2 + '\'' +
                ", homeNumber='" + homeNumber + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", workNumber='" + workNumber + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                ", email2='" + email2 + '\'' +
                ", email3='" + email3 + '\'' +
                ", homepage='" + homepage + '\'' +
                ", address='" + address + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", anniversaryYear='" + anniversaryYear + '\'' +
                ", group='" + group + '\'' +
                ", secondaryAddress='" + secondaryAddress + '\'' +
                ", secondaryPhone='" + secondaryPhone + '\'' +
                ", secondaryNotes='" + secondaryNotes + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

    @Column(name="photo")
    @Type(type="text")
    private String photo;

    public File getPhoto() {
        return new File(photo);}

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (middlename != null ? !middlename.equals(that.middlename) : that.middlename != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (address2 != null ? !address2.equals(that.address2) : that.address2 != null) return false;
        if (homeNumber != null ? !homeNumber.equals(that.homeNumber) : that.homeNumber != null) return false;
        if (mobileNumber != null ? !mobileNumber.equals(that.mobileNumber) : that.mobileNumber != null) return false;
        if (workNumber != null ? !workNumber.equals(that.workNumber) : that.workNumber != null) return false;
        if (fax != null ? !fax.equals(that.fax) : that.fax != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
        if (email3 != null ? !email3.equals(that.email3) : that.email3 != null) return false;
        if (homepage != null ? !homepage.equals(that.homepage) : that.homepage != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (birthYear != null ? !birthYear.equals(that.birthYear) : that.birthYear != null) return false;
        if (anniversaryYear != null ? !anniversaryYear.equals(that.anniversaryYear) : that.anniversaryYear != null)
            return false;
        if (group != null ? !group.equals(that.group) : that.group != null) return false;
        if (secondaryAddress != null ? !secondaryAddress.equals(that.secondaryAddress) : that.secondaryAddress != null)
            return false;
        if (secondaryPhone != null ? !secondaryPhone.equals(that.secondaryPhone) : that.secondaryPhone != null)
            return false;
        return secondaryNotes != null ? secondaryNotes.equals(that.secondaryNotes) : that.secondaryNotes == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (middlename != null ? middlename.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (address2 != null ? address2.hashCode() : 0);
        result = 31 * result + (homeNumber != null ? homeNumber.hashCode() : 0);
        result = 31 * result + (mobileNumber != null ? mobileNumber.hashCode() : 0);
        result = 31 * result + (workNumber != null ? workNumber.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (email2 != null ? email2.hashCode() : 0);
        result = 31 * result + (email3 != null ? email3.hashCode() : 0);
        result = 31 * result + (homepage != null ? homepage.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (birthYear != null ? birthYear.hashCode() : 0);
        result = 31 * result + (anniversaryYear != null ? anniversaryYear.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (secondaryAddress != null ? secondaryAddress.hashCode() : 0);
        result = 31 * result + (secondaryPhone != null ? secondaryPhone.hashCode() : 0);
        result = 31 * result + (secondaryNotes != null ? secondaryNotes.hashCode() : 0);
        return result;
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
        return group;
    }


    public void setId(int id) {
        this.id = id;
    }

}