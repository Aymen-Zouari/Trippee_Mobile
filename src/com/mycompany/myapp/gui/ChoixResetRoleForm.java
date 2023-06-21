/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Chauffeur;
import com.mycompany.myapp.entities.Client;
import com.mycompany.myapp.entities.Locateur;
import com.mycompany.myapp.services.ServiceChauffeur;
import com.mycompany.myapp.services.ServiceClient;
import com.mycompany.myapp.services.ServiceLocateur;

/**
 *
 * @author aymen
 */
public class ChoixResetRoleForm extends BaseForm {

    public ChoixResetRoleForm(Resources res, Form previous) {
        super(new BorderLayout());
        if (!Display.getInstance().isTablet()) {
            BorderLayout bl = (BorderLayout) getLayout();
            bl.defineLandscapeSwap(BorderLayout.NORTH, BorderLayout.EAST);
            bl.defineLandscapeSwap(BorderLayout.SOUTH, BorderLayout.CENTER);
        }
        setUIID("Activate");
        getTitleArea().setUIID("Container");
        // setUIID("SignIn");
        TextField gsm = new TextField("", "Gsm", 20, TextField.EMAILADDR);
        //Button btnValider = new Button("Valider");
        gsm.setSingleLineTextArea(false);
        gsm.setGrowByContent(true);

        ComboBox<String> libelle = new ComboBox<>("Customer", "Driver", "Landlord");
        // addComponent(BorderLayout.CENTER, libelle);
        Button btnValider = new Button("Validate");
        setUIID("Activate");
        Container content = BoxLayout.encloseY(
                new FloatingHint(gsm),
                createLineSeparator(),
                libelle,
                createLineSeparator(),
                btnValider
        );
        content.setScrollableY(true);
        add(BorderLayout.SOUTH, content);
        btnValider.requestFocus();
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                if (libelle.getSelectedItem().equals("Customer")) {
                    ServiceClient.getInstance().sms(gsm, res);
                    LoginForm loginForm = new LoginForm(previous, res);
                    loginForm.show();
                } else if (libelle.getSelectedItem().equals("Landlord")) {

                    ServiceLocateur.getInstance().sms(gsm, res);

                    LoginForm loginForm = new LoginForm(previous, res);
                    loginForm.show();
                } else if (libelle.getSelectedItem().equals("Driver")) {

                    ServiceChauffeur.getInstance().sms(gsm, res);

                    LoginForm loginForm = new LoginForm(previous, res);
                    loginForm.show();
                }

            }

        }
        );

    }
}
