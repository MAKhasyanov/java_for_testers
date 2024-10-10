package model;

public record ContactData(
        String id,
        String firstname,
        String middlename,
        String lastname,
        String address,
        String photo,
        String home,
        String mobile,
        String work,
        String secondary,
        String email, String email2, String email3
) {

    public ContactData(){
        this("", "","",""," ", "src/test/resources/images/cat.jpeg","","","","","","","");
    }

    public ContactData withFirstName(String firstName) {
        return new ContactData(this.id, firstName,this.middlename,this.lastname,this.address, this.photo,this.home , this.mobile,this.work ,this.secondary, this.email, this.email2, this.email3);
    }
    public ContactData withMiddleName(String  middleName) {
        return new ContactData(this.id, this.firstname,middleName,this.lastname,this.address,this.photo,this.home , this.mobile,this.work ,this.secondary, this.email, this.email2, this.email3);
    }

    public ContactData withLastName(String lastName) {
        return new ContactData(this.id, this.firstname,this.middlename,lastName,this.address, this.photo,this.home , this.mobile,this.work ,this.secondary, this.email, this.email2, this.email3);

    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstname,this.middlename,this.lastname,address, this.photo,this.home , this.mobile,this.work ,this.secondary, this.email, this.email2, this.email3);

    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstname,this.middlename,this.lastname,this.address, this.photo,this.home , this.mobile,this.work ,this.secondary, this.email, this.email2, this.email3);

    }
    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstname,this.middlename,this.lastname,this.address, photo,this.home , this.mobile,this.work ,this.secondary, this.email, this.email2, this.email3);

    }

    public ContactData withHome(String home) {
        return new ContactData(this.id, this.firstname,this.middlename,this.lastname,this.address, this.photo,home , this.mobile,this.work ,this.secondary, this.email, this.email2, this.email3);

    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.firstname,this.middlename,this.lastname,this.address, this.photo,this.home , mobile,this.work ,this.secondary, this.email, this.email2, this.email3);

    }

    public ContactData withWork(String work) {
        return new ContactData(this.id, this.firstname,this.middlename,this.lastname,this.address, this.photo,this.home , this.mobile,work ,this.secondary, this.email, this.email2, this.email3);

    }

    public ContactData withSecondary(String secondary) {
        return new ContactData(this.id, this.firstname,this.middlename,this.lastname,this.address, this.photo,this.home , this.mobile,this.work ,secondary, this.email, this.email2, this.email3);

    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.firstname,this.middlename,this.lastname,this.address, this.photo,this.home , this.mobile,this.work ,this.secondary, email, this.email2, this.email3);

    }
    public ContactData withEmail2(String email2) {
        return new ContactData(this.id, this.firstname,this.middlename,this.lastname,this.address, this.photo,this.home , this.mobile,this.work ,this.secondary, this.email, email2, this.email3);

    }
    public ContactData withEmail3(String email3) {
        return new ContactData(this.id, this.firstname,this.middlename,this.lastname,this.address, this.photo,this.home , this.mobile,this.work ,this.secondary, this.email, this.email2, email3);

    }

}