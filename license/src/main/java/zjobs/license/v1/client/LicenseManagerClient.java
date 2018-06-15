package zjobs.license.v1.client;


import de.schlichtherle.license.LicenseManager;
import de.schlichtherle.license.LicenseParam;
import zjobs.license.v1.base.licensemanager.BaseLicenseManager;

public class LicenseManagerClient {

    private static LicenseManager licenseManager;

    public static synchronized LicenseManager getLicenseManager(LicenseParam licenseParams) {
        if (licenseManager == null) {
            licenseManager = new BaseLicenseManager(licenseParams);
        }
        return licenseManager;
    }
}
