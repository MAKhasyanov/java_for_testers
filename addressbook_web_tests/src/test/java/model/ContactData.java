package model;

public record ContactData(String firstname, String middlename, String lastname, String nickname, String mobile) {

    public ContactData(){
        this("","","","","");
    }

    public ContactData withFirstName(String firstName) {
        return new ContactData(firstName,this.middlename,this.lastname,this.nickname,this.mobile);
    }
    public ContactData withMiddleName(String  middleName) {
        return new ContactData(this.firstname,middleName,this.lastname,this.nickname,this.mobile);
    }
}