/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.io.Preferences;

/**
 *
 * @author aymen
 */
public class SessionManagerClient {

    public static Preferences pref; // 3ibara memoire sghira nsajlo fiha data 

    // hethom données ta3 user lyt7b tsajlhom fi session  ba3d login 
    private static int id;
    private static String userName;
    private static String email;
    private static String passowrd;
    private static String photo;
    private static int gsm;
    private static int id_role;

    public static Preferences getPref() {
        return pref;
    }

    public static void setPref(Preferences pref) {
        SessionManagerClient.pref = pref;
    }

    public static int getId() {
        return pref.get("id", id);// kif nheb njib id user connecté apres njibha men pref 
    }

    public static void setId(int id) {
        pref.set("id", id);//nsajl id user connecté  w na3tiha identifiant "id";
    }

    public static String getUserName() {
        return pref.get("username", userName);
    }

    public static void setUserName(String userName) {
        pref.set("username", userName);
    }

    public static String getEmail() {
        return pref.get("email", email);
    }

    public static void setEmail(String email) {
        pref.set("email", email);
    }

    public static String getPassowrd() {
        return pref.get("passowrd", passowrd);
    }

    public static void setPassowrd(String passowrd) {
        pref.set("passowrd", passowrd);
    }

    public static String getPhoto() {
        return pref.get("photo", photo);
    }

    public static void setPhoto(String photo) {
        pref.set("photo", photo);
    }

    public static void setGsm(int gsm) {
        pref.set("gsm", gsm);
    }

    public static int getGsm() {
        return pref.get("gsm", gsm);
    }

    public static void setIdRole(int id_role) {
        pref.set("id_role", id_role);
    }

    public static int getIdRole() {
        return pref.get("id_role", id_role);
    }

}
