package model;

public record ContactData(String id, String firstname, String middlename, String lastname, String nickname, String mobile) {

    public ContactData(){
        this("", "","","","","");
    }

    public ContactData withFirstName(String firstName) {
        return new ContactData(this.id, firstName,this.middlename,this.lastname,this.nickname,this.mobile);
    }
    public ContactData withMiddleName(String  middleName) {
        return new ContactData(this.id, this.firstname,middleName,this.lastname,this.nickname,this.mobile);
    }

    public ContactData withLastName(String lastName) {
        return new ContactData(this.id, this.firstname,this.middlename,lastName,this.nickname,this.mobile);

    }

    public ContactData withNickname(String nickname) {
        return new ContactData(this.id, this.firstname,this.middlename,this.lastname,nickname,this.mobile);

    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.firstname,this.middlename,this.lastname,this.nickname,mobile);

    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstname,this.middlename,this.lastname,this.nickname,this.mobile);

    }
}