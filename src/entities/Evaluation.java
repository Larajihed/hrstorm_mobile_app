/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author conta
 */
public class Evaluation {
    
private Integer id;

private Date date;

private String commentaire;

//private User employee;

private Integer experience;

private String level;


private Collection<Competence> competences;


private Poste poste;

public Evaluation() {
    competences = new ArrayList<>();
}

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}



public String getCommentaire() {
    return commentaire;
}

public void setCommentaire(String commentaire) {
    this.commentaire = commentaire;
}


public Integer getExperience() {
    return experience;
}

public void setExperience(Integer experience) {
    this.experience = experience;
}

public String getLevel() {
    return level;
}

public void setLevel(String level) {
    this.level = level;
}

public Collection<Competence> getCompetences() {
    return competences;
}

public void setCompetences(Collection<Competence> competences) {
    this.competences = competences;
}

public Poste getPoste() {
    return poste;
}

public void setPoste(Poste poste) {
    this.poste = poste;
}



}
