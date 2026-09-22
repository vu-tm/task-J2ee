/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.guides.springboot2.springpropertysourceexample;

/**
 *
 * @author Hi
 */

public class DataSourceConfig {
    private String driver;
    private String url;
    private String username;
    private String password;

    public void setDriver(String driver) { this.driver = driver; }
    public void setUrl(String url) { this.url = url; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "DataSourceConfig [driver=" + driver + ", url=" + url + ", username=" + username + "]";
    }
}
