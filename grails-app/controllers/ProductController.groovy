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
        withFormat {
            json {render(product as JSON)}
        }

    }


}
