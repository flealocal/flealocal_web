import grails.converters.JSON

/**
 * Created by Nishant on 9/7/14.
 */
class DeviceController {

    def index(){
        def devices  = Device.findAll()
        withFormat {
            json {render(devices as JSON)}
        }
    }

    def save(){
        def jsonObject = request.JSON.getAt("params")
        Device device = new Device(jsonObject)
        device.save()
        withFormat {
            json {render(device as JSON)}
        }

    }

}
