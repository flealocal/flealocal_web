import grails.persistence.Entity

/**
 * Created by Nishant on 9/7/14.
 */
@Entity
class Device {

    String authToken
    String fleazarId
    String os
    String appVersionNumber
    String packageName
    String screenDensity
    String networkOperator
    String networkType
    String sdkVersion
    String macAddress
    String localeInfo
    String mobileCountryIso
    String deviceManufacturer
    String hardwareDeviceModel
    String deviceId
    String optOut
    String appVersionName
    User user
    Date created = new Date()
    Date modified = new Date()

    static hasOne = {user:user}


    static constraints = {

        authToken nullable: true
        fleazarId nullable: false
        os nullable: true
        appVersionName nullable: true
        appVersionNumber nullable: true
        packageName nullable: true
        screenDensity nullable: true
        networkOperator nullable: true
        networkType nullable: true
        sdkVersion nullable: true
        macAddress nullable: true
        localeInfo nullable: true
        mobileCountryIso nullable: true
        deviceManufacturer nullable: true
        hardwareDeviceModel nullable: true
        deviceId nullable: true
        optOut nullable: true
        created nullable: false
        modified nullable: false

    }


}
