import grails.persistence.Entity

/**
 * Created by Nishant on 10/11/14.
 */
@Entity
class Product {

    String name
    String imageLocation
    String category
    Long priceListed
    String productCondition
    String location
    Long zipcode
    String description
    String status
    Boolean archived
    Date created = new Date()
    Date modified = new Date()

    static hasMany = [userProduct:UserProduct]

    static constraints = {

        name nullable: false
        imageLocation nullable: true
        category nullable: false
        priceListed nullable: true
        productCondition nullable: false
        location nullable: true
        zipcode nullable: true
        description nullable: true
        status nullable: false
        archived nullable: false
        created nullable: false
        modified nullable: false

    }








}
