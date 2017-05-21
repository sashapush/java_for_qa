package by.mmjava.addressbook.model;

public class ContactData {
    private int id=Integer.MAX_VALUE;
    private  String firstname;
    private  String middlename;
    private  String lastname;
    private  String nickname;
    private  String title;
    private  String companyName;
    private  String address1;
    private  String homeNumber;
    private  String mobileNumber;
    private  String workNumber;
    private  String fax;
    private  String email;
    private  String email2;
    private  String email3;
    private  String homepage;
    private  String address;
    private  String birthYear;
    private  String anniversaryYear;
    private  String group;
    private  String secondaryAddress;
    private  String secondaryPhone;
    private  String secondaryNotes;
    private  String allPhones;
    private  String allEmails;
    private String allContactData;

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
        this.address1 = address1; return this;
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

    public String getAddress1() {
        return address1;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

}