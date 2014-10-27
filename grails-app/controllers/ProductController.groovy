import grails.converters.JSON
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.MultipartHttpServletRequest

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

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

    @RequestMapping(value = "/storeimages.htm", method = RequestMethod.POST)
    public void storeimages(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            Set set = multipartRequest.getFileMap().entrySet();
            Iterator i = set.iterator();
            while(i.hasNext()) {
                Map.Entry me = (Map.Entry)i.next();
                String fileName = (String)me.getKey();
                MultipartFile multipartFile = (MultipartFile)me.getValue();
                writeToDisk(fileName, multipartFile);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void writeToDisk(String filename, MultipartFile multipartFile)
    {
        try
        {
            String fullFileName = "/Users/Nishant/IdeaProjects/images" + filename;
            FileOutputStream fos = new FileOutputStream(fullFileName);
            fos.write(multipartFile.getBytes());
            fos.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }





}
