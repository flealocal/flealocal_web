import grails.persistence.Entity

/**
 * Created by Nishant on 9/29/14.
 */
@Entity
class User {

    String firstName
    String lastName
    String emailAddress
    String loginType
    String authToken
    String gender
    Date created = new Date()
    Date modified = new Date()

    static hasMany = [userProduct:UserProduct]


    static constraints = {
        firstName nullable: true
        lastName nullable: true
        emailAddress nullable: false, unique: true
        loginType nullable: true
        authToken nullable: false, unique: true
        gender nullable: true
        created nullable: false
        modified nullable: false

    }

}
