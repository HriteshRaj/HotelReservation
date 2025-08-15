package model;

public class Customer {

    private final String firstName;
    private final String lastName;
    private final String email;

    public Customer(String email,String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
        emailChecking(email);
        this.email=email;

    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }



    public String getEmail() {
        return email;
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
