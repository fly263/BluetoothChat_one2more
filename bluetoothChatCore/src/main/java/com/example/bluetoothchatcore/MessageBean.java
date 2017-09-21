package com.example.bluetoothchatcore;

/**
 * Created by lirongxiu on 2017/7/21.
 */

public class MessageBean {
    private String deviceAddress;
    private String deviceName;
    private String content;

    public String getDeviceAddress() {
        return deviceAddress;
    }

    public void setDeviceAddress(String deviceAddress) {
        this.deviceAddress = deviceAddress;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
