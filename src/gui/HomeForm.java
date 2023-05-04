package gui;

import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.Resources;
import entities.Competence;

public class HomeForm extends Form {

    public HomeForm(){
    
    Button competenceBtn = new Button("Competences");
    Button posteBtn = new Button("Fiches des postes");
        Button statBtn = new Button("Statiscs");

    Toolbar tb = this.getToolbar();
    Container topBar = BorderLayout.east(new Label("Menu"));
    topBar.add(BorderLayout.SOUTH, new Label("Cool App Tagline...", "SidemenuTagline")); 
    topBar.setUIID("SideCommand");
    tb.addComponentToSideMenu(topBar);

    tb.addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, e -> {}); 
    tb.addMaterialCommandToSideMenu("Website", FontImage.MATERIAL_WEB, e -> {});
    tb.addMaterialCommandToSideMenu("Settings", FontImage.MATERIAL_SETTINGS, e -> {});
    tb.addMaterialCommandToSideMenu("About", FontImage.MATERIAL_INFO, e -> {});



        // add action to the button
        competenceBtn.addActionListener((evt) -> {
            new ListCompetenceForm().show();
        });
        posteBtn.addActionListener((evt) -> {
            new ListPosteForm().show();
        }); 
        statBtn.addActionListener((evt) -> {
            new StatsForm().show();
        }); 
        this.addAll(competenceBtn,posteBtn);
    }
}
