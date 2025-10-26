import java.time.LocalDateTime;
import java.util.UUID;

public class SmartDevice {
    private final String deviceId;
    private final LocalDateTime manufacturingDate;
    private final String serialNumber;

    private int hashedEncryptionKey;
    private int hashedAdminPassword;

    private String deviceName;
    private boolean isEnabled;

    private final LocalDateTime startupTime;

    public SmartDevice(String name) {
        this.deviceId = UUID.randomUUID().toString();
        this.manufacturingDate = LocalDateTime.now();
        this.serialNumber = "SN-" + System.currentTimeMillis();
        this.deviceName = name;
        this.isEnabled = true;
        this.startupTime = LocalDateTime.now();
    }

    // Read-only
    public String getDeviceId() {
        return deviceId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    // Write-only
    public void setEncryptionKey(String key) {
        hashedEncryptionKey = key.hashCode();
    }

    public void setAdminPassword(String password) {
        hashedAdminPassword = password.hashCode();
    }

    // Read-write
    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String name) {
        this.deviceName = name;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        this.isEnabled = enabled;
    }

    public static void main(String[] args) {
        SmartDevice device = new SmartDevice("Home Router");
        System.out.println("Device ID: " + device.getDeviceId());
        System.out.println("Serial Number: " + device.getSerialNumber());

        device.setEncryptionKey("secureKey123");
        device.setAdminPassword("adminPass!");

        System.out.println("Device Name: " + device.getDeviceName());
        device.setDeviceName("Smart Hub");
        System.out.println("Updated Device Name: " + device.getDeviceName());
    }
}
