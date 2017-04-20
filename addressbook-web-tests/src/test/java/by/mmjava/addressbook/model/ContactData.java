package by.mmjava.addressbook.model;

public class ContactData {
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
    private final String secondaryAddress;
    private final String secondaryPhone;
    private final String secondaryNotes;

    public ContactData(String firstname, String middlename, String lastname, String nickname, String title, String companyName, String address1, String homeNumber, String mobileNumber, String workNumber, String fax, String email, String email2, String email3, String homepage, String address, String birthYear, String anniversaryYear, String secondaryAddress, String secondaryPhone, String secondaryNotes) {
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
}
