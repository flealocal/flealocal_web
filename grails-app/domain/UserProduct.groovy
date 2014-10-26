/**
 * Created by Nishant on 10/11/14.
 */
class UserProduct {

    User user
    Product product
    String type
    Date created = new Date()
    Date modified = new Date()

    static UserProduct link(User user, Product product, String type) {
        def up = UserProduct.findByUserAndProductAndType(user, product, type)
        if (!up)
        {
            up = new UserProduct()
            user?.addToUserProduct(up)
            product?.addToUserProduct(up)
            up.type = type
            up.save(failOnError: true)
        }
        return up
    }

    static constraints = {
        user nullable: false
        product nullable: false
        type nullable: false
        created nullable: false
        modified nullable : false
    }




}
