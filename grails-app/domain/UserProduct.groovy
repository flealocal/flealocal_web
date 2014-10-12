/**
 * Created by Nishant on 10/11/14.
 */
class UserProduct {

    User user
    Product product
    String type
    Date created = new Date()
    Date modified = new Date()

    static constraints = {
        user nullable: false
        product nullable: false
        type nullable: false
        created nullable: false
        modified nullable : false
    }




}
