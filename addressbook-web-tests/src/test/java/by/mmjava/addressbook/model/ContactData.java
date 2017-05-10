package by.mmjava.addressbook.model;

public class ContactData {
    private int id;
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String title;
    private final String companyName;
    private final String address1;
    private final String homeNumber;
    private final String mobileNumber;
    private final String workNumber;
    private final String fax;
    private final String email;
    private final String email2;
    private final String email3;
    private final String homepage;
    private final String address;
    private final String birthYear;
    private final String anniversaryYear;
    private final String group;
    private final String secondaryAddress;
    private final String secondaryPhone;
    private final String secondaryNotes;


    public int getId() {
        return id;
    }


    public ContactData(int id, String firstname, String middlename, String lastname, String nickname, String title, String companyName, String address1, String homeNumber, String mobileNumber, String workNumber, String fax, String email, String email2, String email3, String homepage, String address, String birthYear, String anniversaryYear, String group, String secondaryAddress, String secondaryPhone, String secondaryNotes) {

        this.id=id;

        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.title = title;
        this.companyName = companyName;
        this.address1 = address1;
        this.homeNumber = homeNumber;
        this.mobileNumber = mobileNumber;
        this.workNumber = workNumber;
        this.fax = fax;
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
        this.homepage = homepage;
        this.address = address;
        this.birthYear = birthYear;
        this.anniversaryYear = anniversaryYear;
        this.group = group;
        this.secondaryAddress = secondaryAddress;
        this.secondaryPhone = secondaryPhone;
        this.secondaryNotes = secondaryNotes;
    }
    public ContactData(String firstname, String middlename, String lastname, String nickname, String title, String companyName, String address1, String homeNumber, String mobileNumber, String workNumber, String fax, String email, String email2, String email3, String homepage, String address, String birthYear, String anniversaryYear, String group, String secondaryAddress, String secondaryPhone, String secondaryNotes) {
        this.id=0;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.title = title;
        this.companyName = companyName;
        this.address1 = address1;
        this.homeNumber = homeNumber;
        this.mobileNumber = mobileNumber;
        this.workNumber = workNumber;
        this.fax = fax;
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
        this.homepage = homepage;
        this.address = address;
        this.birthYear = birthYear;
        this.anniversaryYear = anniversaryYear;
        this.group = group;
        this.secondaryAddress = secondaryAddress;
        this.secondaryPhone = secondaryPhone;
        this.secondaryNotes = secondaryNotes;
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

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
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

}