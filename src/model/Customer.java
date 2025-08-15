package model;

public class Customer {

    private String firstName;
    private String lastName;
    private String email;

    public Customer(String email,String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;

        this.email=email;
        emailChecking(email);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return
                "customer "+
                        "\n first name = "+ firstName
                +"\n last name  = "+lastName +"\n email = "+email;
    }



    public boolean emailChecking(String email){
        String formattedEmail = email.trim();

        if (!formattedEmail.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            throw new IllegalArgumentException("This Email Format is not Acceptable");
        }else{
            System.out.println("your email is " + formattedEmail);
        }
        return true;

    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Customer customer = (Customer) obj;

        return this.email.equals(customer.email);
    }

    @Override
    public int hashCode() {

        return email.hashCode();
    }












}
