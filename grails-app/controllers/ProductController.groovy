import grails.converters.JSON

/**
 * Created by Nishant on 10/11/14.
 */
class ProductController {

    def index(){
        def products  = Product.findAll()
        withFormat {
            json {render(products as JSON)}
        }
    }

    def save(){
        def jsonObject = request.JSON.getAt("params")
        Product product = new Product(jsonObject)
        product.save(failOnError: true)
        def userProductObject  = request.JSON.getAt("user")
        print(userProductObject)
        if(userProductObject){
            def user = User.findById(userProductObject.getAt("UserId"))
            UserProduct.link(user, product, userProductObject.getAt("type"))
        }
        withFormat {
            json {render(product as JSON)}
        }
    }


}
