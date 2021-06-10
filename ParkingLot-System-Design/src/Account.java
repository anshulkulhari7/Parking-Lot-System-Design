public abstract class Account {
    private String userName;
    private String password;
    private AccountStatus status;
    private Person person;

    public boolean resetPassword(String password){

        if(this.password==password)return false;
        this.password=password;
        return true;
    }
}