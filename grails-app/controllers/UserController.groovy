import grails.converters.JSON

/**
 * Created by Nishant on 9/7/14.
 */
class UserController {

    def index(){
        def users  = User.findAll()
        withFormat {
            json {render(users as JSON)}
        }
    }

    def save(){
        def jsonObject = request.JSON
        User user = new User(jsonObject)
        user.save(failOnError: true)
        withFormat {
            json {render(user as JSON)}
        }

    }

}
