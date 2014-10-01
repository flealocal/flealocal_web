/**
 * Created by Nishant on 9/29/14.
 */
class User {

    String firstName
    String lastName
    String emailAddress
    String loginType
    String authToken
    String gender

    static constraints = {
        firstName nullable: true
        lastName nullable: true
        emailAddress nullable: false
        loginType nullable: true
        authToken nullable: false
        gender nullable: true
    }

}
