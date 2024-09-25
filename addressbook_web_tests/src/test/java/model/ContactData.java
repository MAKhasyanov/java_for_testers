package model;

public record ContactData(String id, String firstname, String middlename, String lastname, String address, String mobile,String photo) {

    public ContactData(){
        this("", "","","","","","src/test/resources/images/cat.jpeg");
    }

    public ContactData withFirstName(String firstName) {
        return new ContactData(this.id, firstName,this.middlename,this.lastname,this.address,this.mobile,this.photo);
    }
    public ContactData withMiddleName(String  middleName) {
        return new ContactData(this.id, this.firstname,middleName,this.lastname,this.address,this.mobile,this.photo);
    }

    public ContactData withLastName(String lastName) {
        return new ContactData(this.id, this.firstname,this.middlename,lastName,this.address,this.mobile,this.photo);

    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstname,this.middlename,this.lastname,address,this.mobile,this.photo);

    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.firstname,this.middlename,this.lastname,this.address,mobile,this.photo);

    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstname,this.middlename,this.lastname,this.address,this.mobile,this.photo);

    }
    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstname,this.middlename,this.lastname,this.address,this.mobile,photo);

    }
}