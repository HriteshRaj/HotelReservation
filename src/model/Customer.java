package model;

public class Customer {

    private String firstName;
    private String lastName;
    private String email;

    @Override
    public String toString() {
        return
                "customer "+
                        "\n first name = "+ firstName
                +"\n last name  = "+lastName +"\n email = "+email;
    }



    public Customer(String email){
        String formattedEmail = email.trim();

        if (!formattedEmail.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            throw new IllegalArgumentException("This Email Format is not Acceptable");
        }else{
            System.out.println("your email is " + formattedEmail);
        }

    }












}
