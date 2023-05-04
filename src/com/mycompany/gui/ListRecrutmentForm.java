/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.entites.Recrutment;
import com.mycompany.services.Service;
import java.util.ArrayList;

/**
 *
 * @author usoum
 */
public class ListRecrutmentForm extends Form {
    public ListRecrutmentForm(){
        super("",BoxLayout.y());
        Button ajouter = new Button("Ajouter Recrutment");
        ajouter.addActionListener(e->{
            AjouterRecrutmentForm a = new AjouterRecrutmentForm();
            a.show();
        });
        
        Button ret = new Button("<-- Retourner");
        ret.addActionListener(e->{
            menuForm menu = new menuForm();
            menu.show();
        });
        
        this.add(ret);
        this.add(ajouter);
        
        String h ="Campagne de Recrutment";
        TextArea t1 = new TextArea(h);
        this.add(t1);
        ArrayList<Recrutment> list = Service.getInstance().affichageReclamations();
        for(Recrutment r : list){
        addButton(r.getId(),r.getDescription(),r.getNbrposte(),r.getSalaire(),r.getTitre(),r.getType());
    }

}
    private void addButton(int id,String description,int nbrposte,float salaire,String titre, String type) {
         
        Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        TextArea t = new TextArea("Titre : "+titre+"\n"+"Description : "+description+"\n"+
               "Nombre De Poste : "+nbrposte+"\n"+"Salaire : "+salaire +"\n" + "Type : "+type);
      
       Button modifier = new Button("Modifier");
       modifier.addActionListener(e->{
           Recrutment r = new Recrutment(id, titre, description, nbrposte, salaire, type);
           new ModifierRecrutmentForm(r).show();
       });
       
       Button supprimer = new Button("Supprimer");
       supprimer.addPointerPressedListener(l -> {
            
            Dialog dig = new Dialog("Suppression");
            
            if(Dialog.show("Suppression","Vous voulez supprimer ce Recrutment ?","Annuler","Ok")) {
                dig.dispose();
            }
            else {
                dig.dispose();
                if(Service.getInstance().deleteRecrutment(id)) {
                    new ListRecrutmentForm().show();
                }
            }
           
        });
       
        Container cnt2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        cnt2.add(modifier);
        cnt2.add(supprimer);
        cnt.add(t);
        cnt.add(cnt2);
        add(cnt);
    }
    
}
