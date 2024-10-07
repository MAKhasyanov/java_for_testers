package ru.stqa.mantis.model;

public record DeveloperMailUser(String name,String email,String password,String token) {
    public DeveloperMailUser(){
        this("", "", "", "");
    }
    public DeveloperMailUser withName (String name){return new DeveloperMailUser(name,this.email,this.password,this.token);}
    public DeveloperMailUser withEmail (String email){return new DeveloperMailUser(this.name,email,this.password,this.token);}
    public DeveloperMailUser withPassword (String password){return new DeveloperMailUser(this.name,this.email,password,this.token);}
    public DeveloperMailUser withToken (String token){return new DeveloperMailUser(this.name,this.email,this.password,token);}

}
